package a2.a.a.e2.w;

import com.avito.android.items.BasicInputItem;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<BasicInputItem, String> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public String apply(BasicInputItem basicInputItem) {
        BasicInputItem basicInputItem2 = basicInputItem;
        Intrinsics.checkNotNullParameter(basicInputItem2, "it");
        return basicInputItem2.getValue();
    }
}
