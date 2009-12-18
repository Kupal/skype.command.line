package com.kupal.skypeCommand.annotations.process;

import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.process.impl.RequestProcessor;
import com.kupal.skypeCommand.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kupal 3kb
 */
public class ProcessorHolder {

    private static Map<Class<? extends Annotation>, Class<? extends Processor>> registeredProcessors = new HashMap<Class<? extends Annotation>, Class<? extends Processor>>();

    static {
        registerProcessor(Request.class, RequestProcessor.class);
    }

    public static Processor getProcessor(Class<? extends Annotation> annotationClass) {
        return ClassUtil.getInstance(registeredProcessors.get(annotationClass));
    }

    public static void registerProcessor(Class<? extends Annotation> annotationClass, Class<? extends Processor> processorClass) {
        registeredProcessors.put(annotationClass, processorClass);
    }
}
