package com.avito.android.ratings;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\bW\u0010XJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b)\u0010\rJ\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020*HÖ\u0001¢\u0006\u0004\b1\u0010,J \u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020*HÖ\u0001¢\u0006\u0004\b6\u00107R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\rR\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u00109\u001a\u0004\b<\u0010\rR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010\rR$\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010CR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\nR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u0004R\u001b\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0014R\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bM\u00109\u001a\u0004\bN\u0010\rR\u001b\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bO\u00109\u001a\u0004\bP\u0010\rR!\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u001bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0007¨\u0006Y"}, d2 = {"Lcom/avito/android/ratings/ReviewData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Long;", "", "component2", "()Ljava/lang/Float;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/lang/Boolean;", "Lcom/avito/android/ratings/ReviewReply;", "component10", "()Lcom/avito/android/ratings/ReviewReply;", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "component11", "()Ljava/util/List;", "reviewId", "score", "avatar", "name", "message", "stage", "item", "publicationDate", "canReply", "reply", "images", "copy", "(Ljava/lang/Long;Ljava/lang/Float;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/ratings/ReviewReply;Ljava/util/List;)Lcom/avito/android/ratings/ReviewData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "h", "Ljava/lang/String;", "getPublicationDate", "f", "getStage", "d", "getName", "j", "Lcom/avito/android/ratings/ReviewReply;", "getReply", "setReply", "(Lcom/avito/android/ratings/ReviewReply;)V", "c", "Lcom/avito/android/remote/model/Image;", "getAvatar", AuthSource.SEND_ABUSE, "Ljava/lang/Long;", "getReviewId", "i", "Ljava/lang/Boolean;", "getCanReply", "e", "getMessage", g.a, "getItem", "k", "Ljava/util/List;", "getImages", AuthSource.BOOKING_ORDER, "Ljava/lang/Float;", "getScore", "<init>", "(Ljava/lang/Long;Ljava/lang/Float;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/ratings/ReviewReply;Ljava/util/List;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewData implements Parcelable {
    public static final Parcelable.Creator<ReviewData> CREATOR = new Creator();
    @Nullable
    public final Long a;
    @Nullable
    public final Float b;
    @Nullable
    public final Image c;
    @NotNull
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
    public final Boolean i;
    @Nullable
    public ReviewReply j;
    @Nullable
    public final List<TnsGalleryImage> k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ReviewData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewData createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            Float valueOf2 = parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null;
            Image image = (Image) parcel.readParcelable(ReviewData.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            ReviewReply createFromParcel = parcel.readInt() != 0 ? ReviewReply.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((TnsGalleryImage) parcel.readParcelable(ReviewData.class.getClassLoader()));
                    readInt--;
                }
            }
            return new ReviewData(valueOf, valueOf2, image, readString, readString2, readString3, readString4, readString5, bool, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewData[] newArray(int i) {
            return new ReviewData[i];
        }
    }

    public ReviewData(@Nullable Long l, @Nullable Float f2, @Nullable Image image, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable ReviewReply reviewReply, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = l;
        this.b = f2;
        this.c = image;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = bool;
        this.j = reviewReply;
        this.k = list;
    }

    public static /* synthetic */ ReviewData copy$default(ReviewData reviewData, Long l, Float f2, Image image, String str, String str2, String str3, String str4, String str5, Boolean bool, ReviewReply reviewReply, List list, int i2, Object obj) {
        return reviewData.copy((i2 & 1) != 0 ? reviewData.a : l, (i2 & 2) != 0 ? reviewData.b : f2, (i2 & 4) != 0 ? reviewData.c : image, (i2 & 8) != 0 ? reviewData.d : str, (i2 & 16) != 0 ? reviewData.e : str2, (i2 & 32) != 0 ? reviewData.f : str3, (i2 & 64) != 0 ? reviewData.g : str4, (i2 & 128) != 0 ? reviewData.h : str5, (i2 & 256) != 0 ? reviewData.i : bool, (i2 & 512) != 0 ? reviewData.j : reviewReply, (i2 & 1024) != 0 ? reviewData.k : list);
    }

    @Nullable
    public final Long component1() {
        return this.a;
    }

    @Nullable
    public final ReviewReply component10() {
        return this.j;
    }

    @Nullable
    public final List<TnsGalleryImage> component11() {
        return this.k;
    }

    @Nullable
    public final Float component2() {
        return this.b;
    }

    @Nullable
    public final Image component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final Boolean component9() {
        return this.i;
    }

    @NotNull
    public final ReviewData copy(@Nullable Long l, @Nullable Float f2, @Nullable Image image, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable ReviewReply reviewReply, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ReviewData(l, f2, image, str, str2, str3, str4, str5, bool, reviewReply, list);
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
        if (!(obj instanceof ReviewData)) {
            return false;
        }
        ReviewData reviewData = (ReviewData) obj;
        return Intrinsics.areEqual(this.a, reviewData.a) && Intrinsics.areEqual(this.b, reviewData.b) && Intrinsics.areEqual(this.c, reviewData.c) && Intrinsics.areEqual(this.d, reviewData.d) && Intrinsics.areEqual(this.e, reviewData.e) && Intrinsics.areEqual(this.f, reviewData.f) && Intrinsics.areEqual(this.g, reviewData.g) && Intrinsics.areEqual(this.h, reviewData.h) && Intrinsics.areEqual(this.i, reviewData.i) && Intrinsics.areEqual(this.j, reviewData.j) && Intrinsics.areEqual(this.k, reviewData.k);
    }

    @Nullable
    public final Image getAvatar() {
        return this.c;
    }

    @Nullable
    public final Boolean getCanReply() {
        return this.i;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.k;
    }

    @Nullable
    public final String getItem() {
        return this.g;
    }

    @Nullable
    public final String getMessage() {
        return this.e;
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final String getPublicationDate() {
        return this.h;
    }

    @Nullable
    public final ReviewReply getReply() {
        return this.j;
    }

    @Nullable
    public final Long getReviewId() {
        return this.a;
    }

    @Nullable
    public final Float getScore() {
        return this.b;
    }

    @Nullable
    public final String getStage() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Long l = this.a;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        Float f2 = this.b;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 31;
        Image image = this.c;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool = this.i;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        ReviewReply reviewReply = this.j;
        int hashCode10 = (hashCode9 + (reviewReply != null ? reviewReply.hashCode() : 0)) * 31;
        List<TnsGalleryImage> list = this.k;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode10 + i2;
    }

    public final void setReply(@Nullable ReviewReply reviewReply) {
        this.j = reviewReply;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ReviewData(reviewId=");
        L.append(this.a);
        L.append(", score=");
        L.append(this.b);
        L.append(", avatar=");
        L.append(this.c);
        L.append(", name=");
        L.append(this.d);
        L.append(", message=");
        L.append(this.e);
        L.append(", stage=");
        L.append(this.f);
        L.append(", item=");
        L.append(this.g);
        L.append(", publicationDate=");
        L.append(this.h);
        L.append(", canReply=");
        L.append(this.i);
        L.append(", reply=");
        L.append(this.j);
        L.append(", images=");
        return a.w(L, this.k, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Long l = this.a;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        Float f2 = this.b;
        if (f2 != null) {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        Boolean bool = this.i;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        ReviewReply reviewReply = this.j;
        if (reviewReply != null) {
            parcel.writeInt(1);
            reviewReply.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<TnsGalleryImage> list = this.k;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((TnsGalleryImage) l0.next(), i2);
            }
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReviewData(Long l, Float f2, Image image, String str, String str2, String str3, String str4, String str5, Boolean bool, ReviewReply reviewReply, List list, int i2, j jVar) {
        this(l, f2, image, str, str2, str3, str4, str5, bool, reviewReply, (i2 & 1024) != 0 ? null : list);
    }
}
