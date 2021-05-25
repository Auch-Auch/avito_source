package com.avito.android.messenger.channels.mvi.common.v3;

import a2.b.a.a.a;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterKt;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LogsT;
import com.avito.android.util.Observables;
import com.avito.android.util.rx.concurrent.RxExecutor;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00011Bã\u0001\u0012\u0006\u0010=\u001a\u00020\u0007\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000b0P\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\b\b\u0002\u0010D\u001a\u00020\u000f\u00128\b\u0002\u0010$\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d\u00128\b\u0002\u0010F\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d\u00128\b\u0002\u0010+\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d¢\u0006\u0004\bR\u0010SJI\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0016\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0004¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\f¢\u0006\u0004\b\u0018\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRF\u0010$\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(RF\u0010+\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00108\u001a\u00020\u000b8B@\u0002X\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010=\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CRF\u0010F\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010#R\"\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000G008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u00102R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001d\u0010O\u001a\u00020\u000b8B@\u0002X\u0002¢\u0006\f\n\u0004\bN\u00105\u001a\u0004\bH\u00107¨\u0006T"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "", "KeyT", "Lio/reactivex/disposables/Disposable;", "T", "Lio/reactivex/Single;", AbuseCategoryItemPresenterKt.SINGLE_TAG, "", "operationName", "", "keys", "Lio/reactivex/Scheduler;", "scheduler", "callSingle", "(Lio/reactivex/Single;Ljava/lang/String;Ljava/util/Set;Lio/reactivex/Scheduler;)Lio/reactivex/Single;", "", "isDisposed", "()Z", "", "dispose", "()V", "otherKeys", "doesNotOverlapWith", "(Ljava/util/Set;Ljava/util/Set;)Z", "overlapsWith", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "j", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "keyOverlapChecker", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tag", "message", "l", "Lkotlin/jvm/functions/Function2;", "logVerbose", "Lcom/jakewharton/rxrelay2/Relay;", "", "h", "Lcom/jakewharton/rxrelay2/Relay;", "opStartTriggerStream", "n", "logInfo", "Ljava/util/concurrent/atomic/AtomicLong;", a2.g.r.g.a, "Ljava/util/concurrent/atomic/AtomicLong;", "opIdCounter", "Ljava/util/LinkedList;", AuthSource.BOOKING_ORDER, "Ljava/util/LinkedList;", "contestedKeys", "f", "Lkotlin/Lazy;", "getStartTriggerProcessingScheduler", "()Lio/reactivex/Scheduler;", "startTriggerProcessingScheduler", "i", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "c", "Ljava/util/Set;", "ongoingOpKeys", "k", "Z", "extensiveLoggingEnabled", AuthSource.OPEN_CHANNEL_LIST, "logDebug", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock$b;", AuthSource.SEND_ABUSE, "opQueue", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "d", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "actionExecutor", "e", "callProcessingScheduler", "Lkotlin/Function0;", "schedulerFactory", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class RxFairCompositeWriteLock<KeyT> implements Disposable {
    public final LinkedList<b<KeyT>> a;
    public final LinkedList<Set<KeyT>> b;
    public final Set<KeyT> c;
    public final RxExecutor d;
    public final Lazy e;
    public final Lazy f;
    public final AtomicLong g;
    public final Relay<Long> h;
    @NotNull
    public final String i;
    public final OverlapChecker<KeyT> j;
    public final boolean k;
    public final Function2<String, String, Unit> l;
    public final Function2<String, String, Unit> m;
    public final Function2<String, String, Unit> n;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<String, String, Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            int i = this.a;
            if (i == 0) {
                String str3 = str;
                String str4 = str2;
                Intrinsics.checkNotNullParameter(str3, "tag");
                Intrinsics.checkNotNullParameter(str4, "message");
                LogsT.verbose$default(str3, str4, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str5 = str;
                String str6 = str2;
                Intrinsics.checkNotNullParameter(str5, "tag");
                Intrinsics.checkNotNullParameter(str6, "message");
                LogsT.debug$default(str5, str6, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 2) {
                String str7 = str;
                String str8 = str2;
                Intrinsics.checkNotNullParameter(str7, "tag");
                Intrinsics.checkNotNullParameter(str8, "message");
                LogsT.info$default(str7, str8, null, 4, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<KeyT> {
        @JvmField
        public final long a;
        @JvmField
        @NotNull
        public final String b;
        @JvmField
        @NotNull
        public final Set<KeyT> c;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Set<? extends KeyT> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(long j, @NotNull String str, @NotNull Set<? extends KeyT> set) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(set, "keys");
            this.a = j;
            this.b = str;
            this.c = set;
        }

        @NotNull
        public String toString() {
            StringBuilder I = a2.b.a.a.a.I(Typography.less);
            I.append(this.c);
            I.append(Typography.greater);
            I.append(this.b);
            I.append('-');
            I.append(this.a);
            return I.toString();
        }
    }

    public static final class c extends Lambda implements Function0<SharedScheduler> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SharedScheduler invoke() {
            return new SharedScheduler((Scheduler) this.a.invoke());
        }
    }

    public static final class d extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ RxFairCompositeWriteLock a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RxFairCompositeWriteLock rxFairCompositeWriteLock, String str) {
            super(1);
            this.a = rxFairCompositeWriteLock;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Long l) {
            Function2 function2 = this.a.l;
            String tag = this.a.getTAG();
            function2.invoke(tag, this.b + " listener received trigger=" + l);
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Predicate<Pair<? extends b<KeyT>, ? extends Long>> {
        public final /* synthetic */ RxFairCompositeWriteLock a;

        public e(RxFairCompositeWriteLock rxFairCompositeWriteLock) {
            this.a = rxFairCompositeWriteLock;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            b bVar = (b) pair.component1();
            Long l = (Long) pair.component2();
            boolean z = l != null && bVar.a == l.longValue();
            if (this.a.k) {
                if (z) {
                    Function2 function2 = this.a.l;
                    String tag = this.a.getTAG();
                    function2.invoke(tag, bVar + " filter received trigger=" + l + " => PASSED");
                } else {
                    Function2 function22 = this.a.l;
                    String tag2 = this.a.getTAG();
                    function22.invoke(tag2, bVar + " filter received trigger=" + l + " => didn't pass");
                }
            }
            return z;
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends b<KeyT>, ? extends Long>, SingleSource<? extends T>> {
        public final /* synthetic */ RxFairCompositeWriteLock a;
        public final /* synthetic */ Single b;
        public final /* synthetic */ Scheduler c;

        public f(RxFairCompositeWriteLock rxFairCompositeWriteLock, Single single, Scheduler scheduler) {
            this.a = rxFairCompositeWriteLock;
            this.b = single;
            this.c = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            b bVar = (b) pair.component1();
            if (this.a.k) {
                Function2 function2 = this.a.l;
                String tag = this.a.getTAG();
                function2.invoke(tag, bVar + " triggered");
            }
            return this.b.doFinally(new a2.a.a.o1.b.b.a.c.d(this, bVar)).subscribeOn(this.c);
        }
    }

    public static final class g extends Lambda implements Function0<Scheduler> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            return ForkJoinCommonPoolScheduler.INSTANCE.getValue();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public RxFairCompositeWriteLock(@NotNull String str, @NotNull Function0<? extends Scheduler> function0, @NotNull OverlapChecker<KeyT> overlapChecker, boolean z, @NotNull Function2<? super String, ? super String, Unit> function2, @NotNull Function2<? super String, ? super String, Unit> function22, @NotNull Function2<? super String, ? super String, Unit> function23) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(function0, "schedulerFactory");
        Intrinsics.checkNotNullParameter(overlapChecker, "keyOverlapChecker");
        Intrinsics.checkNotNullParameter(function2, "logVerbose");
        Intrinsics.checkNotNullParameter(function22, "logDebug");
        Intrinsics.checkNotNullParameter(function23, "logInfo");
        this.i = str;
        this.j = overlapChecker;
        this.k = z;
        this.l = function2;
        this.m = function22;
        this.n = function23;
        this.a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.c = new HashSet();
        this.d = new RxExecutor(new SharedScheduler((Scheduler) function0.invoke()));
        this.e = t6.c.lazy(new c(function0));
        this.f = t6.c.lazy(g.a);
        this.g = new AtomicLong(0);
        this.h = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    }

    public static final void access$addOperation(RxFairCompositeWriteLock rxFairCompositeWriteLock, b bVar) {
        rxFairCompositeWriteLock.d.execute(new Runnable(bVar) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock$addOperation$$inlined$invoke$1
            public final /* synthetic */ RxFairCompositeWriteLock.b b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (RxFairCompositeWriteLock.this.k) {
                    Function2 function2 = RxFairCompositeWriteLock.this.l;
                    String tag = RxFairCompositeWriteLock.this.getTAG();
                    StringBuilder L = a.L("addOperation(");
                    L.append(this.b);
                    L.append(')');
                    function2.invoke(tag, L.toString());
                }
                RxFairCompositeWriteLock.this.a.add(this.b);
                RxFairCompositeWriteLock.access$processOpQueueFromTheHead(RxFairCompositeWriteLock.this);
            }
        });
    }

    public static final boolean access$attemptToStartOperation(RxFairCompositeWriteLock rxFairCompositeWriteLock, b bVar, Iterator it) {
        boolean z;
        Objects.requireNonNull(rxFairCompositeWriteLock);
        Function2 function2 = rxFairCompositeWriteLock.l;
        String tag = rxFairCompositeWriteLock.getTAG();
        function2.invoke(tag, "attemptToStartOperation " + bVar);
        if (rxFairCompositeWriteLock.doesNotOverlapWith(bVar.c, rxFairCompositeWriteLock.c)) {
            Iterator it2 = rxFairCompositeWriteLock.b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Set<? extends KeyT> set = (Set) it2.next();
                if (!Intrinsics.areEqual(bVar.c, set)) {
                    Set<KeyT> set2 = bVar.c;
                    Intrinsics.checkNotNullExpressionValue(set, "contestedKeySet");
                    if (!rxFairCompositeWriteLock.doesNotOverlapWith(set2, set)) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            z = true;
            if (z) {
                if (rxFairCompositeWriteLock.k) {
                    Function2 function22 = rxFairCompositeWriteLock.l;
                    String tag2 = rxFairCompositeWriteLock.getTAG();
                    function22.invoke(tag2, "Dequeue '" + bVar + "' ");
                }
                Function2 function23 = rxFairCompositeWriteLock.m;
                String tag3 = rxFairCompositeWriteLock.getTAG();
                function23.invoke(tag3, "startOperation(" + bVar + ')');
                if (rxFairCompositeWriteLock.k) {
                    Function2 function24 = rxFairCompositeWriteLock.l;
                    String tag4 = rxFairCompositeWriteLock.getTAG();
                    function24.invoke(tag4, "startOperation(" + bVar + "): adding " + bVar.c + " to ongoingOpKeys = " + rxFairCompositeWriteLock.c);
                }
                rxFairCompositeWriteLock.c.addAll(bVar.c);
                if (rxFairCompositeWriteLock.k) {
                    Function2 function25 = rxFairCompositeWriteLock.l;
                    String tag5 = rxFairCompositeWriteLock.getTAG();
                    function25.invoke(tag5, "startOperation(" + bVar + "): removing " + bVar + " from opQueue = " + rxFairCompositeWriteLock.a);
                }
                it.remove();
                if (rxFairCompositeWriteLock.b.remove(bVar.c)) {
                    if (rxFairCompositeWriteLock.k) {
                        Function2 function26 = rxFairCompositeWriteLock.l;
                        String tag6 = rxFairCompositeWriteLock.getTAG();
                        function26.invoke(tag6, "startOperation(" + bVar + "): removed " + bVar.c + " from contestedKeys = " + rxFairCompositeWriteLock.b);
                    }
                    access$processOpQueueFromTheHead(rxFairCompositeWriteLock);
                }
                if (rxFairCompositeWriteLock.k) {
                    Function2 function27 = rxFairCompositeWriteLock.l;
                    String tag7 = rxFairCompositeWriteLock.getTAG();
                    StringBuilder sb = new StringBuilder();
                    sb.append("startOperation(");
                    sb.append(bVar);
                    sb.append("): sending ");
                    function27.invoke(tag7, a2.b.a.a.a.l(sb, bVar.a, " to opStartTriggerStream"));
                }
                rxFairCompositeWriteLock.h.accept(Long.valueOf(bVar.a));
                return true;
            } else if (rxFairCompositeWriteLock.b.contains(bVar.c)) {
                return false;
            } else {
                rxFairCompositeWriteLock.b.add(bVar.c);
                return false;
            }
        } else if (rxFairCompositeWriteLock.b.contains(bVar.c)) {
            return false;
        } else {
            rxFairCompositeWriteLock.b.add(bVar.c);
            return false;
        }
    }

    public static final void access$finishOperation(RxFairCompositeWriteLock rxFairCompositeWriteLock, b bVar) {
        rxFairCompositeWriteLock.d.execute(new Runnable(bVar) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock$finishOperation$$inlined$invoke$1
            public final /* synthetic */ RxFairCompositeWriteLock.b b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function2 function2 = RxFairCompositeWriteLock.this.m;
                String tag = RxFairCompositeWriteLock.this.getTAG();
                StringBuilder L = a.L("finishOperation(");
                L.append(this.b);
                L.append(')');
                function2.invoke(tag, L.toString());
                RxFairCompositeWriteLock.this.c.removeAll(this.b.c);
                RxFairCompositeWriteLock.access$processOpQueueFromTheHead(RxFairCompositeWriteLock.this);
            }
        });
    }

    public static final void access$processOpQueueFromTheHead(RxFairCompositeWriteLock rxFairCompositeWriteLock) {
        rxFairCompositeWriteLock.d.execute(new Runnable() { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock$processOpQueueFromTheHead$$inlined$invoke$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                if (RxFairCompositeWriteLock.this.k) {
                    RxFairCompositeWriteLock.this.l.invoke(RxFairCompositeWriteLock.this.getTAG(), "processOpQueueFromTheHead()");
                }
                Iterator it = RxFairCompositeWriteLock.this.a.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "opQueue.iterator()");
                while (it.hasNext()) {
                    RxFairCompositeWriteLock.b bVar = (RxFairCompositeWriteLock.b) it.next();
                    RxFairCompositeWriteLock rxFairCompositeWriteLock2 = RxFairCompositeWriteLock.this;
                    Intrinsics.checkNotNullExpressionValue(bVar, "operation");
                    Function2 function2 = rxFairCompositeWriteLock2.l;
                    String tag = rxFairCompositeWriteLock2.getTAG();
                    function2.invoke(tag, "attemptToStartOperation " + bVar);
                    boolean z2 = false;
                    if (rxFairCompositeWriteLock2.doesNotOverlapWith(bVar.c, rxFairCompositeWriteLock2.c)) {
                        Iterator it2 = rxFairCompositeWriteLock2.b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Set set = (Set) it2.next();
                            if (!Intrinsics.areEqual(bVar.c, set)) {
                                Set<KeyT> set2 = bVar.c;
                                Intrinsics.checkNotNullExpressionValue(set, "contestedKeySet");
                                if (!rxFairCompositeWriteLock2.doesNotOverlapWith(set2, set)) {
                                    z = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        z = true;
                        if (z) {
                            if (rxFairCompositeWriteLock2.k) {
                                Function2 function22 = rxFairCompositeWriteLock2.l;
                                String tag2 = rxFairCompositeWriteLock2.getTAG();
                                function22.invoke(tag2, "Dequeue '" + bVar + "' ");
                            }
                            Function2 function23 = rxFairCompositeWriteLock2.m;
                            String tag3 = rxFairCompositeWriteLock2.getTAG();
                            function23.invoke(tag3, "startOperation(" + bVar + ')');
                            if (rxFairCompositeWriteLock2.k) {
                                Function2 function24 = rxFairCompositeWriteLock2.l;
                                String tag4 = rxFairCompositeWriteLock2.getTAG();
                                function24.invoke(tag4, "startOperation(" + bVar + "): adding " + bVar.c + " to ongoingOpKeys = " + rxFairCompositeWriteLock2.c);
                            }
                            rxFairCompositeWriteLock2.c.addAll(bVar.c);
                            if (rxFairCompositeWriteLock2.k) {
                                Function2 function25 = rxFairCompositeWriteLock2.l;
                                String tag5 = rxFairCompositeWriteLock2.getTAG();
                                function25.invoke(tag5, "startOperation(" + bVar + "): removing " + bVar + " from opQueue = " + rxFairCompositeWriteLock2.a);
                            }
                            it.remove();
                            if (rxFairCompositeWriteLock2.b.remove(bVar.c)) {
                                if (rxFairCompositeWriteLock2.k) {
                                    Function2 function26 = rxFairCompositeWriteLock2.l;
                                    String tag6 = rxFairCompositeWriteLock2.getTAG();
                                    function26.invoke(tag6, "startOperation(" + bVar + "): removed " + bVar.c + " from contestedKeys = " + rxFairCompositeWriteLock2.b);
                                }
                                RxFairCompositeWriteLock.access$processOpQueueFromTheHead(rxFairCompositeWriteLock2);
                            }
                            if (rxFairCompositeWriteLock2.k) {
                                Function2 function27 = rxFairCompositeWriteLock2.l;
                                String tag7 = rxFairCompositeWriteLock2.getTAG();
                                StringBuilder sb = new StringBuilder();
                                sb.append("startOperation(");
                                sb.append(bVar);
                                sb.append("): sending ");
                                function27.invoke(tag7, a.l(sb, bVar.a, " to opStartTriggerStream"));
                            }
                            rxFairCompositeWriteLock2.h.accept(Long.valueOf(bVar.a));
                            z2 = true;
                            continue;
                        } else if (!rxFairCompositeWriteLock2.b.contains(bVar.c)) {
                            rxFairCompositeWriteLock2.b.add(bVar.c);
                            continue;
                        } else {
                            continue;
                        }
                    } else if (!rxFairCompositeWriteLock2.b.contains(bVar.c)) {
                        rxFairCompositeWriteLock2.b.add(bVar.c);
                        continue;
                    } else {
                        continue;
                    }
                    if (z2) {
                        return;
                    }
                }
            }
        });
    }

    public static final void access$startOperation(RxFairCompositeWriteLock rxFairCompositeWriteLock, b bVar, Iterator it) {
        Objects.requireNonNull(rxFairCompositeWriteLock);
        Function2 function2 = rxFairCompositeWriteLock.m;
        String tag = rxFairCompositeWriteLock.getTAG();
        function2.invoke(tag, "startOperation(" + bVar + ')');
        if (rxFairCompositeWriteLock.k) {
            Function2 function22 = rxFairCompositeWriteLock.l;
            String tag2 = rxFairCompositeWriteLock.getTAG();
            function22.invoke(tag2, "startOperation(" + bVar + "): adding " + bVar.c + " to ongoingOpKeys = " + rxFairCompositeWriteLock.c);
        }
        rxFairCompositeWriteLock.c.addAll(bVar.c);
        if (rxFairCompositeWriteLock.k) {
            Function2 function23 = rxFairCompositeWriteLock.l;
            String tag3 = rxFairCompositeWriteLock.getTAG();
            function23.invoke(tag3, "startOperation(" + bVar + "): removing " + bVar + " from opQueue = " + rxFairCompositeWriteLock.a);
        }
        it.remove();
        if (rxFairCompositeWriteLock.b.remove(bVar.c)) {
            if (rxFairCompositeWriteLock.k) {
                Function2 function24 = rxFairCompositeWriteLock.l;
                String tag4 = rxFairCompositeWriteLock.getTAG();
                function24.invoke(tag4, "startOperation(" + bVar + "): removed " + bVar.c + " from contestedKeys = " + rxFairCompositeWriteLock.b);
            }
            access$processOpQueueFromTheHead(rxFairCompositeWriteLock);
        }
        if (rxFairCompositeWriteLock.k) {
            Function2 function25 = rxFairCompositeWriteLock.l;
            String tag5 = rxFairCompositeWriteLock.getTAG();
            StringBuilder sb = new StringBuilder();
            sb.append("startOperation(");
            sb.append(bVar);
            sb.append("): sending ");
            function25.invoke(tag5, a2.b.a.a.a.l(sb, bVar.a, " to opStartTriggerStream"));
        }
        rxFairCompositeWriteLock.h.accept(Long.valueOf(bVar.a));
    }

    public final Scheduler a() {
        return (Scheduler) this.e.getValue();
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: io.reactivex.Single<R>, java.lang.Object, io.reactivex.Single<T> */
    @NotNull
    public final <T> Single<T> callSingle(@NotNull Single<T> single, @NotNull String str, @NotNull Set<? extends KeyT> set, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(single, AbuseCategoryItemPresenterKt.SINGLE_TAG);
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(set, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable create = Observable.create(new ObservableOnSubscribe<T>(this, str, set) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock$callSingle$$inlined$observableFromCallableWithoutComplete$1
            public final /* synthetic */ RxFairCompositeWriteLock a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Set c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.ObservableEmitter<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(@NotNull ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    try {
                        RxFairCompositeWriteLock.b bVar = new RxFairCompositeWriteLock.b(this.a.g.getAndIncrement(), this.b, this.c);
                        if (this.a.k) {
                            Function2 function2 = this.a.l;
                            String tag = this.a.getTAG();
                            function2.invoke(tag, "Enqueue '" + bVar + "' ");
                        }
                        RxFairCompositeWriteLock.access$addOperation(this.a, bVar);
                        observableEmitter.onNext(bVar);
                    } catch (Throwable th) {
                        observableEmitter.tryOnError(th);
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        Observable<T> subscribeOn = create.subscribeOn(a());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "observableFromCallableWi…(callProcessingScheduler)");
        Observable<Long> subscribeOn2 = this.h.observeOn(a()).subscribeOn(a());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "opStartTriggerStream\n   …(callProcessingScheduler)");
        Observable combineLatest = Observable.combineLatest(Observables.doOnNextIf(subscribeOn2, this.k, new d(this, str)), subscribeOn, RxFairCompositeWriteLock$callSingle$$inlined$reverseCombineLatestWith$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…2, t1 -> t1 to t2 }\n    )");
        Single single2 = (Single<R>) combineLatest.subscribeOn(a()).observeOn((Scheduler) this.f.getValue()).filter(new e(this)).firstOrError().flatMap(new f(this, single, scheduler));
        Intrinsics.checkNotNullExpressionValue(single2, "observableFromCallableWi…(scheduler)\n            }");
        return single2;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.d.dispose();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker<KeyT> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean doesNotOverlapWith(@NotNull Set<? extends KeyT> set, @NotNull Set<? extends KeyT> set2) {
        Intrinsics.checkNotNullParameter(set, "$this$doesNotOverlapWith");
        Intrinsics.checkNotNullParameter(set2, "otherKeys");
        for (Object obj : set) {
            Iterator<? extends KeyT> it = set2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (this.j.checkOverlap(obj, it.next())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @NotNull
    public final String getTAG() {
        return this.i;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public final boolean overlapsWith(@NotNull Set<? extends KeyT> set, @NotNull Set<? extends KeyT> set2) {
        Intrinsics.checkNotNullParameter(set, "$this$overlapsWith");
        Intrinsics.checkNotNullParameter(set2, "otherKeys");
        return !doesNotOverlapWith(set, set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RxFairCompositeWriteLock(String str, Function0 function0, OverlapChecker overlapChecker, boolean z, Function2 function2, Function2 function22, Function2 function23, int i2, j jVar) {
        this(str, function0, overlapChecker, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? a.b : function2, (i2 & 32) != 0 ? a.c : function22, (i2 & 64) != 0 ? a.d : function23);
    }
}
