package a2.a.a.g.l;

import com.avito.android.remote.model.MyAdvertSafeDeal;
import io.reactivex.functions.Predicate;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Predicate<Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ d b;

    public b(String str, MyAdvertSafeDeal.Service service, d dVar, Set set) {
        this.a = str;
        this.b = dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return !this.b.a.c.contains(this.a);
    }
}
