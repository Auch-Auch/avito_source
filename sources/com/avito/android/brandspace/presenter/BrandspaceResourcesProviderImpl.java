package com.avito.android.brandspace.presenter;

import android.content.res.Resources;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b \u0010!R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u001d\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\f¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProviderImpl;", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "c", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "callAdapterFactoryResourceProvider", "", "getBrandspaceColumnCount", "()I", "brandspaceColumnCount", "getContentHorizontalPadding", "contentHorizontalPadding", "", "getEmptyPropertyValue", "()Ljava/lang/String;", "emptyPropertyValue", "", "isAboutWide", "()Z", "getDefaultConnectionError", "defaultConnectionError", "getPropertyTopPadding", "propertyTopPadding", AuthSource.SEND_ABUSE, "Z", "isTablet", "getAdvertSpan", "advertSpan", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceResourcesProviderImpl implements BrandspaceResourcesProvider {
    public final boolean a;
    public final Resources b;
    public final CallAdapterFactoryResourceProvider c;

    @Inject
    public BrandspaceResourcesProviderImpl(@NotNull Resources resources, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "callAdapterFactoryResourceProvider");
        this.b = resources;
        this.c = callAdapterFactoryResourceProvider;
        this.a = resources.getBoolean(R.bool.is_tablet);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public int getAdvertSpan() {
        return this.b.getInteger(com.avito.android.brandspace.R.integer.brandspace_advert_span);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public int getBrandspaceColumnCount() {
        return this.b.getInteger(com.avito.android.brandspace.R.integer.brandspace_column_count);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public int getContentHorizontalPadding() {
        return this.b.getDimensionPixelOffset(com.avito.android.brandspace.R.dimen.brandspace_content_horizontal_padding);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    @NotNull
    public String getDefaultConnectionError() {
        return this.c.getUnknownError();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    @NotNull
    public String getEmptyPropertyValue() {
        String string = this.b.getString(com.avito.android.brandspace.R.string.brandspace_empty_property_value);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ace_empty_property_value)");
        return string;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public int getPropertyTopPadding() {
        return this.b.getDimensionPixelOffset(com.avito.android.brandspace.R.dimen.brandspace_productcomparison_property_header_padding_top);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public boolean isAboutWide() {
        return this.b.getBoolean(com.avito.android.brandspace.R.bool.brandspace_is_about_wide);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceResourcesProvider
    public boolean isTablet() {
        return this.a;
    }
}
