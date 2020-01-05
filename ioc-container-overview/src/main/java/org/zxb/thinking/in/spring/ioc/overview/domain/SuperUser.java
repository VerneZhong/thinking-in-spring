package org.zxb.thinking.in.spring.ioc.overview.domain;

import org.zxb.thinking.in.spring.ioc.overview.annotaion.Super;

/**
 * 超级用户 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:54
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
