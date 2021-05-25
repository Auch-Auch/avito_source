package com.avito.android.remote.model.search.map;

import android.net.Uri;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/search/map/PinAdvertsResult;", "", "", "Lcom/avito/android/remote/model/SerpElement;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Landroid/net/Uri;", "nextPage", "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "<init>", "(Ljava/util/List;Landroid/net/Uri;Lcom/avito/android/remote/model/SerpDisplayType;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class PinAdvertsResult {
    @SerializedName("displayType")
    @Nullable
    private final SerpDisplayType displayType;
    @SerializedName("items")
    @NotNull
    private final List<SerpElement> items;
    @SerializedName("nextPage")
    @Nullable
    private final Uri nextPage;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public PinAdvertsResult(@NotNull List<? extends SerpElement> list, @Nullable Uri uri, @Nullable SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.nextPage = uri;
        this.displayType = serpDisplayType;
    }

    @Nullable
    public final SerpDisplayType getDisplayType() {
        return this.displayType;
    }

    @NotNull
    public final List<SerpElement> getItems() {
        return this.items;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.nextPage;
    }
}
