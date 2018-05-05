
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marloncs
 */
public class Person {
    private String code;
    private String name;
    private Date birthDay;
    
    public Person(){
        
    }

    public Person(String code, String name, Date birthDay) {
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    
    
    
    
}
