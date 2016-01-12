package moneycalculator;

import control.ExchangeCommand;
import persistence.MockExchangeRateReader;
import ui.MockCurrencyDialog;
import ui.MockMoneyDialog;
import ui.MockMoneyDisplay;

public class Application {

    public static void main(String[] args) {
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                new MockMoneyDialog(),
                new MockCurrencyDialog(),
                new MockExchangeRateReader(), 
                new MockMoneyDisplay()
        );
        exchangeCommand.execute();
                
    }
    
}
