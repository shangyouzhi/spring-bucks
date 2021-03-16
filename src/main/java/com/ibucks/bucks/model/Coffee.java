package com.ibucks.bucks.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibucks.bucks.deserialize.MoneyDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: coffee文件实体
 * @Author: shang
 * @CreateDate: 2020/3/26 14:31
 * @UpdateUser: shang
 * @UpdateDate: 2020/3/26 14:31
 * @UpdateRemark:
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@Builder
public class Coffee implements Serializable {

    private static final long serialVersionUID = 4681831164202404395L;
    @Id
    private String id;
    private String name;
    @JsonDeserialize(using = MoneyDeserializer.class)
    private Money price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
