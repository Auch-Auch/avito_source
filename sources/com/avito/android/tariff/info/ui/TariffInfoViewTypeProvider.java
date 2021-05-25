package com.avito.android.tariff.info.ui;

import com.avito.konveyor.blueprint.ViewTypeProvider;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "", "getDisclaimerViewType", "()I", "disclaimerViewType", "getHeaderViewType", "headerViewType", "getInfoViewType", "infoViewType", "getPackagesTitleViewType", "packagesTitleViewType", "getPackageViewType", "packageViewType", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffInfoViewTypeProvider extends ViewTypeProvider {
    int getDisclaimerViewType();

    int getHeaderViewType();

    int getInfoViewType();

    int getPackageViewType();

    int getPackagesTitleViewType();
}
