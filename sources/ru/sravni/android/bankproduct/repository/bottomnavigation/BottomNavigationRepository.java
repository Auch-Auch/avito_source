package ru.sravni.android.bankproduct.repository.bottomnavigation;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.bottomnavigation.IBottomNavigationRepository;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/repository/bottomnavigation/BottomNavigationRepository;", "Lru/sravni/android/bankproduct/domain/bottomnavigation/IBottomNavigationRepository;", "", "selectItem", "", "saveSelectedItemBottomNavigation", "(Ljava/lang/Integer;)V", "Lio/reactivex/Observable;", "getSelectedItemBottomNavigation", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/bottomnavigation/IBottomNavigationStorage;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/bottomnavigation/IBottomNavigationStorage;", "bottomNavigationStorage", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "<init>", "(Lru/sravni/android/bankproduct/repository/bottomnavigation/IBottomNavigationStorage;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BottomNavigationRepository implements IBottomNavigationRepository {
    public final IBottomNavigationStorage a;
    public final IErrorLogger b;
    public final IThrowableWrapper c;

    public BottomNavigationRepository(@NotNull IBottomNavigationStorage iBottomNavigationStorage, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iBottomNavigationStorage, "bottomNavigationStorage");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.a = iBottomNavigationStorage;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.bottomnavigation.IBottomNavigationRepository
    @NotNull
    public Observable<Integer> getSelectedItemBottomNavigation() {
        int i;
        try {
            i = this.a.getSelectedItemBottomNavigation();
        } catch (Throwable th) {
            this.b.logError(MessagePriority.ERROR, this.c.wrap(th));
            i = 0;
        }
        Observable<Integer> just = Observable.just(Integer.valueOf(i));
        Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(selectedItem)");
        return just;
    }

    @Override // ru.sravni.android.bankproduct.domain.bottomnavigation.IBottomNavigationRepository
    public void saveSelectedItemBottomNavigation(@Nullable Integer num) {
        if (num != null) {
            try {
                this.a.saveSelectedItemBottomNavigation(num.intValue());
            } catch (Throwable th) {
                this.b.logError(MessagePriority.ERROR, this.c.wrap(th));
            }
        }
    }
}
