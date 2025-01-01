package software.ulpgc.kata7.io.exchangerate;

import software.ulpgc.kata7.io.APIFileDeserializer;
import software.ulpgc.kata7.io.APIFileReader;
import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.ExchangeRate;

public record ExchangeRateLoader(
        APIFileReader reader,
        ExchangeRateAdapter adapter,
        APIFileDeserializer deserializer
) {
    public ExchangeRate load(Currency from, Currency to) {
        return adapter.adapt(deserializer.deserialize(reader.read()), from, to);
    }
}
