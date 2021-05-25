package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.avito.android.BuildConfig;
import com.yandex.mobile.ads.nativeads.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class pp {
    @NonNull
    private final ps a;
    @NonNull
    private final pu b;
    @NonNull
    private final pr c;
    @NonNull
    private final ed d;

    public pp(@NonNull Context context) {
        ed edVar = new ed(context);
        this.d = edVar;
        this.c = new pr(edVar);
        pu puVar = new pu(edVar);
        this.b = puVar;
        this.a = new ps(context, puVar);
    }

    private static oz b(JSONObject jSONObject) throws JSONException, z {
        oz ozVar = (oz) Cif.a(oz.class, new Object[0]);
        if (ozVar != null) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("templateType".equals(next)) {
                    ozVar.a(a(jSONObject2, next));
                } else if ("highlightingEnabled".equals(next)) {
                    ozVar.a(jSONObject2.getBoolean(next));
                }
            }
        }
        return ozVar;
    }

    private List<bo> c(JSONObject jSONObject) throws JSONException, z {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("showNotices");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(e(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    @NonNull
    private List<String> d(@NonNull JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("renderTrackingUrls");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(this.d.a(jSONArray.getString(i)));
        }
        return arrayList;
    }

    @VisibleForTesting
    private bo e(JSONObject jSONObject) throws z, JSONException {
        bo boVar = (bo) Cif.a(bo.class, new Object[0]);
        if (boVar != null) {
            if (pq.a(jSONObject, "delay", "url")) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("delay".equals(next)) {
                        boVar.a(jSONObject.getLong(next));
                    } else if ("url".equals(next)) {
                        boVar.a(this.c.a(jSONObject, next));
                    } else if ("visibilityPercent".equals(next)) {
                        boVar.a(Math.max(Math.min(jSONObject.optInt(next, 0), 100), 0));
                    }
                }
            } else {
                throw new z("Native Ad json has not required attributes");
            }
        }
        return boVar;
    }

    @VisibleForTesting
    private ox f(JSONObject jSONObject) throws JSONException, z {
        ox oxVar = (ox) Cif.a(ox.class, new Object[0]);
        if (oxVar != null) {
            if (pq.a(jSONObject, "adType", "assets", "link")) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("adType".equals(next)) {
                        oxVar.a(a(jSONObject, next));
                    } else if ("assets".equals(next)) {
                        oxVar.a(g(jSONObject));
                    } else if ("link".equals(next)) {
                        oxVar.a(this.b.a(jSONObject.getJSONObject(next)));
                    } else if ("showNotice".equals(next)) {
                        oxVar.a(e(jSONObject.getJSONObject(next)));
                    } else if ("info".equals(next)) {
                        oxVar.e(jSONObject.optString(next, null));
                    } else if ("hideConditions".equals(next)) {
                        oxVar.a(pt.a(jSONObject, next));
                    } else if ("showConditions".equals(next)) {
                        oxVar.b(pt.a(jSONObject, next));
                    } else if ("renderTrackingUrl".equals(next)) {
                        oxVar.c(this.c.a(jSONObject, next));
                    } else if ("id".equals(next)) {
                        oxVar.d(jSONObject.optString("id", null));
                    }
                }
            } else {
                throw new z("Native Ad json has not required attributes");
            }
        }
        return oxVar;
    }

    @NonNull
    private List<oq> g(JSONObject jSONObject) throws JSONException, z {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            boolean z = jSONObject2.getBoolean("required");
            try {
                arrayList.add(this.a.a(jSONObject2));
            } catch (z | JSONException e) {
                if (z) {
                    throw e;
                }
            }
        }
        if (!pq.a(arrayList)) {
            return arrayList;
        }
        throw new z("Native Ad json has not required attributes");
    }

    @NonNull
    public final oy a(@NonNull String str) throws JSONException, z {
        List<ox> c2;
        oy a3 = a(new JSONObject(str));
        boolean z = false;
        if (!(a3 == null || (c2 = a3.c()) == null || c2.isEmpty())) {
            z = true;
        }
        if (z) {
            return a3;
        }
        throw new z("Native Ad json has not required attributes");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        if (r12 != null) goto L_0x006f;
     */
    @android.support.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.yandex.mobile.ads.impl.oy a(org.json.JSONObject r14) throws org.json.JSONException, com.yandex.mobile.ads.nativeads.z {
        /*
            r13 = this;
            java.lang.Class<com.yandex.mobile.ads.impl.oy> r0 = com.yandex.mobile.ads.impl.oy.class
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Object r0 = com.yandex.mobile.ads.impl.Cif.a(r0, r2)
            com.yandex.mobile.ads.impl.oy r0 = (com.yandex.mobile.ads.impl.oy) r0
            if (r0 == 0) goto L_0x00e2
            java.lang.String r2 = "native"
            org.json.JSONObject r14 = r14.getJSONObject(r2)
            java.lang.String r2 = "ads"
            java.lang.String[] r3 = new java.lang.String[]{r2}
            boolean r3 = com.yandex.mobile.ads.impl.pq.a(r14, r3)
            java.lang.String r4 = "Native Ad json has not required attributes"
            if (r3 == 0) goto L_0x00dc
            java.util.Iterator r3 = r14.keys()
        L_0x0025:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00e2
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r2.equals(r5)
            if (r6 == 0) goto L_0x0081
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            org.json.JSONArray r6 = r14.getJSONArray(r2)
            r7 = 0
        L_0x0041:
            int r8 = r6.length()
            if (r7 >= r8) goto L_0x007d
            org.json.JSONObject r8 = r6.getJSONObject(r7)
            com.yandex.mobile.ads.impl.ox r8 = r13.f(r8)
            r9 = 1
            if (r8 == 0) goto L_0x006e
            java.util.List r10 = r8.c()
            com.yandex.mobile.ads.impl.ou r11 = r8.a()
            com.yandex.mobile.ads.nativeads.NativeAdType r12 = r8.b()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x006e
            if (r11 == 0) goto L_0x0068
            r10 = 1
            goto L_0x0069
        L_0x0068:
            r10 = 0
        L_0x0069:
            if (r10 == 0) goto L_0x006e
            if (r12 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r9 = 0
        L_0x006f:
            if (r9 == 0) goto L_0x0077
            r5.add(r8)
            int r7 = r7 + 1
            goto L_0x0041
        L_0x0077:
            com.yandex.mobile.ads.nativeads.z r14 = new com.yandex.mobile.ads.nativeads.z
            r14.<init>(r4)
            throw r14
        L_0x007d:
            r0.b(r5)
            goto L_0x0025
        L_0x0081:
            java.lang.String r6 = "assets"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x0098
            java.util.List r5 = r13.g(r14)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0094
            r5 = 0
        L_0x0094:
            r0.a(r5)
            goto L_0x0025
        L_0x0098:
            java.lang.String r6 = "settings"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x00a9
            com.yandex.mobile.ads.impl.oz r5 = b(r14)
            r0.a(r5)
            goto L_0x0025
        L_0x00a9:
            java.lang.String r6 = "showNotices"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x00ba
            java.util.List r5 = r13.c(r14)
            r0.c(r5)
            goto L_0x0025
        L_0x00ba:
            java.lang.String r6 = "ver"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x00cb
            java.lang.String r5 = a(r14, r5)
            r0.a(r5)
            goto L_0x0025
        L_0x00cb:
            java.lang.String r6 = "renderTrackingUrls"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0025
            java.util.List r5 = r13.d(r14)
            r0.d(r5)
            goto L_0x0025
        L_0x00dc:
            com.yandex.mobile.ads.nativeads.z r14 = new com.yandex.mobile.ads.nativeads.z
            r14.<init>(r4)
            throw r14
        L_0x00e2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.pp.a(org.json.JSONObject):com.yandex.mobile.ads.impl.oy");
    }

    @NonNull
    public static String a(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException, z {
        String string = jSONObject.getString(str);
        if (!TextUtils.isEmpty(string) && !BuildConfig.ADJUST_DEFAULT_TRACKER.equals(string)) {
            return string;
        }
        throw new z("Native Ad json has not required attributes");
    }
}
