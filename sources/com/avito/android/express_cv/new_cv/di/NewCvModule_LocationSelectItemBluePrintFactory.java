package com.avito.android.express_cv.new_cv.di;

import com.avito.android.blueprints.publish.SelectItemBlueprint;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_LocationSelectItemBluePrintFactory implements Factory<SelectItemBlueprint> {
    public final NewCvModule a;
    public final Provider<SelectItemPresenter> b;

    public NewCvModule_LocationSelectItemBluePrintFactory(NewCvModule newCvModule, Provider<SelectItemPresenter> provider) {
        this.a = newCvModule;
        this.b = provider;
    }

    public static NewCvModule_LocationSelectItemBluePrintFactory create(NewCvModule newCvModule, Provider<SelectItemPresenter> provider) {
        return new NewCvModule_LocationSelectItemBluePrintFactory(newCvModule, provider);
    }

    public static SelectItemBlueprint locationSelectItemBluePrint(NewCvModule newCvModule, SelectItemPresenter selectItemPresenter) {
        return (SelectItemBlueprint) Preconditions.checkNotNullFromProvides(newCvModule.locationSelectItemBluePrint(selectItemPresenter));
    }

    @Override // javax.inject.Provider
    public SelectItemBlueprint get() {
        return locationSelectItemBluePrint(this.a, this.b.get());
    }
}
