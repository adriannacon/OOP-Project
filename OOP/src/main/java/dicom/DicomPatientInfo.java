package dicom;

public class DicomPatientInfo extends DicomInfo {
    // instance variables
    private String studyName;
    private String patientName;
    private String patientID; //used instead of int in case its alphanumerical

    // Constructor
    public DicomPatientInfo(String studyName) {
        super(studyName); //sets instance var to the local var
    }

    // Patient Name
    // setter
    public void setPatientName(String patientName) {
        this.patientName = patientName; 
    }

    // getter
    public String getPatientName() {
        return patientName;
    }

    // Patient ID
    // setter
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    // getter
    public String getPatientID() {
        return patientID;
    }

    //OVERRIDE METHOD
    @Override
    public String toString() {
        return super.toString()
                + "Patient Name: " + getPatientName() + "\n"
                + "Patient ID: " + getPatientID() + "\n";
    }
}