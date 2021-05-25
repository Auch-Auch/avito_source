package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.button.Button;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: l  reason: default package */
public final class l<T> implements Observer<Boolean> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public l(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean bool) {
        int i = this.a;
        if (i == 0) {
            Boolean bool2 = bool;
            Button access$getSubmitButton$p = DeliveryCourierOrderUpdateFragment.access$getSubmitButton$p((DeliveryCourierOrderUpdateFragment) this.b);
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            access$getSubmitButton$p.setEnabled(bool2.booleanValue());
        } else if (i == 1) {
            Boolean bool3 = bool;
            Button access$getSubmitButton$p2 = DeliveryCourierOrderUpdateFragment.access$getSubmitButton$p((DeliveryCourierOrderUpdateFragment) this.b);
            Intrinsics.checkNotNullExpressionValue(bool3, "it");
            access$getSubmitButton$p2.setLoading(bool3.booleanValue());
        } else {
            throw null;
        }
    }
}
