package com.avito.android.publish.details.di;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideButtonBlueprintFactory implements Factory<ButtonItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<ButtonItemPresenter> b;

    public PublishDetailsModule_ProvideButtonBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<ButtonItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideButtonBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<ButtonItemPresenter> provider) {
        return new PublishDetailsModule_ProvideButtonBlueprintFactory(publishDetailsModule, provider);
    }

    public static ButtonItemBlueprint provideButtonBlueprint(PublishDetailsModule publishDetailsModule, ButtonItemPresenter buttonItemPresenter) {
        return (ButtonItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideButtonBlueprint(buttonItemPresenter));
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return provideButtonBlueprint(this.a, this.b.get());
    }
}
