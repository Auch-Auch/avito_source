package a2.a.a.s2.e;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.shop.write_seller.WriteSellerPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<SuccessResult> {
    public final /* synthetic */ WriteSellerPresenterImpl a;

    public a(WriteSellerPresenterImpl writeSellerPresenterImpl) {
        this.a = writeSellerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SuccessResult successResult) {
        WriteSellerPresenterImpl.access$onSuccess(this.a);
    }
}
