package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
public class ih {
    @NonNull
    public final ct a;
    @NonNull
    public final a b;

    public class a implements Runnable {
        public final /* synthetic */ cj a;
        public final /* synthetic */ Context b;

        public a(cj cjVar, Context context) {
            this.a = cjVar;
            this.b = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00c7 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8  */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                com.my.target.ih r0 = com.my.target.ih.this
                com.my.target.cj r1 = r9.a
                java.util.Objects.requireNonNull(r0)
                java.lang.String r2 = r1.getId()
                com.my.target.ct r3 = r0.a     // Catch:{ all -> 0x009d }
                org.json.JSONObject r3 = r3.ci()     // Catch:{ all -> 0x009d }
                java.lang.String r4 = "unable to change cached notification for banner "
                if (r3 != 0) goto L_0x0023
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r4)
                r1.append(r2)
                java.lang.String r3 = ": no raw data in section"
                goto L_0x0052
            L_0x0023:
                com.my.target.ct r5 = r0.a
                java.lang.String r5 = r5.getName()
                org.json.JSONObject r5 = r3.getJSONObject(r5)
                if (r5 != 0) goto L_0x003d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r4)
                r1.append(r2)
                java.lang.String r3 = ": no section object in raw data"
                goto L_0x0052
            L_0x003d:
                java.lang.String r6 = "banners"
                org.json.JSONArray r5 = r5.getJSONArray(r6)
                if (r5 != 0) goto L_0x005d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r4)
                r1.append(r2)
                java.lang.String r3 = ": no banners array in section object"
            L_0x0052:
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.my.target.ae.a(r1)
                goto L_0x00c4
            L_0x005d:
                int r4 = r5.length()
                r6 = 0
            L_0x0062:
                if (r6 >= r4) goto L_0x00c4
                java.lang.Object r7 = r5.get(r6)
                org.json.JSONObject r7 = (org.json.JSONObject) r7
                java.lang.String r8 = "bannerID"
                java.lang.String r8 = r7.getString(r8)
                if (r8 == 0) goto L_0x009a
                boolean r8 = r8.equals(r2)
                if (r8 == 0) goto L_0x009a
                java.lang.String r4 = "hasNotification"
                boolean r1 = r1.isHasNotification()
                r7.put(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "notification changed in raw data for banner "
                r1.append(r4)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.my.target.ae.a(r1)
                java.lang.String r0 = r3.toString()
                goto L_0x00c5
            L_0x009a:
                int r6 = r6 + 1
                goto L_0x0062
            L_0x009d:
                r1 = move-exception
                java.lang.String r3 = "error updating cached notification for section "
                java.lang.StringBuilder r3 = a2.b.a.a.a.L(r3)
                com.my.target.ct r0 = r0.a
                java.lang.String r0 = r0.getName()
                r3.append(r0)
                java.lang.String r0 = " and banner "
                r3.append(r0)
                r3.append(r2)
                java.lang.String r0 = ": "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r3.toString()
                com.my.target.ae.a(r0)
            L_0x00c4:
                r0 = 0
            L_0x00c5:
                if (r0 != 0) goto L_0x00c8
                return
            L_0x00c8:
                android.content.Context r1 = r9.b
                com.my.target.hy r1 = com.my.target.hy.Z(r1)
                if (r1 != 0) goto L_0x00e9
                java.lang.String r0 = "unable to open disk cache and save text data for slotId: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                com.my.target.ih r1 = com.my.target.ih.this
                com.my.target.a r1 = r1.b
                int r1 = r1.getSlotId()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.my.target.ae.a(r0)
                return
            L_0x00e9:
                com.my.target.ih r2 = com.my.target.ih.this
                com.my.target.a r2 = r2.b
                int r2 = r2.getSlotId()
                r3 = 1
                r1.a(r2, r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.ih.a.run():void");
        }
    }

    public ih(@NonNull ct ctVar, @NonNull a aVar) {
        this.a = ctVar;
        this.b = aVar;
    }

    @NonNull
    public static ih a(@NonNull ct ctVar, @NonNull a aVar) {
        return new ih(ctVar, aVar);
    }

    public void a(@NonNull cj cjVar, boolean z, @NonNull Context context) {
        if (cjVar.isHasNotification() != z) {
            cjVar.setHasNotification(z);
            af.a(new a(cjVar, context.getApplicationContext()));
        }
    }
}
