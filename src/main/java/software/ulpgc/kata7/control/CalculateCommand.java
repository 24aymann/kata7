package software.ulpgc.kata7.control;

import software.ulpgc.kata7.io.exchangerate.ExchangeRateLoader;
import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.ExchangeRate;
import software.ulpgc.kata7.model.Money;
import software.ulpgc.kata7.view.CurrencyDialog;
import software.ulpgc.kata7.view.MoneyDialog;
import software.ulpgc.kata7.view.MoneyDisplay;


public class CalculateCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Currency currency = currencyDialog.get();
        Money money = moneyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money operationResult = new Money(money.amount() * exchangeRate.rate(), currency);
        moneyDisplay.display(operationResult);
    }
}
