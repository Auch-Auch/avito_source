package ru.sravni.android.bankproduct.domain.bottomnavigation;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationRepository;", "", "", "selectItem", "", "saveSelectedItemBottomNavigation", "(Ljava/lang/Integer;)V", "Lio/reactivex/Observable;", "getSelectedItemBottomNavigation", "()Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IBottomNavigationRepository {
    @NotNull
    Observable<Integer> getSelectedItemBottomNavigation();

    void saveSelectedItemBottomNavigation(@Nullable Integer num);
}
