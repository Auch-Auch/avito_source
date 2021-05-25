package com.avito.android.home;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HomeTabItem;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BS\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016¨\u0006$"}, d2 = {"Lcom/avito/android/home/HomePageResult;", "", "Lcom/avito/android/remote/model/SerpDisplayType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "e", "Ljava/lang/String;", "getXHash", "()Ljava/lang/String;", "xHash", "d", "getSearchHint", "searchHint", "", "Lcom/avito/android/remote/model/HomeTabItem;", "c", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "tabs", "Lcom/avito/android/remote/model/Location;", "f", "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", AuthSource.SEND_ABUSE, "getElements", MessengerShareContentUtility.ELEMENTS, "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Location;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomePageResult {
    @NotNull
    public final List<ViewTypeSerpItem> a;
    @NotNull
    public final SerpDisplayType b;
    @Nullable
    public final List<HomeTabItem> c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Location f;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public HomePageResult(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpDisplayType serpDisplayType, @Nullable List<HomeTabItem> list2, @Nullable String str, @Nullable String str2, @Nullable Location location) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.a = list;
        this.b = serpDisplayType;
        this.c = list2;
        this.d = str;
        this.e = str2;
        this.f = location;
    }

    @NotNull
    public final SerpDisplayType getDisplayType() {
        return this.b;
    }

    @NotNull
    public final List<ViewTypeSerpItem> getElements() {
        return this.a;
    }

    @Nullable
    public final Location getLocation() {
        return this.f;
    }

    @Nullable
    public final String getSearchHint() {
        return this.d;
    }

    @Nullable
    public final List<HomeTabItem> getTabs() {
        return this.c;
    }

    @Nullable
    public final String getXHash() {
        return this.e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomePageResult(List list, SerpDisplayType serpDisplayType, List list2, String str, String str2, Location location, int i, j jVar) {
        this(list, serpDisplayType, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : location);
    }
}
