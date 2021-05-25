package com.avito.android.remote.model.rating_details_legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.rating_details_legacy.RatingDetailsElement;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/rating_details_legacy/RatingScoreElement;", "Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "scoreFloat", "Ljava/lang/Float;", "getScoreFloat", "()Ljava/lang/Float;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "score", "F", "getScore", "()F", "<init>", "(FLjava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingScoreElement implements RatingDetailsElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<RatingScoreElement> CREATOR = Parcels.creator(RatingScoreElement$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("score")
    private final float score;
    @SerializedName("scoreFloat")
    @Nullable
    private final Float scoreFloat;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/rating_details_legacy/RatingScoreElement$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/rating_details_legacy/RatingScoreElement;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public RatingScoreElement(float f, @Nullable Float f2, @Nullable String str, @Nullable String str2) {
        this.score = f;
        this.scoreFloat = f2;
        this.title = str;
        this.subtitle = str2;
    }

    @Override // com.avito.android.remote.model.rating_details_legacy.RatingDetailsElement, android.os.Parcelable
    public int describeContents() {
        return RatingDetailsElement.DefaultImpls.describeContents(this);
    }

    public final float getScore() {
        return this.score;
    }

    @Nullable
    public final Float getScoreFloat() {
        return this.scoreFloat;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeFloat(this.score);
        ParcelsKt.writeNullableValue(parcel, this.scoreFloat);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
    }
}
