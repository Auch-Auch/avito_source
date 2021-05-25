package com.avito.android.messenger.map.viewing.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMarkerOptions;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterManager;
import com.avito.android.avito_map.clustering.view.DefaultClusterRenderer;
import com.avito.android.messenger.R;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020$\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&¢\u0006\u0004\b(\u0010)J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u00020\u00178B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/PinRenderer;", "Lcom/avito/android/avito_map/clustering/view/DefaultClusterRenderer;", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "item", "Lcom/avito/android/avito_map/AvitoMapMarkerOptions;", "markerOptions", "", "onBeforeClusterItemRendered", "(Lcom/avito/android/messenger/map/viewing/view/Pin;Lcom/avito/android/avito_map/AvitoMapMarkerOptions;)V", "clusterItem", "Lcom/avito/android/avito_map/AvitoMapMarker;", "marker", "onClusterItemRendered", "(Lcom/avito/android/messenger/map/viewing/view/Pin;Lcom/avito/android/avito_map/AvitoMapMarker;)V", "Lcom/avito/android/avito_map/clustering/Cluster;", "cluster", "", "shouldRenderAsCluster", "(Lcom/avito/android/avito_map/clustering/Cluster;)Z", "", "clusterSize", "getColor", "(I)I", "Landroid/graphics/Bitmap;", "r", "Lkotlin/Lazy;", "getSelectedPinIcon", "()Landroid/graphics/Bitmap;", "selectedPinIcon", VKApiConst.Q, "getRegularPinIcon", "regularPinIcon", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/avito_map/AvitoMap;", "map", "Lcom/avito/android/avito_map/clustering/ClusterManager;", "clusterManager", "<init>", "(Landroid/content/Context;Lcom/avito/android/avito_map/AvitoMap;Lcom/avito/android/avito_map/clustering/ClusterManager;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PinRenderer extends DefaultClusterRenderer<Pin> {
    public final Lazy q = c.lazy(new a(0, this));
    public final Lazy r = c.lazy(new a(1, this));
    public final Context s;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Bitmap> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Bitmap invoke() {
            int i = this.a;
            if (i == 0) {
                PinRenderer pinRenderer = (PinRenderer) this.b;
                int i2 = R.drawable.ic_messenger_map_blue_pin;
                Drawable drawable = pinRenderer.s.getResources().getDrawable(i2, pinRenderer.s.getTheme());
                if (drawable != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                    Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
                    return createBitmap;
                }
                throw new IllegalStateException(("PinRenderer.getBitmapDescriptor(resId = " + i2 + ") error - couldn't get drawable").toString());
            } else if (i == 1) {
                PinRenderer pinRenderer2 = (PinRenderer) this.b;
                int i3 = R.drawable.ic_messenger_map_red_pin;
                Drawable drawable2 = pinRenderer2.s.getResources().getDrawable(i3, pinRenderer2.s.getTheme());
                if (drawable2 != null) {
                    Bitmap createBitmap2 = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap2);
                    drawable2.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
                    drawable2.draw(canvas2);
                    Intrinsics.checkNotNullExpressionValue(createBitmap2, "bitmap");
                    return createBitmap2;
                }
                throw new IllegalStateException(("PinRenderer.getBitmapDescriptor(resId = " + i3 + ") error - couldn't get drawable").toString());
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PinRenderer(@NotNull Context context, @NotNull AvitoMap avitoMap, @NotNull ClusterManager<Pin> clusterManager) {
        super(context, avitoMap, clusterManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        Intrinsics.checkNotNullParameter(clusterManager, "clusterManager");
        this.s = context;
    }

    public static final Bitmap access$getBitmap(PinRenderer pinRenderer, int i) {
        Objects.requireNonNull(pinRenderer);
        Drawable drawable = pinRenderer.s.getResources().getDrawable(i, pinRenderer.s.getTheme());
        if (drawable != null) {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
            return createBitmap;
        }
        throw new IllegalStateException(a2.b.a.a.a.Q2("PinRenderer.getBitmapDescriptor(resId = ", i, ") error - couldn't get drawable").toString());
    }

    public static final Bitmap access$getRegularPinIcon$p(PinRenderer pinRenderer) {
        return (Bitmap) pinRenderer.q.getValue();
    }

    public static final Bitmap access$getSelectedPinIcon$p(PinRenderer pinRenderer) {
        return (Bitmap) pinRenderer.r.getValue();
    }

    @Override // com.avito.android.avito_map.clustering.view.DefaultClusterRenderer
    public int getColor(int i) {
        return ResourcesCompat.getColor(this.s.getResources(), R.color.messenger_map_cluster_pin_color, null);
    }

    @Override // com.avito.android.avito_map.clustering.view.DefaultClusterRenderer
    public boolean shouldRenderAsCluster(@Nullable Cluster<Pin> cluster) {
        return cluster != null && cluster.getSize() > 1;
    }

    public void onBeforeClusterItemRendered(@Nullable Pin pin, @Nullable AvitoMapMarkerOptions avitoMapMarkerOptions) {
        if (pin != null && avitoMapMarkerOptions != null) {
            avitoMapMarkerOptions.setIcon(pin.isSelected() ? access$getSelectedPinIcon$p(this) : access$getRegularPinIcon$p(this));
        }
    }

    public void onClusterItemRendered(@Nullable Pin pin, @Nullable AvitoMapMarker avitoMapMarker) {
        if (pin != null && avitoMapMarker != null) {
            Bitmap access$getSelectedPinIcon$p = pin.isSelected() ? access$getSelectedPinIcon$p(this) : access$getRegularPinIcon$p(this);
            avitoMapMarker.changeIcon(access$getSelectedPinIcon$p, pin.getId() + pin.isSelected(), 0.0f, AvitoMapMarker.Anchor.BOTTOM_CENTER);
        }
    }
}
