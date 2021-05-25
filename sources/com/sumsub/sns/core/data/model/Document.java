package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0001/B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0015\u0010#\u001a\u0004\u0018\u00010 8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010$\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010\u0004R\u0015\u0010)\u001a\u0004\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u000eR\u0013\u0010*\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010%R\u0013\u0010+\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0013\u0010,\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010%¨\u00060"}, d2 = {"Lcom/sumsub/sns/core/data/model/Document;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/DocumentType;", "component1", "()Lcom/sumsub/sns/core/data/model/DocumentType;", "Lcom/sumsub/sns/core/data/model/Document$Result;", "component2", "()Lcom/sumsub/sns/core/data/model/Document$Result;", "type", "result", "copy", "(Lcom/sumsub/sns/core/data/model/DocumentType;Lcom/sumsub/sns/core/data/model/Document$Result;)Lcom/sumsub/sns/core/data/model/Document;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sumsub/sns/core/data/model/Document$Result;", "getResult", "Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "getReview", "()Lcom/sumsub/sns/core/data/model/Document$Result$Review;", AvatarStatus.REVIEW, "isApproved", "()Z", "Lcom/sumsub/sns/core/data/model/DocumentType;", "getType", "getCountry", "country", "isSubmitted", "isReviewing", "isRejected", "<init>", "(Lcom/sumsub/sns/core/data/model/DocumentType;Lcom/sumsub/sns/core/data/model/Document$Result;)V", "Result", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Document implements Parcelable {
    public static final Parcelable.Creator<Document> CREATOR = new Creator();
    @Nullable
    private final Result result;
    @NotNull
    private final DocumentType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Document> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Document createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Document(DocumentType.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Result.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Document[] newArray(int i) {
            return new Document[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u00016BI\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r¢\u0006\u0004\b4\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0004R'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010\u0007R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\f¨\u00067"}, d2 = {"Lcom/sumsub/sns/core/data/model/Document$Result;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "component1", "()Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "", "component2", "()Ljava/lang/String;", "component3", "", "", "component4", "()Ljava/util/List;", "", "component5", "()Ljava/util/Map;", AvatarStatus.REVIEW, "country", "identity", "imageIds", "imageResult", "copy", "(Lcom/sumsub/sns/core/data/model/Document$Result$Review;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lcom/sumsub/sns/core/data/model/Document$Result;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getIdentity", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "getReview", "e", "Ljava/util/Map;", "getImageResult", AuthSource.BOOKING_ORDER, "getCountry", "d", "Ljava/util/List;", "getImageIds", "<init>", "(Lcom/sumsub/sns/core/data/model/Document$Result$Review;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "Review", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        @Nullable
        public final Review a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @NotNull
        public final List<Integer> d;
        @Nullable
        public final Map<Integer, Review> e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Result> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Result createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                LinkedHashMap linkedHashMap = null;
                Review createFromParcel = parcel.readInt() != 0 ? Review.CREATOR.createFromParcel(parcel) : null;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    readInt--;
                }
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt2);
                    while (readInt2 != 0) {
                        linkedHashMap.put(Integer.valueOf(parcel.readInt()), Review.CREATOR.createFromParcel(parcel));
                        readInt2--;
                    }
                }
                return new Result(createFromParcel, readString, readString2, arrayList, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "component1", "()Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/util/List;", "answer", "moderationComment", "clientComment", "rejectLabels", "copy", "(Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getModerationComment", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "getAnswer", "d", "Ljava/util/List;", "getRejectLabels", "c", "getClientComment", "<init>", "(Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Review implements Parcelable {
            public static final Parcelable.Creator<Review> CREATOR = new Creator();
            @Nullable
            public final ReviewAnswerType a;
            @Nullable
            public final String b;
            @Nullable
            public final String c;
            @Nullable
            public final List<String> d;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Review> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Review createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Review(parcel.readInt() != 0 ? (ReviewAnswerType) Enum.valueOf(ReviewAnswerType.class, parcel.readString()) : null, parcel.readString(), parcel.readString(), parcel.createStringArrayList());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Review[] newArray(int i) {
                    return new Review[i];
                }
            }

            public Review(@Nullable ReviewAnswerType reviewAnswerType, @Nullable String str, @Nullable String str2, @Nullable List<String> list) {
                this.a = reviewAnswerType;
                this.b = str;
                this.c = str2;
                this.d = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.Document$Result$Review */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Review copy$default(Review review, ReviewAnswerType reviewAnswerType, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    reviewAnswerType = review.a;
                }
                if ((i & 2) != 0) {
                    str = review.b;
                }
                if ((i & 4) != 0) {
                    str2 = review.c;
                }
                if ((i & 8) != 0) {
                    list = review.d;
                }
                return review.copy(reviewAnswerType, str, str2, list);
            }

            @Nullable
            public final ReviewAnswerType component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @Nullable
            public final List<String> component4() {
                return this.d;
            }

            @NotNull
            public final Review copy(@Nullable ReviewAnswerType reviewAnswerType, @Nullable String str, @Nullable String str2, @Nullable List<String> list) {
                return new Review(reviewAnswerType, str, str2, list);
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
                if (!(obj instanceof Review)) {
                    return false;
                }
                Review review = (Review) obj;
                return Intrinsics.areEqual(this.a, review.a) && Intrinsics.areEqual(this.b, review.b) && Intrinsics.areEqual(this.c, review.c) && Intrinsics.areEqual(this.d, review.d);
            }

            @Nullable
            public final ReviewAnswerType getAnswer() {
                return this.a;
            }

            @Nullable
            public final String getClientComment() {
                return this.c;
            }

            @Nullable
            public final String getModerationComment() {
                return this.b;
            }

            @Nullable
            public final List<String> getRejectLabels() {
                return this.d;
            }

            @Override // java.lang.Object
            public int hashCode() {
                ReviewAnswerType reviewAnswerType = this.a;
                int i = 0;
                int hashCode = (reviewAnswerType != null ? reviewAnswerType.hashCode() : 0) * 31;
                String str = this.b;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.c;
                int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<String> list = this.d;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode3 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Review(answer=");
                L.append(this.a);
                L.append(", moderationComment=");
                L.append(this.b);
                L.append(", clientComment=");
                L.append(this.c);
                L.append(", rejectLabels=");
                return a.w(L, this.d, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                ReviewAnswerType reviewAnswerType = this.a;
                if (reviewAnswerType != null) {
                    parcel.writeInt(1);
                    parcel.writeString(reviewAnswerType.name());
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeString(this.b);
                parcel.writeString(this.c);
                parcel.writeStringList(this.d);
            }
        }

        public Result(@Nullable Review review, @Nullable String str, @Nullable String str2, @NotNull List<Integer> list, @Nullable Map<Integer, Review> map) {
            Intrinsics.checkNotNullParameter(list, "imageIds");
            this.a = review;
            this.b = str;
            this.c = str2;
            this.d = list;
            this.e = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.sumsub.sns.core.data.model.Document$Result */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Review review, String str, String str2, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                review = result.a;
            }
            if ((i & 2) != 0) {
                str = result.b;
            }
            if ((i & 4) != 0) {
                str2 = result.c;
            }
            if ((i & 8) != 0) {
                list = result.d;
            }
            if ((i & 16) != 0) {
                map = result.e;
            }
            return result.copy(review, str, str2, list, map);
        }

        @Nullable
        public final Review component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final List<Integer> component4() {
            return this.d;
        }

        @Nullable
        public final Map<Integer, Review> component5() {
            return this.e;
        }

        @NotNull
        public final Result copy(@Nullable Review review, @Nullable String str, @Nullable String str2, @NotNull List<Integer> list, @Nullable Map<Integer, Review> map) {
            Intrinsics.checkNotNullParameter(list, "imageIds");
            return new Result(review, str, str2, list, map);
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
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual(this.a, result.a) && Intrinsics.areEqual(this.b, result.b) && Intrinsics.areEqual(this.c, result.c) && Intrinsics.areEqual(this.d, result.d) && Intrinsics.areEqual(this.e, result.e);
        }

        @Nullable
        public final String getCountry() {
            return this.b;
        }

        @Nullable
        public final String getIdentity() {
            return this.c;
        }

        @NotNull
        public final List<Integer> getImageIds() {
            return this.d;
        }

        @Nullable
        public final Map<Integer, Review> getImageResult() {
            return this.e;
        }

        @Nullable
        public final Review getReview() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Review review = this.a;
            int i = 0;
            int hashCode = (review != null ? review.hashCode() : 0) * 31;
            String str = this.b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<Integer> list = this.d;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Integer, Review> map = this.e;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Result(review=");
            L.append(this.a);
            L.append(", country=");
            L.append(this.b);
            L.append(", identity=");
            L.append(this.c);
            L.append(", imageIds=");
            L.append(this.d);
            L.append(", imageResult=");
            return a.x(L, this.e, ")");
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
            /*
                r3 = this;
                java.lang.String r5 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
                com.sumsub.sns.core.data.model.Document$Result$Review r5 = r3.a
                r0 = 1
                r1 = 0
                if (r5 == 0) goto L_0x0012
                r4.writeInt(r0)
                r5.writeToParcel(r4, r1)
                goto L_0x0015
            L_0x0012:
                r4.writeInt(r1)
            L_0x0015:
                java.lang.String r5 = r3.b
                r4.writeString(r5)
                java.lang.String r5 = r3.c
                r4.writeString(r5)
                java.util.List<java.lang.Integer> r5 = r3.d
                java.util.Iterator r5 = a2.b.a.a.a.n0(r5, r4)
            L_0x0025:
                boolean r2 = r5.hasNext()
                if (r2 == 0) goto L_0x0039
                java.lang.Object r2 = r5.next()
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                r4.writeInt(r2)
                goto L_0x0025
            L_0x0039:
                java.util.Map<java.lang.Integer, com.sumsub.sns.core.data.model.Document$Result$Review> r5 = r3.e
                if (r5 == 0) goto L_0x0062
                java.util.Iterator r5 = a2.b.a.a.a.m0(r4, r0, r5)
            L_0x0041:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0065
                java.lang.Object r0 = r5.next()
                java.lang.Object r2 = r0.getKey()
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                r4.writeInt(r2)
                java.lang.Object r0 = r0.getValue()
                com.sumsub.sns.core.data.model.Document$Result$Review r0 = (com.sumsub.sns.core.data.model.Document.Result.Review) r0
                r0.writeToParcel(r4, r1)
                goto L_0x0041
            L_0x0062:
                r4.writeInt(r1)
            L_0x0065:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.Document.Result.writeToParcel(android.os.Parcel, int):void");
        }
    }

    public Document(@NotNull DocumentType documentType, @Nullable Result result2) {
        Intrinsics.checkNotNullParameter(documentType, "type");
        this.type = documentType;
        this.result = result2;
    }

    public static /* synthetic */ Document copy$default(Document document, DocumentType documentType, Result result2, int i, Object obj) {
        if ((i & 1) != 0) {
            documentType = document.type;
        }
        if ((i & 2) != 0) {
            result2 = document.result;
        }
        return document.copy(documentType, result2);
    }

    @NotNull
    public final DocumentType component1() {
        return this.type;
    }

    @Nullable
    public final Result component2() {
        return this.result;
    }

    @NotNull
    public final Document copy(@NotNull DocumentType documentType, @Nullable Result result2) {
        Intrinsics.checkNotNullParameter(documentType, "type");
        return new Document(documentType, result2);
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
        if (!(obj instanceof Document)) {
            return false;
        }
        Document document = (Document) obj;
        return Intrinsics.areEqual(this.type, document.type) && Intrinsics.areEqual(this.result, document.result);
    }

    @Nullable
    public final String getCountry() {
        Result result2 = this.result;
        if (result2 != null) {
            return result2.getCountry();
        }
        return null;
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    @Nullable
    public final Result.Review getReview() {
        Map<Integer, Result.Review> imageResult;
        Collection<Result.Review> values;
        boolean z;
        Result.Review review;
        Result result2 = this.result;
        T t = null;
        if (((result2 == null || (review = result2.getReview()) == null) ? null : review.getAnswer()) != null) {
            return this.result.getReview();
        }
        Result result3 = this.result;
        if (result3 == null || (imageResult = result3.getImageResult()) == null || (values = imageResult.values()) == null) {
            return null;
        }
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getAnswer() != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        return t;
    }

    @NotNull
    public final DocumentType getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DocumentType documentType = this.type;
        int i = 0;
        int hashCode = (documentType != null ? documentType.hashCode() : 0) * 31;
        Result result2 = this.result;
        if (result2 != null) {
            i = result2.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isApproved() {
        Boolean bool;
        Result.Review review;
        Map<Integer, Result.Review> imageResult;
        Collection<Result.Review> values;
        boolean z;
        Result result2 = this.result;
        boolean z2 = true;
        if (result2 == null || (imageResult = result2.getImageResult()) == null || (values = imageResult.values()) == null) {
            Result result3 = this.result;
            if (result3 == null || (review = result3.getReview()) == null) {
                bool = null;
            } else {
                if (review.getAnswer() != ReviewAnswerType.Green) {
                    z2 = false;
                }
                bool = Boolean.valueOf(z2);
            }
        } else {
            if (!values.isEmpty()) {
                Iterator<T> it = values.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getAnswer() == ReviewAnswerType.Green) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (!z) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            bool = Boolean.valueOf(z2);
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isRejected() {
        Boolean bool;
        Result.Review review;
        Map<Integer, Result.Review> imageResult;
        Collection<Result.Review> values;
        boolean z;
        Result result2 = this.result;
        boolean z2 = true;
        if (result2 == null || (imageResult = result2.getImageResult()) == null || (values = imageResult.values()) == null) {
            Result result3 = this.result;
            if (result3 == null || (review = result3.getReview()) == null) {
                bool = null;
            } else {
                if (review.getAnswer() != ReviewAnswerType.Red) {
                    z2 = false;
                }
                bool = Boolean.valueOf(z2);
            }
        } else {
            if (!values.isEmpty()) {
                Iterator<T> it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getAnswer() == ReviewAnswerType.Red) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                bool = Boolean.valueOf(z2);
            }
            z2 = false;
            bool = Boolean.valueOf(z2);
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isReviewing() {
        Map<Integer, Result.Review> imageResult;
        Collection<Result.Review> values;
        boolean z;
        Result result2 = this.result;
        if (!(result2 == null || (imageResult = result2.getImageResult()) == null || (values = imageResult.values()) == null || values.isEmpty())) {
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                if (it.next().getAnswer() == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSubmitted() {
        Result result2 = this.result;
        return (result2 != null ? result2.getReview() : null) != null;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Document(type=");
        L.append(this.type);
        L.append(", result=");
        L.append(this.result);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type.writeToParcel(parcel, 0);
        Result result2 = this.result;
        if (result2 != null) {
            parcel.writeInt(1);
            result2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
