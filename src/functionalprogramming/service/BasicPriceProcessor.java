package functionalprogramming.service;

import functionalprogramming.model.Price;

public class BasicPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return price;
    }

}
