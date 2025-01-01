package software.ulpgc.kata7.io.currency;

import software.ulpgc.kata7.model.Currency;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object object);
}
