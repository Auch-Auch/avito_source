package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.InvalidationTracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public class RxRoom {
    public static final Object NOTHING = new Object();

    public static class a implements FlowableOnSubscribe<Object> {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ RoomDatabase b;

        /* renamed from: androidx.room.RxRoom$a$a  reason: collision with other inner class name */
        public class C0123a extends InvalidationTracker.Observer {
            public final /* synthetic */ FlowableEmitter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0123a(a aVar, String[] strArr, FlowableEmitter flowableEmitter) {
                super(strArr);
                this.b = flowableEmitter;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> set) {
                if (!this.b.isCancelled()) {
                    this.b.onNext(RxRoom.NOTHING);
                }
            }
        }

        public class b implements Action {
            public final /* synthetic */ InvalidationTracker.Observer a;

            public b(InvalidationTracker.Observer observer) {
                this.a = observer;
            }

            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                a.this.b.getInvalidationTracker().removeObserver(this.a);
            }
        }

        public a(String[] strArr, RoomDatabase roomDatabase) {
            this.a = strArr;
            this.b = roomDatabase;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public void subscribe(FlowableEmitter<Object> flowableEmitter) throws Exception {
            C0123a aVar = new C0123a(this, this.a, flowableEmitter);
            FlowableCreate.a aVar2 = (FlowableCreate.a) flowableEmitter;
            if (!aVar2.isCancelled()) {
                this.b.getInvalidationTracker().addObserver(aVar);
                aVar2.b.update(Disposables.fromAction(new b(aVar)));
            }
            if (!aVar2.isCancelled()) {
                flowableEmitter.onNext(RxRoom.NOTHING);
            }
        }
    }

    public static class b implements Function<Object, MaybeSource<T>> {
        public final /* synthetic */ Maybe a;

        public b(Maybe maybe) {
            this.a = maybe;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return this.a;
        }
    }

    public static class c implements ObservableOnSubscribe<Object> {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ RoomDatabase b;

        public class a extends InvalidationTracker.Observer {
            public final /* synthetic */ ObservableEmitter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, String[] strArr, ObservableEmitter observableEmitter) {
                super(strArr);
                this.b = observableEmitter;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> set) {
                this.b.onNext(RxRoom.NOTHING);
            }
        }

        public class b implements Action {
            public final /* synthetic */ InvalidationTracker.Observer a;

            public b(InvalidationTracker.Observer observer) {
                this.a = observer;
            }

            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                c.this.b.getInvalidationTracker().removeObserver(this.a);
            }
        }

        public c(String[] strArr, RoomDatabase roomDatabase) {
            this.a = strArr;
            this.b = roomDatabase;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
            a aVar = new a(this, this.a, observableEmitter);
            this.b.getInvalidationTracker().addObserver(aVar);
            observableEmitter.setDisposable(Disposables.fromAction(new b(aVar)));
            observableEmitter.onNext(RxRoom.NOTHING);
        }
    }

    public static class d implements Function<Object, MaybeSource<T>> {
        public final /* synthetic */ Maybe a;

        public d(Maybe maybe) {
            this.a = maybe;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return this.a;
        }
    }

    public static class e implements SingleOnSubscribe<T> {
        public final /* synthetic */ Callable a;

        public e(Callable callable) {
            this.a = callable;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public void subscribe(SingleEmitter<T> singleEmitter) throws Exception {
            try {
                singleEmitter.onSuccess((T) this.a.call());
            } catch (EmptyResultSetException e) {
                singleEmitter.tryOnError(e);
            }
        }
    }

    public static Flowable<Object> createFlowable(RoomDatabase roomDatabase, String... strArr) {
        return Flowable.create(new a(strArr, roomDatabase), BackpressureStrategy.LATEST);
    }

    public static Observable<Object> createObservable(RoomDatabase roomDatabase, String... strArr) {
        return Observable.create(new c(strArr, roomDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Single<T> createSingle(Callable<T> callable) {
        return Single.create(new e(callable));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createFlowable(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> Observable<T> createObservable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createObservable(roomDatabase, false, strArr, callable);
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: io.reactivex.Flowable<R>, io.reactivex.Flowable<T> */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<T> callable) {
        Executor executor;
        if (z) {
            executor = roomDatabase.getTransactionExecutor();
        } else {
            executor = roomDatabase.getQueryExecutor();
        }
        Scheduler from = Schedulers.from(executor);
        return (Flowable<R>) createFlowable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new b(Maybe.fromCallable(callable)));
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: io.reactivex.Observable<R>, io.reactivex.Observable<T> */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Observable<T> createObservable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<T> callable) {
        Executor executor;
        if (z) {
            executor = roomDatabase.getTransactionExecutor();
        } else {
            executor = roomDatabase.getQueryExecutor();
        }
        Scheduler from = Schedulers.from(executor);
        return (Observable<R>) createObservable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new d(Maybe.fromCallable(callable)));
    }
}
