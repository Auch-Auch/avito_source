package com.avito.android.error_helper;

import com.avito.android.util.ErrorFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorHelperImpl_Factory implements Factory<ErrorHelperImpl> {
    public final Provider<ErrorFormatter> a;

    public ErrorHelperImpl_Factory(Provider<ErrorFormatter> provider) {
        this.a = provider;
    }

    public static ErrorHelperImpl_Factory create(Provider<ErrorFormatter> provider) {
        return new ErrorHelperImpl_Factory(provider);
    }

    public static ErrorHelperImpl newInstance(ErrorFormatter errorFormatter) {
        return new ErrorHelperImpl(errorFormatter);
    }

    @Override // javax.inject.Provider
    public ErrorHelperImpl get() {
        return newInstance(this.a.get());
    }
}
