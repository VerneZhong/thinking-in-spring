package org.zxb.thinking.in.spring.ioc.overview.domain;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;
import org.zxb.thinking.in.spring.ioc.overview.enums.City;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * 用户 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:23
 */
public class User implements BeanNameAware {

    private Long id;
    private String name;
    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Resource configFileLocation;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    /**
     * 静态方法构建对象
     * @return
     */
    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Chivalry");
        user.setCity(City.BEIJING);
        return user;
    }

    /**
     * 静态方法构建对象
     * @return
     */
    public static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Chivalry" + id);
        user.setCity(City.BEIJING);
        return user;
    }

    @PostConstruct
    public void init() {
        System.out.println("用户 Bean ["+ beanName +"] 初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("用户 Bean [" + beanName + "] 销毁...");
    }

    public void setBeanName(String name) {
        this.beanName = name;
    }
}
