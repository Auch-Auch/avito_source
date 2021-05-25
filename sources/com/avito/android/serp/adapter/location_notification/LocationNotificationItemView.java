package com.avito.android.serp.adapter.location_notification;

import com.avito.konveyor.blueprint.ItemView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitleText", "(Ljava/lang/String;)V", "text", "setConfirmText", "setChangeText", "Lio/reactivex/rxjava3/core/Observable;", "getVisibilityCallback", "()Lio/reactivex/rxjava3/core/Observable;", "visibilityCallback", "", "getConfirmClicks", "confirmClicks", "getChangeClicks", "changeClicks", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface LocationNotificationItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull LocationNotificationItemView locationNotificationItemView) {
            ItemView.DefaultImpls.onUnbind(locationNotificationItemView);
        }
    }

    @NotNull
    Observable<Unit> getChangeClicks();

    @NotNull
    Observable<Integer> getConfirmClicks();

    @NotNull
    Observable<Unit> getVisibilityCallback();

    void setChangeText(@Nullable String str);

    void setConfirmText(@Nullable String str);

    void setTitleText(@Nullable String str);
}
