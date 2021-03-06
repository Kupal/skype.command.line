package com.kupal.skypeCommand.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kupal 3kb
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {

    String name();

    /**
     * If set to true, only authorized user can call this command
     *  
     * @return boolean
     */
    boolean authorizedOnly() default false;
}
