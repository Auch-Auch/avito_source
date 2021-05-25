package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j0<T> implements Consumer<Boolean> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    public j0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        MyAdvertDetailsView myAdvertDetailsView;
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "shouldShowAppRater");
        if (bool2.booleanValue() && (myAdvertDetailsView = this.a.b) != null) {
            myAdvertDetailsView.showAppRater();
        }
    }
}
