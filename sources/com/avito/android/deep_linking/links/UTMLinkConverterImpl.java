package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/deep_linking/links/UTMLinkConverterImpl;", "Lcom/avito/android/deep_linking/links/UTMLinkConverter;", "Lcom/avito/android/deep_linking/links/UTMLink;", "link", "", "convertToQueryParameters", "(Lcom/avito/android/deep_linking/links/UTMLink;)Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UTMLinkConverterImpl implements UTMLinkConverter {
    @Override // com.avito.android.deep_linking.links.UTMLinkConverter
    @NotNull
    public String convertToQueryParameters(@NotNull UTMLink uTMLink) {
        Intrinsics.checkNotNullParameter(uTMLink, "link");
        StringBuilder sb = new StringBuilder();
        Map mapOf = r.mapOf(TuplesKt.to("utm_source", uTMLink.getUtmSource()), TuplesKt.to("utm_medium", uTMLink.getUtmMedium()), TuplesKt.to("utm_campaign", uTMLink.getUtmCampaign()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            StringBuilder L = a.L(sb.length() == 0 ? "?" : "&");
            L.append((String) entry2.getKey());
            L.append('=');
            L.append((String) entry2.getValue());
            sb.append(L.toString());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder()\n        …   }\n        }.toString()");
        return sb2;
    }
}
