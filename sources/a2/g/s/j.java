package a2.g.s;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.LoginClient;
public class j extends p {
    public static final Parcelable.Creator<j> CREATOR = new a();

    public static class a implements Parcelable.Creator<j> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i) {
            return new j[i];
        }
    }

    public j(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public String b() {
        return "katana_proxy_auth";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[LOOP:0: B:9:0x003e->B:21:0x005f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[SYNTHETIC] */
    @Override // a2.g.s.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(com.facebook.login.LoginClient.Request r15) {
        /*
            r14 = this;
            com.facebook.login.LoginBehavior r0 = r15.a
            boolean r1 = com.facebook.FacebookSdk.ignoreAppSwitchToLoggedOut
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = com.facebook.internal.CustomTabUtils.getChromePackage()
            if (r1 == 0) goto L_0x0014
            boolean r0 = r0.e
            if (r0 == 0) goto L_0x0014
            r13 = 1
            goto L_0x0015
        L_0x0014:
            r13 = 0
        L_0x0015:
            java.lang.String r0 = com.facebook.login.LoginClient.g()
            com.facebook.login.LoginClient r1 = r14.loginClient
            androidx.fragment.app.FragmentActivity r4 = r1.e()
            java.lang.String r5 = r15.d
            java.util.Set<java.lang.String> r6 = r15.b
            boolean r8 = r15.f
            boolean r9 = r15.a()
            com.facebook.login.DefaultAudience r10 = r15.c
            java.lang.String r1 = r15.e
            java.lang.String r11 = r14.getClientState(r1)
            java.lang.String r12 = r15.h
            r7 = r0
            java.util.List r15 = com.facebook.internal.NativeProtocol.createProxyAuthIntents(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.String r1 = "e2e"
            r14.addLoggingExtra(r1, r0)
            r0 = 0
        L_0x003e:
            int r1 = r15.size()
            if (r0 >= r1) goto L_0x0062
            java.lang.Object r1 = r15.get(r0)
            android.content.Intent r1 = (android.content.Intent) r1
            int r4 = com.facebook.login.LoginClient.i()
            if (r1 != 0) goto L_0x0051
            goto L_0x005a
        L_0x0051:
            com.facebook.login.LoginClient r5 = r14.loginClient     // Catch:{ ActivityNotFoundException -> 0x005a }
            androidx.fragment.app.Fragment r5 = r5.c     // Catch:{ ActivityNotFoundException -> 0x005a }
            r5.startActivityForResult(r1, r4)     // Catch:{ ActivityNotFoundException -> 0x005a }
            r1 = 1
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            if (r1 == 0) goto L_0x005f
            int r0 = r0 + r3
            return r0
        L_0x005f:
            int r0 = r0 + 1
            goto L_0x003e
        L_0x0062:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g.s.j.f(com.facebook.login.LoginClient$Request):int");
    }

    @Override // a2.g.s.n
    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public j(Parcel parcel) {
        super(parcel);
    }
}
