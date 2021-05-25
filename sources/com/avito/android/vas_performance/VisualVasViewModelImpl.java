package com.avito.android.vas_performance;

import a2.a.a.q3.c;
import a2.a.a.q3.d;
import a2.a.a.q3.e;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.ButtonState;
import com.avito.android.vas_performance.ui.VisualVasViewModel;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItem;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenter;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.android.vas_performance.ui.recycler.VisualVasDiffUtil;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bZ\u0010[J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J%\u0010\n\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001bR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010 \u001a\u0004\b<\u0010\"R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010\u0017R\u0016\u0010D\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010.R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020:0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u001e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010 \u001a\u0004\bO\u0010\"R&\u0010S\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010 \u001a\u0004\bR\u0010\"R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010.¨\u0006\\"}, d2 = {"Lcom/avito/android/vas_performance/VisualVasViewModelImpl;", "Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onContinueButtonClick", "()V", "onRetryButtonClick", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "c", "", "selectedItems", "d", "(Ljava/util/List;)V", "Lcom/avito/android/util/SchedulersFactory;", "w", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/conveyor_item/Item;", "i", "Ljava/util/List;", "allItems", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/vas_performance/ui/ButtonState;", "p", "Landroidx/lifecycle/LiveData;", "getButtonStateChanges", "()Landroidx/lifecycle/LiveData;", "buttonStateChanges", "j", "oldItems", "e", "buttonStateChangesLiveData", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "x", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "", "s", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "t", "checkoutContext", "Lcom/avito/android/deep_linking/links/DeepLink;", "n", "Lcom/avito/android/deep_linking/links/DeepLink;", "noItemsDeepLink", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "observingSubscriptions", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "o", "getDataChanges", "dataChanges", "Lcom/avito/android/vas_performance/VisualVasConverter;", VKApiConst.VERSION, "Lcom/avito/android/vas_performance/VisualVasConverter;", "converter", "k", "l", "unselectedButtonText", "Lio/reactivex/disposables/Disposable;", g.a, "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "dataChangesLiveData", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "continueButtonLiveData", "r", "getContinueButtonNavigate", "continueButtonNavigate", VKApiConst.Q, "getProgressChanges", "progressChanges", "Lcom/avito/android/vas_performance/repository/VasRepository;", "u", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", AuthSource.OPEN_CHANNEL_LIST, "selectedButtonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/vas_performance/VisualVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVasViewModelImpl extends ViewModel implements VisualVasViewModel {
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<ListUpdate> d;
    public final MutableLiveData<ButtonState> e;
    public final SingleLiveEvent<DeepLink> f;
    public Disposable g;
    public final CompositeDisposable h = new CompositeDisposable();
    public List<? extends Item> i = CollectionsKt__CollectionsKt.emptyList();
    public List<? extends Item> j = CollectionsKt__CollectionsKt.emptyList();
    public List<? extends Item> k = CollectionsKt__CollectionsKt.emptyList();
    public String l = "";
    public String m = "";
    public DeepLink n;
    @NotNull
    public final LiveData<ListUpdate> o;
    @NotNull
    public final LiveData<ButtonState> p;
    @NotNull
    public final LiveData<LoadingState<?>> q;
    @NotNull
    public final LiveData<DeepLink> r;
    public final String s;
    public final String t;
    public final VasRepository u;
    public final VisualVasConverter v;
    public final SchedulersFactory w;
    public final VisualVasTracker x;

    public static final class a<T> implements Consumer<LoadingState<? super VasVisualResult>> {
        public final /* synthetic */ VisualVasViewModelImpl a;

        public a(VisualVasViewModelImpl visualVasViewModelImpl) {
            this.a = visualVasViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super VasVisualResult> loadingState) {
            LoadingState<? super VasVisualResult> loadingState2 = loadingState;
            VisualVasViewModelImpl visualVasViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            VisualVasViewModelImpl.access$handleLoadingState(visualVasViewModelImpl, loadingState2);
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

    public VisualVasViewModelImpl(@NotNull String str, @NotNull String str2, @NotNull VasRepository vasRepository, @NotNull VisualVasConverter visualVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(visualVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(visualVasTracker, "tracker");
        this.s = str;
        this.t = str2;
        this.u = vasRepository;
        this.v = visualVasConverter;
        this.w = schedulersFactory;
        this.x = visualVasTracker;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<ListUpdate> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<ButtonState> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.g = empty;
        c();
        this.o = mutableLiveData2;
        this.p = mutableLiveData3;
        this.q = mutableLiveData;
        this.r = singleLiveEvent;
    }

    public static final void access$handleLoadingState(VisualVasViewModelImpl visualVasViewModelImpl, LoadingState loadingState) {
        String str;
        Objects.requireNonNull(visualVasViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            visualVasViewModelImpl.x.trackLoaded();
            visualVasViewModelImpl.x.startPreparing();
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            Action action = ((VasVisualResult) loaded.getData()).getAction();
            String str2 = "";
            if ((action == null || (str = action.getTitle()) == null) && (str = ((VasVisualResult) loaded.getData()).getEmptyActionTitle()) == null) {
                str = str2;
            }
            visualVasViewModelImpl.l = str;
            String selectedActionTitle = ((VasVisualResult) loaded.getData()).getSelectedActionTitle();
            if (selectedActionTitle != null) {
                str2 = selectedActionTitle;
            }
            visualVasViewModelImpl.m = str2;
            List<Item> convert = visualVasViewModelImpl.v.convert((VasVisualResult) loaded.getData());
            visualVasViewModelImpl.i = convert;
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new VisualVasDiffUtil(visualVasViewModelImpl.j, convert));
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
            visualVasViewModelImpl.d.postValue(new ListUpdate(convert, calculateDiff));
            visualVasViewModelImpl.j = convert;
            Action action2 = ((VasVisualResult) loaded.getData()).getAction();
            visualVasViewModelImpl.n = action2 != null ? action2.getDeepLink() : null;
            visualVasViewModelImpl.d(visualVasViewModelImpl.k);
            visualVasViewModelImpl.x.trackPrepared();
            visualVasViewModelImpl.x.startDrawing();
            visualVasViewModelImpl.c.postValue(loadingState);
            visualVasViewModelImpl.x.trackDrawn();
        } else if (loadingState instanceof LoadingState.Error) {
            visualVasViewModelImpl.x.trackLoadingError();
            visualVasViewModelImpl.x.startDrawing();
            visualVasViewModelImpl.c.postValue(loadingState);
            visualVasViewModelImpl.x.trackDrawnError();
        } else {
            visualVasViewModelImpl.c.postValue(loadingState);
        }
    }

    public static final void access$handleVasContextLoadingState(VisualVasViewModelImpl visualVasViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(visualVasViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            visualVasViewModelImpl.f.postValue(((DeepLinkResponse) ((LoadingState.Loaded) loadingState).getData()).getDeepLink());
            visualVasViewModelImpl.c.postValue(loadingState);
        } else if (loadingState instanceof LoadingState.Error) {
            visualVasViewModelImpl.x.trackLoadingError();
            visualVasViewModelImpl.x.startDrawing();
            visualVasViewModelImpl.c.postValue(loadingState);
            visualVasViewModelImpl.x.trackDrawnError();
        } else {
            visualVasViewModelImpl.c.postValue(loadingState);
        }
    }

    public static final void access$selectItem(VisualVasViewModelImpl visualVasViewModelImpl, VisualVasItem visualVasItem) {
        Object obj;
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(visualVasViewModelImpl.i), VisualVasViewModelImpl$selectItem$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Iterator it = filter.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((VisualVasItem) obj).getStringId(), visualVasItem.getStringId())) {
                break;
            }
        }
        VisualVasItem visualVasItem2 = (VisualVasItem) obj;
        if (visualVasItem2 != null) {
            visualVasItem2.setSelected(!visualVasItem2.getSelected());
        }
        Sequence filter2 = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(visualVasViewModelImpl.i), VisualVasViewModelImpl$findSelected$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        List<? extends Item> list = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.filter(filter2, a2.a.a.q3.a.a));
        visualVasViewModelImpl.k = list;
        visualVasViewModelImpl.d(list);
    }

    public final void c() {
        this.g.dispose();
        this.k = CollectionsKt__CollectionsKt.emptyList();
        this.x.startLoading();
        Disposable subscribe = this.u.getVisualVasNew(this.s, this.t).observeOn(this.w.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vasRepository.getVisualV…error(it) }\n            )");
        this.g = subscribe;
    }

    public final void d(List<?> list) {
        boolean z = list.size() > 0;
        this.e.setValue(new ButtonState(z ? this.m : this.l, z));
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    @NotNull
    public LiveData<ButtonState> getButtonStateChanges() {
        return this.p;
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    @NotNull
    public LiveData<DeepLink> getContinueButtonNavigate() {
        return this.r;
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    @NotNull
    public LiveData<ListUpdate> getDataChanges() {
        return this.o;
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.q;
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.h.clear();
        for (T t2 : set) {
            if (t2 instanceof VisualVasItemPresenter) {
                CompositeDisposable compositeDisposable = this.h;
                Disposable subscribe = t2.getVasClicksObservable().debounce(50, TimeUnit.MILLISECONDS).observeOn(this.w.mainThread()).subscribe(new d(this), e.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "vasClicksObservable\n    …t) }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    public void onContinueButtonClick() {
        if (this.k.isEmpty()) {
            this.f.postValue(this.n);
            return;
        }
        List<? extends Item> list = this.k;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getStringId());
        }
        Set<String> set = CollectionsKt___CollectionsKt.toSet(arrayList);
        this.g.dispose();
        Disposable subscribe = this.u.getVasContext(this.s, this.t, set).observeOn(this.w.mainThread()).subscribe(new a2.a.a.q3.b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vasRepository\n          …t) }, { Logs.error(it) })");
        this.g = subscribe;
    }

    @Override // com.avito.android.vas_performance.ui.VisualVasViewModel
    public void onRetryButtonClick() {
        c();
    }
}
