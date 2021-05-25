package com.avito.android.publish_limits_info.history.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishLimitsHistoryModule_ProvideDialogRouterFactory implements Factory<ProgressDialogRouter> {
    public final Provider<FragmentActivity> a;

    public PublishLimitsHistoryModule_ProvideDialogRouterFactory(Provider<FragmentActivity> provider) {
        this.a = provider;
    }

    public static PublishLimitsHistoryModule_ProvideDialogRouterFactory create(Provider<FragmentActivity> provider) {
        return new PublishLimitsHistoryModule_ProvideDialogRouterFactory(provider);
    }

    public static ProgressDialogRouter provideDialogRouter(FragmentActivity fragmentActivity) {
        return (ProgressDialogRouter) Preconditions.checkNotNullFromProvides(PublishLimitsHistoryModule.INSTANCE.provideDialogRouter(fragmentActivity));
    }

    @Override // javax.inject.Provider
    public ProgressDialogRouter get() {
        return provideDialogRouter(this.a.get());
    }
}
