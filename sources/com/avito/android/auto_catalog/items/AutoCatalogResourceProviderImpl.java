package com.avito.android.auto_catalog.items;

import android.content.res.Resources;
import com.avito.android.auto_catalog.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProviderImpl;", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "", "spanCount", "()I", "", "selectModificationText", "()Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public class AutoCatalogResourceProviderImpl implements AutoCatalogResourceProvider {
    public final Resources a;

    @Inject
    public AutoCatalogResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.auto_catalog.items.AutoCatalogResourceProvider
    @NotNull
    public String selectModificationText() {
        String string = this.a.getString(R.string.modifications_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.modifications_title)");
        return string;
    }

    @Override // com.avito.android.auto_catalog.items.AutoCatalogResourceProvider
    public int spanCount() {
        return this.a.getInteger(com.avito.android.ui_components.R.integer.similar_adverts_columns);
    }
}
