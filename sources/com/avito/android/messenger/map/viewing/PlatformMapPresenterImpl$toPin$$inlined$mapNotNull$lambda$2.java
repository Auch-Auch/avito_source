package com.avito.android.messenger.map.viewing;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/avito/android/messenger/map/viewing/PlatformMapPresenterImpl$toPin$1$1", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapPresenterImpl$toPin$$inlined$mapNotNull$lambda$2 implements OnDeepLinkClickListener {
    public final /* synthetic */ PlatformMapPresenterImpl a;

    public PlatformMapPresenterImpl$toPin$$inlined$mapNotNull$lambda$2(PlatformMapPresenterImpl platformMapPresenterImpl) {
        this.a = platformMapPresenterImpl;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (!(deepLink instanceof NoMatchLink)) {
            String str = this.a.getTAG();
            Logs.verbose$default(str, "onDeepLinkClick(" + deepLink + "):\n\t valid Deeplink", null, 4, null);
            this.a.getDeepLinkClicksStream().postValue(deepLink);
        }
    }
}
