package defpackage;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.advert.item.AdvertDetailsFragment;
/* compiled from: java-style lambda group */
/* renamed from: i0  reason: default package */
public final class i0<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public i0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(String str) {
        Context context;
        int i = this.a;
        if (i == 0) {
            ((AdvertDetailsFragment) this.b).getAdvertDetailsCreditInfoPresenter().updateLegalInfoDialog(str);
        } else if (i == 1) {
            String str2 = str;
            if (str2 != null && (context = ((AdvertDetailsFragment) this.b).getContext()) != null) {
                ((AdvertDetailsFragment) this.b).getAdvertDetailsCreditInfoPresenter().openSravni(context, str2);
            }
        } else {
            throw null;
        }
    }
}
