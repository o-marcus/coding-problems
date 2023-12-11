package br.com.coding.P17_GUBEE_CHALLENGE.annotation;


import java.lang.annotation.*;// Version.java
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {

}
