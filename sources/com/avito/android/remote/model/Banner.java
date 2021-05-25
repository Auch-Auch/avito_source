package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/Banner;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/SimpleAction;", "component3", "()Lcom/avito/android/remote/model/SimpleAction;", "title", "description", "action", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SimpleAction;)Lcom/avito/android/remote/model/Banner;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/SimpleAction;", "getAction", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SimpleAction;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class Banner {
    @SerializedName("action")
    @Nullable
    private final SimpleAction action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Banner(@NotNull String str, @Nullable String str2, @Nullable SimpleAction simpleAction) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.action = simpleAction;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, SimpleAction simpleAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = banner.title;
        }
        if ((i & 2) != 0) {
            str2 = banner.description;
        }
        if ((i & 4) != 0) {
            simpleAction = banner.action;
        }
        return banner.copy(str, str2, simpleAction);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final SimpleAction component3() {
        return this.action;
    }

    @NotNull
    public final Banner copy(@NotNull String str, @Nullable String str2, @Nullable SimpleAction simpleAction) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new Banner(str, str2, simpleAction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) obj;
        return Intrinsics.areEqual(this.title, banner.title) && Intrinsics.areEqual(this.description, banner.description) && Intrinsics.areEqual(this.action, banner.action);
    }

    @Nullable
    public final SimpleAction getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
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
        SimpleAction simpleAction = this.action;
        if (simpleAction != null) {
            i = simpleAction.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Banner(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }
}
