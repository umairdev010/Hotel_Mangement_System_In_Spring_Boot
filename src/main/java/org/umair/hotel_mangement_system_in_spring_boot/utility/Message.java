package org.umair.hotel_mangement_system_in_spring_boot.utility;

public class Message {

    private String massage;
    private boolean success;

    public Message(String massage, boolean success) {
        this.massage = massage;
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Message{" +
                "massage='" + massage + '\'' +
                ", success=" + success +
                '}';
    }
}
