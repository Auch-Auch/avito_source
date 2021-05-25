package com.avito.android.express_cv.existed_cv.di;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExistedCvModule_ProvideButtonBlueprintFactory implements Factory<ButtonItemBlueprint> {
    public final ExistedCvModule a;
    public final Provider<ButtonItemPresenter> b;

    public ExistedCvModule_ProvideButtonBlueprintFactory(ExistedCvModule existedCvModule, Provider<ButtonItemPresenter> provider) {
        this.a = existedCvModule;
        this.b = provider;
    }

    public static ExistedCvModule_ProvideButtonBlueprintFactory create(ExistedCvModule existedCvModule, Provider<ButtonItemPresenter> provider) {
        return new ExistedCvModule_ProvideButtonBlueprintFactory(existedCvModule, provider);
    }

    public static ButtonItemBlueprint provideButtonBlueprint(ExistedCvModule existedCvModule, ButtonItemPresenter buttonItemPresenter) {
        return (ButtonItemBlueprint) Preconditions.checkNotNullFromProvides(existedCvModule.provideButtonBlueprint(buttonItemPresenter));
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return provideButtonBlueprint(this.a, this.b.get());
    }
}
