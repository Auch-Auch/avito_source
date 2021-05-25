package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.BasketActivity;
import com.avito.android.basket_legacy.utils.BasketStep;
public final class a<T> implements Observer<BasketStep> {
    public final /* synthetic */ BasketActivity a;

    public a(BasketActivity basketActivity) {
        this.a = basketActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(BasketStep basketStep) {
        BasketStep basketStep2 = basketStep;
        if (basketStep2 == null) {
            return;
        }
        if (basketStep2 instanceof BasketStep.PackageChoice) {
            this.a.o = true;
            BasketActivity basketActivity = this.a;
            BasketStep.PackageChoice packageChoice = (BasketStep.PackageChoice) basketStep2;
            BasketActivity.access$openFees(basketActivity, BasketActivity.access$getAdvertId$p(basketActivity), packageChoice.getPackages(), packageChoice.getMessage());
        } else if (basketStep2 instanceof BasketStep.VasChoice) {
            BasketActivity.access$openVas(this.a, (BasketStep.VasChoice) basketStep2);
        } else if (basketStep2 instanceof BasketStep.Checkout) {
            BasketActivity.access$openBasket(this.a);
        } else if (basketStep2 instanceof BasketStep.LfSingleChoice) {
            BasketActivity basketActivity2 = this.a;
            BasketStep.LfSingleChoice lfSingleChoice = (BasketStep.LfSingleChoice) basketStep2;
            BasketActivity.access$openLfSingleFee(basketActivity2, BasketActivity.access$getAdvertId$p(basketActivity2), lfSingleChoice.getSingleFee(), lfSingleChoice.getMessage(), lfSingleChoice.getAction());
        }
    }
}
