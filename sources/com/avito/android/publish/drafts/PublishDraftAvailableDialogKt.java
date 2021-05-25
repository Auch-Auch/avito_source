package com.avito.android.publish.drafts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "sessionId", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "info", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "addToBackStack", "", "showPublishDraftAvailableDialogFragment", "(Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;Landroidx/fragment/app/FragmentManager;Z)V", "publish-drafts_release"}, k = 2, mv = {1, 4, 2})
public final class PublishDraftAvailableDialogKt {
    public static final void showPublishDraftAvailableDialogFragment(@NotNull String str, @NotNull DeepLinksDialogInfo deepLinksDialogInfo, @NotNull FragmentManager fragmentManager, boolean z) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "info");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("publish_draft_dialog");
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        if (z) {
            beginTransaction.addToBackStack(null);
        }
        PublishDraftAvailableDialog.Companion.getInstance(DeepLinksDialogInfo.copy$default(deepLinksDialogInfo, null, null, null, null, null, Boolean.TRUE, 31, null), str).show(beginTransaction, "publish_draft_dialog");
    }

    public static /* synthetic */ void showPublishDraftAvailableDialogFragment$default(String str, DeepLinksDialogInfo deepLinksDialogInfo, FragmentManager fragmentManager, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        showPublishDraftAvailableDialogFragment(str, deepLinksDialogInfo, fragmentManager, z);
    }
}
