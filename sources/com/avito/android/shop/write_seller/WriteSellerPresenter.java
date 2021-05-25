package com.avito.android.shop.write_seller;

import android.os.Bundle;
import com.avito.android.shop.write_seller.WriteSellerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "Lcom/avito/android/shop/write_seller/WriteSellerView$Callback;", "Lcom/avito/android/shop/write_seller/WriteSellerView;", "view", "", "attachView", "(Lcom/avito/android/shop/write_seller/WriteSellerView;)V", "detachView", "()V", "Lcom/avito/android/shop/write_seller/WriteSellerRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/write_seller/WriteSellerRouter;)V", "detachRouter", "Landroid/os/Bundle;", "state", "onSaveState", "(Landroid/os/Bundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface WriteSellerPresenter extends WriteSellerView.Callback {
    void attachRouter(@NotNull WriteSellerRouter writeSellerRouter);

    void attachView(@NotNull WriteSellerView writeSellerView);

    void detachRouter();

    void detachView();

    void onSaveState(@NotNull Bundle bundle);
}
