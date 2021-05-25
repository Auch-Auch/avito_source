package ru.sravni.android.bankproduct.domain.dashboard;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.dashboard.entity.ChatProgressDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.HelloMessageInfo;
import ru.sravni.android.bankproduct.domain.dashboard.entity.OfferCalculationElementDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardRepository;", "", "", "Lru/sravni/android/bankproduct/domain/dashboard/entity/HelloMessageInfo;", "getListHelloMessages", "()Ljava/util/List;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "", "getNameUser", "()Lio/reactivex/Observable;", "", "getHourNow", "()I", "Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "getOfferCalculatedList", "Lru/sravni/android/bankproduct/domain/dashboard/entity/ChatProgressDomain;", "getChatProgress", "", "nextIcon", "()V", "getIconNumChannel", "iconNumChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDashBoardRepository {
    @NotNull
    Observable<ChatProgressDomain> getChatProgress();

    int getHourNow();

    @NotNull
    Observable<Integer> getIconNumChannel();

    @NotNull
    List<HelloMessageInfo> getListHelloMessages();

    @NotNull
    Observable<DataContainer<String>> getNameUser();

    @NotNull
    Observable<List<OfferCalculationElementDomain>> getOfferCalculatedList();

    void nextIcon();
}
