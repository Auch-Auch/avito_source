package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u0000 52\u00020\u0001:\u00015BC\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010\u0004R\"\u00102\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010\"\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010\u0004¨\u00066"}, d2 = {"Lcom/avito/android/deep_linking/links/PasswordChangeLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "login", "loginType", "sessionIdHash", "deviceId", "source", ChannelContext.Item.USER_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/deep_linking/links/PasswordChangeLink;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Ljava/lang/String;", "getSessionIdHash", "e", "getLoginType", "i", "getUserId", g.a, "getDeviceId", "d", "getLogin", "h", "getSource", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeLink extends DeepLink {
    public static final Parcelable.Creator<PasswordChangeLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/profile/password/change";
    @NotNull
    public final String c = PATH;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/PasswordChangeLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PasswordChangeLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PasswordChangeLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PasswordChangeLink(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PasswordChangeLink[] newArray(int i) {
            return new PasswordChangeLink[i];
        }
    }

    public PasswordChangeLink(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
    }

    public static /* synthetic */ PasswordChangeLink copy$default(PasswordChangeLink passwordChangeLink, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = passwordChangeLink.d;
        }
        if ((i2 & 2) != 0) {
            str2 = passwordChangeLink.e;
        }
        if ((i2 & 4) != 0) {
            str3 = passwordChangeLink.f;
        }
        if ((i2 & 8) != 0) {
            str4 = passwordChangeLink.g;
        }
        if ((i2 & 16) != 0) {
            str5 = passwordChangeLink.h;
        }
        if ((i2 & 32) != 0) {
            str6 = passwordChangeLink.i;
        }
        return passwordChangeLink.copy(str, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.d;
    }

    @Nullable
    public final String component2() {
        return this.e;
    }

    @Nullable
    public final String component3() {
        return this.f;
    }

    @Nullable
    public final String component4() {
        return this.g;
    }

    @Nullable
    public final String component5() {
        return this.h;
    }

    @Nullable
    public final String component6() {
        return this.i;
    }

    @NotNull
    public final PasswordChangeLink copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new PasswordChangeLink(str, str2, str3, str4, str5, str6);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PasswordChangeLink)) {
            return false;
        }
        PasswordChangeLink passwordChangeLink = (PasswordChangeLink) obj;
        return Intrinsics.areEqual(this.d, passwordChangeLink.d) && Intrinsics.areEqual(this.e, passwordChangeLink.e) && Intrinsics.areEqual(this.f, passwordChangeLink.f) && Intrinsics.areEqual(this.g, passwordChangeLink.g) && Intrinsics.areEqual(this.h, passwordChangeLink.h) && Intrinsics.areEqual(this.i, passwordChangeLink.i);
    }

    @Nullable
    public final String getDeviceId() {
        return this.g;
    }

    @Nullable
    public final String getLogin() {
        return this.d;
    }

    @Nullable
    public final String getLoginType() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSessionIdHash() {
        return this.f;
    }

    @Nullable
    public final String getSource() {
        return this.h;
    }

    @Nullable
    public final String getUserId() {
        return this.i;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.i;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PasswordChangeLink(login=");
        L.append(this.d);
        L.append(", loginType=");
        L.append(this.e);
        L.append(", sessionIdHash=");
        L.append(this.f);
        L.append(", deviceId=");
        L.append(this.g);
        L.append(", source=");
        L.append(this.h);
        L.append(", userId=");
        return a.t(L, this.i, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }
}
