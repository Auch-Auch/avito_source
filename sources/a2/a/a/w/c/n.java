package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceAdverts;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilder;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.remote.model.Brandspace;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Consumer<BrandspaceAdverts> {
    public final /* synthetic */ BrandspacePresenterImpl a;
    public final /* synthetic */ Brandspace b;

    public n(BrandspacePresenterImpl brandspacePresenterImpl, Brandspace brandspace) {
        this.a = brandspacePresenterImpl;
        this.b = brandspace;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(BrandspaceAdverts brandspaceAdverts) {
        BrandspaceAdverts brandspaceAdverts2 = brandspaceAdverts;
        this.a.h = new LoadingState.Loaded(brandspaceAdverts2);
        BrandspacePresenterImpl brandspacePresenterImpl = this.a;
        BrandspaceItemBuilder brandspaceItemBuilder = brandspacePresenterImpl.k;
        Brandspace brandspace = this.b;
        List<? extends BrandspaceItem> list = this.a.i;
        Intrinsics.checkNotNullExpressionValue(brandspaceAdverts2, "brandspaceAdverts");
        brandspacePresenterImpl.i(brandspaceItemBuilder.addFilteredAdverts(brandspace, list, brandspaceAdverts2));
        this.a.d();
    }
}
