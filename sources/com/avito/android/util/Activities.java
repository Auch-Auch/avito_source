package com.avito.android.util;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.app.di.HasApplicationComponent;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aA\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0018\b\u0004\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u000f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0011\u001a\"\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0012*\u00020\u0014H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0012*\u00020\u0014H\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u0017\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0013*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"Landroid/app/Activity;", "Lkotlin/Function0;", "", "block", "runOnMainThreadSync", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorHandler", "", "startActivityForResultSafely", "(Landroid/app/Activity;Landroid/content/Intent;ILkotlin/jvm/functions/Function1;)Z", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "", "T", "Landroidx/fragment/app/FragmentActivity;", "findFragmentOfType", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Object;", "getTopFragmentIfMatchType", "appComponent", "(Landroid/app/Activity;)Ljava/lang/Object;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Activities")
public final class Activities {
    public static final <T> T appComponent(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$appComponent");
        Application application = activity.getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.avito.android.app.di.HasApplicationComponent");
        return (T) ((HasApplicationComponent) application).getApplicationComponent();
    }

    public static final /* synthetic */ <T> T findFragmentOfType(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$findFragmentOfType");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t != null && t.isAdded()) {
                Intrinsics.reifiedOperationMarker(3, "T");
                return t;
            }
        }
        return null;
    }

    public static final /* synthetic */ <T> T getTopFragmentIfMatchType(FragmentActivity fragmentActivity) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$getTopFragmentIfMatchType");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            if (t2.isVisible()) {
                Intrinsics.reifiedOperationMarker(3, "T");
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public static final void runOnMainThreadSync(@NotNull Activity activity, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "$this$runOnMainThreadSync");
        Intrinsics.checkNotNullParameter(function0, "block");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        activity.runOnUiThread(new Runnable(function0, countDownLatch) { // from class: com.avito.android.util.Activities$runOnMainThreadSync$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ CountDownLatch b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.a.invoke();
                } finally {
                    this.b.countDown();
                }
            }
        });
        countDownLatch.await();
    }

    public static final boolean startActivityForResultSafely(@NotNull Activity activity, @NotNull Intent intent, int i, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "$this$startActivityForResultSafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "errorHandler");
        try {
            activity.startActivityForResult(IntentsKt.makeSafeForExternalApps(intent), i);
            return true;
        } catch (Exception e) {
            function1.invoke(e);
            return false;
        }
    }

    @Deprecated(message = "Function deprecated", replaceWith = @ReplaceWith(expression = "startActivityForResultSafely(intent, requestCode, errorHandler)", imports = {}))
    public static final void startActivityForResultSafely(@NotNull Activity activity, @NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(activity, "$this$startActivityForResultSafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            activity.startActivityForResult(IntentsKt.makeSafeForExternalApps(intent), i);
        } catch (Exception e) {
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
            Logs.error(name, "", e);
        }
    }
}
