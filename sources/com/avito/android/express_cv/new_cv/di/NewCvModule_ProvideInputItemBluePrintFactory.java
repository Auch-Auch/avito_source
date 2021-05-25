package com.avito.android.express_cv.new_cv.di;

import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_ProvideInputItemBluePrintFactory implements Factory<InputItemBlueprint> {
    public final NewCvModule a;
    public final Provider<InputItemPresenter> b;

    public NewCvModule_ProvideInputItemBluePrintFactory(NewCvModule newCvModule, Provider<InputItemPresenter> provider) {
        this.a = newCvModule;
        this.b = provider;
    }

    public static NewCvModule_ProvideInputItemBluePrintFactory create(NewCvModule newCvModule, Provider<InputItemPresenter> provider) {
        return new NewCvModule_ProvideInputItemBluePrintFactory(newCvModule, provider);
    }

    public static InputItemBlueprint provideInputItemBluePrint(NewCvModule newCvModule, InputItemPresenter inputItemPresenter) {
        return (InputItemBlueprint) Preconditions.checkNotNullFromProvides(newCvModule.provideInputItemBluePrint(inputItemPresenter));
    }

    @Override // javax.inject.Provider
    public InputItemBlueprint get() {
        return provideInputItemBluePrint(this.a, this.b.get());
    }
}
