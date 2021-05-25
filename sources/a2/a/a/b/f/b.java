package a2.a.a.b.f;

import com.avito.android.authorization.login_suggests.Suggest;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Throwable, List<? extends Suggest>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Suggest> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
