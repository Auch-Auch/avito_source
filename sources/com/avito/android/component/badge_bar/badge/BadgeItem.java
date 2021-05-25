package com.avito.android.component.badge_bar.badge;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.conveyor_item.ParcelableItem;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010)\u001a\u00020\u0018\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u00108\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010!¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001b\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010)\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001b\u0010/\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00102\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001cR\u0019\u00105\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0004R\u001b\u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b7\u0010\u000f¨\u0006;"}, d2 = {"Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", g.a, "Lcom/avito/android/remote/model/UniversalColor;", "getTextColor", "()Lcom/avito/android/remote/model/UniversalColor;", "textColor", "i", "I", "getDescriptionMaxLines", "descriptionMaxLines", "h", "getTitleMaxLines", "titleMaxLines", "", "d", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "e", "getBackgroundColor", "backgroundColor", "Lcom/avito/android/deep_linking/links/DeepLink;", "k", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/Image;", "j", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "c", "getTitle", "title", AuthSource.BOOKING_ORDER, "getBadgeId", "badgeId", "f", "getRippleColor", "rippleColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;IILcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeItem implements ParcelableItem {
    public static final Parcelable.Creator<BadgeItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final UniversalColor e;
    @Nullable
    public final UniversalColor f;
    @Nullable
    public final UniversalColor g;
    public final int h;
    public final int i;
    @Nullable
    public final Image j;
    @Nullable
    public final DeepLink k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BadgeItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BadgeItem(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), (UniversalColor) parcel.readParcelable(BadgeItem.class.getClassLoader()), (UniversalColor) parcel.readParcelable(BadgeItem.class.getClassLoader()), (UniversalColor) parcel.readParcelable(BadgeItem.class.getClassLoader()), parcel.readInt(), parcel.readInt(), (Image) parcel.readParcelable(BadgeItem.class.getClassLoader()), (DeepLink) parcel.readParcelable(BadgeItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeItem[] newArray(int i) {
            return new BadgeItem[i];
        }
    }

    public BadgeItem(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3, @Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable UniversalColor universalColor3, int i3, int i4, @Nullable Image image, @Nullable DeepLink deepLink) {
        a.Z0(str, "stringId", str2, "title", str3, "description");
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.d = str3;
        this.e = universalColor;
        this.f = universalColor2;
        this.g = universalColor3;
        this.h = i3;
        this.i = i4;
        this.j = image;
        this.k = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final UniversalColor getBackgroundColor() {
        return this.e;
    }

    public final int getBadgeId() {
        return this.b;
    }

    @NotNull
    public final String getDescription() {
        return this.d;
    }

    public final int getDescriptionMaxLines() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getImage() {
        return this.j;
    }

    @Nullable
    public final UniversalColor getRippleColor() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final UniversalColor getTextColor() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    public final int getTitleMaxLines() {
        return this.h;
    }

    @Nullable
    public final DeepLink getUri() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeParcelable(this.j, i2);
        parcel.writeParcelable(this.k, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeItem(String str, int i2, String str2, String str3, UniversalColor universalColor, UniversalColor universalColor2, UniversalColor universalColor3, int i3, int i4, Image image, DeepLink deepLink, int i5, j jVar) {
        this(str, i2, str2, str3, universalColor, universalColor2, universalColor3, (i5 & 128) != 0 ? Integer.MAX_VALUE : i3, (i5 & 256) != 0 ? Integer.MAX_VALUE : i4, (i5 & 512) != 0 ? null : image, (i5 & 1024) != 0 ? null : deepLink);
    }
}
