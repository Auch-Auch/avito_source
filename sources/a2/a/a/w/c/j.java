package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class j implements Action {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public j(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        LoadingState loadingState = null;
        this.a.c = null;
        BrandspacePresenterImpl brandspacePresenterImpl = this.a;
        LoadingState loadingState2 = brandspacePresenterImpl.g;
        if (!Intrinsics.areEqual(loadingState2, LoadingState.Loading.INSTANCE)) {
            loadingState = loadingState2;
        }
        brandspacePresenterImpl.g = loadingState;
    }
}
