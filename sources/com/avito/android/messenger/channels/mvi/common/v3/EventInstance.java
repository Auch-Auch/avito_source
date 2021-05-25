package com.avito.android.messenger.channels.mvi.common.v3;

import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00062\b\u0012\u0004\u0012\u00028\u00010\u0007:\u00029:B\u001f\u0012\u0006\u00100\u001a\u00028\u0000\u0012\u0006\u00106\u001a\u000201\u0012\u0006\u0010$\u001a\u00028\u0002¢\u0006\u0004\b7\u00108J\u0013\u0010\t\u001a\u00020\b*\u00028\u0002H'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\u0016\u001a \u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00130\u0015\"\u0004\b\u0003\u0010\u0011\"\b\b\u0004\u0010\u0012*\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00040\u0013H\b¢\u0006\u0004\b\u0016\u0010\u0017JX\u0010\u001a\u001a,\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00190\u0018\"\u0004\b\u0003\u0010\u0011\"\b\b\u0004\u0010\u0012*\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00040\u0013H\b¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010$\u001a\u00028\u00028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R.\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0004\u0012\u00020&0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00100\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "", "EventT", "PartialStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "DepsT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;", "Lcom/avito/android/messenger/channels/mvi/common/v3/HasPropertyKeys;", "", "doHandle", "(Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;)V", "Lio/reactivex/Completable;", "handle", "()Lio/reactivex/Completable;", "", "toString", "()Ljava/lang/String;", "R", "PartialStateSubclassT", "Lkotlin/reflect/KMutableProperty0;", "property", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "writeKeyProperty", "(Lkotlin/reflect/KMutableProperty0;)Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "Lkotlin/reflect/KProperty0;", "readKeyProperty", "(Lkotlin/reflect/KMutableProperty0;)Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getParamsString", "paramsString", "e", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "getDeps", "()Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "deps", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getKeys", "()Ljava/util/Map;", "keys", "c", "Ljava/lang/Object;", "getTypeObj", "()Ljava/lang/Object;", "typeObj", "", "d", "J", "getId", "()J", "id", "<init>", "(Ljava/lang/Object;JLcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;)V", "ReadKeyProperty", "WriteKeyProperty", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class EventInstance<EventT, PartialStateT, DepsT extends BaseEventDeps<PartialStateT>> implements BaseEvent, HasPropertyKeys<PartialStateT> {
    @NotNull
    public final Map<KMutableProperty0<PartialStateT>, Boolean> a = new LinkedHashMap();
    @NotNull
    public final String b = "";
    @NotNull
    public final EventT c;
    public final long d;
    @NotNull
    public final DepsT e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\b\b\u0005\u0010\u0003*\u00028\u0004*\u000e\b\u0006\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00050\u0004*\u000e\b\u0007\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00050\u00062\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00070\bB)\u0012\u0006\u0010\u0010\u001a\u00028\u0006\u0012\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0004\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\f\u001a\u00028\u00072\u0006\u0010\t\u001a\u00028\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00028\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "R", "PartialStateT", "PartialStateSubclassT", "Lkotlin/reflect/KMutableProperty0;", "InT", "Lkotlin/reflect/KProperty0;", "ReturnT", "Lkotlin/properties/ReadOnlyProperty;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/reflect/KProperty0;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/KMutableProperty0;", "value", "", "", "keys", "<init>", "(Lkotlin/reflect/KMutableProperty0;Ljava/util/Map;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReadKeyProperty<R, PartialStateT, PartialStateSubclassT extends PartialStateT, InT extends KMutableProperty0<PartialStateSubclassT>, ReturnT extends KProperty0<? extends PartialStateSubclassT>> implements ReadOnlyProperty<R, ReturnT> {
        public final InT a;

        public ReadKeyProperty(@NotNull InT r2, @NotNull Map<KMutableProperty0<PartialStateT>, Boolean> map) {
            Intrinsics.checkNotNullParameter(r2, "value");
            Intrinsics.checkNotNullParameter(map, "keys");
            this.a = r2;
            Objects.requireNonNull(r2, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<PartialStateT>");
            map.put(r2, Boolean.FALSE);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [ReturnT extends kotlin.reflect.KProperty0<? extends PartialStateSubclassT>, java.lang.Object, InT extends kotlin.reflect.KMutableProperty0<PartialStateSubclassT>] */
        @Override // kotlin.properties.ReadOnlyProperty
        @NotNull
        public ReturnT getValue(R r, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(kProperty, "property");
            InT r1 = this.a;
            Objects.requireNonNull(r1, "null cannot be cast to non-null type ReturnT");
            return r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\b\b\u0005\u0010\u0003*\u00028\u0004*\u000e\b\u0006\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00050\u00042\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00060\u0006B)\u0012\u0006\u0010\u000e\u001a\u00028\u0006\u0012\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0004\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\n\u001a\u00028\u00062\u0006\u0010\u0007\u001a\u00028\u00032\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00028\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "R", "PartialStateT", "PartialStateSubclassT", "Lkotlin/reflect/KMutableProperty0;", "ReturnT", "Lkotlin/properties/ReadOnlyProperty;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/reflect/KMutableProperty0;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/KMutableProperty0;", "value", "", "", "keys", "<init>", "(Lkotlin/reflect/KMutableProperty0;Ljava/util/Map;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class WriteKeyProperty<R, PartialStateT, PartialStateSubclassT extends PartialStateT, ReturnT extends KMutableProperty0<PartialStateSubclassT>> implements ReadOnlyProperty<R, ReturnT> {
        public final ReturnT a;

        public WriteKeyProperty(@NotNull ReturnT returnt, @NotNull Map<KMutableProperty0<PartialStateT>, Boolean> map) {
            Intrinsics.checkNotNullParameter(returnt, "value");
            Intrinsics.checkNotNullParameter(map, "keys");
            this.a = returnt;
            Objects.requireNonNull(returnt, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<PartialStateT>");
            map.put(returnt, Boolean.TRUE);
        }

        @Override // kotlin.properties.ReadOnlyProperty
        @NotNull
        public ReturnT getValue(R r, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return this.a;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ EventInstance a;

        public a(EventInstance eventInstance) {
            this.a = eventInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.avito.android.messenger.channels.mvi.common.v3.EventInstance */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Action
        public final void run() {
            String entityTag = this.a.getDeps().getEntityTag();
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.f1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb, " Executing ");
            sb.append(this.a);
            Logs.verbose$default(entityTag, sb.toString(), null, 4, null);
            EventInstance eventInstance = this.a;
            eventInstance.doHandle(eventInstance.getDeps());
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Map.Entry<KMutableProperty0<PartialStateT>, Boolean> entry : this.a.getKeys().entrySet()) {
                KMutableProperty0<PartialStateT> key = entry.getKey();
                if (entry.getValue().booleanValue()) {
                    linkedHashSet.add(key.get());
                }
            }
            this.a.getDeps().getPartialStatesConsumer().accept(linkedHashSet);
        }
    }

    public EventInstance(@NotNull EventT eventt, long j, @NotNull DepsT depst) {
        Intrinsics.checkNotNullParameter(eventt, "typeObj");
        Intrinsics.checkNotNullParameter(depst, "deps");
        this.c = eventt;
        this.d = j;
        this.e = depst;
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void doHandle(@NotNull DepsT depst);

    @NotNull
    public final DepsT getDeps() {
        return this.e;
    }

    public final long getId() {
        return this.d;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v3.HasPropertyKeys
    @NotNull
    public Map<KMutableProperty0<PartialStateT>, Boolean> getKeys() {
        return this.a;
    }

    @NotNull
    public String getParamsString() {
        return this.b;
    }

    @NotNull
    public final EventT getTypeObj() {
        return this.c;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEvent
    @NotNull
    public Completable handle() {
        Completable fromAction = Completable.fromAction(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…wPartialStates)\n        }");
        RxFairCompositeReadWriteLock<KMutableProperty0<?>> stateLock = this.e.getStateLock();
        String simpleName = this.c.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "typeObj.javaClass.simpleName");
        Map<KMutableProperty0<PartialStateT>, Boolean> keys = getKeys();
        Objects.requireNonNull(keys, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.reflect.KMutableProperty0<*>, kotlin.Boolean>");
        Scheduler io2 = this.e.getSchedulers().io();
        Single<T> singleDefault = fromAction.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = stateLock.callSingle(singleDefault, simpleName, keys, io2).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }

    @NotNull
    public final <R, PartialStateSubclassT extends PartialStateT> ReadKeyProperty<R, PartialStateT, PartialStateSubclassT, KMutableProperty0<PartialStateSubclassT>, KProperty0<PartialStateSubclassT>> readKeyProperty(@NotNull KMutableProperty0<PartialStateSubclassT> kMutableProperty0) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "property");
        return new ReadKeyProperty<>(kMutableProperty0, getKeys());
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<KMutableProperty0<PartialStateT>, Boolean> entry : getKeys().entrySet()) {
            KMutableProperty0<PartialStateT> key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                arrayList2.add(key.getName());
            } else {
                arrayList.add(key.getName());
            }
        }
        StringBuilder L = a2.b.a.a.a.L("Instance_");
        L.append(this.c.getClass().getSimpleName());
        L.append("-iId(");
        L.append(this.d);
        L.append(")-<W");
        L.append(arrayList2);
        L.append("-R");
        L.append(arrayList);
        L.append(">(");
        L.append(getParamsString());
        L.append(')');
        return L.toString();
    }

    @NotNull
    public final <R, PartialStateSubclassT extends PartialStateT> WriteKeyProperty<R, PartialStateT, PartialStateSubclassT, KMutableProperty0<PartialStateSubclassT>> writeKeyProperty(@NotNull KMutableProperty0<PartialStateSubclassT> kMutableProperty0) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "property");
        return new WriteKeyProperty<>(kMutableProperty0, getKeys());
    }
}
