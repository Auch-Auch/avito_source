package com.avito.android.passport_verification;

import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SumsubVerificationActivity_MembersInjector implements MembersInjector<SumsubVerificationActivity> {
    public final Provider<PassportVerificationModel> a;
    public final Provider<SchedulersFactory3> b;

    public SumsubVerificationActivity_MembersInjector(Provider<PassportVerificationModel> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<SumsubVerificationActivity> create(Provider<PassportVerificationModel> provider, Provider<SchedulersFactory3> provider2) {
        return new SumsubVerificationActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.passport_verification.SumsubVerificationActivity.model")
    public static void injectModel(SumsubVerificationActivity sumsubVerificationActivity, PassportVerificationModel passportVerificationModel) {
        sumsubVerificationActivity.model = passportVerificationModel;
    }

    @InjectedFieldSignature("com.avito.android.passport_verification.SumsubVerificationActivity.schedulers")
    public static void injectSchedulers(SumsubVerificationActivity sumsubVerificationActivity, SchedulersFactory3 schedulersFactory3) {
        sumsubVerificationActivity.schedulers = schedulersFactory3;
    }

    public void injectMembers(SumsubVerificationActivity sumsubVerificationActivity) {
        injectModel(sumsubVerificationActivity, this.a.get());
        injectSchedulers(sumsubVerificationActivity, this.b.get());
    }
}
