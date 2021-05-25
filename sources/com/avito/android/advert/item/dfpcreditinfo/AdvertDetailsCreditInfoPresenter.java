package com.avito.android.advert.item.dfpcreditinfo;

import android.content.Context;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001e\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000fH&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010\n¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)V", "clearFocus", "()V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "creditInfo", "showCreditInfo", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;)V", "", "value", "updateLegalInfoDialog", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "setPhoneChooserListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "router", "setRouter", "(Lcom/avito/android/advert_core/advert/AdvertCoreRouter;)V", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phonesState", "updatePhoneChooser", "(Lcom/avito/android/util/LoadingState;)V", "Landroid/content/Context;", "context", "phone", "openSravni", "(Landroid/content/Context;Ljava/lang/String;)V", "onResume", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsCreditInfoPresenter extends ItemPresenter<AdvertDetailsCreditInfoView, AdvertDetailsCreditInfoItem> {
    void clearFocus();

    void onResume();

    void openSravni(@NotNull Context context, @NotNull String str);

    void setListener(@NotNull DfpCreditButton.Listener listener);

    void setPhoneChooserListener(@NotNull PhoneChooserView.Listener listener);

    void setRouter(@NotNull AdvertCoreRouter advertCoreRouter);

    void showCreditInfo(@NotNull DfpCreditInfo dfpCreditInfo);

    void updateLegalInfoDialog(@Nullable String str);

    void updatePhoneChooser(@Nullable LoadingState<? super List<Phone>> loadingState);
}
