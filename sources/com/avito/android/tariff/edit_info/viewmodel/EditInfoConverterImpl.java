package com.avito.android.tariff.edit_info.viewmodel;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.InfoListElement;
import com.avito.android.remote.model.edit.DeepLinkAction;
import com.avito.android.remote.model.edit.ManagerCallInfo;
import com.avito.android.remote.model.edit.PackageElement;
import com.avito.android.remote.model.edit.Period;
import com.avito.android.remote.model.edit.ShowNextAction;
import com.avito.android.remote.model.edit.TariffAlertAction;
import com.avito.android.remote.model.edit.TariffBanner;
import com.avito.android.remote.model.edit.TariffDescription;
import com.avito.android.remote.model.edit.TariffEditInfoResult;
import com.avito.android.remote.model.edit.TariffEditMicrocategories;
import com.avito.android.remote.model.edit.TariffEditPackage;
import com.avito.android.remote.model.edit.TariffProlongation;
import com.avito.android.remote.model.edit.TariffSheetAction;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.tariff.bar.BarDescription;
import com.avito.android.tariff.edit_info.item.TariffEditInfo;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.DeepLinkActionItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.ShowNextActionItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.TariffBannerItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.TariffSheetActionItem;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItem;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallItem;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItem;
import com.avito.android.tariff.edit_info.item.tabs.PeriodTab;
import com.avito.android.tariff.edit_info.item.tabs.TabsItem;
import com.avito.android.tariff.edit_info.item.tabs.TariffEditConvertInfo;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.android.tariff.info.item.package_title.PackageTitleItem;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.tariff.view.TariffBarConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverterImpl;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "Lcom/avito/android/remote/model/edit/TariffEditInfoResult;", "infoResult", "Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;", "convert", "(Lcom/avito/android/remote/model/edit/TariffEditInfoResult;)Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;", "Lcom/avito/android/tariff/view/TariffBarConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/view/TariffBarConverter;", "tariffBarConverter", "<init>", "(Lcom/avito/android/tariff/view/TariffBarConverter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoConverterImpl implements EditInfoConverter {
    public final TariffBarConverter a;

    @Inject
    public EditInfoConverterImpl(@NotNull TariffBarConverter tariffBarConverter) {
        Intrinsics.checkNotNullParameter(tariffBarConverter, "tariffBarConverter");
        this.a = tariffBarConverter;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoConverter
    @NotNull
    public TariffEditConvertInfo convert(@NotNull TariffEditInfoResult tariffEditInfoResult) {
        AlertDialogItem alertDialogItem;
        ArrayList arrayList;
        Object obj;
        Iterator<T> it;
        EditPackageItem editPackageItem;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(tariffEditInfoResult, "infoResult");
        List<Period> periods = tariffEditInfoResult.getPeriods();
        int i = 10;
        ArrayList<Pair> arrayList3 = new ArrayList(e.collectionSizeOrDefault(periods, 10));
        Iterator<T> it2 = periods.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            T next = it2.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t = next;
            PeriodTab periodTab = new PeriodTab(t.getPeriodTitle().getText(), null, t.getPeriodTitle(), t.getHasRedBadge(), i2);
            ArrayList arrayList4 = new ArrayList();
            String tariffTitle = t.getTariffTitle();
            if (tariffTitle != null) {
                TariffDescription description = t.getDescription();
                arrayList4.add(new PaidServiceHeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, tariffTitle, description != null ? description.getTitle() : null));
            }
            List<InfoListElement> infoList = t.getInfoList();
            ArrayList arrayList5 = new ArrayList(e.collectionSizeOrDefault(infoList, i));
            int i4 = 0;
            for (T t2 : infoList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                StringBuilder L = a.L("info_item");
                L.append(String.valueOf(i4));
                arrayList5.add(new InfoItem(L.toString(), t3.getTitle(), t3.getDescription()));
                i4 = i5;
            }
            h.addAll(arrayList4, arrayList5);
            TariffProlongation prolongation = t.getProlongation();
            if (prolongation != null) {
                arrayList4.add(new TariffProlongationItem("prolongation_item", prolongation.getTitle(), null, prolongation.getDescription(), prolongation.isSwitchOn(), prolongation.isSwitchActive(), prolongation.getOffDescription()));
            }
            ManagerCallInfo managerCallInfo = t.getManagerCallInfo();
            if (managerCallInfo != null) {
                arrayList4.add(new ManagerCallItem("manager_call_item", managerCallInfo.getActionTitle(), managerCallInfo.getTitle(), managerCallInfo.getDescription(), managerCallInfo.getContactActionTitle(), managerCallInfo.getDeepLink()));
            }
            arrayList4.add(new PackageTitleItem("package_title", t.getPackagesTitle()));
            List<PackageElement> packagesList = t.getPackagesList();
            ArrayList arrayList6 = new ArrayList();
            int i6 = 0;
            for (T t4 : packagesList) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t5 = t4;
                String str = "package_" + i6 + '_' + i2;
                if (t5 instanceof TariffEditPackage) {
                    T t7 = t5;
                    List<TariffEditMicrocategories> microcategories = t7.getMicrocategories();
                    if (microcategories != null) {
                        ArrayList arrayList7 = new ArrayList(e.collectionSizeOrDefault(microcategories, 10));
                        for (T t8 : microcategories) {
                            arrayList7.add(new EditPackageMicroCategoryItem("micro_category", t8.getTitle(), t8.getSubcategories()));
                            it2 = it2;
                        }
                        it = it2;
                        arrayList2 = arrayList7;
                    } else {
                        it = it2;
                        arrayList2 = null;
                    }
                    String locations = t7.getLocations();
                    String title = t7.getBar().getTitle();
                    String subtitle = t7.getBar().getSubtitle();
                    float value = t7.getBar().getCurrentProgress().getValue();
                    ProgressState convertProgressStatus = this.a.convertProgressStatus(t7.getBar().getCurrentProgress().getState());
                    BarDescription description2 = t7.getBar().getDescription();
                    String title2 = description2 != null ? description2.getTitle() : null;
                    TariffBarConverter tariffBarConverter = this.a;
                    BarDescription description3 = t7.getBar().getDescription();
                    editPackageItem = new EditPackageItem(str, arrayList2, locations, title, subtitle, value, convertProgressStatus, title2, tariffBarConverter.convertDescriptionStatus(description3 != null ? description3.getState() : null), t7.getUri());
                } else {
                    it = it2;
                    editPackageItem = null;
                }
                if (editPackageItem != null) {
                    arrayList6.add(editPackageItem);
                }
                i6 = i7;
                it2 = it;
            }
            h.addAll(arrayList4, arrayList6);
            arrayList3.add(TuplesKt.to(periodTab, arrayList4));
            i = 10;
            i2 = i3;
            it2 = it2;
        }
        Iterator<Period> it3 = tariffEditInfoResult.getPeriods().iterator();
        int i8 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i8 = -1;
                break;
            } else if (it3.next().isSelected()) {
                break;
            } else {
                i8++;
            }
        }
        int max = Math.max(i8, 0);
        TariffEditInfo tariffEditInfo = new TariffEditInfo(tariffEditInfoResult.getTitle(), r.toMap(arrayList3), (PeriodTab) ((Pair) arrayList3.get(max)).getFirst());
        ArrayList arrayList8 = new ArrayList(e.collectionSizeOrDefault(arrayList3, 10));
        for (Pair pair : arrayList3) {
            arrayList8.add((PeriodTab) pair.getFirst());
        }
        TabsItem tabsItem = new TabsItem("tabs_item", arrayList8, max);
        TariffBanner tariffBanner = tariffEditInfoResult.getTariffBanner();
        if (tariffBanner != null) {
            TariffBanner.State state = tariffBanner.getState();
            String title3 = tariffBanner.getTitle();
            AttributedText description4 = tariffBanner.getDescription();
            Boolean isExclaimed = tariffBanner.isExclaimed();
            List<TariffAlertAction> actions = tariffBanner.getActions();
            if (actions != null) {
                ArrayList arrayList9 = new ArrayList(e.collectionSizeOrDefault(actions, 10));
                for (T t9 : actions) {
                    if (t9 instanceof DeepLinkAction) {
                        T t10 = t9;
                        obj = new DeepLinkActionItem(t10.getTitle(), t10.getButtonStyle(), t10.getDeeplink());
                    } else if (t9 instanceof TariffSheetAction) {
                        T t11 = t9;
                        obj = new TariffSheetActionItem(t11.getTitle(), t11.getButtonStyle(), t11.getTariffSheet());
                    } else if (t9 instanceof ShowNextAction) {
                        T t12 = t9;
                        obj = new ShowNextActionItem(t12.getTitle(), t12.getButtonStyle());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList9.add(obj);
                }
                arrayList = arrayList9;
            } else {
                arrayList = null;
            }
            alertDialogItem = new AlertDialogItem("alert_dialog_item", new TariffBannerItem(state, title3, description4, isExclaimed, arrayList));
        } else {
            alertDialogItem = null;
        }
        return new TariffEditConvertInfo(tariffEditInfo, alertDialogItem, tabsItem);
    }
}
