package lecture04;

public class Excercise4_2 {
    public static void main(String[] args) {

        ATM atm = new ATM();

        String name = "古川理貴";
        String number = "2212070";

        atm.existsAccount(name, number);
        atm.registerAccount(name, number);
        atm.existsAccount(name, number);
        atm.deposit(number, 1000);
        atm.withdraw(number, 2000);
        atm.withdraw(number, 500);
    }
}
