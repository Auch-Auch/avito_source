package a2.a.a.k0.e.i0;

import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<ParametersTree, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ DeliveryRdsContactsFieldsInteractorImpl a;

    public a(DeliveryRdsContactsFieldsInteractorImpl deliveryRdsContactsFieldsInteractorImpl) {
        this.a = deliveryRdsContactsFieldsInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends PretendResult> apply(ParametersTree parametersTree) {
        ParametersTree parametersTree2 = parametersTree;
        LocalPretendInteractor localPretendInteractor = this.a.b;
        Intrinsics.checkNotNullExpressionValue(parametersTree2, "it");
        return localPretendInteractor.pretend(parametersTree2);
    }
}
