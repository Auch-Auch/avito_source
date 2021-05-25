package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/util/SearchContextWrapper;", "", "", "component1", "()Ljava/lang/String;", "context", "copy", "(Ljava/lang/String;)Lcom/avito/android/util/SearchContextWrapper;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getContext", "<init>", "(Ljava/lang/String;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class SearchContextWrapper {
    @Nullable
    public final String a;

    public SearchContextWrapper(@Nullable String str) {
        this.a = str;
    }

    public static /* synthetic */ SearchContextWrapper copy$default(SearchContextWrapper searchContextWrapper, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchContextWrapper.a;
        }
        return searchContextWrapper.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final SearchContextWrapper copy(@Nullable String str) {
        return new SearchContextWrapper(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SearchContextWrapper) && Intrinsics.areEqual(this.a, ((SearchContextWrapper) obj).a);
        }
        return true;
    }

    @Nullable
    public final String getContext() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("SearchContextWrapper(context="), this.a, ")");
    }
}
