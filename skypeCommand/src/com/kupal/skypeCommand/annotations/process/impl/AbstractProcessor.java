package com.kupal.skypeCommand.annotations.process.impl;

import com.kupal.skypeCommand.annotations.process.Processor;
import com.kupal.skypeCommand.annotations.process.AnnotationProcessorException;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public abstract class AbstractProcessor<T> implements Processor<T> {

    protected void setValueToField(Field field, T object, String value, String paramName) throws AnnotationProcessorException {
        Class<?> type = field.getType();
        try {
            if(type.equals(Integer.class) || type.getName().equals("int")) {
                field.setInt(object, Integer.parseInt(value));
            } else if(type.equals(Boolean.class) || type.getName().equals("boolean")) {
                field.setBoolean(object, Boolean.parseBoolean(value));
            } else if(type.equals(Byte.class) || type.getName().equals("byte")) {
                field.setByte(object, Byte.parseByte(value));
            } else if(type.equals(Character.class) || type.getName().equals("char")) {
                if(value.length() > 1) {
                    throw new NumberFormatException();
                }
                field.setChar(object, value.charAt(0));
            } else if(type.equals(Double.class) || type.getName().equals("double")) {
                field.setDouble(object, Double.parseDouble(value));
            } else if(type.equals(Float.class) || type.getName().equals("float")) {
                field.setFloat(object, Float.parseFloat(value));
            } else if(type.equals(Long.class) || type.getName().equals("long")) {
                field.setLong(object, Long.parseLong(value));
            } else if(type.equals(Short.class) || type.getName().equals("short")) {
                field.setShort(object, Short.parseShort(value));
            } else if(type.equals(String.class)) {
                field.set(object, value);
            } else {
                throw new AnnotationProcessorException("type " + type.getSimpleName() + " not supported for parameter value. Contact command vendor");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            throw new AnnotationProcessorException("value of <" + paramName + "> is incorrect. Expected type: " + type.getSimpleName());
        }
    }
}
