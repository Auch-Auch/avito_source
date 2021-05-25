package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
public class ef implements abx<Thread, StackTraceElement[], lc> {
    @NonNull
    public lc a(@NonNull Thread thread, @Nullable StackTraceElement[] stackTraceElementArr) {
        List list;
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        String a = a(thread);
        Integer valueOf = Integer.valueOf(thread.getState().ordinal());
        if (stackTraceElementArr == null) {
            list = null;
        } else {
            list = Arrays.asList(stackTraceElementArr);
        }
        return new lc(name, priority, id, a, valueOf, list);
    }

    @NonNull
    public static String a(@NonNull Thread thread) {
        ThreadGroup threadGroup = thread.getThreadGroup();
        return threadGroup != null ? threadGroup.getName() : "";
    }
}
