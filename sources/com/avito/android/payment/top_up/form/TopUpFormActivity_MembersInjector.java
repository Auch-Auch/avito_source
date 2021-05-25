package com.avito.android.payment.top_up.form;

import com.avito.android.ActivityIntentFactory;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class TopUpFormActivity_MembersInjector implements MembersInjector<TopUpFormActivity> {
    public final Provider<TopUpFormPresenter> a;
    public final Provider<TopUpFormInteractor> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<ActivityIntentFactory> d;

    public TopUpFormActivity_MembersInjector(Provider<TopUpFormPresenter> provider, Provider<TopUpFormInteractor> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<TopUpFormActivity> create(Provider<TopUpFormPresenter> provider, Provider<TopUpFormInteractor> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<ActivityIntentFactory> provider4) {
        return new TopUpFormActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.payment.top_up.form.TopUpFormActivity.adapter")
    public static void injectAdapter(TopUpFormActivity topUpFormActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        topUpFormActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.payment.top_up.form.TopUpFormActivity.intentFactory")
    public static void injectIntentFactory(TopUpFormActivity topUpFormActivity, ActivityIntentFactory activityIntentFactory) {
        topUpFormActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.top_up.form.TopUpFormActivity.interactor")
    public static void injectInteractor(TopUpFormActivity topUpFormActivity, TopUpFormInteractor topUpFormInteractor) {
        topUpFormActivity.interactor = topUpFormInteractor;
    }

    @InjectedFieldSignature("com.avito.android.payment.top_up.form.TopUpFormActivity.presenter")
    public static void injectPresenter(TopUpFormActivity topUpFormActivity, TopUpFormPresenter topUpFormPresenter) {
        topUpFormActivity.presenter = topUpFormPresenter;
    }

    public void injectMembers(TopUpFormActivity topUpFormActivity) {
        injectPresenter(topUpFormActivity, this.a.get());
        injectInteractor(topUpFormActivity, this.b.get());
        injectAdapter(topUpFormActivity, this.c.get());
        injectIntentFactory(topUpFormActivity, this.d.get());
    }
}
