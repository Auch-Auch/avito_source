package arrow.syntax.collections;

import arrow.core.Option;
import arrow.core.OptionKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\b¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"", "Larrow/core/Option;", "", "firstOption", "(Ljava/lang/String;)Larrow/core/Option;", "Lkotlin/Function1;", "", "Larrow/core/Predicate;", "predicate", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class StringKt {
    @NotNull
    public static final Option<Character> firstOption(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        return OptionKt.toOption(StringsKt___StringsKt.firstOrNull(str));
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Character ch;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                ch = null;
                break;
            }
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                ch = Character.valueOf(charAt);
                break;
            }
            i++;
        }
        return OptionKt.toOption(ch);
    }
}
