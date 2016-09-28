package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Favio Gonzalez on 9/26/2016.
 */
@Component
public class GreetingsService {

    public String getMessage(){
        return "breakbot!";
    }

    private String aName;

    public String getaName() {
        return aName;
    }

    @Value("${generics.name}")
    public void setaName(String aName) {
        this.aName = aName;
    }

    private String aMsg;

    public String getaMsg() {
        return aMsg;
    }

    @Profile("development")
    @Value("${a_msg}")
    public void setaMsg1(String aMsg) {
        this.aMsg = aMsg;
    }
    @Profile("production")
    @Value("${a_msg}")
    public void setaMsg2(String aMsg) {
        this.aMsg = aMsg;
    }
}
