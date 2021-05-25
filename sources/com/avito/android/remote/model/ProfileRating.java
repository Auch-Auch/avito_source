package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B-\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/ProfileRating;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/ProfileRatingAction;", "action", "Lcom/avito/android/remote/model/ProfileRatingAction;", "getAction", "()Lcom/avito/android/remote/model/ProfileRatingAction;", "", "score", "F", "getScore", "()F", "scoreFloat", "Ljava/lang/Float;", "getScoreFloat", "()Ljava/lang/Float;", "", "hideStars", "Ljava/lang/Boolean;", "getHideStars", "()Ljava/lang/Boolean;", "<init>", "(FLjava/lang/Float;Lcom/avito/android/remote/model/ProfileRatingAction;Ljava/lang/Boolean;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileRating implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ProfileRating> CREATOR = Parcels.creator(ProfileRating$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("action")
    @Nullable
    private final ProfileRatingAction action;
    @SerializedName("hideStars")
    @Nullable
    private final Boolean hideStars;
    @SerializedName("score")
    private final float score;
    @SerializedName("scoreFloat")
    @Nullable
    private final Float scoreFloat;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ProfileRating$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/ProfileRating;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ProfileRating(float f, @Nullable Float f2, @Nullable ProfileRatingAction profileRatingAction, @Nullable Boolean bool) {
        this.score = f;
        this.scoreFloat = f2;
        this.action = profileRatingAction;
        this.hideStars = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ProfileRatingAction getAction() {
        return this.action;
    }

    @Nullable
    public final Boolean getHideStars() {
        return this.hideStars;
    }

    public final float getScore() {
        return this.score;
    }

    @Nullable
    public final Float getScoreFloat() {
        return this.scoreFloat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeFloat(this.score);
        ParcelsKt.writeNullableValue(parcel, this.scoreFloat);
        parcel.writeParcelable(this.action, i);
        ParcelsKt.writeNullableValue(parcel, this.hideStars);
    }
}
