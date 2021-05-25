package com.avito.android.advert;

import com.avito.android.remote.model.AdvertDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsToolbarRouter;", "", "", "url", "title", "", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "closeScreen", "()V", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "editNoteClick", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsToolbarRouter {
    void closeScreen();

    void editNoteClick(@NotNull AdvertDetails advertDetails);

    void openShareDialog(@NotNull String str, @NotNull String str2);
}
