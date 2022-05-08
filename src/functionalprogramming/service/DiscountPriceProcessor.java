package functionalprogramming.service;

import functionalprogramming.model.Price;

public class DiscountPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice()+ ", then applied discount");
    }

}
