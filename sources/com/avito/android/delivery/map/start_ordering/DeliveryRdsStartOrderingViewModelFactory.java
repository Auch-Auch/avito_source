package com.avito.android.delivery.map.start_ordering;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.di.qualifier.AdvertId;
import com.avito.android.delivery.di.qualifier.AnalyticsAdvertId;
import com.avito.android.delivery.di.qualifier.CartFlag;
import com.avito.android.delivery.di.qualifier.CartItems;
import com.avito.android.delivery.di.qualifier.MarketplaceFlag;
import com.avito.android.delivery.di.qualifier.Source;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\f\u0012\b\b\u0001\u0010\u0011\u001a\u00020\f\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010-\u001a\u0004\u0018\u00010*¢\u0006\u0004\b4\u00105J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\nR\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\nR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010\n¨\u00066"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "e", "Ljava/lang/String;", "source", "", "f", "Z", "isMarketplace", g.a, "isCart", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "l", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "interactor", "c", BookingInfoActivity.EXTRA_ITEM_ID, "d", "analyticsAdvertId", "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "i", "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/model/ParametrizedEvent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Lcom/avito/android/account/AccountStateProvider;", "k", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "h", "cartItems", "<init>", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingViewModelFactory implements ViewModelProvider.Factory {
    public final DeliveryRdsStartOrderingInteractor a;
    public final SchedulersFactory3 b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final DeliveryStartOrderingResourceProvider i;
    public final Analytics j;
    public final AccountStateProvider k;
    public final BaseScreenPerformanceTracker l;
    public final ParametrizedEvent m;

    @Inject
    public DeliveryRdsStartOrderingViewModelFactory(@NotNull DeliveryRdsStartOrderingInteractor deliveryRdsStartOrderingInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @AdvertId @Nullable String str, @AnalyticsAdvertId @Nullable String str2, @Source @Nullable String str3, @MarketplaceFlag boolean z, @CartFlag boolean z2, @CartItems @Nullable String str4, @NotNull DeliveryStartOrderingResourceProvider deliveryStartOrderingResourceProvider, @NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(deliveryRdsStartOrderingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryStartOrderingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = deliveryRdsStartOrderingInteractor;
        this.b = schedulersFactory3;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = z;
        this.g = z2;
        this.h = str4;
        this.i = deliveryStartOrderingResourceProvider;
        this.j = analytics;
        this.k = accountStateProvider;
        this.l = baseScreenPerformanceTracker;
        this.m = parametrizedEvent;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryRdsStartOrderingViewModelImpl.class)) {
            return new DeliveryRdsStartOrderingViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.l, this.m, this.k);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
