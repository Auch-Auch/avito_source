package com.avito.android.delivery.order_cancellation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.di.qualifier.OrderId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b \u0010!J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "", "e", "Ljava/lang/String;", AnalyticFieldsName.orderId, "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "interactor", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "c", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "itemsConverter", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationReasonsViewModelFactory implements ViewModelProvider.Factory {
    public final RdsOrderCancellationInteractor a;
    public final OrderCancellationResourceProvider b;
    public final RdsOrderCancellationItemsConverter c;
    public final SchedulersFactory d;
    public String e;
    public final BaseScreenPerformanceTracker f;

    @Inject
    public RdsOrderCancellationReasonsViewModelFactory(@NotNull RdsOrderCancellationInteractor rdsOrderCancellationInteractor, @NotNull OrderCancellationResourceProvider orderCancellationResourceProvider, @NotNull RdsOrderCancellationItemsConverter rdsOrderCancellationItemsConverter, @NotNull SchedulersFactory schedulersFactory, @OrderId @NotNull String str, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(rdsOrderCancellationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(rdsOrderCancellationItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = rdsOrderCancellationInteractor;
        this.b = orderCancellationResourceProvider;
        this.c = rdsOrderCancellationItemsConverter;
        this.d = schedulersFactory;
        this.e = str;
        this.f = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(RdsOrderCancellationReasonsViewModelImpl.class)) {
            return new RdsOrderCancellationReasonsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
