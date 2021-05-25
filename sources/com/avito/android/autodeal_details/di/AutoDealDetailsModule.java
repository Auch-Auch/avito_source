package com.avito.android.autodeal_details.di;

import android.webkit.CookieManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.autodeal_details.AutoDealDetailsInterceptor;
import com.avito.android.autodeal_details.AutoDealDetailsInterceptorImpl;
import com.avito.android.autodeal_details.AutoDealDetailsJSInterface;
import com.avito.android.autodeal_details.AutoDealDetailsJSInterfaceImpl;
import com.avito.android.autodeal_details.AutoDealDetailsViewModel;
import com.avito.android.autodeal_details.AutoDealDetailsViewModelFactory;
import com.avito.android.autodeal_details.AutoDealDetailsViewModelImpl;
import com.avito.android.cookie_provider.di.CookieProviderModule;
import com.avito.android.di.PerActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/autodeal_details/di/AutoDealDetailsModule;", "", "Landroid/webkit/CookieManager;", "provideCookieManager", "()Landroid/webkit/CookieManager;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "provideAutoDealDetailsViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "<init>", "()V", "Declarations", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CookieProviderModule.class, Declarations.class})
public final class AutoDealDetailsModule {
    @NotNull
    public static final AutoDealDetailsModule INSTANCE = new AutoDealDetailsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/autodeal_details/di/AutoDealDetailsModule$Declarations;", "", "Lcom/avito/android/autodeal_details/AutoDealDetailsViewModelFactory;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindAutoDealDetailsViewModelFactory", "(Lcom/avito/android/autodeal_details/AutoDealDetailsViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterfaceImpl;", "jsInterface", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "bindAutoDealDetailsJSInterface", "(Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterfaceImpl;)Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptorImpl;", "interceptor", "Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "bindAutoDealDetailsInterceptor", "(Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptorImpl;)Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AutoDealDetailsInterceptor bindAutoDealDetailsInterceptor(@NotNull AutoDealDetailsInterceptorImpl autoDealDetailsInterceptorImpl);

        @PerActivity
        @Binds
        @NotNull
        AutoDealDetailsJSInterface bindAutoDealDetailsJSInterface(@NotNull AutoDealDetailsJSInterfaceImpl autoDealDetailsJSInterfaceImpl);

        @PerActivity
        @Binds
        @NotNull
        ViewModelProvider.Factory bindAutoDealDetailsViewModelFactory(@NotNull AutoDealDetailsViewModelFactory autoDealDetailsViewModelFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AutoDealDetailsViewModel provideAutoDealDetailsViewModel(@NotNull ViewModelProvider.Factory factory, @NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        ViewModel viewModel = ViewModelProviders.of(fragmentActivity, factory).get(AutoDealDetailsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (AutoDealDetailsViewModel) viewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final CookieManager provideCookieManager() {
        CookieManager instance = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "CookieManager.getInstance()");
        return instance;
    }
}
