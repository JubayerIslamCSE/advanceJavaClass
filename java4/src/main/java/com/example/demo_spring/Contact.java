package com.example.demo_spring;

import lombok.*;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String name;
    private String email;
    private String message;
}
