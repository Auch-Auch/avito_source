package com.avito.android.ratings;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bL\u0010MJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J~\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b$\u0010\u0007J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020%HÖ\u0001¢\u0006\u0004\b,\u0010'J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020%HÖ\u0001¢\u0006\u0004\b1\u00102R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010\u0007R\u0019\u0010\u001d\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b\u001d\u0010\u000fR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0012R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bE\u00107\u001a\u0004\bF\u0010\u0007R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bG\u00107\u001a\u0004\bH\u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0017¨\u0006N"}, d2 = {"Lcom/avito/android/ratings/ReviewReply;", "Landroid/os/Parcelable;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "component5", "", "component6", "()Z", "Lcom/avito/android/ratings/ReviewReplyStatus;", "component7", "()Lcom/avito/android/ratings/ReviewReplyStatus;", "component8", "component9", "Lcom/avito/android/deep_linking/links/DeepLink;", "component10", "()Lcom/avito/android/deep_linking/links/DeepLink;", "id", "title", "answerDate", "avatar", "text", "isShop", "status", "statusText", "rejectMessage", "link", "copy", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;ZLcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/ratings/ReviewReply;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/remote/model/Image;", "getAvatar", "e", "Ljava/lang/String;", "getText", AuthSource.BOOKING_ORDER, "getTitle", "f", "Z", g.a, "Lcom/avito/android/ratings/ReviewReplyStatus;", "getStatus", AuthSource.SEND_ABUSE, "J", "getId", "i", "getRejectMessage", "c", "getAnswerDate", "h", "getStatusText", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;ZLcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReply implements Parcelable {
    public static final Parcelable.Creator<ReviewReply> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final Image d;
    @NotNull
    public final String e;
    public final boolean f;
    @Nullable
    public final ReviewReplyStatus g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final DeepLink j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ReviewReply> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewReply createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ReviewReply(parcel.readLong(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(ReviewReply.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? (ReviewReplyStatus) Enum.valueOf(ReviewReplyStatus.class, parcel.readString()) : null, parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(ReviewReply.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewReply[] newArray(int i) {
            return new ReviewReply[i];
        }
    }

    public ReviewReply(long j2, @NotNull String str, @NotNull String str2, @Nullable Image image, @NotNull String str3, boolean z, @Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str4, @Nullable String str5, @Nullable DeepLink deepLink) {
        a.Z0(str, "title", str2, "answerDate", str3, "text");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = image;
        this.e = str3;
        this.f = z;
        this.g = reviewReplyStatus;
        this.h = str4;
        this.i = str5;
        this.j = deepLink;
    }

    public static /* synthetic */ ReviewReply copy$default(ReviewReply reviewReply, long j2, String str, String str2, Image image, String str3, boolean z, ReviewReplyStatus reviewReplyStatus, String str4, String str5, DeepLink deepLink, int i2, Object obj) {
        return reviewReply.copy((i2 & 1) != 0 ? reviewReply.a : j2, (i2 & 2) != 0 ? reviewReply.b : str, (i2 & 4) != 0 ? reviewReply.c : str2, (i2 & 8) != 0 ? reviewReply.d : image, (i2 & 16) != 0 ? reviewReply.e : str3, (i2 & 32) != 0 ? reviewReply.f : z, (i2 & 64) != 0 ? reviewReply.g : reviewReplyStatus, (i2 & 128) != 0 ? reviewReply.h : str4, (i2 & 256) != 0 ? reviewReply.i : str5, (i2 & 512) != 0 ? reviewReply.j : deepLink);
    }

    public final long component1() {
        return this.a;
    }

    @Nullable
    public final DeepLink component10() {
        return this.j;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Image component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @Nullable
    public final ReviewReplyStatus component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final ReviewReply copy(long j2, @NotNull String str, @NotNull String str2, @Nullable Image image, @NotNull String str3, boolean z, @Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str4, @Nullable String str5, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "answerDate");
        Intrinsics.checkNotNullParameter(str3, "text");
        return new ReviewReply(j2, str, str2, image, str3, z, reviewReplyStatus, str4, str5, deepLink);
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
        if (!(obj instanceof ReviewReply)) {
            return false;
        }
        ReviewReply reviewReply = (ReviewReply) obj;
        return this.a == reviewReply.a && Intrinsics.areEqual(this.b, reviewReply.b) && Intrinsics.areEqual(this.c, reviewReply.c) && Intrinsics.areEqual(this.d, reviewReply.d) && Intrinsics.areEqual(this.e, reviewReply.e) && this.f == reviewReply.f && Intrinsics.areEqual(this.g, reviewReply.g) && Intrinsics.areEqual(this.h, reviewReply.h) && Intrinsics.areEqual(this.i, reviewReply.i) && Intrinsics.areEqual(this.j, reviewReply.j);
    }

    @NotNull
    public final String getAnswerDate() {
        return this.c;
    }

    @Nullable
    public final Image getAvatar() {
        return this.d;
    }

    public final long getId() {
        return this.a;
    }

    @Nullable
    public final DeepLink getLink() {
        return this.j;
    }

    @Nullable
    public final String getRejectMessage() {
        return this.i;
    }

    @Nullable
    public final ReviewReplyStatus getStatus() {
        return this.g;
    }

    @Nullable
    public final String getStatusText() {
        return this.h;
    }

    @NotNull
    public final String getText() {
        return this.e;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(this.a) * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (a3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Image image = this.d;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode4 + i3) * 31;
        ReviewReplyStatus reviewReplyStatus = this.g;
        int hashCode5 = (i6 + (reviewReplyStatus != null ? reviewReplyStatus.hashCode() : 0)) * 31;
        String str4 = this.h;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        DeepLink deepLink = this.j;
        if (deepLink != null) {
            i2 = deepLink.hashCode();
        }
        return hashCode7 + i2;
    }

    public final boolean isShop() {
        return this.f;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ReviewReply(id=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", answerDate=");
        L.append(this.c);
        L.append(", avatar=");
        L.append(this.d);
        L.append(", text=");
        L.append(this.e);
        L.append(", isShop=");
        L.append(this.f);
        L.append(", status=");
        L.append(this.g);
        L.append(", statusText=");
        L.append(this.h);
        L.append(", rejectMessage=");
        L.append(this.i);
        L.append(", link=");
        return a.m(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i2);
        parcel.writeString(this.e);
        parcel.writeInt(this.f ? 1 : 0);
        ReviewReplyStatus reviewReplyStatus = this.g;
        if (reviewReplyStatus != null) {
            parcel.writeInt(1);
            parcel.writeString(reviewReplyStatus.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeParcelable(this.j, i2);
    }
}
