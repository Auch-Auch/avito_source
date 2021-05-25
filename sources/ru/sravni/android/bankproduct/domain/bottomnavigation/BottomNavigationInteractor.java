package ru.sravni.android.bankproduct.domain.bottomnavigation;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/domain/bottomnavigation/BottomNavigationInteractor;", "Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationInteractor;", "", "selectItem", "", "saveSelectedItemBottomNavigation", "(Ljava/lang/Integer;)V", "Lio/reactivex/Observable;", "getSelectedItemBottomNavigation", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationRepository;", "bottomNavigationRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationRepository;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BottomNavigationInteractor implements IBottomNavigationInteractor {
    public final IBottomNavigationRepository a;

    public BottomNavigationInteractor(@NotNull IBottomNavigationRepository iBottomNavigationRepository) {
        Intrinsics.checkParameterIsNotNull(iBottomNavigationRepository, "bottomNavigationRepository");
        this.a = iBottomNavigationRepository;
    }

    @Override // ru.sravni.android.bankproduct.domain.bottomnavigation.IBottomNavigationInteractor
    @NotNull
    public Observable<Integer> getSelectedItemBottomNavigation() {
        return this.a.getSelectedItemBottomNavigation();
    }

    @Override // ru.sravni.android.bankproduct.domain.bottomnavigation.IBottomNavigationInteractor
    public void saveSelectedItemBottomNavigation(@Nullable Integer num) {
        this.a.saveSelectedItemBottomNavigation(num);
    }
}
