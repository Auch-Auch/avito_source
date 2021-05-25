package com.avito.android.user_subscribers;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.user_subscribers.action.SubscriberAction;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class UserSubscribersPresenterImpl_Factory implements Factory<UserSubscribersPresenterImpl> {
    public final Provider<UserSubscribersInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Observable<SubscriberAction>> c;
    public final Provider<ErrorHelper> d;
    public final Provider<Kundle> e;

    public UserSubscribersPresenterImpl_Factory(Provider<UserSubscribersInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Observable<SubscriberAction>> provider3, Provider<ErrorHelper> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static UserSubscribersPresenterImpl_Factory create(Provider<UserSubscribersInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Observable<SubscriberAction>> provider3, Provider<ErrorHelper> provider4, Provider<Kundle> provider5) {
        return new UserSubscribersPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserSubscribersPresenterImpl newInstance(UserSubscribersInteractor userSubscribersInteractor, SchedulersFactory schedulersFactory, Observable<SubscriberAction> observable, ErrorHelper errorHelper, Kundle kundle) {
        return new UserSubscribersPresenterImpl(userSubscribersInteractor, schedulersFactory, observable, errorHelper, kundle);
    }

    @Override // javax.inject.Provider
    public UserSubscribersPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
