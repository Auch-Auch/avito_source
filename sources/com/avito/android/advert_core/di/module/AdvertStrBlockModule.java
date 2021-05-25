package com.avito.android.advert_core.di.module;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractor;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractorImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractor;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractorImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModelFactory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModelImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewResourceProvider;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewResourceProviderImpl;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertStrBlockModule;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "provideAdvertStrBlockViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "provideSellerShortTermRentObservable", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AdvertStrBlockModule {
    @NotNull
    public static final AdvertStrBlockModule INSTANCE = new AdvertStrBlockModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertStrBlockModule$Declarations;", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModelFactory;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindAdvertStrBlockViewModelFactory", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractorImpl;", "interactor", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "bindAdvertStrBlockInteractor", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractorImpl;)Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "bindAdvertStrBlockViewResourceProvider", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProviderImpl;)Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractorImpl;", "analyticsInteractor", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "bindAdvertStrBlockAnalyticsInteractor", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractorImpl;)Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        AdvertStrBlockAnalyticsInteractor bindAdvertStrBlockAnalyticsInteractor(@NotNull AdvertStrBlockAnalyticsInteractorImpl advertStrBlockAnalyticsInteractorImpl);

        @Reusable
        @Binds
        @NotNull
        AdvertStrBlockInteractor bindAdvertStrBlockInteractor(@NotNull AdvertStrBlockInteractorImpl advertStrBlockInteractorImpl);

        @Reusable
        @Binds
        @NotNull
        ViewModelProvider.Factory bindAdvertStrBlockViewModelFactory(@NotNull AdvertStrBlockViewModelFactory advertStrBlockViewModelFactory);

        @Reusable
        @Binds
        @NotNull
        AdvertStrBlockViewResourceProvider bindAdvertStrBlockViewResourceProvider(@NotNull AdvertStrBlockViewResourceProviderImpl advertStrBlockViewResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertStrBlockViewModel provideAdvertStrBlockViewModel(@NotNull ViewModelProvider.Factory factory, @NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        ViewModel viewModel = ViewModelProviders.of(fragmentActivity, factory).get(AdvertStrBlockViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (AdvertStrBlockViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @AdvertSellerShortTermRentObservable
    public static final PublishRelay<AdvertSellerShortTermRent> provideSellerShortTermRentObservable() {
        PublishRelay<AdvertSellerShortTermRent> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
