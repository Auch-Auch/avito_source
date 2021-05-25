package com.avito.android.orders.feature.list;

import a2.a.a.r1.a.b.b;
import a2.a.a.r1.a.b.c;
import a2.a.a.r1.a.b.d;
import a2.a.a.r1.a.b.e;
import a2.a.a.r1.a.b.f;
import a2.a.a.r1.a.b.h;
import a2.a.a.r1.a.b.i;
import a2.g.r.g;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.orders.feature.list.adapter.loading.OrderLoadingItem;
import com.avito.android.orders.feature.list.model.OrdersPagination;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.orders.model.OrdersPlaceholder;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.Event;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0001FB9\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0010\u00106\u001a\f\u0012\u0004\u0012\u00020\u000402j\u0002`3\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\bD\u0010EJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00106\u001a\f\u0012\u0004\u0012\u00020\u000402j\u0002`38\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R(\u0010<\u001a\u00020:8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010;\u0012\u0004\b@\u0010\b\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R%\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0(8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010*\u001a\u0004\bB\u0010,¨\u0006G"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "orderItem", "", "onOrderClick", "(Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;)V", "onListVisible", "()V", "onCleared", "d", "c", "e", "Lcom/avito/android/remote/model/ParametrizedEvent;", "clickEvent", "f", "(Lcom/avito/android/remote/model/ParametrizedEvent;)V", "Lcom/avito/android/orders/feature/list/model/OrdersPagination;", g.a, "Lcom/avito/android/orders/feature/list/model/OrdersPagination;", "data", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "l", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "itemConverter", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/architecture_components/Event;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroidx/lifecycle/MutableLiveData;", "orderClicks", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "n", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "initialData", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState;", "dataChanges", "Landroidx/lifecycle/LiveData;", "h", "Landroidx/lifecycle/LiveData;", "getDataLiveData", "()Landroidx/lifecycle/LiveData;", "dataLiveData", "Lcom/avito/android/orders/feature/list/OrdersListRepository;", "j", "Lcom/avito/android/orders/feature/list/OrdersListRepository;", "repository", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreObservable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/core/Observable;", "loadMoreObservable", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "", "Z", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$annotations", "i", "getOrderLiveData", "orderLiveData", "<init>", "(Lcom/avito/android/orders/feature/list/OrdersListRepository;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;)V", "OrderListState", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersListViewModel extends ViewModel {
    public final CompositeDisposable c;
    public final MutableLiveData<OrderListState> d;
    public final MutableLiveData<Event<DeepLink>> e;
    public boolean f;
    public OrdersPagination g;
    @NotNull
    public final LiveData<OrderListState> h;
    @NotNull
    public final LiveData<Event<DeepLink>> i;
    public final OrdersListRepository j;
    public final Analytics k;
    public final OrdersItemConverter l;
    public final Observable<Unit> m;
    public final OrderPage n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState;", "", "<init>", "()V", "Content", "Empty", "Error", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Content;", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Empty;", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Error;", "orders_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class OrderListState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Content;", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState;", "", "Lcom/avito/konveyor/blueprint/Item;", "component1", "()Ljava/util/List;", "orderItems", "copy", "(Ljava/util/List;)Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Content;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getOrderItems", "<init>", "(Ljava/util/List;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class Content extends OrderListState {
            @NotNull
            public final List<Item> a;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Content(@NotNull List<? extends Item> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "orderItems");
                this.a = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.orders.feature.list.OrdersListViewModel$OrderListState$Content */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Content copy$default(Content content, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = content.a;
                }
                return content.copy(list);
            }

            @NotNull
            public final List<Item> component1() {
                return this.a;
            }

            @NotNull
            public final Content copy(@NotNull List<? extends Item> list) {
                Intrinsics.checkNotNullParameter(list, "orderItems");
                return new Content(list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Content) && Intrinsics.areEqual(this.a, ((Content) obj).a);
                }
                return true;
            }

            @NotNull
            public final List<Item> getOrderItems() {
                return this.a;
            }

            public int hashCode() {
                List<Item> list = this.a;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.w(a2.b.a.a.a.L("Content(orderItems="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Empty;", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState;", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "component1", "()Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", InternalConstsKt.PLACEHOLDER, "copy", "(Lcom/avito/android/remote/orders/model/OrdersPlaceholder;)Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "getPlaceholder", "<init>", "(Lcom/avito/android/remote/orders/model/OrdersPlaceholder;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends OrderListState {
            @NotNull
            public final OrdersPlaceholder a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Empty(@NotNull OrdersPlaceholder ordersPlaceholder) {
                super(null);
                Intrinsics.checkNotNullParameter(ordersPlaceholder, InternalConstsKt.PLACEHOLDER);
                this.a = ordersPlaceholder;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, OrdersPlaceholder ordersPlaceholder, int i, Object obj) {
                if ((i & 1) != 0) {
                    ordersPlaceholder = empty.a;
                }
                return empty.copy(ordersPlaceholder);
            }

            @NotNull
            public final OrdersPlaceholder component1() {
                return this.a;
            }

            @NotNull
            public final Empty copy(@NotNull OrdersPlaceholder ordersPlaceholder) {
                Intrinsics.checkNotNullParameter(ordersPlaceholder, InternalConstsKt.PLACEHOLDER);
                return new Empty(ordersPlaceholder);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Empty) && Intrinsics.areEqual(this.a, ((Empty) obj).a);
                }
                return true;
            }

            @NotNull
            public final OrdersPlaceholder getPlaceholder() {
                return this.a;
            }

            public int hashCode() {
                OrdersPlaceholder ordersPlaceholder = this.a;
                if (ordersPlaceholder != null) {
                    return ordersPlaceholder.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Empty(placeholder=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Error;", "Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState;", "Lcom/avito/android/util/architecture_components/Event;", "Lcom/avito/android/remote/error/TypedError;", "component1", "()Lcom/avito/android/util/architecture_components/Event;", "", "Lcom/avito/konveyor/blueprint/Item;", "component2", "()Ljava/util/List;", "error", "orderItems", "copy", "(Lcom/avito/android/util/architecture_components/Event;Ljava/util/List;)Lcom/avito/android/orders/feature/list/OrdersListViewModel$OrderListState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getOrderItems", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/Event;", "getError", "<init>", "(Lcom/avito/android/util/architecture_components/Event;Ljava/util/List;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends OrderListState {
            @NotNull
            public final Event<TypedError> a;
            @NotNull
            public final List<Item> b;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.architecture_components.Event<? extends com.avito.android.remote.error.TypedError> */
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Event<? extends TypedError> event, @NotNull List<? extends Item> list) {
                super(null);
                Intrinsics.checkNotNullParameter(event, "error");
                Intrinsics.checkNotNullParameter(list, "orderItems");
                this.a = event;
                this.b = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.orders.feature.list.OrdersListViewModel$OrderListState$Error */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Error copy$default(Error error, Event event, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    event = error.a;
                }
                if ((i & 2) != 0) {
                    list = error.b;
                }
                return error.copy(event, list);
            }

            @NotNull
            public final Event<TypedError> component1() {
                return this.a;
            }

            @NotNull
            public final List<Item> component2() {
                return this.b;
            }

            @NotNull
            public final Error copy(@NotNull Event<? extends TypedError> event, @NotNull List<? extends Item> list) {
                Intrinsics.checkNotNullParameter(event, "error");
                Intrinsics.checkNotNullParameter(list, "orderItems");
                return new Error(event, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.a, error.a) && Intrinsics.areEqual(this.b, error.b);
            }

            @NotNull
            public final Event<TypedError> getError() {
                return this.a;
            }

            @NotNull
            public final List<Item> getOrderItems() {
                return this.b;
            }

            public int hashCode() {
                Event<TypedError> event = this.a;
                int i = 0;
                int hashCode = (event != null ? event.hashCode() : 0) * 31;
                List<Item> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Error(error=");
                L.append(this.a);
                L.append(", orderItems=");
                return a2.b.a.a.a.w(L, this.b, ")");
            }
        }

        public OrderListState() {
        }

        public OrderListState(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<com.avito.conveyor_item.Item, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(com.avito.conveyor_item.Item item) {
            com.avito.conveyor_item.Item item2 = item;
            Intrinsics.checkNotNullParameter(item2, "it");
            return Boolean.valueOf(item2 instanceof OrderLoadingItem);
        }
    }

    public OrdersListViewModel(@NotNull OrdersListRepository ordersListRepository, @NotNull Analytics analytics, @NotNull OrdersItemConverter ordersItemConverter, @NotNull Observable<Unit> observable, @NotNull OrderPage orderPage) {
        Intrinsics.checkNotNullParameter(ordersListRepository, "repository");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(ordersItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(observable, "loadMoreObservable");
        Intrinsics.checkNotNullParameter(orderPage, "initialData");
        this.j = ordersListRepository;
        this.k = analytics;
        this.l = ordersItemConverter;
        this.m = observable;
        this.n = orderPage;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        MutableLiveData<OrderListState> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Event<DeepLink>> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        this.g = new OrdersPagination(orderPage.getNextPage(), orderPage.getOrderItems());
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        if (orderPage.getOrderItems().isEmpty()) {
            OrdersPlaceholder placeholder = orderPage.getPlaceholder();
            Intrinsics.checkNotNull(placeholder);
            mutableLiveData.setValue(new OrderListState.Empty(placeholder));
        } else {
            c();
            d();
        }
        Disposable subscribe = observable.throttleFirst(800, TimeUnit.MILLISECONDS).flatMap(new d(this)).doOnNext(new e(this)).flatMap(new f(this)).flatMap(new a2.a.a.r1.a.b.g(this)).doOnNext(new h(this)).subscribe(new i(this), a2.a.a.r1.a.b.j.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "loadMoreObservable\n     …or(error) }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    public static final Observable access$fetchNextPage(OrdersListViewModel ordersListViewModel, String str) {
        Objects.requireNonNull(ordersListViewModel);
        Observable map = Observable.just(str).flatMapSingle(new a2.a.a.r1.a.b.a(ordersListViewModel)).map(b.a).map(new c(ordersListViewModel));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(nextPage…          }\n            }");
        return map;
    }

    public static final void access$handleLoadingError(OrdersListViewModel ordersListViewModel, LoadingState.Error error) {
        ordersListViewModel.e();
        ordersListViewModel.d.postValue(new OrderListState.Error(new Event(error.getError()), ordersListViewModel.g.getOrderItems()));
    }

    public static final void access$handleNewPageLoaded(OrdersListViewModel ordersListViewModel, LoadingState.Loaded loaded) {
        ordersListViewModel.g = ordersListViewModel.g.copy(((OrdersPagination) loaded.getData()).getNextPage(), CollectionsKt___CollectionsKt.plus((Collection) ordersListViewModel.g.getOrderItems(), (Iterable) ((OrdersPagination) loaded.getData()).getOrderItems()));
        ordersListViewModel.c();
        ordersListViewModel.d();
    }

    @VisibleForTesting
    public static /* synthetic */ void isLoading$annotations() {
    }

    public final void c() {
        e();
        String nextPage = this.g.getNextPage();
        boolean z = false;
        if (nextPage != null) {
            if (nextPage.length() > 0) {
                z = true;
            }
        }
        if (z) {
            OrdersPagination ordersPagination = this.g;
            this.g = OrdersPagination.copy$default(ordersPagination, null, CollectionsKt___CollectionsKt.plus((Collection<? extends OrderLoadingItem>) ordersPagination.getOrderItems(), OrderLoadingItem.INSTANCE), 1, null);
        }
    }

    public final void d() {
        this.d.postValue(new OrderListState.Content(this.g.getOrderItems()));
    }

    public final void e() {
        OrdersPagination ordersPagination = this.g;
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ordersPagination.getOrderItems());
        t6.n.h.removeAll(mutableList, (Function1) a.a);
        this.g = OrdersPagination.copy$default(ordersPagination, null, mutableList, 1, null);
    }

    public final void f(ParametrizedEvent parametrizedEvent) {
        Analytics analytics = this.k;
        int id = parametrizedEvent.getId();
        int version = parametrizedEvent.getVersion();
        Map<String, String> parameters = parametrizedEvent.getParameters();
        if (parameters == null) {
            parameters = r.emptyMap();
        }
        analytics.track(new ParametrizedClickStreamEvent(id, version, parameters, null, 8, null));
    }

    @NotNull
    public final LiveData<OrderListState> getDataLiveData() {
        return this.h;
    }

    @NotNull
    public final LiveData<Event<DeepLink>> getOrderLiveData() {
        return this.i;
    }

    public final boolean isLoading() {
        return this.f;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }

    public final void onListVisible() {
        f(this.n.getClickEvent());
    }

    public final void onOrderClick(@NotNull OrderItem orderItem) {
        Intrinsics.checkNotNullParameter(orderItem, "orderItem");
        f(orderItem.getClickEvent());
        this.e.setValue(new Event<>(orderItem.getDeepLink()));
    }

    public final void setLoading(boolean z) {
        this.f = z;
    }
}
