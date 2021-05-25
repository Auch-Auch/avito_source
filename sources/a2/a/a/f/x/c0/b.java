package a2.a.a.f.x.c0;

import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert.item.spare_parts.SparePartsPresenterImpl;
import com.avito.android.remote.models.SparePartsResponse;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<SparePartsResponse.SparePartsGroup> {
    public final /* synthetic */ SparePartsPresenterImpl a;

    public b(SparePartsPresenterImpl sparePartsPresenterImpl) {
        this.a = sparePartsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SparePartsResponse.SparePartsGroup sparePartsGroup) {
        SparePartsResponse.SparePartsGroup sparePartsGroup2 = sparePartsGroup;
        SparePartsPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(sparePartsGroup2, "it");
            router.openSparePartsBottomSheet(sparePartsGroup2);
        }
    }
}
