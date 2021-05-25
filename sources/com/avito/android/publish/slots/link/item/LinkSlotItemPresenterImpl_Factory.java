package com.avito.android.publish.slots.link.item;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LinkSlotItemPresenterImpl_Factory implements Factory<LinkSlotItemPresenterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public LinkSlotItemPresenterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static LinkSlotItemPresenterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new LinkSlotItemPresenterImpl_Factory(provider);
    }

    public static LinkSlotItemPresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new LinkSlotItemPresenterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public LinkSlotItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
