package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017B4\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u0016\u0010\u0018J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\nH\n¢\u0006\u0004\b\r\u0010\u000eR4\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "", ExifInterface.LATITUDE_SOUTH, "curState", "", "invoke", "(Ljava/lang/Object;)V", "", "component1", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "component2", "()Lkotlin/jvm/functions/Function1;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getBlock", "block", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public class Action<S> {
    @NotNull
    public final String a;
    @NotNull
    public final Function1<S, Unit> b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Action(String str, int i, j jVar) {
        this((i & 1) != 0 ? "" : str);
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final Function1<S, Unit> component2() {
        return getBlock();
    }

    @NotNull
    public final Function1<S, Unit> getBlock() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    public void invoke(@NotNull S s) {
        Intrinsics.checkNotNullParameter(s, "curState");
    }

    public Action(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str.length() == 0 ? getClass().getSimpleName() : str;
        this.b = new Function1<S, Unit>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v2.Action.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "p1");
                ((Action) this.receiver).invoke(obj);
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super S, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public Action(@NotNull String str, @NotNull Function1<? super S, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.a = str;
        this.b = function1;
    }
}
