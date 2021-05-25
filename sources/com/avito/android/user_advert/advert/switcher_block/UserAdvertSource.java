package com.avito.android.user_advert.advert.switcher_block;

import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J<\u0010\u0011\u001a\u00020\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\b2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;", "", "Lcom/avito/android/user_advert/advert/switcher_block/AdvertLoadListener;", "advertLoadListener", "", "addAdvertLoadListener", "(Lcom/avito/android/user_advert/advert/switcher_block/AdvertLoadListener;)V", "removeAdvertLoadListener", "Lkotlin/Function1;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "Lkotlin/ParameterName;", "name", "advert", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "getSwitcher", "", "isEnabled", "updateSwitcherValue", "(Lkotlin/jvm/functions/Function1;Z)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertSource {
    void addAdvertLoadListener(@NotNull AdvertLoadListener advertLoadListener);

    void removeAdvertLoadListener(@NotNull AdvertLoadListener advertLoadListener);

    void updateSwitcherValue(@NotNull Function1<? super MyAdvertDetailsItem, ? extends MyAdvertDetails.Switcher> function1, boolean z);
}
