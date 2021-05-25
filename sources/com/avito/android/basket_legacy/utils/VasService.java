package com.avito.android.basket_legacy.utils;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020 \u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010.\u001a\u00020)¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010(\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/basket_legacy/utils/VasService;", "Lcom/avito/android/basket_legacy/utils/PaidService;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getOldPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "oldPrice", "", "f", "J", "getPriceValue", "()J", "priceValue", "c", "getPrice", "price", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSlug", "()Ljava/lang/String;", "slug", AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/basket_legacy/utils/VasType;", g.a, "Lcom/avito/android/basket_legacy/utils/VasType;", "getType", "()Lcom/avito/android/basket_legacy/utils/VasType;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;JLcom/avito/android/basket_legacy/utils/VasType;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class VasService extends PaidService {
    public static final Parcelable.Creator<VasService> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final AttributedText c;
    @Nullable
    public final AttributedText d;
    @Nullable
    public final Image e;
    public final long f;
    @NotNull
    public final VasType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VasService> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VasService createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VasService(parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(VasService.class.getClassLoader()), (AttributedText) parcel.readParcelable(VasService.class.getClassLoader()), (Image) parcel.readParcelable(VasService.class.getClassLoader()), parcel.readLong(), (VasType) Enum.valueOf(VasType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VasService[] newArray(int i) {
            return new VasService[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VasService(String str, String str2, AttributedText attributedText, AttributedText attributedText2, Image image, long j, VasType vasType, int i, j jVar) {
        this(str, str2, attributedText, attributedText2, image, j, (i & 64) != 0 ? VasType.PERFORMANCE : vasType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getIcon() {
        return this.e;
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.d;
    }

    @Nullable
    public final AttributedText getPrice() {
        return this.c;
    }

    public final long getPriceValue() {
        return this.f;
    }

    @NotNull
    public final String getSlug() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @NotNull
    public final VasType getType() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeLong(this.f);
        parcel.writeString(this.g.name());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VasService(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable Image image, long j, @NotNull VasType vasType) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "slug");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(vasType, "type");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
        this.d = attributedText2;
        this.e = image;
        this.f = j;
        this.g = vasType;
    }
}
