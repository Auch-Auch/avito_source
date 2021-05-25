package defpackage;

import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.util.AvitoSnackbar;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: y2  reason: default package */
public final class y2<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public y2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(String str) {
        View view;
        int i = this.a;
        if (i == 0) {
            String str2 = str;
            if (str2 != null && (view = ((DeliveryRdsStartOrderingFragment) this.b).getView()) != null) {
                Intrinsics.checkNotNullExpressionValue(view, "this.view ?: return@Observer");
                AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, view, str2, 0, null, 0, null, null, 0, 0, 0, 1016, null).show();
            }
        } else if (i == 1) {
            String str3 = str;
            DeliveryMapViewModel mapViewModel = ((DeliveryRdsStartOrderingFragment) this.b).getMapViewModel();
            Intrinsics.checkNotNullExpressionValue(str3, "markerId");
            DeliveryMapViewModel.DefaultImpls.onMarkerClick$default(mapViewModel, str3, null, null, 4, null);
        } else {
            throw null;
        }
    }
}
