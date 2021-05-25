package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/AuthSuggestsResult;", "", "", "Lcom/avito/android/remote/model/AuthSuggestItem;", "component1", "()Ljava/util/List;", "suggests", "copy", "(Ljava/util/List;)Lcom/avito/android/remote/model/AuthSuggestsResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSuggests", "<init>", "(Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AuthSuggestsResult {
    @SerializedName("info")
    @NotNull
    private final List<AuthSuggestItem> suggests;

    public AuthSuggestsResult(@NotNull List<AuthSuggestItem> list) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        this.suggests = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.AuthSuggestsResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthSuggestsResult copy$default(AuthSuggestsResult authSuggestsResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = authSuggestsResult.suggests;
        }
        return authSuggestsResult.copy(list);
    }

    @NotNull
    public final List<AuthSuggestItem> component1() {
        return this.suggests;
    }

    @NotNull
    public final AuthSuggestsResult copy(@NotNull List<AuthSuggestItem> list) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        return new AuthSuggestsResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AuthSuggestsResult) && Intrinsics.areEqual(this.suggests, ((AuthSuggestsResult) obj).suggests);
        }
        return true;
    }

    @NotNull
    public final List<AuthSuggestItem> getSuggests() {
        return this.suggests;
    }

    public int hashCode() {
        List<AuthSuggestItem> list = this.suggests;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("AuthSuggestsResult(suggests="), this.suggests, ")");
    }
}
