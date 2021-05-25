package com.avito.android.short_term_rent.hotels;

import com.avito.android.remote.model.hotels.DiscountBanner;
import com.avito.android.remote.model.hotels.Information;
import com.avito.android.short_term_rent.hotels.data.FiltersData;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\r\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u001a\u0010\u000bJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsView;", "", "", "errorMessage", "", "showErrorInSnackBar", "(Ljava/lang/String;)V", "stopLoading", "()V", "Lio/reactivex/rxjava3/core/Observable;", "retryLoadingClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "findButtonClicks", "title", "", "Lcom/avito/android/remote/model/hotels/Information;", "information", "Lcom/avito/android/remote/model/hotels/DiscountBanner;", "discountBanner", "fillFormWithData", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/hotels/DiscountBanner;)V", "showProgress", "showContent", "showRetry", "dateFilterClicks", "locationFilterClicks", "guestsFilterClicks", "Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "filtersData", "fillFiltersWithData", "(Lcom/avito/android/short_term_rent/hotels/data/FiltersData;)V", "showLocationError", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface HotelsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showErrorInSnackBar$default(HotelsView hotelsView, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                hotelsView.showErrorInSnackBar(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorInSnackBar");
        }
    }

    @NotNull
    Observable<Unit> dateFilterClicks();

    void fillFiltersWithData(@NotNull FiltersData filtersData);

    void fillFormWithData(@NotNull String str, @NotNull List<Information> list, @Nullable DiscountBanner discountBanner);

    @NotNull
    Observable<Unit> findButtonClicks();

    @NotNull
    Observable<Unit> guestsFilterClicks();

    @NotNull
    Observable<Unit> locationFilterClicks();

    @NotNull
    Observable<Unit> retryLoadingClicks();

    void showContent();

    void showErrorInSnackBar(@Nullable String str);

    void showLocationError();

    void showProgress();

    void showRetry();

    void stopLoading();

    @NotNull
    Observable<Unit> upButtonClicks();
}
