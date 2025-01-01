package software.ulpgc.kata7.io.exchangerate;

import com.google.gson.Gson;
import software.ulpgc.kata7.io.APIFileDeserializer;
import software.ulpgc.kata7.io.pojos.FixerExchangeRateGetResponse;

public class FixerExchangeRateDeserializer implements APIFileDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, FixerExchangeRateGetResponse.class);
    }
}
