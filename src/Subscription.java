import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscription {
    private String patientName;
    private int patientNameOperator;
    private int heartRate;
    private int heartRateOperator;
    private Date dateOfBirth;
    private int dateOfBirdOperator;

    public Subscription(String patientName, int patientNameOperator, int heartRate, int heartRateOperator, Date dateOfBirth, int dateOfBirdOperator) {
        this.patientName = patientName;
        this.patientNameOperator = patientNameOperator;
        this.heartRate = heartRate;
        this.heartRateOperator = heartRateOperator;
        this.dateOfBirth = dateOfBirth;
        this.dateOfBirdOperator = dateOfBirdOperator;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPatientNameOperator() {
        return patientNameOperator;
    }

    public void setPatientNameOperator(int patientNameOperator) {
        this.patientNameOperator = patientNameOperator;
    }

    public int getHeartRateOperator() {
        return heartRateOperator;
    }

    public void setHeartRateOperator(int heartRateOperator) {
        this.heartRateOperator = heartRateOperator;
    }

    public int getDateOfBirdOperator() {
        return dateOfBirdOperator;
    }

    public void setDateOfBirdOperator(int dateOfBirdOperator) {
        this.dateOfBirdOperator = dateOfBirdOperator;
    }

    @Override
    public String toString() {
        if(patientName == null) {
            return "{" +
                "(heartRate," + getOperatorString(heartRateOperator) + ",'" + heartRate +
                ");(dateOfBirth," + getOperatorString(dateOfBirdOperator) + "," +new SimpleDateFormat("dd.MM.yyyy").format(dateOfBirth) +
                ")}";
        }

        return "{" +
            "(patientName," + getOperatorString(patientNameOperator) + ",'" + patientName + '\'' +
            ");(heartRate," + getOperatorString(heartRateOperator) + ",'" + heartRate +
            ");(dateOfBirth," + getOperatorString(dateOfBirdOperator) + "," +new SimpleDateFormat("dd.MM.yyyy").format(dateOfBirth) +
            ")}";
    }

    private String getOperatorString(int operator) {
        switch (operator) {
            case 0: return "=";
            case 1: return "!=";
            case 2: return ">";
            case 3: return "<";
            case 4: return ">=";
            case 5: return "<=";
        }
        return null;
    }
}
