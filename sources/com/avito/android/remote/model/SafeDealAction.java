package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/SafeDealAction;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "icon", "deepLink", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SafeDealAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "Ljava/lang/String;", "getIcon", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SafeDealAction implements Parcelable {
    public static final Parcelable.Creator<SafeDealAction> CREATOR = new Creator();
    @SerializedName("deepLink")
    @NotNull
    private final DeepLink deepLink;
    @SerializedName("icon")
    @Nullable
    private final String icon;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SafeDealAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SafeDealAction(parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(SafeDealAction.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealAction[] newArray(int i) {
            return new SafeDealAction[i];
        }
    }

    public SafeDealAction(@NotNull String str, @Nullable String str2, @NotNull DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.title = str;
        this.icon = str2;
        this.deepLink = deepLink2;
    }

    public static /* synthetic */ SafeDealAction copy$default(SafeDealAction safeDealAction, String str, String str2, DeepLink deepLink2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = safeDealAction.title;
        }
        if ((i & 2) != 0) {
            str2 = safeDealAction.icon;
        }
        if ((i & 4) != 0) {
            deepLink2 = safeDealAction.deepLink;
        }
        return safeDealAction.copy(str, str2, deepLink2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.icon;
    }

    @NotNull
    public final DeepLink component3() {
        return this.deepLink;
    }

    @NotNull
    public final SafeDealAction copy(@NotNull String str, @Nullable String str2, @NotNull DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new SafeDealAction(str, str2, deepLink2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeDealAction)) {
            return false;
        }
        SafeDealAction safeDealAction = (SafeDealAction) obj;
        return Intrinsics.areEqual(this.title, safeDealAction.title) && Intrinsics.areEqual(this.icon, safeDealAction.icon) && Intrinsics.areEqual(this.deepLink, safeDealAction.deepLink);
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeepLink deepLink2 = this.deepLink;
        if (deepLink2 != null) {
            i = deepLink2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SafeDealAction(title=");
        L.append(this.title);
        L.append(", icon=");
        L.append(this.icon);
        L.append(", deepLink=");
        return a.m(L, this.deepLink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.icon);
        parcel.writeParcelable(this.deepLink, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SafeDealAction(String str, String str2, DeepLink deepLink2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, deepLink2);
    }
}
