package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideMultiselectItemPresenterFactory implements Factory<RdsMultiselectItemPresenter> {
    public final PublishDetailsModule a;
    public final Provider<AttributedTextFormatter> b;

    public PublishDetailsModule_ProvideMultiselectItemPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideMultiselectItemPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<AttributedTextFormatter> provider) {
        return new PublishDetailsModule_ProvideMultiselectItemPresenterFactory(publishDetailsModule, provider);
    }

    public static RdsMultiselectItemPresenter provideMultiselectItemPresenter(PublishDetailsModule publishDetailsModule, AttributedTextFormatter attributedTextFormatter) {
        return (RdsMultiselectItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideMultiselectItemPresenter(attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public RdsMultiselectItemPresenter get() {
        return provideMultiselectItemPresenter(this.a, this.b.get());
    }
}
