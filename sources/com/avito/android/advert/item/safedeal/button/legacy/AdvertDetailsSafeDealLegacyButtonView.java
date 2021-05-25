package com.avito.android.advert.item.safedeal.button.legacy;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SafeDeal;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "actions", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showLegacyButton", "(Lcom/avito/android/remote/model/SafeDeal$Actions;Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;)V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsSafeDealLegacyButtonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsSafeDealLegacyButtonView advertDetailsSafeDealLegacyButtonView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsSafeDealLegacyButtonView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "orderTypes", "", "followLegacyButtonDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followLegacyButtonDeepLink(@NotNull DeepLink deepLink, @Nullable String str);
    }

    void showLegacyButton(@NotNull SafeDeal.Actions actions, @NotNull Router router);
}
