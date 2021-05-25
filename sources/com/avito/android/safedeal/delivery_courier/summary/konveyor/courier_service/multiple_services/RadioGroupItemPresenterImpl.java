package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemPresenterImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemPresenter;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemView;", "view", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServicesRadioGroupItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemView;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServicesRadioGroupItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "changeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupItemPresenterImpl implements RadioGroupItemPresenter {
    public final Consumer<BaseCourierServiceItem> a;

    public static final class a extends Lambda implements Function1<CourierServiceRadioButtonItem, Unit> {
        public final /* synthetic */ RadioGroupItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RadioGroupItemPresenterImpl radioGroupItemPresenterImpl, CourierServicesRadioGroupItem courierServicesRadioGroupItem) {
            super(1);
            this.a = radioGroupItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(CourierServiceRadioButtonItem courierServiceRadioButtonItem) {
            CourierServiceRadioButtonItem courierServiceRadioButtonItem2 = courierServiceRadioButtonItem;
            Intrinsics.checkNotNullParameter(courierServiceRadioButtonItem2, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            this.a.a.accept(courierServiceRadioButtonItem2);
            return Unit.INSTANCE;
        }
    }

    public RadioGroupItemPresenterImpl(@NotNull Consumer<BaseCourierServiceItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "changeConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull RadioGroupItemView radioGroupItemView, @NotNull CourierServicesRadioGroupItem courierServicesRadioGroupItem, int i) {
        T t;
        Intrinsics.checkNotNullParameter(radioGroupItemView, "view");
        Intrinsics.checkNotNullParameter(courierServicesRadioGroupItem, "item");
        radioGroupItemView.setTitle(courierServicesRadioGroupItem.getTitle());
        radioGroupItemView.setSubtitle(courierServicesRadioGroupItem.getSubtitle());
        radioGroupItemView.setHint(courierServicesRadioGroupItem.getHint());
        Iterator<T> it = courierServicesRadioGroupItem.getRadioButtons().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.isChecked()) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            this.a.accept(t2);
        }
        radioGroupItemView.setRadioButtons(courierServicesRadioGroupItem.getRadioButtons(), new a(this, courierServicesRadioGroupItem));
    }
}
