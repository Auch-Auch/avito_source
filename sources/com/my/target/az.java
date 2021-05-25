package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.mediation.MediationAdConfig;
import com.my.target.mediation.MediationAdapter;
import java.lang.ref.WeakReference;
import java.util.Map;
public abstract class az<T extends MediationAdapter> {
    @NonNull
    public final cl a;
    @Nullable
    public WeakReference<Context> b;
    @Nullable
    public ik c;
    @Nullable
    public az<T>.b d;
    @Nullable
    public T e;
    @Nullable
    public String f;
    public float g;

    public static class a implements MediationAdConfig {
        @NonNull
        public final String a;
        @Nullable
        public final String b;
        public final int c;
        public final int d;
        @NonNull
        public final Map<String, String> e;
        @NonNull
        public final MyTargetPrivacy f;

        public a(@NonNull String str, @Nullable String str2, @NonNull Map<String, String> map, int i, int i2, @NonNull MyTargetPrivacy myTargetPrivacy) {
            this.a = str;
            this.b = str2;
            this.e = map;
            this.d = i;
            this.c = i2;
            this.f = myTargetPrivacy;
        }

        @NonNull
        public static a a(@NonNull String str, @Nullable String str2, @NonNull Map<String, String> map, int i, int i2, @NonNull MyTargetPrivacy myTargetPrivacy) {
            return new a(str, str2, map, i, i2, myTargetPrivacy);
        }

        @Override // com.my.target.mediation.MediationAdConfig
        public int getAge() {
            return this.d;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        public int getGender() {
            return this.c;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        @Nullable
        public String getPayload() {
            return this.b;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        @NonNull
        public String getPlacementId() {
            return this.a;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        @NonNull
        public MyTargetPrivacy getPrivacy() {
            return this.f;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        @NonNull
        public Map<String, String> getServerParams() {
            return this.e;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        public boolean isUserAgeRestricted() {
            return this.f.userAgeRestricted;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        public boolean isUserConsent() {
            Boolean bool = this.f.userConsent;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        @Override // com.my.target.mediation.MediationAdConfig
        public boolean isUserConsentSpecified() {
            return this.f.userConsent != null;
        }
    }

    public class b implements Runnable {
        @NonNull
        public final cm a;

        public b(cm cmVar) {
            this.a = cmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder L = a2.b.a.a.a.L("MediationEngine: timeout for ");
            L.append(this.a.getName());
            L.append(" ad network");
            ae.a(L.toString());
            Context g = az.this.g();
            if (g != null) {
                im.a(this.a.getStatHolder().K("networkTimeout"), g);
            }
            az.this.a(this.a, false);
        }
    }

    public az(@NonNull cl clVar) {
        this.a = clVar;
    }

    public void a(@NonNull cm cmVar, boolean z) {
        az<T>.b bVar = this.d;
        if (bVar != null && bVar.a == cmVar) {
            ik ikVar = this.c;
            if (ikVar != null) {
                ikVar.e(bVar);
                this.c = null;
            }
            this.d = null;
            if (z) {
                this.f = cmVar.getName();
                this.g = cmVar.bO();
                Context g2 = g();
                if (g2 != null) {
                    im.a(cmVar.getStatHolder().K("networkFilled"), g2);
                    return;
                }
                return;
            }
            f();
        }
    }

    @Nullable
    public String ad() {
        return this.f;
    }

    public float ae() {
        return this.g;
    }

    public abstract void b(@NonNull T t, @NonNull cm cmVar, @NonNull Context context);

    public abstract boolean c(@NonNull MediationAdapter mediationAdapter);

    @NonNull
    public abstract T d();

    public abstract void e();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.my.target.mediation.MediationAdapter] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r7 = this;
            T extends com.my.target.mediation.MediationAdapter r0 = r7.e
            r1 = 0
            java.lang.String r2 = "MediationEngine error: "
            if (r0 == 0) goto L_0x0015
            r0.destroy()     // Catch:{ all -> 0x000b }
            goto L_0x0013
        L_0x000b:
            r0 = move-exception
            java.lang.StringBuilder r3 = a2.b.a.a.a.L(r2)
            a2.b.a.a.a.r1(r0, r3)
        L_0x0013:
            r7.e = r1
        L_0x0015:
            android.content.Context r0 = r7.g()
            if (r0 != 0) goto L_0x0021
            java.lang.String r0 = "MediationEngine: can't configure next ad network, context is null"
            com.my.target.ae.b(r0)
            return
        L_0x0021:
            com.my.target.cl r3 = r7.a
            com.my.target.cm r3 = r3.bK()
            if (r3 != 0) goto L_0x0032
            java.lang.String r0 = "MediationEngine: no ad networks available"
            com.my.target.ae.a(r0)
            r7.e()
            return
        L_0x0032:
            java.lang.String r4 = "MediationEngine: prepare adapter for "
            java.lang.StringBuilder r4 = a2.b.a.a.a.L(r4)
            java.lang.String r5 = r3.getName()
            r4.append(r5)
            java.lang.String r5 = " ad network"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.my.target.ae.a(r4)
            java.lang.String r4 = r3.getName()
            java.lang.String r5 = "myTarget"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x005c
            com.my.target.mediation.MediationAdapter r1 = r7.d()
            goto L_0x007d
        L_0x005c:
            java.lang.String r4 = r3.bM()
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0075 }
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0075 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r6)     // Catch:{ all -> 0x0075 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0075 }
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ all -> 0x0075 }
            com.my.target.mediation.MediationAdapter r4 = (com.my.target.mediation.MediationAdapter) r4     // Catch:{ all -> 0x0075 }
            r1 = r4
            goto L_0x007d
        L_0x0075:
            r4 = move-exception
            java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
            a2.b.a.a.a.r1(r4, r2)
        L_0x007d:
            r7.e = r1
            if (r1 == 0) goto L_0x00b7
            boolean r1 = r7.c(r1)
            if (r1 == 0) goto L_0x00b7
            java.lang.String r1 = "MediationEngine: adapter created"
            com.my.target.ae.a(r1)
            com.my.target.az$b r1 = new com.my.target.az$b
            r1.<init>(r3)
            r7.d = r1
            int r1 = r3.getTimeout()
            if (r1 <= 0) goto L_0x00a4
            com.my.target.ik r1 = com.my.target.ik.J(r1)
            r7.c = r1
            com.my.target.az<T>$b r2 = r7.d
            r1.d(r2)
        L_0x00a4:
            com.my.target.cz r1 = r3.getStatHolder()
            java.lang.String r2 = "networkRequested"
            java.util.ArrayList r1 = r1.K(r2)
            com.my.target.im.a(r1, r0)
            T extends com.my.target.mediation.MediationAdapter r1 = r7.e
            r7.b(r1, r3, r0)
            goto L_0x00d3
        L_0x00b7:
            java.lang.String r0 = "MediationEngine: can't create adapter, class "
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            java.lang.String r1 = r3.bM()
            r0.append(r1)
            java.lang.String r1 = " not found or invalid"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.my.target.ae.b(r0)
            r7.f()
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.az.f():void");
    }

    @Nullable
    public Context g() {
        WeakReference<Context> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void s(@NonNull Context context) {
        this.b = new WeakReference<>(context);
        f();
    }
}
