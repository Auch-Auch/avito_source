package com.avito.android.home;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/home/HomePresenterResourcesProviderImpl;", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "", "locality", "getEmptyScreenTitle", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getColumnsCount", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "", AuthSource.SEND_ABUSE, "Z", "isTablet", "()Z", "()I", "columnsCount", "getAllCategoriesLarge", "()Ljava/lang/String;", "allCategoriesLarge", "getAllCategories", "allCategories", "getSelectCategory", "selectCategory", "getDividerTitle", "dividerTitle", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomePresenterResourcesProviderImpl implements HomePresenterResourcesProvider {
    public final boolean a;
    public final Resources b;

    @Inject
    public HomePresenterResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.a = resources.getBoolean(R.bool.is_tablet);
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    @NotNull
    public String getAllCategories() {
        String string = this.b.getString(com.avito.android.serp.R.string.all_categories);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.all_categories)");
        return string;
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    @NotNull
    public String getAllCategoriesLarge() {
        String string = this.b.getString(R.string.rubricator_show_all_categories);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…ator_show_all_categories)");
        return string;
    }

    @Override // com.avito.android.home.ColumnsCountProvider
    public int getColumnsCount() {
        return this.b.getInteger(R.integer.serp_columns);
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    @NotNull
    public String getDividerTitle() {
        String string = this.b.getString(com.avito.android.serp.R.string.new_adverts);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.new_adverts)");
        return string;
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    @NotNull
    public String getEmptyScreenTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locality");
        String string = this.b.getString(com.avito.android.serp.R.string.create_first_advert_advice, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_advert_advice, locality)");
        return string;
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    @NotNull
    public String getSelectCategory() {
        String string = this.b.getString(com.avito.android.serp.R.string.select_category);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.select_category)");
        return string;
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    public boolean isTablet() {
        return this.a;
    }

    @Override // com.avito.android.home.HomePresenterResourcesProvider
    public int getColumnsCount(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (serpDisplayType.isSingleColumn()) {
            return 1;
        }
        return getColumnsCount();
    }
}
