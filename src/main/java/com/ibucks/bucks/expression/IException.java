package com.ibucks.bucks.expression;
/**
* @Description:   自定义全局项目异常类
* @Author:         shang
* @CreateDate:     2020/3/26 16:36
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 16:36
* @UpdateRemark:
* @Version:        1.0
*/
public class IException extends Exception{

    public IException(){}
    public IException(String message){
        super(message);
    }
    public IException(String message,Throwable cause){
        super(message,cause);
    }

    public IException(String title,String message){
        super(message);
    }
}
