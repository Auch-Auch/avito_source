package com.avito.android.redux;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.redux.Action;
import com.avito.android.redux.State;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005BK\u0012\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 \u0012\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0 \u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00028\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014RD\u0010\u001b\u001a0\u0012\f\u0012\n \u0017*\u0004\u0018\u00018\u00008\u0000 \u0017*\u0017\u0012\f\u0012\n \u0017*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u0016¢\u0006\u0002\b\u00180\u0016¢\u0006\u0002\b\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR(\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R(\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010#¨\u0006+"}, d2 = {"Lcom/avito/android/redux/DefaultSubscribableStore;", "Lcom/avito/android/redux/State;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/redux/Action;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/redux/SubscribableStore;", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribe", "()Lio/reactivex/rxjava3/disposables/Disposable;", "action", "", "dispatch", "(Lcom/avito/android/redux/Action;)V", "Lio/reactivex/rxjava3/core/Observable;", "stateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "getState", "()Lcom/avito/android/redux/State;", "Lcom/jakewharton/rxrelay3/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/Relay;", "actions", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "state", "Lio/reactivex/rxjava3/core/Scheduler;", "e", "Lio/reactivex/rxjava3/core/Scheduler;", "observeScheduler", "", "Lcom/avito/android/redux/Reducer;", "c", "Ljava/util/List;", "reducers", "Lcom/avito/android/redux/Middleware;", "d", "middlewares", "initialState", "<init>", "(Ljava/util/List;Ljava/util/List;Lio/reactivex/rxjava3/core/Scheduler;Lcom/avito/android/redux/State;)V", "redux"}, k = 1, mv = {1, 4, 2})
public final class DefaultSubscribableStore<S extends State, A extends Action> implements SubscribableStore<S, A> {
    public final BehaviorRelay<S> a;
    public final Relay<A> b;
    public final List<Reducer<S, A>> c;
    public final List<Middleware<S, A>> d;
    public final Scheduler e;

    public static final class a<T, R> implements Function<Pair<? extends A, ? extends S>, S> {
        public final /* synthetic */ DefaultSubscribableStore a;

        public a(DefaultSubscribableStore defaultSubscribableStore) {
            this.a = defaultSubscribableStore;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Action action = (Action) pair.component1();
            State state = (State) pair.component2();
            for (T t : this.a.c) {
                Intrinsics.checkNotNullExpressionValue(state, "state");
                Intrinsics.checkNotNullExpressionValue(action, "action");
                state = t.reduce(state, action);
            }
            return state;
        }
    }

    public static final class b<T> implements Predicate<Pair<? extends A, ? extends A>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            Pair pair = (Pair) obj;
            return !Intrinsics.areEqual((Action) pair.getFirst(), (Action) pair.getSecond());
        }
    }

    public static final class c<T, R> implements Function<Pair<? extends A, ? extends A>, A> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Action) ((Pair) obj).getFirst();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.redux.Reducer<S extends com.avito.android.redux.State, ? super A extends com.avito.android.redux.Action>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.redux.Middleware<S extends com.avito.android.redux.State, A extends com.avito.android.redux.Action>> */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSubscribableStore(@NotNull List<? extends Reducer<S, ? super A>> list, @NotNull List<? extends Middleware<S, A>> list2, @NotNull Scheduler scheduler, @NotNull S s) {
        Intrinsics.checkNotNullParameter(list, "reducers");
        Intrinsics.checkNotNullParameter(list2, "middlewares");
        Intrinsics.checkNotNullParameter(scheduler, "observeScheduler");
        Intrinsics.checkNotNullParameter(s, "initialState");
        this.c = list;
        this.d = list2;
        this.e = scheduler;
        this.a = BehaviorRelay.createDefault(s);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
    }

    @Override // com.avito.android.redux.Store
    public void dispatch(@NotNull A a3) {
        Intrinsics.checkNotNullParameter(a3, "action");
        this.b.accept(a3);
    }

    @Override // com.avito.android.redux.Store
    @NotNull
    public S getState() {
        BehaviorRelay<S> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "state");
        S value = behaviorRelay.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "state.value");
        return value;
    }

    @Override // com.avito.android.redux.Store
    @NotNull
    public Observable<S> stateChanges() {
        Observable<S> hide = this.a.distinctUntilChanged().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "state\n            .disti…ged()\n            .hide()");
        return hide;
    }

    @Override // com.avito.android.redux.SubscribableStore
    @NotNull
    public Disposable subscribe() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Relay<A> relay = this.b;
        BehaviorRelay<S> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "state");
        Observable<R> withLatestFrom = relay.withLatestFrom(behaviorRelay, new BiFunction<A, S, R>() { // from class: com.avito.android.redux.DefaultSubscribableStore$subscribe$$inlined$withLatestFrom$1
            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(A a3, S s) {
                Intrinsics.checkExpressionValueIsNotNull(a3, "t");
                Intrinsics.checkExpressionValueIsNotNull(s, "u");
                return (R) TuplesKt.to(a3, s);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe = withLatestFrom.map(new a(this)).subscribe(this.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "actions\n            .wit…        .subscribe(state)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        List<Middleware<S, A>> list = this.d;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Relay<A> relay2 = this.b;
            Observable<S> hide = this.a.hide();
            Intrinsics.checkNotNullExpressionValue(hide, "state.hide()");
            Observable<R> withLatestFrom2 = it.next().create(relay2, hide).withLatestFrom(this.b, new BiFunction<A, A, R>() { // from class: com.avito.android.redux.DefaultSubscribableStore$$special$$inlined$withLatestFrom$1
                @Override // io.reactivex.rxjava3.functions.BiFunction
                @NotNull
                public final R apply(A a3, A a4) {
                    Intrinsics.checkExpressionValueIsNotNull(a3, "t");
                    Intrinsics.checkExpressionValueIsNotNull(a4, "u");
                    return (R) TuplesKt.to(a3, a4);
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(withLatestFrom2, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
            arrayList.add(withLatestFrom2.filter(b.a).map(c.a));
        }
        Disposable subscribe2 = Observable.merge(arrayList).observeOn(this.e).subscribe(this.b);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "Observable.merge(\n      …      .subscribe(actions)");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        return compositeDisposable;
    }
}
