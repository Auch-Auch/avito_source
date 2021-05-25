package com.avito.android.safedeal.delivery_courier.summary;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.di.qualifier.AdvertId;
import com.avito.android.safedeal.delivery_courier.di.qualifier.SearchContext;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BY\b\u0007\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b*\u0010+J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "f", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "converter", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "i", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "e", "Ljava/lang/String;", "searchContext", "d", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "interactor", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", g.a, "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "resourceProvider", "Lcom/avito/android/account/AccountStateProvider;", "h", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryViewModelFactory implements ViewModelProvider.Factory {
    public final Analytics a;
    public final DeliveryCourierSummaryInteractor b;
    public final SchedulersFactory c;
    public final String d;
    public final String e;
    public final DeliveryCourierSummaryItemsConverter f;
    public final DeliveryCourierSummaryResourceProvider g;
    public final AccountStateProvider h;
    public final BaseScreenPerformanceTracker i;

    @Inject
    public DeliveryCourierSummaryViewModelFactory(@NotNull Analytics analytics, @NotNull DeliveryCourierSummaryInteractor deliveryCourierSummaryInteractor, @NotNull SchedulersFactory schedulersFactory, @AdvertId @Nullable String str, @SearchContext @Nullable String str2, @NotNull DeliveryCourierSummaryItemsConverter deliveryCourierSummaryItemsConverter, @NotNull DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = analytics;
        this.b = deliveryCourierSummaryInteractor;
        this.c = schedulersFactory;
        this.d = str;
        this.e = str2;
        this.f = deliveryCourierSummaryItemsConverter;
        this.g = deliveryCourierSummaryResourceProvider;
        this.h = accountStateProvider;
        this.i = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryCourierSummaryViewModelImpl.class)) {
            return new DeliveryCourierSummaryViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
