package com.sumsub.sns.core.data.model.remote;

import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;", "Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "toReviewResult", "(Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ReviewResult;)Lcom/sumsub/sns/core/data/model/Document$Result$Review;", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc;", "Lcom/sumsub/sns/core/data/model/Document$Result;", "toRequiredDoc", "(Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc;)Lcom/sumsub/sns/core/data/model/Document$Result;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class RemoteRequiredDocKt {
    @NotNull
    public static final Document.Result toRequiredDoc(@NotNull RemoteRequiredDoc remoteRequiredDoc) {
        Map<Integer, RemoteRequiredDoc.ReviewResult> data;
        Intrinsics.checkNotNullParameter(remoteRequiredDoc, "$this$toRequiredDoc");
        RemoteRequiredDoc.ReviewResult reviewResult = remoteRequiredDoc.getReviewResult();
        LinkedHashMap linkedHashMap = null;
        Document.Result.Review reviewResult2 = reviewResult != null ? toReviewResult(reviewResult) : null;
        String country = remoteRequiredDoc.getCountry();
        String identity = remoteRequiredDoc.getIdentity();
        List<Integer> imageIds = remoteRequiredDoc.getImageIds();
        RemoteRequiredDoc.ImageReviewResult imageReviewResults = remoteRequiredDoc.getImageReviewResults();
        if (!(imageReviewResults == null || (data = imageReviewResults.getData()) == null)) {
            linkedHashMap = new LinkedHashMap(q.mapCapacity(data.size()));
            for (T t : data.entrySet()) {
                linkedHashMap.put(t.getKey(), toReviewResult((RemoteRequiredDoc.ReviewResult) t.getValue()));
            }
        }
        return new Document.Result(reviewResult2, country, identity, imageIds, linkedHashMap);
    }

    @NotNull
    public static final Document.Result.Review toReviewResult(@NotNull RemoteRequiredDoc.ReviewResult reviewResult) {
        Intrinsics.checkNotNullParameter(reviewResult, "$this$toReviewResult");
        return new Document.Result.Review(reviewResult.getAnswer(), reviewResult.getModerationComment(), reviewResult.getClientComment(), reviewResult.getRejectLabels());
    }
}
