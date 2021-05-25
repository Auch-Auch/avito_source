package com.avito.android.user_advert.advert.autopublish_block;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl;
import com.avito.android.user_advert.advert.switcher_block.SwitcherChangeStateInteractor;
import com.avito.android.util.SchedulersFactory3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModel;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModelImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "advert", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "getSwitcher", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "", "itemId", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;", "resourceProvider", "<init>", "(Ljava/lang/String;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishBlockViewModel extends SwitcherBlockViewModelImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoPublishBlockViewModel(@NotNull String str, @NotNull SwitcherChangeStateInteractor switcherChangeStateInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SwitcherBlockResourceProvider switcherBlockResourceProvider) {
        super(str, switcherChangeStateInteractor, schedulersFactory3, typedErrorThrowableConverter, switcherBlockResourceProvider);
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(switcherChangeStateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(switcherBlockResourceProvider, "resourceProvider");
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl
    @Nullable
    public MyAdvertDetails.AutoPublishSwitcher getSwitcher(@NotNull MyAdvertDetailsItem myAdvertDetailsItem) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem, "advert");
        return myAdvertDetailsItem.getAutoPublish();
    }
}
