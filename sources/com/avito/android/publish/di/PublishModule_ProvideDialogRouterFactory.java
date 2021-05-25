package com.avito.android.publish.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishModule_ProvideDialogRouterFactory implements Factory<ProgressDialogRouter> {
    public final PublishModule a;
    public final Provider<FragmentActivity> b;

    public PublishModule_ProvideDialogRouterFactory(PublishModule publishModule, Provider<FragmentActivity> provider) {
        this.a = publishModule;
        this.b = provider;
    }

    public static PublishModule_ProvideDialogRouterFactory create(PublishModule publishModule, Provider<FragmentActivity> provider) {
        return new PublishModule_ProvideDialogRouterFactory(publishModule, provider);
    }

    public static ProgressDialogRouter provideDialogRouter(PublishModule publishModule, FragmentActivity fragmentActivity) {
        return (ProgressDialogRouter) Preconditions.checkNotNullFromProvides(publishModule.provideDialogRouter(fragmentActivity));
    }

    @Override // javax.inject.Provider
    public ProgressDialogRouter get() {
        return provideDialogRouter(this.a, this.b.get());
    }
}
