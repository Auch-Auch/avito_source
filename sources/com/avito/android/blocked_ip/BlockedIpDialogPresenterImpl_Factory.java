package com.avito.android.blocked_ip;

import dagger.internal.Factory;
public final class BlockedIpDialogPresenterImpl_Factory implements Factory<BlockedIpDialogPresenterImpl> {

    public static final class a {
        public static final BlockedIpDialogPresenterImpl_Factory a = new BlockedIpDialogPresenterImpl_Factory();
    }

    public static BlockedIpDialogPresenterImpl_Factory create() {
        return a.a;
    }

    public static BlockedIpDialogPresenterImpl newInstance() {
        return new BlockedIpDialogPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BlockedIpDialogPresenterImpl get() {
        return newInstance();
    }
}
