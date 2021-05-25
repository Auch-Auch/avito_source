package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class m<T, R> implements Function<List<? extends String>, ObservableSource<? extends Unit>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl.s a;
    public final /* synthetic */ Boolean b;

    public m(FavoriteAdvertsListInteractorImpl.s sVar, Boolean bool) {
        this.a = sVar;
        this.b = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Unit> apply(List<? extends String> list) {
        Observable<R> observable;
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "inactiveIds");
        Boolean bool = this.b;
        Intrinsics.checkNotNullExpressionValue(bool, "isLogged");
        if (bool.booleanValue()) {
            observable = InteropKt.toV2(this.a.a.c.removeInactiveFavorites()).map(k.a);
        } else {
            observable = FavoriteAdvertsListInteractorImpl.access$removeAdverts(this.a.a, list2);
        }
        return observable.doOnNext(new l(this, list2));
    }
}
