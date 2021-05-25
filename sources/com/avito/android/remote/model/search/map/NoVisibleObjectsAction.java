package com.avito.android.remote.model.search.map;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", ShareConstants.MEDIA_URI, "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/search/map/NoVisibleObjectsAction;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class NoVisibleObjectsAction {
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    public NoVisibleObjectsAction(@NotNull String str, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.title = str;
        this.uri = deepLink;
    }

    public static /* synthetic */ NoVisibleObjectsAction copy$default(NoVisibleObjectsAction noVisibleObjectsAction, String str, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noVisibleObjectsAction.title;
        }
        if ((i & 2) != 0) {
            deepLink = noVisibleObjectsAction.uri;
        }
        return noVisibleObjectsAction.copy(str, deepLink);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final DeepLink component2() {
        return this.uri;
    }

    @NotNull
    public final NoVisibleObjectsAction copy(@NotNull String str, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        return new NoVisibleObjectsAction(str, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoVisibleObjectsAction)) {
            return false;
        }
        NoVisibleObjectsAction noVisibleObjectsAction = (NoVisibleObjectsAction) obj;
        return Intrinsics.areEqual(this.title, noVisibleObjectsAction.title) && Intrinsics.areEqual(this.uri, noVisibleObjectsAction.uri);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink = this.uri;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NoVisibleObjectsAction(title=");
        L.append(this.title);
        L.append(", uri=");
        return a.m(L, this.uri, ")");
    }
}
