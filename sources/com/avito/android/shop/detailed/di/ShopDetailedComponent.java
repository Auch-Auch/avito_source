package com.avito.android.shop.detailed.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.PerFragment;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.shop.detailed.ShopDetailedFragment;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedComponent;", "", "Lcom/avito/android/shop/detailed/ShopDetailedFragment;", "fragment", "", "inject", "(Lcom/avito/android/shop/detailed/ShopDetailedFragment;)V", "Factory", "shop_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopDetailedDependencies.class}, modules = {ShopDetailedModule.class, ShopDetailedTrackerModule.class, CompositeSnackbarModule.class})
@PerFragment
public interface ShopDetailedComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0001\u0010\u001a\u001a\u00020\u00192\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedComponent$Factory;", "", "", "shopId", "pageFrom", "shopContext", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/util/Kundle;", "interactorState", "presenterState", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroidx/lifecycle/MutableLiveData;", "makeCallStream", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;", "shopDetailedDependencies", "Lcom/avito/android/shop/detailed/di/ShopDetailedModule;", "shopDetailedModule", "Lcom/avito/android/shop/detailed/di/ShopDetailedComponent;", "create", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Landroidx/lifecycle/MutableLiveData;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;Lcom/avito/android/shop/detailed/di/ShopDetailedDependencies;Lcom/avito/android/shop/detailed/di/ShopDetailedModule;)Lcom/avito/android/shop/detailed/di/ShopDetailedComponent;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ShopDetailedComponent create(@BindsInstance @ShopDetailedModule.ShopId @NotNull String str, @BindsInstance @ShopDetailedModule.PageFrom @Nullable String str2, @BindsInstance @ShopDetailedModule.ShopContext @Nullable String str3, @BindsInstance @ShopDetailedModule.SearchParams @NotNull SearchParams searchParams, @ShopDetailedModule.InteractorState @BindsInstance @Nullable Kundle kundle, @BindsInstance @ShopDetailedModule.PresenterState @Nullable Kundle kundle2, @BindsInstance @Nullable TreeClickStreamParent treeClickStreamParent, @BindsInstance @NotNull MutableLiveData<String> mutableLiveData, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @Nullable SerpOnboardingHandler serpOnboardingHandler, @NotNull ShopDetailedDependencies shopDetailedDependencies, @NotNull ShopDetailedModule shopDetailedModule);
    }

    void inject(@NotNull ShopDetailedFragment shopDetailedFragment);
}
