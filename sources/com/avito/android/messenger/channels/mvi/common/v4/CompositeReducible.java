package com.avito.android.messenger.channels.mvi.common.v4;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0012\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\u001a\b\u0002\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00120\u0011¢\u0006\u0004\b\"\u0010#J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rH\n¢\u0006\u0004\b\u0010\u0010\u000fJ\"\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00120\u0011H\n¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR4\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00120\u00118\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010!\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u000f¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lio/reactivex/functions/Consumer;", "reducerStream", "", "sendToReducer", "(Lio/reactivex/functions/Consumer;)V", "oldState", "Lio/reactivex/Single;", "execute", "(Ljava/lang/Object;)Lio/reactivex/Single;", "", "toString", "()Ljava/lang/String;", "component1", "Lkotlin/Function0;", "", "component2", "()Lkotlin/jvm/functions/Function0;", "c", "Ljava/lang/String;", "getParams", "params", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "getBlock", "getBlock$annotations", "()V", "block", AuthSource.BOOKING_ORDER, "getName", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public class CompositeReducible<S> implements Reducible<S> {
    @NotNull
    public final Function0<List<Reducible<S>>> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    public static final class a extends Lambda implements Function0<List<? extends MutatorSingle<S>>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return d.listOf(new MutatorSingle(null, null, 3, null));
        }
    }

    public CompositeReducible() {
        this(null, null, null, 7, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.List<? extends com.avito.android.messenger.channels.mvi.common.v4.Reducible<S>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompositeReducible(@NotNull String str, @NotNull String str2, @NotNull Function0<? extends List<? extends Reducible<S>>> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "params");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.b = str;
        this.c = str2;
        this.a = function0;
    }

    public static /* synthetic */ void getBlock$annotations() {
    }

    @NotNull
    public final String component1() {
        return toString();
    }

    @NotNull
    public final Function0<List<Reducible<S>>> component2() {
        return getBlock();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.Reducible
    @NotNull
    public final Single<S> execute(@NotNull S s) {
        Intrinsics.checkNotNullParameter(s, "oldState");
        Logs.error$default("BaseMviEntityWithReducerQueue", this + ": CompositeReducible can't be executed directly!", null, 4, null);
        return Singles.toSingle(s);
    }

    @NotNull
    public Function0<List<Reducible<S>>> getBlock() {
        return this.a;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    @NotNull
    public final String getParams() {
        return this.c;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.Reducible
    public final void sendToReducer(@NotNull Consumer<Reducible<S>> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "reducerStream");
        Iterator<T> it = getBlock().invoke().iterator();
        while (it.hasNext()) {
            it.next().sendToReducer(consumer);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('(');
        return a2.b.a.a.a.s(sb, this.c, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositeReducible(String str, String str2, Function0 function0, int i, j jVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? a.a : function0);
    }
}
