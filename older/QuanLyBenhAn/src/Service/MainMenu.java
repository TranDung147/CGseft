package Service;

import Service.MedicalRecordService;


public class MainMenu extends MenuIF {
    private MedicalRecordService medicalRecordService;

    public MainMenu(String title, String[] choices) {
        super(title, choices);
        this.medicalRecordService = new MedicalRecordService();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                medicalRecordService.addNewMedicalRecord();
                break;
            case 2:
                medicalRecordService.deleteMedicalRecord();
                break;
            case 3:
                medicalRecordService.viewMedicalRecords();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}