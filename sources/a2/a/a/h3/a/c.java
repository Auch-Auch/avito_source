package a2.a.a.h3.a;

import com.avito.android.remote.model.Action;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ Action b;

    public c(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, Action action) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = action;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        MyAdvertDetailsPresenterImpl.access$withAdvertId(this.a, new b(this));
    }
}
