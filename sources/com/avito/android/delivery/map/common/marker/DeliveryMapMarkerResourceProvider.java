package com.avito.android.delivery.map.common.marker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.map.MapMarkerResourceProvider;
import com.avito.android.util.map.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerResourceProvider;", "Lcom/avito/android/util/map/MapMarkerResourceProvider;", "", AuthSource.BOOKING_ORDER, "I", "getPinIconResId", "()I", "pinIconResId", "c", "getPinSelectedIconResId", "pinSelectedIconResId", "getClusterIconResId", "clusterIconResId", AuthSource.SEND_ABUSE, "getUserIconResId", "userIconResId", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMapMarkerResourceProvider implements MapMarkerResourceProvider {
    public final int a = R.drawable.ic_explore_item_map_my_pin_red;
    public final int b = R.drawable.ic_map_pin;
    public final int c = R.drawable.ic_map_marker_selected;

    @Override // com.avito.android.util.map.MapMarkerResourceProvider
    public int getClusterIconResId() {
        throw new UnsupportedOperationException("Cluster icon not implemented yet");
    }

    @Override // com.avito.android.util.map.MapMarkerResourceProvider
    public int getPinIconResId() {
        return this.b;
    }

    @Override // com.avito.android.util.map.MapMarkerResourceProvider
    public int getPinSelectedIconResId() {
        return this.c;
    }

    @Override // com.avito.android.util.map.MapMarkerResourceProvider
    public int getUserIconResId() {
        return this.a;
    }
}
