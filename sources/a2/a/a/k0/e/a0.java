package a2.a.a.k0.e;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T> implements Consumer<Boolean> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public a0(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        MutableLiveData<Float> disabledImageAlphaChanges = this.a.getDisabledImageAlphaChanges();
        Intrinsics.checkNotNullExpressionValue(bool2, "success");
        disabledImageAlphaChanges.setValue(Float.valueOf(bool2.booleanValue() ? 0.4f : 1.0f));
    }
}
