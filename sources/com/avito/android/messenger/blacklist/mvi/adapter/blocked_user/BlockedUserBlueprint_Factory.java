package com.avito.android.messenger.blacklist.mvi.adapter.blocked_user;

import com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BlockedUserBlueprint_Factory implements Factory<BlockedUserBlueprint> {
    public final Provider<ItemPresenter<? super BlockedUserView, ? super BlacklistItem.BlockedUser>> a;

    public BlockedUserBlueprint_Factory(Provider<ItemPresenter<? super BlockedUserView, ? super BlacklistItem.BlockedUser>> provider) {
        this.a = provider;
    }

    public static BlockedUserBlueprint_Factory create(Provider<ItemPresenter<? super BlockedUserView, ? super BlacklistItem.BlockedUser>> provider) {
        return new BlockedUserBlueprint_Factory(provider);
    }

    public static BlockedUserBlueprint newInstance(ItemPresenter<? super BlockedUserView, ? super BlacklistItem.BlockedUser> itemPresenter) {
        return new BlockedUserBlueprint(itemPresenter);
    }

    @Override // javax.inject.Provider
    public BlockedUserBlueprint get() {
        return newInstance(this.a.get());
    }
}
