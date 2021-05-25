package com.avito.android.shop.list.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.floating_views.FloatingViewsPresenterState;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.list.ShopListFragment;
import com.avito.android.shop.list.di.ShopListModule;
import com.avito.android.util.Constants;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListComponent;", "", "Lcom/avito/android/shop/list/ShopListFragment;", "shopListFragment", "", "inject", "(Lcom/avito/android/shop/list/ShopListFragment;)V", "Builder", "shop_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopDetailedDependencies.class, LocationDependencies.class}, modules = {ShopListModule.class})
@PerFragment
public interface ShopListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00002\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u00002\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0018H'¢\u0006\u0004\b\u001d\u0010\u001bJ\u001b\u0010 \u001a\u00020\u00002\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "", "Lcom/avito/android/location/di/LocationDependencies;", "dependencies", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;", "shopDetailedDependencies", "(Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Lcom/avito/android/shop/list/di/ShopListModule;", "shopListModule", "(Lcom/avito/android/shop/list/di/ShopListModule;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParams", "withSearchParams", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "", Constants.LOCATION_NAME, "withLocationName", "(Ljava/lang/String;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "interactorState", "withInteractorState", "Landroid/os/Bundle;", "floatingViewsState", "withFloatingViewState", "(Landroid/os/Bundle;)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "", "spanCount", "withSpanCount", "(I)Lcom/avito/android/shop/list/di/ShopListComponent$Builder;", "Lcom/avito/android/shop/list/di/ShopListComponent;", "build", "()Lcom/avito/android/shop/list/di/ShopListComponent;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ShopListComponent build();

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @NotNull
        Builder shopDetailedDependencies(@NotNull ShopDetailedDependencies shopDetailedDependencies);

        @NotNull
        Builder shopListModule(@NotNull ShopListModule shopListModule);

        @BindsInstance
        @NotNull
        Builder withFloatingViewState(@FloatingViewsPresenterState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withInteractorState(@ShopListModule.InteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withLocationName(@Nullable String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@ShopListModule.PresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSearchParams(@NotNull ShopsSearchParameters shopsSearchParameters);

        @BindsInstance
        @NotNull
        Builder withSpanCount(int i);
    }

    void inject(@NotNull ShopListFragment shopListFragment);
}
