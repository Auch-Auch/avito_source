package com.avito.android.cart.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.di.deps.CartSummaryDependencies;
import com.avito.android.cart.di.module.CartSummaryBlueprintsModule;
import com.avito.android.cart.di.module.CartSummaryModule;
import com.avito.android.cart.di.module.CartSummaryTrackerModule;
import com.avito.android.cart.summary.CartSummaryFragment;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.di.PerFragment;
import com.facebook.common.util.UriUtil;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/cart/di/component/CartSummaryComponent;", "", "Lcom/avito/android/cart/summary/CartSummaryFragment;", "fragment", "", "inject", "(Lcom/avito/android/cart/summary/CartSummaryFragment;)V", "Factory", "cart_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CartSummaryDependencies.class}, modules = {CartSummaryModule.class, CartSummaryBlueprintsModule.class, CartSummaryTrackerModule.class})
@PerFragment
public interface CartSummaryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J§\u0001\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u001e\b\u0001\u0010\u000b\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006j\u0002`\n2\u0012\b\u0001\u0010\r\u001a\f\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\f2\u0012\b\u0001\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u000e0\u0006j\u0002`\u000f2\u0012\b\u0001\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u00112\u001e\b\u0001\u0010\u0015\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00070\u0006j\u0002`\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/cart/di/component/CartSummaryComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/res/Resources;", UriUtil.LOCAL_RESOURCE_SCHEME, "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lkotlin/Pair;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "", "Lcom/avito/android/cart/summary/QuantityChangesRelay;", "productQuantityRelay", "Lcom/avito/android/cart/summary/DeleteItemRelay;", "deleteItemRelay", "", "Lcom/avito/android/cart/summary/OpenAdvertDetailsRelay;", "openAdvertDetailsRelay", "Lcom/avito/android/cart/summary/HideSwipeLayoutRelay;", "hideSwipeLayoutRelay", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageRelay;", "stepperUsageRelay", "Lcom/avito/android/cart/di/deps/CartSummaryDependencies;", "dependencies", "Lcom/avito/android/cart/di/component/CartSummaryComponent;", "create", "(Landroidx/fragment/app/Fragment;Landroid/content/res/Resources;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/avito/android/cart/di/deps/CartSummaryDependencies;)Lcom/avito/android/cart/di/component/CartSummaryComponent;", "cart_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        CartSummaryComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull PublishRelay<Pair<ProductItem, Integer>> publishRelay, @BindsInstance @NotNull PublishRelay<ProductItem> publishRelay2, @BindsInstance @NotNull PublishRelay<String> publishRelay3, @BindsInstance @NotNull PublishRelay<Integer> publishRelay4, @BindsInstance @NotNull PublishRelay<Pair<ProductItem, StepperUsageType>> publishRelay5, @NotNull CartSummaryDependencies cartSummaryDependencies);
    }

    void inject(@NotNull CartSummaryFragment cartSummaryFragment);
}
