package com.avito.android.cart.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.summary.CartSummaryRepository;
import com.avito.android.cart.summary.CartSummaryRepositoryImpl;
import com.avito.android.cart.summary.CartSummaryViewModel;
import com.avito.android.cart.summary.CartSummaryViewModelFactory;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverterImpl;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.PerFragment;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/cart/di/module/CartSummaryModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/cart/summary/CartSummaryViewModelFactory;", "factory", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "provideCartSummaryViewModel$cart_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/cart/summary/CartSummaryViewModelFactory;)Lcom/avito/android/cart/summary/CartSummaryViewModel;", "provideCartSummaryViewModel", "<init>", "()V", "Deps", "cart_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Deps.class})
public final class CartSummaryModule {
    @NotNull
    public static final CartSummaryModule INSTANCE = new CartSummaryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0018\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0016j\u0002`\u00172\u001c\u0010\u0015\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`\u0014H'¢\u0006\u0004\b\u0018\u0010\u0019JC\u0010\u001c\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u001aj\u0002`\u001b2\u001c\u0010\u0015\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`\u0014H'¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\f\u0012\u0004\u0012\u00020\u00120\u0016j\u0002`\u001f2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u001eH'¢\u0006\u0004\b \u0010\u0019J+\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u00120\u001aj\u0002`!2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u001eH'¢\u0006\u0004\b\"\u0010\u001dJ+\u0010&\u001a\f\u0012\u0004\u0012\u00020#0\u0016j\u0002`%2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020#0\u0010j\u0002`$H'¢\u0006\u0004\b&\u0010\u0019J+\u0010(\u001a\f\u0012\u0004\u0012\u00020#0\u001aj\u0002`'2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020#0\u0010j\u0002`$H'¢\u0006\u0004\b(\u0010\u001dJ+\u0010+\u001a\f\u0012\u0004\u0012\u00020\u00130\u0016j\u0002`*2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00130\u0010j\u0002`)H'¢\u0006\u0004\b+\u0010\u0019J+\u0010-\u001a\f\u0012\u0004\u0012\u00020\u00130\u001aj\u0002`,2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00130\u0010j\u0002`)H'¢\u0006\u0004\b-\u0010\u001dJC\u00101\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0\u00110\u0016j\u0002`02\u001c\u0010\u0015\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0\u00110\u0010j\u0002`/H'¢\u0006\u0004\b1\u0010\u0019JC\u00103\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0\u00110\u001aj\u0002`22\u001c\u0010\u0015\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0\u00110\u0010j\u0002`/H'¢\u0006\u0004\b3\u0010\u001d¨\u00064"}, d2 = {"Lcom/avito/android/cart/di/module/CartSummaryModule$Deps;", "", "Lcom/avito/android/cart/summary/CartSummaryRepositoryImpl;", "repository", "Lcom/avito/android/cart/summary/CartSummaryRepository;", "bindCartSummaryRepository", "(Lcom/avito/android/cart/summary/CartSummaryRepositoryImpl;)Lcom/avito/android/cart/summary/CartSummaryRepository;", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverterImpl;", "converter", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "bindCartSummaryItemsConverter", "(Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverterImpl;)Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "bindOnDeepLinkClickListener", "(Lcom/avito/android/cart/summary/CartSummaryViewModel;)Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lkotlin/Pair;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "", "Lcom/avito/android/cart/summary/QuantityChangesRelay;", "relay", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/cart/summary/QuantityChangesConsumer;", "bindQuantityChangesConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/cart/summary/QuantityChangesObservable;", "bindQuantityChangesObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/cart/summary/DeleteItemRelay;", "Lcom/avito/android/cart/summary/DeleteItemConsumer;", "bindDeleteItemConsumer", "Lcom/avito/android/cart/summary/DeleteItemObservable;", "bindDeleteItemObservable", "", "Lcom/avito/android/cart/summary/OpenAdvertDetailsRelay;", "Lcom/avito/android/cart/summary/OpenAdvertDetailsConsumer;", "bindOpenAdvertDetailsConsumer", "Lcom/avito/android/cart/summary/OpenAdvertDetailsObservable;", "bindOpenAdvertDetailsObservable", "Lcom/avito/android/cart/summary/HideSwipeLayoutRelay;", "Lcom/avito/android/cart/summary/HideSwipeLayoutConsumer;", "bindHideSwipeLayoutConsumer", "Lcom/avito/android/cart/summary/HideSwipeLayoutObservable;", "bindHideSwipeLayoutObservable", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageRelay;", "Lcom/avito/android/cart/summary/StepperUsageConsumer;", "bindStepperUsageConsumer", "Lcom/avito/android/cart/summary/StepperUsageObservable;", "bindStepperUsageObservable", "cart_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Deps {
        @PerFragment
        @Binds
        @NotNull
        CartSummaryItemsConverter bindCartSummaryItemsConverter(@NotNull CartSummaryItemsConverterImpl cartSummaryItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        CartSummaryRepository bindCartSummaryRepository(@NotNull CartSummaryRepositoryImpl cartSummaryRepositoryImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<ProductItem> bindDeleteItemConsumer(@NotNull PublishRelay<ProductItem> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<ProductItem> bindDeleteItemObservable(@NotNull PublishRelay<ProductItem> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Consumer<Integer> bindHideSwipeLayoutConsumer(@NotNull PublishRelay<Integer> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<Integer> bindHideSwipeLayoutObservable(@NotNull PublishRelay<Integer> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        OnDeepLinkClickListener bindOnDeepLinkClickListener(@NotNull CartSummaryViewModel cartSummaryViewModel);

        @Binds
        @NotNull
        @PerFragment
        Consumer<String> bindOpenAdvertDetailsConsumer(@NotNull PublishRelay<String> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<String> bindOpenAdvertDetailsObservable(@NotNull PublishRelay<String> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Consumer<Pair<ProductItem, Integer>> bindQuantityChangesConsumer(@NotNull PublishRelay<Pair<ProductItem, Integer>> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<Pair<ProductItem, Integer>> bindQuantityChangesObservable(@NotNull PublishRelay<Pair<ProductItem, Integer>> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Consumer<Pair<ProductItem, StepperUsageType>> bindStepperUsageConsumer(@NotNull PublishRelay<Pair<ProductItem, StepperUsageType>> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<Pair<ProductItem, StepperUsageType>> bindStepperUsageObservable(@NotNull PublishRelay<Pair<ProductItem, StepperUsageType>> publishRelay);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CartSummaryViewModel provideCartSummaryViewModel$cart_release(@NotNull Fragment fragment, @NotNull CartSummaryViewModelFactory cartSummaryViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cartSummaryViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragment, cartSummaryViewModelFactory).get(CartSummaryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return (CartSummaryViewModel) viewModel;
    }
}
