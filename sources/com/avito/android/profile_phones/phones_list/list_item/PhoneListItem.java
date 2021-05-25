package com.avito.android.profile_phones.phones_list.list_item;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002+,BO\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006-"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "Lcom/avito/conveyor_item/Item;", "", "e", "Ljava/lang/String;", "getStatusText", "()Ljava/lang/String;", "statusText", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Status;", "d", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Status;", "getStatus", "()Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Status;", "status", "c", "getUsageText", "usageText", "", "h", "Z", "isVerified", "()Z", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", g.a, "I", "getAdvertsCount", "()I", "advertsCount", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "f", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", AuthSource.BOOKING_ORDER, "getPhone", "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Status;Ljava/lang/String;Ljava/util/List;IZ)V", "Action", "Status", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneListItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final Status d;
    @Nullable
    public final String e;
    @NotNull
    public final List<Action> f;
    public final int g;
    public final boolean h;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Z", "getShouldBeRed", "()Z", "shouldBeRed", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @NotNull
        public final String a;
        public final boolean b;
        @NotNull
        public final DeepLink c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Action(parcel.readString(), parcel.readInt() != 0, (DeepLink) parcel.readParcelable(Action.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action[] newArray(int i) {
                return new Action[i];
            }
        }

        public Action(@NotNull String str, boolean z, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = str;
            this.b = z;
            this.c = deepLink;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.c;
        }

        public final boolean getShouldBeRed() {
            return this.b;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeParcelable(this.c, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Status;", "", "<init>", "(Ljava/lang/String;I)V", "ON_VERIFICATION", "VERIFIED", "NOT_VERIFIED", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public enum Status {
        ON_VERIFICATION,
        VERIFIED,
        NOT_VERIFIED
    }

    public PhoneListItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Status status, @Nullable String str4, @NotNull List<Action> list, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "phone");
        Intrinsics.checkNotNullParameter(str3, "usageText");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = status;
        this.e = str4;
        this.f = list;
        this.g = i;
        this.h = z;
    }

    @NotNull
    public final List<Action> getActions() {
        return this.f;
    }

    public final int getAdvertsCount() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getPhone() {
        return this.b;
    }

    @NotNull
    public final Status getStatus() {
        return this.d;
    }

    @Nullable
    public final String getStatusText() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getUsageText() {
        return this.c;
    }

    public final boolean isVerified() {
        return this.h;
    }
}
