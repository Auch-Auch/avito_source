package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
public final class e<T> implements Observer<String> {
    public final /* synthetic */ TariffCountFragment a;

    public e(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            Views.showSnackBar$default(TariffCountFragment.access$getContentView$p(this.a), str2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
        }
    }
}
