package arrow.core;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001b\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001aM\u0010\b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00070\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001aR\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0004¢\u0006\u0004\b\f\u0010\r\u001aR\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007H\u0004¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "identity", "(Ljava/lang/Object;)Ljava/lang/Object;", "B", "Z", "Lkotlin/Function2;", "Lkotlin/Function1;", "curry", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "C", "f", "compose", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", g.a, "andThen", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class PredefKt {

    public static final class a extends Lambda implements Function1<A, C> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1, Function1 function12) {
            super(1);
            this.a = function1;
            this.b = function12;
        }

        @Override // kotlin.jvm.functions.Function1
        public final C invoke(A a3) {
            return (C) this.b.invoke(this.a.invoke(a3));
        }
    }

    public static final class b extends Lambda implements Function1<A, C> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1, Function1 function12) {
            super(1);
            this.a = function1;
            this.b = function12;
        }

        @Override // kotlin.jvm.functions.Function1
        public final C invoke(A a3) {
            return (C) this.a.invoke(this.b.invoke(a3));
        }
    }

    public static final class c extends Lambda implements Function1<A, Function1<? super B, ? extends Z>> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function2 function2) {
            super(1);
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return new n6.a.g(this, obj);
        }
    }

    @NotNull
    public static final <A, B, C> Function1<A, C> andThen(@NotNull Function1<? super A, ? extends B> function1, @NotNull Function1<? super B, ? extends C> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, g.a);
        return new a(function1, function12);
    }

    @NotNull
    public static final <A, B, C> Function1<A, C> compose(@NotNull Function1<? super B, ? extends C> function1, @NotNull Function1<? super A, ? extends B> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new b(function1, function12);
    }

    @NotNull
    public static final <A, B, Z> Function1<A, Function1<B, Z>> curry(@NotNull Function2<? super A, ? super B, ? extends Z> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        return new c(function2);
    }

    public static final <A> A identity(A a3) {
        return a3;
    }
}
