public class User {
    private String userId;
    private String pin;
    private Integer bankBalance = 1000;

    public User(String userId, String pin) {
        this.userId = (userId != null) ? userId : "";
        this.pin = (pin != null) ? pin : "";
    }

    public String getUserId() {
        return userId;
    }


    public String getPin() {
        return pin;
    }

    public Integer getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance() {
        this.bankBalance = 1000;
    }
}
