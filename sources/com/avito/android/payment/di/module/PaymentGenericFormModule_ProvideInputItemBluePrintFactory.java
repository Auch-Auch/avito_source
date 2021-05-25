package com.avito.android.payment.di.module;

import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideInputItemBluePrintFactory implements Factory<InputItemBlueprint> {
    public final PaymentGenericFormModule a;
    public final Provider<InputItemPresenter> b;

    public PaymentGenericFormModule_ProvideInputItemBluePrintFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<InputItemPresenter> provider) {
        this.a = paymentGenericFormModule;
        this.b = provider;
    }

    public static PaymentGenericFormModule_ProvideInputItemBluePrintFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<InputItemPresenter> provider) {
        return new PaymentGenericFormModule_ProvideInputItemBluePrintFactory(paymentGenericFormModule, provider);
    }

    public static InputItemBlueprint provideInputItemBluePrint(PaymentGenericFormModule paymentGenericFormModule, InputItemPresenter inputItemPresenter) {
        return (InputItemBlueprint) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideInputItemBluePrint(inputItemPresenter));
    }

    @Override // javax.inject.Provider
    public InputItemBlueprint get() {
        return provideInputItemBluePrint(this.a, this.b.get());
    }
}
