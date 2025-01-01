package software.ulpgc.kata7.model;

import java.time.LocalDate;

public record ExchangeRate (
        Currency from,
        Currency to,
        double rate,
        LocalDate date
) {}
