package com.vk.sdk.util;

import android.net.Uri;
import android.text.TextUtils;
import com.vk.sdk.api.model.VKAttachments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
public class VKStringJoiner {
    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0045: APUT  (r3v2 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v2 java.lang.String) */
    public static String joinParams(Map<String, ?> map, boolean z) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof VKAttachments) {
                value = ((VKAttachments) value).toAttachmentsString();
            }
            Object[] objArr = new Object[2];
            objArr[0] = entry.getKey();
            objArr[1] = z ? Uri.encode(String.valueOf(value)) : String.valueOf(value);
            arrayList.add(String.format("%s=%s", objArr));
        }
        return join(arrayList, "&");
    }

    public static String joinUriParams(Map<String, ?> map) {
        return joinParams(map, true);
    }

    public static String join(Collection<?> collection, String str) {
        return TextUtils.join(str, collection);
    }

    public static String joinParams(Map<String, ?> map) {
        return joinParams(map, false);
    }
}
