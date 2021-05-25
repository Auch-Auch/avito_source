package com.avito.android.remote.notification;

import com.avito.android.remote.model.Image;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "", "Lcom/avito/android/remote/model/Image;", "image", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/notification/NotificationImages;", "load", "(Lcom/avito/android/remote/model/Image;)Lio/reactivex/Observable;", "notification_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationBitmapInteractor {
    @NotNull
    Observable<LoadingState<NotificationImages>> load(@NotNull Image image);
}
