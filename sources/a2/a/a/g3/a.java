package a2.a.a.g3;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<List<? extends Integer>, Integer> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Integer invoke(List<? extends Integer> list) {
        List<? extends Integer> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "countList");
        return Integer.valueOf(CollectionsKt___CollectionsKt.sumOfInt(list2));
    }
}
