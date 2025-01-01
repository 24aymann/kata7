package software.ulpgc.kata7.io.currency;

import software.ulpgc.kata7.io.APIFileDeserializer;
import software.ulpgc.kata7.io.APIFileReader;
import software.ulpgc.kata7.model.Currency;

import java.util.List;

public record CurrencyLoader(
        APIFileReader reader,
        CurrencyAdapter adapter,
        APIFileDeserializer deserializer
) {

    public List<Currency> load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
