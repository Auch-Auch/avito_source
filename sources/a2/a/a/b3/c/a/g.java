package a2.a.a.b3.c.a;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
public final class g<T> implements Observer<Boolean> {
    public final /* synthetic */ SellerCalendarViewImpl a;

    public g(SellerCalendarViewImpl sellerCalendarViewImpl) {
        this.a = sellerCalendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            ViewGroup viewGroup = this.a.j;
            TransitionDsl transitionDsl = new TransitionDsl(new Fade());
            transitionDsl.addTarget(this.a.d);
            transitionDsl.addTarget(this.a.f);
            TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
            if (bool2.booleanValue()) {
                Views.hide(this.a.d);
                Views.show(this.a.f);
                return;
            }
            Views.hide(this.a.f);
            Views.show(this.a.d);
        }
    }
}
