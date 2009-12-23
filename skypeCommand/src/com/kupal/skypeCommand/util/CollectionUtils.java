package com.kupal.skypeCommand.util;

import java.util.Collection;

/**
 * @author Kupal 3kb
 */
public class CollectionUtils {

    /**
     * Check if collection is null or empty
     *
     * @param collection to check
     * @return true if collection is null or empty, false otherwise
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Check if collection is not null ant not empty
     *
     * @param collection to check
     * @return true if collection is not null and not empty, false otherwise
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
