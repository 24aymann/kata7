package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.Money;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amountField;
    private final CurrencyDialog currencyDialog;
    private final static Font font = new Font(Font.MONOSPACED, Font.PLAIN | Font.BOLD, 14);

    public SwingMoneyDialog(CurrencyDialog currencyDialog) throws HeadlessException {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.currencyDialog = currencyDialog;
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(createAmountField());
        add((Component) currencyDialog.define(currencies));
        return this;
    }

    private Component createAmountField() {
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel("Amount: ");
        jLabel.setFont(font);
        panel.add(jLabel);

        JTextField field = new JTextField();
        field.setColumns(5);
        field.setFont(font);
        this.amountField = field;
        panel.add(field);

        return panel;
    }

    @Override
    public Money get() {
        return new Money(toLong(amountField.getText()), currencyDialog.get());
    }

    private long toLong(String text) {
        return Long.parseLong(text);
    }
}
