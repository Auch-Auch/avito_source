package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.HashMap;
import java.util.Map;
public final class ld {
    private static final Map<String, lc> a = new HashMap<String, lc>() { // from class: com.yandex.mobile.ads.impl.ld.1
        {
            put("image", new le());
            put(Types.STRING, new lh());
            put("media", new lf());
        }
    };

    @NonNull
    public static lc a(@NonNull String str) {
        str.hashCode();
        String str2 = "media";
        char c = 65535;
        switch (str.hashCode()) {
            case -1074675180:
                if (str.equals("favicon")) {
                    c = 0;
                    break;
                }
                break;
            case 3226745:
                if (str.equals("icon")) {
                    c = 1;
                    break;
                }
                break;
            case 103772132:
                if (str.equals(str2)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                str2 = "image";
                break;
            case 2:
                break;
            default:
                str2 = Types.STRING;
                break;
        }
        return a.get(str2);
    }
}
