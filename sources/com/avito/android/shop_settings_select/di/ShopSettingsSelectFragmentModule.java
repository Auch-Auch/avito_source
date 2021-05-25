package com.avito.android.shop_settings_select.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.recycler.di.DetectMoves;
import com.avito.android.shop_settings_select.ShopSettingsSelectConverter;
import com.avito.android.shop_settings_select.ShopSettingsSelectConverterImpl;
import com.avito.android.shop_settings_select.ShopSettingsSelectRepository;
import com.avito.android.shop_settings_select.ShopSettingsSelectRepositoryImpl;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModel;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModelFactory;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModelImpl;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.di.ShopSettingsSelectionItemModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "provideChangePayloadCreator", "()Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideItemPresenters", "()Ljava/util/Set;", "", "provideDetectMoves", "()Z", "<init>", "()V", "Declarations", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, ShopSettingsSelectionItemModule.class})
public final class ShopSettingsSelectFragmentModule {
    @NotNull
    public static final ShopSettingsSelectFragmentModule INSTANCE = new ShopSettingsSelectFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentModule$Declarations;", "", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindViewModelFactory", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepositoryImpl;", "repository", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "bindRepository", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepositoryImpl;)Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverterImpl;", "converter", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", "bindConverter", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverterImpl;)Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "bindRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "bindDiffCalculator", "(Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/android/recycler/data_aware/SimpleEqualityComparator;", "equalityComparator", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "bindEqualityComparator", "(Lcom/avito/android/recycler/data_aware/SimpleEqualityComparator;)Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/android/recycler/data_aware/SimpleContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "bindContentsComparator", "(Lcom/avito/android/recycler/data_aware/SimpleContentsComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenterImpl;", "presenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "bindDataAwareAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenterImpl;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ContentsComparator bindContentsComparator(@NotNull SimpleContentsComparator simpleContentsComparator);

        @PerFragment
        @Binds
        @NotNull
        ShopSettingsSelectConverter bindConverter(@NotNull ShopSettingsSelectConverterImpl shopSettingsSelectConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        DataAwareAdapterPresenter bindDataAwareAdapterPresenter(@NotNull DataAwareAdapterPresenterImpl dataAwareAdapterPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        DiffCalculator bindDiffCalculator(@NotNull SimpleDiffCalculator simpleDiffCalculator);

        @PerFragment
        @Binds
        @NotNull
        EqualityComparator bindEqualityComparator(@NotNull SimpleEqualityComparator simpleEqualityComparator);

        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback bindListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @Binds
        @NotNull
        @PerFragment
        RecyclerView.Adapter<BaseViewHolder> bindRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        ShopSettingsSelectRepository bindRepository(@NotNull ShopSettingsSelectRepositoryImpl shopSettingsSelectRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory bindViewModelFactory(@NotNull ShopSettingsSelectViewModelFactory shopSettingsSelectViewModelFactory);
    }

    @Provides
    @PerFragment
    @Nullable
    public final ChangePayloadCreator provideChangePayloadCreator() {
        return null;
    }

    @Provides
    @PerFragment
    @DetectMoves
    public final boolean provideDetectMoves() {
        return false;
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresenters() {
        return y.emptySet();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ShopSettingsSelectViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(ShopSettingsSelectViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (ShopSettingsSelectViewModel) viewModel;
    }
}
