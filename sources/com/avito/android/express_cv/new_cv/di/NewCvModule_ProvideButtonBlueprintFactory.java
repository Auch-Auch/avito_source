package com.avito.android.express_cv.new_cv.di;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_ProvideButtonBlueprintFactory implements Factory<ButtonItemBlueprint> {
    public final NewCvModule a;
    public final Provider<ButtonItemPresenter> b;

    public NewCvModule_ProvideButtonBlueprintFactory(NewCvModule newCvModule, Provider<ButtonItemPresenter> provider) {
        this.a = newCvModule;
        this.b = provider;
    }

    public static NewCvModule_ProvideButtonBlueprintFactory create(NewCvModule newCvModule, Provider<ButtonItemPresenter> provider) {
        return new NewCvModule_ProvideButtonBlueprintFactory(newCvModule, provider);
    }

    public static ButtonItemBlueprint provideButtonBlueprint(NewCvModule newCvModule, ButtonItemPresenter buttonItemPresenter) {
        return (ButtonItemBlueprint) Preconditions.checkNotNullFromProvides(newCvModule.provideButtonBlueprint(buttonItemPresenter));
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return provideButtonBlueprint(this.a, this.b.get());
    }
}
