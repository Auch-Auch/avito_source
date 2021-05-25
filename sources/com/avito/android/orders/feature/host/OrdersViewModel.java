package com.avito.android.orders.feature.host;

import a2.g.r.g;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverter;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.model.OrdersModel;
import com.avito.android.remote.orders.model.OrdersTab;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.Event;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0002HIB1\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u00109\u001a\u0004\u0018\u000106¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010)R\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020,028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u00104R\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00100¨\u0006J"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel;", "Landroidx/lifecycle/ViewModel;", "", "tabIndex", "", "onRefresh", "(I)V", "onRetry", "()V", "onVisible", "onInvisible", "onCleared", "", "fullScreenLoading", "c", "(Z)V", "e", "Lcom/avito/android/remote/error/TypedError;", "error", "d", "(Lcom/avito/android/remote/error/TypedError;)V", "", "Lcom/avito/android/orders/feature/host/OrdersViewModel$TabData;", g.a, "Ljava/util/List;", "getInitialData", "()Ljava/util/List;", "setInitialData", "(Ljava/util/List;)V", "initialData", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "l", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "tabItemConverter", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "itemConverter", "I", "selectedTabIndex", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "h", "Landroidx/lifecycle/LiveData;", "getScreenStateChanges", "()Landroidx/lifecycle/LiveData;", "screenStateChanges", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "selectedTabIndexLiveData", "", "n", "Ljava/lang/String;", "initialTabId", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "k", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/orders/feature/host/OrdersRepository;", "j", "Lcom/avito/android/orders/feature/host/OrdersRepository;", "repository", "screenStateLiveData", "i", "getSelectedTabIndexChanges", "selectedTabIndexChanges", "<init>", "(Lcom/avito/android/orders/feature/host/OrdersRepository;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;Ljava/lang/String;)V", "OrdersLoadingState", "TabData", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public int d = -1;
    public final MutableLiveData<OrdersLoadingState> e;
    public final MutableLiveData<Integer> f;
    @NotNull
    public List<TabData> g;
    @NotNull
    public final LiveData<OrdersLoadingState> h;
    @NotNull
    public final LiveData<Integer> i;
    public final OrdersRepository j;
    public final TypedErrorThrowableConverter k;
    public final OrdersTabItemConverter l;
    public final OrdersItemConverter m;
    public String n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "", "<init>", "()V", "ErrorFullScreen", "ErrorPartScreen", "Loaded", "Loading", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$Loaded;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$Loading;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorFullScreen;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorPartScreen;", "orders_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class OrdersLoadingState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorFullScreen;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "Lcom/avito/android/remote/error/TypedError;", "component1", "()Lcom/avito/android/remote/error/TypedError;", "error", "copy", "(Lcom/avito/android/remote/error/TypedError;)Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorFullScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedError;", "getError", "<init>", "(Lcom/avito/android/remote/error/TypedError;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class ErrorFullScreen extends OrdersLoadingState {
            @NotNull
            public final TypedError a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ErrorFullScreen(@NotNull TypedError typedError) {
                super(null);
                Intrinsics.checkNotNullParameter(typedError, "error");
                this.a = typedError;
            }

            public static /* synthetic */ ErrorFullScreen copy$default(ErrorFullScreen errorFullScreen, TypedError typedError, int i, Object obj) {
                if ((i & 1) != 0) {
                    typedError = errorFullScreen.a;
                }
                return errorFullScreen.copy(typedError);
            }

            @NotNull
            public final TypedError component1() {
                return this.a;
            }

            @NotNull
            public final ErrorFullScreen copy(@NotNull TypedError typedError) {
                Intrinsics.checkNotNullParameter(typedError, "error");
                return new ErrorFullScreen(typedError);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ErrorFullScreen) && Intrinsics.areEqual(this.a, ((ErrorFullScreen) obj).a);
                }
                return true;
            }

            @NotNull
            public final TypedError getError() {
                return this.a;
            }

            public int hashCode() {
                TypedError typedError = this.a;
                if (typedError != null) {
                    return typedError.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ErrorFullScreen(error=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorPartScreen;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "Lcom/avito/android/util/architecture_components/Event;", "Lcom/avito/android/remote/error/TypedError;", "component1", "()Lcom/avito/android/util/architecture_components/Event;", "error", "copy", "(Lcom/avito/android/util/architecture_components/Event;)Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$ErrorPartScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/Event;", "getError", "<init>", "(Lcom/avito/android/util/architecture_components/Event;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class ErrorPartScreen extends OrdersLoadingState {
            @NotNull
            public final Event<TypedError> a;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.architecture_components.Event<? extends com.avito.android.remote.error.TypedError> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ErrorPartScreen(@NotNull Event<? extends TypedError> event) {
                super(null);
                Intrinsics.checkNotNullParameter(event, "error");
                this.a = event;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.orders.feature.host.OrdersViewModel$OrdersLoadingState$ErrorPartScreen */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ErrorPartScreen copy$default(ErrorPartScreen errorPartScreen, Event event, int i, Object obj) {
                if ((i & 1) != 0) {
                    event = errorPartScreen.a;
                }
                return errorPartScreen.copy(event);
            }

            @NotNull
            public final Event<TypedError> component1() {
                return this.a;
            }

            @NotNull
            public final ErrorPartScreen copy(@NotNull Event<? extends TypedError> event) {
                Intrinsics.checkNotNullParameter(event, "error");
                return new ErrorPartScreen(event);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ErrorPartScreen) && Intrinsics.areEqual(this.a, ((ErrorPartScreen) obj).a);
                }
                return true;
            }

            @NotNull
            public final Event<TypedError> getError() {
                return this.a;
            }

            public int hashCode() {
                Event<TypedError> event = this.a;
                if (event != null) {
                    return event.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ErrorPartScreen(error=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$Loaded;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends OrdersLoadingState {
            @NotNull
            public static final Loaded INSTANCE = new Loaded();

            public Loaded() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState$Loading;", "Lcom/avito/android/orders/feature/host/OrdersViewModel$OrdersLoadingState;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends OrdersLoadingState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public OrdersLoadingState() {
        }

        public OrdersLoadingState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModel$TabData;", "", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "component1", "()Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "component2", "()Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "tab", "orderPage", "copy", "(Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;)Lcom/avito/android/orders/feature/host/OrdersViewModel$TabData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "getTab", AuthSource.BOOKING_ORDER, "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "getOrderPage", "<init>", "(Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
    public static final class TabData {
        @NotNull
        public final OrdersTabItem a;
        @NotNull
        public final OrderPage b;

        public TabData(@NotNull OrdersTabItem ordersTabItem, @NotNull OrderPage orderPage) {
            Intrinsics.checkNotNullParameter(ordersTabItem, "tab");
            Intrinsics.checkNotNullParameter(orderPage, "orderPage");
            this.a = ordersTabItem;
            this.b = orderPage;
        }

        public static /* synthetic */ TabData copy$default(TabData tabData, OrdersTabItem ordersTabItem, OrderPage orderPage, int i, Object obj) {
            if ((i & 1) != 0) {
                ordersTabItem = tabData.a;
            }
            if ((i & 2) != 0) {
                orderPage = tabData.b;
            }
            return tabData.copy(ordersTabItem, orderPage);
        }

        @NotNull
        public final OrdersTabItem component1() {
            return this.a;
        }

        @NotNull
        public final OrderPage component2() {
            return this.b;
        }

        @NotNull
        public final TabData copy(@NotNull OrdersTabItem ordersTabItem, @NotNull OrderPage orderPage) {
            Intrinsics.checkNotNullParameter(ordersTabItem, "tab");
            Intrinsics.checkNotNullParameter(orderPage, "orderPage");
            return new TabData(ordersTabItem, orderPage);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TabData)) {
                return false;
            }
            TabData tabData = (TabData) obj;
            return Intrinsics.areEqual(this.a, tabData.a) && Intrinsics.areEqual(this.b, tabData.b);
        }

        @NotNull
        public final OrderPage getOrderPage() {
            return this.b;
        }

        @NotNull
        public final OrdersTabItem getTab() {
            return this.a;
        }

        public int hashCode() {
            OrdersTabItem ordersTabItem = this.a;
            int i = 0;
            int hashCode = (ordersTabItem != null ? ordersTabItem.hashCode() : 0) * 31;
            OrderPage orderPage = this.b;
            if (orderPage != null) {
                i = orderPage.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("TabData(tab=");
            L.append(this.a);
            L.append(", orderPage=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a<T, R> implements Function<TypedResult<OrdersModel>, LoadingState<? super OrdersModel>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super OrdersModel> apply(TypedResult<OrdersModel> typedResult) {
            TypedResult<OrdersModel> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super OrdersModel>> {
        public final /* synthetic */ OrdersViewModel a;

        public b(OrdersViewModel ordersViewModel) {
            this.a = ordersViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super OrdersModel> loadingState) {
            LoadingState<? super OrdersModel> loadingState2 = loadingState;
            OrdersViewModel ordersViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            OrdersViewModel.access$handleOrdersResult(ordersViewModel, loadingState2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ OrdersViewModel a;

        public c(OrdersViewModel ordersViewModel) {
            this.a = ordersViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            OrdersViewModel ordersViewModel = this.a;
            TypedErrorThrowableConverter typedErrorThrowableConverter = ordersViewModel.k;
            Intrinsics.checkNotNullExpressionValue(th2, NotificationCompat.CATEGORY_ERROR);
            ordersViewModel.d(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class d extends Lambda implements Function1<TypedError, Unit> {
        public final /* synthetic */ OrdersViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(OrdersViewModel ordersViewModel) {
            super(1);
            this.a = ordersViewModel;
        }

        public final void a(@NotNull TypedError typedError) {
            Intrinsics.checkNotNullParameter(typedError, "error");
            this.a.e.postValue(new OrdersLoadingState.ErrorPartScreen(new Event(typedError)));
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedError typedError) {
            a(typedError);
            return Unit.INSTANCE;
        }
    }

    public OrdersViewModel(@NotNull OrdersRepository ordersRepository, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull OrdersTabItemConverter ordersTabItemConverter, @NotNull OrdersItemConverter ordersItemConverter, @Nullable String str) {
        Intrinsics.checkNotNullParameter(ordersRepository, "repository");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(ordersTabItemConverter, "tabItemConverter");
        Intrinsics.checkNotNullParameter(ordersItemConverter, "itemConverter");
        this.j = ordersRepository;
        this.k = typedErrorThrowableConverter;
        this.l = ordersTabItemConverter;
        this.m = ordersItemConverter;
        this.n = str;
        MutableLiveData<OrdersLoadingState> mutableLiveData = new MutableLiveData<>();
        this.e = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.f = mutableLiveData2;
        this.g = CollectionsKt__CollectionsKt.emptyList();
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        c(true);
    }

    public static final void access$handleOrdersResult(OrdersViewModel ordersViewModel, LoadingState loadingState) {
        Objects.requireNonNull(ordersViewModel);
        if (loadingState instanceof LoadingState.Loaded) {
            List<OrdersTab> tabs = ((OrdersModel) ((LoadingState.Loaded) loadingState).getData()).getTabs();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tabs, 10));
            for (T t : tabs) {
                arrayList.add(new TabData(ordersViewModel.l.convert(t), new OrderPage(t.getNextPage(), ordersViewModel.m.convert(t.getOrderDataList()), t.getPlaceholder(), t.getClickEvent())));
            }
            ordersViewModel.g = arrayList;
            ordersViewModel.e.postValue(OrdersLoadingState.Loaded.INSTANCE);
            ordersViewModel.e();
        } else if (Intrinsics.areEqual(loadingState, LoadingState.Loading.INSTANCE)) {
            ordersViewModel.e.postValue(OrdersLoadingState.Loading.INSTANCE);
        } else if (loadingState instanceof LoadingState.Error) {
            ordersViewModel.d(((LoadingState.Error) loadingState).getError());
            ordersViewModel.e();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void c(boolean z) {
        Observable observable;
        if (z) {
            observable = Observable.just(LoadingState.Loading.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(LoadingState.Loading)");
        } else {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        }
        Disposable subscribe = this.j.loadOrders().map(a.a).toObservable().startWith(observable).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.loadOrders()\n…onverter.convert(err)) })");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void d(TypedError typedError) {
        d dVar = new d(this);
        OrdersLoadingState value = this.e.getValue();
        if (value instanceof OrdersLoadingState.Loaded) {
            dVar.a(typedError);
        } else if (value instanceof OrdersLoadingState.ErrorPartScreen) {
            dVar.a(typedError);
        } else {
            this.e.postValue(new OrdersLoadingState.ErrorFullScreen(typedError));
        }
    }

    public final void e() {
        Integer value;
        if (!(this.n == null || (value = this.f.getValue()) == null)) {
            int i2 = -1;
            if (value.intValue() == -1) {
                int i3 = 0;
                Iterator<TabData> it = this.g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual(it.next().getTab().getShortcut(), this.n)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                this.d = i2;
            }
        }
        this.f.postValue(Integer.valueOf(this.d));
    }

    @NotNull
    public final List<TabData> getInitialData() {
        return this.g;
    }

    @NotNull
    public final LiveData<OrdersLoadingState> getScreenStateChanges() {
        return this.h;
    }

    @NotNull
    public final LiveData<Integer> getSelectedTabIndexChanges() {
        return this.i;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }

    public final void onInvisible(int i2) {
        this.d = i2;
    }

    public final void onRefresh(int i2) {
        this.n = null;
        this.d = i2;
        c(false);
    }

    public final void onRetry() {
        c(true);
    }

    public final void onVisible() {
        this.f.postValue(Integer.valueOf(this.d));
    }

    public final void setInitialData(@NotNull List<TabData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.g = list;
    }
}
