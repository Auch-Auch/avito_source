package com.avito.android.delivery.summary;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewImpl;
import com.avito.android.image_loader.SimpleImageRequestListener;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n¸\u0006\u000b"}, d2 = {"com/avito/android/delivery/summary/DeliveryRdsSummaryViewImpl$bindTo$2$1$1$listener$1", "Lcom/avito/android/image_loader/SimpleImageRequestListener;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "onLoaded", "(II)V", "onFailed", "()V", "delivery_release", "com/avito/android/delivery/summary/DeliveryRdsSummaryViewImpl$bindTo$2$$special$$inlined$with$lambda$1"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryViewImpl$bindTo$2$$special$$inlined$with$lambda$5 extends SimpleImageRequestListener {
    public final /* synthetic */ DeliveryRdsSummaryViewImpl.d a;

    public DeliveryRdsSummaryViewImpl$bindTo$2$$special$$inlined$with$lambda$5(DeliveryRdsSummaryViewImpl.d dVar, DeliverySummaryRds.Header header) {
        this.a = dVar;
    }

    @Override // com.avito.android.image_loader.SimpleImageRequestListener, com.avito.android.image_loader.ImageRequestListener
    public void onFailed() {
        this.a.b.getImageLoadedSuccessfullyConsumer().accept(Boolean.FALSE);
    }

    @Override // com.avito.android.image_loader.SimpleImageRequestListener, com.avito.android.image_loader.ImageRequestListener
    public void onLoaded(int i, int i2) {
        this.a.b.getImageLoadedSuccessfullyConsumer().accept(Boolean.TRUE);
    }
}
