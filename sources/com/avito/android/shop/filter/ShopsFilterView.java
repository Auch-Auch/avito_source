package com.avito.android.shop.filter;

import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H&¢\u0006\u0004\b\u0019\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterView;", "", "", "showRetryOverlay", "()V", "showLoading", "hideLoading", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Category;", "category", "setSelectedCategory", "(Lcom/avito/android/remote/model/Category;)V", "Lcom/avito/android/remote/model/Location;", "location", "setSelectedLocation", "(Lcom/avito/android/remote/model/Location;)V", "setDefaultLocation", "Lcom/avito/konveyor/data_source/DataSource;", "categories", "setCategories", "(Lcom/avito/konveyor/data_source/DataSource;)V", "title", "setToolbar", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopsFilterView {
    void hideLoading();

    void setCategories(@NotNull DataSource<Category> dataSource);

    void setDefaultLocation(@NotNull Location location);

    void setSelectedCategory(@Nullable Category category);

    void setSelectedLocation(@Nullable Location location);

    void setToolbar(@NotNull String str);

    void showError(@NotNull String str);

    void showLoading();

    void showRetryOverlay();
}
