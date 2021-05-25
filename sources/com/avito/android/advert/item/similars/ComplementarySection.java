package com.avito.android.advert.item.similars;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J8\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/advert/item/similars/ComplementarySection;", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "component1", "()Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "component2", "()Ljava/util/List;", "component3", "topCommercial", "similarItems", "bottomCommercial", "copy", "(Lcom/avito/android/serp/adapter/PersistableSerpItem;Ljava/util/List;Lcom/avito/android/serp/adapter/PersistableSerpItem;)Lcom/avito/android/advert/item/similars/ComplementarySection;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSimilarItems", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "getTopCommercial", "c", "getBottomCommercial", "<init>", "(Lcom/avito/android/serp/adapter/PersistableSerpItem;Ljava/util/List;Lcom/avito/android/serp/adapter/PersistableSerpItem;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ComplementarySection {
    @Nullable
    public final PersistableSerpItem a;
    @NotNull
    public final List<PersistableSpannedItem> b;
    @Nullable
    public final PersistableSerpItem c;

    public ComplementarySection() {
        this(null, null, null, 7, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.PersistableSpannedItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public ComplementarySection(@Nullable PersistableSerpItem persistableSerpItem, @NotNull List<? extends PersistableSpannedItem> list, @Nullable PersistableSerpItem persistableSerpItem2) {
        Intrinsics.checkNotNullParameter(list, "similarItems");
        this.a = persistableSerpItem;
        this.b = list;
        this.c = persistableSerpItem2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.advert.item.similars.ComplementarySection */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComplementarySection copy$default(ComplementarySection complementarySection, PersistableSerpItem persistableSerpItem, List list, PersistableSerpItem persistableSerpItem2, int i, Object obj) {
        if ((i & 1) != 0) {
            persistableSerpItem = complementarySection.a;
        }
        if ((i & 2) != 0) {
            list = complementarySection.b;
        }
        if ((i & 4) != 0) {
            persistableSerpItem2 = complementarySection.c;
        }
        return complementarySection.copy(persistableSerpItem, list, persistableSerpItem2);
    }

    @Nullable
    public final PersistableSerpItem component1() {
        return this.a;
    }

    @NotNull
    public final List<PersistableSpannedItem> component2() {
        return this.b;
    }

    @Nullable
    public final PersistableSerpItem component3() {
        return this.c;
    }

    @NotNull
    public final ComplementarySection copy(@Nullable PersistableSerpItem persistableSerpItem, @NotNull List<? extends PersistableSpannedItem> list, @Nullable PersistableSerpItem persistableSerpItem2) {
        Intrinsics.checkNotNullParameter(list, "similarItems");
        return new ComplementarySection(persistableSerpItem, list, persistableSerpItem2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplementarySection)) {
            return false;
        }
        ComplementarySection complementarySection = (ComplementarySection) obj;
        return Intrinsics.areEqual(this.a, complementarySection.a) && Intrinsics.areEqual(this.b, complementarySection.b) && Intrinsics.areEqual(this.c, complementarySection.c);
    }

    @Nullable
    public final PersistableSerpItem getBottomCommercial() {
        return this.c;
    }

    @NotNull
    public final List<PersistableSpannedItem> getSimilarItems() {
        return this.b;
    }

    @Nullable
    public final PersistableSerpItem getTopCommercial() {
        return this.a;
    }

    public int hashCode() {
        PersistableSerpItem persistableSerpItem = this.a;
        int i = 0;
        int hashCode = (persistableSerpItem != null ? persistableSerpItem.hashCode() : 0) * 31;
        List<PersistableSpannedItem> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        PersistableSerpItem persistableSerpItem2 = this.c;
        if (persistableSerpItem2 != null) {
            i = persistableSerpItem2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ComplementarySection(topCommercial=");
        L.append(this.a);
        L.append(", similarItems=");
        L.append(this.b);
        L.append(", bottomCommercial=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComplementarySection(PersistableSerpItem persistableSerpItem, List list, PersistableSerpItem persistableSerpItem2, int i, j jVar) {
        this((i & 1) != 0 ? null : persistableSerpItem, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : persistableSerpItem2);
    }
}
