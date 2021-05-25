package com.avito.android.photo_wizard;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lcom/avito/android/remote/model/VerificationStep;", "steps", "Landroid/content/Intent;", "createPhotoWizardIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "EXTRA_STEPS_LIST", "Ljava/lang/String;", "EXTRA_ADVERT_ID", "photo-wizard_release"}, k = 2, mv = {1, 4, 2})
public final class PhotoWizardActivityKt {
    @NotNull
    public static final String EXTRA_ADVERT_ID = "advert_id";
    @NotNull
    public static final String EXTRA_STEPS_LIST = "steps_list";

    @NotNull
    public static final Intent createPhotoWizardIntent(@NotNull Context context, @NotNull String str, @NotNull List<VerificationStep> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "steps");
        Intent intent = new Intent(context, PhotoWizardActivity.class);
        intent.putExtra("advert_id", str);
        intent.putParcelableArrayListExtra(EXTRA_STEPS_LIST, Collections.asArrayList(list));
        return intent;
    }
}
