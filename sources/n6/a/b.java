package n6.a;

import arrow.core.Eval;
import arrow.core.Some;
import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
public final class b extends Lambda implements Function1<Eval.Memoize<Object>, Function1<? super Object, ? extends Eval<? extends Object>>> {
    public final /* synthetic */ Eval.Companion a;

    public static final class a extends Lambda implements Function1<Object, Eval.Now<? extends Object>> {
        public final /* synthetic */ b a;
        public final /* synthetic */ Eval.Memoize b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, Eval.Memoize memoize) {
            super(1);
            this.a = bVar;
            this.b = memoize;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Eval.Now<? extends Object> invoke(Object obj) {
            this.b.setResult(new Some(obj));
            return this.a.a.now(obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Eval.Companion companion) {
        super(1);
        this.a = companion;
    }

    @NotNull
    /* renamed from: a */
    public final Function1<Object, Eval<Object>> invoke(@NotNull Eval.Memoize<Object> memoize) {
        Intrinsics.checkParameterIsNotNull(memoize, AuthSource.OPEN_CHANNEL_LIST);
        return new a(this, memoize);
    }
}
