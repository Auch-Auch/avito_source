package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aM\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001aM\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a_\u0010\r\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0002*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a_\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0002* \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"P1", "P2", "R", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lkotlin/Pair;", "paired", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "unpaired", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "P3", "Lkotlin/Function3;", "Lkotlin/Triple;", "tripled", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function1;", "untripled", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function3;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class PairingKt {

    public static final class a extends Lambda implements Function1<Pair<? extends P1, ? extends P2>, R> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function2 function2) {
            super(1);
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkParameterIsNotNull(pair, "pair");
            return this.a.invoke(pair.component1(), pair.component2());
        }
    }

    public static final class b extends Lambda implements Function1<Triple<? extends P1, ? extends P2, ? extends P3>, R> {
        public final /* synthetic */ Function3 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function3 function3) {
            super(1);
            this.a = function3;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Triple triple = (Triple) obj;
            Intrinsics.checkParameterIsNotNull(triple, "triple");
            return this.a.invoke(triple.component1(), triple.component2(), triple.component3());
        }
    }

    public static final class c extends Lambda implements Function2<P1, P2, R> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function1 function1) {
            super(2);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final R invoke(P1 p1, P2 p2) {
            return (R) this.a.invoke(TuplesKt.to(p1, p2));
        }
    }

    public static final class d extends Lambda implements Function3<P1, P2, P3, R> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function1 function1) {
            super(3);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public final R invoke(P1 p1, P2 p2, P3 p3) {
            return (R) this.a.invoke(new Triple(p1, p2, p3));
        }
    }

    @NotNull
    public static final <P1, P2, R> Function1<Pair<? extends P1, ? extends P2>, R> paired(@NotNull Function2<? super P1, ? super P2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        return new a(function2);
    }

    @NotNull
    public static final <P1, P2, P3, R> Function1<Triple<? extends P1, ? extends P2, ? extends P3>, R> tripled(@NotNull Function3<? super P1, ? super P2, ? super P3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "$receiver");
        return new b(function3);
    }

    @NotNull
    public static final <P1, P2, R> Function2<P1, P2, R> unpaired(@NotNull Function1<? super Pair<? extends P1, ? extends P2>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new c(function1);
    }

    @NotNull
    public static final <P1, P2, P3, R> Function3<P1, P2, P3, R> untripled(@NotNull Function1<? super Triple<? extends P1, ? extends P2, ? extends P3>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new d(function1);
    }
}
