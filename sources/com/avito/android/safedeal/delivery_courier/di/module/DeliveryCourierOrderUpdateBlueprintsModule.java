package com.avito.android.safedeal.delivery_courier.di.module;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierContentsComparator;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemPresenter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemPresenter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010CJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010+\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b)\u0010*J\u0017\u00100\u001a\u00020'2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u000f\u00103\u001a\u00020,H\u0001¢\u0006\u0004\b1\u00102J\u0017\u00109\u001a\u0002062\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b7\u00108J\u0017\u0010=\u001a\u00020:2\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b;\u0010<J\u000f\u0010A\u001a\u00020>H\u0001¢\u0006\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierOrderUpdateBlueprintsModule;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$safedeal_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierContentsComparator;", "contentsComparator", "provideDiffCalculator$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideDeliveryCourierContentsComparator$safedeal_release", "()Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierContentsComparator;", "provideDeliveryCourierContentsComparator", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$safedeal_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter$safedeal_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "provideAdapterPresenter$safedeal_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemBlueprint;", "inputItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/select/SelectItemBlueprint;", "selectItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/text/TextItemBlueprint;", "textItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemBlueprint;", "headerItemBlueprint", "provideItemBinder$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/select/SelectItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/text/TextItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemPresenter;", "presenter", "provideHeaderItemBluePrint$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemPresenter;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemBlueprint;", "provideHeaderItemBluePrint", "provideHeaderItemPresenter$safedeal_release", "()Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemPresenter;", "provideHeaderItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/select/SelectItemPresenter;", "provideSelectItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;)Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/select/SelectItemPresenter;", "provideSelectItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemPresenter;", "provideInputItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;)Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemPresenter;", "provideInputItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/text/TextItemPresenter;", "provideTextItemPresenter$safedeal_release", "()Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/text/TextItemPresenter;", "provideTextItemPresenter", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DeliveryCourierOrderUpdateBlueprintsModule {
    @NotNull
    public static final DeliveryCourierOrderUpdateBlueprintsModule INSTANCE = new DeliveryCourierOrderUpdateBlueprintsModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$safedeal_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$safedeal_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierContentsComparator provideDeliveryCourierContentsComparator$safedeal_release() {
        return new DeliveryCourierContentsComparator();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator$safedeal_release(@NotNull DeliveryCourierContentsComparator deliveryCourierContentsComparator) {
        Intrinsics.checkNotNullParameter(deliveryCourierContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(deliveryCourierContentsComparator, null, true, null, 10, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final HeaderItemBlueprint provideHeaderItemBluePrint$safedeal_release(@NotNull HeaderItemPresenter headerItemPresenter) {
        Intrinsics.checkNotNullParameter(headerItemPresenter, "presenter");
        return new HeaderItemBlueprint(headerItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final HeaderItemPresenter provideHeaderItemPresenter$safedeal_release() {
        return new HeaderItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final InputItemPresenter provideInputItemPresenter$safedeal_release(@NotNull DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateViewModel, "viewModel");
        return new InputItemPresenterImpl(deliveryCourierOrderUpdateViewModel.getTextChangesConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$safedeal_release(@NotNull InputItemBlueprint inputItemBlueprint, @NotNull SelectItemBlueprint selectItemBlueprint, @NotNull TextItemBlueprint textItemBlueprint, @NotNull HeaderItemBlueprint headerItemBlueprint) {
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(selectItemBlueprint, "selectItemBlueprint");
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        Intrinsics.checkNotNullParameter(headerItemBlueprint, "headerItemBlueprint");
        return new ItemBinder.Builder().registerItem(inputItemBlueprint).registerItem(selectItemBlueprint).registerItem(textItemBlueprint).registerItem(headerItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListUpdateCallback provideListUpdateCallback$safedeal_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter$safedeal_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemPresenter provideSelectItemPresenter$safedeal_release(@NotNull DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateViewModel, "viewModel");
        return new SelectItemPresenterImpl(deliveryCourierOrderUpdateViewModel.getSelectDeepLinkClickConsumer(), deliveryCourierOrderUpdateViewModel.getTextChangesConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TextItemPresenter provideTextItemPresenter$safedeal_release() {
        return new TextItemPresenterImpl();
    }
}
