package com.avito.android.remote.model.user_profile;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001*BE\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u00020#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/user_profile/Phone;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "verificationInProgress", "Ljava/lang/Boolean;", "getVerificationInProgress", "()Ljava/lang/Boolean;", "locked", "getLocked", "setLocked", "(Ljava/lang/Boolean;)V", "isLocked", "()Z", "verified", "Z", "getVerified", "", "Lcom/avito/android/remote/model/user_profile/Phone$PhoneAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "itemsCount", "Ljava/lang/Integer;", "getItemsCount", "()Ljava/lang/Integer;", "", "phone", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;)V", "PhoneAction", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Phone implements Parcelable {
    public static final Parcelable.Creator<Phone> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final List<PhoneAction> actions;
    @SerializedName("itemsCount")
    @Nullable
    private final Integer itemsCount;
    @SerializedName("locked")
    @Nullable
    private Boolean locked;
    @SerializedName("phone")
    @NotNull
    private final String phone;
    @SerializedName("verificationInProgress")
    @Nullable
    private final Boolean verificationInProgress;
    @SerializedName("verified")
    private final boolean verified;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Phone> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Phone createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add(PhoneAction.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new Phone(readString, z2, bool, bool2, valueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Phone[] newArray(int i) {
            return new Phone[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/user_profile/Phone$PhoneAction;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "shouldBeRed", "Ljava/lang/Boolean;", "getShouldBeRed", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneAction implements Parcelable {
        public static final Parcelable.Creator<PhoneAction> CREATOR = new Creator();
        @SerializedName("deeplink")
        @NotNull
        private final DeepLink deepLink;
        @SerializedName("shouldBeRed")
        @Nullable
        private final Boolean shouldBeRed;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<PhoneAction> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PhoneAction createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(PhoneAction.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new PhoneAction(readString, deepLink, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PhoneAction[] newArray(int i) {
                return new PhoneAction[i];
            }
        }

        public PhoneAction(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.title = str;
            this.deepLink = deepLink2;
            this.shouldBeRed = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Nullable
        public final Boolean getShouldBeRed() {
            return this.shouldBeRed;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.shouldBeRed;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }
    }

    public Phone(@NotNull String str, boolean z, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable List<PhoneAction> list) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.phone = str;
        this.verified = z;
        this.verificationInProgress = bool;
        this.locked = bool2;
        this.itemsCount = num;
        this.actions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<PhoneAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final Integer getItemsCount() {
        return this.itemsCount;
    }

    @Nullable
    public final Boolean getLocked() {
        return this.locked;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final Boolean getVerificationInProgress() {
        return this.verificationInProgress;
    }

    public final boolean getVerified() {
        return this.verified;
    }

    public final boolean isLocked() {
        return Intrinsics.areEqual(this.locked, Boolean.TRUE);
    }

    public final void setLocked(@Nullable Boolean bool) {
        this.locked = bool;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.phone);
        parcel.writeInt(this.verified ? 1 : 0);
        Boolean bool = this.verificationInProgress;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.locked;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.itemsCount;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        List<PhoneAction> list = this.actions;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((PhoneAction) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
