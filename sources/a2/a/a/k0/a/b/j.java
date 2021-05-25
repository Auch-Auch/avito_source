package a2.a.a.k0.a.b;

import android.graphics.Point;
import android.view.View;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<String> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;
    public final /* synthetic */ DeliveryMapView b;

    public j(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryMapView deliveryMapView) {
        this.a = deliveryRdsStartOrderingFragment;
        this.b = deliveryMapView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        View view = this.a.getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view ?: return@subscribe");
            AvitoMapPoint center = this.b.getCenter();
            if (center != null) {
                int mapViewHeight = this.b.getMapViewHeight() - DeliveryRdsStartOrderingFragment.access$getPointInfoView$p(this.a).getBottomSheetPeekHeight();
                AvitoMapPoint fromScreenLocation = this.b.fromScreenLocation(new Point(view.getWidth() / 2, mapViewHeight / 2));
                if (fromScreenLocation != null) {
                    DeliveryMapViewModel mapViewModel = this.a.getMapViewModel();
                    Intrinsics.checkNotNullExpressionValue(str2, "markerId");
                    DeliveryMapViewModel.DefaultImpls.onMarkerClick$default(mapViewModel, str2, Double.valueOf(fromScreenLocation.getLatitude() - center.getLatitude()), null, 4, null);
                }
            }
        }
    }
}
