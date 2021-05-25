package com.avito.android.tariff.change.viewmodel;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.model.change.CheckmarkTextBenefit;
import com.avito.android.remote.model.change.PlusTextBenefit;
import com.avito.android.remote.model.change.Tariff;
import com.avito.android.remote.model.change.TariffBenefit;
import com.avito.android.remote.model.change.TariffChangeResult;
import com.avito.android.tariff.change.item.benefit.BenefitIcon;
import com.avito.android.tariff.change.item.benefit.BenefitItem;
import com.avito.android.tariff.change.item.title.TitleItem;
import com.avito.android.tariff.change.page.TariffTab;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverterImpl;", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;", "Lcom/avito/android/remote/model/change/TariffChangeResult;", "tariffChangeResult", "", "Lcom/avito/android/tariff/change/page/TariffTab;", "convert", "(Lcom/avito/android/remote/model/change/TariffChangeResult;)Ljava/util/List;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeConverterImpl implements TariffChangeConverter {
    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeConverter
    @NotNull
    public List<TariffTab> convert(@NotNull TariffChangeResult tariffChangeResult) {
        BenefitIcon benefitIcon;
        Intrinsics.checkNotNullParameter(tariffChangeResult, "tariffChangeResult");
        List<Tariff> tariffs = tariffChangeResult.getTariffs();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tariffs, 10));
        Iterator<T> it = tariffs.iterator();
        while (it.hasNext()) {
            T next = it.next();
            String title = next.getTitle();
            List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, next.getTitle(), null), new BenefitItem("price", next.getPrice(), BenefitIcon.NONE));
            int i = 0;
            for (T t : next.getBenefits()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                StringBuilder L = a.L("title");
                L.append(String.valueOf(i));
                mutableListOf.add(new TitleItem(L.toString(), t2.getTitle()));
                List<TariffBenefit> list = t2.getList();
                if (list != null) {
                    int i3 = 0;
                    for (T t3 : list) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        T t4 = t3;
                        if (t4 instanceof PlusTextBenefit) {
                            benefitIcon = BenefitIcon.PLUS;
                        } else if (t4 instanceof CheckmarkTextBenefit) {
                            benefitIcon = BenefitIcon.CHECKMARK;
                        } else {
                            benefitIcon = BenefitIcon.NONE;
                        }
                        StringBuilder L2 = a.L("benefit");
                        L2.append(String.valueOf(i));
                        L2.append(String.valueOf(i3));
                        mutableListOf.add(new BenefitItem(L2.toString(), t4.getText(), benefitIcon));
                        it = it;
                        i3 = i4;
                    }
                }
                it = it;
                i = i2;
            }
            arrayList.add(new TariffTab(title, mutableListOf, next.getAction(), next.isSelected(), null, 16, null));
        }
        return arrayList;
    }
}
