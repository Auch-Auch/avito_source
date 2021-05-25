package a2.j.b.e.a.i;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.ac;
import com.google.android.play.core.splitinstall.z;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
public final class f implements SplitInstallManager {
    public final z a;
    public final ac b;
    public final z c;
    public final a0 d;
    public final Handler e = new Handler(Looper.getMainLooper());

    public f(z zVar, Context context) {
        String packageName = context.getPackageName();
        this.c = new z(context, packageName);
        this.a = zVar;
        this.b = ac.a(context);
        this.d = new a0(context);
    }

    public static List<String> a(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale locale : list) {
            arrayList.add(locale.toLanguageTag());
        }
        return arrayList;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(int i) {
        z zVar = this.a;
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "cancelInstall(%d)", new Object[]{Integer.valueOf(i)});
        zVar.b.a(new p(zVar, H1, i, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        z zVar = this.a;
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "deferredInstall(%s)", new Object[]{list});
        zVar.b.a(new k(zVar, H1, list, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        z zVar = this.a;
        List<String> a3 = a(list);
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "deferredLanguageInstall(%s)", new Object[]{a3});
        zVar.b.a(new l(zVar, H1, a3, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        z zVar = this.a;
        List<String> a3 = a(list);
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "deferredLanguageUninstall(%s)", new Object[]{a3});
        zVar.b.a(new m(zVar, H1, a3, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        a0 a0Var = this.d;
        synchronized (a0Var) {
            Set<String> a3 = a0Var.a();
            boolean z = false;
            for (String str : list) {
                if (a3.add(str)) {
                    z = true;
                }
            }
            if (z) {
                try {
                    a0Var.a.getSharedPreferences("playcore_split_install_internal", 0).edit().putStringSet("deferred_uninstall_module_list", a3).apply();
                } catch (Exception unused) {
                }
            }
        }
        z zVar = this.a;
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "deferredUninstall(%s)", new Object[]{list});
        zVar.b.a(new j(zVar, H1, list, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        Set<String> b2 = this.c.b();
        return b2 == null ? Collections.emptySet() : b2;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        return this.c.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        z zVar = this.a;
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "getSessionState(%d)", new Object[]{Integer.valueOf(i)});
        zVar.b.a(new n(zVar, H1, i, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        z zVar = this.a;
        if (zVar.b == null) {
            return z.d();
        }
        i H1 = a.H1(z.c, "getSessionStates", new Object[0]);
        zVar.b.a(new o(zVar, H1, H1));
        return H1.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.a((StateUpdatedListener) splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return startConfirmationDialogForResult(splitInstallSessionState, new e(activity), i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r1.containsAll(r3) != false) goto L_0x0037;
     */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r9) {
        /*
            r8 = this;
            java.util.List r0 = r9.getLanguages()
            r0.isEmpty()
            java.util.List r0 = r9.getLanguages()
            com.google.android.play.core.splitinstall.z r1 = r8.c
            java.util.Set r1 = r1.b()
            r2 = 0
            if (r1 == 0) goto L_0x0037
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r0.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r4 = r4.getLanguage()
            r3.add(r4)
            goto L_0x001d
        L_0x0031:
            boolean r0 = r1.containsAll(r3)
            if (r0 == 0) goto L_0x006b
        L_0x0037:
            java.util.List r0 = r9.getModuleNames()
            com.google.android.play.core.splitinstall.z r1 = r8.c
            java.util.Set r1 = r1.a()
            boolean r0 = r1.containsAll(r0)
            if (r0 != 0) goto L_0x0048
            goto L_0x006b
        L_0x0048:
            java.util.List r0 = r9.getModuleNames()
            a2.j.b.e.a.i.a0 r1 = r8.d
            java.util.Set r1 = r1.a()
            boolean r0 = java.util.Collections.disjoint(r0, r1)
            if (r0 == 0) goto L_0x006b
            android.os.Handler r0 = r8.e
            a2.j.b.e.a.i.d r1 = new a2.j.b.e.a.i.d
            r1.<init>(r8, r9)
            r0.post(r1)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            com.google.android.play.core.tasks.Task r9 = com.google.android.play.core.tasks.Tasks.a(r9)
            return r9
        L_0x006b:
            a2.j.b.e.a.i.z r1 = r8.a
            java.util.List r3 = r9.getModuleNames()
            java.util.List r9 = r9.getLanguages()
            java.util.List r4 = a(r9)
            com.google.android.play.core.internal.ak<com.google.android.play.core.internal.bp> r9 = r1.b
            if (r9 == 0) goto L_0x009f
            com.google.android.play.core.internal.aa r9 = a2.j.b.e.a.i.z.c
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r3
            r2 = 1
            r0[r2] = r4
            java.lang.String r2 = "startInstall(%s,%s)"
            com.google.android.play.core.tasks.i r9 = a2.b.a.a.a.H1(r9, r2, r0)
            com.google.android.play.core.internal.ak<com.google.android.play.core.internal.bp> r6 = r1.b
            a2.j.b.e.a.i.i r7 = new a2.j.b.e.a.i.i
            r0 = r7
            r2 = r9
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r6.a(r7)
            com.google.android.play.core.tasks.Task r9 = r9.a()
            goto L_0x00a3
        L_0x009f:
            com.google.android.play.core.tasks.Task r9 = a2.j.b.e.a.i.z.d()
        L_0x00a3:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.i.f.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.b(splitInstallStateUpdatedListener);
    }
}
