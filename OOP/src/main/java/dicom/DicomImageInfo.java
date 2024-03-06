package dicom;

/**
 * This section was created with the help of the website
 * https://www.saravanansubramanian.com/blog/extractdicomimagedata/ 
 */

public class DicomImageInfo extends DicomInfo {
    // instance variables
    private String transferSyntax;
    private String sopClass;
    private String modality;
    private String photometricInterpretation;
    private String pixelSpacing;
    private int numOfFrames;
    private int width;
    private int height;
    private boolean isGrayscale; //american spelling bc that is what pixelMed uses :(
    private boolean pixelDataPresent;

    // Constructor
    public DicomImageInfo(String studyName) {
        super(studyName);
    }

    // Transfer Syntax
    public void setTransferSyntax(String transferSyntax) {
        this.transferSyntax = transferSyntax;
    }

    public String getTransferSyntax() {
        return transferSyntax;
    }

    // SOP Class
    public void setSopClass(String sopClass) {
        this.sopClass = sopClass;
    }

    public String getSopClass() {
        return sopClass;
    }

    // Modality
    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getModality() {
        return modality;
    }

    // Photometric Interpretation
    public void setPhotometricInterpretation(String photometricInterpretation) {
        this.photometricInterpretation = photometricInterpretation;
    }

    public String getPhotometricInterpretation() {
        return photometricInterpretation;
    }

    // Pixel Spacing
    public void setPixelSpacing(String pixelSpacing) {
        this.pixelSpacing = pixelSpacing;
    }

    public String getPixelSpacing() {
        return pixelSpacing;
    }

    // Number of Frames
    public void setNumberOfFrames(int numOfFrames) {
        this.numOfFrames = numOfFrames;
    }

    public int getNumberOfFrames() {
        return numOfFrames;
    }

    // Width
    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    // Height
    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    // Grayscale
    public void setGrayscale(boolean isGrayscale){
        this.isGrayscale = isGrayscale;
    }

    public boolean getGrayscale() {
        return isGrayscale;
    }

    // Pixel Data
    public void setPixelData(boolean pixelDataPresent){
        this.pixelDataPresent = pixelDataPresent;
    }

    public boolean getPixelData() {
        return pixelDataPresent;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Transfer Syntax: " + getTransferSyntax() + "\n"
                + "SOP Class: " + getSopClass() + "\n"
                + "Modality: " + getModality() + "\n"
                + "Photometric Interpretation: " + getPhotometricInterpretation() + "\n"
                + "Pixel Spacing: " + getPixelSpacing() + "\n"
                + "Number of frames: " + getNumberOfFrames() + "\n"
                + "Width: " + getWidth() + "\n"
                + "Height: " + getHeight() + "\n"
                + "Is Grayscale?: " + getGrayscale() + "\n"
                + "Pixel Data present: " + getPixelData();
    }
}
