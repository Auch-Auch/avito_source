package com.avito.android.publish;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Landroid/content/Intent;", "createPublishActivity", "(Landroid/content/Context;Lcom/avito/android/remote/model/Navigation;)Landroid/content/Intent;", "", BookingInfoActivity.EXTRA_ITEM_ID, "createPublishActivityWithAdvert", "(Landroid/content/Context;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;)Landroid/content/Intent;", "itemId", "action", "createPublishActivityForEditing", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "draftId", "", "trackDraftResume", "createPublishActivityForDraft", "(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Intent;", "KEY_STEP_INDEX", "Ljava/lang/String;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishActivityKt {
    @NotNull
    public static final String KEY_STEP_INDEX = "step_index";

    @NotNull
    public static final Intent createPublishActivity(@NotNull Context context, @Nullable Navigation navigation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, PublishActivity.class).putExtra("key_navigation", navigation);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…Y_NAVIGATION, navigation)");
        return putExtra;
    }

    @NotNull
    public static final Intent createPublishActivityForDraft(@NotNull Context context, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intent putExtra = new Intent(context, PublishActivity.class).putExtra("should_restore_draft", true).putExtra("should_draft_id", str).putExtra("should_track_draft_resume", z);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…RESUME, trackDraftResume)");
        return putExtra;
    }

    public static /* synthetic */ Intent createPublishActivityForDraft$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return createPublishActivityForDraft(context, str, z);
    }

    @NotNull
    public static final Intent createPublishActivityForEditing(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intent putExtra = new Intent(context, PublishActivity.class).putExtra("key_item_id", str).putExtra("key_action", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…Extra(KEY_ACTION, action)");
        return putExtra;
    }

    public static /* synthetic */ Intent createPublishActivityForEditing$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createPublishActivityForEditing(context, str, str2);
    }

    @VisibleForTesting
    @NotNull
    public static final Intent createPublishActivityWithAdvert(@NotNull Context context, @Nullable Navigation navigation, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intent putExtra = createPublishActivity(context, navigation).putExtra("key_advert_id", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "createPublishActivity(co…(KEY_ADVERT_ID, advertId)");
        return putExtra;
    }
}
