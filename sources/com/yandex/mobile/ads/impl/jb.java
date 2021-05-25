package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.regex.Pattern;
public final class jb {
    private static final Pattern a = Pattern.compile("(<script)(.*)(src=\"mraid\\.js\")(.*)(<\\/script>)");

    public static boolean a(@NonNull String str) {
        return a.matcher(str).find();
    }
}
