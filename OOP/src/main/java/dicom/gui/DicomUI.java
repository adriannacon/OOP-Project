package dicom.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dicom.DicomImageInfo;
import dicom.DicomPatientInfo;
import dicom.DicomReader;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * This section was created with the help of the YouTube video
 * https://www.youtube.com/watch?v=5o3fMLPY7qY&ab_channel=AlexLee
 */
public class DicomUI extends JFrame {
    // instance variables
    private JTextArea textArea;
    private String filePath;
    private DicomReader dicomReader = new DicomReader();
    
    // Constructor
    public DicomUI() {
        super("DICOM Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setupUI();
    }

    private void setupUI() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton loadButton = new JButton("Load DICOM File");
        loadButton.addActionListener(e -> loadDICOMFile());

        JButton patientInfoButton = new JButton("Show Patient Info");
        patientInfoButton.addActionListener(e -> showPatientInfo());

        JButton imageInfoButton = new JButton("Show Image Info");
        imageInfoButton.addActionListener(e -> showImageInfo());

        buttonPanel.add(loadButton);
        buttonPanel.add(patientInfoButton);
        buttonPanel.add(imageInfoButton);

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadDICOMFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            // You might want to store the filePath in an instance variable for use in other methods
            this.filePath = filePath;
            JOptionPane.showMessageDialog(this, "File loaded successfully :)\n Choose an action :)",
                                                 "File Loaded", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showImageInfo() {
        if (filePath == null || filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please load a DICOM file first :)",
                                                "No File Loaded :(", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            DicomImageInfo imageInfo = dicomReader.readImageDicom(filePath);
            if (imageInfo != null) {
                textArea.setText(imageInfo.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to extract image info :(",
                                                    "Error :(", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading DICOM file: " + ex.getMessage(), 
                                                "Error :(", JOptionPane.ERROR_MESSAGE);
        }
    }    

    private void showPatientInfo() {
        if (filePath == null || filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please load a DICOM file first :)", 
                                            "No File Loaded :(", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            DicomPatientInfo patientInfo = dicomReader.readPatientDicom(filePath);
            if (patientInfo != null) {
                textArea.setText(patientInfo.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to extract patient info :(",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading DICOM file: " + ex.getMessage(), 
                                                "Error :(", JOptionPane.ERROR_MESSAGE);
        }
    }
}

