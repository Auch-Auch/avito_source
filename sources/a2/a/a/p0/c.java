package a2.a.a.p0;

import androidx.lifecycle.Observer;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.util.Views;
public final class c<T> implements Observer<Boolean> {
    public final /* synthetic */ ExpressCvActivity a;

    public c(ExpressCvActivity expressCvActivity) {
        this.a = expressCvActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            Views.setVisible(ExpressCvActivity.access$getTabLayout$p(this.a), bool2.booleanValue());
        }
    }
}
