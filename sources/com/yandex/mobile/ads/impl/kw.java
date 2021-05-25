package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.HashMap;
import java.util.Map;
public final class kw {
    private static final Map<String, kv> a = new HashMap<String, kv>() { // from class: com.yandex.mobile.ads.impl.kw.1
        {
            put("image", new ky());
            put("number", new la());
            put("close_button", new kx());
            put("media", new kz());
            put(Types.STRING, new lb());
        }
    };

    @NonNull
    public static kv a(@NonNull String str) {
        str.hashCode();
        String str2 = "media";
        char c = 65535;
        switch (str.hashCode()) {
            case -1678958759:
                if (str.equals("close_button")) {
                    c = 0;
                    break;
                }
                break;
            case -1074675180:
                if (str.equals("favicon")) {
                    c = 1;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 2;
                    break;
                }
                break;
            case -807286424:
                if (str.equals("review_count")) {
                    c = 3;
                    break;
                }
                break;
            case 3226745:
                if (str.equals("icon")) {
                    c = 4;
                    break;
                }
                break;
            case 103772132:
                if (str.equals(str2)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = "close_button";
                break;
            case 1:
            case 4:
                str2 = "image";
                break;
            case 2:
            case 3:
                str2 = "number";
                break;
            case 5:
                break;
            default:
                str2 = Types.STRING;
                break;
        }
        return a.get(str2);
    }
}
