package com.avito.android.publish.details.adapter.multiselect;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsMultiselectItemPresenterImpl_Factory implements Factory<RdsMultiselectItemPresenterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public RdsMultiselectItemPresenterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static RdsMultiselectItemPresenterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new RdsMultiselectItemPresenterImpl_Factory(provider);
    }

    public static RdsMultiselectItemPresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new RdsMultiselectItemPresenterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public RdsMultiselectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
