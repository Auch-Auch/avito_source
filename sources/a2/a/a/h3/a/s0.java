package a2.a.a.h3.a;

import com.avito.android.remote.model.Coordinates;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Unit;
public final class s0<T> implements Consumer<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Coordinates c;
    public final /* synthetic */ String d;
    public final /* synthetic */ List e;

    public s0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, Coordinates coordinates, String str2, List list) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = str;
        this.c = coordinates;
        this.d = str2;
        this.e = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        MyAdvertRouter myAdvertRouter = this.a.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.showAddressOnMap(this.b, this.c, this.d, this.e);
        }
    }
}
