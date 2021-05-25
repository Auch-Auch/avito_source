package com.avito.android.profile_phones.phone_management;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneManagementInteractorImpl_Factory implements Factory<PhoneManagementInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<CodeConfirmationInteractor> b;
    public final Provider<SchedulersFactory> c;

    public PhoneManagementInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<CodeConfirmationInteractor> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PhoneManagementInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<CodeConfirmationInteractor> provider2, Provider<SchedulersFactory> provider3) {
        return new PhoneManagementInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static PhoneManagementInteractorImpl newInstance(ProfileApi profileApi, CodeConfirmationInteractor codeConfirmationInteractor, SchedulersFactory schedulersFactory) {
        return new PhoneManagementInteractorImpl(profileApi, codeConfirmationInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public PhoneManagementInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
