package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
public final class i<T> implements Observer<Runnable> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public i(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Runnable runnable) {
        Runnable runnable2 = runnable;
        if (runnable2 != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.a, null, 1, null);
            this.a.a.setOnRefreshListener(new h(runnable2));
        }
    }
}
