package com.avito.android.delivery.map.common.marker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManagerImpl;", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "", "lat", "", "zoom", "getClusterRadius", "(DF)Ljava/lang/Float;", "Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "calculator", "", AuthSource.SEND_ABUSE, "I", "clusterMarkerRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ClusterMarkerManagerImpl implements ClusterMarkerManager {
    public final int a;
    public final ClusterRadiusCalculator b;

    @Inject
    public ClusterMarkerManagerImpl(@NotNull Context context, @NotNull ClusterRadiusCalculator clusterRadiusCalculator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clusterRadiusCalculator, "calculator");
        this.b = clusterRadiusCalculator;
        View inflate = LayoutInflater.from(context).inflate(R.layout.map_cluster, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        View findViewById = inflate.findViewById(R.id.text_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(MarkersKt.STUB_CLUSTER_TEXT);
        inflate.measure(0, 0);
        this.a = Contexts.pxToDp(context, inflate.getMeasuredHeight() / 2);
    }

    @Override // com.avito.android.delivery.map.common.marker.ClusterMarkerManager
    @Nullable
    public Float getClusterRadius(double d, float f) {
        return this.b.calculate(this.a, d, f);
    }
}
