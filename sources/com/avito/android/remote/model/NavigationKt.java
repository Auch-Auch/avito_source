package com.avito.android.remote.model;

import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u001c\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a)\u0010\u0004\u001a\u00020\u0002*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00030\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0006\u001a7\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00020\u0002*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00030\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b*\"\u0010\f\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\r"}, d2 = {"", "", "", "Lcom/avito/android/remote/model/Attribute;", "joinToString", "(Ljava/lang/Iterable;)Ljava/lang/String;", "(Ljava/util/Map;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "kotlin.jvm.PlatformType", "toAnalyticsFormat", "(Ljava/lang/Iterable;Lcom/google/gson/Gson;)Ljava/lang/String;", "Attribute", "models_release"}, k = 2, mv = {1, 4, 2})
public final class NavigationKt {
    public static final String joinToString(Iterable<? extends Map<String, String>> iterable) {
        return CollectionsKt___CollectionsKt.joinToString$default(iterable, "", "[", "]", 0, null, NavigationKt$joinToString$1.INSTANCE, 24, null);
    }

    public static final String toAnalyticsFormat(@NotNull Iterable<? extends Map<String, String>> iterable, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toAnalyticsFormat");
        Intrinsics.checkNotNullParameter(gson, "gson");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends Map<String, String>> it = iterable.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                String str = (String) map.get("id");
                if (str != null) {
                    String str2 = (String) map.get("value");
                    linkedHashMap.put(str, str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return gson.toJson(linkedHashMap);
    }

    public static final String joinToString(Map<String, String> map) {
        return CollectionsKt___CollectionsKt.joinToString$default(map.entrySet(), "&", "{", "}", 0, null, NavigationKt$joinToString$2.INSTANCE, 24, null);
    }
}
