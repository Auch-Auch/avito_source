package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.remote.model.section.SectionResponse;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<SectionResponse> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;

    public h(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        this.a = advertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SectionResponse sectionResponse) {
        this.a.S.trackComplementaryLoaded();
    }
}
