package com.avito.android.delivery.di.module;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel;
import com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemBlueprint;
import com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemPresenter;
import com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemBlueprint;
import com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemPresenter;
import com.avito.android.delivery.order_cancellation.details.konveyor.title.TitleItemBlueprint;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b+\u0010,J-\u0010\f\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010 \u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b$\u0010%J\u0017\u0010*\u001a\u00020'2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/delivery/di/module/ReasonDetailsBlueprintsModule;", "", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$delivery_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "provideDiffCalculator$delivery_release", "()Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$delivery_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/title/TitleItemBlueprint;", "titleItemBlueprint", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemBlueprint;", "radioGroupItemBlueprint", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemBlueprint;", "inputItemBlueprint", "provideItemBinder$delivery_release", "(Lcom/avito/android/delivery/order_cancellation/details/konveyor/title/TitleItemBlueprint;Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemBlueprint;Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "viewModel", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemPresenter;", "provideRadioGroupItemPresenter$delivery_release", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;)Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemPresenter;", "provideRadioGroupItemPresenter", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemPresenter;", "provideInputItemPresenter$delivery_release", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;)Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemPresenter;", "provideInputItemPresenter", "<init>", "()V", "Declarations", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ReasonDetailsBlueprintsModule {
    @NotNull
    public static final ReasonDetailsBlueprintsModule INSTANCE = new ReasonDetailsBlueprintsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/delivery/di/module/ReasonDetailsBlueprintsModule$Declarations;", "", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback bindListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$delivery_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$delivery_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator$delivery_release() {
        return new SimpleDiffCalculator(new SimpleContentsComparator(), null, true, null, 10, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final InputItemPresenter provideInputItemPresenter$delivery_release(@NotNull ReasonDetailsViewModel reasonDetailsViewModel) {
        Intrinsics.checkNotNullParameter(reasonDetailsViewModel, "viewModel");
        return new InputItemPresenter(reasonDetailsViewModel.getCommentChangesConsumer());
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$delivery_release(@NotNull TitleItemBlueprint titleItemBlueprint, @NotNull RadioGroupItemBlueprint radioGroupItemBlueprint, @NotNull InputItemBlueprint inputItemBlueprint) {
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        Intrinsics.checkNotNullParameter(radioGroupItemBlueprint, "radioGroupItemBlueprint");
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        return new ItemBinder.Builder().registerItem(titleItemBlueprint).registerItem(radioGroupItemBlueprint).registerItem(inputItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final RadioGroupItemPresenter provideRadioGroupItemPresenter$delivery_release(@NotNull ReasonDetailsViewModel reasonDetailsViewModel) {
        Intrinsics.checkNotNullParameter(reasonDetailsViewModel, "viewModel");
        return new RadioGroupItemPresenter(reasonDetailsViewModel.getRadioGroupChangesConsumer(), reasonDetailsViewModel.getSelectedRadioButtonId());
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
