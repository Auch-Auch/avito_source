package com.avito.android.shop_settings.di;

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
import com.avito.android.shop_settings.ShopSettingsConverter;
import com.avito.android.shop_settings.ShopSettingsConverterImpl;
import com.avito.android.shop_settings.ShopSettingsInteractor;
import com.avito.android.shop_settings.ShopSettingsInteractorImpl;
import com.avito.android.shop_settings.ShopSettingsStringProvider;
import com.avito.android.shop_settings.ShopSettingsStringProviderImpl;
import com.avito.android.shop_settings.ShopSettingsViewModel;
import com.avito.android.shop_settings.ShopSettingsViewModelFactory;
import com.avito.android.shop_settings.ShopSettingsViewModelImpl;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.address.di.ShopSettingsAddressItemModule;
import com.avito.android.shop_settings.blueprints.alert.di.ShopSettingsAlertItemModule;
import com.avito.android.shop_settings.blueprints.form_title.di.ShopSettingsFormTitleItemModule;
import com.avito.android.shop_settings.blueprints.input.di.ShopSettingsInputItemModule;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.di.ShopSettingsMultiLineInputItemModule;
import com.avito.android.shop_settings.blueprints.input.single_line_input.di.ShopSettingsSingleLineInputItemModule;
import com.avito.android.shop_settings.blueprints.moderation_error.di.ShopSettingsModerationErrorItemModule;
import com.avito.android.shop_settings.blueprints.save_button.di.ShopSettingsSaveButtonItemModule;
import com.avito.android.shop_settings.blueprints.section_title.di.ShopSettingsSectionTitleItemModule;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.blueprints.select.di.ShopSettingsSelectItemModule;
import com.avito.android.shop_settings.blueprints.separator.di.ShopSettingsSeparatorItemModule;
import com.avito.android.shop_settings.blueprints.switcher.di.ShopSettingsSwitcherItemModule;
import com.avito.android.shop_settings.blueprints.title_subtitle.di.ShopSettingsTitleSubtitleItemModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0007¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0007¢\u0006\u0004\b\u001d\u0010\u0019¨\u0006!"}, d2 = {"Lcom/avito/android/shop_settings/di/ShopSettingsFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "provideChangePayloadCreator", "()Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "", "provideDetectMoves", "()Z", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "provideSaveButtonClick", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;", "provideSelectItemClick", "Lcom/avito/android/shop_settings/blueprints/address/ShopSettingsAddressItem;", "provideAddressItemClick", "<init>", "()V", "Declarations", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, AttributedTextFormatterModule.class, Declarations.class, ShopSettingsFormTitleItemModule.class, ShopSettingsAlertItemModule.class, ShopSettingsSwitcherItemModule.class, ShopSettingsSelectItemModule.class, ShopSettingsAddressItemModule.class, ShopSettingsSeparatorItemModule.class, ShopSettingsSingleLineInputItemModule.class, ShopSettingsMultiLineInputItemModule.class, ShopSettingsSectionTitleItemModule.class, ShopSettingsTitleSubtitleItemModule.class, ShopSettingsSaveButtonItemModule.class, ShopSettingsInputItemModule.class, ShopSettingsModerationErrorItemModule.class})
public final class ShopSettingsFragmentModule {
    @NotNull
    public static final ShopSettingsFragmentModule INSTANCE = new ShopSettingsFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b,\u0010-J\u0017\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.H'¢\u0006\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/avito/android/shop_settings/di/ShopSettingsFragmentModule$Declarations;", "", "Lcom/avito/android/shop_settings/ShopSettingsConverterImpl;", "converter", "Lcom/avito/android/shop_settings/ShopSettingsConverter;", "bindConverter", "(Lcom/avito/android/shop_settings/ShopSettingsConverterImpl;)Lcom/avito/android/shop_settings/ShopSettingsConverter;", "Lcom/avito/android/shop_settings/ShopSettingsInteractorImpl;", "interactor", "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "bindInteractor", "(Lcom/avito/android/shop_settings/ShopSettingsInteractorImpl;)Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "bindRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/shop_settings/ShopSettingsViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindViewModelFactory", "(Lcom/avito/android/shop_settings/ShopSettingsViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "bindDiffCalculator", "(Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/android/recycler/data_aware/SimpleEqualityComparator;", "equalityComparator", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "bindEqualityComparator", "(Lcom/avito/android/recycler/data_aware/SimpleEqualityComparator;)Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/android/recycler/data_aware/SimpleContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "bindContentsComparator", "(Lcom/avito/android/recycler/data_aware/SimpleContentsComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenterImpl;", "presenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "bindDataAwareAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenterImpl;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/shop_settings/ShopSettingsStringProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "bindStringProvider", "(Lcom/avito/android/shop_settings/ShopSettingsStringProviderImpl;)Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ContentsComparator bindContentsComparator(@NotNull SimpleContentsComparator simpleContentsComparator);

        @PerFragment
        @Binds
        @NotNull
        ShopSettingsConverter bindConverter(@NotNull ShopSettingsConverterImpl shopSettingsConverterImpl);

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
        ShopSettingsInteractor bindInteractor(@NotNull ShopSettingsInteractorImpl shopSettingsInteractorImpl);

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
        ShopSettingsStringProvider bindStringProvider(@NotNull ShopSettingsStringProviderImpl shopSettingsStringProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory bindViewModelFactory(@NotNull ShopSettingsViewModelFactory shopSettingsViewModelFactory);
    }

    @Provides
    @NotNull
    @PerFragment
    @AddressItemClick
    public final PublishRelay<ShopSettingsAddressItem> provideAddressItemClick() {
        PublishRelay<ShopSettingsAddressItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
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

    @SaveButtonClick
    @Provides
    @NotNull
    @PerFragment
    public final PublishRelay<Unit> provideSaveButtonClick() {
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @SelectItemClick
    @NotNull
    @PerFragment
    public final PublishRelay<ShopSettingsSelectItem> provideSelectItemClick() {
        PublishRelay<ShopSettingsSelectItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
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
    public final ShopSettingsViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(ShopSettingsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (ShopSettingsViewModel) viewModel;
    }
}
