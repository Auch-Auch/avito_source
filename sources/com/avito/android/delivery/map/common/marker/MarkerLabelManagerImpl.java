package com.avito.android.delivery.map.common.marker;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.delivery.R;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012¨\u0006\""}, d2 = {"Lcom/avito/android/delivery/map/common/marker/MarkerLabelManagerImpl;", "Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "projection", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "", "", "getLabels", "(Lcom/avito/android/avito_map/AvitoMapBounds;Ljava/util/List;)Ljava/util/Set;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "helper", "", "setMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "", AuthSource.BOOKING_ORDER, "I", "pinLabelHeight", "", "Landroid/graphics/Rect;", "c", "Ljava/util/List;", "placedLabels", "d", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapHelper", AuthSource.SEND_ABUSE, "pinLabelWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerLabelManagerImpl implements MarkerLabelManager {
    public final int a;
    public final int b;
    public final List<Rect> c = new ArrayList();
    public AvitoMapAttachHelper d;

    @Inject
    public MarkerLabelManagerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.map_pin_with_label, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.label);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(R.string.delivery_map_marker_template);
        inflate.measure(0, 0);
        this.a = inflate.getMeasuredWidth();
        this.b = inflate.getMeasuredHeight();
    }

    @Override // com.avito.android.delivery.map.common.marker.MarkerLabelManager
    @NotNull
    public Set<String> getLabels(@Nullable AvitoMapBounds avitoMapBounds, @NotNull List<? extends Marker> list) {
        String str;
        Point screenLocation;
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        if (avitoMapBounds == null) {
            return y.emptySet();
        }
        this.c.clear();
        ArrayList<Pair> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            AvitoMapPoint latLng = next.getLatLng();
            if (avitoMapBounds.contains(latLng)) {
                AvitoMapAttachHelper avitoMapAttachHelper = this.d;
                AvitoMap map = avitoMapAttachHelper != null ? avitoMapAttachHelper.getMap() : null;
                if (!(map == null || (screenLocation = map.toScreenLocation(latLng)) == null)) {
                    pair = new Pair(next.getId(), screenLocation);
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair2 : arrayList) {
            Point point = (Point) pair2.getSecond();
            int i = point.x;
            int i2 = this.a / 2;
            int i3 = point.y;
            int i4 = this.b / 2;
            Rect rect = new Rect(i - i2, i3 - i4, i2 + i, i4 + i3);
            List<Rect> list2 = this.c;
            boolean z = true;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!(!Rect.intersects(it2.next(), rect))) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                this.c.add(rect);
                str = (String) pair2.getFirst();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    @Override // com.avito.android.delivery.map.common.marker.MarkerLabelManager
    public void setMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper) {
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "helper");
        this.d = avitoMapAttachHelper;
    }
}
