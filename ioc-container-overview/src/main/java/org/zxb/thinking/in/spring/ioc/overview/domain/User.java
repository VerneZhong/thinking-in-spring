package org.zxb.thinking.in.spring.ioc.overview.domain;

/**
 * 用户 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:23
 */
public class User {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
        return user;
    }
}
