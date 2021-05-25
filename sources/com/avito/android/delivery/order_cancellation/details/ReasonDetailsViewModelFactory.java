package com.avito.android.delivery.order_cancellation.details;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.delivery.di.qualifier.OrderId;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/remote/model/ReasonRds;", g.a, "Lcom/avito/android/remote/model/ReasonRds;", "reason", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "d", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "itemsConverter", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "f", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "", "h", "Ljava/lang/String;", AnalyticFieldsName.orderId, "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;Lcom/avito/android/remote/model/ReasonRds;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonDetailsViewModelFactory implements ViewModelProvider.Factory {
    public final Analytics a;
    public final RdsOrderCancellationInteractor b;
    public final AccountStateProvider c;
    public final ReasonDetailsItemsConverter d;
    public final SchedulersFactory e;
    public final OrderCancellationResourceProvider f;
    public final ReasonRds g;
    public final String h;

    @Inject
    public ReasonDetailsViewModelFactory(@NotNull Analytics analytics, @NotNull RdsOrderCancellationInteractor rdsOrderCancellationInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull ReasonDetailsItemsConverter reasonDetailsItemsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull OrderCancellationResourceProvider orderCancellationResourceProvider, @NotNull ReasonRds reasonRds, @OrderId @NotNull String str) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(rdsOrderCancellationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(reasonDetailsItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(reasonRds, "reason");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        this.a = analytics;
        this.b = rdsOrderCancellationInteractor;
        this.c = accountStateProvider;
        this.d = reasonDetailsItemsConverter;
        this.e = schedulersFactory;
        this.f = orderCancellationResourceProvider;
        this.g = reasonRds;
        this.h = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ReasonDetailsViewModelImpl.class)) {
            return new ReasonDetailsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalStateException("Unknown ViewModel class");
    }
}
