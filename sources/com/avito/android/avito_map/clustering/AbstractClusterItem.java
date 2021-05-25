package com.avito.android.avito_map.clustering;

import a2.b.a.a.a;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/avito/android/avito_map/clustering/AbstractClusterItem;", "Lcom/avito/android/avito_map/clustering/ClusterItem;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPosition", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "", "getTitle", "()Ljava/lang/String;", "getSnippet", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "title", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "c", "snippet", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/lang/String;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractClusterItem implements ClusterItem {
    public final AvitoMapPoint a;
    public final String b;
    public final String c;

    public AbstractClusterItem(@NotNull AvitoMapPoint avitoMapPoint, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "snippet");
        this.a = avitoMapPoint;
        this.b = str;
        this.c = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractClusterItem)) {
            return false;
        }
        AbstractClusterItem abstractClusterItem = (AbstractClusterItem) obj;
        return !(Intrinsics.areEqual(this.a, abstractClusterItem.a) ^ true) && !(Intrinsics.areEqual(this.b, abstractClusterItem.b) ^ true) && !(Intrinsics.areEqual(this.c, abstractClusterItem.c) ^ true);
    }

    @Override // com.avito.android.avito_map.clustering.ClusterItem
    @NotNull
    public AvitoMapPoint getPosition() {
        return this.a;
    }

    @Override // com.avito.android.avito_map.clustering.ClusterItem
    @NotNull
    public String getSnippet() {
        return this.c;
    }

    @Override // com.avito.android.avito_map.clustering.ClusterItem
    @NotNull
    public String getTitle() {
        return this.b;
    }

    public int hashCode() {
        return this.c.hashCode() + a.B0(this.b, this.a.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AbstractClusterItem(position=");
        L.append(this.a);
        L.append(", title='");
        L.append(this.b);
        L.append("', snippet='");
        return a.t(L, this.c, "')");
    }
}
