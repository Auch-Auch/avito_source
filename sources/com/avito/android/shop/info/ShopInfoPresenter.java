package com.avito.android.shop.info;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoPresenter;", "Lcom/avito/android/shop/info/ShopInfoViewPresenter;", "Lcom/avito/android/shop/info/ShopInfoView;", "view", "", "attachView", "(Lcom/avito/android/shop/info/ShopInfoView;)V", "detachView", "()V", "Lcom/avito/android/shop/info/ShopInfoRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/info/ShopInfoRouter;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopInfoPresenter extends ShopInfoViewPresenter {
    void attachRouter(@NotNull ShopInfoRouter shopInfoRouter);

    void attachView(@NotNull ShopInfoView shopInfoView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
