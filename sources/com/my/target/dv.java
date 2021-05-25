package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class dv {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final dn d;
    @Nullable
    public String e;
    public boolean f = true;

    public dv(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = dn.c(bpVar, aVar, context);
    }

    @NonNull
    public static dv g(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dv(bpVar, aVar, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull org.json.JSONObject r9, @androidx.annotation.NonNull com.my.target.cg r10) {
        /*
            r8 = this;
            com.my.target.dn r0 = r8.d
            r0.a(r9, r10)
            boolean r0 = r10.isLogErrors()
            r8.f = r0
            java.lang.String r0 = r10.getId()
            r8.e = r0
            java.lang.String r0 = "cards"
            org.json.JSONArray r0 = r9.optJSONArray(r0)
            java.lang.String r1 = "Required field"
            r2 = 0
            if (r0 == 0) goto L_0x0067
            boolean r3 = com.my.target.io.fi()
            if (r3 == 0) goto L_0x0067
            int r9 = r0.length()
            r3 = 0
        L_0x0027:
            if (r3 >= r9) goto L_0x00f2
            org.json.JSONObject r4 = r0.optJSONObject(r3)
            if (r4 == 0) goto L_0x0064
            com.my.target.ch r5 = com.my.target.ch.newCard(r10)
            com.my.target.dn r6 = r8.d
            r6.a(r4, r5)
            java.lang.String r6 = r5.getTrackingLink()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0045
            java.lang.String r4 = "no tracking link in nativeAdCard"
            goto L_0x004d
        L_0x0045:
            com.my.target.common.models.ImageData r6 = r5.getImage()
            if (r6 != 0) goto L_0x0052
            java.lang.String r4 = "no image in nativeAdCard"
        L_0x004d:
            r8.b(r1, r4)
            r5 = r2
            goto L_0x005f
        L_0x0052:
            java.lang.String r6 = r5.getId()
            java.lang.String r7 = "cardID"
            java.lang.String r4 = r4.optString(r7, r6)
            r5.setId(r4)
        L_0x005f:
            if (r5 == 0) goto L_0x0064
            r10.addNativeAdCard(r5)
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0067:
            java.lang.String r0 = "content"
            boolean r3 = r9.has(r0)
            if (r3 == 0) goto L_0x00c5
            java.lang.String r3 = r10.getCtcText()
            java.lang.String r4 = "ctcText"
            java.lang.String r3 = r9.optString(r4, r3)
            r10.setCtcText(r3)
            java.lang.String r3 = "ctcIconLink"
            java.lang.String r3 = r9.optString(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x008f
            com.my.target.common.models.ImageData r3 = com.my.target.common.models.ImageData.newImageData(r3)
            r10.setCtcIcon(r3)
        L_0x008f:
            org.json.JSONObject r0 = r9.optJSONObject(r0)
            if (r0 == 0) goto L_0x00c5
            java.lang.String r3 = "type"
            java.lang.String r3 = r0.optString(r3)
            java.lang.String r4 = "html"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x00a9
            java.lang.String r0 = "NativeAdContent banner has type "
            a2.b.a.a.a.U0(r0, r3)
            goto L_0x00c2
        L_0x00a9:
            java.lang.String r3 = com.my.target.dn.e(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x00b9
            java.lang.String r0 = "NativeAdContent has no source field"
            r8.b(r1, r0)
            goto L_0x00c2
        L_0x00b9:
            com.my.target.ci r2 = com.my.target.ci.newContent(r10, r3)
            com.my.target.dn r1 = r8.d
            r1.a(r0, r2)
        L_0x00c2:
            r10.setContent(r2)
        L_0x00c5:
            java.lang.String r0 = "video"
            org.json.JSONObject r9 = r9.optJSONObject(r0)
            if (r9 == 0) goto L_0x00f2
            com.my.target.cf r0 = com.my.target.cf.newVideoBanner()
            java.lang.String r1 = r10.getId()
            r0.setId(r1)
            boolean r1 = r10.isLogErrors()
            r0.setLogErrors(r1)
            com.my.target.bp r1 = r8.a
            com.my.target.a r2 = r8.b
            android.content.Context r3 = r8.c
            com.my.target.do r1 = com.my.target.Cdo.d(r1, r2, r3)
            boolean r9 = r1.a(r9, r0)
            if (r9 == 0) goto L_0x00f2
            r10.setVideoBanner(r0)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.dv.a(org.json.JSONObject, com.my.target.cg):void");
    }

    public final void b(String str, String str2) {
        if (this.f) {
            dh.M(str).N(str2).v(this.b.getSlotId()).P(this.e).O(this.a.getUrl()).v(this.c);
        }
    }
}
