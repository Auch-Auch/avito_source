package com.avito.android.shop.write_seller;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WriteSellerActivity_MembersInjector implements MembersInjector<WriteSellerActivity> {
    public final Provider<WriteSellerPresenter> a;

    public WriteSellerActivity_MembersInjector(Provider<WriteSellerPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<WriteSellerActivity> create(Provider<WriteSellerPresenter> provider) {
        return new WriteSellerActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.shop.write_seller.WriteSellerActivity.presenter")
    public static void injectPresenter(WriteSellerActivity writeSellerActivity, WriteSellerPresenter writeSellerPresenter) {
        writeSellerActivity.presenter = writeSellerPresenter;
    }

    public void injectMembers(WriteSellerActivity writeSellerActivity) {
        injectPresenter(writeSellerActivity, this.a.get());
    }
}
