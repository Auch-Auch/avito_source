package com.avito.android.remote.model.review_reply;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/review_reply/AddReviewReplyResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "reply", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "getReply", "()Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class AddReviewReplyResult implements Parcelable {
    public static final Parcelable.Creator<AddReviewReplyResult> CREATOR = new Creator();
    @SerializedName("message")
    @NotNull
    private final String message;
    @SerializedName("answer")
    @NotNull
    private final ReviewReplyResult reply;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AddReviewReplyResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddReviewReplyResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AddReviewReplyResult(parcel.readString(), ReviewReplyResult.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddReviewReplyResult[] newArray(int i) {
            return new AddReviewReplyResult[i];
        }
    }

    public AddReviewReplyResult(@NotNull String str, @NotNull ReviewReplyResult reviewReplyResult) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(reviewReplyResult, "reply");
        this.message = str;
        this.reply = reviewReplyResult;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final ReviewReplyResult getReply() {
        return this.reply;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.message);
        this.reply.writeToParcel(parcel, 0);
    }
}
