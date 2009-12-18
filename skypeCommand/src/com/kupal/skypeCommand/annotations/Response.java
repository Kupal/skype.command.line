package com.kupal.skypeCommand.annotations;

import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.response.impl.CommonCommandResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kupal 3kb
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Response {

    Class<? extends CommandResponse> responseClass() default CommonCommandResponse.class;
}
