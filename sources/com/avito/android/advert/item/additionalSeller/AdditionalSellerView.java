package com.avito.android.advert.item.additionalSeller;

import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.model.AdditionalSellerButtons;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "params", "bindParams", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/AdditionalSellerButtons;", "additionalSellerButtons", "bindButtons", "(Lcom/avito/android/remote/model/AdditionalSellerButtons;)V", "hideDivider", "()V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdditionalSellerView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdditionalSellerView additionalSellerView) {
            ItemView.DefaultImpls.onUnbind(additionalSellerView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "onAdditionalSellerClicks", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", ErrorBundle.DETAIL_ENTRY, "onOpenCallBottomSheet", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener extends AdvertDetailsFlatsListener {
        void onAdditionalSellerClicks(@NotNull DeepLink deepLink);

        void onOpenCallBottomSheet(@NotNull DetailsSheetLinkBody detailsSheetLinkBody);
    }

    void bindButtons(@Nullable AdditionalSellerButtons additionalSellerButtons);

    void bindParams(@NotNull List<AdvertParameters.Parameter> list);

    void hideDivider();

    void setTitle(@Nullable AttributedText attributedText);
}
