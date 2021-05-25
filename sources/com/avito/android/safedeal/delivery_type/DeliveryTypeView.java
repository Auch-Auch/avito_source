package com.avito.android.safedeal.delivery_type;

import com.avito.android.remote.model.AlertBannerModel;
import com.avito.conveyor_item.ParcelableItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showError", "()V", "", "Lcom/avito/conveyor_item/ParcelableItem;", "items", "bindItems", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/AlertBannerModel;", "banner", "showAlertBanner", "(Lcom/avito/android/remote/model/AlertBannerModel;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryTypeView {
    void bindItems(@NotNull List<? extends ParcelableItem> list);

    void showAlertBanner(@Nullable AlertBannerModel alertBannerModel);

    void showError();

    @NotNull
    Observable<Unit> upButtonClicks();
}
