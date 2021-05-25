package com.avito.android.di;

import android.app.Activity;
import com.avito.android.util.DialogRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DialogRouterModule_ProvideDialogRouterFactory implements Factory<DialogRouter> {
    public final Provider<Activity> a;

    public DialogRouterModule_ProvideDialogRouterFactory(Provider<Activity> provider) {
        this.a = provider;
    }

    public static DialogRouterModule_ProvideDialogRouterFactory create(Provider<Activity> provider) {
        return new DialogRouterModule_ProvideDialogRouterFactory(provider);
    }

    public static DialogRouter provideDialogRouter(Activity activity) {
        return (DialogRouter) Preconditions.checkNotNullFromProvides(DialogRouterModule.provideDialogRouter(activity));
    }

    @Override // javax.inject.Provider
    public DialogRouter get() {
        return provideDialogRouter(this.a.get());
    }
}
