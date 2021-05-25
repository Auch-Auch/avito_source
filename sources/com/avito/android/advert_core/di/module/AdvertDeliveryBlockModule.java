package com.avito.android.advert_core.di.module;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepository;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepositoryImpl;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelFactory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelImpl;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertDeliveryBlockModule;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "provideAdvertDeliveryBlockViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/LifecycleOwner;)Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "provideAdvertDeliveryBlockDataObservable", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AdvertDeliveryBlockModule {
    @NotNull
    public static final AdvertDeliveryBlockModule INSTANCE = new AdvertDeliveryBlockModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertDeliveryBlockModule$Declarations;", "", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepositoryImpl;", "repository", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", "bindAdvertDeliveryBlockRepository", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepositoryImpl;)Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModelFactory;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindAdvertDeliveryBlockViewModelFactory", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        AdvertDeliveryBlockRepository bindAdvertDeliveryBlockRepository(@NotNull AdvertDeliveryBlockRepositoryImpl advertDeliveryBlockRepositoryImpl);

        @Reusable
        @Binds
        @NotNull
        ViewModelProvider.Factory bindAdvertDeliveryBlockViewModelFactory(@NotNull AdvertDeliveryBlockViewModelFactory advertDeliveryBlockViewModelFactory);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @AdvertDeliveryBlockDataObservable
    public static final PublishRelay<AdvertDeliveryC2C> provideAdvertDeliveryBlockDataObservable() {
        PublishRelay<AdvertDeliveryC2C> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertDeliveryBlockViewModel provideAdvertDeliveryBlockViewModel(@NotNull ViewModelProvider.Factory factory, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (lifecycleOwner instanceof FragmentActivity) {
            ViewModel viewModel = ViewModelProviders.of((FragmentActivity) lifecycleOwner, factory).get(AdvertDeliveryBlockViewModelImpl.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(\n …iewModelImpl::class.java)");
            return (AdvertDeliveryBlockViewModel) viewModel;
        } else if (lifecycleOwner instanceof Fragment) {
            ViewModel viewModel2 = ViewModelProviders.of((Fragment) lifecycleOwner, factory).get(AdvertDeliveryBlockViewModelImpl.class);
            Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(\n …iewModelImpl::class.java)");
            return (AdvertDeliveryBlockViewModel) viewModel2;
        } else {
            throw new IllegalArgumentException("AdvertDeliveryBlockModule: lifecycleOwner must be FragmentActivity or Fragment types");
        }
    }
}
