package com.avito.android.brandspace.view;

import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/brandspace/view/BrandpaceSpanProviderImpl;", "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "item", "", "getSpanCount", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)I", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "getResources", "()Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "resources", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandpaceSpanProviderImpl implements BrandpaceSpanProvider {
    @NotNull
    public final BrandspaceResourcesProvider a;

    @Inject
    public BrandpaceSpanProviderImpl(@NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "resources");
        this.a = brandspaceResourcesProvider;
    }

    @NotNull
    public final BrandspaceResourcesProvider getResources() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.view.BrandpaceSpanProvider
    public int getSpanCount(@NotNull BrandspaceItem brandspaceItem) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "item");
        if (brandspaceItem instanceof BrandspaceAdvertItem) {
            return this.a.getAdvertSpan();
        }
        if (brandspaceItem instanceof MarketplaceSnippetItem) {
            return this.a.getAdvertSpan();
        }
        return this.a.getBrandspaceColumnCount();
    }
}
