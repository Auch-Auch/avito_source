package com.avito.android.remote.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Request;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"api_release"}, k = 2, mv = {1, 4, 2})
public final class HeadersInterceptorKt {
    public static final List access$generateHeaderToRemove(List list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderProvider) it.next()).getKey() + "-required");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map access$generateNewHeaders(okhttp3.Headers r5, java.util.List r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0009:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r6.next()
            com.avito.android.remote.interceptor.HeaderProvider r1 = (com.avito.android.remote.interceptor.HeaderProvider) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.getKey()
            r2.append(r3)
            java.lang.String r3 = "-required"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r5.get(r2)
            java.lang.String r3 = "true"
            r4 = 1
            boolean r2 = t6.y.m.equals(r3, r2, r4)
            r3 = 0
            if (r2 != 0) goto L_0x0042
            boolean r2 = r1.isMandatory()
            if (r2 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r2 = 0
            goto L_0x0043
        L_0x0042:
            r2 = 1
        L_0x0043:
            if (r2 == 0) goto L_0x0061
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r4 = 0
        L_0x004d:
            if (r4 == 0) goto L_0x0061
            java.lang.String r2 = r1.getKey()
            java.lang.String r1 = r1.getValue()
            if (r1 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            java.lang.String r1 = ""
        L_0x005c:
            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            if (r1 == 0) goto L_0x0009
            r0.add(r1)
            goto L_0x0009
        L_0x0068:
            java.util.Map r5 = t6.n.r.toMap(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.interceptor.HeadersInterceptorKt.access$generateNewHeaders(okhttp3.Headers, java.util.List):java.util.Map");
    }

    public static final boolean access$hostIsContainedIn(Request request, List list) {
        return list.contains(request.url().host());
    }
}
