package com.avito.android.in_app_calls.di;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import com.avito.android.in_app_calls.ui.InAppCallsRouterImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallActivityModule;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "provideInAppCallsRouter", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CallActivityModule {
    @NotNull
    public static final CallActivityModule INSTANCE = new CallActivityModule();

    @Provides
    @NotNull
    public final InAppCallsRouter provideInAppCallsRouter(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        return new InAppCallsRouterImpl(supportFragmentManager, R.id.in_app_call_root);
    }
}
