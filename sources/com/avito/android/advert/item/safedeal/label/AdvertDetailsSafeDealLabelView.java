package com.avito.android.advert.item.safedeal.label;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SafeDeal;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "actions", "", "aboutLabelTitle", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showLabel", "(Lcom/avito/android/remote/model/SafeDeal$Actions;Ljava/lang/CharSequence;Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;)V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsSafeDealLabelView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsSafeDealLabelView advertDetailsSafeDealLabelView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsSafeDealLabelView);
        }

        public static /* synthetic */ void showLabel$default(AdvertDetailsSafeDealLabelView advertDetailsSafeDealLabelView, SafeDeal.Actions actions, CharSequence charSequence, Router router, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    charSequence = null;
                }
                advertDetailsSafeDealLabelView.showLabel(actions, charSequence, router);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLabel");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followLabelDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followLabelDeepLink(@NotNull DeepLink deepLink);
    }

    void showLabel(@NotNull SafeDeal.Actions actions, @Nullable CharSequence charSequence, @NotNull Router router);
}
