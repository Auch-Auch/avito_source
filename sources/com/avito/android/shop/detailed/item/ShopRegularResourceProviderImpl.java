package com.avito.android.shop.detailed.item;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopRegularResourceProviderImpl;", "Lcom/avito/android/shop/detailed/item/ShopRegularResourceProvider;", "", "getExpandedDescriptionText", "()Ljava/lang/String;", "getCollapsedDescriptionText", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRegularResourceProviderImpl implements ShopRegularResourceProvider {
    public final Resources a;

    @Inject
    public ShopRegularResourceProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.getResources();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularResourceProvider
    @NotNull
    public String getCollapsedDescriptionText() {
        String string = this.a.getString(R.string.shops_show_less_description);
        return string != null ? string : "";
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularResourceProvider
    @NotNull
    public String getExpandedDescriptionText() {
        String string = this.a.getString(R.string.shops_show_full_description);
        return string != null ? string : "";
    }
}
