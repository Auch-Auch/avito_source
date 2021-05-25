package com.avito.android.delivery.order_cancellation;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.OrderCancellationReasons;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\bZ\u0010[J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010#R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002070%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010(R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R(\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010!\u001a\u0004\b@\u0010#R\"\u0010D\u001a\b\u0012\u0004\u0012\u00020\f018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bC\u00105R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010U\u001a\b\u0012\u0004\u0012\u00020;0:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010=\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006\\"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "force", "requestReasons", "(Z)V", "", "getCommentMaxLength", "()I", "onCleared", "()V", "c", "", "s", "Ljava/lang/String;", AnalyticFieldsName.orderId, "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "t", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "p", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "i", "Landroidx/lifecycle/MutableLiveData;", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "", "Lcom/avito/android/remote/model/ReasonRds;", "h", "Ljava/util/List;", "reasons", "l", "getSnackbarChanges", "snackbarChanges", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "k", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getReasonDetailsChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "reasonDetailsChanges", "Lcom/avito/conveyor_item/Item;", g.a, PlatformActions.ItemsList.TYPE, "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItem;", "e", "Lcom/jakewharton/rxrelay2/Relay;", "reasonClickRelay", "j", "getDataChanges", "dataChanges", AuthSource.OPEN_CHANNEL_LIST, "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "o", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "I", "commentMaxLength", "f", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "n", "getReasonClickConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "reasonClickConsumer", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", VKApiConst.Q, "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "itemsConverter", "<init>", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationReasonsViewModelImpl extends ViewModel implements RdsOrderCancellationReasonsViewModel {
    public int c = 1000;
    public final CompositeDisposable d = new CompositeDisposable();
    public final Relay<ReasonItem> e;
    public AdapterPresenter f;
    public List<? extends Item> g;
    public List<ReasonRds> h;
    @NotNull
    public final MutableLiveData<LoadingState<?>> i;
    @NotNull
    public final MutableLiveData<List<ReasonRds>> j;
    @NotNull
    public final SingleLiveEvent<ReasonRds> k;
    @NotNull
    public final MutableLiveData<String> l;
    @NotNull
    public final SingleLiveEvent<Integer> m;
    @NotNull
    public final Relay<ReasonItem> n;
    public final RdsOrderCancellationInteractor o;
    public final OrderCancellationResourceProvider p;
    public final RdsOrderCancellationItemsConverter q;
    public final SchedulersFactory r;
    public final String s;
    public final BaseScreenPerformanceTracker t;

    public static final class a<T> implements Consumer<LoadingState<? super OrderCancellationReasons>> {
        public final /* synthetic */ RdsOrderCancellationReasonsViewModelImpl a;

        public a(RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl) {
            this.a = rdsOrderCancellationReasonsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super OrderCancellationReasons> loadingState) {
            LoadingState<? super OrderCancellationReasons> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.t.trackLoaded();
                this.a.t.startPreparing();
                ArrayList arrayList = new ArrayList();
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                List<ReasonRds> reasons = ((OrderCancellationReasons) loaded.getData()).getReasons();
                if (reasons != null) {
                    arrayList.addAll(t6.n.d.shuffled(reasons));
                }
                ReasonRds otherReason = ((OrderCancellationReasons) loaded.getData()).getOtherReason();
                if (otherReason != null) {
                    arrayList.add(otherReason);
                }
                if (arrayList.isEmpty()) {
                    this.a.getCloseScreenChanges().setValue(0);
                    return;
                }
                List<Item> convert = this.a.q.convert(arrayList);
                this.a.g = convert;
                this.a.h = arrayList;
                this.a.t.trackPrepared();
                this.a.t.startDrawing();
                AdapterPresenter adapterPresenter = this.a.f;
                if (adapterPresenter != null) {
                    a2.b.a.a.a.s1(convert, adapterPresenter);
                }
                this.a.getProgressChanges().setValue(loadingState2);
                this.a.t.trackDrawn();
                RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl = this.a;
                Integer commentMaxLength = ((OrderCancellationReasons) loaded.getData()).getCommentMaxLength();
                rdsOrderCancellationReasonsViewModelImpl.c = commentMaxLength != null ? commentMaxLength.intValue() : 1000;
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.t.trackLoadingError();
                this.a.t.startDrawing();
                this.a.getProgressChanges().setValue(loadingState2);
                this.a.t.trackDrawnError();
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.getProgressChanges().setValue(loadingState2);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ RdsOrderCancellationReasonsViewModelImpl a;

        public b(RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl) {
            this.a = rdsOrderCancellationReasonsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(th2);
            MutableLiveData<LoadingState<?>> progressChanges = this.a.getProgressChanges();
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            progressChanges.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown("", th2)));
        }
    }

    public static final class c<T> implements Consumer<ReasonItem> {
        public final /* synthetic */ RdsOrderCancellationReasonsViewModelImpl a;

        public c(RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl) {
            this.a = rdsOrderCancellationReasonsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ReasonItem reasonItem) {
            T t;
            ReasonItem reasonItem2 = reasonItem;
            SingleLiveEvent<ReasonRds> reasonDetailsChanges = this.a.getReasonDetailsChanges();
            Iterator<T> it = RdsOrderCancellationReasonsViewModelImpl.access$getReasons$p(this.a).iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getId(), reasonItem2.getStringId())) {
                    break;
                }
            }
            reasonDetailsChanges.setValue(t);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ RdsOrderCancellationReasonsViewModelImpl a;

        public d(RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl) {
            this.a = rdsOrderCancellationReasonsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().setValue(this.a.p.getErrorOccurred());
            this.a.c();
        }
    }

    public RdsOrderCancellationReasonsViewModelImpl(@NotNull RdsOrderCancellationInteractor rdsOrderCancellationInteractor, @NotNull OrderCancellationResourceProvider orderCancellationResourceProvider, @NotNull RdsOrderCancellationItemsConverter rdsOrderCancellationItemsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(rdsOrderCancellationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(rdsOrderCancellationItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.o = rdsOrderCancellationInteractor;
        this.p = orderCancellationResourceProvider;
        this.q = rdsOrderCancellationItemsConverter;
        this.r = schedulersFactory;
        this.s = str;
        this.t = baseScreenPerformanceTracker;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.e = create;
        this.g = CollectionsKt__CollectionsKt.emptyList();
        this.i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new SingleLiveEvent<>();
        this.l = new MutableLiveData<>();
        this.m = new SingleLiveEvent<>();
        this.n = create;
        requestReasons(true);
        c();
    }

    public static final /* synthetic */ List access$getReasons$p(RdsOrderCancellationReasonsViewModelImpl rdsOrderCancellationReasonsViewModelImpl) {
        List<ReasonRds> list = rdsOrderCancellationReasonsViewModelImpl.h;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasons");
        }
        return list;
    }

    public final void c() {
        Disposable subscribe = this.e.observeOn(this.r.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "reasonClickRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.d);
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    public int getCommentMaxLength() {
        return this.c;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.d.clear();
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    public void requestReasons(boolean z) {
        if (z || this.h == null) {
            this.t.startLoading();
            Disposable subscribe = this.o.getReasons(this.s).observeOn(this.r.mainThread()).subscribe(new a(this), new b(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getReasons(or…          }\n            )");
            DisposableKt.addTo(subscribe, this.d);
            return;
        }
        MutableLiveData<LoadingState<?>> progressChanges = getProgressChanges();
        List<ReasonRds> list = this.h;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasons");
        }
        progressChanges.setValue(new LoadingState.Loaded(list));
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        this.f = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.g));
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public SingleLiveEvent<Integer> getCloseScreenChanges() {
        return this.m;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public MutableLiveData<List<ReasonRds>> getDataChanges() {
        return this.j;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.i;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public Relay<ReasonItem> getReasonClickConsumer() {
        return this.n;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public SingleLiveEvent<ReasonRds> getReasonDetailsChanges() {
        return this.k;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel
    @NotNull
    public MutableLiveData<String> getSnackbarChanges() {
        return this.l;
    }
}
