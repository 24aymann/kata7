package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
