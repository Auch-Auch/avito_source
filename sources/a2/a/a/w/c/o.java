package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<Throwable> {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public o(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.p;
        Intrinsics.checkNotNullExpressionValue(th2, "throwable");
        TypedError convert = typedErrorThrowableConverter.convert(th2);
        this.a.h = new LoadingState.Error(convert);
        BrandspacePresenterImpl brandspacePresenterImpl = this.a;
        brandspacePresenterImpl.i(brandspacePresenterImpl.k.removeFilteredAdverts(this.a.i));
        this.a.d();
    }
}
