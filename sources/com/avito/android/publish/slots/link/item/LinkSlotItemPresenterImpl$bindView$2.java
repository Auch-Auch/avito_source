package com.avito.android.publish.slots.link.item;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/publish/slots/link/item/LinkSlotItemPresenterImpl$bindView$2", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSlotItemPresenterImpl$bindView$2 implements OnDeepLinkClickListener {
    public final /* synthetic */ LinkSlotItemPresenterImpl a;
    public final /* synthetic */ LinkSlotItem b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LinkSlotItemPresenterImpl$bindView$2 a;
        public final /* synthetic */ DeepLink b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LinkSlotItemPresenterImpl$bindView$2 linkSlotItemPresenterImpl$bindView$2, DeepLink deepLink) {
            super(0);
            this.a = linkSlotItemPresenterImpl$bindView$2;
            this.b = deepLink;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.e.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public LinkSlotItemPresenterImpl$bindView$2(LinkSlotItemPresenterImpl linkSlotItemPresenterImpl, LinkSlotItem linkSlotItem) {
        this.a = linkSlotItemPresenterImpl;
        this.b = linkSlotItem;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (this.b.getAlert() != null) {
            this.a.a.accept(LinkSlotItemPresenterImpl.access$createLinkAlertParams(this.a, this.b.getAlert(), new a(this, deepLink)));
        } else {
            this.a.e.accept(deepLink);
        }
    }
}
