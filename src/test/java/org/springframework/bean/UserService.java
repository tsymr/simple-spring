package org.springframework.bean;

/**
 * UserService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:22 AM
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
