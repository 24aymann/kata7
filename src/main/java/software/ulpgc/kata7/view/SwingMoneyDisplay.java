package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Money;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void display(Money money) {
        String formattedMoney = String.format("%.4f", money.amount());
        this.setText("Result = " + formattedMoney + " " + money.currency().code());
    }
}
