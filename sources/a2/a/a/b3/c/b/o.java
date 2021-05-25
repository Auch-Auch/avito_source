package a2.a.a.b3.c.b;

import androidx.core.view.ViewCompat;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<Boolean> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public o(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "keyboardVisible");
        if (bool2.booleanValue()) {
            ViewCompat.animate(this.a.c).alpha(0.0f).setDuration(200).withEndAction(new l0(0, this)).start();
        } else {
            ViewCompat.animate(this.a.c).withStartAction(new l0(1, this)).alpha(1.0f).setDuration(200).start();
        }
    }
}
