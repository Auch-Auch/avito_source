package com.avito.android.tariff.edit_info.ui;

import com.avito.konveyor.blueprint.ViewTypeProvider;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "", "getButtonViewType", "()I", "buttonViewType", "getAddCategoryViewType", "addCategoryViewType", "getPackagesTitleViewType", "packagesTitleViewType", "getInfoViewType", "infoViewType", "getTabsViewType", "tabsViewType", "getHeaderViewType", "headerViewType", "getProlongationViewType", "prolongationViewType", "getEditPackageViewType", "editPackageViewType", "getManagerCallViewType", "managerCallViewType", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface EditInfoViewTypeProvider extends ViewTypeProvider {
    int getAddCategoryViewType();

    int getButtonViewType();

    int getEditPackageViewType();

    int getHeaderViewType();

    int getInfoViewType();

    int getManagerCallViewType();

    int getPackagesTitleViewType();

    int getProlongationViewType();

    int getTabsViewType();
}
