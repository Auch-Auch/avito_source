package com.avito.android.messenger.search;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/search/SearchQuery;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "id", "text", "copy", "(JLjava/lang/String;)Lcom/avito/android/messenger/search/SearchQuery;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "<init>", "(JLjava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SearchQuery {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final SearchQuery c = new SearchQuery(0, null, 3, null);
    public final long a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/SearchQuery$Companion;", "", "Lcom/avito/android/messenger/search/SearchQuery;", "EMPTY", "Lcom/avito/android/messenger/search/SearchQuery;", "getEMPTY", "()Lcom/avito/android/messenger/search/SearchQuery;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SearchQuery getEMPTY() {
            return SearchQuery.c;
        }

        public Companion(j jVar) {
        }
    }

    public SearchQuery() {
        this(0, null, 3, null);
    }

    public SearchQuery(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = j;
        this.b = str;
    }

    public static /* synthetic */ SearchQuery copy$default(SearchQuery searchQuery, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = searchQuery.a;
        }
        if ((i & 2) != 0) {
            str = searchQuery.b;
        }
        return searchQuery.copy(j, str);
    }

    public final long component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final SearchQuery copy(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new SearchQuery(j, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchQuery)) {
            return false;
        }
        SearchQuery searchQuery = (SearchQuery) obj;
        return this.a == searchQuery.a && Intrinsics.areEqual(this.b, searchQuery.b);
    }

    public final long getId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    public int hashCode() {
        int a3 = c.a(this.a) * 31;
        String str = this.b;
        return a3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchQuery(id=");
        L.append(this.a);
        L.append(", text=");
        return a.t(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchQuery(long j, String str, int i, j jVar) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? "" : str);
    }
}
