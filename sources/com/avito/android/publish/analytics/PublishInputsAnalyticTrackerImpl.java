package com.avito.android.publish.analytics;

import a2.a.a.e2.n.e;
import a2.a.a.e2.n.f;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.InputItem;
import com.avito.android.publish.NavigationProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.GeoContract;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.ObservablesKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0019\u0010\"\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ)\u0010\u000f\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR)\u0010\"\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e¢\u0006\u0002\b\u001f0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$R$\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00160&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/publish/analytics/PublishInputsAnalyticTrackerImpl;", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "Lcom/avito/android/publish/NavigationProvider;", GeoContract.PROVIDER, "", "setNavigationProvider", "(Lcom/avito/android/publish/NavigationProvider;)V", "subscribe", "()V", "unsubscribe", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/avito/android/items/BasicInputItem;", "inputFocusChangesObservable", AuthSource.SEND_ABUSE, "(Lio/reactivex/Observable;)V", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "e", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lio/reactivex/functions/Consumer;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "d", "Lio/reactivex/functions/Consumer;", "getStructureChangeConsumer", "()Lio/reactivex/functions/Consumer;", "structureChangeConsumer", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "f", "Ljava/util/Set;", "itemPresentersSet", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "structureChangeRelay", "c", "Lcom/avito/android/publish/NavigationProvider;", "navigationProvider", "<init>", "(Lcom/avito/android/publish/analytics/PublishEventTracker;Ljava/util/Set;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishInputsAnalyticTrackerImpl implements PublishInputsAnalyticTracker {
    public final CompositeDisposable a = new CompositeDisposable();
    public final PublishRelay<DataSource<? extends Item>> b;
    public NavigationProvider c;
    @NotNull
    public final Consumer<DataSource<? extends Item>> d;
    public final PublishEventTracker e;
    public final Set<ItemPresenter<?, ?>> f;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<Pair<? extends Boolean, ? extends BasicInputItem>> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Pair<? extends Boolean, ? extends BasicInputItem> pair) {
            int i = this.a;
            if (i == 0) {
                Pair<? extends Boolean, ? extends BasicInputItem> pair2 = pair;
                Intrinsics.checkNotNullParameter(pair2, "it");
                return !((Boolean) pair2.getFirst()).booleanValue();
            } else if (i == 1) {
                Pair<? extends Boolean, ? extends BasicInputItem> pair3 = pair;
                Intrinsics.checkNotNullParameter(pair3, "it");
                if (((BasicInputItem) pair3.getSecond()).getValue() != null) {
                    return true;
                }
                return false;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Pair<? extends Boolean, ? extends BasicInputItem>, BasicInputItem> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public BasicInputItem apply(Pair<? extends Boolean, ? extends BasicInputItem> pair) {
            Pair<? extends Boolean, ? extends BasicInputItem> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return (BasicInputItem) pair2.getSecond();
        }
    }

    public static final class c<T> implements Consumer<BasicInputItem> {
        public final /* synthetic */ PublishInputsAnalyticTrackerImpl a;

        public c(PublishInputsAnalyticTrackerImpl publishInputsAnalyticTrackerImpl) {
            this.a = publishInputsAnalyticTrackerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BasicInputItem basicInputItem) {
            String str;
            BasicInputItem basicInputItem2 = basicInputItem;
            if (basicInputItem2 instanceof InputItem) {
                str = ((InputItem) basicInputItem2).getTitle();
            } else if (basicInputItem2 instanceof ParameterElement.TaggedInput) {
                str = ((ParameterElement.TaggedInput) basicInputItem2).getTitle();
            } else if (basicInputItem2 instanceof ParameterElement.Video) {
                str = ((ParameterElement.Video) basicInputItem2).getTitle();
            } else {
                throw new IllegalArgumentException("Unknown BasicInputItem implementation " + basicInputItem2);
            }
            this.a.e.trackParamValueChangedEvent(str, basicInputItem2.getValue(), PublishInputsAnalyticTrackerImpl.access$getNavigationProvider$p(this.a).getNavigation());
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("observeInputChanges failed", th);
        }
    }

    public PublishInputsAnalyticTrackerImpl(@NotNull PublishEventTracker publishEventTracker, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        this.e = publishEventTracker;
        this.f = set;
        PublishRelay<DataSource<? extends Item>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
        this.d = create;
    }

    public static final /* synthetic */ NavigationProvider access$getNavigationProvider$p(PublishInputsAnalyticTrackerImpl publishInputsAnalyticTrackerImpl) {
        NavigationProvider navigationProvider = publishInputsAnalyticTrackerImpl.c;
        if (navigationProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationProvider");
        }
        return navigationProvider;
    }

    public final void a(Observable<Pair<Boolean, BasicInputItem>> observable) {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = observable.filter(a.b).filter(a.c).map(b.a).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "inputFocusChangesObserva…led\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish.analytics.PublishInputsAnalyticTracker
    @NotNull
    public Consumer<DataSource<? extends Item>> getStructureChangeConsumer() {
        return this.d;
    }

    @Override // com.avito.android.publish.analytics.PublishInputsAnalyticTracker
    public void setNavigationProvider(@NotNull NavigationProvider navigationProvider) {
        Intrinsics.checkNotNullParameter(navigationProvider, GeoContract.PROVIDER);
        this.c = navigationProvider;
    }

    @Override // com.avito.android.publish.analytics.PublishInputsAnalyticTracker
    public void subscribe() {
        for (T t : this.f) {
            if (t instanceof MultiStateInputItemPresenter) {
                a(t.getFocusChangesObservable());
            } else if (t instanceof VideoItemPresenter) {
                a(t.getFocusChangesObservable());
            } else if (t instanceof MultiStateSwitcherItemPresenter) {
                Observable<CheckBoxItem> valueChangesObservable = t.getValueChangesObservable();
                CompositeDisposable compositeDisposable = this.a;
                Disposable subscribe = valueChangesObservable.subscribe(new e(this), f.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "switchValueChangesObserv…led\", it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t instanceof MultiStateInputWithTagsItemPresenter) {
                a(t.getFocusChangesObservable());
            }
        }
        Observable<R> map = this.b.map(a2.a.a.e2.n.d.a);
        Observable<R> skip = map.skip(1);
        CompositeDisposable compositeDisposable2 = this.a;
        Intrinsics.checkNotNullExpressionValue(map, "was");
        Intrinsics.checkNotNullExpressionValue(skip, "now");
        Disposable subscribe2 = ObservablesKt.zipWith(map, skip).map(a2.a.a.e2.n.a.a).subscribe(new a2.a.a.e2.n.b(this), a2.a.a.e2.n.c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "was.zipWith(now)\n       …, it) }\n                )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.publish.analytics.PublishInputsAnalyticTracker
    public void unsubscribe() {
        this.a.clear();
    }
}
