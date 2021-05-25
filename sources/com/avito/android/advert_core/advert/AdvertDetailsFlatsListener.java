package com.avito.android.advert_core.advert;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "", "", "itemName", "itemValue", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onFlatsClick", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFlatsListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onFlatsClick$default(AdvertDetailsFlatsListener advertDetailsFlatsListener, String str, String str2, DeepLink deepLink, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    deepLink = null;
                }
                advertDetailsFlatsListener.onFlatsClick(str, str2, deepLink);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFlatsClick");
        }
    }

    void onFlatsClick(@NotNull String str, @NotNull String str2, @Nullable DeepLink deepLink);
}
