package com.avito.android.advert_core.safedeal.di;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractor;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractorImpl;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModelImpl;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.UrlParams;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.Relay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/safedeal/di/MyAdvertSafeDealServicesModule;", "", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "Lcom/avito/android/advert_core/safedeal/MyAdvertSafedealServicesViewModelFactory;", "factory", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "provideMyAdvertSafeDealServicesViewModel$advert_core_release", "(Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/advert_core/safedeal/MyAdvertSafedealServicesViewModelFactory;)Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "provideMyAdvertSafeDealServicesViewModel", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "provideMyAdvertSafeDealServicesObservable$advert_core_release", "()Lcom/jakewharton/rxrelay3/Relay;", "provideMyAdvertSafeDealServicesObservable", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class MyAdvertSafeDealServicesModule {
    @NotNull
    public static final MyAdvertSafeDealServicesModule INSTANCE = new MyAdvertSafeDealServicesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/safedeal/di/MyAdvertSafeDealServicesModule$Declarations;", "", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractorImpl;", "interactor", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "bindMyAdvertSafedealServicesInteractor", "(Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractorImpl;)Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        MyAdvertSafeDealServicesInteractor bindMyAdvertSafedealServicesInteractor(@NotNull MyAdvertSafeDealServicesInteractorImpl myAdvertSafeDealServicesInteractorImpl);
    }

    @MyAdvertSafeDealServicesObservable
    @Provides
    @Reusable
    @NotNull
    public final Relay<MyAdvertSafeDeal> provideMyAdvertSafeDealServicesObservable$advert_core_release() {
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        return create;
    }

    @Provides
    @Reusable
    @NotNull
    public final MyAdvertSafeDealServicesViewModel provideMyAdvertSafeDealServicesViewModel$advert_core_release(@NotNull LifecycleOwner lifecycleOwner, @NotNull MyAdvertSafedealServicesViewModelFactory myAdvertSafedealServicesViewModelFactory) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(myAdvertSafedealServicesViewModelFactory, "factory");
        if (lifecycleOwner instanceof FragmentActivity) {
            ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) lifecycleOwner, myAdvertSafedealServicesViewModelFactory).get(MyAdvertSafeDealServicesViewModelImpl.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,…iewModelImpl::class.java)");
            return (MyAdvertSafeDealServicesViewModel) viewModel;
        } else if (lifecycleOwner instanceof Fragment) {
            ViewModel viewModel2 = new ViewModelProvider((ViewModelStoreOwner) lifecycleOwner, myAdvertSafedealServicesViewModelFactory).get(MyAdvertSafeDealServicesViewModelImpl.class);
            Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(owner,…iewModelImpl::class.java)");
            return (MyAdvertSafeDealServicesViewModel) viewModel2;
        } else {
            throw new IllegalArgumentException("MyAdvertSafeDealServicesModule: the lifecycleOwner's type must be FragmentActivity or Fragment");
        }
    }
}
