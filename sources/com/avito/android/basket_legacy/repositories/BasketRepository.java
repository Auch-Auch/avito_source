package com.avito.android.basket_legacy.repositories;

import com.avito.android.basket_legacy.utils.PackageService;
import com.avito.android.basket_legacy.utils.PaidService;
import com.avito.android.basket_legacy.utils.SingleFeeService;
import com.avito.android.basket_legacy.utils.VasService;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\bH&¢\u0006\u0004\b\u001c\u0010\u000bR\u0016\u0010 \u001a\u00020\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0016\u0010'\u001a\u00020\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001fR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\"\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010#R\u0016\u0010.\u001a\u00020\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001fR\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#¨\u00061"}, d2 = {"Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "", "Lcom/avito/android/basket_legacy/utils/VasService;", "vas", "", "addVas", "(Lcom/avito/android/basket_legacy/utils/VasService;)V", "addFirstStepVas", "", "vasList", "addSecondStepVas", "(Ljava/util/List;)V", "", "id", "removeVas", "(Ljava/lang/String;)V", "clearFirstStepVasSelection", "()V", "Lcom/avito/android/basket_legacy/utils/PackageService;", "ownedPackage", "addPackage", "(Lcom/avito/android/basket_legacy/utils/PackageService;)V", "Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "singleFee", "addSingleFee", "(Lcom/avito/android/basket_legacy/utils/SingleFeeService;)V", "Lcom/avito/android/basket_legacy/utils/PaidService;", "list", "restoreSelection", "", "getContainsVas", "()Z", "containsVas", "Lio/reactivex/Observable;", "getLfPackageObservable", "()Lio/reactivex/Observable;", "lfPackageObservable", "isEmpty", "getContainsLfPackage", "containsLfPackage", "getSelectedServices", "()Ljava/util/List;", "selectedServices", "getVasObservable", "vasObservable", "getContainsListingFees", "containsListingFees", "getSingleFeeObservable", "singleFeeObservable", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface BasketRepository {
    void addFirstStepVas(@NotNull VasService vasService);

    void addPackage(@NotNull PackageService packageService);

    void addSecondStepVas(@NotNull List<VasService> list);

    void addSingleFee(@NotNull SingleFeeService singleFeeService);

    void addVas(@NotNull VasService vasService);

    void clearFirstStepVasSelection();

    boolean getContainsLfPackage();

    boolean getContainsListingFees();

    boolean getContainsVas();

    @NotNull
    Observable<PackageService> getLfPackageObservable();

    @NotNull
    List<PaidService> getSelectedServices();

    @NotNull
    Observable<SingleFeeService> getSingleFeeObservable();

    @NotNull
    Observable<List<VasService>> getVasObservable();

    boolean isEmpty();

    void removeVas(@NotNull String str);

    void restoreSelection(@NotNull List<? extends PaidService> list);
}
