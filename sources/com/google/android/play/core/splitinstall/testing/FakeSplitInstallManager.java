package com.google.android.play.core.splitinstall.testing;

import a2.j.b.e.a.i.q0.a;
import a2.j.b.e.a.i.q0.c;
import a2.j.b.e.a.i.q0.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.an;
import com.google.android.play.core.internal.ao;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bs;
import com.google.android.play.core.splitcompat.d;
import com.google.android.play.core.splitcompat.e;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.z;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public class FakeSplitInstallManager implements SplitInstallManager {
    public static final long m = TimeUnit.SECONDS.toMillis(1);
    public static final /* synthetic */ int n = 0;
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Context b;
    public final an c;
    public final z d;
    public final bs e;
    public final com.google.android.play.core.internal.z<SplitInstallSessionState> f = new com.google.android.play.core.internal.z<>();
    public final Executor g;
    public final File h;
    public final AtomicReference<SplitInstallSessionState> i = new AtomicReference<>();
    public final Set<String> j = Collections.synchronizedSet(new HashSet());
    public final Set<String> k = Collections.synchronizedSet(new HashSet());
    public final AtomicBoolean l = new AtomicBoolean(false);

    public FakeSplitInstallManager(Context context, File file) throws PackageManager.NameNotFoundException {
        Executor a3 = d.a();
        aq aqVar = new aq();
        z zVar = new z(context, context.getPackageName());
        bs bsVar = new bs(context);
        ao aoVar = new ao(context, new e(context), new d(), null);
        this.b = context;
        this.h = file;
        this.d = zVar;
        this.e = bsVar;
        e eVar = new e(context);
        this.g = a3;
        this.c = new an(context, a3, aoVar, eVar, aqVar, null);
    }

    public static String b(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    public final SplitInstallSessionState a(f fVar) {
        SplitInstallSessionState e2 = e();
        SplitInstallSessionState a3 = ((a) fVar).a(e2);
        if (!this.i.compareAndSet(e2, a3)) {
            return null;
        }
        return a3;
    }

    public final void c(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        this.c.b(list, new a2.j.b.e.a.i.q0.e(this, list2, list3, j2, z, list));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(int i2) {
        try {
            SplitInstallSessionState e2 = e();
            if (e2 != null && i2 == e2.sessionId() && e2.status() == 1) {
                SplitInstallSessionState create = SplitInstallSessionState.create(i2, 7, e2.errorCode(), e2.bytesDownloaded(), e2.totalBytesToDownload(), e2.moduleNames(), e2.languages());
                if (!this.i.compareAndSet(e2, create)) {
                    create = null;
                }
                if (create != null) {
                    this.a.post(new c(this, create));
                }
                return Tasks.a((Object) null);
            }
            throw new SplitInstallException(-3);
        } catch (SplitInstallException e3) {
            return Tasks.a((Exception) e3);
        }
    }

    public final boolean d(int i2, int i3, Long l2, Long l3, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState a3 = a(new a(num, i2, i3, l2, l3, list, list2));
        if (a3 == null) {
            return false;
        }
        this.a.post(new c(this, a3));
        return true;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    public final SplitInstallSessionState e() {
        return this.i.get();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        return new HashSet(this.k);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        return new HashSet(this.j);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i2) {
        SplitInstallSessionState e2 = e();
        return (e2 == null || e2.sessionId() != i2) ? Tasks.a((Exception) new SplitInstallException(-4)) : Tasks.a(e2);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState e2 = e();
        return Tasks.a(e2 == null ? Collections.emptyList() : Collections.singletonList(e2));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.l.set(z);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cf, code lost:
        if (r4.contains(r6) == false) goto L_0x01d1;
     */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r25) {
        /*
        // Method dump skipped, instructions count: 593
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.b(splitInstallStateUpdatedListener);
    }
}
