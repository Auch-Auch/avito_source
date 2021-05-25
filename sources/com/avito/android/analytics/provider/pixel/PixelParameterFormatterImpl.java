package com.avito.android.analytics.provider.pixel;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatterImpl;", "Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "format", "(Ljava/util/Map;)Ljava/lang/String;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class PixelParameterFormatterImpl implements PixelParameterFormatter {
    @Override // com.avito.android.analytics.provider.pixel.PixelParameterFormatter
    @NotNull
    public String format(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (!(value == null || value.length() == 0)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            StringBuilder L = a.L(a.c3((String) entry2.getKey(), ":"));
            L.append((String) entry2.getValue());
            arrayList.add(L.toString());
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ";", null, null, 0, null, null, 62, null);
    }
}
