package com.avito.android.basket_legacy.utils;

import com.avito.android.basket_legacy.item.BasketItem;
import com.avito.android.basket_legacy.item.header.HeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.conveyor_item.Item;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverterImpl;", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "Lcom/avito/android/basket_legacy/utils/PackageService;", "ownedPackage", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/basket_legacy/utils/PackageService;)Ljava/util/List;", "Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "singleFee", "(Lcom/avito/android/basket_legacy/utils/SingleFeeService;)Ljava/util/List;", "Lcom/avito/android/basket_legacy/utils/StringProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "<init>", "(Lcom/avito/android/basket_legacy/utils/StringProvider;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class FeesToBasketItemConverterImpl implements FeesToBasketItemConverter {
    public final StringProvider a;

    @Inject
    public FeesToBasketItemConverterImpl(@NotNull StringProvider stringProvider) {
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        this.a = stringProvider;
    }

    @Override // com.avito.android.basket_legacy.utils.FeesToBasketItemConverter
    @NotNull
    public List<Item> convert(@NotNull PackageService packageService) {
        Intrinsics.checkNotNullParameter(packageService, "ownedPackage");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Item[]{new HeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, this.a.getPackagesTitle(), null, 1, 4, null), new BasketItem("fees", packageService.getCountDetails(), new AttributedText(packageService.getLocation(), CollectionsKt__CollectionsKt.emptyList()), new AttributedText(this.a.getPackageFeePrice(), CollectionsKt__CollectionsKt.emptyList()), null, packageService.getIcon(), false, TariffPackageInfoConverterKt.HEADER_STRING_ID, String.valueOf(packageService.getServiceId()), 0, 16, null)});
    }

    @Override // com.avito.android.basket_legacy.utils.FeesToBasketItemConverter
    @NotNull
    public List<Item> convert(@NotNull SingleFeeService singleFeeService) {
        Intrinsics.checkNotNullParameter(singleFeeService, "singleFee");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Item[]{new HeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, this.a.getSingleFeeTitle(), singleFeeService.getDescription(), 1), new BasketItem("fees", singleFeeService.getCategory(), new AttributedText(singleFeeService.getLocation(), CollectionsKt__CollectionsKt.emptyList()), new AttributedText(singleFeeService.getPriceDetails(), CollectionsKt__CollectionsKt.emptyList()), null, singleFeeService.getIcon(), false, TariffPackageInfoConverterKt.HEADER_STRING_ID, singleFeeService.getSlug(), singleFeeService.getPrice(), 16, null)});
    }
}
