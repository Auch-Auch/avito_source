package com.avito.android.authorization.start_registration;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StartRegistrationInteractorImpl_Factory implements Factory<StartRegistrationInteractorImpl> {
    public final Provider<CodeConfirmationInteractor> a;

    public StartRegistrationInteractorImpl_Factory(Provider<CodeConfirmationInteractor> provider) {
        this.a = provider;
    }

    public static StartRegistrationInteractorImpl_Factory create(Provider<CodeConfirmationInteractor> provider) {
        return new StartRegistrationInteractorImpl_Factory(provider);
    }

    public static StartRegistrationInteractorImpl newInstance(CodeConfirmationInteractor codeConfirmationInteractor) {
        return new StartRegistrationInteractorImpl(codeConfirmationInteractor);
    }

    @Override // javax.inject.Provider
    public StartRegistrationInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
