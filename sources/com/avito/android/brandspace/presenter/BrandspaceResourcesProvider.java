package com.avito.android.brandspace.presenter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "", "", "isAboutWide", "()Z", "", "getContentHorizontalPadding", "()I", "contentHorizontalPadding", "getPropertyTopPadding", "propertyTopPadding", "getBrandspaceColumnCount", "brandspaceColumnCount", "", "getDefaultConnectionError", "()Ljava/lang/String;", "defaultConnectionError", "getEmptyPropertyValue", "emptyPropertyValue", "isTablet", "getAdvertSpan", "advertSpan", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceResourcesProvider {
    int getAdvertSpan();

    int getBrandspaceColumnCount();

    int getContentHorizontalPadding();

    @NotNull
    String getDefaultConnectionError();

    @NotNull
    String getEmptyPropertyValue();

    int getPropertyTopPadding();

    boolean isAboutWide();

    boolean isTablet();
}
