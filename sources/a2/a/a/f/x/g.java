package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Triple;
public final class g<T> implements Consumer<Triple<? extends LoadingState<? super Object>, ? extends SectionResponse, ? extends List<? extends PositionedBannerContainer>>> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;

    public g(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        this.a = advertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Triple<? extends LoadingState<? super Object>, ? extends SectionResponse, ? extends List<? extends PositionedBannerContainer>> triple) {
        Triple<? extends LoadingState<? super Object>, ? extends SectionResponse, ? extends List<? extends PositionedBannerContainer>> triple2 = triple;
        LoadingState loadingState = (LoadingState) triple2.component1();
        SectionResponse sectionResponse = (SectionResponse) triple2.component2();
        List<PositionedBannerContainer> list = (List) triple2.component3();
        if (this.a.q != null) {
            List<SectionTypeElement> sections = sectionResponse.getSections();
            if (loadingState instanceof LoadingState.Loaded) {
                if (!sections.isEmpty()) {
                    this.a.S.startComplementaryPrepare();
                }
                this.a.z.setComplementaryItems(sections, list, sectionResponse.getExpandButton());
                this.a.b();
            } else if (loadingState instanceof LoadingState.Error) {
                this.a.S.startComplementaryPrepare();
                this.a.S.trackComplementaryErrorPrepare();
                this.a.S.trackComplementaryErrorDraw();
            }
        }
        this.a.e = null;
    }
}
