package com.avito.android.advert_core.safedeal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesObservable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.Relay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafedealServicesViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "d", "Lcom/jakewharton/rxrelay3/Relay;", "safeDealServicesObservable", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;", "c", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;", "resourcesProvider", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "interactor", "<init>", "(Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;Lcom/jakewharton/rxrelay3/Relay;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertSafedealServicesViewModelFactory implements ViewModelProvider.Factory {
    public final MyAdvertSafeDealServicesInteractor a;
    public final SchedulersFactory3 b;
    public final MyAdvertSafeDealResourceProvider c;
    public final Relay<MyAdvertSafeDeal> d;

    @Inject
    public MyAdvertSafedealServicesViewModelFactory(@NotNull MyAdvertSafeDealServicesInteractor myAdvertSafeDealServicesInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MyAdvertSafeDealResourceProvider myAdvertSafeDealResourceProvider, @MyAdvertSafeDealServicesObservable @NotNull Relay<MyAdvertSafeDeal> relay) {
        Intrinsics.checkNotNullParameter(myAdvertSafeDealServicesInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(myAdvertSafeDealResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(relay, "safeDealServicesObservable");
        this.a = myAdvertSafeDealServicesInteractor;
        this.b = schedulersFactory3;
        this.c = myAdvertSafeDealResourceProvider;
        this.d = relay;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(MyAdvertSafeDealServicesViewModelImpl.class)) {
            return new MyAdvertSafeDealServicesViewModelImpl(this.a, this.b, this.c, this.d);
        }
        throw new IllegalStateException("Unknown ViewModel class");
    }
}
