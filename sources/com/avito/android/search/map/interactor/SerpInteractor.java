package com.avito.android.search.map.interactor;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001eJS\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpInteractor;", "", "Lcom/avito/android/search/map/interactor/SerpKey;", "key", "", "nextPage", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "context", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/remote/model/search/map/Area;", "area", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", "loadSerp", "(Lcom/avito/android/search/map/interactor/SerpKey;ZLcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/search/map/Area;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "itemsDataSource", "loadAds", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "serpKey", "", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Completable;", "removeElement", "(Lcom/avito/android/search/map/interactor/SerpKey;I)Lio/reactivex/rxjava3/core/Completable;", "Result", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SerpInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\"\u001a\u00020\u001d\u0012\b\b\u0002\u0010,\u001a\u00020'\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b/\u00100R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010,\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0013\u0010.\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010\u0015¨\u00061"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", "", "Lcom/avito/android/search/map/interactor/SerpKey;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/interactor/SerpKey;", "getKey", "()Lcom/avito/android/search/map/interactor/SerpKey;", "key", "", "d", "Ljava/lang/String;", "getSubscriptionId", "()Ljava/lang/String;", "subscriptionId", "h", "getXHash", "xHash", "", "c", "Z", "getHasMoreItem", "()Z", "hasMoreItem", "Lcom/avito/android/search/map/interactor/SerpDataSources;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/map/interactor/SerpDataSources;", "getDataSources", "()Lcom/avito/android/search/map/interactor/SerpDataSources;", "dataSources", "", "e", "J", "getCount", "()J", "count", g.a, "Ljava/lang/Boolean;", "isSubScribed", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "getHasItems", "hasItems", "<init>", "(Lcom/avito/android/search/map/interactor/SerpKey;Lcom/avito/android/search/map/interactor/SerpDataSources;ZLjava/lang/String;JLcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/Boolean;Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result {
        @NotNull
        public final SerpKey a;
        @NotNull
        public final SerpDataSources b;
        public final boolean c;
        @Nullable
        public final String d;
        public final long e;
        @NotNull
        public final SerpDisplayType f;
        @Nullable
        public final Boolean g;
        @Nullable
        public final String h;

        public Result(@NotNull SerpKey serpKey, @NotNull SerpDataSources serpDataSources, boolean z, @Nullable String str, long j, @NotNull SerpDisplayType serpDisplayType, @Nullable Boolean bool, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(serpKey, "key");
            Intrinsics.checkNotNullParameter(serpDataSources, "dataSources");
            Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
            this.a = serpKey;
            this.b = serpDataSources;
            this.c = z;
            this.d = str;
            this.e = j;
            this.f = serpDisplayType;
            this.g = bool;
            this.h = str2;
        }

        public final long getCount() {
            return this.e;
        }

        @NotNull
        public final SerpDataSources getDataSources() {
            return this.b;
        }

        @NotNull
        public final SerpDisplayType getDisplayType() {
            return this.f;
        }

        public final boolean getHasItems() {
            return this.b.getSpans().getCount() > 0;
        }

        public final boolean getHasMoreItem() {
            return this.c;
        }

        @NotNull
        public final SerpKey getKey() {
            return this.a;
        }

        @Nullable
        public final String getSubscriptionId() {
            return this.d;
        }

        @Nullable
        public final String getXHash() {
            return this.h;
        }

        @Nullable
        public final Boolean isSubScribed() {
            return this.g;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Result(SerpKey serpKey, SerpDataSources serpDataSources, boolean z, String str, long j, SerpDisplayType serpDisplayType, Boolean bool, String str2, int i, j jVar) {
            this(serpKey, serpDataSources, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? 0 : j, (i & 32) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str2);
        }
    }

    @NotNull
    Observable<ViewTypeSerpItem> loadAds(@NotNull DataSource<ViewTypeSerpItem> dataSource, @NotNull SearchParams searchParams, @NotNull SerpDisplayType serpDisplayType, @NotNull String str);

    @NotNull
    Observable<LoadingState<Result>> loadSerp(@Nullable SerpKey serpKey, boolean z, @NotNull SearchParams searchParams, @Nullable String str, @Nullable SerpDisplayType serpDisplayType, @Nullable Area area);

    @NotNull
    Completable removeElement(@Nullable SerpKey serpKey, int i);
}
