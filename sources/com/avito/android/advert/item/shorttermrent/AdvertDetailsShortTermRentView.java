package com.avito.android.advert.item.shorttermrent;

import android.net.Uri;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.model.AdvertShortTermRent;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/AdvertShortTermRent;", "shortTermRent", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "buttonListener", "", "showShortTermRent", "(Lcom/avito/android/remote/model/AdvertShortTermRent;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsShortTermRentView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsShortTermRentView advertDetailsShortTermRentView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsShortTermRentView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "", "Landroid/net/Uri;", "actionUri", "", "onClickShortTermRent", "(Landroid/net/Uri;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onClickShortTermRent(@NotNull Uri uri);
    }

    void showShortTermRent(@NotNull AdvertShortTermRent advertShortTermRent, @NotNull DeepLinkFactory deepLinkFactory, @Nullable Listener listener);
}
