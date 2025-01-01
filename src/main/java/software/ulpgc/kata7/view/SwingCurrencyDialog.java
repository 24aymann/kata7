package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog{
    private JComboBox<Currency> currencySelector;
    private final String label;
    private final static Font font = new Font(Font.MONOSPACED, Font.PLAIN | Font.BOLD, 14);

    public SwingCurrencyDialog(String label) {
        this.setLayout(new GridLayout(1, 2, 10, 10));
        this.label = label;
    }

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        add(createCurrencySelector(currencies, label));
        return this;
    }

    private Component createCurrencySelector(List<Currency> currencies, String label) {
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(font);
        panel.add(jLabel);

        JComboBox<Currency> comboBoxSelector = new JComboBox<>();
        comboBoxSelector.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        for (Currency currency : currencies)
            comboBoxSelector.addItem(currency);
        this.currencySelector = comboBoxSelector;
        panel.add(comboBoxSelector);

        return panel;
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }
}
