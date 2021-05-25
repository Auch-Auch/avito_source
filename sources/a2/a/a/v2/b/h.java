package a2.a.a.v2.b;

import com.avito.android.short_term_rent.hotels.HotelsView;
import com.avito.android.short_term_rent.hotels.HotelsViewModel;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ HotelsViewModel a;

    public h(HotelsViewModel hotelsViewModel) {
        this.a = hotelsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        HotelsView hotelsView = this.a.c;
        if (hotelsView != null) {
            hotelsView.stopLoading();
        }
        HotelsView hotelsView2 = this.a.c;
        if (hotelsView2 != null) {
            HotelsView.DefaultImpls.showErrorInSnackBar$default(hotelsView2, null, 1, null);
        }
    }
}
