package com.avito.android.remote.model.delivery;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryGeoPointsResult;", "", "", "", "pointsToRemove", "Ljava/util/List;", "getPointsToRemove", "()Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/Cluster;", "clustersToPlace", "getClustersToPlace", "Lcom/avito/android/remote/model/delivery/DeliveryPointGeo;", "pointsToPlace", "getPointsToPlace", "clustersToRemove", "getClustersToRemove", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryGeoPointsResult {
    @NotNull
    private final List<Cluster> clustersToPlace;
    @NotNull
    private final List<String> clustersToRemove;
    @NotNull
    private final List<DeliveryPointGeo> pointsToPlace;
    @NotNull
    private final List<String> pointsToRemove;

    public DeliveryGeoPointsResult() {
        this(null, null, null, null, 15, null);
    }

    public DeliveryGeoPointsResult(@NotNull List<String> list, @NotNull List<String> list2, @NotNull List<DeliveryPointGeo> list3, @NotNull List<Cluster> list4) {
        Intrinsics.checkNotNullParameter(list, "pointsToRemove");
        Intrinsics.checkNotNullParameter(list2, "clustersToRemove");
        Intrinsics.checkNotNullParameter(list3, "pointsToPlace");
        Intrinsics.checkNotNullParameter(list4, "clustersToPlace");
        this.pointsToRemove = list;
        this.clustersToRemove = list2;
        this.pointsToPlace = list3;
        this.clustersToPlace = list4;
    }

    @NotNull
    public final List<Cluster> getClustersToPlace() {
        return this.clustersToPlace;
    }

    @NotNull
    public final List<String> getClustersToRemove() {
        return this.clustersToRemove;
    }

    @NotNull
    public final List<DeliveryPointGeo> getPointsToPlace() {
        return this.pointsToPlace;
    }

    @NotNull
    public final List<String> getPointsToRemove() {
        return this.pointsToRemove;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeliveryGeoPointsResult(List list, List list2, List list3, List list4, int i, j jVar) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2, (i & 4) != 0 ? new ArrayList() : list3, (i & 8) != 0 ? new ArrayList() : list4);
    }
}
