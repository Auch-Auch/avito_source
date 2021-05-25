package a2.a.a.g.m;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.SnackBarListener;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ AdvertStrBlockViewImpl a;

    public c(AdvertStrBlockViewImpl advertStrBlockViewImpl) {
        this.a = advertStrBlockViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            AdvertStrBlockViewImpl advertStrBlockViewImpl = this.a;
            AdvertStrBlockViewImpl.access$setToggleValue(advertStrBlockViewImpl, !advertStrBlockViewImpl.isChecked());
            SnackBarListener.DefaultImpls.showSnackBar$default(this.a.d, str2, -1, 0, null, null, true, 28, null);
        }
    }
}
