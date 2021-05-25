package a2.a.a.v2.a;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewImpl;
public final class e<T> implements Observer<Runnable> {
    public final /* synthetic */ StrConfirmBookingViewImpl a;

    public e(StrConfirmBookingViewImpl strConfirmBookingViewImpl) {
        this.a = strConfirmBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Runnable runnable) {
        Runnable runnable2 = runnable;
        if (runnable2 != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.e, null, 1, null);
            this.a.e.setOnRefreshListener(new d(runnable2));
        }
    }
}
