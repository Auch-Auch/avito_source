package defpackage;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import java.util.Objects;
/* compiled from: java-style lambda group */
/* renamed from: e2  reason: default package */
public final class e2<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public e2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(String str) {
        int i = this.a;
        if (i == 0) {
            String str2 = str;
            if (str2 != null) {
                View findViewById = DeliveryCourierOrderUpdateFragment.access$getToolbar$p((DeliveryCourierOrderUpdateFragment) this.b).findViewById(R.id.toolbar_title);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) findViewById).setText(str2);
            }
        } else if (i == 1) {
            String str3 = str;
            if (str3 != null) {
                DeliveryCourierOrderUpdateFragment.access$getSubmitButton$p((DeliveryCourierOrderUpdateFragment) this.b).setText(str3);
            }
        } else if (i == 2) {
            String str4 = str;
            if (str4 != null) {
                DeliveryCourierOrderUpdateFragment.access$getCancelButton$p((DeliveryCourierOrderUpdateFragment) this.b).setText(str4);
            }
        } else {
            throw null;
        }
    }
}
