package com.avito.android.photo_gallery.autoteka_teaser;

import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", "", "", "onEmptyClick", "()V", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "onButtonClick", "(Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaListener {
    void onButtonClick(@NotNull FromBlock fromBlock);

    void onEmptyClick();
}
