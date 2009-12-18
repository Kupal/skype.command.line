package com.kupal.skypeCommand.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public class AnnotationUtil {

    public static <T extends Annotation> T getAnnotation(Class<T> annotationClass, Class clazz, boolean recursively) {
        T t = (T)clazz.getAnnotation(annotationClass);

        if(t == null && recursively)
            t = getAnnotation(annotationClass, clazz.getSuperclass(), recursively);

        return t;
    }

    public static boolean isTransient(Field field) {
        return field.isAnnotationPresent(Transient.class);
    }
}
