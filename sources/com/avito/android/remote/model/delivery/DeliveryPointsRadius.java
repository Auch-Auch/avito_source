package com.avito.android.remote.model.delivery;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsRadius;", "", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/delivery/DeliveryPointGeo;", "pins", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/Cluster;", "clusters", "getClusters", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPointsRadius {
    @SerializedName("clusters")
    @NotNull
    private final List<Cluster> clusters;
    @SerializedName("pins")
    @NotNull
    private final List<DeliveryPointGeo> pins;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;

    public DeliveryPointsRadius(@NotNull String str, @NotNull List<DeliveryPointGeo> list, @NotNull List<Cluster> list2) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(list, "pins");
        Intrinsics.checkNotNullParameter(list2, "clusters");
        this.subtitle = str;
        this.pins = list;
        this.clusters = list2;
    }

    @NotNull
    public final List<Cluster> getClusters() {
        return this.clusters;
    }

    @NotNull
    public final List<DeliveryPointGeo> getPins() {
        return this.pins;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }
}
