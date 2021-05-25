package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001:\u000278BE\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\\\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010\u0004R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\bR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u0010\u0004¨\u00069"}, d2 = {"Lcom/sumsub/sns/core/data/model/Action;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component3", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "component4", "component5", "", "Lcom/sumsub/sns/core/data/model/Action$DocSetsItem;", "component6", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/Action$Review;", "component7", "()Lcom/sumsub/sns/core/data/model/Action$Review;", "id", "applicantId", "type", "createdAt", "externalActionId", "docSets", AvatarStatus.REVIEW, "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/core/data/model/Action$Review;)Lcom/sumsub/sns/core/data/model/Action;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getCreatedAt", g.a, "Lcom/sumsub/sns/core/data/model/Action$Review;", "getReview", AuthSource.BOOKING_ORDER, "getApplicantId", "f", "Ljava/util/List;", "getDocSets", "e", "getExternalActionId", "c", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getType", AuthSource.SEND_ABUSE, "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/core/data/model/Action$Review;)V", "DocSetsItem", "Review", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Action {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final FlowActionType c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final List<DocSetsItem> f;
    @NotNull
    public final Review g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/sumsub/sns/core/data/model/Action$DocSetsItem;", "", "Lcom/sumsub/sns/core/data/model/DocumentType;", "component1", "()Lcom/sumsub/sns/core/data/model/DocumentType;", "", "", "component2", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/VideoRequiredType;", "component3-u2aduso", "()Ljava/lang/String;", "component3", "idDocSetType", "types", "videoRequired", "copy-5BEKOTA", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/Action$DocSetsItem;", "copy", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/DocumentType;", "getIdDocSetType", "c", "Ljava/lang/String;", "getVideoRequired-u2aduso", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getTypes", "<init>", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/lang/String;Lt6/r/a/j;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class DocSetsItem {
        @NotNull
        public final DocumentType a;
        @NotNull
        public final List<String> b;
        @NotNull
        public final String c;

        public DocSetsItem(DocumentType documentType, List<String> list, String str) {
            this.a = documentType;
            this.b = list;
            this.c = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.Action$DocSetsItem */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-5BEKOTA$default  reason: not valid java name */
        public static /* synthetic */ DocSetsItem m191copy5BEKOTA$default(DocSetsItem docSetsItem, DocumentType documentType, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                documentType = docSetsItem.a;
            }
            if ((i & 2) != 0) {
                list = docSetsItem.b;
            }
            if ((i & 4) != 0) {
                str = docSetsItem.c;
            }
            return docSetsItem.m193copy5BEKOTA(documentType, list, str);
        }

        @NotNull
        public final DocumentType component1() {
            return this.a;
        }

        @NotNull
        public final List<String> component2() {
            return this.b;
        }

        @NotNull
        /* renamed from: component3-u2aduso  reason: not valid java name */
        public final String m192component3u2aduso() {
            return this.c;
        }

        @NotNull
        /* renamed from: copy-5BEKOTA  reason: not valid java name */
        public final DocSetsItem m193copy5BEKOTA(@NotNull DocumentType documentType, @NotNull List<String> list, @NotNull String str) {
            Intrinsics.checkNotNullParameter(documentType, "idDocSetType");
            Intrinsics.checkNotNullParameter(list, "types");
            Intrinsics.checkNotNullParameter(str, "videoRequired");
            return new DocSetsItem(documentType, list, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DocSetsItem)) {
                return false;
            }
            DocSetsItem docSetsItem = (DocSetsItem) obj;
            return Intrinsics.areEqual(this.a, docSetsItem.a) && Intrinsics.areEqual(this.b, docSetsItem.b) && Intrinsics.areEqual(VideoRequiredType.m222boximpl(this.c), VideoRequiredType.m222boximpl(docSetsItem.c));
        }

        @NotNull
        public final DocumentType getIdDocSetType() {
            return this.a;
        }

        @NotNull
        public final List<String> getTypes() {
            return this.b;
        }

        @NotNull
        /* renamed from: getVideoRequired-u2aduso  reason: not valid java name */
        public final String m194getVideoRequiredu2aduso() {
            return this.c;
        }

        public int hashCode() {
            DocumentType documentType = this.a;
            int i = 0;
            int hashCode = (documentType != null ? documentType.hashCode() : 0) * 31;
            List<String> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DocSetsItem(idDocSetType=");
            L.append(this.a);
            L.append(", types=");
            L.append(this.b);
            L.append(", videoRequired=");
            L.append(VideoRequiredType.m227toStringimpl(this.c));
            L.append(")");
            return L.toString();
        }

        public DocSetsItem(DocumentType documentType, List list, String str, j jVar) {
            this.a = documentType;
            this.b = list;
            this.c = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/sumsub/sns/core/data/model/Action$Review;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "reprocessing", "notificationFailureCnt", "reviewStatus", "autoChecked", "createDate", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/Action$Review;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/Boolean;", "getAutoChecked", AuthSource.SEND_ABUSE, "getReprocessing", "c", "Ljava/lang/String;", "getReviewStatus", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getNotificationFailureCnt", "e", "getCreateDate", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Review {
        @Nullable
        public final Boolean a;
        @Nullable
        public final Integer b;
        @Nullable
        public final String c;
        @Nullable
        public final Boolean d;
        @Nullable
        public final String e;

        public Review(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable Boolean bool2, @Nullable String str2) {
            this.a = bool;
            this.b = num;
            this.c = str;
            this.d = bool2;
            this.e = str2;
        }

        public static /* synthetic */ Review copy$default(Review review, Boolean bool, Integer num, String str, Boolean bool2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = review.a;
            }
            if ((i & 2) != 0) {
                num = review.b;
            }
            if ((i & 4) != 0) {
                str = review.c;
            }
            if ((i & 8) != 0) {
                bool2 = review.d;
            }
            if ((i & 16) != 0) {
                str2 = review.e;
            }
            return review.copy(bool, num, str, bool2, str2);
        }

        @Nullable
        public final Boolean component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final Boolean component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        @NotNull
        public final Review copy(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable Boolean bool2, @Nullable String str2) {
            return new Review(bool, num, str, bool2, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Review)) {
                return false;
            }
            Review review = (Review) obj;
            return Intrinsics.areEqual(this.a, review.a) && Intrinsics.areEqual(this.b, review.b) && Intrinsics.areEqual(this.c, review.c) && Intrinsics.areEqual(this.d, review.d) && Intrinsics.areEqual(this.e, review.e);
        }

        @Nullable
        public final Boolean getAutoChecked() {
            return this.d;
        }

        @Nullable
        public final String getCreateDate() {
            return this.e;
        }

        @Nullable
        public final Integer getNotificationFailureCnt() {
            return this.b;
        }

        @Nullable
        public final Boolean getReprocessing() {
            return this.a;
        }

        @Nullable
        public final String getReviewStatus() {
            return this.c;
        }

        public int hashCode() {
            Boolean bool = this.a;
            int i = 0;
            int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.c;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Boolean bool2 = this.d;
            int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str2 = this.e;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Review(reprocessing=");
            L.append(this.a);
            L.append(", notificationFailureCnt=");
            L.append(this.b);
            L.append(", reviewStatus=");
            L.append(this.c);
            L.append(", autoChecked=");
            L.append(this.d);
            L.append(", createDate=");
            return a.t(L, this.e, ")");
        }
    }

    public Action(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType, @NotNull String str3, @NotNull String str4, @NotNull List<DocSetsItem> list, @NotNull Review review) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "applicantId");
        Intrinsics.checkNotNullParameter(flowActionType, "type");
        Intrinsics.checkNotNullParameter(str3, "createdAt");
        Intrinsics.checkNotNullParameter(str4, "externalActionId");
        Intrinsics.checkNotNullParameter(list, "docSets");
        Intrinsics.checkNotNullParameter(review, AvatarStatus.REVIEW);
        this.a = str;
        this.b = str2;
        this.c = flowActionType;
        this.d = str3;
        this.e = str4;
        this.f = list;
        this.g = review;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.sumsub.sns.core.data.model.Action */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Action copy$default(Action action, String str, String str2, FlowActionType flowActionType, String str3, String str4, List list, Review review, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action.a;
        }
        if ((i & 2) != 0) {
            str2 = action.b;
        }
        if ((i & 4) != 0) {
            flowActionType = action.c;
        }
        if ((i & 8) != 0) {
            str3 = action.d;
        }
        if ((i & 16) != 0) {
            str4 = action.e;
        }
        if ((i & 32) != 0) {
            list = action.f;
        }
        if ((i & 64) != 0) {
            review = action.g;
        }
        return action.copy(str, str2, flowActionType, str3, str4, list, review);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final FlowActionType component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final List<DocSetsItem> component6() {
        return this.f;
    }

    @NotNull
    public final Review component7() {
        return this.g;
    }

    @NotNull
    public final Action copy(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType, @NotNull String str3, @NotNull String str4, @NotNull List<DocSetsItem> list, @NotNull Review review) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "applicantId");
        Intrinsics.checkNotNullParameter(flowActionType, "type");
        Intrinsics.checkNotNullParameter(str3, "createdAt");
        Intrinsics.checkNotNullParameter(str4, "externalActionId");
        Intrinsics.checkNotNullParameter(list, "docSets");
        Intrinsics.checkNotNullParameter(review, AvatarStatus.REVIEW);
        return new Action(str, str2, flowActionType, str3, str4, list, review);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return Intrinsics.areEqual(this.a, action.a) && Intrinsics.areEqual(this.b, action.b) && Intrinsics.areEqual(this.c, action.c) && Intrinsics.areEqual(this.d, action.d) && Intrinsics.areEqual(this.e, action.e) && Intrinsics.areEqual(this.f, action.f) && Intrinsics.areEqual(this.g, action.g);
    }

    @NotNull
    public final String getApplicantId() {
        return this.b;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.d;
    }

    @NotNull
    public final List<DocSetsItem> getDocSets() {
        return this.f;
    }

    @NotNull
    public final String getExternalActionId() {
        return this.e;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final Review getReview() {
        return this.g;
    }

    @NotNull
    public final FlowActionType getType() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        FlowActionType flowActionType = this.c;
        int hashCode3 = (hashCode2 + (flowActionType != null ? flowActionType.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<DocSetsItem> list = this.f;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Review review = this.g;
        if (review != null) {
            i = review.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Action(id=");
        L.append(this.a);
        L.append(", applicantId=");
        L.append(this.b);
        L.append(", type=");
        L.append(this.c);
        L.append(", createdAt=");
        L.append(this.d);
        L.append(", externalActionId=");
        L.append(this.e);
        L.append(", docSets=");
        L.append(this.f);
        L.append(", review=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }
}
