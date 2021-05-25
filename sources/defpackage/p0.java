package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
import com.avito.android.component.switch_list_element.SwitchListElement;
/* compiled from: java-style lambda group */
/* renamed from: p0  reason: default package */
public final class p0<T> implements Observer<Boolean> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public p0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean bool) {
        int i = this.a;
        if (i == 0) {
            Boolean bool2 = bool;
            if (bool2 != null) {
                SwitchListElement.DefaultImpls.setChecked$default((AdvertStrBlockViewImpl) this.b, bool2.booleanValue(), false, 2, null);
            }
        } else if (i == 1) {
            Boolean bool3 = bool;
            if (bool3 != null) {
                ((AdvertStrBlockViewImpl) this.b).setEnabled(bool3.booleanValue());
            }
        } else {
            throw null;
        }
    }
}
