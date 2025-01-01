package software.ulpgc.kata7.io.currency;

import com.google.gson.Gson;
import software.ulpgc.kata7.io.APIFileDeserializer;
import software.ulpgc.kata7.io.pojos.FixerCurrencyGetResponse;

public class FixerCurrencyDeserializer implements APIFileDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, FixerCurrencyGetResponse.class);
    }
}
