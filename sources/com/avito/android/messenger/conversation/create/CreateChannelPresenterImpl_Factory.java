package com.avito.android.messenger.conversation.create;

import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreateChannelPresenterImpl_Factory implements Factory<CreateChannelPresenterImpl> {
    public final Provider<CreateChannelInteractor> a;
    public final Provider<CreateChannelPresenter.State> b;
    public final Provider<SchedulersFactory> c;

    public CreateChannelPresenterImpl_Factory(Provider<CreateChannelInteractor> provider, Provider<CreateChannelPresenter.State> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CreateChannelPresenterImpl_Factory create(Provider<CreateChannelInteractor> provider, Provider<CreateChannelPresenter.State> provider2, Provider<SchedulersFactory> provider3) {
        return new CreateChannelPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static CreateChannelPresenterImpl newInstance(CreateChannelInteractor createChannelInteractor, CreateChannelPresenter.State state, SchedulersFactory schedulersFactory) {
        return new CreateChannelPresenterImpl(createChannelInteractor, state, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CreateChannelPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
