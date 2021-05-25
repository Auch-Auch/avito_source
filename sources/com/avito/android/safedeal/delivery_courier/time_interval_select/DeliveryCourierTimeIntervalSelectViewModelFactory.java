package com.avito.android.safedeal.delivery_courier.time_interval_select;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", g.a, "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "tracker", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "d", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "interactor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "orderID", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "f", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "resourceProvider", AuthSource.BOOKING_ORDER, "source", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "c", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final TimeInterval c;
    public final DeliveryCourierTimeIntervalSelectInteractor d;
    public final SchedulersFactory e;
    public final DeliveryCourierTimeIntervalSelectResourceProvider f;
    public final DeliveryCourierTimeIntervalSelectAnalyticsTracker g;

    public DeliveryCourierTimeIntervalSelectViewModelFactory(@NotNull String str, @NotNull String str2, @Nullable TimeInterval timeInterval, @NotNull DeliveryCourierTimeIntervalSelectInteractor deliveryCourierTimeIntervalSelectInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierTimeIntervalSelectResourceProvider deliveryCourierTimeIntervalSelectResourceProvider, @NotNull DeliveryCourierTimeIntervalSelectAnalyticsTracker deliveryCourierTimeIntervalSelectAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectAnalyticsTracker, "tracker");
        this.a = str;
        this.b = str2;
        this.c = timeInterval;
        this.d = deliveryCourierTimeIntervalSelectInteractor;
        this.e = schedulersFactory;
        this.f = deliveryCourierTimeIntervalSelectResourceProvider;
        this.g = deliveryCourierTimeIntervalSelectAnalyticsTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryCourierTimeIntervalSelectViewModelImpl.class)) {
            return new DeliveryCourierTimeIntervalSelectViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
