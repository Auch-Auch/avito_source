package ru.sravni.android.bankproduct.repository.dashboard;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.OfferCalculationElementRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;", "", "Lio/reactivex/Observable;", "", "Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "getOfferCalculatedList", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "getChatProgress", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDashBoardWebClient {
    @NotNull
    Observable<ChatProgressRepo> getChatProgress();

    @NotNull
    Observable<List<OfferCalculationElementRepo>> getOfferCalculatedList();
}
