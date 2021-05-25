package com.avito.android.messenger.channels.mvi.common.v4;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#BD\b\u0016\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012%\u0010\u001e\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0013¢\u0006\u0004\b\"\u0010$J\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fH\n¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0016\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0013H\n¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R8\u0010\u001e\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u0011¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "curState", "Lio/reactivex/Single;", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "Lio/reactivex/functions/Consumer;", "reducerStream", "", "sendToReducer", "(Lio/reactivex/functions/Consumer;)V", "oldState", "execute", "", "toString", "()Ljava/lang/String;", "component1", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "component2", "()Lkotlin/jvm/functions/Function1;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getBlock", "block", "c", "getParams", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public class ActionSingle<S> implements Reducible<S> {
    @NotNull
    public final String a;
    @NotNull
    public final Function1<S, Single<?>> b;
    @NotNull
    public final String c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionSingle(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @NotNull
    public final String component1() {
        return toString();
    }

    @NotNull
    public final Function1<S, Single<?>> component2() {
        return getBlock();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.Reducible
    @NotNull
    public final Single<S> execute(@NotNull S s) {
        Intrinsics.checkNotNullParameter(s, "oldState");
        return ReducibleKt.toMutatorSingle(this).getBlock().invoke(s);
    }

    @NotNull
    public final Function1<S, Single<?>> getBlock() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @NotNull
    public final String getParams() {
        return this.c;
    }

    @NotNull
    public Single<?> invoke(@NotNull S s) {
        Intrinsics.checkNotNullParameter(s, "curState");
        return Singles.toSingle(Unit.INSTANCE);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.Reducible
    public final void sendToReducer(@NotNull Consumer<Reducible<S>> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "reducerStream");
        consumer.accept(this);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('(');
        return a2.b.a.a.a.s(sb, this.c, ')');
    }

    public ActionSingle(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "params");
        if (str.length() == 0) {
            str = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "javaClass.simpleName");
        }
        this.a = str;
        this.c = str2;
        this.b = new Function1<S, Single<?>>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v4.ActionSingle.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public Single<?> invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "p1");
                return ((ActionSingle) this.receiver).invoke(obj);
            }
        };
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionSingle(String str, String str2, Function1 function1, int i, j jVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super S, ? extends io.reactivex.Single<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionSingle(@NotNull String str, @NotNull String str2, @NotNull Function1<? super S, ? extends Single<?>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "params");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (str.length() == 0) {
            str = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "javaClass.simpleName");
        }
        this.a = str;
        this.c = str2;
        this.b = function1;
    }
}
