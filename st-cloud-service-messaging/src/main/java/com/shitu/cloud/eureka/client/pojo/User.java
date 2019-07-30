package com.shitu.cloud.eureka.client.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author andrew
 * @date 2019/07/23
 */
@Data
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1190418445460063931L;

    private Long id;
    private String name;
    private Integer age;
    private String sex;
    @ToString.Exclude
    private String desc;

    public static void main(String[] args) {
        User john = User.builder().id(10L).name("John").build();
        john.setSex("male").setAge(20);
        System.out.println(john);
    }
}
