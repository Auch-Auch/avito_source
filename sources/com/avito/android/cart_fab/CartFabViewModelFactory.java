package com.avito.android.cart_fab;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.google.common.base.Optional;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b%\u0010&J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/cart_fab/CartFabViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/cart_fab/CartFabPreferences;", "c", "Lcom/avito/android/cart_fab/CartFabPreferences;", "cartFabPrefs", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/cart_fab/CartFabRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cart_fab/CartFabRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/google/common/base/Optional;", "Lcom/avito/android/util/SearchContextWrapper;", g.a, "Lcom/google/common/base/Optional;", "searchContextWrapper", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/cart_fab/CartFabRepository;Lcom/avito/android/cart_fab/CartFabPreferences;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/google/common/base/Optional;)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabViewModelFactory implements ViewModelProvider.Factory {
    public final Features a;
    public final CartFabRepository b;
    public final CartFabPreferences c;
    public final AccountStateProvider d;
    public final SchedulersFactory3 e;
    public final Analytics f;
    public final Optional<SearchContextWrapper> g;

    @Inject
    public CartFabViewModelFactory(@NotNull Features features, @NotNull CartFabRepository cartFabRepository, @NotNull CartFabPreferences cartFabPreferences, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull Optional<SearchContextWrapper> optional) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(cartFabRepository, "repository");
        Intrinsics.checkNotNullParameter(cartFabPreferences, "cartFabPrefs");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(optional, "searchContextWrapper");
        this.a = features;
        this.b = cartFabRepository;
        this.c = cartFabPreferences;
        this.d = accountStateProvider;
        this.e = schedulersFactory3;
        this.f = analytics;
        this.g = optional;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (this.a.getCartFloatingActionButton().invoke().booleanValue()) {
            return new CartFabViewModelImpl(this.b, this.c, this.d, this.e, this.f, this.g);
        }
        return new CartFabStubViewModel();
    }
}
