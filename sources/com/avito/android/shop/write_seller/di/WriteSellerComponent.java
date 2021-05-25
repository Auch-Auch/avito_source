package com.avito.android.shop.write_seller.di;

import com.avito.android.di.PerActivity;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.write_seller.WriteSellerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/write_seller/di/WriteSellerComponent;", "", "Lcom/avito/android/shop/write_seller/WriteSellerActivity;", "activity", "", "inject", "(Lcom/avito/android/shop/write_seller/WriteSellerActivity;)V", "Builder", "shop_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopDetailedDependencies.class}, modules = {WriteSellerModule.class})
@PerActivity
public interface WriteSellerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/shop/write_seller/di/WriteSellerComponent$Builder;", "", "Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;", "shopDetailedDependencies", "(Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;)Lcom/avito/android/shop/write_seller/di/WriteSellerComponent$Builder;", "Lcom/avito/android/shop/write_seller/di/WriteSellerModule;", "writeSellerModule", "(Lcom/avito/android/shop/write_seller/di/WriteSellerModule;)Lcom/avito/android/shop/write_seller/di/WriteSellerComponent$Builder;", "Lcom/avito/android/shop/write_seller/di/WriteSellerComponent;", "build", "()Lcom/avito/android/shop/write_seller/di/WriteSellerComponent;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        WriteSellerComponent build();

        @NotNull
        Builder shopDetailedDependencies(@NotNull ShopDetailedDependencies shopDetailedDependencies);

        @NotNull
        Builder writeSellerModule(@NotNull WriteSellerModule writeSellerModule);
    }

    void inject(@NotNull WriteSellerActivity writeSellerActivity);
}
