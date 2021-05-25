package com.avito.android.user_advert.advert.service;

import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "", "", "reason", BookingInfoActivity.EXTRA_ITEM_ID, "", "closeAdvertSync", "(Ljava/lang/String;Ljava/lang/String;)V", "", "enabled", "setAutoPublishSync", "(ZLjava/lang/String;)Z", "activateAdvertSync", "(Ljava/lang/String;)Z", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertInteractor {
    boolean activateAdvertSync(@NotNull String str);

    void closeAdvertSync(@NotNull String str, @NotNull String str2);

    boolean setAutoPublishSync(boolean z, @NotNull String str);
}
