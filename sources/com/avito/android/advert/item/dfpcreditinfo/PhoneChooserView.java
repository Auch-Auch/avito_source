package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView;", "", "", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "items", "", "showItems", "(Ljava/util/List;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneChooserView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "", "", "onReloadPhonesClicked", "()V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;", "phone", "onPhoneClicked", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;)V", "onOtherPhoneClicked", "onPhoneChooserClosed", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onOtherPhoneClicked();

        void onPhoneChooserClosed();

        void onPhoneClicked(@NotNull PhoneChooserItem.Phone phone);

        void onReloadPhonesClicked();
    }

    @Nullable
    Listener getListener();

    void setListener(@Nullable Listener listener);

    void showItems(@NotNull List<? extends PhoneChooserItem> list);
}
