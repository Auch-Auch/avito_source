package com.avito.android.item_legacy.details;

import dagger.internal.Factory;
public final class ItemDetailsSelectResultHandlerImpl_Factory implements Factory<ItemDetailsSelectResultHandlerImpl> {

    public static final class a {
        public static final ItemDetailsSelectResultHandlerImpl_Factory a = new ItemDetailsSelectResultHandlerImpl_Factory();
    }

    public static ItemDetailsSelectResultHandlerImpl_Factory create() {
        return a.a;
    }

    public static ItemDetailsSelectResultHandlerImpl newInstance() {
        return new ItemDetailsSelectResultHandlerImpl();
    }

    @Override // javax.inject.Provider
    public ItemDetailsSelectResultHandlerImpl get() {
        return newInstance();
    }
}
