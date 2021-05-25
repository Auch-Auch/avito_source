package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/AuthSuggestItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "hashUserId", "name", "avatar", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/AuthSuggestItem;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Image;", "getAvatar", "Ljava/lang/String;", "getName", "getHashUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AuthSuggestItem {
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("hashUserId")
    @NotNull
    private final String hashUserId;
    @SerializedName("name")
    @NotNull
    private final String name;

    public AuthSuggestItem(@NotNull String str, @NotNull String str2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(str, "hashUserId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.hashUserId = str;
        this.name = str2;
        this.avatar = image;
    }

    public static /* synthetic */ AuthSuggestItem copy$default(AuthSuggestItem authSuggestItem, String str, String str2, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authSuggestItem.hashUserId;
        }
        if ((i & 2) != 0) {
            str2 = authSuggestItem.name;
        }
        if ((i & 4) != 0) {
            image = authSuggestItem.avatar;
        }
        return authSuggestItem.copy(str, str2, image);
    }

    @NotNull
    public final String component1() {
        return this.hashUserId;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final Image component3() {
        return this.avatar;
    }

    @NotNull
    public final AuthSuggestItem copy(@NotNull String str, @NotNull String str2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(str, "hashUserId");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new AuthSuggestItem(str, str2, image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthSuggestItem)) {
            return false;
        }
        AuthSuggestItem authSuggestItem = (AuthSuggestItem) obj;
        return Intrinsics.areEqual(this.hashUserId, authSuggestItem.hashUserId) && Intrinsics.areEqual(this.name, authSuggestItem.name) && Intrinsics.areEqual(this.avatar, authSuggestItem.avatar);
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getHashUserId() {
        return this.hashUserId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.hashUserId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Image image = this.avatar;
        if (image != null) {
            i = image.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AuthSuggestItem(hashUserId=");
        L.append(this.hashUserId);
        L.append(", name=");
        L.append(this.name);
        L.append(", avatar=");
        L.append(this.avatar);
        L.append(")");
        return L.toString();
    }
}
