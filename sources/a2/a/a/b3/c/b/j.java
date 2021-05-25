package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
public final class j<T> implements Observer<String> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public j(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            Views.showSnackBar$default(this.a.l, str2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }
}
