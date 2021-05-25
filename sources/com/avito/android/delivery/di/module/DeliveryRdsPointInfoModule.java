package com.avito.android.delivery.di.module;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractor;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractorImpl;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoResourceProvider;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoResourceProviderImpl;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModelFactory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModelImpl;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemPresenterImpl;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemPresenterImpl;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemPresenterImpl;
import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.delivery.utils.DrawableFactoryImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsPointInfoModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "provideDeliveryRdsPointInfoViewModel$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModelFactory;)Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "provideDeliveryRdsPointInfoViewModel", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$delivery_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemBlueprint;", "serviceItemBlueprint", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemBlueprint;", "multiServiceItemBlueprint", "Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemBlueprint;", "titleItemBlueprint", "provideItemBinder$delivery_release", "(Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemBlueprint;Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemBlueprint;Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "viewModel", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", "provideMultiServiceItemPresenter$delivery_release", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;)Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", "provideMultiServiceItemPresenter", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, AttributedTextFormatterModule.class})
public final class DeliveryRdsPointInfoModule {
    @NotNull
    public static final DeliveryRdsPointInfoModule INSTANCE = new DeliveryRdsPointInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsPointInfoModule$Dependencies;", "", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractorImpl;", "interactor", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "bindsPointInfoInteractor", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractorImpl;)Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", "bindsPointInfoResourceProvider", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProviderImpl;)Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", "Lcom/avito/android/delivery/utils/DrawableFactoryImpl;", "factory", "Lcom/avito/android/delivery/utils/DrawableFactory;", "bindsDrawableFactory", "(Lcom/avito/android/delivery/utils/DrawableFactoryImpl;)Lcom/avito/android/delivery/utils/DrawableFactory;", "Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemPresenterImpl;", "presenter", "Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemPresenter;", "bindTitleItemPresenter", "(Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemPresenterImpl;)Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemPresenter;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenterImpl;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;", "bindServiceItemPresenter", "(Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenterImpl;)Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ServiceItemPresenter bindServiceItemPresenter(@NotNull ServiceItemPresenterImpl serviceItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TitleItemPresenter bindTitleItemPresenter(@NotNull TitleItemPresenterImpl titleItemPresenterImpl);

        @Binds
        @NotNull
        DrawableFactory bindsDrawableFactory(@NotNull DrawableFactoryImpl drawableFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsPointInfoInteractor bindsPointInfoInteractor(@NotNull DeliveryRdsPointInfoInteractorImpl deliveryRdsPointInfoInteractorImpl);

        @Binds
        @NotNull
        DeliveryRdsPointInfoResourceProvider bindsPointInfoResourceProvider(@NotNull DeliveryRdsPointInfoResourceProviderImpl deliveryRdsPointInfoResourceProviderImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$delivery_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryRdsPointInfoViewModel provideDeliveryRdsPointInfoViewModel$delivery_release(@NotNull Fragment fragment, @NotNull DeliveryRdsPointInfoViewModelFactory deliveryRdsPointInfoViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryRdsPointInfoViewModelFactory).get(DeliveryRdsPointInfoViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryRdsPointInfoViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$delivery_release(@NotNull ServiceItemBlueprint serviceItemBlueprint, @NotNull MultiServiceItemBlueprint multiServiceItemBlueprint, @NotNull TitleItemBlueprint titleItemBlueprint) {
        Intrinsics.checkNotNullParameter(serviceItemBlueprint, "serviceItemBlueprint");
        Intrinsics.checkNotNullParameter(multiServiceItemBlueprint, "multiServiceItemBlueprint");
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        return new ItemBinder.Builder().registerItem(serviceItemBlueprint).registerItem(multiServiceItemBlueprint).registerItem(titleItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiServiceItemPresenter provideMultiServiceItemPresenter$delivery_release(@NotNull DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoViewModel, "viewModel");
        return new MultiServiceItemPresenterImpl(deliveryRdsPointInfoViewModel.getServiceSelectConsumer());
    }
}
