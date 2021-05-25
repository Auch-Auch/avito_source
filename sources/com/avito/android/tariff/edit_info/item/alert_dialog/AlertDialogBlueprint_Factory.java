package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AlertDialogBlueprint_Factory implements Factory<AlertDialogBlueprint> {
    public final Provider<AlertDialogPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public AlertDialogBlueprint_Factory(Provider<AlertDialogPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AlertDialogBlueprint_Factory create(Provider<AlertDialogPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new AlertDialogBlueprint_Factory(provider, provider2);
    }

    public static AlertDialogBlueprint newInstance(AlertDialogPresenter alertDialogPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new AlertDialogBlueprint(alertDialogPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AlertDialogBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
