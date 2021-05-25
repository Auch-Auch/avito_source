package com.avito.android.delivery.map.common.marker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/Marker;", "", "", "hasLabel", "()Z", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Lcom/avito/android/avito_map/AvitoMapPoint;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "Cluster", "Pin", "User", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "Lcom/avito/android/delivery/map/common/marker/Marker$Cluster;", "Lcom/avito/android/delivery/map/common/marker/Marker$User;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public abstract class Marker {
    @NotNull
    public final String a;
    @NotNull
    public final AvitoMapPoint b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/Marker$Cluster;", "Lcom/avito/android/delivery/map/common/marker/Marker;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "component3", "component4", "id", "latLng", "count", "hint", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/delivery/map/common/marker/Marker$Cluster;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "c", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", g.a, "Ljava/lang/String;", "getHint", "f", "getCount", "d", "getId", "e", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cluster extends Marker {
        @NotNull
        public final AvitoMapMarker.Anchor c = AvitoMapMarker.Anchor.CENTER;
        @NotNull
        public final String d;
        @NotNull
        public final AvitoMapPoint e;
        @NotNull
        public final String f;
        @Nullable
        public final String g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cluster(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull String str2, @Nullable String str3) {
            super(str, avitoMapPoint, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(str2, "count");
            this.d = str;
            this.e = avitoMapPoint;
            this.f = str2;
            this.g = str3;
        }

        public static /* synthetic */ Cluster copy$default(Cluster cluster, String str, AvitoMapPoint avitoMapPoint, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cluster.getId();
            }
            if ((i & 2) != 0) {
                avitoMapPoint = cluster.getLatLng();
            }
            if ((i & 4) != 0) {
                str2 = cluster.f;
            }
            if ((i & 8) != 0) {
                str3 = cluster.g;
            }
            return cluster.copy(str, avitoMapPoint, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final AvitoMapPoint component2() {
            return getLatLng();
        }

        @NotNull
        public final String component3() {
            return this.f;
        }

        @Nullable
        public final String component4() {
            return this.g;
        }

        @NotNull
        public final Cluster copy(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(str2, "count");
            return new Cluster(str, avitoMapPoint, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cluster)) {
                return false;
            }
            Cluster cluster = (Cluster) obj;
            return Intrinsics.areEqual(getId(), cluster.getId()) && Intrinsics.areEqual(getLatLng(), cluster.getLatLng()) && Intrinsics.areEqual(this.f, cluster.f) && Intrinsics.areEqual(this.g, cluster.g);
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapMarker.Anchor getAnchor() {
            return this.c;
        }

        @NotNull
        public final String getCount() {
            return this.f;
        }

        @Nullable
        public final String getHint() {
            return this.g;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public String getId() {
            return this.d;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapPoint getLatLng() {
            return this.e;
        }

        public int hashCode() {
            String id = getId();
            int i = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            AvitoMapPoint latLng = getLatLng();
            int hashCode2 = (hashCode + (latLng != null ? latLng.hashCode() : 0)) * 31;
            String str = this.f;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.g;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Cluster(id=");
            L.append(getId());
            L.append(", latLng=");
            L.append(getLatLng());
            L.append(", count=");
            L.append(this.f);
            L.append(", hint=");
            return a.t(L, this.g, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0007R\u001c\u00106\u001a\u0002018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "Lcom/avito/android/delivery/map/common/marker/Marker;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "component3", "", "component4", "()Ljava/util/List;", "component5", "", "component6", "()Ljava/lang/Float;", "id", "latLng", "fiasGuid", "serviceIds", "hint", "zoomLevel", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;)Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getId", g.a, "Ljava/util/List;", "getServiceIds", "h", "getHint", "i", "Ljava/lang/Float;", "getZoomLevel", "f", "getFiasGuid", "e", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "c", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pin extends Marker {
        @NotNull
        public final AvitoMapMarker.Anchor c;
        @NotNull
        public final String d;
        @NotNull
        public final AvitoMapPoint e;
        @NotNull
        public final String f;
        @NotNull
        public final List<String> g;
        @Nullable
        public final String h;
        @Nullable
        public final Float i;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pin(String str, AvitoMapPoint avitoMapPoint, String str2, List list, String str3, Float f2, int i2, j jVar) {
            this(str, avitoMapPoint, str2, list, str3, (i2 & 32) != 0 ? null : f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.delivery.map.common.marker.Marker$Pin */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Pin copy$default(Pin pin, String str, AvitoMapPoint avitoMapPoint, String str2, List list, String str3, Float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = pin.getId();
            }
            if ((i2 & 2) != 0) {
                avitoMapPoint = pin.getLatLng();
            }
            if ((i2 & 4) != 0) {
                str2 = pin.f;
            }
            if ((i2 & 8) != 0) {
                list = pin.g;
            }
            if ((i2 & 16) != 0) {
                str3 = pin.h;
            }
            if ((i2 & 32) != 0) {
                f2 = pin.i;
            }
            return pin.copy(str, avitoMapPoint, str2, list, str3, f2);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final AvitoMapPoint component2() {
            return getLatLng();
        }

        @NotNull
        public final String component3() {
            return this.f;
        }

        @NotNull
        public final List<String> component4() {
            return this.g;
        }

        @Nullable
        public final String component5() {
            return this.h;
        }

        @Nullable
        public final Float component6() {
            return this.i;
        }

        @NotNull
        public final Pin copy(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull String str2, @NotNull List<String> list, @Nullable String str3, @Nullable Float f2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(str2, "fiasGuid");
            Intrinsics.checkNotNullParameter(list, "serviceIds");
            return new Pin(str, avitoMapPoint, str2, list, str3, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return Intrinsics.areEqual(getId(), pin.getId()) && Intrinsics.areEqual(getLatLng(), pin.getLatLng()) && Intrinsics.areEqual(this.f, pin.f) && Intrinsics.areEqual(this.g, pin.g) && Intrinsics.areEqual(this.h, pin.h) && Intrinsics.areEqual(this.i, pin.i);
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapMarker.Anchor getAnchor() {
            return this.c;
        }

        @NotNull
        public final String getFiasGuid() {
            return this.f;
        }

        @Nullable
        public final String getHint() {
            return this.h;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public String getId() {
            return this.d;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapPoint getLatLng() {
            return this.e;
        }

        @NotNull
        public final List<String> getServiceIds() {
            return this.g;
        }

        @Nullable
        public final Float getZoomLevel() {
            return this.i;
        }

        public int hashCode() {
            String id = getId();
            int i2 = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            AvitoMapPoint latLng = getLatLng();
            int hashCode2 = (hashCode + (latLng != null ? latLng.hashCode() : 0)) * 31;
            String str = this.f;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list = this.g;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            String str2 = this.h;
            int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Float f2 = this.i;
            if (f2 != null) {
                i2 = f2.hashCode();
            }
            return hashCode5 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Pin(id=");
            L.append(getId());
            L.append(", latLng=");
            L.append(getLatLng());
            L.append(", fiasGuid=");
            L.append(this.f);
            L.append(", serviceIds=");
            L.append(this.g);
            L.append(", hint=");
            L.append(this.h);
            L.append(", zoomLevel=");
            L.append(this.i);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Pin(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull String str2, @NotNull List<String> list, @Nullable String str3, @Nullable Float f2) {
            super(str, avitoMapPoint, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(str2, "fiasGuid");
            Intrinsics.checkNotNullParameter(list, "serviceIds");
            this.d = str;
            this.e = avitoMapPoint;
            this.f = str2;
            this.g = list;
            this.h = str3;
            this.i = f2;
            this.c = AvitoMapMarker.Anchor.BOTTOM_CENTER;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/Marker$User;", "Lcom/avito/android/delivery/map/common/marker/Marker;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "id", "latLng", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/delivery/map/common/marker/Marker$User;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "d", "Ljava/lang/String;", "getId", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "c", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class User extends Marker {
        @NotNull
        public final AvitoMapMarker.Anchor c = AvitoMapMarker.Anchor.CENTER;
        @NotNull
        public final String d;
        @NotNull
        public final AvitoMapPoint e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public User(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint) {
            super(str, avitoMapPoint, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            this.d = str;
            this.e = avitoMapPoint;
        }

        public static /* synthetic */ User copy$default(User user, String str, AvitoMapPoint avitoMapPoint, int i, Object obj) {
            if ((i & 1) != 0) {
                str = user.getId();
            }
            if ((i & 2) != 0) {
                avitoMapPoint = user.getLatLng();
            }
            return user.copy(str, avitoMapPoint);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final AvitoMapPoint component2() {
            return getLatLng();
        }

        @NotNull
        public final User copy(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            return new User(str, avitoMapPoint);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            return Intrinsics.areEqual(getId(), user.getId()) && Intrinsics.areEqual(getLatLng(), user.getLatLng());
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapMarker.Anchor getAnchor() {
            return this.c;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public String getId() {
            return this.d;
        }

        @Override // com.avito.android.delivery.map.common.marker.Marker
        @NotNull
        public AvitoMapPoint getLatLng() {
            return this.e;
        }

        public int hashCode() {
            String id = getId();
            int i = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            AvitoMapPoint latLng = getLatLng();
            if (latLng != null) {
                i = latLng.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("User(id=");
            L.append(getId());
            L.append(", latLng=");
            L.append(getLatLng());
            L.append(")");
            return L.toString();
        }
    }

    public Marker(String str, AvitoMapPoint avitoMapPoint, j jVar) {
        this.a = str;
        this.b = avitoMapPoint;
    }

    @NotNull
    public abstract AvitoMapMarker.Anchor getAnchor();

    @NotNull
    public String getId() {
        return this.a;
    }

    @NotNull
    public AvitoMapPoint getLatLng() {
        return this.b;
    }

    public final boolean hasLabel() {
        if ((this instanceof Pin) && ((Pin) this).getHint() != null) {
            return true;
        }
        if (!(this instanceof Cluster) || ((Cluster) this).getHint() == null) {
            return false;
        }
        return true;
    }
}
