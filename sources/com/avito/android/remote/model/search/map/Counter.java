package com.avito.android.remote.model.search.map;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/search/map/Counter;", "", "", "totalCount", "Ljava/lang/String;", "getTotalCount", "()Ljava/lang/String;", "", "visibleObjectsCount", "Ljava/lang/Integer;", "getVisibleObjectsCount", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;", "noVisibleObjectsCurtain", "Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;", "getNoVisibleObjectsCurtain", "()Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class Counter {
    @SerializedName("noVisibleObjectsCurtain")
    @Nullable
    private final NoVisibleObjectsCurtain noVisibleObjectsCurtain;
    @SerializedName("totalCount")
    @Nullable
    private final String totalCount;
    @SerializedName("visibleObjectsCount")
    @Nullable
    private final Integer visibleObjectsCount;

    public Counter() {
        this(null, null, null, 7, null);
    }

    public Counter(@Nullable String str, @Nullable Integer num, @Nullable NoVisibleObjectsCurtain noVisibleObjectsCurtain2) {
        this.totalCount = str;
        this.visibleObjectsCount = num;
        this.noVisibleObjectsCurtain = noVisibleObjectsCurtain2;
    }

    @Nullable
    public final NoVisibleObjectsCurtain getNoVisibleObjectsCurtain() {
        return this.noVisibleObjectsCurtain;
    }

    @Nullable
    public final String getTotalCount() {
        return this.totalCount;
    }

    @Nullable
    public final Integer getVisibleObjectsCount() {
        return this.visibleObjectsCount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Counter(String str, Integer num, NoVisibleObjectsCurtain noVisibleObjectsCurtain2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : noVisibleObjectsCurtain2);
    }
}
