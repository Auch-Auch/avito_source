package a2.a.a.k0.a.b;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestActivityKt;
import kotlin.jvm.internal.Intrinsics;
public final class r implements Toolbar.OnMenuItemClickListener {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public r(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        AvitoMapBounds visibleRegion;
        Intrinsics.checkNotNullExpressionValue(menuItem, "it");
        if (menuItem.getItemId() != R.id.menu_find_location || (visibleRegion = DeliveryRdsStartOrderingFragment.access$getMapView$p(this.a).getVisibleRegion()) == null) {
            return false;
        }
        DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment = this.a;
        Context requireContext = deliveryRdsStartOrderingFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        deliveryRdsStartOrderingFragment.startActivityForResult(DeliveryLocationSuggestActivityKt.createDeliveryLocationSuggestIntent(requireContext, visibleRegion), 1);
        return true;
    }
}
