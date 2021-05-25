package com.avito.android.messenger.conversation.mvi.messages;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "component2", "()[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "component3", "()Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "title", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "markersRequest", "copy", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", "toString", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "c", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "getMarkersRequest", AuthSource.BOOKING_ORDER, "[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "getMarkers", "<init>", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapData {
    @NotNull
    public final String a;
    @NotNull
    public final GeoMarker[] b;
    @Nullable
    public final MarkersRequest c;

    public PlatformMapData(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(geoMarkerArr, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        this.a = str;
        this.b = geoMarkerArr;
        this.c = markersRequest;
    }

    public static /* synthetic */ PlatformMapData copy$default(PlatformMapData platformMapData, String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformMapData.a;
        }
        if ((i & 2) != 0) {
            geoMarkerArr = platformMapData.b;
        }
        if ((i & 4) != 0) {
            markersRequest = platformMapData.c;
        }
        return platformMapData.copy(str, geoMarkerArr, markersRequest);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final GeoMarker[] component2() {
        return this.b;
    }

    @Nullable
    public final MarkersRequest component3() {
        return this.c;
    }

    @NotNull
    public final PlatformMapData copy(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(geoMarkerArr, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        return new PlatformMapData(str, geoMarkerArr, markersRequest);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformMapData)) {
            return false;
        }
        PlatformMapData platformMapData = (PlatformMapData) obj;
        return !(Intrinsics.areEqual(this.a, platformMapData.a) ^ true) && Arrays.equals(this.b, platformMapData.b) && !(Intrinsics.areEqual(this.c, platformMapData.c) ^ true);
    }

    @NotNull
    public final GeoMarker[] getMarkers() {
        return this.b;
    }

    @Nullable
    public final MarkersRequest getMarkersRequest() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + Arrays.hashCode(this.b)) * 31;
        MarkersRequest markersRequest = this.c;
        return hashCode + (markersRequest != null ? markersRequest.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PlatformMapData(title=");
        L.append(this.a);
        L.append(", markers=");
        L.append(Arrays.toString(this.b));
        L.append(", markersRequest=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
