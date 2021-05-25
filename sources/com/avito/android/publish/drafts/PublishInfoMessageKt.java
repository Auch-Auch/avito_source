package com.avito.android.publish.drafts;

import com.avito.android.remote.model.SaveDraftResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/SaveDraftResponse;", "Lcom/avito/android/publish/drafts/PublishInfoMessage;", "getInfoMessage", "(Lcom/avito/android/remote/model/SaveDraftResponse;)Lcom/avito/android/publish/drafts/PublishInfoMessage;", "publish-drafts_release"}, k = 2, mv = {1, 4, 2})
public final class PublishInfoMessageKt {
    @NotNull
    public static final PublishInfoMessage getInfoMessage(@NotNull SaveDraftResponse saveDraftResponse) {
        Intrinsics.checkNotNullParameter(saveDraftResponse, "$this$getInfoMessage");
        if (saveDraftResponse instanceof SaveDraftResponse.Ok) {
            SaveDraftResponse.Ok ok = (SaveDraftResponse.Ok) saveDraftResponse;
            return new PublishInfoMessage(ok.getDraft().getId(), ok.getMessage(), null, 4, null);
        } else if (saveDraftResponse instanceof SaveDraftResponse.Conflict) {
            return new PublishInfoMessage(null, null, ((SaveDraftResponse.Conflict) saveDraftResponse).getDialogInfo(), 3, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
