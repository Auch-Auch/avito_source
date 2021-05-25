package ru.sravni.android.bankproduct.repository.dashboard;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.dashboard.entity.HelloMessageInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardStorage;", "", "", "Lru/sravni/android/bankproduct/repository/dashboard/entity/HelloMessageInfoRepo;", "getListHelloMessages", "()Ljava/util/List;", "", "nextIcon", "()V", "Lio/reactivex/Observable;", "", "getIconSourceChannel", "()Lio/reactivex/Observable;", "iconSourceChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDashBoardStorage {
    @NotNull
    Observable<Integer> getIconSourceChannel();

    @NotNull
    List<HelloMessageInfoRepo> getListHelloMessages();

    void nextIcon();
}
