package com.ibucks.bucks.indicator;

import com.ibucks.bucks.sevice.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
/**
* @Description:   咖啡数量检测器
* @Author:         shang
* @CreateDate:     2021/3/16 17:07
* @UpdateUser:     shang
* @UpdateDate:     2021/3/16 17:07
* @UpdateRemark:
* @Version:        1.0
*/
@Component
public class CoffeeCountIndicator implements HealthIndicator {
    @Autowired
    private CoffeeService coffeeService;
    @Override
    public Health health() {
        Long count = coffeeService.countCoffee();
        if(null == count || count <=0){
            return Health.down()
                    .withDetail("count",count)
                    .withDetail("message","we are out of coffee").build();
        }
        return Health.up()
                .withDetail("count",count)
                .withDetail("message","we have enough coffee").build();
    }
}
