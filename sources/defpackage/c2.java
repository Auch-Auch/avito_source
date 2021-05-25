package defpackage;

import com.avito.android.public_profile.ui.SubscribeButtonsView;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: c2  reason: default package */
public final class c2 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public c2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            ((SubscribeButtonsView) this.b).setNotificationLoading(false);
        } else if (i == 1) {
            ((SubscribeButtonsView) this.b).setNotificationLoading(false);
        } else {
            throw null;
        }
    }
}
