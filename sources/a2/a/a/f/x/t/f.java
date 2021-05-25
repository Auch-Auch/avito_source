package a2.a.a.f.x.t;

import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<DfpCreditInfo> {
    public final /* synthetic */ DfpCreditViewModel a;

    public f(DfpCreditViewModel dfpCreditViewModel) {
        this.a = dfpCreditViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DfpCreditInfo dfpCreditInfo) {
        DfpCreditInfo dfpCreditInfo2 = dfpCreditInfo;
        this.a.g = false;
        this.a.c.setValue(dfpCreditInfo2);
        DfpCreditViewModel dfpCreditViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(dfpCreditInfo2, "it");
        DfpCreditViewModel.access$trackCalculatorRender(dfpCreditViewModel, dfpCreditInfo2);
    }
}
