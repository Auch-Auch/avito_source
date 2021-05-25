package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.remote.model.Brandspace;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Consumer<Brandspace> {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public k(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Brandspace brandspace) {
        Brandspace brandspace2 = brandspace;
        BrandspacePresenterImpl brandspacePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(brandspace2, "loadedBrandspace");
        BrandspacePresenterImpl.access$onBrandspaceLoaded(brandspacePresenterImpl, brandspace2);
    }
}
