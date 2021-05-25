package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
public class fe extends fb {
    public boolean b = false;

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            fe.this.b(this.a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "com.huawei.hms.ads.identifier.AdvertisingIdClient"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "send huawei AId"
            com.my.target.ae.a(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "getAdvertisingIdInfo"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x00a1 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x00a1 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x00a1
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x00a1 }
            r2[r6] = r9     // Catch:{ all -> 0x00a1 }
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x00a1
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "getId"
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x00a1 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x0051
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a1 }
            java.lang.Object r2 = r2.invoke(r1, r4)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r4.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r5 = "huawei AId: "
            r4.append(r5)     // Catch:{ all -> 0x009e }
            r4.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009e }
            com.my.target.ae.a(r4)     // Catch:{ all -> 0x009e }
            goto L_0x0052
        L_0x0051:
            r2 = r0
        L_0x0052:
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x009e }
            java.lang.String r5 = "isLimitAdTrackingEnabled"
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x009e }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x009e
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ all -> 0x009e }
            java.lang.Object r1 = r4.invoke(r1, r5)     // Catch:{ all -> 0x009e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r4.<init>()     // Catch:{ all -> 0x009e }
            boolean r5 = r1.booleanValue()     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x0075
            r5 = 0
            goto L_0x0076
        L_0x0075:
            r5 = 1
        L_0x0076:
            r4.append(r5)     // Catch:{ all -> 0x009e }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ all -> 0x009e }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r4.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r5 = "huawei ad tracking enabled: "
            r4.append(r5)     // Catch:{ all -> 0x009e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r3 = 0
        L_0x0094:
            r4.append(r3)     // Catch:{ all -> 0x009e }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x009e }
            com.my.target.ae.a(r1)     // Catch:{ all -> 0x009e }
        L_0x009e:
            r1 = r0
            r0 = r2
            goto L_0x00a2
        L_0x00a1:
            r1 = r0
        L_0x00a2:
            monitor-enter(r8)
            java.lang.String r2 = "oaid"
            r8.addParam(r2, r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "oaid_tracking_enabled"
            r8.addParam(r2, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r8)     // Catch:{ all -> 0x00bd }
            com.my.target.ij r2 = com.my.target.ij.ad(r9)
            r2.ak(r0)
            com.my.target.ij r9 = com.my.target.ij.ad(r9)
            r9.al(r1)
            return
        L_0x00bd:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.fe.b(android.content.Context):void");
    }

    @Override // com.my.target.fb
    @WorkerThread
    public synchronized void collectData(@NonNull Context context) {
        if (af.isMainThread()) {
            ae.a("You must not call collectData method from main thread");
        } else if (!this.b) {
            ij ad = ij.ad(context);
            try {
                Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient");
                String eV = ad.eV();
                String eW = ad.eW();
                if (eV == null || eV.length() == 0) {
                    b(context);
                } else {
                    addParam("oaid", eV);
                    addParam("oaid_tracking_enabled", eW);
                    af.b(new a(context));
                }
                this.b = true;
            } catch (Throwable unused) {
                ad.ak(null);
                ad.al(null);
                this.b = true;
            }
        }
    }
}
