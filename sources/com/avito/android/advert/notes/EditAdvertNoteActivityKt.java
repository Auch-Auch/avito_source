package com.avito.android.advert.notes;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "title", VKAttachments.TYPE_NOTE, "", "isFavorite", "Landroid/content/Intent;", "createAdvertDetailsNoteIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "ADVERT_RESULT_NOTE", "Ljava/lang/String;", "advert-details_release"}, k = 2, mv = {1, 4, 2})
public final class EditAdvertNoteActivityKt {
    @NotNull
    public static final String ADVERT_RESULT_NOTE = "advert_result_note";

    @NotNull
    public static final Intent createAdvertDetailsNoteIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent(context, EditAdvertNoteActivity.class);
        intent.putExtra("advert_id", str);
        intent.putExtra("advert_title", str2);
        intent.putExtra("advert_note", str3);
        intent.putExtra("is_favorite", z);
        return intent;
    }
}
