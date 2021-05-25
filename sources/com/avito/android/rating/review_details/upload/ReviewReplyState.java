package com.avito.android.rating.review_details.upload;

import a2.b.a.a.a;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "", "Lcom/avito/android/ratings/ReviewData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ratings/ReviewData;", "getReview", "()Lcom/avito/android/ratings/ReviewData;", AvatarStatus.REVIEW, "Error", "Loading", "Result", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Result;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Loading;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Error;", "rating_release"}, k = 1, mv = {1, 4, 2})
public abstract class ReviewReplyState {
    @NotNull
    public final ReviewData a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Error;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "Lcom/avito/android/ratings/ReviewData;", "component1", "()Lcom/avito/android/ratings/ReviewData;", "", "component2", "()Ljava/lang/Throwable;", "reviewData", "error", "copy", "(Lcom/avito/android/ratings/ReviewData;Ljava/lang/Throwable;)Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ratings/ReviewData;", "getReviewData", "c", "Ljava/lang/Throwable;", "getError", "<init>", "(Lcom/avito/android/ratings/ReviewData;Ljava/lang/Throwable;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends ReviewReplyState {
        @NotNull
        public final ReviewData b;
        @NotNull
        public final Throwable c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull ReviewData reviewData, @NotNull Throwable th) {
            super(reviewData, null);
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            Intrinsics.checkNotNullParameter(th, "error");
            this.b = reviewData;
            this.c = th;
        }

        public static /* synthetic */ Error copy$default(Error error, ReviewData reviewData, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                reviewData = error.b;
            }
            if ((i & 2) != 0) {
                th = error.c;
            }
            return error.copy(reviewData, th);
        }

        @NotNull
        public final ReviewData component1() {
            return this.b;
        }

        @NotNull
        public final Throwable component2() {
            return this.c;
        }

        @NotNull
        public final Error copy(@NotNull ReviewData reviewData, @NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            Intrinsics.checkNotNullParameter(th, "error");
            return new Error(reviewData, th);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.b, error.b) && Intrinsics.areEqual(this.c, error.c);
        }

        @NotNull
        public final Throwable getError() {
            return this.c;
        }

        @NotNull
        public final ReviewData getReviewData() {
            return this.b;
        }

        public int hashCode() {
            ReviewData reviewData = this.b;
            int i = 0;
            int hashCode = (reviewData != null ? reviewData.hashCode() : 0) * 31;
            Throwable th = this.c;
            if (th != null) {
                i = th.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Error(reviewData=");
            L.append(this.b);
            L.append(", error=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Loading;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "Lcom/avito/android/ratings/ReviewData;", "component1", "()Lcom/avito/android/ratings/ReviewData;", "reviewData", "copy", "(Lcom/avito/android/ratings/ReviewData;)Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Loading;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ratings/ReviewData;", "getReviewData", "<init>", "(Lcom/avito/android/ratings/ReviewData;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends ReviewReplyState {
        @NotNull
        public final ReviewData b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loading(@NotNull ReviewData reviewData) {
            super(reviewData, null);
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            this.b = reviewData;
        }

        public static /* synthetic */ Loading copy$default(Loading loading, ReviewData reviewData, int i, Object obj) {
            if ((i & 1) != 0) {
                reviewData = loading.b;
            }
            return loading.copy(reviewData);
        }

        @NotNull
        public final ReviewData component1() {
            return this.b;
        }

        @NotNull
        public final Loading copy(@NotNull ReviewData reviewData) {
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            return new Loading(reviewData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Loading) && Intrinsics.areEqual(this.b, ((Loading) obj).b);
            }
            return true;
        }

        @NotNull
        public final ReviewData getReviewData() {
            return this.b;
        }

        public int hashCode() {
            ReviewData reviewData = this.b;
            if (reviewData != null) {
                return reviewData.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Loading(reviewData=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Result;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "Lcom/avito/android/ratings/ReviewData;", "component1", "()Lcom/avito/android/ratings/ReviewData;", "", "component2", "()Ljava/lang/String;", "reviewData", "message", "copy", "(Lcom/avito/android/ratings/ReviewData;Ljava/lang/String;)Lcom/avito/android/rating/review_details/upload/ReviewReplyState$Result;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getMessage", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ratings/ReviewData;", "getReviewData", "<init>", "(Lcom/avito/android/ratings/ReviewData;Ljava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result extends ReviewReplyState {
        @NotNull
        public final ReviewData b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Result(@NotNull ReviewData reviewData, @NotNull String str) {
            super(reviewData, null);
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            Intrinsics.checkNotNullParameter(str, "message");
            this.b = reviewData;
            this.c = str;
        }

        public static /* synthetic */ Result copy$default(Result result, ReviewData reviewData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                reviewData = result.b;
            }
            if ((i & 2) != 0) {
                str = result.c;
            }
            return result.copy(reviewData, str);
        }

        @NotNull
        public final ReviewData component1() {
            return this.b;
        }

        @NotNull
        public final String component2() {
            return this.c;
        }

        @NotNull
        public final Result copy(@NotNull ReviewData reviewData, @NotNull String str) {
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            Intrinsics.checkNotNullParameter(str, "message");
            return new Result(reviewData, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual(this.b, result.b) && Intrinsics.areEqual(this.c, result.c);
        }

        @NotNull
        public final String getMessage() {
            return this.c;
        }

        @NotNull
        public final ReviewData getReviewData() {
            return this.b;
        }

        public int hashCode() {
            ReviewData reviewData = this.b;
            int i = 0;
            int hashCode = (reviewData != null ? reviewData.hashCode() : 0) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Result(reviewData=");
            L.append(this.b);
            L.append(", message=");
            return a.t(L, this.c, ")");
        }
    }

    public ReviewReplyState(ReviewData reviewData, j jVar) {
        this.a = reviewData;
    }

    @NotNull
    public final ReviewData getReview() {
        return this.a;
    }
}
