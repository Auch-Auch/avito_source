package com.avito.android.messenger.channels.mvi.common.v2;

import android.annotation.SuppressLint;
import arrow.syntax.function.Partial;
import arrow.syntax.function.PartialsKt;
import com.avito.android.messenger.channels.mvi.common.v2.AbstractMviEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001f\u0012\u0006\u0010>\u001a\u00020\r\u0012\u0006\u0010?\u001a\u00028\u0000\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ9\u0010\u000b\u001a\u00020\n\"\n\b\u0002\u0010\u0006\u0018\u0001*\u00028\u0001*\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00020\u0007j\b\u0012\u0004\u0012\u00028\u0002`\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u000e\u001a\u00020\r\"\n\b\u0002\u0010\u0006\u0018\u0001*\u00028\u0001*\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00020\u0007j\b\u0012\u0004\u0012\u00028\u0002`\tH\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H$¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\b\"\b\b\u0002\u0010\u0006*\u00028\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJW\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00022.\b\b\u0010 \u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J]\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u000224\b\b\u0010 \u001a.\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b$\u0010\"Jf\u0010&\u001a\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%0\u0012\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00022.\b\b\u0010 \u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b&\u0010\"Jj\u0010'\u001a\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%0\u0012\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u000222\b\b\u0010 \u001a,\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b'\u0010\"J]\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00022.\b\b\u0010 \u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b(\u0010)Jc\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u000224\b\b\u0010 \u001a.\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b*\u0010)J]\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00022.\b\b\u0010 \u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b+\u0010)Ja\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u000222\b\b\u0010 \u001a,\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u001b¢\u0006\u0002\b\u001fH\bø\u0001\u0000¢\u0006\u0004\b,\u0010)R\u001c\u00102\u001a\u00020-8\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00108\u001a\b\u0012\u0004\u0012\u00028\u0001038\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R&\u0010=\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<\u0002\u0007\n\u0005\b20\u0001¨\u0006D"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithEvents;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v2/AbstractMviEvent;", "EventT", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntity;", "T", "Lkotlin/Function1;", "", "Lcom/avito/android/messenger/channels/mvi/common/v1/Dispatchable;", "", "dispatch", "(Lkotlin/jvm/functions/Function1;)V", "", "dispatchAndReturnName", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "Lio/reactivex/Observable;", "eventObservable", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "eventHandlerObservable", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "mutatorsObservable", "()Lio/reactivex/Observable;", "Lkotlin/reflect/KClass;", "klass", "generateEventId", "(Lkotlin/reflect/KClass;)J", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "oldState", "Lkotlin/ExtensionFunctionType;", "block", "mutator", "(Lcom/avito/android/messenger/channels/mvi/common/v2/AbstractMviEvent;Lkotlin/jvm/functions/Function2;)Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lio/reactivex/Single;", "mutatorSingle", "curState", "action", "actionSingle", "mutatorHandler", "(Lcom/avito/android/messenger/channels/mvi/common/v2/AbstractMviEvent;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "mutatorSingleHandler", "actionHandler", "actionSingleHandler", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "n", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "getSchedulerForEventHandlers", "()Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "schedulerForEventHandlers", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/Relay;", "getEventRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "eventRelay", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "l", "Ljava/util/concurrent/ConcurrentHashMap;", "eventIds", "TAG", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/avito/android/util/SchedulersFactory;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithEvents<StateT, EventT extends AbstractMviEvent> extends BaseMviEntity<StateT> {
    public final ConcurrentHashMap<KClass<?>, AtomicLong> l = new ConcurrentHashMap<>();
    @NotNull
    public final Relay<EventT> m = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    @NotNull
    public final SharedScheduler n;

    public static final class a<T> implements Consumer<EventT> {
        public final /* synthetic */ BaseMviEntityWithEvents a;

        public a(BaseMviEntityWithEvents baseMviEntityWithEvents) {
            this.a = baseMviEntityWithEvents;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            String tag = this.a.getTAG();
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" New Event: ");
            sb.append((AbstractMviEvent) obj);
            Logs.verbose$default(tag, sb.toString(), null, 4, null);
        }
    }

    public static final class b<T, R> implements Function<Observable<EventT>, ObservableSource<MutatorSingle<StateT>>> {
        public final /* synthetic */ BaseMviEntityWithEvents a;

        public b(BaseMviEntityWithEvents baseMviEntityWithEvents) {
            this.a = baseMviEntityWithEvents;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Observable<EventT> observable = (Observable) obj;
            Intrinsics.checkNotNullParameter(observable, "eventObservable");
            return this.a.eventHandlerObservable(observable);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntityWithEvents(@NotNull String str, @NotNull StateT statet, @NotNull SchedulersFactory schedulersFactory) {
        super(str, statet, schedulersFactory);
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.n = new SharedScheduler(schedulersFactory.io());
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> MutatorSingle<StateT> action(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, Unit> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$action");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        Action action = new Action(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        return new MutatorSingle<>(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action));
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> Observable<MutatorSingle<StateT>> actionHandler(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, Unit> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$actionHandler");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        Action action = new Action(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        Observable<MutatorSingle<StateT>> just = Observable.just(new MutatorSingle(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(action(block))");
        return just;
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> MutatorSingle<StateT> actionSingle(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends Single<?>> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$actionSingle");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        ActionSingle actionSingle = new ActionSingle(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        return new MutatorSingle<>(actionSingle.getName(), new BaseMviEntityKt$toMutatorSingle$3(actionSingle));
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> Observable<MutatorSingle<StateT>> actionSingleHandler(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends Single<?>> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$actionSingleHandler");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        ActionSingle actionSingle = new ActionSingle(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        Observable<MutatorSingle<StateT>> just = Observable.just(new MutatorSingle(actionSingle.getName(), new BaseMviEntityKt$toMutatorSingle$3(actionSingle)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(actionSingle(block))");
        return just;
    }

    @SuppressLint({})
    public final /* synthetic */ <T extends EventT> void dispatch(Function1<? super Long, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "$this$dispatch");
        Intrinsics.reifiedOperationMarker(4, "T");
        initialize().blockingGet();
        this.m.accept((AbstractMviEvent) function1.invoke(Long.valueOf(generateEventId(Reflection.getOrCreateKotlinClass(AbstractMviEvent.class)))));
    }

    public final /* synthetic */ <T extends EventT> String dispatchAndReturnName(Function1<? super Long, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "$this$dispatchAndReturnName");
        Intrinsics.reifiedOperationMarker(4, "T");
        AbstractMviEvent abstractMviEvent = (AbstractMviEvent) function1.invoke(Long.valueOf(generateEventId(Reflection.getOrCreateKotlinClass(AbstractMviEvent.class))));
        initialize().blockingGet();
        this.m.accept(abstractMviEvent);
        if (abstractMviEvent.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(abstractMviEvent, sb, '#');
            sb.append(abstractMviEvent.eventId);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        a2.b.a.a.a.K0(abstractMviEvent, sb2, '#');
        sb2.append(abstractMviEvent.eventId);
        sb2.append(' ');
        sb2.append(abstractMviEvent.getParamsString());
        return sb2.toString();
    }

    @NotNull
    public abstract Observable<MutatorSingle<StateT>> eventHandlerObservable(@NotNull Observable<EventT> observable);

    public final <T extends EventT> long generateEventId(@NotNull KClass<T> kClass) {
        AtomicLong putIfAbsent;
        Intrinsics.checkNotNullParameter(kClass, "klass");
        ConcurrentHashMap<KClass<?>, AtomicLong> concurrentHashMap = this.l;
        AtomicLong atomicLong = concurrentHashMap.get(kClass);
        if (atomicLong == null && (putIfAbsent = concurrentHashMap.putIfAbsent(kClass, (atomicLong = new AtomicLong(0)))) != null) {
            atomicLong = putIfAbsent;
        }
        return atomicLong.getAndIncrement();
    }

    @NotNull
    public final Relay<EventT> getEventRelay() {
        return this.m;
    }

    @NotNull
    public SharedScheduler getSchedulerForEventHandlers() {
        return this.n;
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> MutatorSingle<StateT> mutator(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends StateT> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$mutator");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        Mutator mutator = new Mutator(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        return new MutatorSingle<>(mutator.getName(), new BaseMviEntityKt$toMutatorSingle$1(mutator));
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> Observable<MutatorSingle<StateT>> mutatorHandler(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends StateT> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$mutatorHandler");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        Mutator mutator = new Mutator(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
        Observable<MutatorSingle<StateT>> just = Observable.just(new MutatorSingle(mutator.getName(), new BaseMviEntityKt$toMutatorSingle$1(mutator)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(mutator(block))");
        return just;
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> MutatorSingle<StateT> mutatorSingle(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends Single<StateT>> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$mutatorSingle");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        return new MutatorSingle<>(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null));
    }

    @NotNull
    public final <EventT extends AbstractMviEvent> Observable<MutatorSingle<StateT>> mutatorSingleHandler(@NotNull EventT eventt, @NotNull Function2<? super EventT, ? super StateT, ? extends Single<StateT>> function2) {
        String str;
        Intrinsics.checkNotNullParameter(eventt, "$this$mutatorSingleHandler");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (eventt.getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb, '#');
            sb.append(eventt.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.K0(eventt, sb2, '#');
            sb2.append(eventt.eventId);
            sb2.append(' ');
            sb2.append(eventt.getParamsString());
            str = sb2.toString();
        }
        Observable<MutatorSingle<StateT>> just = Observable.just(new MutatorSingle(str, PartialsKt.invoke$default(function2, eventt, (Partial) null, 2, (Object) null)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(mutatorSingle(block))");
        return just;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity
    @NotNull
    public Observable<MutatorSingle<StateT>> mutatorsObservable() {
        Observable<R> publish = this.m.observeOn(getSchedulerForEventHandlers()).doOnNext(new a(this)).publish(new b(this));
        Intrinsics.checkNotNullExpressionValue(publish, "eventRelay\n            .…Observable)\n            }");
        return publish;
    }
}
