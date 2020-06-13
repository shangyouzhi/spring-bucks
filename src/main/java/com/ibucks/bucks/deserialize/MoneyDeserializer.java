package com.ibucks.bucks.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.math.BigDecimal;

/**
* @Description:   Money 实体反序列化器
* @Author:         shang
* @CreateDate:     2020/5/28 10:13
* @UpdateUser:     shang
* @UpdateDate:     2020/5/28 10:13
* @UpdateRemark:
* @Version:        1.0
*/
@JsonComponent
public class MoneyDeserializer extends JsonObjectDeserializer<Money> {


    @Override
    protected Money deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        JsonNode amountNode =  tree.get("amount");
        JsonNode currencyUnitNode = tree.get("currencyUnit");
        JsonNode codeNode = currencyUnitNode.get("code");
        BigDecimal amount = amountNode.decimalValue();
        return  Money.of(CurrencyUnit.of(codeNode.asText()),amount);

    }
}
