package lecture04;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<Account> accountList;

    public ATM() {
        this.accountList = new ArrayList<>();
    }

    public void registerAccount(String name, String number) {
        Account account = new Account(name, number);
        accountList.add(account);
        System.out.println(name + " さんのアカウントを口座番号:" + number + " で登録しました。");
    }

    public boolean existsAccount(String name, String number) {
        for (Account account : accountList) {
            if (account.getName().equals(name) && account.getNumber().equals(number)) {
                System.out.println("名前:" + name + " 口座番号:" + number + " は存在します。");
                return true;
            }
        }
        System.out.println("名前:" + name + " 口座番号:" + number + " は存在しません。");
        return false;
    }

    public void deposit(String number, long money) {
        for (Account account : accountList) {
            if (account.getNumber().equals(number)) {
                account.setBalance(account.getBalance() + money);
                System.out.println("口座番号:" + number + " に " + money + " 円入金しました。");
                return;
            }
        }
        System.out.println("口座番号:" + number + " は存在しません。");
    }
    public long withdraw(String number, long money) {
        for (Account account : accountList) {
            if (account.getNumber().equals(number)) {
                if (account.getBalance() >= money) {
                    account.setBalance(account.getBalance() - money);
                    System.out.print("口座番号:" + number + " から " + money + " 円引き出しました。");
                    System.out.println("残高:" + account.getBalance() + "円です。");
                    return money;
                } else {
                    System.out.print("口座番号:" + number + " から " + money + " 円引き出せませんでした。");
                    System.out.println("残高:" + account.getBalance() + "円です。");
                    return 0;
                }
            }
        }
        System.out.println("口座番号:" + number + " は存在しません。");
        return 0;
    }


}