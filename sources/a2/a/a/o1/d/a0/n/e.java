package a2.a.a.o1.d.a0.n;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<Object[], List<? extends LocalMessage>> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends LocalMessage> apply(Object[] objArr) {
        Object[] objArr2 = objArr;
        Intrinsics.checkNotNullParameter(objArr2, "results");
        ArrayList arrayList = new ArrayList(objArr2.length);
        for (Object obj : objArr2) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.avito.android.remote.model.messenger.message.LocalMessage>");
            arrayList.add((List) obj);
        }
        return t6.n.e.flatten(arrayList);
    }
}
