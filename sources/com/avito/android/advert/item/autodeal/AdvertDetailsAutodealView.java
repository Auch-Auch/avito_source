package com.avito.android.advert.item.autodeal;

import android.view.View;
import com.avito.android.remote.model.AutoDeal;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/AutoDeal;", "autoDeal", "", "showAutodeal", "(Lcom/avito/android/remote/model/AutoDeal;)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Landroid/view/View$OnClickListener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsAutodealView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsAutodealView advertDetailsAutodealView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsAutodealView);
        }
    }

    void setListener(@NotNull View.OnClickListener onClickListener);

    void showAutodeal(@NotNull AutoDeal autoDeal);
}
