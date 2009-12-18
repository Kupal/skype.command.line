package com.kupal.skypeCommand.annotations;

import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.request.impl.CommonCommandRequest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kupal 3kb
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Request {

    Class<? extends CommandRequest> requestClass() default CommonCommandRequest.class;
}
