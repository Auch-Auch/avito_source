package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfoView;", "", "value", "", "showBrokerInfoSheetIfNeeded", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPhoneChooserListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", "", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "items", "updatePhoneChooser", "(Ljava/util/List;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsCreditInfoView extends ItemView, DfpCreditInfoView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsCreditInfoView advertDetailsCreditInfoView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsCreditInfoView);
        }
    }

    void setPhoneChooserListener(@NotNull PhoneChooserView.Listener listener);

    void showBrokerInfoSheetIfNeeded(@Nullable String str);

    void updatePhoneChooser(@Nullable List<? extends PhoneChooserItem> list);
}
