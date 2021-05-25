package com.avito.android.rating.details.adapter.user_profile_comment;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.ratings.ReviewReply;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.user_review.RecipientData;
import com.vk.sdk.api.VKApiConst;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B»\u0001\u0012\u0006\u0010W\u001a\u00020\t\u0012\b\u00105\u001a\u0004\u0018\u000100\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\b\u0010]\u001a\u0004\u0018\u00010X\u0012\b\u0010A\u001a\u0004\u0018\u00010<\u0012\b\u0010%\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\b\u0010T\u001a\u0004\u0018\u00010H\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010G\u001a\u00020B\u0012\b\b\u0002\u0010O\u001a\u00020H\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&¢\u0006\u0004\b^\u0010_J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001b\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR!\u0010,\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\rR\u001b\u00105\u001a\u0004\u0018\u0001008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\rR\u001b\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR\u001b\u0010A\u001a\u0004\u0018\u00010<8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010G\u001a\u00020B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001b\u0010T\u001a\u0004\u0018\u00010H8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010W\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\rR\u001b\u0010]\u001a\u0004\u0018\u00010X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\¨\u0006`"}, d2 = {"Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItem;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", g.a, "Ljava/lang/String;", "getStage", "()Ljava/lang/String;", "stage", "Lcom/avito/android/ratings/ReviewReply;", "k", "Lcom/avito/android/ratings/ReviewReply;", "getReply", "()Lcom/avito/android/ratings/ReviewReply;", "setReply", "(Lcom/avito/android/ratings/ReviewReply;)V", "reply", "Lcom/avito/android/user_review/RecipientData;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/user_review/RecipientData;", "getRecipientData", "()Lcom/avito/android/user_review/RecipientData;", "recipientData", "c", "getName", "name", "h", "getItem", "item", "f", "getMessage", "message", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", VKApiConst.Q, "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", "i", "getPublicationDate", "publicationDate", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getReviewId", "()Ljava/lang/Long;", "reviewId", "l", "getRejectMessage", "rejectMessage", "n", "getReviewStatusText", "reviewStatusText", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;", "o", "Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;", "getReviewStatus", "()Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;", "reviewStatus", "", "p", "Z", "getExpanded", "()Z", "setExpanded", "(Z)V", PanelStateKt.PANEL_EXPANDED, "j", "Ljava/lang/Boolean;", "getCanReply", "()Ljava/lang/Boolean;", "canReply", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "d", "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "score", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Float;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/ratings/ReviewReply;Ljava/lang/String;Lcom/avito/android/user_review/RecipientData;Ljava/lang/String;Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;ZLjava/util/List;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileCommentItem extends RatingDetailsItem {
    public static final Parcelable.Creator<UserProfileCommentItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final Long b;
    @NotNull
    public final String c;
    @Nullable
    public final Float d;
    @Nullable
    public final Image e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final Boolean j;
    @Nullable
    public ReviewReply k;
    @Nullable
    public final String l;
    @Nullable
    public final RecipientData m;
    @Nullable
    public final String n;
    @NotNull
    public final ReviewStatus o;
    public boolean p;
    @Nullable
    public final List<TnsGalleryImage> q;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserProfileCommentItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfileCommentItem createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            String readString2 = parcel.readString();
            Float valueOf2 = parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null;
            Image image = (Image) parcel.readParcelable(UserProfileCommentItem.class.getClassLoader());
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            ReviewReply reviewReply = (ReviewReply) parcel.readParcelable(UserProfileCommentItem.class.getClassLoader());
            String readString7 = parcel.readString();
            RecipientData recipientData = (RecipientData) parcel.readParcelable(UserProfileCommentItem.class.getClassLoader());
            String readString8 = parcel.readString();
            ReviewStatus reviewStatus = (ReviewStatus) Enum.valueOf(ReviewStatus.class, parcel.readString());
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((TnsGalleryImage) parcel.readParcelable(UserProfileCommentItem.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new UserProfileCommentItem(readString, valueOf, readString2, valueOf2, image, readString3, readString4, readString5, readString6, bool, reviewReply, readString7, recipientData, readString8, reviewStatus, z, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfileCommentItem[] newArray(int i) {
            return new UserProfileCommentItem[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfileCommentItem(String str, Long l2, String str2, Float f2, Image image, String str3, String str4, String str5, String str6, Boolean bool, ReviewReply reviewReply, String str7, RecipientData recipientData, String str8, ReviewStatus reviewStatus, boolean z, List list, int i2, j jVar) {
        this(str, l2, str2, f2, image, str3, str4, str5, str6, bool, reviewReply, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : recipientData, (i2 & 8192) != 0 ? null : str8, (i2 & 16384) != 0 ? ReviewStatus.NONE : reviewStatus, (32768 & i2) != 0 ? false : z, (i2 & 65536) != 0 ? null : list);
    }

    @Nullable
    public final Image getAvatar() {
        return this.e;
    }

    @Nullable
    public final Boolean getCanReply() {
        return this.j;
    }

    public final boolean getExpanded() {
        return this.p;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.q;
    }

    @Nullable
    public final String getItem() {
        return this.h;
    }

    @Nullable
    public final String getMessage() {
        return this.f;
    }

    @NotNull
    public final String getName() {
        return this.c;
    }

    @Nullable
    public final String getPublicationDate() {
        return this.i;
    }

    @Nullable
    public final RecipientData getRecipientData() {
        return this.m;
    }

    @Nullable
    public final String getRejectMessage() {
        return this.l;
    }

    @Nullable
    public final ReviewReply getReply() {
        return this.k;
    }

    @Nullable
    public final Long getReviewId() {
        return this.b;
    }

    @NotNull
    public final ReviewStatus getReviewStatus() {
        return this.o;
    }

    @Nullable
    public final String getReviewStatusText() {
        return this.n;
    }

    @Nullable
    public final Float getScore() {
        return this.d;
    }

    @Nullable
    public final String getStage() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final void setExpanded(boolean z) {
        this.p = z;
    }

    public final void setReply(@Nullable ReviewReply reviewReply) {
        this.k = reviewReply;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Long l2 = this.b;
        if (l2 != null) {
            a.I0(parcel, 1, l2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.c);
        Float f2 = this.d;
        if (f2 != null) {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.e, i2);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        Boolean bool = this.j;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.k, i2);
        parcel.writeString(this.l);
        parcel.writeParcelable(this.m, i2);
        parcel.writeString(this.n);
        parcel.writeString(this.o.name());
        parcel.writeInt(this.p ? 1 : 0);
        List<TnsGalleryImage> list = this.q;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((TnsGalleryImage) l0.next(), i2);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public UserProfileCommentItem(@NotNull String str, @Nullable Long l2, @NotNull String str2, @Nullable Float f2, @Nullable Image image, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, @Nullable ReviewReply reviewReply, @Nullable String str7, @Nullable RecipientData recipientData, @Nullable String str8, @NotNull ReviewStatus reviewStatus, boolean z, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(reviewStatus, "reviewStatus");
        this.a = str;
        this.b = l2;
        this.c = str2;
        this.d = f2;
        this.e = image;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = bool;
        this.k = reviewReply;
        this.l = str7;
        this.m = recipientData;
        this.n = str8;
        this.o = reviewStatus;
        this.p = z;
        this.q = list;
    }
}
