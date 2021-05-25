package com.avito.android.advert.item;

import com.avito.android.contact_access.ContactAccessPackageFragment;
import com.avito.android.contact_access.ContactAccessPackageRouter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/avito/android/advert/item/AdvertDetailsRouterImpl$setRouter$contactAccessPackageRouter$1", "Lcom/avito/android/contact_access/ContactAccessPackageRouter;", "", "onCancel", "()V", "onClose", "onUpdate", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsRouterImpl$setRouter$contactAccessPackageRouter$1 implements ContactAccessPackageRouter {
    public final /* synthetic */ AdvertDetailsRouterImpl a;
    public final /* synthetic */ ContactAccessPackageFragment b;

    public AdvertDetailsRouterImpl$setRouter$contactAccessPackageRouter$1(AdvertDetailsRouterImpl advertDetailsRouterImpl, ContactAccessPackageFragment contactAccessPackageFragment) {
        this.a = advertDetailsRouterImpl;
        this.b = contactAccessPackageFragment;
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageRouter
    public void onCancel() {
        this.b.setRouter(null);
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageRouter
    public void onClose() {
        this.b.dismiss();
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageRouter
    public void onUpdate() {
        this.a.k.invoke();
    }
}
