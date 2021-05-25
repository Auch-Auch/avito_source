package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import com.avito.android.user_adverts_common.safety.events.FraudWindowModalShowEvent;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class q0<T> implements Consumer<DetailsSheetLinkBody> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ String b;

    public q0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DetailsSheetLinkBody detailsSheetLinkBody) {
        DetailsSheetLinkBody detailsSheetLinkBody2 = detailsSheetLinkBody;
        MyAdvertDetailsView myAdvertDetailsView = this.a.b;
        if (myAdvertDetailsView != null) {
            Intrinsics.checkNotNullExpressionValue(detailsSheetLinkBody2, "it");
            MyAdvertDetailsView.DefaultImpls.showInfoBanner$default(myAdvertDetailsView, detailsSheetLinkBody2, null, 2, null);
        }
        this.a.C.track(new FraudWindowModalShowEvent(this.b));
    }
}
