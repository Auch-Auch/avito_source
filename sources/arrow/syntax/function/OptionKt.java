package arrow.syntax.function;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"P1", "R", "Lkotlin/Function1;", "Larrow/core/Option;", "optionLift", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class OptionKt {

    public static final class a extends Lambda implements Function1<Option<? extends P1>, Option<? extends R>> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkParameterIsNotNull(option, "it");
            Function1 function1 = this.a;
            if (option instanceof None) {
                return None.INSTANCE;
            }
            if (option instanceof Some) {
                return new Some(function1.invoke(((Some) option).getT()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final <P1, R> Function1<Option<? extends P1>, Option<R>> optionLift(@NotNull Function1<? super P1, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new a(function1);
    }
}
