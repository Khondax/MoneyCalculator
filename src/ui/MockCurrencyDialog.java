package ui;

import model.Currency;

public class MockCurrencyDialog implements CurrencyDialog {

    @Override
    public Currency get() {
        return new Currency("EUR", "Euro", "€");
    }

}
