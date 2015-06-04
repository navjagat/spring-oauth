package com.practice.acl.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.practice.acl.entiry.Client;
/**
 * Return the currently logged in {@link Client} information
 * 
 * @author navneet.prabhakar
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActiveClient {

}
