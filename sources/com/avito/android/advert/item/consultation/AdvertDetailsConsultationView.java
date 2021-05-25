package com.avito.android.advert.item.consultation;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addListener", "(Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsConsultationView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsConsultationView advertDetailsConsultationView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsConsultationView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;", "", "", "onSubmitConsultationRequestClick", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onSubmitConsultationRequestClick();
    }

    void addListener(@NotNull Listener listener);
}
