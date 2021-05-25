package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016B4\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0015\u0010\u0017J\u0018\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00000\tH\n¢\u0006\u0004\b\f\u0010\rR4\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00000\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "", ExifInterface.LATITUDE_SOUTH, "oldState", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "component1", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "component2", "()Lkotlin/jvm/functions/Function1;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getBlock", "block", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public class Mutator<S> {
    @NotNull
    public final String a;
    @NotNull
    public final Function1<S, S> b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Mutator(String str, int i, j jVar) {
        this((i & 1) != 0 ? "" : str);
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final Function1<S, S> component2() {
        return getBlock();
    }

    @NotNull
    public final Function1<S, S> getBlock() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @NotNull
    public S invoke(@NotNull S s) {
        Intrinsics.checkNotNullParameter(s, "oldState");
        return s;
    }

    public Mutator(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str.length() == 0 ? getClass().getSimpleName() : str;
        this.b = new Function1<S, S>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v2.Mutator.a
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final S invoke(@NotNull S s) {
                Intrinsics.checkNotNullParameter(s, "p1");
                return (S) ((Mutator) this.receiver).invoke(s);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super S, ? extends S> */
    /* JADX WARN: Multi-variable type inference failed */
    public Mutator(@NotNull String str, @NotNull Function1<? super S, ? extends S> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.a = str;
        this.b = function1;
    }
}
