package com.avito.android.safedeal.delivery_courier.di.module;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryContentsComparator;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServicesRadioGroupItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemPresenterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItemBlueprint;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bO\u0010PJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJg\u00103\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104J\u0017\u0010:\u001a\u0002072\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109J\u0017\u0010>\u001a\u00020;2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b<\u0010=J\u0017\u0010B\u001a\u00020?2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010F\u001a\u00020C2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\bD\u0010EJ\u0017\u0010J\u001a\u00020G2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\bH\u0010IJ\u0017\u0010N\u001a\u00020K2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierSummaryBlueprintsModule;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$safedeal_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$safedeal_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryContentsComparator;", "contentsComparator", "provideDiffCalculator$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$safedeal_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/image/ImageItemBlueprint;", "imageItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/text/TextItemBlueprint;", "textItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemBlueprint;", "headerItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/link/LinkItemBlueprint;", "linkItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemBlueprint;", "inputItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemBlueprint;", "selectItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/divider/DividerItemBlueprint;", "dividerItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/button/ButtonItemBlueprint;", "buttonItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemBlueprint;", "extraItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServicesRadioGroupItemBlueprint;", "courierServicesRadioGroupItemBlueprint", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceBlueprint;", "singleCourierServiceBlueprint", "provideItemBinder", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/image/ImageItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/text/TextItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/link/LinkItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/divider/DividerItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/button/ButtonItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServicesRadioGroupItemBlueprint;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemPresenter;", "provideCourierServicesRadioGroupItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemPresenter;", "provideCourierServicesRadioGroupItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemPresenter;", "provideSingleCourierServiceItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemPresenter;", "provideSingleCourierServiceItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", "provideExtraItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", "provideExtraItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemPresenter;", "provideInputItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemPresenter;", "provideInputItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemPresenter;", "provideSelectItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemPresenter;", "provideSelectItemPresenter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/button/ButtonItemPresenter;", "provideButtonItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/button/ButtonItemPresenter;", "provideButtonItemPresenter", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DeliveryCourierSummaryBlueprintsModule {
    @NotNull
    public static final DeliveryCourierSummaryBlueprintsModule INSTANCE = new DeliveryCourierSummaryBlueprintsModule();

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
    public static final ButtonItemPresenter provideButtonItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new ButtonItemPresenter(deliveryCourierSummaryViewModel.getSubmitButtonClickConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RadioGroupItemPresenter provideCourierServicesRadioGroupItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new RadioGroupItemPresenterImpl(deliveryCourierSummaryViewModel.getCourierServiceChangeConsumer());
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
    public static final DiffCalculator provideDiffCalculator$safedeal_release(@NotNull DeliveryCourierSummaryContentsComparator deliveryCourierSummaryContentsComparator) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(deliveryCourierSummaryContentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ExtraItemPresenter provideExtraItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new ExtraItemPresenter(deliveryCourierSummaryViewModel.getDialogState(), deliveryCourierSummaryViewModel.getDialogStateConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final InputItemPresenter provideInputItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new InputItemPresenterImpl(deliveryCourierSummaryViewModel.getChangeConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull ImageItemBlueprint imageItemBlueprint, @NotNull TextItemBlueprint textItemBlueprint, @NotNull HeaderItemBlueprint headerItemBlueprint, @NotNull LinkItemBlueprint linkItemBlueprint, @NotNull InputItemBlueprint inputItemBlueprint, @NotNull SelectItemBlueprint selectItemBlueprint, @NotNull DividerItemBlueprint dividerItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint, @NotNull ExtraItemBlueprint extraItemBlueprint, @NotNull CourierServicesRadioGroupItemBlueprint courierServicesRadioGroupItemBlueprint, @NotNull SingleCourierServiceBlueprint singleCourierServiceBlueprint) {
        Intrinsics.checkNotNullParameter(imageItemBlueprint, "imageItemBlueprint");
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        Intrinsics.checkNotNullParameter(headerItemBlueprint, "headerItemBlueprint");
        Intrinsics.checkNotNullParameter(linkItemBlueprint, "linkItemBlueprint");
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(selectItemBlueprint, "selectItemBlueprint");
        Intrinsics.checkNotNullParameter(dividerItemBlueprint, "dividerItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        Intrinsics.checkNotNullParameter(extraItemBlueprint, "extraItemBlueprint");
        Intrinsics.checkNotNullParameter(courierServicesRadioGroupItemBlueprint, "courierServicesRadioGroupItemBlueprint");
        Intrinsics.checkNotNullParameter(singleCourierServiceBlueprint, "singleCourierServiceBlueprint");
        return new ItemBinder.Builder().registerItem(imageItemBlueprint).registerItem(textItemBlueprint).registerItem(headerItemBlueprint).registerItem(linkItemBlueprint).registerItem(inputItemBlueprint).registerItem(selectItemBlueprint).registerItem(dividerItemBlueprint).registerItem(buttonItemBlueprint).registerItem(extraItemBlueprint).registerItem(courierServicesRadioGroupItemBlueprint).registerItem(singleCourierServiceBlueprint).build();
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
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemPresenter provideSelectItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new SelectItemPresenterImpl(deliveryCourierSummaryViewModel.getSelectDeepLinkClickConsumer(), deliveryCourierSummaryViewModel.getChangeConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SingleCourierServiceItemPresenter provideSingleCourierServiceItemPresenter$safedeal_release(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        return new SingleCourierServiceItemPresenterImpl(deliveryCourierSummaryViewModel.getCourierServiceChangeConsumer());
    }
}
