package com.avito.android.messenger.channels.mvi.common.v3;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEntityDeps;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00020\u00070\u0006B'\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00028\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000f\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\u00028\u00028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/EventCommand;", "", "EventT", "PartialStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "DepsT", "Lkotlin/Function0;", "", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getTypeObj", "()Ljava/lang/Object;", "typeObj", "c", "Ljava/lang/String;", "paramsString", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "d", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "getDeps", "()Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "deps", "<init>", "(Ljava/lang/Object;JLjava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class EventCommand<EventT, PartialStateT, DepsT extends BaseEntityDeps<PartialStateT>> implements Function0<Unit> {
    @NotNull
    public final EventT a;
    public final long b;
    public final String c;
    @NotNull
    public final DepsT d;

    public EventCommand(@NotNull EventT eventt, long j, @NotNull String str, @NotNull DepsT depst) {
        Intrinsics.checkNotNullParameter(eventt, "typeObj");
        Intrinsics.checkNotNullParameter(str, "paramsString");
        Intrinsics.checkNotNullParameter(depst, "deps");
        this.a = eventt;
        this.b = j;
        this.c = str;
        this.d = depst;
    }

    @NotNull
    public final DepsT getDeps() {
        return this.d;
    }

    public final long getId() {
        return this.b;
    }

    @NotNull
    public final EventT getTypeObj() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Command_");
        L.append(this.a.getClass().getSimpleName());
        L.append("-iId(");
        L.append(this.b);
        L.append(")-(");
        return a.s(L, this.c, ')');
    }
}
