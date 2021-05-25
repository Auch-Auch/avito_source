package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/Toggle;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "title", MessengerShareContentUtility.SUBTITLE, "isEnabled", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/remote/model/Toggle;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Z", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class Toggle {
    @SerializedName("isEnabled")
    private final boolean isEnabled;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Toggle(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.subtitle = str2;
        this.isEnabled = z;
    }

    public static /* synthetic */ Toggle copy$default(Toggle toggle, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toggle.title;
        }
        if ((i & 2) != 0) {
            str2 = toggle.subtitle;
        }
        if ((i & 4) != 0) {
            z = toggle.isEnabled;
        }
        return toggle.copy(str, str2, z);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    public final boolean component3() {
        return this.isEnabled;
    }

    @NotNull
    public final Toggle copy(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new Toggle(str, str2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Toggle)) {
            return false;
        }
        Toggle toggle = (Toggle) obj;
        return Intrinsics.areEqual(this.title, toggle.title) && Intrinsics.areEqual(this.subtitle, toggle.subtitle) && this.isEnabled == toggle.isEnabled;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isEnabled;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Toggle(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", isEnabled=");
        return a.B(L, this.isEnabled, ")");
    }
}
