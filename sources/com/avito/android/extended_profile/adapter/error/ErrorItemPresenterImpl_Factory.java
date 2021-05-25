package com.avito.android.extended_profile.adapter.error;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ErrorItemPresenterImpl_Factory implements Factory<ErrorItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public ErrorItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static ErrorItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new ErrorItemPresenterImpl_Factory(provider);
    }

    public static ErrorItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new ErrorItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
