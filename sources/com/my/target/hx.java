package com.my.target;

import a2.l.a.p;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.MyTargetActivity;
import com.my.target.gi;
import java.util.WeakHashMap;
public class hx {
    @NonNull
    public static final WeakHashMap<by, Boolean> a = new WeakHashMap<>();

    public static abstract class a {
        @NonNull
        public final by a;

        public a(@NonNull by byVar) {
            this.a = byVar;
        }
    }

    public static class b extends a {
        public b(by byVar, p pVar) {
            super(byVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(@androidx.annotation.NonNull android.content.Context r9) {
            /*
                r8 = this;
                com.my.target.by r0 = r8.a
                java.lang.String r0 = r0.getNavigationType()
                java.lang.String r1 = "store"
                boolean r0 = r1.equals(r0)
                r1 = 0
                if (r0 != 0) goto L_0x0010
                return r1
            L_0x0010:
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 30
                r3 = 0
                if (r0 < r2) goto L_0x0022
                com.my.target.by r0 = r8.a
                boolean r0 = r0.isAppInWhiteList()
                if (r0 == 0) goto L_0x0020
                goto L_0x0022
            L_0x0020:
                r0 = r3
                goto L_0x0036
            L_0x0022:
                com.my.target.by r0 = r8.a
                java.lang.String r3 = r0.getBundleId()
                if (r3 != 0) goto L_0x002b
                return r1
            L_0x002b:
                android.content.pm.PackageManager r0 = r9.getPackageManager()
                android.content.Intent r0 = r0.getLaunchIntentForPackage(r3)
                if (r0 != 0) goto L_0x0036
                return r1
            L_0x0036:
                com.my.target.by r2 = r8.a
                java.lang.String r2 = r2.getDeeplink()
                java.lang.String r4 = "android.intent.action.VIEW"
                r5 = 268435456(0x10000000, float:2.5243549E-29)
                r6 = 1
                if (r2 != 0) goto L_0x0045
            L_0x0043:
                r2 = 0
                goto L_0x005e
            L_0x0045:
                android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x0043 }
                android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0043 }
                r7.<init>(r4, r2)     // Catch:{ all -> 0x0043 }
                boolean r2 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x0043 }
                if (r2 != 0) goto L_0x0055
                r7.addFlags(r5)     // Catch:{ all -> 0x0043 }
            L_0x0055:
                if (r3 == 0) goto L_0x005a
                r7.setPackage(r3)     // Catch:{ all -> 0x0043 }
            L_0x005a:
                r9.startActivity(r7)     // Catch:{ all -> 0x0043 }
                r2 = 1
            L_0x005e:
                if (r2 == 0) goto L_0x0070
                com.my.target.by r0 = r8.a
                com.my.target.cz r0 = r0.getStatHolder()
                java.lang.String r1 = "deeplinkClick"
                java.util.ArrayList r0 = r0.K(r1)
                com.my.target.im.a(r0, r9)
                return r6
            L_0x0070:
                com.my.target.by r2 = r8.a
                java.lang.String r2 = r2.getUrlscheme()
                if (r2 != 0) goto L_0x007a
            L_0x0078:
                r2 = 0
                goto L_0x0093
            L_0x007a:
                android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x0078 }
                android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0078 }
                r7.<init>(r4, r2)     // Catch:{ all -> 0x0078 }
                boolean r2 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x0078 }
                if (r2 != 0) goto L_0x008a
                r7.addFlags(r5)     // Catch:{ all -> 0x0078 }
            L_0x008a:
                if (r3 == 0) goto L_0x008f
                r7.setPackage(r3)     // Catch:{ all -> 0x0078 }
            L_0x008f:
                r9.startActivity(r7)     // Catch:{ all -> 0x0078 }
                r2 = 1
            L_0x0093:
                if (r2 != 0) goto L_0x00a7
                if (r0 != 0) goto L_0x0099
            L_0x0097:
                r0 = 0
                goto L_0x00a4
            L_0x0099:
                boolean r2 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x0097 }
                if (r2 != 0) goto L_0x00a0
                r0.addFlags(r5)     // Catch:{ all -> 0x0097 }
            L_0x00a0:
                r9.startActivity(r0)     // Catch:{ all -> 0x0097 }
                r0 = 1
            L_0x00a4:
                if (r0 != 0) goto L_0x00a7
                return r1
            L_0x00a7:
                com.my.target.by r0 = r8.a
                com.my.target.cz r0 = r0.getStatHolder()
                java.lang.String r1 = "click"
                java.util.ArrayList r0 = r0.K(r1)
                com.my.target.im.a(r0, r9)
                com.my.target.by r0 = r8.a
                java.lang.String r0 = r0.getTrackingLink()
                if (r0 == 0) goto L_0x00cb
                boolean r1 = com.my.target.ip.ao(r0)
                if (r1 != 0) goto L_0x00cb
                com.my.target.ip r0 = com.my.target.ip.ar(r0)
                r0.ag(r9)
            L_0x00cb:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.hx.b.a(android.content.Context):boolean");
        }
    }

    public static class c extends d {
        public c(String str, by byVar, p pVar) {
            super(str, byVar, null);
        }

        @Override // com.my.target.hx.d
        public boolean a(@NonNull Context context) {
            boolean z = false;
            if (ip.ap(this.b)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    z = true;
                } catch (Throwable unused) {
                }
                if (z) {
                    return true;
                }
            } else {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    context.startActivity(intent2);
                    z = true;
                } catch (Throwable unused2) {
                }
                if (z) {
                    return true;
                }
            }
            return super.a(context);
        }
    }

    public static class d extends a {
        @NonNull
        public final String b;

        public d(String str, by byVar, p pVar) {
            super(byVar);
            this.b = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(@androidx.annotation.NonNull android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = r8.getPackageName()
                java.lang.String r1 = "ru.mail.browser"
                boolean r0 = r0.equals(r1)
                java.lang.String r2 = "android.intent.action.VIEW"
                r3 = 0
                r4 = 268435456(0x10000000, float:2.5243549E-29)
                r5 = 1
                if (r0 != 0) goto L_0x0013
                goto L_0x003c
            L_0x0013:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0032 }
                java.lang.String r6 = r7.b     // Catch:{ all -> 0x0032 }
                android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ all -> 0x0032 }
                r0.<init>(r2, r6)     // Catch:{ all -> 0x0032 }
                java.lang.String r6 = "com.android.browser.application_id"
                r0.putExtra(r6, r1)     // Catch:{ all -> 0x0032 }
                r0.setPackage(r1)     // Catch:{ all -> 0x0032 }
                boolean r1 = r8 instanceof android.app.Activity     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x002d
                r0.addFlags(r4)     // Catch:{ all -> 0x0032 }
            L_0x002d:
                r8.startActivity(r0)     // Catch:{ all -> 0x0032 }
                r0 = 1
                goto L_0x003d
            L_0x0032:
                r0 = move-exception
                java.lang.String r1 = "Unable to start atom: "
                java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
                a2.b.a.a.a.q1(r0, r1)
            L_0x003c:
                r0 = 0
            L_0x003d:
                if (r0 == 0) goto L_0x0040
                return r5
            L_0x0040:
                com.my.target.by r0 = r7.a
                boolean r0 = r0.isOpenInBrowser()
                if (r0 == 0) goto L_0x0049
                goto L_0x00af
            L_0x0049:
                java.lang.String r0 = r7.b
                android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0073 }
                r1.<init>(r2, r0)     // Catch:{ all -> 0x0073 }
                android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0073 }
                r0.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = "android.support.customtabs.extra.SESSION"
                r6 = 0
                r0.putBinder(r2, r6)     // Catch:{ all -> 0x0073 }
                boolean r2 = r8 instanceof android.app.Activity     // Catch:{ all -> 0x0073 }
                if (r2 != 0) goto L_0x0066
                r1.addFlags(r4)     // Catch:{ all -> 0x0073 }
            L_0x0066:
                java.lang.String r2 = "com.android.chrome"
                r1.setPackage(r2)     // Catch:{ all -> 0x0073 }
                r1.putExtras(r0)     // Catch:{ all -> 0x0073 }
                r8.startActivity(r1)     // Catch:{ all -> 0x0073 }
                r3 = 1
                goto L_0x0074
            L_0x0073:
            L_0x0074:
                if (r3 == 0) goto L_0x0077
                return r5
            L_0x0077:
                com.my.target.by r0 = r7.a
                java.lang.String r0 = r0.getNavigationType()
                java.lang.String r1 = "store"
                boolean r0 = r1.equals(r0)
                if (r0 != 0) goto L_0x00af
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 < r1) goto L_0x0094
                java.lang.String r0 = r7.b
                boolean r0 = com.my.target.ip.aq(r0)
                if (r0 != 0) goto L_0x0094
                goto L_0x00af
            L_0x0094:
                java.lang.String r0 = r7.b
                com.my.target.hx$e r1 = new com.my.target.hx$e
                r1.<init>(r0)
                com.my.target.common.MyTargetActivity.activityEngine = r1
                android.content.Intent r0 = new android.content.Intent
                java.lang.Class<com.my.target.common.MyTargetActivity> r1 = com.my.target.common.MyTargetActivity.class
                r0.<init>(r8, r1)
                boolean r1 = r8 instanceof android.app.Activity
                if (r1 != 0) goto L_0x00ab
                r0.addFlags(r4)
            L_0x00ab:
                r8.startActivity(r0)
                return r5
            L_0x00af:
                java.lang.String r0 = r7.b
                boolean r8 = r7.b(r0, r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.hx.d.a(android.content.Context):boolean");
        }

        public final boolean b(@NonNull String str, @NonNull Context context) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static class e implements MyTargetActivity.ActivityEngine {
        @NonNull
        public final String a;
        @Nullable
        public gi b;

        public class a implements gi.b {
            public final /* synthetic */ MyTargetActivity a;

            public a(e eVar, MyTargetActivity myTargetActivity) {
                this.a = myTargetActivity;
            }

            @Override // com.my.target.gi.b
            public void p() {
                this.a.finish();
            }
        }

        public e(@NonNull String str) {
            this.a = str;
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public boolean onActivityBackPressed() {
            gi giVar = this.b;
            if (giVar == null || !giVar.canGoBack()) {
                return true;
            }
            this.b.goBack();
            return false;
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
            myTargetActivity.setTheme(16973837);
            Window window = myTargetActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-12232092);
            try {
                gi giVar = new gi(myTargetActivity);
                this.b = giVar;
                frameLayout.addView(giVar);
                this.b.init();
                this.b.setUrl(this.a);
                this.b.setListener(new a(this, myTargetActivity));
            } catch (Throwable th) {
                ae.b(th.getMessage());
                myTargetActivity.finish();
            }
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityDestroy() {
            gi giVar = this.b;
            if (giVar != null) {
                giVar.destroy();
                this.b = null;
            }
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public boolean onActivityOptionsItemSelected(MenuItem menuItem) {
            return false;
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityPause() {
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityResume() {
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityStart() {
        }

        @Override // com.my.target.common.MyTargetActivity.ActivityEngine
        public void onActivityStop() {
        }
    }

    @NonNull
    public static hx eC() {
        return new hx();
    }

    public void a(@NonNull by byVar, @NonNull Context context) {
        c(byVar, byVar.getTrackingLink(), context);
    }

    public final void b(@NonNull String str, @NonNull by byVar, @NonNull Context context) {
        (ip.ao(str) ? new c(str, byVar, null) : new d(str, byVar, null)).a(context);
    }

    public void c(@NonNull by byVar, @Nullable String str, @NonNull Context context) {
        WeakHashMap<by, Boolean> weakHashMap = a;
        if (!weakHashMap.containsKey(byVar) && !new b(byVar, null).a(context)) {
            if (str != null) {
                if (byVar.isDirectLink() || ip.ao(str)) {
                    b(str, byVar, context);
                } else {
                    weakHashMap.put(byVar, Boolean.TRUE);
                    ip.ar(str).a(new p(this, byVar, context)).ag(context);
                }
            }
            im.a(byVar.getStatHolder().K("click"), context);
        }
    }
}
