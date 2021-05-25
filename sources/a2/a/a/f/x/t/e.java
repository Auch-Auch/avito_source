package a2.a.a.f.x.t;

import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ DfpCreditViewModel a;

    public e(DfpCreditViewModel dfpCreditViewModel) {
        this.a = dfpCreditViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.g = false;
        this.a.c.setValue(new DfpCreditInfo.Empty());
        Logs.debug$default("Failed to load dfp credit", null, 2, null);
    }
}
