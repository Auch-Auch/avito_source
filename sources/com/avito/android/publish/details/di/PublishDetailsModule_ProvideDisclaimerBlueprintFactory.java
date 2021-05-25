package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.infomation.item.DisclaimerBlueprint;
import com.avito.android.publish.slots.infomation.item.DisclaimerItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideDisclaimerBlueprintFactory implements Factory<DisclaimerBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<DisclaimerItemPresenter> b;
    public final Provider<AttributedTextFormatter> c;

    public PublishDetailsModule_ProvideDisclaimerBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsModule_ProvideDisclaimerBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new PublishDetailsModule_ProvideDisclaimerBlueprintFactory(publishDetailsModule, provider, provider2);
    }

    public static DisclaimerBlueprint provideDisclaimerBlueprint(PublishDetailsModule publishDetailsModule, DisclaimerItemPresenter disclaimerItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return (DisclaimerBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideDisclaimerBlueprint(disclaimerItemPresenter, attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public DisclaimerBlueprint get() {
        return provideDisclaimerBlueprint(this.a, this.b.get(), this.c.get());
    }
}
