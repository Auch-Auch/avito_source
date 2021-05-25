package com.avito.android.tariff.tariff_package_info.viewmodel;

import a2.b.a.a.a;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TariffPackageInfoItem;
import com.avito.android.remote.model.TariffPackageInfoResult;
import com.avito.android.remote.model.edit.TariffEditMicrocategories;
import com.avito.android.remote.tariff.bar.BarDescription;
import com.avito.android.remote.tariff.bar.BarDescriptionState;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackageItem;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItem;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverterImpl;", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "Lcom/avito/android/remote/model/TariffPackageInfoResult;", CommonKt.EXTRA_RESPONSE, "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/TariffPackageInfoResult;)Ljava/util/List;", "Lcom/avito/android/tariff/view/TariffBarConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/view/TariffBarConverter;", "tariffBarConverter", "<init>", "(Lcom/avito/android/tariff/view/TariffBarConverter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageInfoConverterImpl implements TariffPackageInfoConverter {
    public final TariffBarConverter a;

    @Inject
    public TariffPackageInfoConverterImpl(@NotNull TariffBarConverter tariffBarConverter) {
        Intrinsics.checkNotNullParameter(tariffBarConverter, "tariffBarConverter");
        this.a = tariffBarConverter;
    }

    @Override // com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverter
    @NotNull
    public List<Item> convert(@NotNull TariffPackageInfoResult tariffPackageInfoResult) {
        Intrinsics.checkNotNullParameter(tariffPackageInfoResult, CommonKt.EXTRA_RESPONSE);
        String packageTitle = tariffPackageInfoResult.getTariffPackage().getPackageTitle();
        String title = tariffPackageInfoResult.getTariffPackage().getBar().getTitle();
        float value = tariffPackageInfoResult.getTariffPackage().getBar().getCurrentProgress().getValue();
        ProgressState convertProgressStatus = this.a.convertProgressStatus(tariffPackageInfoResult.getTariffPackage().getBar().getCurrentProgress().getState());
        BarDescription description = tariffPackageInfoResult.getTariffPackage().getBar().getDescription();
        BarDescriptionState barDescriptionState = null;
        String title2 = description != null ? description.getTitle() : null;
        TariffBarConverter tariffBarConverter = this.a;
        BarDescription description2 = tariffPackageInfoResult.getTariffPackage().getBar().getDescription();
        if (description2 != null) {
            barDescriptionState = description2.getState();
        }
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TariffPackageHeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, packageTitle, title, value, convertProgressStatus, title2, tariffBarConverter.convertDescriptionStatus(barDescriptionState)));
        List<TariffPackageInfoItem> infoList = tariffPackageInfoResult.getTariffPackage().getInfoList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(infoList, 10));
        int i = 0;
        for (T t : infoList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            String M2 = a.M2(TariffPackageInfoConverterKt.PACKAGE_STRING_ID, i);
            String title3 = t2.getTitle();
            List<TariffEditMicrocategories> microcategories = t2.getMicrocategories();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(microcategories, 10));
            int i3 = 0;
            for (T t3 : microcategories) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t4 = t3;
                arrayList2.add(new EditPackageMicroCategoryItem(a.M2(TariffPackageInfoConverterKt.MICROCATEGORY_STRING_ID, i3), t4.getTitle(), t4.getSubcategories()));
                i3 = i4;
            }
            arrayList.add(new TariffPackageItem(M2, title3, arrayList2));
            i = i2;
        }
        mutableListOf.addAll(arrayList);
        return mutableListOf;
    }
}
