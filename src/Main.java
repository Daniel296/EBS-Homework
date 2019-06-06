import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static final int MAX_MESSAGES = 100;
    private static final int EQUAL_WEIGHT = 90;
    private static final int NAME_FIELD_WEIGHT = 10;

    public static void main(String[] args) {

        List<Subscription> subscriptions = new ArrayList<>();
        List<Publication> publications = new ArrayList<>();

        for(int i = 0; i < MAX_MESSAGES; i++) {
            String patientName = Generator.getRandomName();
            Date dateOfBirth = Generator.getRandomDate();
            double height = Generator.getRandomHeight();
            String eyeColor = Generator.getRandomEyeColor();
            int heartRate = Generator.getRandomHeartRate();

            publications.add(new Publication(patientName, dateOfBirth, height, eyeColor, heartRate));
        }

        double patientNameFieldWeight = ((double) NAME_FIELD_WEIGHT / 100) * MAX_MESSAGES;
        double equalSubscriptionField = ((double) EQUAL_WEIGHT / 100) * (100-patientNameFieldWeight);
        System.out.println("Nu au nume "+patientNameFieldWeight+" subscriptii");
        System.out.println("Nr. minim operator \"=\": "+equalSubscriptionField);
        for(int i = 0, j=0; i < MAX_MESSAGES; i++) {
            String patientName;
            int patientNameOperator = 0;
            if(i < patientNameFieldWeight) {
                patientName = null;
            } else {
                patientName = Generator.getRandomName();
            }

            if(patientName != null)
                if(j < equalSubscriptionField) {
                    j++;
                    patientNameOperator = Operators.EQUAL;
                } else {
                    patientNameOperator = Generator.getRandomNameOperator();
                }

            Date dateOfBirth = Generator.getRandomDate();
            int heartRate = Generator.getRandomHeartRate();
            int dateOfBirthOperator = Generator.getRandomOperator();
            int heartRateOperator = Generator.getRandomOperator();

            subscriptions.add(new Subscription(patientName, patientNameOperator, heartRate, heartRateOperator, dateOfBirth, dateOfBirthOperator));
        }

        writeToFile(publications, "publications.txt");
        writeToFile(subscriptions, "subscriptions.txt");
    }

    private static void writeToFile(List items, String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            for (Object item: items) {
                bufferedOutputStream.write((item.toString() + "\n").getBytes());
            }

            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
