package dicom;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;

import java.io.IOException;

public class DicomReader {

    /**
     * Reads a DICOM file and extracts patient information.
     * 
     * @param filePath the path to the DICOM file
     * @return a DicomPatientInfo object populated with patient data from the DICOM file; null if any error occurs
     */
    public DicomPatientInfo readPatientDicom(String filePath) {
        try {
            final AttributeList list = new AttributeList();
            list.read(filePath);

            final String studyName = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.StudyDescription);
            DicomPatientInfo patientInfo = new DicomPatientInfo(studyName);

            String patientName = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.PatientName);
            patientInfo.setPatientName(patientName);
            String patientID = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.PatientID);
            patientInfo.setPatientID(patientID);

            return patientInfo;

        } catch (IOException | DicomException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads a DICOM file and extracts image information.
     * Part of this code was written using the reference: 
     * https://www.saravanansubramanian.com/blog/extractdicomimagedata/
     * 
     * @param filePath the path to the DICOM file
     * @return a DicomImageInfo object populated with image data from the DICOM file; null if any error occurs
     */
    public DicomImageInfo readImageDicom(String filePath) {
        try {
            final AttributeList list = new AttributeList();
            list.read(filePath);

            final String studyName = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.StudyDescription);
            DicomImageInfo imageInfo = new DicomImageInfo(studyName);

            String transferSyntax = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.TransferSyntaxUID);
            imageInfo.setTransferSyntax(transferSyntax);
            String sopClass = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.SOPClassUID);
            imageInfo.setSopClass(sopClass);
            String modality = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.Modality);
            imageInfo.setModality(modality);
            //125 charcters in the below line
            String photometricInt = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.PhotometricInterpretation);
            imageInfo.setPhotometricInterpretation(photometricInt);
            String pixelSpacing = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.PixelSpacing);
            imageInfo.setPixelSpacing(pixelSpacing);

            SourceImage img = new SourceImage(list);
            imageInfo.setNumberOfFrames(img.getNumberOfFrames());
            imageInfo.setWidth(img.getWidth());
            imageInfo.setHeight(img.getHeight());
            imageInfo.setGrayscale(img.isGrayscale());
            imageInfo.setPixelData(list.get(TagFromName.PixelData) != null);

            return imageInfo;

        } catch (IOException | DicomException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Helper method to safely get the value of a DICOM attribute as a String
     * 
     * @param list the AttributeList from the DICOM file
     * @param tag the AttributeTag to look up
     * @return the attribute value as a String, or an empty string if not found or an error occurs
     */
    private String getAttributeValue(AttributeList list, AttributeTag tag) {
        try {
            Attribute attribute = list.get(tag);
            return attribute.getSingleStringValueOrNull();
        } catch (Exception e) {
            System.err.println("Error accessing attribute value: " + e.getMessage());
            return "";
        }
    }
}

