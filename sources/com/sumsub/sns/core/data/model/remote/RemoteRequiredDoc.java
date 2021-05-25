package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.data.model.ReviewAnswerType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0002)*B=\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u000f¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc;", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "component1", "()Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "", "component2", "()Ljava/lang/String;", "component3", "", "", "component4", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "component5", "()Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "reviewResult", "country", "identity", "imageIds", "imageReviewResults", "copy", "(Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;)Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentity", "Ljava/util/List;", "getImageIds", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "getReviewResult", "getCountry", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "getImageReviewResults", "<init>", "(Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;)V", "ImageReviewResult", "ReviewResult", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteRequiredDoc {
    @SerializedName("country")
    @Nullable
    private final String country;
    @SerializedName("idDocType")
    @Nullable
    private final String identity;
    @SerializedName("imageIds")
    @NotNull
    private final List<Integer> imageIds;
    @SerializedName("imageReviewResults")
    @Nullable
    private final ImageReviewResult imageReviewResults;
    @SerializedName("reviewResult")
    @Nullable
    private final ReviewResult reviewResult;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "", "", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "component1", "()Ljava/util/Map;", "data", "copy", "(Ljava/util/Map;)Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getData", "<init>", "(Ljava/util/Map;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageReviewResult {
        @NotNull
        public final Map<Integer, ReviewResult> a;

        public ImageReviewResult(@NotNull Map<Integer, ReviewResult> map) {
            Intrinsics.checkNotNullParameter(map, "data");
            this.a = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc$ImageReviewResult */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ImageReviewResult copy$default(ImageReviewResult imageReviewResult, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = imageReviewResult.a;
            }
            return imageReviewResult.copy(map);
        }

        @NotNull
        public final Map<Integer, ReviewResult> component1() {
            return this.a;
        }

        @NotNull
        public final ImageReviewResult copy(@NotNull Map<Integer, ReviewResult> map) {
            Intrinsics.checkNotNullParameter(map, "data");
            return new ImageReviewResult(map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ImageReviewResult) && Intrinsics.areEqual(this.a, ((ImageReviewResult) obj).a);
            }
            return true;
        }

        @NotNull
        public final Map<Integer, ReviewResult> getData() {
            return this.a;
        }

        public int hashCode() {
            Map<Integer, ReviewResult> map = this.a;
            if (map != null) {
                return map.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.x(a.L("ImageReviewResult(data="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "component1", "()Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/util/List;", "answer", "moderationComment", "clientComment", "rejectLabels", "copy", "(Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "getAnswer", "Ljava/lang/String;", "getModerationComment", "getClientComment", "Ljava/util/List;", "getRejectLabels", "<init>", "(Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReviewResult {
        @SerializedName("reviewAnswer")
        @Nullable
        private final ReviewAnswerType answer;
        @SerializedName("clientComment")
        @Nullable
        private final String clientComment;
        @SerializedName("moderationComment")
        @Nullable
        private final String moderationComment;
        @SerializedName("rejectLabels")
        @Nullable
        private final List<String> rejectLabels;

        public ReviewResult(@Nullable ReviewAnswerType reviewAnswerType, @Nullable String str, @Nullable String str2, @Nullable List<String> list) {
            this.answer = reviewAnswerType;
            this.moderationComment = str;
            this.clientComment = str2;
            this.rejectLabels = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc$ReviewResult */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReviewResult copy$default(ReviewResult reviewResult, ReviewAnswerType reviewAnswerType, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                reviewAnswerType = reviewResult.answer;
            }
            if ((i & 2) != 0) {
                str = reviewResult.moderationComment;
            }
            if ((i & 4) != 0) {
                str2 = reviewResult.clientComment;
            }
            if ((i & 8) != 0) {
                list = reviewResult.rejectLabels;
            }
            return reviewResult.copy(reviewAnswerType, str, str2, list);
        }

        @Nullable
        public final ReviewAnswerType component1() {
            return this.answer;
        }

        @Nullable
        public final String component2() {
            return this.moderationComment;
        }

        @Nullable
        public final String component3() {
            return this.clientComment;
        }

        @Nullable
        public final List<String> component4() {
            return this.rejectLabels;
        }

        @NotNull
        public final ReviewResult copy(@Nullable ReviewAnswerType reviewAnswerType, @Nullable String str, @Nullable String str2, @Nullable List<String> list) {
            return new ReviewResult(reviewAnswerType, str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReviewResult)) {
                return false;
            }
            ReviewResult reviewResult = (ReviewResult) obj;
            return Intrinsics.areEqual(this.answer, reviewResult.answer) && Intrinsics.areEqual(this.moderationComment, reviewResult.moderationComment) && Intrinsics.areEqual(this.clientComment, reviewResult.clientComment) && Intrinsics.areEqual(this.rejectLabels, reviewResult.rejectLabels);
        }

        @Nullable
        public final ReviewAnswerType getAnswer() {
            return this.answer;
        }

        @Nullable
        public final String getClientComment() {
            return this.clientComment;
        }

        @Nullable
        public final String getModerationComment() {
            return this.moderationComment;
        }

        @Nullable
        public final List<String> getRejectLabels() {
            return this.rejectLabels;
        }

        public int hashCode() {
            ReviewAnswerType reviewAnswerType = this.answer;
            int i = 0;
            int hashCode = (reviewAnswerType != null ? reviewAnswerType.hashCode() : 0) * 31;
            String str = this.moderationComment;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.clientComment;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<String> list = this.rejectLabels;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ReviewResult(answer=");
            L.append(this.answer);
            L.append(", moderationComment=");
            L.append(this.moderationComment);
            L.append(", clientComment=");
            L.append(this.clientComment);
            L.append(", rejectLabels=");
            return a.w(L, this.rejectLabels, ")");
        }
    }

    public RemoteRequiredDoc(@Nullable ReviewResult reviewResult2, @Nullable String str, @Nullable String str2, @NotNull List<Integer> list, @Nullable ImageReviewResult imageReviewResult) {
        Intrinsics.checkNotNullParameter(list, "imageIds");
        this.reviewResult = reviewResult2;
        this.country = str;
        this.identity = str2;
        this.imageIds = list;
        this.imageReviewResults = imageReviewResult;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteRequiredDoc copy$default(RemoteRequiredDoc remoteRequiredDoc, ReviewResult reviewResult2, String str, String str2, List list, ImageReviewResult imageReviewResult, int i, Object obj) {
        if ((i & 1) != 0) {
            reviewResult2 = remoteRequiredDoc.reviewResult;
        }
        if ((i & 2) != 0) {
            str = remoteRequiredDoc.country;
        }
        if ((i & 4) != 0) {
            str2 = remoteRequiredDoc.identity;
        }
        if ((i & 8) != 0) {
            list = remoteRequiredDoc.imageIds;
        }
        if ((i & 16) != 0) {
            imageReviewResult = remoteRequiredDoc.imageReviewResults;
        }
        return remoteRequiredDoc.copy(reviewResult2, str, str2, list, imageReviewResult);
    }

    @Nullable
    public final ReviewResult component1() {
        return this.reviewResult;
    }

    @Nullable
    public final String component2() {
        return this.country;
    }

    @Nullable
    public final String component3() {
        return this.identity;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.imageIds;
    }

    @Nullable
    public final ImageReviewResult component5() {
        return this.imageReviewResults;
    }

    @NotNull
    public final RemoteRequiredDoc copy(@Nullable ReviewResult reviewResult2, @Nullable String str, @Nullable String str2, @NotNull List<Integer> list, @Nullable ImageReviewResult imageReviewResult) {
        Intrinsics.checkNotNullParameter(list, "imageIds");
        return new RemoteRequiredDoc(reviewResult2, str, str2, list, imageReviewResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteRequiredDoc)) {
            return false;
        }
        RemoteRequiredDoc remoteRequiredDoc = (RemoteRequiredDoc) obj;
        return Intrinsics.areEqual(this.reviewResult, remoteRequiredDoc.reviewResult) && Intrinsics.areEqual(this.country, remoteRequiredDoc.country) && Intrinsics.areEqual(this.identity, remoteRequiredDoc.identity) && Intrinsics.areEqual(this.imageIds, remoteRequiredDoc.imageIds) && Intrinsics.areEqual(this.imageReviewResults, remoteRequiredDoc.imageReviewResults);
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getIdentity() {
        return this.identity;
    }

    @NotNull
    public final List<Integer> getImageIds() {
        return this.imageIds;
    }

    @Nullable
    public final ImageReviewResult getImageReviewResults() {
        return this.imageReviewResults;
    }

    @Nullable
    public final ReviewResult getReviewResult() {
        return this.reviewResult;
    }

    public int hashCode() {
        ReviewResult reviewResult2 = this.reviewResult;
        int i = 0;
        int hashCode = (reviewResult2 != null ? reviewResult2.hashCode() : 0) * 31;
        String str = this.country;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.identity;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Integer> list = this.imageIds;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        ImageReviewResult imageReviewResult = this.imageReviewResults;
        if (imageReviewResult != null) {
            i = imageReviewResult.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RemoteRequiredDoc(reviewResult=");
        L.append(this.reviewResult);
        L.append(", country=");
        L.append(this.country);
        L.append(", identity=");
        L.append(this.identity);
        L.append(", imageIds=");
        L.append(this.imageIds);
        L.append(", imageReviewResults=");
        L.append(this.imageReviewResults);
        L.append(")");
        return L.toString();
    }
}
