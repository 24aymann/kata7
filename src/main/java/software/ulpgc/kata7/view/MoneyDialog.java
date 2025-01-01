package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
