package com.avito.android.delivery.order_cancellation.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.delivery.analytics.order_cancellation.OrderCancellationEvent;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Option;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\bc\u0010dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0005R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R$\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010\u0017\u001a\u0004\b7\u0010\u0019R\u0018\u0010:\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010 R\u001e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\r0C8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\"\u0010K\u001a\b\u0012\u0004\u0012\u00020<0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010\u0017\u001a\u0004\bJ\u0010\u0019R\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010,\u001a\u0004\bY\u0010.R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "", "e", "()V", "f", "c", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "getSelectedRadioButtonId", "()Ljava/lang/Integer;", "onCleared", "Lcom/avito/android/remote/model/Option;", "h", "Lcom/avito/android/remote/model/Option;", "selectedOption", "Lcom/jakewharton/rxrelay2/Relay;", "n", "Lcom/jakewharton/rxrelay2/Relay;", "getCancelOrderButtonClickConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "cancelOrderButtonClickConsumer", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "", "x", "Ljava/lang/String;", AnalyticFieldsName.orderId, "Lcom/avito/android/account/AccountStateProvider;", "s", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/remote/model/ReasonRds;", "w", "Lcom/avito/android/remote/model/ReasonRds;", "reason", "Landroidx/lifecycle/MutableLiveData;", "l", "Landroidx/lifecycle/MutableLiveData;", "getSnackbarChanges", "()Landroidx/lifecycle/MutableLiveData;", "snackbarChanges", "cancelOrderButtonClicksRelay", "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "analytics", "", "o", "getCommentChangesConsumer", "commentChangesConsumer", a2.g.r.g.a, "commentText", "commentChangesRelay", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "radioGroupChangesRelay", "", "Lcom/avito/conveyor_item/Item;", "j", "Ljava/util/List;", PlatformActions.ItemsList.TYPE, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "k", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCloseScreenChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "closeScreenChanges", "p", "getRadioGroupChangesConsumer", "radioGroupChangesConsumer", "Lcom/avito/android/util/SchedulersFactory;", "u", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "t", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "itemsConverter", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", AuthSource.OPEN_CHANNEL_LIST, "getButtonStateChanges", "buttonStateChanges", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "r", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "interactor", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", VKApiConst.VERSION, "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;Lcom/avito/android/remote/model/ReasonRds;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonDetailsViewModelImpl extends ViewModel implements ReasonDetailsViewModel {
    public final Relay<Unit> c;
    public final Relay<CharSequence> d;
    public final Relay<ParameterElement.Select> e;
    public final CompositeDisposable f = new CompositeDisposable();
    public String g;
    public Option h;
    public AdapterPresenter i;
    public List<? extends Item> j = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    public final SingleLiveEvent<Integer> k = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<String> l = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> m = new MutableLiveData<>();
    @NotNull
    public final Relay<Unit> n;
    @NotNull
    public final Relay<CharSequence> o;
    @NotNull
    public final Relay<ParameterElement.Select> p;
    public final Analytics q;
    public final RdsOrderCancellationInteractor r;
    public final AccountStateProvider s;
    public final ReasonDetailsItemsConverter t;
    public final SchedulersFactory u;
    public final OrderCancellationResourceProvider v;
    public final ReasonRds w;
    public final String x;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public a(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            ReasonDetailsViewModelImpl reasonDetailsViewModelImpl = this.a;
            ReasonDetailsViewModelImpl.access$sendReason(reasonDetailsViewModelImpl, reasonDetailsViewModelImpl.h, this.a.g);
            ReasonDetailsViewModelImpl reasonDetailsViewModelImpl2 = this.a;
            ReasonDetailsViewModelImpl.access$cancelOrder(reasonDetailsViewModelImpl2, reasonDetailsViewModelImpl2.x);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public b(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().setValue(this.a.v.getErrorOccurred());
            this.a.c();
        }
    }

    public static final class c<T> implements Consumer<CharSequence> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public c(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            this.a.g = charSequence2 != null ? charSequence2.toString() : null;
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public d(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().postValue(this.a.v.getErrorOccurred());
            this.a.d();
        }
    }

    public static final class e<T> implements Consumer<List<? extends Item>> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public e(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            AdapterPresenter adapterPresenter = this.a.i;
            if (adapterPresenter != null) {
                Intrinsics.checkNotNullExpressionValue(list2, "it");
                adapterPresenter.onDataSourceChanged(new ListDataSource(list2));
            }
            ReasonDetailsViewModelImpl reasonDetailsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            reasonDetailsViewModelImpl.j = list2;
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public f(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().setValue(this.a.v.getErrorOccurred());
            this.a.e();
        }
    }

    public static final class g<T> implements Consumer<ParameterElement.Select> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public g(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Select select) {
            ParameterElement.Select select2 = select;
            ReasonDetailsViewModelImpl reasonDetailsViewModelImpl = this.a;
            List<Option> options = reasonDetailsViewModelImpl.w.getOptions();
            Option option = null;
            if (options != null) {
                Iterator<T> it = options.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    T t = next;
                    SelectableItem selectedValue = select2.getSelectedValue();
                    if (Intrinsics.areEqual(selectedValue != null ? selectedValue.getStringId() : null, t.getId())) {
                        option = next;
                        break;
                    }
                }
                option = option;
            }
            reasonDetailsViewModelImpl.h = option;
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReasonDetailsViewModelImpl a;

        public h(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
            this.a = reasonDetailsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().setValue(this.a.v.getErrorOccurred());
            this.a.f();
        }
    }

    public ReasonDetailsViewModelImpl(@NotNull Analytics analytics, @NotNull RdsOrderCancellationInteractor rdsOrderCancellationInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull ReasonDetailsItemsConverter reasonDetailsItemsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull OrderCancellationResourceProvider orderCancellationResourceProvider, @NotNull ReasonRds reasonRds, @NotNull String str) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(rdsOrderCancellationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(reasonDetailsItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(reasonRds, "reason");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        this.q = analytics;
        this.r = rdsOrderCancellationInteractor;
        this.s = accountStateProvider;
        this.t = reasonDetailsItemsConverter;
        this.u = schedulersFactory;
        this.v = orderCancellationResourceProvider;
        this.w = reasonRds;
        this.x = str;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.c = create;
        BehaviorRelay create2 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "BehaviorRelay.create()");
        this.d = create2;
        BehaviorRelay create3 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "BehaviorRelay.create()");
        this.e = create3;
        this.n = create;
        this.o = create2;
        this.p = create3;
        e();
        f();
        d();
        c();
        reasonDetailsItemsConverter.convert(reasonRds);
    }

    public static final void access$cancelOrder(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl, String str) {
        Disposable subscribe = RdsOrderCancellationInteractor.DefaultImpls.sendReasonAndCancelOrder$default(reasonDetailsViewModelImpl.r, str, null, null, null, 14, null).observeOn(reasonDetailsViewModelImpl.u.mainThread()).subscribe(new a2.a.a.k0.b.b.b(reasonDetailsViewModelImpl), new a2.a.a.k0.b.b.c(reasonDetailsViewModelImpl, str));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.sendReasonAnd…          }\n            )");
        DisposableKt.addTo(subscribe, reasonDetailsViewModelImpl.f);
    }

    public static final void access$sendReason(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl, Option option, String str) {
        String currentUserId = reasonDetailsViewModelImpl.s.getCurrentUserId();
        if (currentUserId != null) {
            reasonDetailsViewModelImpl.q.track(new OrderCancellationEvent(reasonDetailsViewModelImpl.x, currentUserId, reasonDetailsViewModelImpl.w.getId(), reasonDetailsViewModelImpl.w.getTitle(), option != null ? option.getId() : null, option != null ? option.getTitle() : null, str));
        }
    }

    public final void c() {
        Disposable subscribe = this.c.observeOn(this.u.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "cancelOrderButtonClicksR…          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
    }

    public final void d() {
        Disposable subscribe = this.d.observeOn(this.u.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "commentChangesRelay\n    …          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
    }

    public final void e() {
        Disposable subscribe = this.t.getItemsObservable().observeOn(this.u.mainThread()).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemsConverter.itemsObse…          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
    }

    public final void f() {
        Disposable subscribe = this.e.observeOn(this.u.mainThread()).subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "radioGroupChangesRelay\n …          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @Nullable
    public Integer getSelectedRadioButtonId() {
        List<Option> options;
        Option option = this.h;
        if (option == null || (options = this.w.getOptions()) == null) {
            return null;
        }
        return Integer.valueOf(options.indexOf(option));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        this.i = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.j));
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public MutableLiveData<Boolean> getButtonStateChanges() {
        return this.m;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public Relay<Unit> getCancelOrderButtonClickConsumer() {
        return this.n;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public SingleLiveEvent<Integer> getCloseScreenChanges() {
        return this.k;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public Relay<CharSequence> getCommentChangesConsumer() {
        return this.o;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public Relay<ParameterElement.Select> getRadioGroupChangesConsumer() {
        return this.p;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel
    @NotNull
    public MutableLiveData<String> getSnackbarChanges() {
        return this.l;
    }
}
