package a2.a.a.o3;

import com.avito.android.validation.ValidationResult;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<List<? extends ValidationResult>, Unit> {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(List<? extends ValidationResult> list) {
        List<? extends ValidationResult> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            this.a.a.d(it.next());
        }
        return Unit.INSTANCE;
    }
}
