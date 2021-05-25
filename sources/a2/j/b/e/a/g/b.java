package a2.j.b.e.a.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.missingsplits.MissingSplitsManager;
import com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
public final class b implements MissingSplitsManager {
    public static final aa e = new aa("MissingSplitsManagerImpl");
    public final Context a;
    public final Runtime b;
    public final a c;
    public final AtomicReference<Boolean> d;

    public b(Context context, Runtime runtime, a aVar, AtomicReference<Boolean> atomicReference) {
        this.a = context;
        this.b = runtime;
        this.c = aVar;
        this.d = atomicReference;
    }

    @TargetApi(21)
    public final boolean a() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !Boolean.TRUE.equals(bundle.get("com.android.vending.splits.required"))) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            e.d("App '%s' is not found in the PackageManager", this.a.getPackageName());
            return false;
        }
    }

    public final Set<String> b() {
        String[] strArr;
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo == null || (strArr = packageInfo.splitNames) == null) {
                return hashSet;
            }
            Collections.addAll(hashSet, strArr);
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            e.d("App '%s' is not found in PackageManager", this.a.getPackageName());
            return Collections.emptySet();
        }
    }

    @TargetApi(21)
    public final List<ActivityManager.AppTask> c() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.a.getSystemService("activity")).getAppTasks();
        return appTasks == null ? Collections.emptyList() : appTasks;
    }

    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    public final boolean disableAppIfMissingRequiredSplits() {
        boolean z;
        boolean booleanValue;
        boolean z2;
        Intent intent;
        boolean z3;
        Bundle bundle;
        Set set;
        String[] strArr;
        synchronized (this.d) {
            z = true;
            if (this.d.get() == null) {
                AtomicReference<Boolean> atomicReference = this.d;
                try {
                    ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
                    if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null || !Boolean.TRUE.equals(bundle.get("com.android.vending.splits.required")))) {
                        try {
                            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
                            set = new HashSet();
                            if (!(packageInfo == null || (strArr = packageInfo.splitNames) == null)) {
                                Collections.addAll(set, strArr);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            e.d("App '%s' is not found in PackageManager", this.a.getPackageName());
                            set = Collections.emptySet();
                        }
                        if (set.isEmpty() || (set.size() == 1 && set.contains(""))) {
                            z3 = true;
                            atomicReference.set(Boolean.valueOf(z3));
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    e.d("App '%s' is not found in the PackageManager", this.a.getPackageName());
                }
                z3 = false;
                atomicReference.set(Boolean.valueOf(z3));
            }
            booleanValue = this.d.get().booleanValue();
        }
        if (booleanValue) {
            Iterator<ActivityManager.AppTask> it = c().iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.AppTask next = it.next();
                    if (!(next.getTaskInfo() == null || next.getTaskInfo().baseIntent == null || next.getTaskInfo().baseIntent.getComponent() == null || !PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName()))) {
                        break;
                    }
                } else {
                    Iterator<ActivityManager.AppTask> it2 = c().iterator();
                    loop1:
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        ActivityManager.RecentTaskInfo taskInfo = it2.next().getTaskInfo();
                        if (!(taskInfo == null || (intent = taskInfo.baseIntent) == null || intent.getComponent() == null)) {
                            ComponentName component = taskInfo.baseIntent.getComponent();
                            String className = component.getClassName();
                            try {
                                Class<?> cls = Class.forName(className);
                                while (cls != null) {
                                    if (cls.equals(Activity.class)) {
                                        break loop1;
                                    }
                                    Class<? super Object> superclass = cls.getSuperclass();
                                    cls = superclass != cls ? superclass : null;
                                }
                                continue;
                            } catch (ClassNotFoundException unused3) {
                                e.d("ClassNotFoundException when scanning class hierarchy of '%s'", className);
                                try {
                                    if (this.a.getPackageManager().getActivityInfo(component, 0) != null) {
                                        break;
                                    }
                                } catch (PackageManager.NameNotFoundException unused4) {
                                    continue;
                                }
                            }
                        }
                    }
                    z2 = true;
                    a aVar = this.c;
                    Objects.requireNonNull(aVar);
                    a.c.c("Disabling all non-activity components", new Object[0]);
                    aVar.a(aVar.b(), 2);
                    for (ActivityManager.AppTask appTask : c()) {
                        appTask.finishAndRemoveTask();
                    }
                    if (z2) {
                        this.a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.a, PlayCoreMissingSplitsActivity.class), 1, 1);
                        this.a.startActivity(new Intent(this.a, PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                    }
                    this.b.exit(0);
                }
            }
            return true;
        }
        a aVar2 = this.c;
        Iterator<ComponentInfo> it3 = aVar2.b().iterator();
        while (true) {
            if (!it3.hasNext()) {
                a.c.a("All non-activity components are disabled", new Object[0]);
                break;
            }
            ComponentInfo next2 = it3.next();
            if (aVar2.b.getComponentEnabledSetting(new ComponentName(next2.packageName, next2.name)) != 2) {
                a.c.a("Not all non-activity components are disabled", new Object[0]);
                z = false;
                break;
            }
        }
        if (z) {
            a aVar3 = this.c;
            Objects.requireNonNull(aVar3);
            a.c.c("Resetting enabled state of all non-activity components", new Object[0]);
            aVar3.a(aVar3.b(), 0);
            this.b.exit(0);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r2 != false) goto L_0x0039;
     */
    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMissingRequiredSplits() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r6.d
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.d     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0031 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0040
        L_0x000e:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.d     // Catch:{ all -> 0x0031 }
            boolean r2 = r6.a()     // Catch:{ all -> 0x0031 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0038
            java.util.Set r2 = r6.b()     // Catch:{ all -> 0x0031 }
            boolean r5 = r2.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r5 != 0) goto L_0x0035
            int r5 = r2.size()     // Catch:{ all -> 0x0031 }
            if (r5 != r3) goto L_0x0033
            java.lang.String r5 = ""
            boolean r2 = r2.contains(r5)     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0031:
            r1 = move-exception
            goto L_0x004e
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 != 0) goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0031 }
            r1.set(r2)     // Catch:{ all -> 0x0031 }
        L_0x0040:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.d     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0031 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r1
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.g.b.isMissingRequiredSplits():boolean");
    }
}
