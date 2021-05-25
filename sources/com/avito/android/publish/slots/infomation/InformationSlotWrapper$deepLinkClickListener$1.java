package com.avito.android.publish.slots.infomation;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/publish/slots/infomation/InformationSlotWrapper$deepLinkClickListener$1", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InformationSlotWrapper$deepLinkClickListener$1 implements OnDeepLinkClickListener {
    public final /* synthetic */ InformationSlotWrapper a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public InformationSlotWrapper$deepLinkClickListener$1(InformationSlotWrapper informationSlotWrapper) {
        this.a = informationSlotWrapper;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        InformationSlotWrapper.access$getDeepLinksRelay$p(this.a).accept(deepLink);
    }
}
