package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideLinkSlotPresenterFactory implements Factory<LinkSlotItemPresenter> {
    public final PublishDetailsModule a;
    public final Provider<AttributedTextFormatter> b;

    public PublishDetailsModule_ProvideLinkSlotPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideLinkSlotPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        return new PublishDetailsModule_ProvideLinkSlotPresenterFactory(publishDetailsModule, provider);
    }

    public static LinkSlotItemPresenter provideLinkSlotPresenter(PublishDetailsModule publishDetailsModule, AttributedTextFormatter attributedTextFormatter) {
        return (LinkSlotItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideLinkSlotPresenter(attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public LinkSlotItemPresenter get() {
        return provideLinkSlotPresenter(this.a, this.b.get());
    }
}
