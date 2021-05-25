package com.avito.android.util;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.app.di.HasActivityComponent;
import com.avito.android.app.di.HasApplicationComponent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\u0011\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0011\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0013\u001a1\u0010\u0014\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0018\"\u0017\u0010\u001d\u001a\u00020\u001a*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/fragment/app/Fragment;", "T", "", "size", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "Lkotlin/ExtensionFunctionType;", "init", "arguments", "(Landroidx/fragment/app/Fragment;ILkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "Landroid/content/Intent;", "intent", "requestCode", "Ljava/lang/Exception;", "Lkotlin/Exception;", "action", "startActivityForResultSafely", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;ILkotlin/jvm/functions/Function1;)V", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;I)V", "startActivitySafely", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;)V", "appComponent", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "activityComponent", "Landroidx/appcompat/app/ActionBar;", "getSupportActionBar", "(Landroidx/fragment/app/Fragment;)Landroidx/appcompat/app/ActionBar;", "supportActionBar", "android_release"}, k = 2, mv = {1, 4, 2})
public final class FragmentsKt {

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ Fragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(1);
            this.a = fragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            String name = this.a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
            Logs.error(name, "", exc2);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ Fragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(1);
            this.a = fragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            String name = this.a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
            Logs.error(name, "", exc2);
            return Unit.INSTANCE;
        }
    }

    public static final <T> T activityComponent(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$activityComponent");
        FragmentActivity activity = fragment.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.app.di.HasActivityComponent<T>");
        return (T) ((HasActivityComponent) activity).getActivityComponent();
    }

    public static final <T> T appComponent(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$appComponent");
        FragmentActivity activity = fragment.getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.avito.android.app.di.HasApplicationComponent");
        return (T) ((HasApplicationComponent) application).getApplicationComponent();
    }

    @NotNull
    public static final <T extends Fragment> T arguments(@NotNull T t, int i, @NotNull Function1<? super Bundle, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "$this$arguments");
        Intrinsics.checkNotNullParameter(function1, "init");
        Bundle bundle = i < 0 ? new Bundle() : new Bundle(i);
        function1.invoke(bundle);
        t.setArguments(bundle);
        return t;
    }

    public static /* synthetic */ Fragment arguments$default(Fragment fragment, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return arguments(fragment, i, function1);
    }

    @NotNull
    public static final ActionBar getSupportActionBar(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$supportActionBar");
        FragmentActivity activity = fragment.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        Objects.requireNonNull(supportActionBar, "null cannot be cast to non-null type androidx.appcompat.app.ActionBar");
        return supportActionBar;
    }

    public static final void startActivityForResultSafely(@NotNull Fragment fragment, @NotNull Intent intent, int i, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "$this$startActivityForResultSafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "action");
        try {
            fragment.startActivityForResult(IntentsKt.makeSafeForExternalApps(intent), i);
        } catch (Exception e) {
            function1.invoke(e);
        }
    }

    public static final void startActivitySafely(@NotNull Fragment fragment, @NotNull Intent intent, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "$this$startActivitySafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "action");
        try {
            fragment.startActivity(IntentsKt.makeSafeForExternalApps(intent));
        } catch (Exception e) {
            function1.invoke(e);
        }
    }

    public static final void startActivityForResultSafely(@NotNull Fragment fragment, @NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(fragment, "$this$startActivityForResultSafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivityForResultSafely(fragment, intent, i, new a(fragment));
    }

    public static final void startActivitySafely(@NotNull Fragment fragment, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(fragment, "$this$startActivitySafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivitySafely(fragment, intent, new b(fragment));
    }
}
