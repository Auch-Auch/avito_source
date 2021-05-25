package com.avito.android.component.ads.yandex;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexContentViewHolder;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/ads/yandex/AdYandexContent;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdYandexContentViewHolder extends ItemView, AdYandexContent {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdYandexContentViewHolder adYandexContentViewHolder) {
            ItemView.DefaultImpls.onUnbind(adYandexContentViewHolder);
        }
    }
}
