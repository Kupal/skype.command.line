package com.kupal.skypeCommand.annotations.process;

import com.kupal.skypeCommand.exception.AnnotationProcessorException;
import com.kupal.skypeCommand.exception.ParameterValueValidationException;

/**
 * @author Kupal 3kb
 */
public interface Processor<T> {

    T process(T t) throws AnnotationProcessorException, ParameterValueValidationException;
}
