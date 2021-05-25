package com.avito.android.search.filter;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/filter/FiltersResourceProviderImpl;", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "", "getPositiveButtonText", "()Ljava/lang/String;", "getNegativeButtonText", "getCategoriesTitle", "getSubcategoriesTitle", "getNoAdverts", "getShowAdverts", "", "canSwitchDisplayType", "()Z", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersResourceProviderImpl implements FiltersResourceProvider {
    public final Resources a;

    @Inject
    public FiltersResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.ResourceProvider
    public boolean canSwitchDisplayType() {
        return this.a.getBoolean(R.bool.can_switch_display_type);
    }

    @Override // com.avito.android.search.filter.CategoriesParameterFactory.TitleProvider
    @NotNull
    public String getCategoriesTitle() {
        String string = this.a.getString(R.string.category);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.category)");
        return string;
    }

    @Override // com.avito.android.search.filter.DialogResourceProvider
    @NotNull
    public String getNegativeButtonText() {
        String string = this.a.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.cancel)");
        return string;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.ResourceProvider
    @NotNull
    public String getNoAdverts() {
        String string = this.a.getString(R.string.zero_adverts);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.zero_adverts)");
        return string;
    }

    @Override // com.avito.android.search.filter.DialogResourceProvider
    @NotNull
    public String getPositiveButtonText() {
        String string = this.a.getString(R.string.list_dialog_positive);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.list_dialog_positive)");
        return string;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.ResourceProvider
    @NotNull
    public String getShowAdverts() {
        String string = this.a.getString(R.string.show_items);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.show_items)");
        return string;
    }

    @Override // com.avito.android.search.filter.CategoriesParameterFactory.TitleProvider
    @NotNull
    public String getSubcategoriesTitle() {
        String string = this.a.getString(R.string.subcategory);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.subcategory)");
        return string;
    }
}
