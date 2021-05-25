package ru.sravni.android.bankproduct.domain.dashboard;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.dashboard.entity.DraftDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.OfferCalculationElementDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.RestoreStorageIntentInfoDomain;
import ru.sravni.android.bankproduct.utils.product.SravniProductItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\u000bR\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00060\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00060\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardInteractor;", "", "Lio/reactivex/Observable;", "", "getHelloMessage", "()Lio/reactivex/Observable;", "", "Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "getOfferCalculatedList", "", "getChatProgress", "()V", "nextFaceImage", "getFaceResource", "Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "getListFinanceProduct", "()Ljava/util/List;", "getListInsuranceProduct", "Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "getRestoreStorageIntentInfo", "()Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "clearRestoredPushInfo", "Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", "getListInsuranceDraftChannel", "listInsuranceDraftChannel", "getListFinanceDraftChannel", "listFinanceDraftChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDashBoardInteractor {
    void clearRestoredPushInfo();

    void getChatProgress();

    @NotNull
    Observable<Integer> getFaceResource();

    @NotNull
    Observable<Integer> getHelloMessage();

    @NotNull
    Observable<List<DraftDomain>> getListFinanceDraftChannel();

    @NotNull
    List<SravniProductItem> getListFinanceProduct();

    @NotNull
    Observable<List<DraftDomain>> getListInsuranceDraftChannel();

    @NotNull
    List<SravniProductItem> getListInsuranceProduct();

    @NotNull
    Observable<List<OfferCalculationElementDomain>> getOfferCalculatedList();

    @Nullable
    RestoreStorageIntentInfoDomain getRestoreStorageIntentInfo();

    void nextFaceImage();
}
