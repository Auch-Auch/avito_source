package a2.a.a.i2.a.b;

import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.PublishIntentFactory;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeliveryCourierLocationSelectLink;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<ParameterElement.SelectDeepLink> {
    public final /* synthetic */ DeliveryCourierSummaryFragment a;
    public final /* synthetic */ DeliveryCourierSummaryViewModel b;

    public b(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        this.a = deliveryCourierSummaryFragment;
        this.b = deliveryCourierSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ParameterElement.SelectDeepLink selectDeepLink) {
        boolean z = this.a.getDeepLinkFactory().createFromUri(selectDeepLink.getDeepLinkUrl()) instanceof DeliveryCourierLocationSelectLink;
        if (!z) {
            return;
        }
        if (z) {
            this.a.startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(this.a.getIntentFactory(), this.b.getSelectedAddress(), null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, null, null, 238, null), 2);
            return;
        }
        View requireView = this.a.requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        Views.showSnackBar$default(requireView, this.a.getResourceProvider().getSelectDeeplinkError(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
