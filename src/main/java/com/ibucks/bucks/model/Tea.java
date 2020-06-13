package com.ibucks.bucks.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibucks.bucks.deserialize.MoneyDeserializer;
import lombok.Data;
import org.joda.money.Money;

import java.io.Serializable;

@Data
public class Tea implements Serializable {


    private static final long serialVersionUID = 7351957918746131123L;
    @JsonDeserialize(using = MoneyDeserializer.class)
    private Money price;
}
