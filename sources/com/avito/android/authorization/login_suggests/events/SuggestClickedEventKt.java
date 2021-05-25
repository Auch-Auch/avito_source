package com.avito.android.authorization.login_suggests.events;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"authorization_release"}, k = 2, mv = {1, 4, 2})
public final class SuggestClickedEventKt {
    public static final long access$convertToEventId(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3260) {
                if (hashCode != 3305) {
                    if (hashCode != 3548) {
                        if (hashCode != 3765) {
                            if (hashCode == 93029210 && str.equals("apple")) {
                                return 8;
                            }
                        } else if (str.equals("vk")) {
                            return 1;
                        }
                    } else if (str.equals("ok")) {
                        return 3;
                    }
                } else if (str.equals("gp")) {
                    return 5;
                }
            } else if (str.equals("fb")) {
                return 2;
            }
        }
        return -1;
    }
}
