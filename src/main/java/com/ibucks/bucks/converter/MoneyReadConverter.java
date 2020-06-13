package com.ibucks.bucks.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
* @Description:   money converter
* @Author:         shang
* @CreateDate:     2020/3/26 14:36
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 14:36
* @UpdateRemark:
* @Version:        1.0
*/
public class MoneyReadConverter  implements Converter<Document, Money> {

    @Override
    public Money convert(Document document) {
        Document money = (Document)document.get("money");
        double amount = Double.valueOf(money.getString("amount"));
        String currency = ((Document)money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency),amount);
    }
}
