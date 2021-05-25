package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class v<T, R> implements Function<Unit, ObservableSource<? extends Unit>> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ String b;

    public v(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Unit> apply(Unit unit) {
        return this.a.y.deleteAdvert(this.b).observeOn(this.a.u.mainThread()).doOnNext(new t(this)).map(u.a);
    }
}
