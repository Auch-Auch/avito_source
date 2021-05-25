package defpackage;

import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: r3  reason: default package */
public final class r3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public r3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            AdvertCoreView advertCoreView = ((AdvertContactsPresenterImpl) this.b).f;
            if (advertCoreView != null) {
                advertCoreView.dismissProgress();
            }
        } else if (i == 1) {
            AdvertCoreView advertCoreView2 = ((AdvertContactsPresenterImpl) this.b).f;
            if (advertCoreView2 != null) {
                advertCoreView2.dismissProgress();
            }
        } else {
            throw null;
        }
    }
}
