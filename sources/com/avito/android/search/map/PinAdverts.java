package com.avito.android.search.map;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/avito/android/search/map/PinAdverts;", "", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getFavouriteAdverts", "()Ljava/util/List;", "favouriteAdverts", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getNextPageUri", "()Landroid/net/Uri;", "nextPageUri", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", AuthSource.SEND_ABUSE, "getAdverts", "adverts", "<init>", "(Ljava/util/List;Ljava/util/List;Landroid/net/Uri;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class PinAdverts {
    @NotNull
    public final List<ViewTypeSerpItem> a;
    @Nullable
    public final List<String> b;
    @Nullable
    public final Uri c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public PinAdverts(@NotNull List<? extends ViewTypeSerpItem> list, @Nullable List<String> list2, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(list, "adverts");
        this.a = list;
        this.b = list2;
        this.c = uri;
    }

    @NotNull
    public final List<ViewTypeSerpItem> getAdverts() {
        return this.a;
    }

    @Nullable
    public final List<String> getFavouriteAdverts() {
        return this.b;
    }

    @Nullable
    public final Uri getNextPageUri() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PinAdverts(List list, List list2, Uri uri, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : list2, uri);
    }
}
