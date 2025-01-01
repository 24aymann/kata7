package software.ulpgc.kata7.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class FixerAPIFileReader implements APIFileReader {
    private final String url;

    public FixerAPIFileReader(String url) {
        this.url = url;
    }

    @Override
    public String read() {
        try {
            return read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String apiFileURL) throws IOException {
        Connection.Response response = Jsoup.connect(apiFileURL)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Fatal Issue.");
        return response.body();
    }
}
