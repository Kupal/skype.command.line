package com.kupal.skypeCommand.annotations.process;

/**
 * @author Kupal 3kb
 */
public interface Processor<T> {

    T process(T t) throws AnnotationProcessorException;
}
