package com.avito.android.search.map.interactor;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J0\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpDataSources;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "component1", "()Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "component2", "spans", "serpItems", "copy", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)Lcom/avito/android/search/map/interactor/SerpDataSources;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "getSpans", AuthSource.BOOKING_ORDER, "getSerpItems", "<init>", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpDataSources {
    @NotNull
    public final DataSource<SpannedItem> a;
    @NotNull
    public final DataSource<ViewTypeSerpItem> b;

    public SerpDataSources(@NotNull DataSource<SpannedItem> dataSource, @NotNull DataSource<ViewTypeSerpItem> dataSource2) {
        Intrinsics.checkNotNullParameter(dataSource, "spans");
        Intrinsics.checkNotNullParameter(dataSource2, "serpItems");
        this.a = dataSource;
        this.b = dataSource2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.search.map.interactor.SerpDataSources */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SerpDataSources copy$default(SerpDataSources serpDataSources, DataSource dataSource, DataSource dataSource2, int i, Object obj) {
        if ((i & 1) != 0) {
            dataSource = serpDataSources.a;
        }
        if ((i & 2) != 0) {
            dataSource2 = serpDataSources.b;
        }
        return serpDataSources.copy(dataSource, dataSource2);
    }

    @NotNull
    public final DataSource<SpannedItem> component1() {
        return this.a;
    }

    @NotNull
    public final DataSource<ViewTypeSerpItem> component2() {
        return this.b;
    }

    @NotNull
    public final SerpDataSources copy(@NotNull DataSource<SpannedItem> dataSource, @NotNull DataSource<ViewTypeSerpItem> dataSource2) {
        Intrinsics.checkNotNullParameter(dataSource, "spans");
        Intrinsics.checkNotNullParameter(dataSource2, "serpItems");
        return new SerpDataSources(dataSource, dataSource2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerpDataSources)) {
            return false;
        }
        SerpDataSources serpDataSources = (SerpDataSources) obj;
        return Intrinsics.areEqual(this.a, serpDataSources.a) && Intrinsics.areEqual(this.b, serpDataSources.b);
    }

    @NotNull
    public final DataSource<ViewTypeSerpItem> getSerpItems() {
        return this.b;
    }

    @NotNull
    public final DataSource<SpannedItem> getSpans() {
        return this.a;
    }

    public int hashCode() {
        DataSource<SpannedItem> dataSource = this.a;
        int i = 0;
        int hashCode = (dataSource != null ? dataSource.hashCode() : 0) * 31;
        DataSource<ViewTypeSerpItem> dataSource2 = this.b;
        if (dataSource2 != null) {
            i = dataSource2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpDataSources(spans=");
        L.append(this.a);
        L.append(", serpItems=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
