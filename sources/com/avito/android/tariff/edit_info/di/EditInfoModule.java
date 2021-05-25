package com.avito.android.tariff.edit_info.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.android.tariff.edit_info.item.add_category.di.AddCategoryItemModule;
import com.avito.android.tariff.edit_info.item.alert_dialog.di.AlertDialogItemModule;
import com.avito.android.tariff.edit_info.item.button.di.ButtonItemModule;
import com.avito.android.tariff.edit_info.item.edit_package.di.EditPackageItemModule;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.manager_call.di.ManagerCallItemModule;
import com.avito.android.tariff.edit_info.item.prolongation.ResourceProvider;
import com.avito.android.tariff.edit_info.item.prolongation.ResourceProviderImpl;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationPayloadCreator;
import com.avito.android.tariff.edit_info.item.prolongation.di.TariffProlongationItemModule;
import com.avito.android.tariff.edit_info.item.tabs.di.TabsItemModule;
import com.avito.android.tariff.edit_info.ui.EditInfoContentsComparator;
import com.avito.android.tariff.edit_info.ui.EditInfoEqualityComparator;
import com.avito.android.tariff.edit_info.ui.EditInfoPaddingDecoration;
import com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider;
import com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProviderImpl;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoConverter;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoConverterImpl;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoRepository;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoRepositoryImpl;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelFactory;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import com.avito.android.tariff.info.item.info.di.InfoItemModule;
import com.avito.android.tariff.info.item.package_title.di.PackageTitleItemModule;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ViewTypeProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u0010\u001a\u00020\r2\u0019\u0010\f\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n¢\u0006\u0002\b\u000b0\tH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0012\u001a\u00020\r2\u001b\b\u0001\u0010\f\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n¢\u0006\u0002\b\u000b0\tH\u0001¢\u0006\u0004\b\u0011\u0010\u000fJ\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010!\u001a\u00020 2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00162\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b#\u0010$J'\u0010+\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u00020-2\b\b\u0001\u0010\u001d\u001a\u00020\u00162\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00162\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0001¢\u0006\u0004\b2\u0010$J\u0017\u00108\u001a\u00020\r2\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/avito/android/tariff/edit_info/di/EditInfoModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$tariff_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "provideTabsItemBinder$tariff_release", "provideTabsItemBinder", "itemBinder", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "viewTypeProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$tariff_release", "(Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/blueprint/ViewTypeProvider;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapter", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideTabsDataAwareAdapter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "equalityComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "payloadCreator", "provideDiffCalculator", "(Lcom/avito/android/recycler/data_aware/EqualityComparator;Lcom/avito/android/recycler/data_aware/ContentsComparator;Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideTabsRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideMicroCategoryAdapterPresenter$tariff_release", "provideMicroCategoryAdapterPresenter", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;", "microCategoryItemBlueprint", "provideMicroCategoryItemBinder$tariff_release", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideMicroCategoryItemBinder", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, EditPackageItemModule.class, AddCategoryItemModule.class, ButtonItemModule.class, InfoItemModule.class, HeaderModule.class, PackageTitleItemModule.class, TabsItemModule.class, AlertDialogItemModule.class, TariffProlongationItemModule.class, ManagerCallItemModule.class})
public final class EditInfoModule {
    @NotNull
    public static final EditInfoModule INSTANCE = new EditInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H'¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H'¢\u0006\u0004\b5\u00106J\u0017\u0010:\u001a\u0002092\u0006\u00108\u001a\u000207H'¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/avito/android/tariff/edit_info/di/EditInfoModule$Declarations;", "", "Lcom/avito/android/tariff/edit_info/ui/EditInfoEqualityComparator;", "comparator", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "provideEqualityComparator", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoEqualityComparator;)Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/tariff/edit_info/ui/EditInfoContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "provideContentsComparator", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoContentsComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/tariff/view/TariffBarConverterImpl;", "barConverterImpl", "Lcom/avito/android/tariff/view/TariffBarConverter;", "provideBarConverter", "(Lcom/avito/android/tariff/view/TariffBarConverterImpl;)Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProviderImpl;", "viewTypeProvider", "Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "provideViewTypeProviderImpl", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProviderImpl;)Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "provideViewTypeProvider", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;)Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationPayloadCreator;", "payloadCreator", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "providePayloadCreator", "(Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationPayloadCreator;)Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/android/tariff/edit_info/ui/EditInfoPaddingDecoration;", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "provideItemDecoration", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoPaddingDecoration;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;", "provideResourceProvider", "(Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProviderImpl;)Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepositoryImpl;", "repository", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "provideRepository", "(Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepositoryImpl;)Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverterImpl;", "converter", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "provideConverter", "(Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverterImpl;)Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        TariffBarConverter provideBarConverter(@NotNull TariffBarConverterImpl tariffBarConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ContentsComparator provideContentsComparator(@NotNull EditInfoContentsComparator editInfoContentsComparator);

