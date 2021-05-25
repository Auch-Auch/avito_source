package com.avito.android.user_review;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010.\u001a\u0004\u0018\u00010)\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u00104\u001a\u0004\u0018\u00010/\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u001b\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00107\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b6\u0010\u000fR!\u0010>\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/user_review/UserReviewData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getStage", "()Ljava/lang/String;", "stage", "i", "getReviewStatus", "reviewStatus", "Lcom/avito/android/user_review/UserProfileData;", "j", "Lcom/avito/android/user_review/UserProfileData;", "getUserProfile", "()Lcom/avito/android/user_review/UserProfileData;", "userProfile", "f", "getItem", "item", g.a, "getRated", "rated", "h", "getRejectMessage", "rejectMessage", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "score", "", AuthSource.SEND_ABUSE, "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "id", "Lcom/avito/android/user_review/RecipientProfile;", "c", "Lcom/avito/android/user_review/RecipientProfile;", "getProfile", "()Lcom/avito/android/user_review/RecipientProfile;", "profile", "d", "getText", "text", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "k", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", "<init>", "(Ljava/lang/Long;Ljava/lang/Float;Lcom/avito/android/user_review/RecipientProfile;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_review/UserProfileData;Ljava/util/List;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewData implements Parcelable {
    public static final Parcelable.Creator<UserReviewData> CREATOR = new Creator();
    @Nullable
    public final Long a;
    @Nullable
    public final Float b;
    @Nullable
    public final RecipientProfile c;
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
    @Nullable
    public final UserProfileData j;
    @Nullable
    public final List<TnsGalleryImage> k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserReviewData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserReviewData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            Float valueOf2 = parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null;
            RecipientProfile createFromParcel = parcel.readInt() != 0 ? RecipientProfile.CREATOR.createFromParcel(parcel) : null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            UserProfileData createFromParcel2 = parcel.readInt() != 0 ? UserProfileData.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((TnsGalleryImage) parcel.readParcelable(UserReviewData.class.getClassLoader()));
                    readInt--;
                }
            }
            return new UserReviewData(valueOf, valueOf2, createFromParcel, readString, readString2, readString3, readString4, readString5, readString6, createFromParcel2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserReviewData[] newArray(int i) {
            return new UserReviewData[i];
        }
    }

    public UserReviewData(@Nullable Long l, @Nullable Float f2, @Nullable RecipientProfile recipientProfile, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable UserProfileData userProfileData, @Nullable List<TnsGalleryImage> list) {
        this.a = l;
        this.b = f2;
        this.c = recipientProfile;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = userProfileData;
        this.k = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Long getId() {
        return this.a;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.k;
    }

    @Nullable
    public final String getItem() {
        return this.f;
    }

    @Nullable
    public final RecipientProfile getProfile() {
        return this.c;
    }

    @Nullable
    public final String getRated() {
        return this.g;
    }

    @Nullable
    public final String getRejectMessage() {
        return this.h;
    }

    @Nullable
    public final String getReviewStatus() {
        return this.i;
    }

    @Nullable
    public final Float getScore() {
        return this.b;
    }

    @Nullable
    public final String getStage() {
        return this.e;
    }

    @Nullable
    public final String getText() {
        return this.d;
    }

    @Nullable
    public final UserProfileData getUserProfile() {
        return this.j;
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
        RecipientProfile recipientProfile = this.c;
        if (recipientProfile != null) {
            parcel.writeInt(1);
            recipientProfile.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        UserProfileData userProfileData = this.j;
        if (userProfileData != null) {
            parcel.writeInt(1);
            userProfileData.writeToParcel(parcel, 0);
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
    public /* synthetic */ UserReviewData(Long l, Float f2, RecipientProfile recipientProfile, String str, String str2, String str3, String str4, String str5, String str6, UserProfileData userProfileData, List list, int i2, j jVar) {
        this(l, f2, recipientProfile, str, str2, str3, str4, str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? null : userProfileData, (i2 & 1024) != 0 ? null : list);
    }
}
