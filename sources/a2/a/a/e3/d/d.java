package a2.a.a.e3.d;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.tariff.edit_info.EditInfoFragment;
public final class d<T> implements Observer<DeepLink> {
    public final /* synthetic */ EditInfoFragment a;

    public d(EditInfoFragment editInfoFragment) {
        this.a = editInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null) {
            EditInfoFragment.access$resolveDeeplink(this.a, deepLink2);
        }
    }
}
