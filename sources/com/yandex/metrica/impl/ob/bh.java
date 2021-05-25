package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.regex.Pattern;
public class bh {
    private static final Pattern a = Pattern.compile("com\\.yandex\\.metrica\\.(?!push)");
    private static final Pattern b = Pattern.compile("com\\.yandex\\.metrica\\.push\\..*");

    public boolean a(@NonNull List<StackTraceElement> list) {
        return a(list, a);
    }

    public boolean b(@NonNull List<StackTraceElement> list) {
        return a(list, b);
    }

    private boolean a(@NonNull List<StackTraceElement> list, @NonNull Pattern pattern) {
        for (StackTraceElement stackTraceElement : list) {
            if (pattern.matcher(stackTraceElement.getClassName()).find()) {
                return true;
            }
        }
        return false;
    }
}
