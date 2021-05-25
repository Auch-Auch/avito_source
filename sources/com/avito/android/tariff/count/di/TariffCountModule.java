package com.avito.android.tariff.count.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.tariff.count.item.CountItemBlueprint;
import com.avito.android.tariff.count.item.CountItemPresenter;
import com.avito.android.tariff.count.item.CountItemPresenterImpl;
import com.avito.android.tariff.count.item.bonus.BonusItemBlueprint;
import com.avito.android.tariff.count.item.bonus.BonusItemPresenter;
import com.avito.android.tariff.count.recycler.TariffCountContentsComparator;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import com.avito.android.tariff.count.viewmodel.PriceConverter;
import com.avito.android.tariff.count.viewmodel.PriceConverterImpl;
import com.avito.android.tariff.count.viewmodel.TariffCountConverter;
import com.avito.android.tariff.count.viewmodel.TariffCountConverterImpl;
import com.avito.android.tariff.count.viewmodel.TariffCountRepository;
import com.avito.android.tariff.count.viewmodel.TariffCountRepositoryImpl;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModel;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModelFactory;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModelImpl;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001c\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/tariff/count/di/TariffCountModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "changePayloadCreator", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "(Lcom/avito/android/recycler/data_aware/ContentsComparator;Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "diffCalculator", "provideDataAwareAdapter", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, HeaderModule.class})
public final class TariffCountModule {
    @NotNull
    public static final TariffCountModule INSTANCE = new TariffCountModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\u0006\u0010&\u001a\u00020*H'¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'2\u0006\u0010.\u001a\u00020+H'¢\u0006\u0004\b/\u00100J\u001f\u00104\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003032\u0006\u00102\u001a\u000201H'¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'2\u0006\u0010.\u001a\u000206H'¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003032\u0006\u00102\u001a\u000209H'¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/avito/android/tariff/count/di/TariffCountModule$Declarations;", "", "Lcom/avito/android/tariff/count/viewmodel/PriceConverterImpl;", "priceConverterImpl", "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "providePriceConverter", "(Lcom/avito/android/tariff/count/viewmodel/PriceConverterImpl;)Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/tariff/count/recycler/TariffCountContentsComparator;", "tariffCountContentsComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "provideContentsComparator", "(Lcom/avito/android/tariff/count/recycler/TariffCountContentsComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/tariff/count/recycler/TariffCountPayloadCreator;", "payloadCreator", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "providePayloadCreator", "(Lcom/avito/android/tariff/count/recycler/TariffCountPayloadCreator;)Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountRepositoryImpl;", "repository", "Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "provideRepository", "(Lcom/avito/android/tariff/count/viewmodel/TariffCountRepositoryImpl;)Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountConverterImpl;", "converter", "Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;", "provideConverter", "(Lcom/avito/android/tariff/count/viewmodel/TariffCountConverterImpl;)Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/count/item/CountItemPresenterImpl;", "Lcom/avito/android/tariff/count/item/CountItemPresenter;", "provideCountPresenterImpl", "(Lcom/avito/android/tariff/count/item/CountItemPresenterImpl;)Lcom/avito/android/tariff/count/item/CountItemPresenter;", "itemPresenter", "provideCountPresenter", "(Lcom/avito/android/tariff/count/item/CountItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/count/item/CountItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideCountBlueprint", "(Lcom/avito/android/tariff/count/item/CountItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/count/item/bonus/BonusItemPresenter;", "provideBonusPresenter", "(Lcom/avito/android/tariff/count/item/bonus/BonusItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/count/item/bonus/BonusItemBlueprint;", "provideBonusBlueprint", "(Lcom/avito/android/tariff/count/item/bonus/BonusItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideBonusBlueprint(@NotNull BonusItemBlueprint bonusItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideBonusPresenter(@NotNull BonusItemPresenter bonusItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ContentsComparator provideContentsComparator(@NotNull TariffCountContentsComparator tariffCountContentsComparator);

        @PerFragment
        @Binds
        @NotNull
        TariffCountConverter provideConverter(@NotNull TariffCountConverterImpl tariffCountConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideCountBlueprint(@NotNull CountItemBlueprint countItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideCountPresenter(@NotNull CountItemPresenter countItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        CountItemPresenter provideCountPresenterImpl(@NotNull CountItemPresenterImpl countItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        ChangePayloadCreator providePayloadCreator(@NotNull TariffCountPayloadCreator tariffCountPayloadCreator);

        @PerFragment
        @Binds
        @NotNull
        PriceConverter providePriceConverter(@NotNull PriceConverterImpl priceConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffCountRepository provideRepository(@NotNull TariffCountRepositoryImpl tariffCountRepositoryImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull TariffCountViewModelFactory tariffCountViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapter(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator(@NotNull ContentsComparator contentsComparator, @NotNull ChangePayloadCreator changePayloadCreator) {
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(changePayloadCreator, "changePayloadCreator");
        return new SimpleDiffCalculator(contentsComparator, null, true, changePayloadCreator, 2, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleRecyclerAdapter(dataAwareAdapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TariffCountViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(TariffCountViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (TariffCountViewModel) viewModel;
    }
}
