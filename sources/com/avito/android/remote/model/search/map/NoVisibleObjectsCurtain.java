package com.avito.android.remote.model.search.map;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;", "component2", "()Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;", "message", "action", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;)Lcom/avito/android/remote/model/search/map/NoVisibleObjectsCurtain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;", "getAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class NoVisibleObjectsCurtain {
    @SerializedName("action")
    @Nullable
    private final NoVisibleObjectsAction action;
    @SerializedName("message")
    @NotNull
    private final String message;

    public NoVisibleObjectsCurtain(@NotNull String str, @Nullable NoVisibleObjectsAction noVisibleObjectsAction) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.message = str;
        this.action = noVisibleObjectsAction;
    }

    public static /* synthetic */ NoVisibleObjectsCurtain copy$default(NoVisibleObjectsCurtain noVisibleObjectsCurtain, String str, NoVisibleObjectsAction noVisibleObjectsAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noVisibleObjectsCurtain.message;
        }
        if ((i & 2) != 0) {
            noVisibleObjectsAction = noVisibleObjectsCurtain.action;
        }
        return noVisibleObjectsCurtain.copy(str, noVisibleObjectsAction);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final NoVisibleObjectsAction component2() {
        return this.action;
    }

    @NotNull
    public final NoVisibleObjectsCurtain copy(@NotNull String str, @Nullable NoVisibleObjectsAction noVisibleObjectsAction) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new NoVisibleObjectsCurtain(str, noVisibleObjectsAction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoVisibleObjectsCurtain)) {
            return false;
        }
        NoVisibleObjectsCurtain noVisibleObjectsCurtain = (NoVisibleObjectsCurtain) obj;
        return Intrinsics.areEqual(this.message, noVisibleObjectsCurtain.message) && Intrinsics.areEqual(this.action, noVisibleObjectsCurtain.action);
    }

    @Nullable
    public final NoVisibleObjectsAction getAction() {
        return this.action;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.message;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        NoVisibleObjectsAction noVisibleObjectsAction = this.action;
        if (noVisibleObjectsAction != null) {
            i = noVisibleObjectsAction.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NoVisibleObjectsCurtain(message=");
        L.append(this.message);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoVisibleObjectsCurtain(String str, NoVisibleObjectsAction noVisibleObjectsAction, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : noVisibleObjectsAction);
    }
}
