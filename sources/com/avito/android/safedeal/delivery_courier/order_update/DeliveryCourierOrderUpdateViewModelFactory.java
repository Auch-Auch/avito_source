package com.avito.android.safedeal.delivery_courier.order_update;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b*\u0010+J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "source", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "f", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "resourceProvider", AuthSource.SEND_ABUSE, "orderID", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "c", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "interactor", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "e", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "itemsConverter", "Lcom/avito/android/account/AccountStateProvider;", "h", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "i", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "performanceTracker", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", g.a, "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "tracker", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final DeliveryCourierOrderUpdateInteractor c;
    public final SchedulersFactory d;
    public final DeliveryCourierItemsConverter e;
    public final DeliveryCourierOrderUpdateResourceProvider f;
    public final DeliveryCourierOrderUpdateAnalyticsTracker g;
    public final AccountStateProvider h;
    public final BaseScreenPerformanceTracker i;

    public DeliveryCourierOrderUpdateViewModelFactory(@NotNull String str, @NotNull String str2, @NotNull DeliveryCourierOrderUpdateInteractor deliveryCourierOrderUpdateInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierItemsConverter deliveryCourierItemsConverter, @NotNull DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider, @NotNull DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker, @NotNull AccountStateProvider accountStateProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "performanceTracker");
        this.a = str;
        this.b = str2;
        this.c = deliveryCourierOrderUpdateInteractor;
        this.d = schedulersFactory;
        this.e = deliveryCourierItemsConverter;
        this.f = deliveryCourierOrderUpdateResourceProvider;
        this.g = deliveryCourierOrderUpdateAnalyticsTracker;
        this.h = accountStateProvider;
        this.i = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryCourierOrderUpdateViewModelImpl.class)) {
            return new DeliveryCourierOrderUpdateViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.i, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
