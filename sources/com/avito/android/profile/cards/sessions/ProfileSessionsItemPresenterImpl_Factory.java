package com.avito.android.profile.cards.sessions;

import com.avito.android.deep_linking.links.DeepLink;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class ProfileSessionsItemPresenterImpl_Factory implements Factory<ProfileSessionsItemPresenterImpl> {
    public final Provider<Consumer<DeepLink>> a;

    public ProfileSessionsItemPresenterImpl_Factory(Provider<Consumer<DeepLink>> provider) {
        this.a = provider;
    }

    public static ProfileSessionsItemPresenterImpl_Factory create(Provider<Consumer<DeepLink>> provider) {
        return new ProfileSessionsItemPresenterImpl_Factory(provider);
    }

    public static ProfileSessionsItemPresenterImpl newInstance(Consumer<DeepLink> consumer) {
        return new ProfileSessionsItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ProfileSessionsItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
