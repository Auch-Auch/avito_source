package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class aav {
    public static boolean a(@Nullable Collection<?> collection, @Nullable Collection<?> collection2) {
        HashSet hashSet;
        if (collection == null && collection2 == null) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        if (collection instanceof HashSet) {
            hashSet = (HashSet) collection;
            collection = collection2;
        } else if (collection2 instanceof HashSet) {
            hashSet = (HashSet) collection2;
        } else {
            HashSet hashSet2 = new HashSet(collection);
            collection = collection2;
            hashSet = hashSet2;
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static List<Integer> a(@NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @NonNull
    public static int[] a(@NonNull List<Integer> list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    public static <K, V> void a(@NonNull Map<K, V> map, @Nullable K k, @Nullable V v) {
        if (k != null && v != null) {
            map.put(k, v);
        }
    }
}
