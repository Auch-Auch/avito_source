package com.avito.android.tariff.info.viewmodel;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.InfoListElement;
import com.avito.android.remote.model.TariffInfoResult;
import com.avito.android.remote.model.TariffPackage;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.tariff.bar.BarDescription;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItem;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.android.tariff.info.item.package_info.PackageInfoItem;
import com.avito.android.tariff.info.item.package_title.PackageTitleItem;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverterImpl;", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;", "Lcom/avito/android/remote/model/TariffInfoResult;", "tariffInfoResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/TariffInfoResult;)Ljava/util/List;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/tariff/view/TariffBarConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/view/TariffBarConverter;", "tariffBarConverter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/tariff/view/TariffBarConverter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoConverterImpl implements TariffInfoConverter {
    public final AttributedTextFormatter a;
    public final TariffBarConverter b;

    @Inject
    public TariffInfoConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull TariffBarConverter tariffBarConverter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(tariffBarConverter, "tariffBarConverter");
        this.a = attributedTextFormatter;
        this.b = tariffBarConverter;
    }

    @Override // com.avito.android.tariff.info.viewmodel.TariffInfoConverter
    @NotNull
    public List<Item> convert(@NotNull TariffInfoResult tariffInfoResult) {
        Intrinsics.checkNotNullParameter(tariffInfoResult, "tariffInfoResult");
        AttributedText description = tariffInfoResult.getDescription();
        int i = 0;
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, tariffInfoResult.getTitle(), description != null ? this.a.format(description) : null));
        List<InfoListElement> infoList = tariffInfoResult.getInfoList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(infoList, 10));
        int i2 = 0;
        for (T t : infoList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            StringBuilder L = a.L("disclaimer");
            L.append(String.valueOf(i2));
            arrayList.add(new InfoItem(L.toString(), t2.getTitle(), t2.getDescription()));
            i2 = i3;
        }
        h.addAll(mutableListOf, arrayList);
        mutableListOf.add(new PackageTitleItem("package_title", tariffInfoResult.getPackagesTitle()));
        List<TariffPackage> packagesList = tariffInfoResult.getPackagesList();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(packagesList, 10));
        for (T t3 : packagesList) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t4 = t3;
            StringBuilder L2 = a.L("package");
            L2.append(String.valueOf(i));
            String sb = L2.toString();
            String title = t4.getTitle();
            String subcategories = t4.getSubcategories();
            String locations = t4.getLocations();
            String title2 = t4.getBar().getTitle();
            String subtitle = t4.getBar().getSubtitle();
            float value = t4.getBar().getCurrentProgress().getValue();
            ProgressState convertProgressStatus = this.b.convertProgressStatus(t4.getBar().getCurrentProgress().getState());
            BarDescription description2 = t4.getBar().getDescription();
            String title3 = description2 != null ? description2.getTitle() : null;
            TariffBarConverter tariffBarConverter = this.b;
            BarDescription description3 = t4.getBar().getDescription();
            arrayList2.add(new PackageInfoItem(sb, title, subcategories, locations, title2, subtitle, value, convertProgressStatus, title3, tariffBarConverter.convertDescriptionStatus(description3 != null ? description3.getState() : null)));
            i = i4;
        }
        h.addAll(mutableListOf, arrayList2);
        mutableListOf.add(new DisclaimerItem("disclaimer", tariffInfoResult.getDisclaimer()));
        return mutableListOf;
    }
}
