package com.avito.android.publish.wizard.di.module;

import com.avito.android.publish.wizard.remote.WizardApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WizardApiModule_ProvideWizardApiFactory implements Factory<WizardApi> {
    public final Provider<RetrofitFactory> a;

    public WizardApiModule_ProvideWizardApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static WizardApiModule_ProvideWizardApiFactory create(Provider<RetrofitFactory> provider) {
        return new WizardApiModule_ProvideWizardApiFactory(provider);
    }

    public static WizardApi provideWizardApi(RetrofitFactory retrofitFactory) {
        return (WizardApi) Preconditions.checkNotNullFromProvides(WizardApiModule.INSTANCE.provideWizardApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public WizardApi get() {
        return provideWizardApi(this.a.get());
    }
}
