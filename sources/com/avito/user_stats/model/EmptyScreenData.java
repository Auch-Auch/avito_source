package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/user_stats/model/EmptyScreenData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "description", "buttonText", "link", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/user_stats/model/EmptyScreenData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "getDescription", "getButtonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyScreenData {
    @SerializedName("button_text")
    @NotNull
    private final String buttonText;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("link")
    @NotNull
    private final DeepLink link;
    @SerializedName("title")
    @NotNull
    private final String title;

    public EmptyScreenData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(deepLink, "link");
        this.title = str;
        this.description = str2;
        this.buttonText = str3;
        this.link = deepLink;
    }

    public static /* synthetic */ EmptyScreenData copy$default(EmptyScreenData emptyScreenData, String str, String str2, String str3, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emptyScreenData.title;
        }
        if ((i & 2) != 0) {
            str2 = emptyScreenData.description;
        }
        if ((i & 4) != 0) {
            str3 = emptyScreenData.buttonText;
        }
        if ((i & 8) != 0) {
            deepLink = emptyScreenData.link;
        }
        return emptyScreenData.copy(str, str2, str3, deepLink);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final String component3() {
        return this.buttonText;
    }

    @NotNull
    public final DeepLink component4() {
        return this.link;
    }

    @NotNull
    public final EmptyScreenData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(deepLink, "link");
        return new EmptyScreenData(str, str2, str3, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyScreenData)) {
            return false;
        }
        EmptyScreenData emptyScreenData = (EmptyScreenData) obj;
        return Intrinsics.areEqual(this.title, emptyScreenData.title) && Intrinsics.areEqual(this.description, emptyScreenData.description) && Intrinsics.areEqual(this.buttonText, emptyScreenData.buttonText) && Intrinsics.areEqual(this.link, emptyScreenData.link);
    }

    @NotNull
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final DeepLink getLink() {
        return this.link;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.buttonText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        DeepLink deepLink = this.link;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("EmptyScreenData(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", buttonText=");
        L.append(this.buttonText);
        L.append(", link=");
        return a.m(L, this.link, ")");
    }
}
