package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Consumer<Throwable> {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public l(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        BrandspacePresenterImpl brandspacePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "throwable");
        BrandspacePresenterImpl.access$onBrandspaceLoadError(brandspacePresenterImpl, th2);
    }
}
