package kotlin.reflect.jvm.internal.calls;

import a2.b.a.a.a;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b`\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\u00020\u0003J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "M", "", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "checkArguments", "([Ljava/lang/Object;)V", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "getMember", "()Ljava/lang/reflect/Member;", "member", "", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public interface Caller<M extends Member> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        public static <M extends Member> void checkArguments(@NotNull Caller<? extends M> caller, @NotNull Object[] objArr) {
            Intrinsics.checkNotNullParameter(objArr, "args");
            if (CallerKt.getArity(caller) != objArr.length) {
                StringBuilder L = a.L("Callable expects ");
                L.append(CallerKt.getArity(caller));
                L.append(" arguments, but ");
                throw new IllegalArgumentException(a.j(L, objArr.length, " were provided."));
            }
        }
    }

    @Nullable
    Object call(@NotNull Object[] objArr);

    M getMember();

    @NotNull
    List<Type> getParameterTypes();

    @NotNull
    Type getReturnType();
}
