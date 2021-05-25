package com.avito.android.brandspace.presenter.mappers;

import com.avito.android.IdProvider;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/presenter/mappers/MarketplaceTabsModuleMapper;", "Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;", "tabsModule", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "invoke", "(Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;)Ljava/util/List;", "Lcom/avito/android/brandspace/items/BlockType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "Lcom/avito/android/IdProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/IdProvider;", "idProvider", "<init>", "(Lcom/avito/android/IdProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabsModuleMapper implements BrandspaceElementMapper<MarketplaceTabsModule> {
    public final BlockType a = BlockType.MARKETPLACE_TAB;
    public final IdProvider b;

    @Inject
    public MarketplaceTabsModuleMapper(@NotNull IdProvider idProvider) {
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        this.b = idProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem> invoke(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.remote.model.MarketplaceTabsModule r24) {
        /*
        // Method dump skipped, instructions count: 383
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.presenter.mappers.MarketplaceTabsModuleMapper.invoke(com.avito.android.brandspace.remote.model.MarketplaceTabsModule):java.util.List");
    }
}
