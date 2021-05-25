package com.avito.android.user_subscribers.adapter.subscriber;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.user_subscribers.adapter.UserSubscriberItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010'\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u001b\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItem;", "Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "", "e", "Z", "isShop", "()Z", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriberItem extends UserSubscriberItem {
    public static final Parcelable.Creator<SubscriberItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Image c;
    @Nullable
    public final String d;
    public final boolean e;
    @Nullable
    public final DeepLink f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SubscriberItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubscriberItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SubscriberItem(parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(SubscriberItem.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, (DeepLink) parcel.readParcelable(SubscriberItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubscriberItem[] newArray(int i) {
            return new SubscriberItem[i];
        }
    }

    public SubscriberItem(@NotNull String str, @NotNull String str2, @Nullable Image image, @Nullable String str3, boolean z, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = image;
        this.d = str3;
        this.e = z;
        this.f = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getAvatar() {
        return this.c;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.f;
    }

    @Nullable
    public final String getDescription() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public final boolean isShop() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeParcelable(this.f, i);
    }
}
