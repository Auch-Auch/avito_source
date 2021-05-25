package com.avito.android.basket_legacy.viewmodels.vas.visual;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.StringProvider;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.ButtonState;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItem;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u00108\u001a\u000205¢\u0006\u0004\bY\u0010ZJ%\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ\u001d\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00062\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\b\u0012\u0004\u0012\u00020+0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010\u001dR \u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030<0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010=R&\u0010A\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030<0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010-\u001a\u0004\b@\u0010/R\"\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010=R\"\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0*8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bC\u0010/R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020+0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010=R\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/vas/visual/LegacyVisualVasViewModelImpl;", "Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onContinueButtonClick", "()V", "onRetryButtonClick", "onCleared", "d", "", "Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItem;", "selectedItems", g.a, "(Ljava/util/List;)V", "e", "f", "Lcom/avito/conveyor_item/Item;", "c", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "completionEventsLiveData", "", "n", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "observingSubscriptions", "Lio/reactivex/disposables/Disposable;", "h", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "Lcom/avito/android/vas_performance/repository/VasRepository;", "o", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/vas_performance/ui/ButtonState;", "l", "Landroidx/lifecycle/LiveData;", "getButtonStateChanges", "()Landroidx/lifecycle/LiveData;", "buttonStateChanges", AuthSource.OPEN_CHANNEL_LIST, "getCompletionEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "completionEvents", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "t", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "j", "unselectedButtonText", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "k", "getProgressChanges", "progressChanges", "dataChangesLiveData", "getDataChanges", "dataChanges", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "p", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/vas_performance/StringProvider;", "s", "Lcom/avito/android/vas_performance/StringProvider;", "stringProvider", "buttonStateChangesLiveData", "i", "Ljava/util/List;", "items", "Lcom/avito/android/vas_performance/VisualVasConverter;", VKApiConst.Q, "Lcom/avito/android/vas_performance/VisualVasConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/VisualVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/StringProvider;Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyVisualVasViewModelImpl extends ViewModel implements LegacyVisualVasViewModel {
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<List<Item>> d = new MutableLiveData<>();
    public final MutableLiveData<ButtonState> e;
    public final SingleLiveEvent<Unit> f;
    public final CompositeDisposable g;
    public Disposable h;
    public List<? extends Item> i;
    public String j;
    @NotNull
    public final LiveData<LoadingState<?>> k;
    @NotNull
    public final LiveData<ButtonState> l;
    @NotNull
    public final SingleLiveEvent<Unit> m;
    public final String n;
    public final VasRepository o;
    public final BasketRepository p;
    public final VisualVasConverter q;
    public final SchedulersFactory r;
    public final StringProvider s;
    public final VisualVasTracker t;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<List<? extends Item>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(List<? extends Item> list) {
            int i = this.a;
            if (i == 0) {
                List<? extends Item> list2 = list;
                ((LegacyVisualVasViewModelImpl) this.b).d.postValue(list2);
                LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl = (LegacyVisualVasViewModelImpl) this.b;
                Intrinsics.checkNotNullExpressionValue(list2, "it");
                legacyVisualVasViewModelImpl.e(legacyVisualVasViewModelImpl.c(list2));
            } else if (i == 1) {
                List<? extends Item> list3 = list;
                LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl2 = (LegacyVisualVasViewModelImpl) this.b;
                Intrinsics.checkNotNullExpressionValue(list3, "it");
                legacyVisualVasViewModelImpl2.g(legacyVisualVasViewModelImpl2.c(list3));
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super VasVisualResult>> {
        public final /* synthetic */ LegacyVisualVasViewModelImpl a;

        public b(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl) {
            this.a = legacyVisualVasViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super VasVisualResult> loadingState) {
            LoadingState<? super VasVisualResult> loadingState2 = loadingState;
            LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            LegacyVisualVasViewModelImpl.access$handleLoadingState(legacyVisualVasViewModelImpl, loadingState2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class e<T, R> implements Function<List<? extends VasService>, List<? extends String>> {
        public final /* synthetic */ LegacyVisualVasViewModelImpl a;

        public e(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl) {
            this.a = legacyVisualVasViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends String> apply(List<? extends VasService> list) {
            List<? extends VasService> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return LegacyVisualVasViewModelImpl.access$findVisualVasIds(this.a, list2);
        }
    }

    public static final class f<T, R> implements Function<List<? extends String>, List<? extends Item>> {
        public final /* synthetic */ LegacyVisualVasViewModelImpl a;

        public f(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl) {
            this.a = legacyVisualVasViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends Item> apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "selectedVasIds");
            LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl = this.a;
            LegacyVisualVasViewModelImpl.access$updateVasSelection(legacyVisualVasViewModelImpl, legacyVisualVasViewModelImpl.i, list2);
            return this.a.i;
        }
    }

    public LegacyVisualVasViewModelImpl(@NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull VisualVasConverter visualVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(visualVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(visualVasTracker, "tracker");
        this.n = str;
        this.o = vasRepository;
        this.p = basketRepository;
        this.q = visualVasConverter;
        this.r = schedulersFactory;
        this.s = stringProvider;
        this.t = visualVasTracker;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<ButtonState> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        SingleLiveEvent<Unit> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        this.g = new CompositeDisposable();
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.h = empty;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = "";
        d();
        this.k = mutableLiveData;
        this.l = mutableLiveData2;
        this.m = singleLiveEvent;
    }

    public static final List access$findVisualVasIds(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl, List list) {
        Objects.requireNonNull(legacyVisualVasViewModelImpl);
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), a2.a.a.r.b.b.b.b.a), a2.a.a.r.b.b.b.c.a));
    }

    public static final void access$handleLoadingState(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(legacyVisualVasViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            legacyVisualVasViewModelImpl.t.trackLoaded();
            legacyVisualVasViewModelImpl.t.startPreparing();
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            String actionTitle = ((VasVisualResult) loaded.getData()).getActionTitle();
            if (actionTitle == null) {
                actionTitle = "";
            }
            legacyVisualVasViewModelImpl.j = actionTitle;
            legacyVisualVasViewModelImpl.i = legacyVisualVasViewModelImpl.q.convert((VasVisualResult) loaded.getData());
            legacyVisualVasViewModelImpl.t.trackPrepared();
            legacyVisualVasViewModelImpl.t.startDrawing();
            legacyVisualVasViewModelImpl.f();
            legacyVisualVasViewModelImpl.c.postValue(loadingState);
            legacyVisualVasViewModelImpl.t.trackDrawn();
        } else if (loadingState instanceof LoadingState.Error) {
            legacyVisualVasViewModelImpl.t.trackLoadingError();
            legacyVisualVasViewModelImpl.t.startDrawing();
            legacyVisualVasViewModelImpl.c.postValue(loadingState);
            legacyVisualVasViewModelImpl.t.trackDrawnError();
        } else {
            legacyVisualVasViewModelImpl.c.postValue(loadingState);
        }
    }

    public static final void access$selectItem(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl, VisualVasItem visualVasItem) {
        Object obj;
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(legacyVisualVasViewModelImpl.i), LegacyVisualVasViewModelImpl$selectItem$$inlined$filterIsInstance$1.INSTANCE);
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
        List<VisualVasItem> c2 = legacyVisualVasViewModelImpl.c(legacyVisualVasViewModelImpl.i);
        legacyVisualVasViewModelImpl.g(c2);
        legacyVisualVasViewModelImpl.e(c2);
    }

    public static final void access$updateVasSelection(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl, List list, List list2) {
        Objects.requireNonNull(legacyVisualVasViewModelImpl);
        Sequence<VisualVasItem> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), LegacyVisualVasViewModelImpl$updateVasSelection$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        for (VisualVasItem visualVasItem : filter) {
            visualVasItem.setSelected(list2.contains(visualVasItem.getStringId()));
        }
    }

    public final List<VisualVasItem> c(List<? extends Item> list) {
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), LegacyVisualVasViewModelImpl$findSelected$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.filter(filter, a2.a.a.r.b.b.b.a.a));
    }

    public final void d() {
        this.h.dispose();
        this.t.startLoading();
        Disposable subscribe = this.o.getVisualVas(this.n).observeOn(this.r.mainThread()).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vasRepository.getVisualV…ber.e(it) }\n            )");
        this.h = subscribe;
    }

    public final void e(List<?> list) {
        boolean z = list.size() > 0;
        this.e.setValue(new ButtonState(z ? this.s.getChooseButtonTitle() : this.j, z));
    }

    public final void f() {
        Observable doOnNext = Observable.just(this.i).doOnNext(new a(1, this));
        Observable<R> map = this.p.getVasObservable().map(new e(this)).map(new f(this));
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = map.ambWith(doOnNext).firstOrError().subscribe(new a(0, this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemsFromBasketObservabl…     }, { Timber.e(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void g(List<VisualVasItem> list) {
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t2 : list) {
            arrayList.add(new VasService(t2.getStringId(), t2.getTitle(), t2.getPrice(), t2.getOldPrice(), t2.getIcon(), t2.getPriceValue(), VasType.VISUAL));
        }
        this.p.addSecondStepVas(arrayList);
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    @NotNull
    public LiveData<ButtonState> getButtonStateChanges() {
        return this.l;
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    @NotNull
    public SingleLiveEvent<Unit> getCompletionEvents() {
        return this.m;
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    @NotNull
    public LiveData<List<Item>> getDataChanges() {
        f();
        return this.d;
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.k;
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.g.clear();
        for (T t2 : set) {
            if (t2 instanceof VisualVasItemPresenter) {
                CompositeDisposable compositeDisposable = this.g;
                Disposable subscribe = t2.getVasClicksObservable().debounce(50, TimeUnit.MILLISECONDS).observeOn(this.r.mainThread()).subscribe(new a2.a.a.r.b.b.b.d(this), a2.a.a.r.b.b.b.e.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "vasClicksObservable\n    …(it) }, { Timber.e(it) })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.g.clear();
        this.h.dispose();
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    public void onContinueButtonClick() {
        this.f.postValue(Unit.INSTANCE);
    }

    @Override // com.avito.android.vas_performance.LegacyVisualVasViewModel
    public void onRetryButtonClick() {
        d();
    }
}
