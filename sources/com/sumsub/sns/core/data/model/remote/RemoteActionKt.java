package com.sumsub.sns.core.data.model.remote;

import com.sumsub.sns.core.data.model.Action;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.remote.RemoteAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs$DocSetsItem;", "Lcom/sumsub/sns/core/data/model/Action$DocSetsItem;", "toDocSetsItem", "(Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs$DocSetsItem;)Lcom/sumsub/sns/core/data/model/Action$DocSetsItem;", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "Lcom/sumsub/sns/core/data/model/Action$Review;", "toReview", "(Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;)Lcom/sumsub/sns/core/data/model/Action$Review;", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction;", "Lcom/sumsub/sns/core/data/model/Action;", "toAction", "(Lcom/sumsub/sns/core/data/model/remote/RemoteAction;)Lcom/sumsub/sns/core/data/model/Action;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class RemoteActionKt {
    @NotNull
    public static final Action toAction(@NotNull RemoteAction remoteAction) {
        Intrinsics.checkNotNullParameter(remoteAction, "$this$toAction");
        String id = remoteAction.getId();
        String applicantId = remoteAction.getApplicantId();
        FlowActionType type = remoteAction.getType();
        String createdAt = remoteAction.getCreatedAt();
        String externalActionId = remoteAction.getExternalActionId();
        List<RemoteAction.RequiredIdDocs.DocSetsItem> docSets = remoteAction.getRequiredIdDocs().getDocSets();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(docSets, 10));
        Iterator<T> it = docSets.iterator();
        while (it.hasNext()) {
            arrayList.add(toDocSetsItem(it.next()));
        }
        return new Action(id, applicantId, type, createdAt, externalActionId, arrayList, toReview(remoteAction.getReview()));
    }

    @NotNull
    public static final Action.DocSetsItem toDocSetsItem(@NotNull RemoteAction.RequiredIdDocs.DocSetsItem docSetsItem) {
        Intrinsics.checkNotNullParameter(docSetsItem, "$this$toDocSetsItem");
        return new Action.DocSetsItem(docSetsItem.getIdDocSetType(), docSetsItem.getTypes(), docSetsItem.m237getVideoRequiredu2aduso(), null);
    }

    @NotNull
    public static final Action.Review toReview(@NotNull RemoteAction.Review review) {
        Intrinsics.checkNotNullParameter(review, "$this$toReview");
        return new Action.Review(review.getReprocessing(), review.getNotificationFailureCnt(), review.getReviewStatus(), review.getAutoChecked(), review.getCreateDate());
    }
}
