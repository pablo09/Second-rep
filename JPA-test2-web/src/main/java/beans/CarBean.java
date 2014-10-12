/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import jpa.example.Car;
import jpa.example.CarFacade;
import jpa.interceptors.Login;
import jpa.interceptors.LoginInterceptor;

/**
 *
 * @author Pawel
 */
@Named

public class CarBean {
    @EJB
    private CarFacade carFacade;
    
    private String name;
    private String date;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    private List<Car> cars;
    private int length;
    public List<Car> getCars() {
        return cars;
    }
    public void setCars (List<Car> cars) {
        this.cars = cars;
    }
    @PostConstruct
    public void init() {
        cars = carFacade.findAll();
        length = cars.size();
    }
    public String addCar() {
        Car car = new Car();
        car.setName(name);
        car.setDate(date);
        car.setColor(color);
        car.setCarId(length);
        
        carFacade.create(car);
        return "cars.xhtml?faces-redirect=true";
    }
    @Login
    public String someMethod() {
        System.out.println("METHOD");
        return "";
    }
    
}
