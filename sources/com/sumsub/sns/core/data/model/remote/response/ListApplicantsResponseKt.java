package com.sumsub.sns.core.data.model.remote.response;

import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.ReviewAnswerType;
import com.sumsub.sns.core.data.model.ReviewRejectType;
import com.sumsub.sns.core.data.model.ReviewStatusType;
import com.sumsub.sns.core.data.model.remote.Metavalue;
import com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0012\u001a\u00020\u0011*\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u001b\u001a\u00020\u001a*\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem;", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "toDocSetsItem", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem;)Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "toRequiredIdDocs", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;)Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "toResult", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;)Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "toReview", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;)Lcom/sumsub/sns/core/data/model/Applicant$Review;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "toInfo", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;)Lcom/sumsub/sns/core/data/model/Applicant$Info;", "", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "Lcom/sumsub/sns/core/data/model/Applicant$MetaValue;", "toApplicantMetadata", "(Ljava/util/List;)Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "Lcom/sumsub/sns/core/data/model/Applicant;", "toApplicant", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;)Lcom/sumsub/sns/core/data/model/Applicant;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class ListApplicantsResponseKt {
    @NotNull
    public static final Applicant toApplicant(@NotNull ListApplicantsResponse.Data.Item item) {
        Intrinsics.checkNotNullParameter(item, "$this$toApplicant");
        String id = item.getId();
        String type = item.getType();
        String clientId = item.getClientId();
        String createdAt = item.getCreatedAt();
        String inspectionId = item.getInspectionId();
        Applicant.RequiredIdDocs requiredIdDocs = toRequiredIdDocs(item.getRequiredIdDocs());
        String externalUserId = item.getExternalUserId();
        Applicant.Review review = toReview(item.getReview());
        String env = item.getEnv();
        ListApplicantsResponse.Data.Info info = item.getInfo();
        Applicant.Info info2 = info != null ? toInfo(info) : null;
        String lang = item.getLang();
        List<Metavalue> metadata = item.getMetadata();
        return new Applicant(id, type, clientId, createdAt, inspectionId, requiredIdDocs, externalUserId, review, env, info2, lang, metadata != null ? toApplicantMetadata(metadata) : null, item.getEmail());
    }

    @NotNull
    public static final List<Applicant.MetaValue> toApplicantMetadata(@NotNull List<Metavalue> list) {
        Intrinsics.checkNotNullParameter(list, "$this$toApplicantMetadata");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String key = t.getKey();
            String value = t.getValue();
            if (value == null) {
                value = "";
            }
            arrayList.add(new Applicant.MetaValue(key, value));
        }
        return arrayList;
    }

    @NotNull
    public static final Applicant.RequiredIdDocs.DocSetsItem toDocSetsItem(@NotNull ListApplicantsResponse.Data.RequiredIdDocs.DocSetsItem docSetsItem) {
        Intrinsics.checkNotNullParameter(docSetsItem, "$this$toDocSetsItem");
        DocumentType create = DocumentType.Companion.create(docSetsItem.getIdDocSetType());
        List<String> types = docSetsItem.getTypes();
        if (types == null) {
            types = CollectionsKt__CollectionsKt.emptyList();
        }
        List<IdentitySide> sides = docSetsItem.getSides();
        if (sides == null) {
            sides = CollectionsKt__CollectionsKt.emptyList();
        }
        return new Applicant.RequiredIdDocs.DocSetsItem(create, types, sides, docSetsItem.getVideoRequired(), docSetsItem.getFields(), docSetsItem.getCustomFields());
    }

    @NotNull
    public static final Applicant.Info toInfo(@NotNull ListApplicantsResponse.Data.Info info) {
        Intrinsics.checkNotNullParameter(info, "$this$toInfo");
        return new Applicant.Info(info.getCountry(), info.getFirstName(), info.getLastName(), info.getMiddleName(), info.getLegalName(), info.getGender(), info.getDob(), info.getPlaceOfBirth(), info.getCountryOfBirth(), info.getStateOfBirth(), info.getNationality(), info.getPhone(), info.getAddresses());
    }

    @NotNull
    public static final Applicant.RequiredIdDocs toRequiredIdDocs(@NotNull ListApplicantsResponse.Data.RequiredIdDocs requiredIdDocs) {
        List list;
        Intrinsics.checkNotNullParameter(requiredIdDocs, "$this$toRequiredIdDocs");
        List<ListApplicantsResponse.Data.RequiredIdDocs.DocSetsItem> docSets = requiredIdDocs.getDocSets();
        if (docSets != null) {
            list = new ArrayList(e.collectionSizeOrDefault(docSets, 10));
            Iterator<T> it = docSets.iterator();
            while (it.hasNext()) {
                list.add(toDocSetsItem(it.next()));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> includedCountries = requiredIdDocs.getIncludedCountries();
        HashSet hashSet = null;
        HashSet hashSet2 = includedCountries != null ? CollectionsKt___CollectionsKt.toHashSet(includedCountries) : null;
        List<String> excludedCountries = requiredIdDocs.getExcludedCountries();
        if (excludedCountries != null) {
            hashSet = CollectionsKt___CollectionsKt.toHashSet(excludedCountries);
        }
        return new Applicant.RequiredIdDocs(list, hashSet2, hashSet);
    }

    @NotNull
    public static final Applicant.Review.Result toResult(@NotNull ListApplicantsResponse.Data.Review.Result result) {
        Intrinsics.checkNotNullParameter(result, "$this$toResult");
        String moderationComment = result.getModerationComment();
        String clientComment = result.getClientComment();
        ReviewAnswerType reviewAnswer = result.getReviewAnswer();
        if (reviewAnswer == null) {
            reviewAnswer = ReviewAnswerType.Unknown;
        }
        List<String> rejectLabels = result.getRejectLabels();
        if (rejectLabels == null) {
            rejectLabels = CollectionsKt__CollectionsKt.emptyList();
        }
        ReviewRejectType reviewRejectType = result.getReviewRejectType();
        if (reviewRejectType == null) {
            reviewRejectType = ReviewRejectType.Unknown;
        }
        return new Applicant.Review.Result(moderationComment, clientComment, reviewAnswer, rejectLabels, reviewRejectType);
    }

    @NotNull
    public static final Applicant.Review toReview(@NotNull ListApplicantsResponse.Data.Review review) {
        Intrinsics.checkNotNullParameter(review, "$this$toReview");
        Integer notificationFailureCnt = review.getNotificationFailureCnt();
        ReviewStatusType reviewStatus = review.getReviewStatus();
        if (reviewStatus == null) {
            reviewStatus = ReviewStatusType.Unknown;
        }
        Integer priority = review.getPriority();
        String createDate = review.getCreateDate();
        ListApplicantsResponse.Data.Review.Result result = review.getResult();
        return new Applicant.Review(notificationFailureCnt, reviewStatus, priority, createDate, result != null ? toResult(result) : null);
    }
}
