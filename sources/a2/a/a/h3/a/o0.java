package a2.a.a.h3.a;

import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o0<T> implements Consumer<LimitsInfo> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    public o0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LimitsInfo limitsInfo) {
        LimitsInfo limitsInfo2 = limitsInfo;
        MyAdvertDetailsView myAdvertDetailsView = this.a.b;
        if (myAdvertDetailsView != null) {
            Intrinsics.checkNotNullExpressionValue(limitsInfo2, "it");
            myAdvertDetailsView.showLimitsInfoDialog(limitsInfo2);
        }
    }
}
