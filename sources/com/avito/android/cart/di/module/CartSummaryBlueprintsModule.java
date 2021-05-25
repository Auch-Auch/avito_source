package com.avito.android.cart.di.module;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.cart.summary.konveyor.decoration.HeaderItemDecoration;
import com.avito.android.cart.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.cart.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemBlueprint;
import com.avito.android.cart.summary.konveyor.price.PriceItemBlueprint;
import com.avito.android.cart.summary.konveyor.product.ProductItemBlueprint;
import com.avito.android.cart.summary.konveyor.text.TextItemBlueprint;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/cart/di/module/CartSummaryBlueprintsModule;", "", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDiffCalculator", "()Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Deps", "cart_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, AttributedTextFormatterModule.class, Deps.class})
public final class CartSummaryBlueprintsModule {
    @NotNull
    public static final CartSummaryBlueprintsModule INSTANCE = new CartSummaryBlueprintsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0018H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/cart/di/module/CartSummaryBlueprintsModule$Deps;", "", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindProductItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/product/ProductItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/header/HeaderItemBlueprint;", "bindHeaderItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/header/HeaderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/header/store/StoreHeaderItemBlueprint;", "bindStoreHeaderItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/header/store/StoreHeaderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/price/PriceItemBlueprint;", "bindPriceItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/price/PriceItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/text/TextItemBlueprint;", "bindTextItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/text/TextItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/divider/DividerItemBlueprint;", "bindDividerItemBlueprint", "(Lcom/avito/android/cart/summary/konveyor/divider/DividerItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/decoration/HeaderItemDecoration;", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "bindHeaderItemDecoration", "(Lcom/avito/android/cart/summary/konveyor/decoration/HeaderItemDecoration;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "cart_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Deps {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindDividerItemBlueprint(@NotNull DividerItemBlueprint dividerItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindHeaderItemBlueprint(@NotNull HeaderItemBlueprint headerItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        RecyclerView.ItemDecoration bindHeaderItemDecoration(@NotNull HeaderItemDecoration headerItemDecoration);

        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback bindListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindPriceItemBlueprint(@NotNull PriceItemBlueprint priceItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindProductItemBlueprint(@NotNull ProductItemBlueprint productItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindStoreHeaderItemBlueprint(@NotNull StoreHeaderItemBlueprint storeHeaderItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindTextItemBlueprint(@NotNull TextItemBlueprint textItemBlueprint);
    }

    @Provides
    @NotNull
    @PerFragment
    public final DataAwareAdapterPresenter provideDataAwareAdapterPresenter(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator() {
        return new SimpleDiffCalculator(new SimpleContentsComparator(), null, false, null, 14, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleRecyclerAdapter(dataAwareAdapterPresenter, itemBinder);
    }
}
