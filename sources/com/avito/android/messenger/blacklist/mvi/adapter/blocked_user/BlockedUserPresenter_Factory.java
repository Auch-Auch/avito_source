package com.avito.android.messenger.blacklist.mvi.adapter.blocked_user;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BlockedUserPresenter_Factory implements Factory<BlockedUserPresenter> {
    public final Provider<UnblockClickListener> a;

    public BlockedUserPresenter_Factory(Provider<UnblockClickListener> provider) {
        this.a = provider;
    }

    public static BlockedUserPresenter_Factory create(Provider<UnblockClickListener> provider) {
        return new BlockedUserPresenter_Factory(provider);
    }

    public static BlockedUserPresenter newInstance(Lazy<UnblockClickListener> lazy) {
        return new BlockedUserPresenter(lazy);
    }

    @Override // javax.inject.Provider
    public BlockedUserPresenter get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
