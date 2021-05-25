package com.avito.android.phone_confirmation;

import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneConfirmationActivity_MembersInjector implements MembersInjector<PhoneConfirmationActivity> {
    public final Provider<PhoneConfirmationInteractor> a;
    public final Provider<PhoneConfirmationRouter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<BuildInfo> d;

    public PhoneConfirmationActivity_MembersInjector(Provider<PhoneConfirmationInteractor> provider, Provider<PhoneConfirmationRouter> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<PhoneConfirmationActivity> create(Provider<PhoneConfirmationInteractor> provider, Provider<PhoneConfirmationRouter> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        return new PhoneConfirmationActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.phone_confirmation.PhoneConfirmationActivity.build")
    public static void injectBuild(PhoneConfirmationActivity phoneConfirmationActivity, BuildInfo buildInfo) {
        phoneConfirmationActivity.build = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.phone_confirmation.PhoneConfirmationActivity.interactor")
    public static void injectInteractor(PhoneConfirmationActivity phoneConfirmationActivity, PhoneConfirmationInteractor phoneConfirmationInteractor) {
        phoneConfirmationActivity.interactor = phoneConfirmationInteractor;
    }

    @InjectedFieldSignature("com.avito.android.phone_confirmation.PhoneConfirmationActivity.router")
    public static void injectRouter(PhoneConfirmationActivity phoneConfirmationActivity, PhoneConfirmationRouter phoneConfirmationRouter) {
        phoneConfirmationActivity.router = phoneConfirmationRouter;
    }

    @InjectedFieldSignature("com.avito.android.phone_confirmation.PhoneConfirmationActivity.schedulers")
    public static void injectSchedulers(PhoneConfirmationActivity phoneConfirmationActivity, SchedulersFactory schedulersFactory) {
        phoneConfirmationActivity.schedulers = schedulersFactory;
    }

    public void injectMembers(PhoneConfirmationActivity phoneConfirmationActivity) {
        injectInteractor(phoneConfirmationActivity, this.a.get());
        injectRouter(phoneConfirmationActivity, this.b.get());
        injectSchedulers(phoneConfirmationActivity, this.c.get());
        injectBuild(phoneConfirmationActivity, this.d.get());
    }
}
