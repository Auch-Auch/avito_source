package com.avito.android.remote.model.payment.service;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/net/Uri;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "parseOrderItemSet", "(Landroid/net/Uri;)Ljava/util/Set;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class OrderItemKt {
    @NotNull
    public static final Set<OrderItem> parseOrderItemSet(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$parseOrderItemSet");
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer(uri.toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = urlQuerySanitizer.getParameterList();
        Intrinsics.checkNotNullExpressionValue(parameterList, "sanitizer.parameterList");
        ArrayList<UrlQuerySanitizer.ParameterValuePair> arrayList = new ArrayList();
        for (T t : parameterList) {
            String str = ((UrlQuerySanitizer.ParameterValuePair) t).mParameter;
            Intrinsics.checkNotNullExpressionValue(str, "it.mParameter");
            if (new Regex("^orderItems\\[\\d\\]\\[\\w+\\]$").matches(str)) {
                arrayList.add(t);
            }
        }
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : arrayList) {
            Regex regex = new Regex("^orderItems\\[(\\d)\\]\\[(\\w+)\\]$");
            String str2 = parameterValuePair.mParameter;
            Intrinsics.checkNotNullExpressionValue(str2, "parameterValuePair.mParameter");
            String str3 = null;
            MatchResult find$default = Regex.find$default(regex, str2, 0, 2, null);
            if (find$default != null) {
                MatchGroup matchGroup = find$default.getGroups().get(1);
                String value = matchGroup != null ? matchGroup.getValue() : null;
                MatchGroup matchGroup2 = find$default.getGroups().get(2);
                if (matchGroup2 != null) {
                    str3 = matchGroup2.getValue();
                }
                String str4 = parameterValuePair.mValue;
                if (!(value == null || str3 == null)) {
                    Map map = (Map) linkedHashMap.get(value);
                    if (map == null) {
                        map = new LinkedHashMap();
                    }
                    Intrinsics.checkNotNull(str4);
                    map.put(str3, str4);
                    linkedHashMap.put(value, map);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Map) entry.getValue()).containsKey("serviceSlug") && ((Map) entry.getValue()).containsKey("externalId")) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object obj = ((Map) entry2.getValue()).get("serviceSlug");
            Intrinsics.checkNotNull(obj);
            Object obj2 = ((Map) entry2.getValue()).get("externalId");
            Intrinsics.checkNotNull(obj2);
            arrayList2.add(new OrderItem((String) obj, (String) obj2));
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList2);
    }
}
