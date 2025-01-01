package software.ulpgc.kata7;

import software.ulpgc.kata7.control.Command;
import software.ulpgc.kata7.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public MainFrame() throws HeadlessException {
        this.setTitle("Money Calculator");
        this.setSize(1000,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        this.setTitle();
        this.add(createDialogs());
        this.add(createButton());
        this.add(createMoneyDisplay());
    }

    private void setTitle() {
        JLabel title = new JLabel("Currency Conversion", JLabel.CENTER);
        title.setFont(new Font("New Font", Font.BOLD | Font.ITALIC, 45));
        this.add(title);
    }

    private JPanel createButton() {
        JButton calculateButton = new JButton("Calculate");

        JPanel panel = new JPanel();
        panel.add(calculateButton);
        calculateButton.addActionListener(e -> commands.get("Calculate").execute());

        return panel;
    }

    private Component createMoneyDisplay() {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        display.setFont(new Font("New Font", Font.BOLD,18));
        this.moneyDisplay = display;
        jPanel.add(display);
        return jPanel;
    }

    private Component createDialogs() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        SwingCurrencyDialog fromCurrencyDialog = new SwingCurrencyDialog("From: ");
        SwingMoneyDialog moneyDialog = new SwingMoneyDialog(fromCurrencyDialog);
        this.moneyDialog = moneyDialog;
        panel.add(moneyDialog);

        SwingCurrencyDialog toCurrencyDialog = new SwingCurrencyDialog("To: ");
        this.currencyDialog = toCurrencyDialog;
        panel.add(toCurrencyDialog);

        return panel;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public void put(String commandName, Command command) {
        commands.put(commandName, command);
    }
}