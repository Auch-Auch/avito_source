package a2.a.a.s2.d.a;

import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.shop.list.business.ShopListInfo;
import com.avito.android.shop.list.business.ShopListInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Throwable, LoadingState<? super ShopListInfo>> {
    public final /* synthetic */ ShopListInteractorImpl a;

    public b(ShopListInteractorImpl shopListInteractorImpl) {
        this.a = shopListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super ShopListInfo> apply(Throwable th) {
        Throwable th2 = th;
        ShopListInteractorImpl shopListInteractorImpl = this.a;
        TypedErrorThrowableConverter typedErrorThrowableConverter = shopListInteractorImpl.m;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        shopListInteractorImpl.f = typedErrorThrowableConverter.convert(th2);
        TypedError typedError = this.a.f;
        Intrinsics.checkNotNull(typedError);
        return new LoadingState.Error(typedError);
    }
}
