package a2.a.a.n2;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.serp.SerpElementResultWithPageParams;
import com.avito.android.serp.SerpInteractorImpl;
import com.avito.android.serp.SerpPageParams;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<TypedResult<SerpElementResult>, ObservableSource<? extends SerpElementResultWithPageParams>> {
    public final /* synthetic */ SerpInteractorImpl a;
    public final /* synthetic */ SerpPageParams b;

    public k(SerpInteractorImpl serpInteractorImpl, SerpPageParams serpPageParams) {
        this.a = serpInteractorImpl;
        this.b = serpPageParams;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends SerpElementResultWithPageParams> apply(TypedResult<SerpElementResult> typedResult) {
        Observable observable;
        TypedResult<SerpElementResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            observable = Observable.just(((TypedResult.OfResult) typedResult2).getResult());
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        } else if (typedResult2 instanceof TypedResult.OfError) {
            TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
            ErrorResult error = ofError.getError();
            if (error instanceof ErrorResult.NetworkIOError) {
                observable = Observable.error(new IOException(ofError.getError().getMessage()));
            } else if (error instanceof ErrorResult.Unauthorized) {
                observable = Observable.error(new UnauthorizedException(new Throwable(ofError.getError().getMessage())));
            } else {
                observable = Observable.error(new RuntimeException(ofError.getError().getMessage()));
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return observable.map(new j(this));
    }
}
