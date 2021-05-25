package a2.a.a.i2.a.a;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.PublishIntentFactory;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryCourierLocationSelectLink;
import com.avito.android.deep_linking.links.DeliveryCourierTimeIntervalSelectLink;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectActivityKt;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<ParameterElement.SelectDeepLink> {
    public final /* synthetic */ DeliveryCourierOrderUpdateFragment a;

    public a(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        this.a = deliveryCourierOrderUpdateFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ParameterElement.SelectDeepLink selectDeepLink) {
        int i;
        Intent intent;
        DeepLink createFromUri = this.a.getDeepLinkFactory().createFromUri(selectDeepLink.getDeepLinkUrl());
        boolean z = createFromUri instanceof DeliveryCourierLocationSelectLink;
        if (z) {
            i = 10;
        } else if (createFromUri instanceof DeliveryCourierTimeIntervalSelectLink) {
            i = 11;
        } else {
            return;
        }
        Intent intent2 = null;
        if (z) {
            intent2 = PublishIntentFactory.DefaultImpls.locationPickerIntent$default(this.a.getActivityIntentFactory(), this.a.getViewModel().getSelectedAddress(), null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, null, null, 238, null);
        } else if ((createFromUri instanceof DeliveryCourierTimeIntervalSelectLink) && (intent = this.a.getDeepLinkIntentFactory().getIntent(createFromUri)) != null) {
            intent.putExtra(DeliveryCourierTimeIntervalSelectActivityKt.EXTRA_SELECTED, this.a.getViewModel().getSelectedTimeInterval());
            intent2 = intent;
        }
        if (intent2 == null) {
            View requireView = this.a.requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
            Views.showSnackBar$default(requireView, this.a.getResourceProvider().getSelectDeeplinkError(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            this.a.getTracker().trackSelectDeepLinkError();
            return;
        }
        this.a.startActivityForResult(intent2, i);
    }
}
