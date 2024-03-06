package dicom;

import javax.swing.SwingUtilities;
import dicom.gui.DicomUI;


public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DicomUI viewer = new DicomUI();
            viewer.setVisible(true);
        });
    }
}

