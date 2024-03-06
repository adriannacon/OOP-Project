package dicom;

// Parent Class!!
public class DicomInfo {
    // instance variable
    private String studyName;

    // Constructor
    public DicomInfo(String studyName) {
        this.studyName = studyName;
    }

    // Setter
    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    // Getter
    public String getStudyName() {
        return studyName;
    }

    @Override
    public String toString() {
        return "DICOM Information\n"+ "Study Name: " + getStudyName() + "\n";
    }
}