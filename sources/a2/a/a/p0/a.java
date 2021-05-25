package a2.a.a.p0;

import androidx.lifecycle.Observer;
import com.avito.android.express_cv.ExpressCvActivity;
public final class a<T> implements Observer<Object> {
    public final /* synthetic */ ExpressCvActivity a;

    public a(ExpressCvActivity expressCvActivity) {
        this.a = expressCvActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        if (obj != null) {
            this.a.setResult(-1);
        }
    }
}
