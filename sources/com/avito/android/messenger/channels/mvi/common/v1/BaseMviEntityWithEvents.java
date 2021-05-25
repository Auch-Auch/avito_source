package com.avito.android.messenger.channels.mvi.common.v1;

import a2.b.a.a.a;
import arrow.syntax.function.Partial;
import arrow.syntax.function.PartialsKt;
import com.avito.android.messenger.channels.mvi.common.v1.AbstractMviEvent;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u0017\u0012\u0006\u00104\u001a\u00028\u0000\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J9\u0010\u000b\u001a\u00020\n\"\n\b\u0002\u0010\u0006\u0018\u0001*\u00028\u0001*\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00020\u0007j\b\u0012\u0004\u0012\u00028\u0002`\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\b\"\b\b\u0002\u0010\u0006*\u00028\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\rH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0001\u0010\u001a\u001aC\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0015\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00028\u0000`\u0019*\u00028\u000123\b\b\u0010\u0016\u001a-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0001\u0010\u001e\u001aC\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0015\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00028\u0000`\u0019*\u00028\u00012-\b\u0004\u0010\u001d\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u001cH\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001bJ¨\u0001\u0010$\u001aI\u0012E\u0012C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0015\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00028\u0000`\u00190#\"\b\b\u0002\u0010\u0006*\u00028\u0001*\u00028\u00022>\b\b\u0010\"\u001a8\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00000\u001fj\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000` ¢\u0006\u0002\b!H\bø\u0001\u0000¢\u0006\u0004\b$\u0010%J®\u0001\u0010(\u001aI\u0012E\u0012C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0015\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00028\u0000`\u00190#\"\b\b\u0002\u0010\u0006*\u00028\u0001*\u00028\u00022D\b\b\u0010'\u001a>\u0012\u0004\u0012\u00028\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u001fj\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000`&¢\u0006\u0002\b!H\bø\u0001\u0000¢\u0006\u0004\b(\u0010%R\"\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010)8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R&\u00103\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102\u0002\u0007\n\u0005\b20\u0001¨\u00069"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntityWithEvents;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v1/AbstractMviEvent;", "EventT", "Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntity;", "T", "Lkotlin/Function1;", "", "Lcom/avito/android/messenger/channels/mvi/common/v1/Dispatchable;", "", "dispatch", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/reflect/KClass;", "klass", "generateEventId", "(Lkotlin/reflect/KClass;)J", "Lkotlin/ParameterName;", "name", "oldState", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/common/v1/MutatorSingle;", "mutatorSingle", "Lkotlin/Pair;", "", "Lcom/avito/android/messenger/channels/mvi/common/v1/NamedMutatorSingle;", "namedMutatorSingle", "(Lcom/avito/android/messenger/channels/mvi/common/v1/AbstractMviEvent;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "Lcom/avito/android/messenger/channels/mvi/common/v1/Mutator;", "mutator", "namedMutatorSingleFromMutator", "Lkotlin/Function2;", "Lcom/avito/android/messenger/channels/mvi/common/v1/EventMutator;", "Lkotlin/ExtensionFunctionType;", "eventMutator", "Lio/reactivex/Observable;", "namedMutatorHandler", "(Lcom/avito/android/messenger/channels/mvi/common/v1/AbstractMviEvent;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "Lcom/avito/android/messenger/channels/mvi/common/v1/EventMutatorSingle;", "eventMutatorSingle", "namedMutatorSingleHandler", "Lcom/jakewharton/rxrelay2/Relay;", "j", "Lcom/jakewharton/rxrelay2/Relay;", "getEventRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "eventRelay", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "eventIds", "defaultState", "Lio/reactivex/Scheduler;", "schedulerForMutators", "<init>", "(Ljava/lang/Object;Lio/reactivex/Scheduler;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithEvents<StateT, EventT extends AbstractMviEvent> extends BaseMviEntity<StateT> {
    public final ConcurrentHashMap<KClass<?>, AtomicLong> i = new ConcurrentHashMap<>();
    @NotNull
    public final Relay<EventT> j = a.J1("PublishRelay.create<T>().toSerialized()");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntityWithEvents(@NotNull StateT statet, @NotNull Scheduler scheduler) {
        super(statet, scheduler);
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(scheduler, "schedulerForMutators");
    }

    public final /* synthetic */ <T extends EventT> void dispatch(Function1<? super Long, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "$this$dispatch");
        Relay relay = this.j;
        Intrinsics.reifiedOperationMarker(4, "T");
        relay.accept(function1.invoke(Long.valueOf(generateEventId(Reflection.getOrCreateKotlinClass(AbstractMviEvent.class)))));
    }

    public final <T extends EventT> long generateEventId(@NotNull KClass<T> kClass) {
        AtomicLong putIfAbsent;
        Intrinsics.checkNotNullParameter(kClass, "klass");
        ConcurrentHashMap<KClass<?>, AtomicLong> concurrentHashMap = this.i;
        AtomicLong atomicLong = concurrentHashMap.get(kClass);
        if (atomicLong == null && (putIfAbsent = concurrentHashMap.putIfAbsent(kClass, (atomicLong = new AtomicLong(0)))) != null) {
            atomicLong = putIfAbsent;
        }
        return atomicLong.getAndIncrement();
    }

    @NotNull
    public final Relay<EventT> getEventRelay() {
        return this.j;
    }

    @NotNull
    public final <T extends EventT> Observable<Pair<Function1<StateT, Single<StateT>>, String>> namedMutatorHandler(@NotNull T t, @NotNull Function2<? super T, ? super StateT, ? extends StateT> function2) {
        Intrinsics.checkNotNullParameter(t, "$this$namedMutatorHandler");
        Intrinsics.checkNotNullParameter(function2, "eventMutator");
        BaseMviEntitiesKt$mutatorSingle$1 baseMviEntitiesKt$mutatorSingle$1 = new BaseMviEntitiesKt$mutatorSingle$1(PartialsKt.invoke$default((Function2) function2, (Object) t, (Partial) null, 2, (Object) null));
        StringBuilder L = a.L("Mutator.");
        L.append(t.getName());
        Observable<Pair<Function1<StateT, Single<StateT>>, String>> just = Observable.just(TuplesKt.to(baseMviEntitiesKt$mutatorSingle$1, L.toString()));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(\n       …\"Mutator.$name\"\n        )");
        return just;
    }

    @NotNull
    public final Pair<Function1<StateT, Single<StateT>>, String> namedMutatorSingle(@NotNull EventT eventt, @NotNull Function1<? super StateT, ? extends Single<StateT>> function1) {
        Intrinsics.checkNotNullParameter(eventt, "$this$namedMutatorSingle");
        Intrinsics.checkNotNullParameter(function1, "mutatorSingle");
        return TuplesKt.to(function1, "Mutator." + eventt.getName());
    }

    @NotNull
    public final Pair<Function1<StateT, Single<StateT>>, String> namedMutatorSingleFromMutator(@NotNull EventT eventt, @NotNull Function1<? super StateT, ? extends StateT> function1) {
        Intrinsics.checkNotNullParameter(eventt, "$this$namedMutatorSingleFromMutator");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        BaseMviEntitiesKt$mutatorSingle$1 baseMviEntitiesKt$mutatorSingle$1 = new BaseMviEntitiesKt$mutatorSingle$1(function1);
        StringBuilder L = a.L("Mutator.");
        L.append(eventt.getName());
        return TuplesKt.to(baseMviEntitiesKt$mutatorSingle$1, L.toString());
    }

    @NotNull
    public final <T extends EventT> Observable<Pair<Function1<StateT, Single<StateT>>, String>> namedMutatorSingleHandler(@NotNull T t, @NotNull Function2<? super T, ? super StateT, ? extends Single<StateT>> function2) {
        Intrinsics.checkNotNullParameter(t, "$this$namedMutatorSingleHandler");
        Intrinsics.checkNotNullParameter(function2, "eventMutatorSingle");
        Function1 invoke$default = PartialsKt.invoke$default((Function2) function2, (Object) t, (Partial) null, 2, (Object) null);
        StringBuilder L = a.L("Mutator.");
        L.append(t.getName());
        Observable<Pair<Function1<StateT, Single<StateT>>, String>> just = Observable.just(TuplesKt.to(invoke$default, L.toString()));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(eventMut…this) to \"Mutator.$name\")");
        return just;
    }
}
