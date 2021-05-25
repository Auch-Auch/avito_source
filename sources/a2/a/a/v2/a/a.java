package a2.a.a.v2.a;

import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractorImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<ParametersTree, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ StrConfirmBookingInteractorImpl a;

    public a(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl) {
        this.a = strConfirmBookingInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PretendResult> apply(ParametersTree parametersTree) {
        ParametersTree parametersTree2 = parametersTree;
        Intrinsics.checkNotNullParameter(parametersTree2, "it");
        return InteropKt.toV2(this.a.d.pretend(parametersTree2));
    }
}
