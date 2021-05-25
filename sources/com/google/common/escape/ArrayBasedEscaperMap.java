package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap {
    public static final char[][] b = ((char[][]) Array.newInstance(char.class, 0, 0));
    public final char[][] a;

    public ArrayBasedEscaperMap(char[][] cArr) {
        this.a = cArr;
    }

    public static ArrayBasedEscaperMap create(Map<Character, String> map) {
        char[][] cArr;
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            cArr = b;
        } else {
            char[][] cArr2 = new char[(((Character) Collections.max(map.keySet())).charValue() + 1)][];
            for (Character ch : map.keySet()) {
                char charValue = ch.charValue();
                cArr2[charValue] = map.get(Character.valueOf(charValue)).toCharArray();
            }
            cArr = cArr2;
        }
        return new ArrayBasedEscaperMap(cArr);
    }
}
