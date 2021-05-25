package a2.a.a.o.b;

import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.remote.model.AutotekaItemResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.TypedResultException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<TypedResult<AutotekaItemResponse>, ObservableSource<? extends AutotekaDetailsResponse>> {
    public final /* synthetic */ AutotekaDetailsInteractorImpl a;

    public a(AutotekaDetailsInteractorImpl autotekaDetailsInteractorImpl) {
        this.a = autotekaDetailsInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends AutotekaDetailsResponse> apply(TypedResult<AutotekaItemResponse> typedResult) {
        TypedResult<AutotekaItemResponse> typedResult2 = typedResult;
        Intrinsics.checkNotNullParameter(typedResult2, "it");
        if (typedResult2 instanceof TypedResult.OfResult) {
            AutotekaItemResponse autotekaItemResponse = (AutotekaItemResponse) ((TypedResult.OfResult) typedResult2).getResult();
            this.a.c = Boolean.valueOf(autotekaItemResponse.getReportAvailable());
            if (!autotekaItemResponse.getReportAvailable()) {
                return Observable.error(this.a.a);
            }
            AutotekaDetailsResponse report = autotekaItemResponse.getReport();
            Intrinsics.checkNotNull(report);
            return Observable.just(report);
        } else if (typedResult2 instanceof TypedResult.OfError) {
            return Observable.error(new TypedResultException(((TypedResult.OfError) typedResult2).getError()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
