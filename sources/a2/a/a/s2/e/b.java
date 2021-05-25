package a2.a.a.s2.e;

import com.avito.android.shop.write_seller.WriteSellerPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ WriteSellerPresenterImpl a;

    public b(WriteSellerPresenterImpl writeSellerPresenterImpl) {
        this.a = writeSellerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        WriteSellerPresenterImpl writeSellerPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        WriteSellerPresenterImpl.access$onError(writeSellerPresenterImpl, th2);
    }
}
