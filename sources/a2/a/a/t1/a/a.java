package a2.a.a.t1.a;

import com.avito.android.payment.caching_interactor.SealedResultCachingInteractor;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<TypedResult<T>> {
    public final /* synthetic */ SealedResultCachingInteractor a;

    public a(SealedResultCachingInteractor sealedResultCachingInteractor) {
        this.a = sealedResultCachingInteractor;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        TypedResult typedResult = (TypedResult) obj;
        if (typedResult instanceof TypedResult.OfResult) {
            this.a.a = ((TypedResult.OfResult) typedResult).getResult();
        }
    }
}
