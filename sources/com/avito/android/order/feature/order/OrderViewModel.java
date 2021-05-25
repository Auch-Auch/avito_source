package com.avito.android.order.feature.order;

import a2.g.r.g;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.order.model.OrderLastUpdate;
import com.avito.android.util.Logs;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/order/feature/order/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onScreenVisible", "()V", "onScreenInvisible", "", "pollingInterval", "Lio/reactivex/rxjava3/core/Observable;", "getNewIntervalEmitter", "(J)Lio/reactivex/rxjava3/core/Observable;", "c", "Landroidx/lifecycle/LiveData;", g.a, "Landroidx/lifecycle/LiveData;", "getFetchOrderEvent", "()Landroidx/lifecycle/LiveData;", "fetchOrderEvent", "Lcom/avito/android/order/feature/order/OrderRepository;", "h", "Lcom/avito/android/order/feature/order/OrderRepository;", "repository", "J", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "fetchOrderEventInternal", "", "e", "I", "lastUpdate", "<init>", "(Lcom/avito/android/order/feature/order/OrderRepository;)V", "order_release"}, k = 1, mv = {1, 4, 2})
public class OrderViewModel extends ViewModel {
    public long c = 2;
    public final CompositeDisposable d = new CompositeDisposable();
    public int e;
    public final SingleLiveEvent<Unit> f;
    @NotNull
    public final LiveData<Unit> g;
    public final OrderRepository h;

    public static final class a<T, R> implements Function<Long, SingleSource<? extends TypedResult<OrderLastUpdate>>> {
        public final /* synthetic */ OrderViewModel a;

        public a(OrderViewModel orderViewModel) {
            this.a = orderViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends TypedResult<OrderLastUpdate>> apply(Long l) {
            return this.a.h.getOrderLastUpdate();
        }
    }

    public static final class b<T> implements Consumer<TypedResult<OrderLastUpdate>> {
        public final /* synthetic */ OrderViewModel a;

        public b(OrderViewModel orderViewModel) {
            this.a = orderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<OrderLastUpdate> typedResult) {
            TypedResult<OrderLastUpdate> typedResult2 = typedResult;
            OrderViewModel orderViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            OrderViewModel.access$handleOrderLastUpdateResult(orderViewModel, typedResult2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("OrderViewModel", th);
        }
    }

    public OrderViewModel(@NotNull OrderRepository orderRepository) {
        Intrinsics.checkNotNullParameter(orderRepository, "repository");
        this.h = orderRepository;
        SingleLiveEvent<Unit> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        this.g = singleLiveEvent;
    }

    public static final void access$handleOrderLastUpdateResult(OrderViewModel orderViewModel, TypedResult typedResult) {
        Objects.requireNonNull(orderViewModel);
        if (typedResult instanceof TypedResult.OfError) {
            Logs.warning$default("OrderViewModel", ((TypedResult.OfError) typedResult).getError().getMessage(), null, 4, null);
        } else if (typedResult instanceof TypedResult.OfResult) {
            OrderLastUpdate orderLastUpdate = (OrderLastUpdate) ((TypedResult.OfResult) typedResult).getResult();
            if (orderLastUpdate.getPollingIntervalSec() <= 0) {
                orderViewModel.d.clear();
                return;
            }
            int i = orderViewModel.e;
            if (!(i == 0 || i == orderLastUpdate.getLastUpdate())) {
                orderViewModel.f.setValue(Unit.INSTANCE);
            }
            orderViewModel.e = orderLastUpdate.getLastUpdate();
            long pollingIntervalSec = (long) orderLastUpdate.getPollingIntervalSec();
            if (orderViewModel.c != pollingIntervalSec) {
                orderViewModel.c = pollingIntervalSec;
                orderViewModel.d.clear();
                orderViewModel.c();
            }
        }
    }

    public final void c() {
        Disposable subscribe = getNewIntervalEmitter(this.c).flatMapSingle(new a(this)).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "getNewIntervalEmitter(po… { Logs.error(TAG, it) })");
        DisposableKt.addTo(subscribe, this.d);
    }

    @NotNull
    public final LiveData<Unit> getFetchOrderEvent() {
        return this.g;
    }

    @VisibleForTesting
    @NotNull
    public Observable<Long> getNewIntervalEmitter(long j) {
        Observable<Long> interval = Observable.interval(j, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(interval, "Observable.interval(poll…terval, TimeUnit.SECONDS)");
        return interval;
    }

    public final void onScreenInvisible() {
        this.d.clear();
    }

    public final void onScreenVisible() {
        this.f.setValue(Unit.INSTANCE);
        c();
    }
}
