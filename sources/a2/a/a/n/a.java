package a2.a.a.n;

import androidx.lifecycle.Observer;
import com.avito.android.autodeal_details.AutoDealDetailsActivity;
public final class a<T> implements Observer<String> {
    public final /* synthetic */ AutoDealDetailsActivity a;

    public a(AutoDealDetailsActivity autoDealDetailsActivity) {
        this.a = autoDealDetailsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            this.a.a().loadUrl(str2);
        }
    }
}
