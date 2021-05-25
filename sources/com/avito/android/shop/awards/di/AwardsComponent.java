package com.avito.android.shop.awards.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.AwardsActivity;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/awards/di/AwardsComponent;", "", "Lcom/avito/android/shop/awards/AwardsActivity;", "activity", "", "inject", "(Lcom/avito/android/shop/awards/AwardsActivity;)V", "Factory", "shop_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopDetailedDependencies.class}, modules = {AwardsModule.class})
@PerActivity
public interface AwardsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/shop/awards/di/AwardsComponent$Factory;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;", "dependencies", "Lcom/avito/android/shop/awards/di/AwardsComponent;", "create", "(Landroid/content/res/Resources;Lcom/avito/android/remote/model/SellerVerification$AwardsItem;Lcom/avito/android/util/Kundle;Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;)Lcom/avito/android/shop/awards/di/AwardsComponent;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        AwardsComponent create(@BindsInstance @NotNull Resources resources, @BindsInstance @NotNull SellerVerification.AwardsItem awardsItem, @BindsInstance @Nullable Kundle kundle, @NotNull ShopDetailedDependencies shopDetailedDependencies);
    }

    void inject(@NotNull AwardsActivity awardsActivity);
}
