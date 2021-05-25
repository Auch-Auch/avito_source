package a2.a.a.d2.c;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsContainerView;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ SubscriptionsPresenterImpl a;

    public i(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
        this.a = subscriptionsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        SubscriptionsContainerView subscriptionsContainerView = this.a.a;
        if (subscriptionsContainerView != null) {
            subscriptionsContainerView.showContent();
        }
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.a.u;
        ErrorHelper errorHelper = this.a.p;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(compositeSnackbarPresenter, errorHelper.recycle(th2), 0, null, 0, null, 0, null, null, 254, null);
    }
}
