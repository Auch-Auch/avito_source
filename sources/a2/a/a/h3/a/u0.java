package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class u0<T> implements Consumer<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ String b;

    public u0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.D.setPrimaryClip(this.a.E.plainText(this.b));
        MyAdvertDetailsView myAdvertDetailsView = this.a.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.showAddressCopied();
        }
    }
}
