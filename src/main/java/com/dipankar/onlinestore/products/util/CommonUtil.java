package com.dipankar.onlinestore.products.util;

import com.dipankar.onlinestore.products.util.exception.NoDataFoudException;

import java.util.Optional;

public class CommonUtil {

    public static <T> T handleOptional(Optional<T> obj) throws NoDataFoudException {
        if (obj.isPresent()) {
            return obj.get();
        }
        throw new NoDataFoudException("No data found for the given condition. " +
                "Please check the condition and try again.");
    }
}
