package com.avito.android.dialog;

import android.app.Activity;
import com.avito.android.util.DialogRouter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DialogPresenterImpl_Factory implements Factory<DialogPresenterImpl> {
    public final Provider<Activity> a;
    public final Provider<DialogRouter> b;

    public DialogPresenterImpl_Factory(Provider<Activity> provider, Provider<DialogRouter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DialogPresenterImpl_Factory create(Provider<Activity> provider, Provider<DialogRouter> provider2) {
        return new DialogPresenterImpl_Factory(provider, provider2);
    }

    public static DialogPresenterImpl newInstance(Activity activity, DialogRouter dialogRouter) {
        return new DialogPresenterImpl(activity, dialogRouter);
    }

    @Override // javax.inject.Provider
    public DialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
