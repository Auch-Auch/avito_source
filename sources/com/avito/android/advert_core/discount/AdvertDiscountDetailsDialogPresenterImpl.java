package com.avito.android.advert_core.discount;

import a2.b.a.a.a;
import com.avito.android.advert_core.discount.di.AdvertDiscountDetailsModule;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenterImpl;", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;", "Lcom/avito/android/remote/model/AdvertDiscounts;", "discounts", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "", "bindData", "(Lcom/avito/android/remote/model/AdvertDiscounts;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;", "converter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDiscountDetailsDialogPresenterImpl implements AdvertDiscountDetailsDialogPresenter {
    public final AdapterPresenter a;
    public final AdvertDiscountItemConverter b;

    @Inject
    public AdvertDiscountDetailsDialogPresenterImpl(@AdvertDiscountDetailsModule.AdvertDiscount @NotNull AdapterPresenter adapterPresenter, @NotNull AdvertDiscountItemConverter advertDiscountItemConverter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(advertDiscountItemConverter, "converter");
        this.a = adapterPresenter;
        this.b = advertDiscountItemConverter;
    }

    @Override // com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenter
    public void bindData(@NotNull AdvertDiscounts advertDiscounts, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(advertDiscounts, "discounts");
        Intrinsics.checkNotNullParameter(list, "actions");
        a.s1(this.b.convert(advertDiscounts, list, contactBarData), this.a);
    }
}
