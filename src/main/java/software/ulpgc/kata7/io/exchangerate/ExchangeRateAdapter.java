package software.ulpgc.kata7.io.exchangerate;

import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.ExchangeRate;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object, Currency from, Currency to);
}
