package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<List<? extends String>, ObservableSource<? extends Unit>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl.q a;
    public final /* synthetic */ Boolean b;

    public f(FavoriteAdvertsListInteractorImpl.q qVar, Boolean bool) {
        this.a = qVar;
        this.b = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Unit> apply(List<? extends String> list) {
        Observable<R> observable;
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "ids");
        Boolean bool = this.b;
        Intrinsics.checkNotNullExpressionValue(bool, "isLogged");
        if (bool.booleanValue()) {
            observable = InteropKt.toV2(this.a.a.c.clearFavorites()).flatMap(new d(this));
        } else {
            observable = FavoriteAdvertsListInteractorImpl.access$wipeLocalAdverts(this.a.a);
        }
        return observable.doOnNext(new e(this, list2));
    }
}
