package a2.a.a.t1.a;

import android.os.Parcelable;
import com.avito.android.payment.caching_interactor.SingleResultCachingInteractor;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<TypedResult<T>> {
    public final /* synthetic */ SingleResultCachingInteractor a;

    public c(SingleResultCachingInteractor singleResultCachingInteractor) {
        this.a = singleResultCachingInteractor;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        TypedResult typedResult = (TypedResult) obj;
        if (typedResult instanceof TypedResult.OfResult) {
            this.a.a = (Parcelable) ((TypedResult.OfResult) typedResult).getResult();
        }
    }
}
