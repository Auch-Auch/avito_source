package com.avito.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.avito.android.app.di.HasApplicationComponent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH$¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/BaseApp;", "Landroid/app/Application;", "Lcom/avito/android/app/di/HasApplicationComponent;", "Landroid/content/Context;", "base", "", "attachBaseContext", "(Landroid/content/Context;)V", "", "obtainComponent", "()Ljava/lang/Object;", "T", "getApplicationComponent", "Lkotlin/Function0;", "block", "runIfMainProcess", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseApp extends Application implements HasApplicationComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static BaseApp instance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/BaseApp$Companion;", "", "Lcom/avito/android/BaseApp;", "instance", "Lcom/avito/android/BaseApp;", "getInstance", "()Lcom/avito/android/BaseApp;", "setInstance", "(Lcom/avito/android/BaseApp;)V", "getInstance$annotations", "()V", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final BaseApp getInstance() {
            BaseApp baseApp = BaseApp.instance;
            if (baseApp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("instance");
            }
            return baseApp;
        }

        public final void setInstance(@NotNull BaseApp baseApp) {
            Intrinsics.checkNotNullParameter(baseApp, "<set-?>");
            BaseApp.instance = baseApp;
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public static final BaseApp getInstance() {
        BaseApp baseApp = instance;
        if (baseApp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
        }
        return baseApp;
    }

    public static final void setInstance(@NotNull BaseApp baseApp) {
        instance = baseApp;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "base");
        super.attachBaseContext(context);
        instance = this;
    }

    @Override // com.avito.android.app.di.HasApplicationComponent
    public <T> T getApplicationComponent() {
        return (T) obtainComponent();
    }

    @NotNull
    public abstract Object obtainComponent();

    public final void runIfMainProcess(@NotNull Function0<Unit> function0) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z;
        Intrinsics.checkNotNullParameter(function0, "block");
        int myPid = Process.myPid();
        String packageName = getPackageName();
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        boolean z2 = true;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            Iterator<T> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (myPid != ((ActivityManager.RunningAppProcessInfo) next).pid || !Intrinsics.areEqual(packageName, ((ActivityManager.RunningAppProcessInfo) next).processName)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            function0.invoke();
        }
    }
}
