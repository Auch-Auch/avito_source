package com.avito.android.delivery.di.module;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemBlueprint;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/delivery/di/module/RdsOrderCancellationBlueprintsModule;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$delivery_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$delivery_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "provideDiffCalculator$delivery_release", "()Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$delivery_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemBlueprint;", "reasonItemBlueprint", "provideItemBinder", "(Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "viewModel", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemPresenter;", "provideReasonItemPresenter", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;)Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemPresenter;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class RdsOrderCancellationBlueprintsModule {
    @NotNull
    public static final RdsOrderCancellationBlueprintsModule INSTANCE = new RdsOrderCancellationBlueprintsModule();

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$delivery_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$delivery_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator$delivery_release() {
        return new SimpleDiffCalculator(new SimpleContentsComparator(), new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder(@NotNull ReasonItemBlueprint reasonItemBlueprint) {
        Intrinsics.checkNotNullParameter(reasonItemBlueprint, "reasonItemBlueprint");
        return new ItemBinder.Builder().registerItem(reasonItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ListUpdateCallback provideListUpdateCallback$delivery_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ReasonItemPresenter provideReasonItemPresenter(@NotNull RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel) {
        Intrinsics.checkNotNullParameter(rdsOrderCancellationReasonsViewModel, "viewModel");
        return new ReasonItemPresenter(rdsOrderCancellationReasonsViewModel.getReasonClickConsumer());
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
