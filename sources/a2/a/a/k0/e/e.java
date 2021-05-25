package a2.a.a.k0.e;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.SummaryState;
import com.avito.android.delivery.summary.DeliveryRdsSummaryActivityKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<Unit> {
    public final /* synthetic */ DeliveryRdsSummaryFragment a;
    public final /* synthetic */ DeliveryRdsSummaryViewModel b;

    public e(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
        this.a = deliveryRdsSummaryFragment;
        this.b = deliveryRdsSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        SummaryState checkoutSummary = this.b.checkoutSummary();
        if (checkoutSummary == null || !checkoutSummary.getSkipMap()) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.setResult(-1, new Intent().putExtra(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE, this.b.checkoutSummary()));
            }
            FragmentActivity activity2 = this.a.getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        DeliveryRdsSummaryFragment deliveryRdsSummaryFragment = this.a;
        ActivityIntentFactory intentFactory = deliveryRdsSummaryFragment.getIntentFactory();
        String advertId = checkoutSummary.getAdvertId();
        String str = this.a.h;
        String str2 = this.a.e;
        boolean z = this.a.g;
        boolean z2 = this.a.f;
        String fiasGuid = checkoutSummary.getFiasGuid();
        Intrinsics.checkNotNull(fiasGuid);
        deliveryRdsSummaryFragment.startActivityForResult(intentFactory.deliveryRdsStartOrderingIntentWithPin(advertId, str, str2, z, z2, null, null, null, null, fiasGuid, CollectionsKt__CollectionsKt.listOfNotNull(checkoutSummary.getServiceId()), true, null), 2);
    }
}
