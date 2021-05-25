package com.facebook.appevents.restrictivedatafilter;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class RestrictiveDataManager {
    public static boolean a = false;
    public static final List<a> b = new ArrayList();
    public static final Set<String> c = new CopyOnWriteArraySet();

    public static class a {
        public String a;
        public Map<String, String> b;

        public a(String str, Map<String, String> map) {
            this.a = str;
            this.b = map;
        }
    }

    public static void enable() {
        a = true;
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null) {
                String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                if (restrictiveDataSetting == null) {
                    return;
                }
                if (!restrictiveDataSetting.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                    b.clear();
                    c.clear();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        if (jSONObject2 != null) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                            a aVar = new a(next, new HashMap());
                            if (optJSONObject != null) {
                                aVar.b = Utility.convertJSONObjectToStringMap(optJSONObject);
                                b.add(aVar);
                            }
                            if (jSONObject2.has("process_event_name")) {
                                c.add(aVar.a);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String processEvent(String str) {
        return (!a || !c.contains(str)) ? str : "_removed_";
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void processParameters(java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            boolean r0 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r8.keySet()
            r1.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0017:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0074
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x006a }
            java.util.List<com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager$a> r4 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.b     // Catch:{ Exception -> 0x006a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x006a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x006a }
        L_0x002e:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x006a }
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x006a }
            com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager$a r4 = (com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.a) r4     // Catch:{ Exception -> 0x006a }
            if (r4 != 0) goto L_0x003d
            goto L_0x002e
        L_0x003d:
            java.lang.String r5 = r4.a     // Catch:{ Exception -> 0x006a }
            boolean r5 = r9.equals(r5)     // Catch:{ Exception -> 0x006a }
            if (r5 == 0) goto L_0x002e
            java.util.Map<java.lang.String, java.lang.String> r5 = r4.b     // Catch:{ Exception -> 0x006a }
            java.util.Set r5 = r5.keySet()     // Catch:{ Exception -> 0x006a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x006a }
        L_0x004f:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x006a }
            if (r6 == 0) goto L_0x002e
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x006a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x006a }
            boolean r7 = r2.equals(r6)     // Catch:{ Exception -> 0x006a }
            if (r7 == 0) goto L_0x004f
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.b     // Catch:{ Exception -> 0x006a }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ Exception -> 0x006a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x006a }
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            if (r3 == 0) goto L_0x0017
            r0.put(r2, r3)
            r8.remove(r2)
            goto L_0x0017
        L_0x0074:
            int r9 = r0.size()
            if (r9 <= 0) goto L_0x00aa
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00aa }
            r9.<init>()     // Catch:{ JSONException -> 0x00aa }
            java.util.Set r0 = r0.entrySet()     // Catch:{ JSONException -> 0x00aa }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x00aa }
        L_0x0087:
            boolean r1 = r0.hasNext()     // Catch:{ JSONException -> 0x00aa }
            if (r1 == 0) goto L_0x00a1
            java.lang.Object r1 = r0.next()     // Catch:{ JSONException -> 0x00aa }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ JSONException -> 0x00aa }
            java.lang.Object r2 = r1.getKey()     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x00aa }
            java.lang.Object r1 = r1.getValue()     // Catch:{ JSONException -> 0x00aa }
            r9.put(r2, r1)     // Catch:{ JSONException -> 0x00aa }
            goto L_0x0087
        L_0x00a1:
            java.lang.String r0 = "_restrictedParams"
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x00aa }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x00aa }
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.processParameters(java.util.Map, java.lang.String):void");
    }
}
