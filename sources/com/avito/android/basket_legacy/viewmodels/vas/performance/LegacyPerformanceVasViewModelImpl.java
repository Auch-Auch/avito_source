package com.avito.android.basket_legacy.viewmodels.vas.performance;

import a2.a.a.r.b.b.a.c;
import a2.a.a.r.b.b.a.d;
import a2.a.a.r.b.b.a.e;
import a2.a.a.r.b.b.a.f;
import a2.a.a.r.b.b.a.h;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.analytics.Analytics;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.PerformanceVasConverter;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0006\u0010a\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00106\u001a\u000203\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bb\u0010cJ%\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\nJ'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R&\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003070\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u0010 \u001a\u0004\b9\u0010\"R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010 \u001a\u0004\b=\u0010\"R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010/R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003070\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010[\u001a\b\u0012\u0004\u0012\u0002010\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010 \u001a\u0004\bZ\u0010\"R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010*R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020;0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010*R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010W¨\u0006d"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/vas/performance/LegacyPerformanceVasViewModelImpl;", "Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onSkipButtonClick", "()V", "onRetryButtonClick", "onCleared", "", "Lcom/avito/conveyor_item/Item;", "list", "e", "(Ljava/util/List;)V", "d", "", "tabId", "c", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "buttonTextChangesLiveData", "Lio/reactivex/disposables/Disposable;", "i", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "Landroidx/lifecycle/LiveData;", "n", "Landroidx/lifecycle/LiveData;", "getButtonTextChanges", "()Landroidx/lifecycle/LiveData;", "buttonTextChanges", "Lcom/avito/android/vas_performance/repository/VasRepository;", "r", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "o", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCompletionEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "completionEvents", "j", "Ljava/util/List;", "allItems", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "dataChangesLiveData", "Lcom/avito/android/analytics/Analytics;", "w", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/LoadingState;", AuthSource.OPEN_CHANNEL_LIST, "getProgressChanges", "progressChanges", "Lcom/avito/android/deep_linking/links/DeepLink;", "p", "getOpenInfoPage", "openInfoPage", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", VKApiConst.VERSION, "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "t", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "observingSubscriptions", "k", "oldItems", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "s", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "progressChangesLiveData", "Lcom/avito/android/util/SchedulersFactory;", "u", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "x", "Ljava/lang/String;", "openedFrom", "l", "getDataChanges", "dataChanges", g.a, "completionEventsLiveData", "f", "openInfoPageLiveData", VKApiConst.Q, BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPerformanceVasViewModelImpl extends ViewModel implements LegacyPerformanceVasViewModel {
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<ListUpdate> d;
    public final MutableLiveData<String> e;
    public final SingleLiveEvent<DeepLink> f;
    public final SingleLiveEvent<Unit> g;
    public final CompositeDisposable h = new CompositeDisposable();
    public Disposable i;
    public List<? extends Item> j;
    public List<? extends Item> k;
    @NotNull
    public final LiveData<ListUpdate> l;
    @NotNull
    public final LiveData<LoadingState<?>> m;
    @NotNull
    public final LiveData<String> n;
    @NotNull
    public final SingleLiveEvent<Unit> o;
    @NotNull
    public final LiveData<DeepLink> p;
    public final String q;
    public final VasRepository r;
    public final BasketRepository s;
    public final PerformanceVasConverter t;
    public final SchedulersFactory u;
    public final PerformanceVasTracker v;
    public final Analytics w;
    public final String x;

    public static final class a<T> implements Consumer<LoadingState<? super VasPerformanceResult>> {
        public final /* synthetic */ LegacyPerformanceVasViewModelImpl a;

        public a(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl) {
            this.a = legacyPerformanceVasViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super VasPerformanceResult> loadingState) {
            LoadingState<? super VasPerformanceResult> loadingState2 = loadingState;
            LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            LegacyPerformanceVasViewModelImpl.access$handleLoadingState(legacyPerformanceVasViewModelImpl, loadingState2);
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

    public LegacyPerformanceVasViewModelImpl(@NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasTracker performanceVasTracker, @NotNull Analytics analytics, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "tracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.q = str;
        this.r = vasRepository;
        this.s = basketRepository;
        this.t = performanceVasConverter;
        this.u = schedulersFactory;
        this.v = performanceVasTracker;
        this.w = analytics;
        this.x = str2;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<ListUpdate> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        SingleLiveEvent<Unit> singleLiveEvent2 = new SingleLiveEvent<>();
        this.g = singleLiveEvent2;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.i = empty;
        this.j = CollectionsKt__CollectionsKt.emptyList();
        this.k = CollectionsKt__CollectionsKt.emptyList();
        d();
        this.l = mutableLiveData2;
        this.m = mutableLiveData;
        this.n = mutableLiveData3;
        this.o = singleLiveEvent2;
        this.p = singleLiveEvent;
    }

    public static final void access$handleLoadingState(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl, LoadingState loadingState) {
        T t2;
        Objects.requireNonNull(legacyPerformanceVasViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            legacyPerformanceVasViewModelImpl.v.trackLoaded();
            legacyPerformanceVasViewModelImpl.v.startPreparing();
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            legacyPerformanceVasViewModelImpl.j = legacyPerformanceVasViewModelImpl.t.convert((VasPerformanceResult) loaded.getData());
            legacyPerformanceVasViewModelImpl.v.trackPrepared();
            legacyPerformanceVasViewModelImpl.v.startDrawing();
            Iterator<T> it = ((VasPerformanceResult) loaded.getData()).getTabs().iterator();
            while (true) {
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
                legacyPerformanceVasViewModelImpl.e(legacyPerformanceVasViewModelImpl.c(legacyPerformanceVasViewModelImpl.j, t3.getTitle()));
            }
            legacyPerformanceVasViewModelImpl.e.postValue(((VasPerformanceResult) loaded.getData()).getActionTitle());
            legacyPerformanceVasViewModelImpl.c.postValue(loadingState);
            legacyPerformanceVasViewModelImpl.v.trackDrawn();
        } else if (loadingState instanceof LoadingState.Error) {
            legacyPerformanceVasViewModelImpl.v.trackLoadingError();
            legacyPerformanceVasViewModelImpl.v.startDrawing();
            legacyPerformanceVasViewModelImpl.c.postValue(loadingState);
            legacyPerformanceVasViewModelImpl.v.trackDrawnError();
        } else {
            legacyPerformanceVasViewModelImpl.c.postValue(loadingState);
        }
    }

    public static final void access$openUri(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl, DeepLink deepLink) {
        Objects.requireNonNull(legacyPerformanceVasViewModelImpl);
        if (deepLink != null) {
            legacyPerformanceVasViewModelImpl.f.postValue(deepLink);
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
        this.i.dispose();
        this.v.startLoading();
        Disposable subscribe = this.r.getPerformanceVas(this.q).observeOn(this.u.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vasRepository.getPerform…error(it) }\n            )");
        this.i = subscribe;
    }

    public final void e(List<? extends Item> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new PerformanceVasDiffUtil(this.k, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        this.d.postValue(new ListUpdate(list, calculateDiff));
        this.k = list;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    @NotNull
    public LiveData<String> getButtonTextChanges() {
        return this.n;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    @NotNull
    public SingleLiveEvent<Unit> getCompletionEvents() {
        return this.o;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    @NotNull
    public LiveData<ListUpdate> getDataChanges() {
        return this.l;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    @NotNull
    public LiveData<DeepLink> getOpenInfoPage() {
        return this.p;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.m;
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.h.clear();
        for (T t2 : set) {
            if (t2 instanceof TabsItemPresenter) {
                CompositeDisposable compositeDisposable = this.h;
                Disposable subscribe = t2.getTabCheckedObservable().debounce(50, TimeUnit.MILLISECONDS).map(new f(this)).observeOn(this.u.mainThread()).subscribe(new a2.a.a.r.b.b.a.g(this), h.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "tabsClickObservable\n    …t) }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t2 instanceof PerformanceVasItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.h;
                Disposable subscribe2 = t2.getVasClicksObservable().debounce(50, TimeUnit.MILLISECONDS).map(c.a).observeOn(this.u.mainThread()).subscribe(new d(this), e.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "vasClicksObservable\n    …   }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (t2 instanceof InfoActionItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.h;
                Disposable subscribe3 = t2.getInfoActionClicksObservable().subscribe(new a2.a.a.r.b.b.a.a(this), a2.a.a.r.b.b.a.b.a);
                Intrinsics.checkNotNullExpressionValue(subscribe3, "infoActionObservable.sub…k) }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.h.clear();
        this.i.dispose();
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    public void onRetryButtonClick() {
        d();
    }

    @Override // com.avito.android.vas_performance.LegacyPerformanceVasViewModel
    public void onSkipButtonClick() {
        this.s.clearFirstStepVasSelection();
        this.g.postValue(Unit.INSTANCE);
    }
}
