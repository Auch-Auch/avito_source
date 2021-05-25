package com.avito.android.user_advert.advert.autobooking_block;

import a2.a.a.h3.a.f1.d;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl;
import com.avito.android.user_advert.advert.switcher_block.SwitcherChangeStateInteractor;
import com.avito.android.user_advert.advert.switcher_block.SwitcherState;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockViewModel;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModelImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "advert", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "getSwitcher", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "", "onAdvertLoaded", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)V", "", "newValue", "onSwitchChanged", "(Z)V", VKApiConst.Q, "Z", "areOrdersExist", "Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockResourceProvider;", "r", "Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockResourceProvider;", "resourceProvider", "", "itemId", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Ljava/lang/String;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoBookingBlockViewModel extends SwitcherBlockViewModelImpl {
    public boolean q;
    public final AutoBookingBlockResourceProvider r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoBookingBlockViewModel(@NotNull String str, @NotNull SwitcherChangeStateInteractor switcherChangeStateInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AutoBookingBlockResourceProvider autoBookingBlockResourceProvider) {
        super(str, switcherChangeStateInteractor, schedulersFactory3, typedErrorThrowableConverter, autoBookingBlockResourceProvider);
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(switcherChangeStateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(autoBookingBlockResourceProvider, "resourceProvider");
        this.r = autoBookingBlockResourceProvider;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl, com.avito.android.user_advert.advert.switcher_block.AdvertLoadListener
    public void onAdvertLoaded(@NotNull MyAdvertDetailsItem myAdvertDetailsItem) {
        Boolean areOrdersExist;
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem, "advert");
        super.onAdvertLoaded(myAdvertDetailsItem);
        MyAdvertDetails.AutoBookingSwitcher autoBooking = myAdvertDetailsItem.getAutoBooking();
        this.q = (autoBooking == null || (areOrdersExist = autoBooking.getAreOrdersExist()) == null) ? false : areOrdersExist.booleanValue();
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl, com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel
    public void onSwitchChanged(boolean z) {
        if (!this.q) {
            super.onSwitchChanged(z);
        } else if (z) {
            super.onSwitchChanged(z);
        } else if (!isCurrentSwitchValue(z)) {
            getSwitcherState().postValue(new SwitcherState.Warning(new d(this)));
        }
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl
    @Nullable
    public MyAdvertDetails.AutoBookingSwitcher getSwitcher(@NotNull MyAdvertDetailsItem myAdvertDetailsItem) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem, "advert");
        return myAdvertDetailsItem.getAutoBooking();
    }
}
