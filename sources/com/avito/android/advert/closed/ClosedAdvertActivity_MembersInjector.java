package com.avito.android.advert.closed;

import com.avito.android.Features;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ClosedAdvertActivity_MembersInjector implements MembersInjector<ClosedAdvertActivity> {
    public final Provider<ClosedAdvertPresenter> a;
    public final Provider<Features> b;

    public ClosedAdvertActivity_MembersInjector(Provider<ClosedAdvertPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<ClosedAdvertActivity> create(Provider<ClosedAdvertPresenter> provider, Provider<Features> provider2) {
        return new ClosedAdvertActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.advert.closed.ClosedAdvertActivity.features")
    public static void injectFeatures(ClosedAdvertActivity closedAdvertActivity, Features features) {
        closedAdvertActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.advert.closed.ClosedAdvertActivity.presenter")
    public static void injectPresenter(ClosedAdvertActivity closedAdvertActivity, ClosedAdvertPresenter closedAdvertPresenter) {
        closedAdvertActivity.presenter = closedAdvertPresenter;
    }

    public void injectMembers(ClosedAdvertActivity closedAdvertActivity) {
        injectPresenter(closedAdvertActivity, this.a.get());
        injectFeatures(closedAdvertActivity, this.b.get());
    }
}
