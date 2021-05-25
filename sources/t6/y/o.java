package t6.y;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
public final class o extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(List list, boolean z) {
        super(2);
        this.a = list;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        CharSequence charSequence2 = charSequence;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(charSequence2, "$receiver");
        Pair pair = StringsKt__StringsKt.b(charSequence2, this.a, intValue, this.b, false);
        if (pair != null) {
            return TuplesKt.to(pair.getFirst(), Integer.valueOf(((String) pair.getSecond()).length()));
        }
        return null;
    }
}
