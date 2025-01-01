package software.ulpgc.kata7.io.exchangerate;

import software.ulpgc.kata7.io.pojos.FixerExchangeRateGetResponse;
import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateAdapter implements ExchangeRateAdapter {
    @Override
    public ExchangeRate adapt(Object object, Currency from, Currency to) {
        FixerExchangeRateGetResponse response = (FixerExchangeRateGetResponse) object;
        return adapt(response.rates(), from, to);
    }

    private ExchangeRate adapt(Map<String, Double> rates, Currency from, Currency to) {
        double rate = calculateRate(from, to, rates);
        return new ExchangeRate(
                from, to, rate, LocalDate.now()
        );
    }

    private double calculateRate(Currency from, Currency to, Map<String, Double> rates) {
        return from.code().equals("EUR") ? getRateBetweenFromAndBaseCurrency(to, rates)
                : to.code().equals("EUR") ? getRateBetweenToAndBaseCurrency(from, rates)
                : getRateBetweenFromAndBaseCurrency(to, rates) * getRateBetweenToAndBaseCurrency(from, rates);
    }

    private double getRateBetweenFromAndBaseCurrency(Currency to, Map<String, Double> rates) {
        return rates.get(to.code());
    }

    private double getRateBetweenToAndBaseCurrency(Currency from, Map<String, Double> rates) {
        return 1 / rates.get(from.code());
    }
}
