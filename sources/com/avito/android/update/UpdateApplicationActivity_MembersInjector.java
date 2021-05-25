package com.avito.android.update;

import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UpdateApplicationActivity_MembersInjector implements MembersInjector<UpdateApplicationActivity> {
    public final Provider<ImplicitIntentFactory> a;
    public final Provider<UpdateApplicationPresenter> b;

    public UpdateApplicationActivity_MembersInjector(Provider<ImplicitIntentFactory> provider, Provider<UpdateApplicationPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<UpdateApplicationActivity> create(Provider<ImplicitIntentFactory> provider, Provider<UpdateApplicationPresenter> provider2) {
        return new UpdateApplicationActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.update.UpdateApplicationActivity.intentFactory")
    public static void injectIntentFactory(UpdateApplicationActivity updateApplicationActivity, ImplicitIntentFactory implicitIntentFactory) {
        updateApplicationActivity.intentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.update.UpdateApplicationActivity.presenter")
    public static void injectPresenter(UpdateApplicationActivity updateApplicationActivity, UpdateApplicationPresenter updateApplicationPresenter) {
        updateApplicationActivity.presenter = updateApplicationPresenter;
    }

    public void injectMembers(UpdateApplicationActivity updateApplicationActivity) {
        injectIntentFactory(updateApplicationActivity, this.a.get());
        injectPresenter(updateApplicationActivity, this.b.get());
    }
}
