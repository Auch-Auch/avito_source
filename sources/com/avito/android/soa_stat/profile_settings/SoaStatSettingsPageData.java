package com.avito.android.soa_stat.profile_settings;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000f¨\u0006/"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/Boolean;", "component5", "()Z", "title", "text", "image", "switcherValue", "switcherEnabled", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Z)Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "d", "Ljava/lang/Boolean;", "getSwitcherValue", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "e", "Z", "getSwitcherEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Z)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatSettingsPageData {
    @Nullable
    public final String a;
    @Nullable
    public final CharSequence b;
    @Nullable
    public final Image c;
    @Nullable
    public final Boolean d;
    public final boolean e;

    public SoaStatSettingsPageData(@Nullable String str, @Nullable CharSequence charSequence, @Nullable Image image, @Nullable Boolean bool, boolean z) {
        this.a = str;
        this.b = charSequence;
        this.c = image;
        this.d = bool;
        this.e = z;
    }

    public static /* synthetic */ SoaStatSettingsPageData copy$default(SoaStatSettingsPageData soaStatSettingsPageData, String str, CharSequence charSequence, Image image, Boolean bool, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = soaStatSettingsPageData.a;
        }
        if ((i & 2) != 0) {
            charSequence = soaStatSettingsPageData.b;
        }
        if ((i & 4) != 0) {
            image = soaStatSettingsPageData.c;
        }
        if ((i & 8) != 0) {
            bool = soaStatSettingsPageData.d;
        }
        if ((i & 16) != 0) {
            z = soaStatSettingsPageData.e;
        }
        return soaStatSettingsPageData.copy(str, charSequence, image, bool, z);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final CharSequence component2() {
        return this.b;
    }

    @Nullable
    public final Image component3() {
        return this.c;
    }

    @Nullable
    public final Boolean component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final SoaStatSettingsPageData copy(@Nullable String str, @Nullable CharSequence charSequence, @Nullable Image image, @Nullable Boolean bool, boolean z) {
        return new SoaStatSettingsPageData(str, charSequence, image, bool, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoaStatSettingsPageData)) {
            return false;
        }
        SoaStatSettingsPageData soaStatSettingsPageData = (SoaStatSettingsPageData) obj;
        return Intrinsics.areEqual(this.a, soaStatSettingsPageData.a) && Intrinsics.areEqual(this.b, soaStatSettingsPageData.b) && Intrinsics.areEqual(this.c, soaStatSettingsPageData.c) && Intrinsics.areEqual(this.d, soaStatSettingsPageData.d) && this.e == soaStatSettingsPageData.e;
    }

    @Nullable
    public final Image getImage() {
        return this.c;
    }

    public final boolean getSwitcherEnabled() {
        return this.e;
    }

    @Nullable
    public final Boolean getSwitcherValue() {
        return this.d;
    }

    @Nullable
    public final CharSequence getText() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        int hashCode2 = (hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Image image = this.c;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        Boolean bool = this.d;
        if (bool != null) {
            i = bool.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SoaStatSettingsPageData(title=");
        L.append(this.a);
        L.append(", text=");
        L.append(this.b);
        L.append(", image=");
        L.append(this.c);
        L.append(", switcherValue=");
        L.append(this.d);
        L.append(", switcherEnabled=");
        return a.B(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SoaStatSettingsPageData(String str, CharSequence charSequence, Image image, Boolean bool, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : charSequence, (i & 4) != 0 ? null : image, (i & 8) != 0 ? null : bool, z);
    }
}
