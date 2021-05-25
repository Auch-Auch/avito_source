package a2.a.a.b3.c.b;

import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractorImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<ParametersTree, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

    public c(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
        this.a = sellerCalendarParametersInteractorImpl;
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
