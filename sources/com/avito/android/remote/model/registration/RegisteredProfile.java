package com.avito.android.remote.model.registration;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B;\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JN\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\rR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b)\u0010\rR\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b*\u0010\rR\u001c\u0010\u0019\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0011¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/registration/RegisteredProfile;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "component4", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "component5", "()Ljava/util/List;", "name", "description", "avatar", "login", "social", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/registration/RegisteredProfile;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSocial", "Ljava/lang/String;", "getDescription", "getLogin", "getName", "Lcom/avito/android/remote/model/Image;", "getAvatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class RegisteredProfile implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<RegisteredProfile> CREATOR = Parcels.creator(RegisteredProfile$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("avatar")
    @NotNull
    private final Image avatar;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("login")
    @Nullable
    private final String login;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("social")
    @Nullable
    private final List<ProfileSocial> social;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/registration/RegisteredProfile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public RegisteredProfile(@NotNull String str, @Nullable String str2, @NotNull Image image, @Nullable String str3, @Nullable List<ProfileSocial> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(image, "avatar");
        this.name = str;
        this.description = str2;
        this.avatar = image;
        this.login = str3;
        this.social = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.registration.RegisteredProfile */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisteredProfile copy$default(RegisteredProfile registeredProfile, String str, String str2, Image image, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registeredProfile.name;
        }
        if ((i & 2) != 0) {
            str2 = registeredProfile.description;
        }
        if ((i & 4) != 0) {
            image = registeredProfile.avatar;
        }
        if ((i & 8) != 0) {
            str3 = registeredProfile.login;
        }
        if ((i & 16) != 0) {
            list = registeredProfile.social;
        }
        return registeredProfile.copy(str, str2, image, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final Image component3() {
        return this.avatar;
    }

    @Nullable
    public final String component4() {
        return this.login;
    }

    @Nullable
    public final List<ProfileSocial> component5() {
        return this.social;
    }

    @NotNull
    public final RegisteredProfile copy(@NotNull String str, @Nullable String str2, @NotNull Image image, @Nullable String str3, @Nullable List<ProfileSocial> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(image, "avatar");
        return new RegisteredProfile(str, str2, image, str3, list);
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
        if (!(obj instanceof RegisteredProfile)) {
            return false;
        }
        RegisteredProfile registeredProfile = (RegisteredProfile) obj;
        return Intrinsics.areEqual(this.name, registeredProfile.name) && Intrinsics.areEqual(this.description, registeredProfile.description) && Intrinsics.areEqual(this.avatar, registeredProfile.avatar) && Intrinsics.areEqual(this.login, registeredProfile.login) && Intrinsics.areEqual(this.social, registeredProfile.social);
    }

    @NotNull
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getLogin() {
        return this.login;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<ProfileSocial> getSocial() {
        return this.social;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Image image = this.avatar;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        String str3 = this.login;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ProfileSocial> list = this.social;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RegisteredProfile(name=");
        L.append(this.name);
        L.append(", description=");
        L.append(this.description);
        L.append(", avatar=");
        L.append(this.avatar);
        L.append(", login=");
        L.append(this.login);
        L.append(", social=");
        return a.w(L, this.social, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.login);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.social, i);
    }
}
