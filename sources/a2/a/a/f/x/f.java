package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<PersistableSpannedItem> {
    public final /* synthetic */ AdvertDetailsItemsPresenterImpl a;
    public final /* synthetic */ AdvertDetails b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, AdvertDetails advertDetails) {
        super(0);
        this.a = advertDetailsItemsPresenterImpl;
        this.b = advertDetails;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public PersistableSpannedItem invoke() {
        return this.a.U(this.b, false);
    }
}
