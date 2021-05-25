package com.avito.android.publish.details.di;

import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideSelectItemPresenterFactory implements Factory<MultiStateSelectItemPresenter> {
    public final PublishDetailsModule a;
    public final Provider<AttributedTextFormatter> b;

    public PublishDetailsModule_ProvideSelectItemPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideSelectItemPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        return new PublishDetailsModule_ProvideSelectItemPresenterFactory(publishDetailsModule, provider);
    }

    public static MultiStateSelectItemPresenter provideSelectItemPresenter(PublishDetailsModule publishDetailsModule, AttributedTextFormatter attributedTextFormatter) {
        return (MultiStateSelectItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideSelectItemPresenter(attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public MultiStateSelectItemPresenter get() {
        return provideSelectItemPresenter(this.a, this.b.get());
    }
}
