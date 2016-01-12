package control;

import java.util.concurrent.Exchanger;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import persistence.ExchangeRateReader;
import process.MoneyExchanger;
import ui.CurrencyDialog;
import ui.MoneyDialog;
import ui.MoneyDisplay;

public class ExchangeCommand implements Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateReader exchangeRateReader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateReader exchangeRateReader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateReader = exchangeRateReader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        ExchangeRate exchangeRate = exchangeRateReader.get(money.getCurrency(), currencyDialog.get());
        moneyDisplay.show(new MoneyExchanger().exchange(money, exchangeRate));
    }

}
