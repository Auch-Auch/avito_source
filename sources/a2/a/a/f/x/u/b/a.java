package a2.a.a.f.x.u.b;

import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenterImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.ApartmentNumberRequestLink;
import com.avito.android.remote.ApartmentNumberRequestResponse;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<ApartmentNumberRequestResponse> {
    public final /* synthetic */ AdvertDetailsDomotekaTeaserPresenterImpl a;

    public a(AdvertDetailsDomotekaTeaserPresenterImpl advertDetailsDomotekaTeaserPresenterImpl) {
        this.a = advertDetailsDomotekaTeaserPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(ApartmentNumberRequestResponse apartmentNumberRequestResponse) {
        DeepLink link;
        AdvertDetailsDomotekaTeaserPresenter.Router router;
        ApartmentNumberRequestLink result = apartmentNumberRequestResponse.getResult();
        if (result != null && (link = result.getLink()) != null && (router = this.a.getRouter()) != null) {
            router.followDomotekaOpenChatDeeplink(link);
        }
    }
}
