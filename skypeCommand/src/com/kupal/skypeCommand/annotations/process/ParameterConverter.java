package com.kupal.skypeCommand.annotations.process;

/**
 * Interface with define convert process of incoming parameter value to specified Object
 *
 * @param <T> generic type of converting entity
 */
public interface ParameterConverter<T> {

    /**
     * Convert incoming parameter to specified object
     *  
     * @param value parameter value
     * @return specified object
     */
    T convert(String value);
}
