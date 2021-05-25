package com.avito.android.shop.filter;

import android.os.Bundle;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "Lcom/avito/android/shop/filter/ShopsFilterViewPresenter;", "Lcom/avito/android/shop/filter/ShopsFilterView;", "view", "", "attachView", "(Lcom/avito/android/shop/filter/ShopsFilterView;)V", "detachView", "()V", "Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveInstanceState", "()Landroid/os/Bundle;", "Router", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopsFilterPresenter extends ShopsFilterViewPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;", "", "Lcom/avito/android/remote/model/Location;", "location", "", "showLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "onBackClicked", "()V", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "Lcom/avito/android/remote/model/CaseText;", "locationNames", "showResults", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Lcom/avito/android/remote/model/CaseText;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onBackClicked();

        void showLocationScreen(@Nullable Location location);

        void showResults(@NotNull ShopsSearchParameters shopsSearchParameters, @NotNull CaseText caseText);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ShopsFilterView shopsFilterView);

    void detachRouter();

    void detachView();

    @NotNull
    Bundle onSaveInstanceState();
}
