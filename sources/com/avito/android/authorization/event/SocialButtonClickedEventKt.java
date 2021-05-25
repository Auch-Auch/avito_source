package com.avito.android.authorization.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002¨\u0006\u0005"}, d2 = {"", "PROFILE", "Ljava/lang/String;", "AUTH", "SUGGEST", "analytics_release"}, k = 2, mv = {1, 4, 2})
public final class SocialButtonClickedEventKt {
    @NotNull
    public static final String AUTH = "auth";
    @NotNull
    public static final String PROFILE = "profile";
    @NotNull
    public static final String SUGGEST = "suggest";

    public static final long access$convertToEventId(String str) {
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
        return -1;
    }
}
