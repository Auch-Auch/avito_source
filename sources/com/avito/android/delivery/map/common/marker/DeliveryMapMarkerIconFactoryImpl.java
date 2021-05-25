package com.avito.android.delivery.map.common.marker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.map.MapMarkerIconFactoryKt;
import com.avito.android.util.map.MapMarkerResourceProvider;
import com.avito.android.util.map.MarkerItem;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003$\t\fB\u0017\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\u00020\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl;", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "Lcom/avito/android/util/map/MarkerItem;", "markerItem", "Landroid/graphics/Bitmap;", "getIcon", "(Lcom/avito/android/util/map/MarkerItem;)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "drawable", AuthSource.SEND_ABUSE, "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$a;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getClusterWithLabelView", "()Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$a;", "clusterWithLabelView", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$ClusterView;", "c", "getClusterView", "()Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$ClusterView;", "clusterView", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$b;", "getPinWithLabelView", "()Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$b;", "pinWithLabelView", "Lcom/avito/android/util/map/MapMarkerResourceProvider;", "e", "Lcom/avito/android/util/map/MapMarkerResourceProvider;", "resourceProvider", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/view/LayoutInflater;Lcom/avito/android/util/map/MapMarkerResourceProvider;)V", "ClusterView", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMapMarkerIconFactoryImpl implements DeliveryMapMarkerIconFactory {
    public final Lazy a = t6.c.lazy(new e(this));
    public final Lazy b = t6.c.lazy(new d(this));
    public final Lazy c = t6.c.lazy(new c(this));
    public final LayoutInflater d;
    public final MapMarkerResourceProvider e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactoryImpl$ClusterView;", "", "", "text", "", "setText", "(Ljava/lang/String;)V", "", "textLength", "setTextViewPadding", "(I)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/view/View;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static class ClusterView {
        public final TextView a;
        @NotNull
        public final View b;

        public ClusterView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = view;
            View findViewById = view.findViewById(R.id.text_view);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.a = (TextView) findViewById;
        }

        @NotNull
        public final View getView() {
            return this.b;
        }

        public final void setText(@Nullable String str) {
            TextViews.bindText$default(this.a, str, false, 2, null);
        }

        public final void setTextViewPadding(int i) {
            int i2;
            Resources resources = this.b.getResources();
            if (i == 1) {
                i2 = R.dimen.rds_delivery_6dp;
            } else if (i == 2) {
                i2 = R.dimen.rds_delivery_10dp;
            } else if (i == 3) {
                i2 = R.dimen.rds_delivery_14dp;
            } else if (i != 4) {
                i2 = R.dimen.rds_delivery_21dp;
            } else {
                i2 = R.dimen.rds_delivery_18dp;
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(i2);
            TextView textView = this.a;
            textView.setPadding(textView.getPaddingLeft(), dimensionPixelSize, this.a.getPaddingRight(), dimensionPixelSize);
        }
    }

    public static final class a extends ClusterView {
        public final TextView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.label);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.label)");
            this.c = (TextView) findViewById;
        }
    }

    public static final class b {
        public final ImageView a;
        public final TextView b;
        @NotNull
        public final View c;

        public b(@NotNull View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.c = view;
            View findViewById = view.findViewById(R.id.marker);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.marker)");
            ImageView imageView = (ImageView) findViewById;
            this.a = imageView;
            View findViewById2 = view.findViewById(R.id.label);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.label)");
            this.b = (TextView) findViewById2;
            imageView.setImageResource(i);
        }
    }

    public static final class c extends Lambda implements Function0<ClusterView> {
        public final /* synthetic */ DeliveryMapMarkerIconFactoryImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl) {
            super(0);
            this.a = deliveryMapMarkerIconFactoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ClusterView invoke() {
            DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl = this.a;
            return new ClusterView(DeliveryMapMarkerIconFactoryImpl.access$inflateView(deliveryMapMarkerIconFactoryImpl, deliveryMapMarkerIconFactoryImpl.d, R.layout.map_cluster));
        }
    }

    public static final class d extends Lambda implements Function0<a> {
        public final /* synthetic */ DeliveryMapMarkerIconFactoryImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl) {
            super(0);
            this.a = deliveryMapMarkerIconFactoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public a invoke() {
            DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl = this.a;
            return new a(DeliveryMapMarkerIconFactoryImpl.access$inflateView(deliveryMapMarkerIconFactoryImpl, deliveryMapMarkerIconFactoryImpl.d, R.layout.map_cluster_with_label));
        }
    }

    public static final class e extends Lambda implements Function0<b> {
        public final /* synthetic */ DeliveryMapMarkerIconFactoryImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl) {
            super(0);
            this.a = deliveryMapMarkerIconFactoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public b invoke() {
            DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl = this.a;
            return new b(DeliveryMapMarkerIconFactoryImpl.access$inflateView(deliveryMapMarkerIconFactoryImpl, deliveryMapMarkerIconFactoryImpl.d, R.layout.map_pin_with_label), this.a.e.getPinIconResId());
        }
    }

    public DeliveryMapMarkerIconFactoryImpl(@NotNull LayoutInflater layoutInflater, @NotNull MapMarkerResourceProvider mapMarkerResourceProvider) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(mapMarkerResourceProvider, "resourceProvider");
        this.d = layoutInflater;
        this.e = mapMarkerResourceProvider;
    }

    public static final View access$inflateView(DeliveryMapMarkerIconFactoryImpl deliveryMapMarkerIconFactoryImpl, LayoutInflater layoutInflater, int i) {
        Objects.requireNonNull(deliveryMapMarkerIconFactoryImpl);
        View inflate = layoutInflater.inflate(i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return inflate;
    }

    public final Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory
    @Nullable
    public Bitmap getIcon(@NotNull MarkerItem markerItem) {
        Intrinsics.checkNotNullParameter(markerItem, "markerItem");
        if (markerItem instanceof MarkerItem.MyLocation) {
            return a(this.d.getContext().getDrawable(this.e.getUserIconResId()));
        }
        if (markerItem instanceof MarkerItem.Pin) {
            if (((MarkerItem.Pin) markerItem).getSelected()) {
                return a(this.d.getContext().getDrawable(this.e.getPinSelectedIconResId()));
            }
            return a(this.d.getContext().getDrawable(this.e.getPinIconResId()));
        } else if (markerItem instanceof MarkerItem.PinWithLabel) {
            b bVar = (b) this.a.getValue();
            TextViews.bindText$default(bVar.b, ((MarkerItem.PinWithLabel) markerItem).getLabelText(), false, 2, null);
            return MapMarkerIconFactoryKt.toBitmap(bVar.c);
        } else if (markerItem instanceof MarkerItem.Cluster) {
            MarkerItem.Cluster cluster = (MarkerItem.Cluster) markerItem;
            ClusterView clusterView = (ClusterView) this.c.getValue();
            clusterView.setText(cluster.getText());
            clusterView.setTextViewPadding(cluster.getText().length());
            return MapMarkerIconFactoryKt.toBitmap(clusterView.getView());
        } else if (markerItem instanceof MarkerItem.ClusterWithLabel) {
            MarkerItem.ClusterWithLabel clusterWithLabel = (MarkerItem.ClusterWithLabel) markerItem;
            a aVar = (a) this.b.getValue();
            aVar.setText(clusterWithLabel.getText());
            TextViews.bindText$default(aVar.c, clusterWithLabel.getLabelText(), false, 2, null);
            aVar.setTextViewPadding(clusterWithLabel.getText().length());
            return MapMarkerIconFactoryKt.toBitmap(aVar.getView());
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
