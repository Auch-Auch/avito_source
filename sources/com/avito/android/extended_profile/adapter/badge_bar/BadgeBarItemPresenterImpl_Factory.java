package com.avito.android.extended_profile.adapter.badge_bar;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class BadgeBarItemPresenterImpl_Factory implements Factory<BadgeBarItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public BadgeBarItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static BadgeBarItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new BadgeBarItemPresenterImpl_Factory(provider);
    }

    public static BadgeBarItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new BadgeBarItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public BadgeBarItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
