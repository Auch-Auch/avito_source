package com.avito.android.remote.model.user_reviews;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.remote.model.review_reply.ReviewReplyResult;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B­\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102¢\u0006\u0004\b8\u00109R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001e\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001e\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001e\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R$\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/remote/model/user_reviews/RatingElement;", "Lcom/avito/android/remote/model/user_reviews/ReviewElement;", "", "rated", "Ljava/lang/String;", "getRated", "()Ljava/lang/String;", "createdAt", "getCreatedAt", "stageTitle", "getStageTitle", "statusText", "getStatusText", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "answer", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "getAnswer", "()Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "Lcom/avito/android/remote/model/user_reviews/Recipient;", "recipient", "Lcom/avito/android/remote/model/user_reviews/Recipient;", "getRecipient", "()Lcom/avito/android/remote/model/user_reviews/Recipient;", "itemTitle", "getItemTitle", "", "score", "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "", "reviewId", "Ljava/lang/Long;", "getReviewId", "()Ljava/lang/Long;", "rejectMessage", "getRejectMessage", "text", "getText", "title", "getTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "status", "getStatus", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/user_reviews/Recipient;Ljava/util/List;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingElement implements ReviewElement {
    @SerializedName("answer")
    @Nullable
    private final ReviewReplyResult answer;
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("createdAt")
    @Nullable
    private final String createdAt;
    @SerializedName("images")
    @Nullable
    private final List<TnsGalleryImage> images;
    @SerializedName("itemTitle")
    @Nullable
    private final String itemTitle;
    @SerializedName("rated")
    @Nullable
    private final String rated;
    @SerializedName("recipient")
    @Nullable
    private final Recipient recipient;
    @SerializedName("rejectMessage")
    @Nullable
    private final String rejectMessage;
    @SerializedName("id")
    @Nullable
    private final Long reviewId;
    @SerializedName("score")
    @Nullable
    private final Float score;
    @SerializedName("stageTitle")
    @Nullable
    private final String stageTitle;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("statusText")
    @Nullable
    private final String statusText;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("text")
    @Nullable
    private final String text;
    @SerializedName("title")
    @NotNull
    private final String title;

    public RatingElement(@Nullable Long l, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Float f, @Nullable String str5, @Nullable Image image, @Nullable String str6, @Nullable ReviewReplyResult reviewReplyResult, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Recipient recipient2, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.reviewId = l;
        this.title = str;
        this.subtitle = str2;
        this.itemTitle = str3;
        this.stageTitle = str4;
        this.score = f;
        this.rated = str5;
        this.avatar = image;
        this.text = str6;
        this.answer = reviewReplyResult;
        this.status = str7;
        this.statusText = str8;
        this.createdAt = str9;
        this.rejectMessage = str10;
        this.recipient = recipient2;
        this.images = list;
    }

    @Nullable
    public final ReviewReplyResult getAnswer() {
        return this.answer;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.images;
    }

    @Nullable
    public final String getItemTitle() {
        return this.itemTitle;
    }

    @Nullable
    public final String getRated() {
        return this.rated;
    }

    @Nullable
    public final Recipient getRecipient() {
        return this.recipient;
    }

    @Nullable
    public final String getRejectMessage() {
        return this.rejectMessage;
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
    public final String getStageTitle() {
        return this.stageTitle;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getStatusText() {
        return this.statusText;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
