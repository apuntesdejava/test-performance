package com.apuntesdejava.test.performance;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author diego
 */
public class Utils {

    public static boolean isValidListIf(List<?> list) {
        if (list != null) {
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isValidListInline(List<?> list) {
        return list != null && !list.isEmpty();
    }

    public static boolean isValidListOptional(List<?> list) {
        return Optional.ofNullable(list).map((l) -> !l.isEmpty()).orElse(Boolean.FALSE);
    }

    public static boolean isValidStringIf(String str) {
        if (str != null) {
            if (str.trim().length() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isValidStringInLine(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValidStringOption(String str) {
        return Optional.ofNullable(str).map(s -> !s.trim().isEmpty()).orElse(Boolean.FALSE);
    }
}
