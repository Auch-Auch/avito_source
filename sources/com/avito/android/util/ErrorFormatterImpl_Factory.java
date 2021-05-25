package com.avito.android.util;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorFormatterImpl_Factory implements Factory<ErrorFormatterImpl> {
    public final Provider<Resources> a;

    public ErrorFormatterImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ErrorFormatterImpl_Factory create(Provider<Resources> provider) {
        return new ErrorFormatterImpl_Factory(provider);
    }

    public static ErrorFormatterImpl newInstance(Resources resources) {
        return new ErrorFormatterImpl(resources);
    }

    @Override // javax.inject.Provider
    public ErrorFormatterImpl get() {
        return newInstance(this.a.get());
    }
}
