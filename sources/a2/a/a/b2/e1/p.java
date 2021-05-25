package a2.a.a.b2.e1;

import com.avito.android.profile.edit.LocationInteractorImpl;
import com.avito.android.remote.model.Sublocation;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class p<T, R> implements Function<List<? extends Sublocation>, Unit> {
    public final /* synthetic */ LocationInteractorImpl a;
    public final /* synthetic */ Sublocation.Type b;
    public final /* synthetic */ String c;

    public p(LocationInteractorImpl locationInteractorImpl, Sublocation.Type type, String str) {
        this.a = locationInteractorImpl;
        this.b = type;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Unit apply(List<? extends Sublocation> list) {
        List<? extends Sublocation> list2 = list;
        LocationInteractorImpl locationInteractorImpl = this.a;
        Sublocation.Type type = this.b;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        LocationInteractorImpl.access$setSublocation(locationInteractorImpl, type, list2, this.c);
        return Unit.INSTANCE;
    }
}
