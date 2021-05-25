package com.avito.android.vas_performance.di.applied_services;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitleBlueprint;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.AppliedServiceConverterImpl;
import com.avito.android.vas_performance.AppliedServicesConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelFactory;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelImpl;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceBlueprint;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceItem;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceItemPresenter;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceItemView;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerBlueprint;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemPresenter;
import com.avito.android.vas_performance.ui.items.button.ButtonItemBlueprint;
import com.avito.android.vas_performance.ui.items.button.ButtonItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesModule;", "", "Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;", "provideTitlePresenter", "()Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideTitleBlueprint", "(Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "provideViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "Lcom/avito/android/vas_performance/repository/VasRepository;", "repository", "Lcom/avito/android/vas_performance/AppliedServicesConverter;", "converter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "provideVmFactory", "(Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/vas_performance/AppliedServicesConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/util/SchedulersFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class AppliedServicesModule {
    public final Fragment a;
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesModule$Declarations;", "", "Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideAppliedVasBannerBlueprint", "(Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideAppliedVasBannerPresenter", "(Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceItemPresenter;", "appliedServiceItemPresenter", "Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceItemView;", "Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceItem;", "provideAppliedServicesPresenter", "(Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceBlueprint;", "appliedServiceBlueprint", "provideAppliedServiceBlueprint", "(Lcom/avito/android/vas_performance/ui/items/applied_services/AppliedServiceBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_performance/ui/items/button/ButtonItemPresenter;", "buttonItemPresenter", "provideButtonPresenter", "(Lcom/avito/android/vas_performance/ui/items/button/ButtonItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/button/ButtonItemBlueprint;", "blueprint", "provideButtonBlueprint", "(Lcom/avito/android/vas_performance/ui/items/button/ButtonItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;", "vasRepositoryImpl", "Lcom/avito/android/vas_performance/repository/VasRepository;", "provideVasRepository", "(Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;)Lcom/avito/android/vas_performance/repository/VasRepository;", "Lcom/avito/android/vas_performance/AppliedServiceConverterImpl;", "converter", "Lcom/avito/android/vas_performance/AppliedServicesConverter;", "provideConverter", "(Lcom/avito/android/vas_performance/AppliedServiceConverterImpl;)Lcom/avito/android/vas_performance/AppliedServicesConverter;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideAppliedServiceBlueprint(@NotNull AppliedServiceBlueprint appliedServiceBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<AppliedServiceItemView, AppliedServiceItem> provideAppliedServicesPresenter(@NotNull AppliedServiceItemPresenter appliedServiceItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideAppliedVasBannerBlueprint(@NotNull VasBundleBannerBlueprint vasBundleBannerBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideAppliedVasBannerPresenter(@NotNull VasBundleBannerItemPresenter vasBundleBannerItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideButtonBlueprint(@NotNull ButtonItemBlueprint buttonItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideButtonPresenter(@NotNull ButtonItemPresenter buttonItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        AppliedServicesConverter provideConverter(@NotNull AppliedServiceConverterImpl appliedServiceConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        VasRepository provideVasRepository(@NotNull VasRepositoryImpl vasRepositoryImpl);
    }

    public AppliedServicesModule(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a = fragment;
        this.b = str;
    }

    @Provides
    @IntoSet
    @NotNull
    @PerFragment
    public final ItemBlueprint<?, ?> provideTitleBlueprint(@NotNull TitlePresenter titlePresenter) {
        Intrinsics.checkNotNullParameter(titlePresenter, "presenter");
        return new TitleBlueprint(titlePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TitlePresenter provideTitlePresenter() {
        return new TitlePresenter();
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppliedServicesViewModel provideViewModel(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a, factory).get(AppliedServicesViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (AppliedServicesViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ViewModelProvider.Factory provideVmFactory(@NotNull VasRepository vasRepository, @NotNull AppliedServicesConverter appliedServicesConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(vasRepository, "repository");
        Intrinsics.checkNotNullParameter(appliedServicesConverter, "converter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkIntentFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new AppliedServicesViewModelFactory(this.b, vasRepository, appliedServicesConverter, deepLinkIntentFactory, schedulersFactory);
    }
}
