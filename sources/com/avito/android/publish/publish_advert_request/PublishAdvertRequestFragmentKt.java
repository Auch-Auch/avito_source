package com.avito.android.publish.publish_advert_request;

import android.os.Bundle;
import com.avito.android.publish.drafts.db.LocalDraftTypeAdapterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "draftId", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestFragment;", "createPublishAdvertRequestFragment", "(Ljava/lang/String;)Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestFragment;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishAdvertRequestFragmentKt {
    @NotNull
    public static final PublishAdvertRequestFragment createPublishAdvertRequestFragment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        PublishAdvertRequestFragment publishAdvertRequestFragment = new PublishAdvertRequestFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(LocalDraftTypeAdapterKt.DRAFT_ID, str);
        Unit unit = Unit.INSTANCE;
        publishAdvertRequestFragment.setArguments(bundle);
        return publishAdvertRequestFragment;
    }
}
