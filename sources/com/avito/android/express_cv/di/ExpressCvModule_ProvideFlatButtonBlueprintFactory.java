package com.avito.android.express_cv.di;

import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideFlatButtonBlueprintFactory implements Factory<FlatButtonBlueprint> {
    public final ExpressCvModule a;
    public final Provider<FlatButtonPresenter> b;

    public ExpressCvModule_ProvideFlatButtonBlueprintFactory(ExpressCvModule expressCvModule, Provider<FlatButtonPresenter> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideFlatButtonBlueprintFactory create(ExpressCvModule expressCvModule, Provider<FlatButtonPresenter> provider) {
        return new ExpressCvModule_ProvideFlatButtonBlueprintFactory(expressCvModule, provider);
    }

    public static FlatButtonBlueprint provideFlatButtonBlueprint(ExpressCvModule expressCvModule, FlatButtonPresenter flatButtonPresenter) {
        return (FlatButtonBlueprint) Preconditions.checkNotNullFromProvides(expressCvModule.provideFlatButtonBlueprint(flatButtonPresenter));
    }

    @Override // javax.inject.Provider
    public FlatButtonBlueprint get() {
        return provideFlatButtonBlueprint(this.a, this.b.get());
    }
}
