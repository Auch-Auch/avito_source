package com.avito.android.search.filter;

import com.avito.android.common.InputFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InputItemFormatterProviderImpl_Factory implements Factory<InputItemFormatterProviderImpl> {
    public final Provider<InputFormatter> a;

    public InputItemFormatterProviderImpl_Factory(Provider<InputFormatter> provider) {
        this.a = provider;
    }

    public static InputItemFormatterProviderImpl_Factory create(Provider<InputFormatter> provider) {
        return new InputItemFormatterProviderImpl_Factory(provider);
    }

    public static InputItemFormatterProviderImpl newInstance(InputFormatter inputFormatter) {
        return new InputItemFormatterProviderImpl(inputFormatter);
    }

    @Override // javax.inject.Provider
    public InputItemFormatterProviderImpl get() {
        return newInstance(this.a.get());
    }
}
