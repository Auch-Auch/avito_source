package com.avito.android.messenger.channels.mvi.common.v3;

import a2.b.a.a.a;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterKt;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00012Bó\u0001\u0012\u0006\u0010Y\u001a\u00020\u0007\u0012\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\f0Z\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000009\u0012\b\b\u0002\u0010T\u001a\u00020\n\u00128\b\u0002\u00100\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)\u00128\b\u0002\u0010>\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)\u00128\b\u0002\u0010Q\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)¢\u0006\u0004\b\\\u0010]JO\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0018\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0004¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u001a\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\f¢\u0006\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'RF\u00100\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R(\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020%058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;RF\u0010>\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010/R\u001d\u0010A\u001a\u00020\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000F018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u00103R\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NRF\u0010Q\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010/R\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0019\u0010Y\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X¨\u0006^"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "", "KeyT", "Lio/reactivex/disposables/Disposable;", "T", "Lio/reactivex/Single;", AbuseCategoryItemPresenterKt.SINGLE_TAG, "", "operationName", "", "", "keys", "Lio/reactivex/Scheduler;", "scheduler", "callSingle", "(Lio/reactivex/Single;Ljava/lang/String;Ljava/util/Map;Lio/reactivex/Scheduler;)Lio/reactivex/Single;", "isDisposed", "()Z", "", "dispose", "()V", "contestedKeySet", "doesNotOverlapWith$mvi_release", "(Ljava/util/Map;Ljava/util/Map;)Z", "doesNotOverlapWith", "overlapsWith$mvi_release", "overlapsWith", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "k", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "keyOverlapChecker", a2.g.r.g.a, "Lkotlin/Lazy;", "getStartTriggerProcessingScheduler", "()Lio/reactivex/Scheduler;", "startTriggerProcessingScheduler", "", "", "d", "Ljava/util/Map;", "ongoingOpReadKeys", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tag", "message", "n", "Lkotlin/jvm/functions/Function2;", "logVerbose", "Ljava/util/LinkedList;", AuthSource.BOOKING_ORDER, "Ljava/util/LinkedList;", "contestedKeys", "Lcom/jakewharton/rxrelay2/Relay;", "i", "Lcom/jakewharton/rxrelay2/Relay;", "opStartTriggerStream", "Lcom/avito/android/messenger/channels/mvi/common/v3/ToStringConverter;", "l", "Lcom/avito/android/messenger/channels/mvi/common/v3/ToStringConverter;", "keyToStringConverter", "o", "logDebug", "f", AuthSource.SEND_ABUSE, "callProcessingScheduler", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "e", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "actionExecutor", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock$b;", "opQueue", "", "c", "Ljava/util/Set;", "ongoingOpWriteKeys", "Ljava/util/concurrent/atomic/AtomicLong;", "h", "Ljava/util/concurrent/atomic/AtomicLong;", "opIdCounter", "p", "logInfo", AuthSource.OPEN_CHANNEL_LIST, "Z", "extensiveLoggingEnabled", "j", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lkotlin/Function0;", "schedulerFactory", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;Lcom/avito/android/messenger/channels/mvi/common/v3/ToStringConverter;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class RxFairCompositeReadWriteLock<KeyT> implements Disposable {
    public final LinkedList<b<KeyT>> a;
    public final LinkedList<Map<KeyT, Boolean>> b;
    public final Set<KeyT> c;
    public final Map<KeyT, Long> d;
    public final RxExecutor e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicLong h;
    public final Relay<Long> i;
    @NotNull
    public final String j;
    public final OverlapChecker<KeyT> k;
    public final ToStringConverter<KeyT> l;
    public final boolean m;
    public final Function2<String, String, Unit> n;
    public final Function2<String, String, Unit> o;
    public final Function2<String, String, Unit> p;

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
                Logs.verbose$default(str3, str4, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str5 = str;
                String str6 = str2;
                Intrinsics.checkNotNullParameter(str5, "tag");
                Intrinsics.checkNotNullParameter(str6, "message");
                Logs.debug$default(str5, str6, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 2) {
                String str7 = str;
                String str8 = str2;
                Intrinsics.checkNotNullParameter(str7, "tag");
                Intrinsics.checkNotNullParameter(str8, "message");
                Logs.info$default(str7, str8, null, 4, null);
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
        public final Map<KeyT, Boolean> c;
        @JvmField
        @NotNull
        public final String d;

        public b(long j, @NotNull String str, @NotNull Map<KeyT, Boolean> map, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(map, "keys");
            Intrinsics.checkNotNullParameter(str2, "keysString");
            this.a = j;
            this.b = str;
            this.c = map;
            this.d = str2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("-opId(");
            sb.append(this.a);
            sb.append(")-<");
            return a2.b.a.a.a.s(sb, this.d, Typography.greater);
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
        public final /* synthetic */ RxFairCompositeReadWriteLock a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, String str) {
            super(1);
            this.a = rxFairCompositeReadWriteLock;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Long l) {
            Function2 function2 = this.a.n;
            String tag = this.a.getTAG();
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(' ');
            sb.append(this.b);
            sb.append(" listener received trigger=");
            sb.append(l);
            function2.invoke(tag, sb.toString());
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Predicate<Pair<? extends b<KeyT>, ? extends Long>> {
        public final /* synthetic */ RxFairCompositeReadWriteLock a;

        public e(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock) {
            this.a = rxFairCompositeReadWriteLock;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            b bVar = (b) pair.component1();
            Long l = (Long) pair.component2();
            boolean z = l != null && bVar.a == l.longValue();
            if (this.a.m) {
                if (z) {
                    Function2 function2 = this.a.n;
                    String tag = this.a.getTAG();
                    StringBuilder sb = new StringBuilder();
                    StringBuilder I = a2.b.a.a.a.I('[');
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    I.append(currentThread.getName());
                    I.append(']');
                    sb.append(I.toString());
                    sb.append(' ');
                    sb.append(bVar);
                    sb.append(" filter received trigger=");
                    sb.append(l);
                    sb.append(" => PASSED");
                    function2.invoke(tag, sb.toString());
                } else {
                    Function2 function22 = this.a.n;
                    String tag2 = this.a.getTAG();
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder I2 = a2.b.a.a.a.I('[');
                    Thread currentThread2 = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                    I2.append(currentThread2.getName());
                    I2.append(']');
                    sb2.append(I2.toString());
                    sb2.append(' ');
                    sb2.append(bVar);
                    sb2.append(" filter received trigger=");
                    sb2.append(l);
                    sb2.append(" => didn't pass");
                    function22.invoke(tag2, sb2.toString());
                }
            }
            return z;
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends b<KeyT>, ? extends Long>, SingleSource<? extends T>> {
        public final /* synthetic */ RxFairCompositeReadWriteLock a;
        public final /* synthetic */ Single b;
        public final /* synthetic */ Scheduler c;

        public f(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Single single, Scheduler scheduler) {
            this.a = rxFairCompositeReadWriteLock;
            this.b = single;
            this.c = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            b bVar = (b) pair.component1();
            if (this.a.m) {
                Function2 function2 = this.a.n;
                String tag = this.a.getTAG();
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a2.b.a.a.a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(' ');
                sb.append(bVar);
                sb.append(" triggered");
                function2.invoke(tag, sb.toString());
            }
            return this.b.doFinally(new a2.a.a.o1.b.b.a.c.c(this, bVar)).subscribeOn(this.c);
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

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public RxFairCompositeReadWriteLock(@NotNull String str, @NotNull Function0<? extends Scheduler> function0, @NotNull OverlapChecker<KeyT> overlapChecker, @NotNull ToStringConverter<KeyT> toStringConverter, boolean z, @NotNull Function2<? super String, ? super String, Unit> function2, @NotNull Function2<? super String, ? super String, Unit> function22, @NotNull Function2<? super String, ? super String, Unit> function23) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(function0, "schedulerFactory");
        Intrinsics.checkNotNullParameter(overlapChecker, "keyOverlapChecker");
        Intrinsics.checkNotNullParameter(toStringConverter, "keyToStringConverter");
        Intrinsics.checkNotNullParameter(function2, "logVerbose");
        Intrinsics.checkNotNullParameter(function22, "logDebug");
        Intrinsics.checkNotNullParameter(function23, "logInfo");
        this.j = str;
        this.k = overlapChecker;
        this.l = toStringConverter;
        this.m = z;
        this.n = function2;
        this.o = function22;
        this.p = function23;
        this.a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.c = new HashSet();
        this.d = new HashMap();
        this.e = new RxExecutor(new SharedScheduler((Scheduler) function0.invoke()));
        this.f = t6.c.lazy(new c(function0));
        this.g = t6.c.lazy(g.a);
        this.h = new AtomicLong(0);
        this.i = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    }

    public static final void access$addOperation(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, b bVar) {
        rxFairCompositeReadWriteLock.e.execute(new Runnable(bVar) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock$addOperation$$inlined$invoke$1
            public final /* synthetic */ RxFairCompositeReadWriteLock.b b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (RxFairCompositeReadWriteLock.this.m) {
                    Function2 function2 = RxFairCompositeReadWriteLock.this.n;
                    String tag = RxFairCompositeReadWriteLock.this.getTAG();
                    StringBuilder sb = new StringBuilder();
                    a.f1("Thread.currentThread()", a.I('['), ']', sb, " addOperation(");
                    sb.append(this.b);
                    sb.append(')');
                    function2.invoke(tag, sb.toString());
                }
                RxFairCompositeReadWriteLock.this.a.add(this.b);
                RxFairCompositeReadWriteLock.access$processOpQueueFromTheHead(RxFairCompositeReadWriteLock.this);
            }
        });
    }

    public static final void access$addReadKeysToOngoingOpReadKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!((Boolean) entry.getValue()).booleanValue()) {
                Long l2 = (Long) rxFairCompositeReadWriteLock.d.get(key);
                if (l2 != null) {
                    rxFairCompositeReadWriteLock.d.put(key, Long.valueOf(l2.longValue() + 1));
                } else {
                    rxFairCompositeReadWriteLock.d.put(key, 1L);
                }
            }
        }
    }

    public static final void access$addWriteKeysToOngoingOpWriteKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                rxFairCompositeReadWriteLock.c.add(key);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker */
    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$attemptToStartOperation(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, b bVar, Iterator it) {
        boolean z;
        boolean z2;
        boolean z3;
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        Function2 function2 = rxFairCompositeReadWriteLock.n;
        String tag = rxFairCompositeReadWriteLock.getTAG();
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a2.b.a.a.a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" attemptToStartOperation ");
        sb.append(bVar);
        function2.invoke(tag, sb.toString());
        Iterator<Map.Entry<KeyT, Boolean>> it2 = bVar.c.entrySet().iterator();
        loop0:
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            KeyT key = it2.next().getKey();
            Iterator it3 = rxFairCompositeReadWriteLock.c.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (rxFairCompositeReadWriteLock.k.checkOverlap(key, it3.next())) {
                        z = false;
                        break loop0;
                    }
                }
            }
        }
        if (z) {
            Iterator<Map.Entry<KeyT, Boolean>> it4 = bVar.c.entrySet().iterator();
            loop2:
            while (true) {
                if (!it4.hasNext()) {
                    z2 = true;
                    break;
                }
                Map.Entry<KeyT, Boolean> next = it4.next();
                KeyT key2 = next.getKey();
                if (next.getValue().booleanValue()) {
                    for (Object obj : rxFairCompositeReadWriteLock.d.keySet()) {
                        if (rxFairCompositeReadWriteLock.k.checkOverlap(key2, obj)) {
                            z2 = false;
                            break loop2;
                        }
                    }
                    continue;
                }
            }
            if (z2) {
                Iterator it5 = rxFairCompositeReadWriteLock.b.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        z3 = true;
                        break;
                    }
                    Map<KeyT, Boolean> map = (Map) it5.next();
                    if (Intrinsics.areEqual(bVar.c, map)) {
                        z3 = true;
                        break;
                    }
                    Map<KeyT, Boolean> map2 = bVar.c;
                    Intrinsics.checkNotNullExpressionValue(map, "contestedKeySet");
                    if (!rxFairCompositeReadWriteLock.doesNotOverlapWith$mvi_release(map2, map)) {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    if (rxFairCompositeReadWriteLock.m) {
                        Function2 function22 = rxFairCompositeReadWriteLock.n;
                        String tag2 = rxFairCompositeReadWriteLock.getTAG();
                        StringBuilder sb2 = new StringBuilder();
                        a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb2, " Dequeue '", bVar);
                        sb2.append("' ");
                        function22.invoke(tag2, sb2.toString());
                    }
                    Function2 function23 = rxFairCompositeReadWriteLock.o;
                    String tag3 = rxFairCompositeReadWriteLock.getTAG();
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder I2 = a2.b.a.a.a.I('[');
                    Thread currentThread2 = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                    I2.append(currentThread2.getName());
                    I2.append(']');
                    sb3.append(I2.toString());
                    sb3.append(" startOperation ");
                    sb3.append(bVar);
                    function23.invoke(tag3, sb3.toString());
                    if (rxFairCompositeReadWriteLock.m) {
                        Function2 function24 = rxFairCompositeReadWriteLock.n;
                        String tag4 = rxFairCompositeReadWriteLock.getTAG();
                        StringBuilder sb4 = new StringBuilder();
                        a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb4, " startOperation(", bVar);
                        sb4.append("): adding ");
                        sb4.append(bVar.c);
                        sb4.append(" to ongoingOpWriteKeys = ");
                        sb4.append(rxFairCompositeReadWriteLock.c);
                        function24.invoke(tag4, sb4.toString());
                        Function2 function25 = rxFairCompositeReadWriteLock.n;
                        String tag5 = rxFairCompositeReadWriteLock.getTAG();
                        StringBuilder sb5 = new StringBuilder();
                        a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb5, " startOperation(", bVar);
                        sb5.append("): adding ");
                        sb5.append(bVar.c);
                        sb5.append(" to ongoingOpReadKeys = ");
                        sb5.append(rxFairCompositeReadWriteLock.d);
                        function25.invoke(tag5, sb5.toString());
                    }
                    for (Map.Entry<KeyT, Boolean> entry : bVar.c.entrySet()) {
                        KeyT key3 = entry.getKey();
                        if (!entry.getValue().booleanValue()) {
                            Long l2 = (Long) rxFairCompositeReadWriteLock.d.get(key3);
                            if (l2 != null) {
                                rxFairCompositeReadWriteLock.d.put(key3, Long.valueOf(l2.longValue() + 1));
                            } else {
                                rxFairCompositeReadWriteLock.d.put(key3, 1L);
                            }
                        }
                    }
                    for (Map.Entry<KeyT, Boolean> entry2 : bVar.c.entrySet()) {
                        KeyT key4 = entry2.getKey();
                        if (entry2.getValue().booleanValue()) {
                            rxFairCompositeReadWriteLock.c.add(key4);
                        }
                    }
                    if (rxFairCompositeReadWriteLock.m) {
                        Function2 function26 = rxFairCompositeReadWriteLock.n;
                        String tag6 = rxFairCompositeReadWriteLock.getTAG();
                        StringBuilder sb6 = new StringBuilder();
                        a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb6, " startOperation ", bVar);
                        sb6.append(": removing ");
                        sb6.append(bVar);
                        sb6.append(" from opQueue = ");
                        sb6.append(rxFairCompositeReadWriteLock.a);
                        function26.invoke(tag6, sb6.toString());
                    }
                    it.remove();
                    if (rxFairCompositeReadWriteLock.b.remove(bVar.c)) {
                        if (rxFairCompositeReadWriteLock.m) {
                            Function2 function27 = rxFairCompositeReadWriteLock.n;
                            String tag7 = rxFairCompositeReadWriteLock.getTAG();
                            StringBuilder sb7 = new StringBuilder();
                            a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb7, " startOperation(", bVar);
                            sb7.append("): removed ");
                            sb7.append(bVar.c);
                            sb7.append(" from contestedKeys = ");
                            sb7.append(rxFairCompositeReadWriteLock.b);
                            function27.invoke(tag7, sb7.toString());
                        }
                        access$processOpQueueFromTheHead(rxFairCompositeReadWriteLock);
                    }
                    if (rxFairCompositeReadWriteLock.m) {
                        Function2 function28 = rxFairCompositeReadWriteLock.n;
                        String tag8 = rxFairCompositeReadWriteLock.getTAG();
                        StringBuilder sb8 = new StringBuilder();
                        a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb8, " startOperation ", bVar);
                        sb8.append(": sending ");
                        function28.invoke(tag8, a2.b.a.a.a.l(sb8, bVar.a, " to opStartTriggerStream"));
                    }
                    rxFairCompositeReadWriteLock.i.accept(Long.valueOf(bVar.a));
                    return true;
                } else if (rxFairCompositeReadWriteLock.b.contains(bVar.c)) {
                    return false;
                } else {
                    rxFairCompositeReadWriteLock.b.add(bVar.c);
                    return false;
                }
            }
        }
        if (rxFairCompositeReadWriteLock.b.contains(bVar.c)) {
            return false;
        }
        rxFairCompositeReadWriteLock.b.add(bVar.c);
        return false;
    }

    public static final String access$convertToString(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                arrayList2.add(rxFairCompositeReadWriteLock.l.convertToString(key));
            } else {
                arrayList.add(rxFairCompositeReadWriteLock.l.convertToString(key));
            }
        }
        return 'W' + arrayList2 + "-R" + arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$doesNotOverlapWithOngoingOpReadKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                for (Object obj : rxFairCompositeReadWriteLock.d.keySet()) {
                    if (rxFairCompositeReadWriteLock.k.checkOverlap(key, obj)) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$doesNotOverlapWithOngoingOpWriteKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Iterator it = rxFairCompositeReadWriteLock.c.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (rxFairCompositeReadWriteLock.k.checkOverlap(key, it.next())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final void access$finishOperation(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, b bVar) {
        rxFairCompositeReadWriteLock.e.execute(new Runnable(bVar) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock$finishOperation$$inlined$invoke$1
            public final /* synthetic */ RxFairCompositeReadWriteLock.b b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Long l2;
                Function2 function2 = RxFairCompositeReadWriteLock.this.o;
                String tag = RxFairCompositeReadWriteLock.this.getTAG();
                StringBuilder sb = new StringBuilder();
                a.f1("Thread.currentThread()", a.I('['), ']', sb, " finishOperation ");
                sb.append(this.b);
                function2.invoke(tag, sb.toString());
                RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock2 = RxFairCompositeReadWriteLock.this;
                for (Map.Entry<KeyT, Boolean> entry : this.b.c.entrySet()) {
                    KeyT key = entry.getKey();
                    if (!entry.getValue().booleanValue() && (l2 = (Long) rxFairCompositeReadWriteLock2.d.get(key)) != null) {
                        if (l2.longValue() > 1) {
                            rxFairCompositeReadWriteLock2.d.put(key, Long.valueOf(l2.longValue() - 1));
                        } else {
                            rxFairCompositeReadWriteLock2.d.remove(key);
                        }
                    }
                }
                RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock3 = RxFairCompositeReadWriteLock.this;
                for (Map.Entry<KeyT, Boolean> entry2 : this.b.c.entrySet()) {
                    KeyT key2 = entry2.getKey();
                    if (entry2.getValue().booleanValue()) {
                        rxFairCompositeReadWriteLock3.c.remove(key2);
                    }
                }
                RxFairCompositeReadWriteLock.access$processOpQueueFromTheHead(RxFairCompositeReadWriteLock.this);
            }
        });
    }

    public static final void access$processOpQueueFromTheHead(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock) {
        rxFairCompositeReadWriteLock.e.execute(new Runnable() { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock$processOpQueueFromTheHead$$inlined$invoke$1
            /* JADX WARNING: Removed duplicated region for block: B:82:0x03a9 A[LOOP:0: B:4:0x003d->B:82:0x03a9, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x03b1 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 946
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock$processOpQueueFromTheHead$$inlined$invoke$1.run():void");
            }
        });
    }

    public static final void access$removeReadKeysFromOngoingOpReadKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Long l2;
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!((Boolean) entry.getValue()).booleanValue() && (l2 = (Long) rxFairCompositeReadWriteLock.d.get(key)) != null) {
                if (l2.longValue() > 1) {
                    rxFairCompositeReadWriteLock.d.put(key, Long.valueOf(l2.longValue() - 1));
                } else {
                    rxFairCompositeReadWriteLock.d.remove(key);
                }
            }
        }
    }

    public static final void access$removeWriteKeysFromOngoingOpWriteKeys(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, Map map) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                rxFairCompositeReadWriteLock.c.remove(key);
            }
        }
    }

    public static final void access$startOperation(RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock, b bVar, Iterator it) {
        Objects.requireNonNull(rxFairCompositeReadWriteLock);
        Function2 function2 = rxFairCompositeReadWriteLock.o;
        String tag = rxFairCompositeReadWriteLock.getTAG();
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a2.b.a.a.a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" startOperation ");
        sb.append(bVar);
        function2.invoke(tag, sb.toString());
        if (rxFairCompositeReadWriteLock.m) {
            Function2 function22 = rxFairCompositeReadWriteLock.n;
            String tag2 = rxFairCompositeReadWriteLock.getTAG();
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb2, " startOperation(", bVar);
            sb2.append("): adding ");
            sb2.append(bVar.c);
            sb2.append(" to ongoingOpWriteKeys = ");
            sb2.append(rxFairCompositeReadWriteLock.c);
            function22.invoke(tag2, sb2.toString());
            Function2 function23 = rxFairCompositeReadWriteLock.n;
            String tag3 = rxFairCompositeReadWriteLock.getTAG();
            StringBuilder sb3 = new StringBuilder();
            a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb3, " startOperation(", bVar);
            sb3.append("): adding ");
            sb3.append(bVar.c);
            sb3.append(" to ongoingOpReadKeys = ");
            sb3.append(rxFairCompositeReadWriteLock.d);
            function23.invoke(tag3, sb3.toString());
        }
        for (Map.Entry<KeyT, Boolean> entry : bVar.c.entrySet()) {
            KeyT key = entry.getKey();
            if (!entry.getValue().booleanValue()) {
                Long l2 = (Long) rxFairCompositeReadWriteLock.d.get(key);
                if (l2 != null) {
                    rxFairCompositeReadWriteLock.d.put(key, Long.valueOf(l2.longValue() + 1));
                } else {
                    rxFairCompositeReadWriteLock.d.put(key, 1L);
                }
            }
        }
        for (Map.Entry<KeyT, Boolean> entry2 : bVar.c.entrySet()) {
            KeyT key2 = entry2.getKey();
            if (entry2.getValue().booleanValue()) {
                rxFairCompositeReadWriteLock.c.add(key2);
            }
        }
        if (rxFairCompositeReadWriteLock.m) {
            Function2 function24 = rxFairCompositeReadWriteLock.n;
            String tag4 = rxFairCompositeReadWriteLock.getTAG();
            StringBuilder sb4 = new StringBuilder();
            a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb4, " startOperation ", bVar);
            sb4.append(": removing ");
            sb4.append(bVar);
            sb4.append(" from opQueue = ");
            sb4.append(rxFairCompositeReadWriteLock.a);
            function24.invoke(tag4, sb4.toString());
        }
        it.remove();
        if (rxFairCompositeReadWriteLock.b.remove(bVar.c)) {
            if (rxFairCompositeReadWriteLock.m) {
                Function2 function25 = rxFairCompositeReadWriteLock.n;
                String tag5 = rxFairCompositeReadWriteLock.getTAG();
                StringBuilder sb5 = new StringBuilder();
                a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb5, " startOperation(", bVar);
                sb5.append("): removed ");
                sb5.append(bVar.c);
                sb5.append(" from contestedKeys = ");
                sb5.append(rxFairCompositeReadWriteLock.b);
                function25.invoke(tag5, sb5.toString());
            }
            access$processOpQueueFromTheHead(rxFairCompositeReadWriteLock);
        }
        if (rxFairCompositeReadWriteLock.m) {
            Function2 function26 = rxFairCompositeReadWriteLock.n;
            String tag6 = rxFairCompositeReadWriteLock.getTAG();
            StringBuilder sb6 = new StringBuilder();
            a2.b.a.a.a.g1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb6, " startOperation ", bVar);
            sb6.append(": sending ");
            function26.invoke(tag6, a2.b.a.a.a.l(sb6, bVar.a, " to opStartTriggerStream"));
        }
        rxFairCompositeReadWriteLock.i.accept(Long.valueOf(bVar.a));
    }

    public final Scheduler a() {
        return (Scheduler) this.f.getValue();
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: io.reactivex.Single<R>, java.lang.Object, io.reactivex.Single<T> */
    @NotNull
    public final <T> Single<T> callSingle(@NotNull Single<T> single, @NotNull String str, @NotNull Map<KeyT, Boolean> map, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(single, AbuseCategoryItemPresenterKt.SINGLE_TAG);
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(map, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable create = Observable.create(new ObservableOnSubscribe<T>(this, str, map) { // from class: com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock$callSingle$$inlined$observableFromCallableWithoutComplete$1
            public final /* synthetic */ RxFairCompositeReadWriteLock a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Map c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: io.reactivex.ObservableEmitter<T> */
            /* JADX DEBUG: Multi-variable search result rejected for r8v6, resolved type: com.avito.android.messenger.channels.mvi.common.v3.ToStringConverter */
            /* JADX DEBUG: Multi-variable search result rejected for r8v8, resolved type: com.avito.android.messenger.channels.mvi.common.v3.ToStringConverter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(@NotNull ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    try {
                        long andIncrement = this.a.h.getAndIncrement();
                        String str2 = this.b;
                        Map map2 = this.c;
                        RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock = this.a;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Map.Entry entry : map2.entrySet()) {
                            Object key = entry.getKey();
                            if (((Boolean) entry.getValue()).booleanValue()) {
                                arrayList2.add(rxFairCompositeReadWriteLock.l.convertToString(key));
                            } else {
                                arrayList.add(rxFairCompositeReadWriteLock.l.convertToString(key));
                            }
                        }
                        RxFairCompositeReadWriteLock.b bVar = new RxFairCompositeReadWriteLock.b(andIncrement, str2, map2, 'W' + arrayList2 + "-R" + arrayList);
                        if (this.a.m) {
                            Function2 function2 = this.a.n;
                            String tag = this.a.getTAG();
                            StringBuilder sb = new StringBuilder();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append('[');
                            Thread currentThread = Thread.currentThread();
                            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                            sb2.append(currentThread.getName());
                            sb2.append(']');
                            sb.append(sb2.toString());
                            sb.append(" Enqueue '");
                            sb.append(bVar);
                            sb.append("' ");
                            function2.invoke(tag, sb.toString());
                        }
                        RxFairCompositeReadWriteLock.access$addOperation(this.a, bVar);
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
        Observable<Long> subscribeOn2 = this.i.observeOn(a()).subscribeOn(a());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "opStartTriggerStream\n   …(callProcessingScheduler)");
        Observable combineLatest = Observable.combineLatest(Observables.doOnNextIf(subscribeOn2, this.m, new d(this, str)), subscribeOn, RxFairCompositeReadWriteLock$callSingle$$inlined$reverseCombineLatestWith$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…2, t1 -> t1 to t2 }\n    )");
        Single single2 = (Single<R>) combineLatest.subscribeOn(a()).observeOn((Scheduler) this.g.getValue()).filter(new e(this)).firstOrError().flatMap(new f(this, single, scheduler));
        Intrinsics.checkNotNullExpressionValue(single2, "observableFromCallableWi…(scheduler)\n            }");
        return single2;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.e.dispose();
    }

    public final boolean doesNotOverlapWith$mvi_release(@NotNull Map<KeyT, Boolean> map, @NotNull Map<KeyT, Boolean> map2) {
        Intrinsics.checkNotNullParameter(map, "$this$doesNotOverlapWith");
        Intrinsics.checkNotNullParameter(map2, "contestedKeySet");
        for (Map.Entry<KeyT, Boolean> entry : map.entrySet()) {
            KeyT key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                for (Map.Entry<KeyT, Boolean> entry2 : map2.entrySet()) {
                    if (this.k.checkOverlap(key, entry2.getKey())) {
                        return false;
                    }
                }
                continue;
            } else {
                for (Map.Entry<KeyT, Boolean> entry3 : map2.entrySet()) {
                    KeyT key2 = entry3.getKey();
                    if (entry3.getValue().booleanValue() && this.k.checkOverlap(key, key2)) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    @NotNull
    public final String getTAG() {
        return this.j;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.e.isDisposed();
    }

    public final boolean overlapsWith$mvi_release(@NotNull Map<KeyT, Boolean> map, @NotNull Map<KeyT, Boolean> map2) {
        Intrinsics.checkNotNullParameter(map, "$this$overlapsWith");
        Intrinsics.checkNotNullParameter(map2, "contestedKeySet");
        return !doesNotOverlapWith$mvi_release(map, map2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RxFairCompositeReadWriteLock(String str, Function0 function0, OverlapChecker overlapChecker, ToStringConverter toStringConverter, boolean z, Function2 function2, Function2 function22, Function2 function23, int i2, j jVar) {
        this(str, function0, overlapChecker, (i2 & 8) != 0 ? new DefaultToStringConverter() : toStringConverter, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? a.b : function2, (i2 & 64) != 0 ? a.c : function22, (i2 & 128) != 0 ? a.d : function23);
    }
}
