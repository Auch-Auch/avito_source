package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import io.reactivex.rxjava3.functions.Action;
public final class m implements Action {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public m(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.e = null;
    }
}