        @PerFragment
        @Binds
        @NotNull
        EditInfoConverter provideConverter(@NotNull EditInfoConverterImpl editInfoConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        EqualityComparator provideEqualityComparator(@NotNull EditInfoEqualityComparator editInfoEqualityComparator);

        @PerFragment
        @Binds
        @NotNull
        RecyclerView.ItemDecoration provideItemDecoration(@NotNull EditInfoPaddingDecoration editInfoPaddingDecoration);

        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        ChangePayloadCreator providePayloadCreator(@NotNull TariffProlongationPayloadCreator tariffProlongationPayloadCreator);

        @PerFragment
        @Binds
        @NotNull
        EditInfoRepository provideRepository(@NotNull EditInfoRepositoryImpl editInfoRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ResourceProvider provideResourceProvider(@NotNull ResourceProviderImpl resourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull EditInfoViewModelFactory editInfoViewModelFactory);

        @PerFragment
        @Binds
        @NotNull
        ViewTypeProvider provideViewTypeProvider(@NotNull EditInfoViewTypeProvider editInfoViewTypeProvider);

        @PerFragment
        @Binds
        @NotNull
        EditInfoViewTypeProvider provideViewTypeProviderImpl(@NotNull EditInfoViewTypeProviderImpl editInfoViewTypeProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$tariff_release(@NotNull ItemBinder itemBinder, @NotNull ViewTypeProvider viewTypeProvider) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(viewTypeProvider, "viewTypeProvider");
        return new SimpleAdapterPresenter(viewTypeProvider, itemBinder);
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
    public static final DiffCalculator provideDiffCalculator(@NotNull EqualityComparator equalityComparator, @NotNull ContentsComparator contentsComparator, @NotNull ChangePayloadCreator changePayloadCreator) {
        Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(changePayloadCreator, "payloadCreator");
        return new SimpleDiffCalculator(contentsComparator, equalityComparator, true, changePayloadCreator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$tariff_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
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
    @TabsAdapterPresenter
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideTabsDataAwareAdapter(@TabsItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @TabsItemBinder
    @PerFragment
    public static final ItemBinder provideTabsItemBinder$tariff_release(@AlertDialogAdapterSet @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }

    @TabsRecyclerAdapter
    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideTabsRecyclerAdapter(@TabsAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @TabsItemBinder @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final EditInfoViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(EditInfoViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (EditInfoViewModel) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    @MicroCategoryAdapterPresenter
    public final AdapterPresenter provideMicroCategoryAdapterPresenter$tariff_release(@MicroCategoryItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @MicroCategoryItemBinder
    @PerFragment
    public final ItemBinder provideMicroCategoryItemBinder$tariff_release(@NotNull MicroCategoryItemBlueprint microCategoryItemBlueprint) {
        Intrinsics.checkNotNullParameter(microCategoryItemBlueprint, "microCategoryItemBlueprint");
        return new ItemBinder.Builder().registerItem(microCategoryItemBlueprint).build();
    }
}
