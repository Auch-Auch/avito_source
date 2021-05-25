package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.du;
import org.json.JSONArray;
import org.json.JSONObject;
public class ac extends c<cu> implements du.a {
    @Nullable
    public String a;

    @NonNull
    public static c<cu> f() {
        return new ac();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r1 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r1 = r9.optJSONObject("standard_728x90");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        if (r1 != null) goto L_0x0073;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.my.target.cu a(@androidx.annotation.NonNull java.lang.String r9, @androidx.annotation.NonNull com.my.target.bp r10, @androidx.annotation.Nullable com.my.target.cu r11, @androidx.annotation.NonNull com.my.target.a r12, @androidx.annotation.NonNull android.content.Context r13) {
        /*
            r8 = this;
            org.json.JSONObject r9 = r8.a(r9, r13)
            r0 = 0
            if (r9 != 0) goto L_0x0008
            return r0
        L_0x0008:
            if (r11 != 0) goto L_0x000e
            com.my.target.cu r11 = com.my.target.cu.cp()
        L_0x000e:
            java.lang.String r1 = "mraid.js"
            java.lang.String r1 = r9.optString(r1)
            r8.a = r1
            java.lang.String r1 = r12.getFormat()
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 0
            java.lang.String r5 = "standard"
            java.lang.String r6 = "standard_320x50"
            java.lang.String r7 = "standard_728x90"
            switch(r3) {
                case -1292723836: goto L_0x003f;
                case -1177968780: goto L_0x0036;
                case 1312628413: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0047
        L_0x002d:
            boolean r3 = r1.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0047
        L_0x0034:
            r2 = 2
            goto L_0x0047
        L_0x0036:
            boolean r3 = r1.equals(r7)
            if (r3 != 0) goto L_0x003d
            goto L_0x0047
        L_0x003d:
            r2 = 1
            goto L_0x0047
        L_0x003f:
            boolean r3 = r1.equals(r6)
            if (r3 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            switch(r2) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0061;
                case 2: goto L_0x004f;
                default: goto L_0x004a;
            }
        L_0x004a:
            org.json.JSONObject r1 = r9.optJSONObject(r1)
            goto L_0x0073
        L_0x004f:
            org.json.JSONObject r1 = r9.optJSONObject(r5)
            if (r1 != 0) goto L_0x0059
            org.json.JSONObject r1 = r9.optJSONObject(r6)
        L_0x0059:
            if (r1 == 0) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            org.json.JSONObject r1 = r9.optJSONObject(r7)
            goto L_0x0073
        L_0x0061:
            org.json.JSONObject r1 = r9.optJSONObject(r5)
            if (r1 == 0) goto L_0x005c
            goto L_0x0073
        L_0x0068:
            org.json.JSONObject r1 = r9.optJSONObject(r5)
            if (r1 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            org.json.JSONObject r1 = r9.optJSONObject(r6)
        L_0x0073:
            if (r1 != 0) goto L_0x0092
            boolean r1 = r12.isMediationEnabled()
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = "mediation"
            org.json.JSONObject r9 = r9.optJSONObject(r1)
            if (r9 == 0) goto L_0x0091
            com.my.target.du r10 = com.my.target.du.a(r8, r10, r12, r13)
            com.my.target.cl r9 = r10.i(r9)
            if (r9 == 0) goto L_0x0091
            r11.a(r9)
            return r11
        L_0x0091:
            return r0
        L_0x0092:
            java.lang.String r9 = "banners"
            org.json.JSONArray r9 = r1.optJSONArray(r9)
            if (r9 == 0) goto L_0x00be
            int r2 = r9.length()
            if (r2 > 0) goto L_0x00a1
            goto L_0x00be
        L_0x00a1:
            com.my.target.ea r2 = com.my.target.ea.cT()
            r2.a(r1, r11)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x00be
            org.json.JSONObject r9 = r9.optJSONObject(r4)
            if (r9 == 0) goto L_0x00be
            com.my.target.ck r9 = r8.d(r9, r10, r12, r13)
            if (r9 == 0) goto L_0x00be
            r11.a(r9)
            return r11
        L_0x00be:
            return r0
            switch-data {-1292723836->0x003f, -1177968780->0x0036, 1312628413->0x002d, }
            switch-data {0->0x0068, 1->0x0061, 2->0x004f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.ac.a(java.lang.String, com.my.target.bp, com.my.target.cu, com.my.target.a, android.content.Context):com.my.target.cu");
    }

    @Override // com.my.target.du.a
    @Nullable
    public cn b(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("banners", jSONArray);
            new JSONObject().put(aVar.getFormat(), jSONObject2);
            cu cp = cu.cp();
            ck d = d(jSONObject, bpVar, aVar, context);
            if (d == null) {
                return null;
            }
            cp.a(d);
            return cp;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public final ck d(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        dz j = dz.j(bpVar, aVar, context);
        ck newBanner = ck.newBanner();
        if (!j.a(jSONObject, newBanner, this.a)) {
            return null;
        }
        return newBanner;
    }
}
