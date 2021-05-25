package com.avito.android.vas_performance.ui;

import a2.a.a.q3.f.a0;
import a2.a.a.q3.f.b0;
import a2.a.a.q3.f.c0;
import a2.a.a.q3.f.d0;
import a2.a.a.q3.f.e0;
import a2.a.a.q3.f.f0;
import a2.a.a.q3.f.g0;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.PerformanceVasViewModel;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenter;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenter;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItem;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenter;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.android.vas_performance.ui.recycler.PerformanceVasDiffUtil;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010Q\u001a\u00020\u0012\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b[\u0010\\J%\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R&\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00106\u001a\b\u0012\u0004\u0012\u0002030\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u001eR\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u0002030;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020'0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0017R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010BR\"\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010\u001c\u001a\u0004\bJ\u0010\u001eR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010!R\u0018\u0010T\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010W\u001a\b\u0012\u0004\u0012\u0002030\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010\u001c\u001a\u0004\bV\u0010\u001eR \u0010X\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u0002030;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010=¨\u0006]"}, d2 = {"Lcom/avito/android/vas_performance/ui/PerformanceVasViewModelImpl;", "Lcom/avito/android/vas_performance/PerformanceVasViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onSkipButtonClick", "()V", "onRetryButtonClick", "d", "", "Lcom/avito/conveyor_item/Item;", "list", "e", "(Ljava/util/List;)V", "", "tabId", "c", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "buttonTextChangesLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "p", "Landroidx/lifecycle/LiveData;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "r", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/util/SchedulersFactory;", "u", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", AuthSource.OPEN_CHANNEL_LIST, "getDataChanges", "dataChanges", "Lio/reactivex/disposables/CompositeDisposable;", "i", "Lio/reactivex/disposables/CompositeDisposable;", "observingSubscriptions", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "w", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Lcom/avito/android/deep_linking/links/DeepLink;", "n", "getOpenInfoPage", "openInfoPage", "Lcom/avito/android/vas_performance/repository/VasRepository;", "t", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openInfoPageLiveData", "f", "dataChangesLiveData", "j", "Ljava/util/List;", "allItems", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "k", "oldItems", "o", "getButtonTextChanges", "buttonTextChanges", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", VKApiConst.VERSION, "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "s", "checkoutContext", "l", "Lcom/avito/android/deep_linking/links/DeepLink;", "continueDeeplink", VKApiConst.Q, "getDeeplinkNavigate", "deeplinkNavigate", "progressChangesLiveData", "h", "navigateToDeeplinkLiveData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasViewModelImpl extends ViewModel implements PerformanceVasViewModel {
    public Disposable c;
    public final MutableLiveData<LoadingState<?>> d;
    public final MutableLiveData<String> e;
    public final MutableLiveData<ListUpdate> f;
    public final SingleLiveEvent<DeepLink> g;
    public final SingleLiveEvent<DeepLink> h;
    public final CompositeDisposable i = new CompositeDisposable();
    public List<? extends Item> j = CollectionsKt__CollectionsKt.emptyList();
    public List<? extends Item> k = CollectionsKt__CollectionsKt.emptyList();
    public DeepLink l;
    @NotNull
    public final LiveData<ListUpdate> m;
    @NotNull
    public final LiveData<DeepLink> n;
    @NotNull
    public final LiveData<String> o;
    @NotNull
    public final LiveData<LoadingState<?>> p;
    @NotNull
    public final LiveData<DeepLink> q;
    public final String r;
    public final String s;
    public final VasRepository t;
    public final SchedulersFactory u;
    public final PerformanceVasConverter v;
    public final PerformanceVasTracker w;

    public static final class a<T> implements Consumer<LoadingState<? super VasPerformanceResult>> {
        public final /* synthetic */ PerformanceVasViewModelImpl a;

        public a(PerformanceVasViewModelImpl performanceVasViewModelImpl) {
            this.a = performanceVasViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super VasPerformanceResult> loadingState) {
            LoadingState<? super VasPerformanceResult> loadingState2 = loadingState;
            PerformanceVasViewModelImpl performanceVasViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            PerformanceVasViewModelImpl.access$handleLoadingState(performanceVasViewModelImpl, loadingState2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public PerformanceVasViewModelImpl(@NotNull String str, @NotNull String str2, @NotNull VasRepository vasRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull PerformanceVasTracker performanceVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "tracker");
        this.r = str;
        this.s = str2;
        this.t = vasRepository;
        this.u = schedulersFactory;
        this.v = performanceVasConverter;
        this.w = performanceVasTracker;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<ListUpdate> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.g = singleLiveEvent;
        SingleLiveEvent<DeepLink> singleLiveEvent2 = new SingleLiveEvent<>();
        this.h = singleLiveEvent2;
        this.m = mutableLiveData3;
        this.n = singleLiveEvent;
        this.o = mutableLiveData2;
        this.p = mutableLiveData;
        this.q = singleLiveEvent2;
        d();
    }

    public static final void access$handleLoadingState(PerformanceVasViewModelImpl performanceVasViewModelImpl, LoadingState loadingState) {
        DeepLink deepLink;
        T t2;
        Objects.requireNonNull(performanceVasViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            performanceVasViewModelImpl.w.trackLoaded();
            performanceVasViewModelImpl.w.startPreparing();
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            performanceVasViewModelImpl.j = performanceVasViewModelImpl.v.convert((VasPerformanceResult) loaded.getData());
            performanceVasViewModelImpl.w.trackPrepared();
            performanceVasViewModelImpl.w.startDrawing();
            Iterator<T> it = ((VasPerformanceResult) loaded.getData()).getTabs().iterator();
            while (true) {
                deepLink = null;
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2.getSelected()) {
                    break;
                }
            }
            T t3 = t2;
            if (t3 != null) {
                performanceVasViewModelImpl.e(performanceVasViewModelImpl.c(performanceVasViewModelImpl.j, t3.getTitle()));
            }
            MutableLiveData<String> mutableLiveData = performanceVasViewModelImpl.e;
            Action action = ((VasPerformanceResult) loaded.getData()).getAction();
            mutableLiveData.postValue(action != null ? action.getTitle() : null);
            Action action2 = ((VasPerformanceResult) loaded.getData()).getAction();
            if (action2 != null) {
                deepLink = action2.getDeepLink();
            }
            performanceVasViewModelImpl.l = deepLink;
            performanceVasViewModelImpl.d.postValue(loadingState);
            performanceVasViewModelImpl.w.trackDrawn();
        } else if (loadingState instanceof LoadingState.Error) {
            performanceVasViewModelImpl.w.trackLoadingError();
            performanceVasViewModelImpl.w.startDrawing();
            performanceVasViewModelImpl.d.postValue(loadingState);
            performanceVasViewModelImpl.w.trackDrawnError();
        } else {
            performanceVasViewModelImpl.d.postValue(loadingState);
        }
    }

    public static final void access$openUri(PerformanceVasViewModelImpl performanceVasViewModelImpl, DeepLink deepLink) {
        Objects.requireNonNull(performanceVasViewModelImpl);
        if (deepLink != null) {
            performanceVasViewModelImpl.g.postValue(deepLink);
        }
    }

    public final List<Item> c(List<? extends Item> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            T t3 = t2;
            boolean z = true;
            if (!(t3 instanceof PerformanceVasItem) || !(!Intrinsics.areEqual(t3.getTabId(), str))) {
                z = false;
            }
            if (!z) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public final void d() {
        this.c.dispose();
        this.w.startLoading();
        Disposable subscribe = this.t.getPerformanceVasV2(this.r, this.s).observeOn(this.u.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vasRepository.getPerform…t) }, { Logs.error(it) })");
        this.c = subscribe;
    }

    public final void e(List<? extends Item> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new PerformanceVasDiffUtil(this.k, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        this.f.postValue(new ListUpdate(list, calculateDiff));
        this.k = list;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    @NotNull
    public LiveData<String> getButtonTextChanges() {
        return this.o;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    @NotNull
    public LiveData<ListUpdate> getDataChanges() {
        return this.m;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    @NotNull
    public LiveData<DeepLink> getDeeplinkNavigate() {
        return this.q;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    @NotNull
    public LiveData<DeepLink> getOpenInfoPage() {
        return this.n;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.p;
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.i.clear();
        for (T t2 : set) {
            if (t2 instanceof TabsItemPresenter) {
                CompositeDisposable compositeDisposable = this.i;
                Disposable subscribe = t2.getTabCheckedObservable().debounce(50, TimeUnit.MILLISECONDS).map(new e0(this)).observeOn(this.u.mainThread()).subscribe(new f0(this), g0.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "tabsClickObservable\n    …t) }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t2 instanceof PerformanceVasItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.i;
                Disposable subscribe2 = t2.getVasClicksObservable().debounce(50, TimeUnit.MILLISECONDS).observeOn(this.u.mainThread()).subscribe(new c0(this), d0.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "vasClicksObservable\n    …   }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (t2 instanceof InfoActionItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.i;
                Disposable subscribe3 = t2.getInfoActionClicksObservable().subscribe(new a0(this), b0.a);
                Intrinsics.checkNotNullExpressionValue(subscribe3, "infoActionObservable.sub…k) }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            }
        }
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    public void onRetryButtonClick() {
        d();
    }

    @Override // com.avito.android.vas_performance.PerformanceVasViewModel
    public void onSkipButtonClick() {
        DeepLink deepLink = this.l;
        if (deepLink != null) {
            this.h.postValue(deepLink);
        }
    }
}
