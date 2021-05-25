package com.avito.android.serp;

import a2.b.a.a.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/InlineFiltersChangesParamsConverterImpl;", "Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;", "", "", "rawMap", "convert", "(Ljava/util/Map;)Ljava/util/Map;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersChangesParamsConverterImpl implements InlineFiltersChangesParamsConverter {
    @Override // com.avito.android.serp.InlineFiltersChangesParamsConverter
    @NotNull
    public Map<String, String> convert(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, "rawMap");
        Regex regex = new Regex("\\b(params\\[[a-zA-Z0-9+-_]+])");
        Regex regex2 = new Regex("\\b(price\\[[a-zA-Z0-9+-_]+])");
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(map.size()));
        for (T t : map.entrySet()) {
            if (Regex.find$default(regex2, (CharSequence) t.getKey(), 0, 2, null) != null) {
                String str2 = (String) t.getKey();
                if (str2 == null || (str = m.replace$default(str2, "price", "changes[price]", false, 4, (Object) null)) == null) {
                    str = (String) t.getKey();
                }
            } else if (Regex.find$default(regex, (CharSequence) t.getKey(), 0, 2, null) != null) {
                String str3 = (String) t.getKey();
                if (str3 == null || (str = m.replace$default(str3, "params", "changes[params]", false, 4, (Object) null)) == null) {
                    str = (String) t.getKey();
                }
            } else {
                str = a.s(a.L("changes["), (String) t.getKey(), ']');
            }
            linkedHashMap.put(str, t.getValue());
        }
        return linkedHashMap;
    }
}
