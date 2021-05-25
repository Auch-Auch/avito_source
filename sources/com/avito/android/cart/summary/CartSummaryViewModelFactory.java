package com.avito.android.cart.summary;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B©\u0001\b\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u001c\u00102\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0\u001a0\fj\u0002`0\u0012\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00160\fj\u0002`\u0017\u0012\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\u001c\u0010\u001e\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001a0\fj\u0002`\u001c\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\b;\u0010<J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00160\fj\u0002`\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R,\u0010\u001e\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001a0\fj\u0002`\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R,\u00102\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0\u001a0\fj\u0002`08\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0010R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/cart/summary/CartSummaryResourceProvider;", "d", "Lcom/avito/android/cart/summary/CartSummaryResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/cart/summary/OpenAdvertDetailsObservable;", "j", "Lio/reactivex/rxjava3/core/Observable;", "openAdvertDetailsObservable", "Lcom/avito/android/cart/summary/CartSummaryRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cart/summary/CartSummaryRepository;", "repository", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "Lcom/avito/android/cart/summary/DeleteItemObservable;", "i", "deleteItemObservable", "Lkotlin/Pair;", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageObservable;", "k", "stepperUsageObservable", "Lcom/avito/android/ActivityIntentFactory;", g.a, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/account/AccountStateProvider;", "e", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "analytics", "", "Lcom/avito/android/cart/summary/QuantityChangesObservable;", "h", "quantityChanges", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "c", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "converter", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "l", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "<init>", "(Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;Lcom/avito/android/cart/summary/CartSummaryRepository;Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;Lcom/avito/android/cart/summary/CartSummaryResourceProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ActivityIntentFactory;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryViewModelFactory implements ViewModelProvider.Factory {
    public final CartSummaryAnalyticsTracker a;
    public final CartSummaryRepository b;
    public final CartSummaryItemsConverter c;
    public final CartSummaryResourceProvider d;
    public final AccountStateProvider e;
    public final SchedulersFactory3 f;
    public final ActivityIntentFactory g;
    public final Observable<Pair<ProductItem, Integer>> h;
    public final Observable<ProductItem> i;
    public final Observable<String> j;
    public final Observable<Pair<ProductItem, StepperUsageType>> k;
    public final BaseScreenPerformanceTracker l;

    @Inject
    public CartSummaryViewModelFactory(@NotNull CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker, @NotNull CartSummaryRepository cartSummaryRepository, @NotNull CartSummaryItemsConverter cartSummaryItemsConverter, @NotNull CartSummaryResourceProvider cartSummaryResourceProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Observable<Pair<ProductItem, Integer>> observable, @NotNull Observable<ProductItem> observable2, @NotNull Observable<String> observable3, @NotNull Observable<Pair<ProductItem, StepperUsageType>> observable4, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(cartSummaryAnalyticsTracker, "analytics");
        Intrinsics.checkNotNullParameter(cartSummaryRepository, "repository");
        Intrinsics.checkNotNullParameter(cartSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(cartSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(observable, "quantityChanges");
        Intrinsics.checkNotNullParameter(observable2, "deleteItemObservable");
        Intrinsics.checkNotNullParameter(observable3, "openAdvertDetailsObservable");
        Intrinsics.checkNotNullParameter(observable4, "stepperUsageObservable");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = cartSummaryAnalyticsTracker;
        this.b = cartSummaryRepository;
        this.c = cartSummaryItemsConverter;
        this.d = cartSummaryResourceProvider;
        this.e = accountStateProvider;
        this.f = schedulersFactory3;
        this.g = activityIntentFactory;
        this.h = observable;
        this.i = observable2;
        this.j = observable3;
        this.k = observable4;
        this.l = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new CartSummaryViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }
}
