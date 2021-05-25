package com.avito.android.shop.filter.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.filter.ShopsFilterFragment;
import com.avito.android.shop.filter.di.ShopsFilterModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterComponent;", "", "Lcom/avito/android/shop/filter/ShopsFilterFragment;", "fragment", "", "inject", "(Lcom/avito/android/shop/filter/ShopsFilterFragment;)V", "Builder", "shop_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopDetailedDependencies.class, LocationDependencies.class}, modules = {ShopsFilterModule.class})
@PerFragment
public interface ShopsFilterComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "", "Lcom/avito/android/location/di/LocationDependencies;", "dependencies", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;", "shopDetailedDependencies", "(Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "params", "withSearchParams", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Landroid/os/Bundle;", "state", "withPresenterState", "(Landroid/os/Bundle;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Lcom/avito/android/shop/filter/di/ShopsFilterModule;", "shopsFilterModule", "(Lcom/avito/android/shop/filter/di/ShopsFilterModule;)Lcom/avito/android/shop/filter/di/ShopsFilterComponent$Builder;", "Lcom/avito/android/shop/filter/di/ShopsFilterComponent;", "build", "()Lcom/avito/android/shop/filter/di/ShopsFilterComponent;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ShopsFilterComponent build();

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @NotNull
        Builder shopDetailedDependencies(@NotNull ShopDetailedDependencies shopDetailedDependencies);

        @BindsInstance
        @NotNull
        Builder shopsFilterModule(@NotNull ShopsFilterModule shopsFilterModule);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@ShopsFilterModule.PresenterState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSearchParams(@ShopsFilterModule.ShopsSearchParams @NotNull ShopsSearchParameters shopsSearchParameters);
    }

    void inject(@NotNull ShopsFilterFragment shopsFilterFragment);
}
