package com.avito.android.remote.model.rating_details;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.remote.model.rating_details.RatingDetailsElement;
import com.avito.android.remote.model.review_reply.ReviewReplyResult;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u00020\u0001:\u00017Bu\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010/\u001a\u00020\u0018\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u00101\u001a\u0004\u0018\u00010\u0018\u0012\b\u00103\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0004\b5\u00106J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR$\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001cR\u001e\u00101\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u001cR\u001e\u00103\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/rating_details/CommentElement;", "Lcom/avito/android/remote/model/rating_details/RatingDetailsElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "canReply", "Ljava/lang/Boolean;", "getCanReply", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "", "score", "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "", "rated", "Ljava/lang/String;", "getRated", "()Ljava/lang/String;", "text", "getText", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "", "reviewId", "Ljava/lang/Long;", "getReviewId", "()Ljava/lang/Long;", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "reply", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "getReply", "()Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "title", "getTitle", "stage", "getStage", "item", "getItem", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;Ljava/util/List;)V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class CommentElement implements RatingDetailsElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CommentElement> CREATOR = Parcels.creator(CommentElement$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("canAnswer")
    @Nullable
    private final Boolean canReply;
    @SerializedName("images")
    @Nullable
    private final List<TnsGalleryImage> images;
    @SerializedName("itemTitle")
    @Nullable
    private final String item;
    @SerializedName("rated")
    @NotNull
    private final String rated;
    @SerializedName("answer")
    @Nullable
    private final ReviewReplyResult reply;
    @SerializedName("id")
    @Nullable
    private final Long reviewId;
    @SerializedName("score")
    @Nullable
    private final Float score;
    @SerializedName("stageTitle")
    @Nullable
    private final String stage;
    @SerializedName("text")
    @NotNull
    private final String text;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/rating_details/CommentElement$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/rating_details/CommentElement;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public CommentElement(@Nullable Long l, @NotNull String str, @Nullable Float f, @NotNull String str2, @Nullable Image image, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable ReviewReplyResult reviewReplyResult, @Nullable List<TnsGalleryImage> list) {
        a.Z0(str, "title", str2, "rated", str3, "text");
        this.reviewId = l;
        this.title = str;
        this.score = f;
        this.rated = str2;
        this.avatar = image;
        this.text = str3;
        this.stage = str4;
        this.item = str5;
        this.canReply = bool;
        this.reply = reviewReplyResult;
        this.images = list;
    }

    @Override // com.avito.android.remote.model.rating_details.RatingDetailsElement, android.os.Parcelable
    public int describeContents() {
        return RatingDetailsElement.DefaultImpls.describeContents(this);
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Boolean getCanReply() {
        return this.canReply;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.images;
    }

    @Nullable
    public final String getItem() {
        return this.item;
    }

    @NotNull
    public final String getRated() {
        return this.rated;
    }

    @Nullable
    public final ReviewReplyResult getReply() {
        return this.reply;
    }

    @Nullable
    public final Long getReviewId() {
        return this.reviewId;
    }

    @Nullable
    public final Float getScore() {
        return this.score;
    }

    @Nullable
    public final String getStage() {
        return this.stage;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeNullableValue(parcel, this.reviewId);
        parcel.writeString(this.title);
        ParcelsKt.writeNullableValue(parcel, this.score);
        parcel.writeString(this.rated);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.text);
        parcel.writeString(this.stage);
        parcel.writeString(this.item);
        ParcelsKt.writeNullableValue(parcel, this.canReply);
        parcel.writeParcelable(this.reply, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.images, i);
    }
}
