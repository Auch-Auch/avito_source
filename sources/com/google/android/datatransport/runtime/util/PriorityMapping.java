package com.google.android.datatransport.runtime.util;

import a2.b.a.a.a;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;
public final class PriorityMapping {
    public static SparseArray<Priority> a = new SparseArray<>();
    public static EnumMap<Priority, Integer> b;

    static {
        EnumMap<Priority, Integer> enumMap = new EnumMap<>(Priority.class);
        b = enumMap;
        enumMap.put((EnumMap<Priority, Integer>) Priority.DEFAULT, (Priority) 0);
        b.put((EnumMap<Priority, Integer>) Priority.VERY_LOW, (Priority) 1);
        b.put((EnumMap<Priority, Integer>) Priority.HIGHEST, (Priority) 2);
        for (Priority priority : b.keySet()) {
            a.append(b.get(priority).intValue(), priority);
        }
    }

    public static int toInt(@NonNull Priority priority) {
        Integer num = b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority valueOf(int i) {
        Priority priority = a.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(a.M2("Unknown Priority for value ", i));
    }
}
