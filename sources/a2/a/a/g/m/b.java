package a2.a.a.g.m;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlock;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
public final class b<T> implements Observer<AdvertStrBlock> {
    public final /* synthetic */ AdvertStrBlockViewImpl a;

    public b(AdvertStrBlockViewImpl advertStrBlockViewImpl) {
        this.a = advertStrBlockViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AdvertStrBlock advertStrBlock) {
        AdvertStrBlock advertStrBlock2 = advertStrBlock;
        if (advertStrBlock2 != null) {
            AdvertStrBlockViewImpl.access$bindStrBlock(this.a, advertStrBlock2);
        }
    }
}
