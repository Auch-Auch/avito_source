package a2.a.a.h3.a;

import android.view.View;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.RejectReason;
import com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl;
public final class a1 implements View.OnClickListener {
    public final /* synthetic */ Action a;
    public final /* synthetic */ View b;
    public final /* synthetic */ MyAdvertDetailsViewImpl c;

    public a1(Action action, View view, MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, String str, RejectReason rejectReason) {
        this.a = action;
        this.b = view;
        this.c = myAdvertDetailsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OnDeepLinkClickListener onDeepLinkClickListener = this.c.W;
        if (onDeepLinkClickListener != null) {
            onDeepLinkClickListener.onDeepLinkClick(this.a.getDeepLink());
        }
    }
}
