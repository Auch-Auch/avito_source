package com.avito.android.delivery.summary.change_contacts;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "d", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "contactsFieldsInteractor", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "converter", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;", "c", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsEditContactsViewModelFactory implements ViewModelProvider.Factory {
    public final SchedulersFactory3 a;
    public final DeliveryRdsSummaryItemsConverter b;
    public final DeliveryRdsEditContactsResourceProvider c;
    public final DeliveryRdsContactsFieldsInteractor d;

    @Inject
    public DeliveryRdsEditContactsViewModelFactory(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, @NotNull DeliveryRdsEditContactsResourceProvider deliveryRdsEditContactsResourceProvider, @NotNull DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryRdsEditContactsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryRdsContactsFieldsInteractor, "contactsFieldsInteractor");
        this.a = schedulersFactory3;
        this.b = deliveryRdsSummaryItemsConverter;
        this.c = deliveryRdsEditContactsResourceProvider;
        this.d = deliveryRdsContactsFieldsInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryRdsEditContactsViewModelImpl.class)) {
            return new DeliveryRdsEditContactsViewModelImpl(this.d, this.a, this.b, this.c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
