package defpackage;

import com.avito.android.cart.summary.konveyor.product.ProductItemViewHolder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: u4  reason: default package */
public final class u4 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u4(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        int i = this.a;
        boolean z = true;
        if (i == 0) {
            if (((ProductItemViewHolder) this.b).A.getValue() != 1) {
                z = false;
            }
            if (z) {
                ProductItemViewHolder.access$animateShowDeleteView((ProductItemViewHolder) this.b);
            }
            ((ProductItemViewHolder) this.b).E.invoke();
            return Boolean.valueOf(z);
        } else if (i == 1) {
            ProductItemViewHolder.access$animateHideDeleteView((ProductItemViewHolder) this.b);
            ((ProductItemViewHolder) this.b).F.invoke();
            return Boolean.FALSE;
        } else {
            throw null;
        }
    }
}
