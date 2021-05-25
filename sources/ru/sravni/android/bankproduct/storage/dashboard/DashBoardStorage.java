package ru.sravni.android.bankproduct.storage.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.dashboard.IDashBoardStorage;
import ru.sravni.android.bankproduct.repository.dashboard.entity.HelloMessageInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\u000bR*\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001b\u001a\n \u000f*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001f\u0010\u000b¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/storage/dashboard/DashBoardStorage;", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardStorage;", "", "nextIcon", "()V", "", "Lru/sravni/android/bankproduct/repository/dashboard/entity/HelloMessageInfoRepo;", "getListHelloMessages", "()Ljava/util/List;", "", "d", "Ljava/lang/String;", "prefsName", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lio/reactivex/subjects/BehaviorSubject;", "getIconSourceChannel", "()Lio/reactivex/subjects/BehaviorSubject;", "iconSourceChannel", AuthSource.SEND_ABUSE, "Ljava/util/List;", "faceSrcList", "Landroid/content/SharedPreferences;", "f", "Landroid/content/SharedPreferences;", "prefs", "c", "I", "iconNum", "e", "iconNumField", "Landroid/content/Context;", "context", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "<init>", "(Landroid/content/Context;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardStorage implements IDashBoardStorage {
    public final List<Integer> a = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.ic_girl_sravni), Integer.valueOf(R.drawable.ic_old_girl_sravni), Integer.valueOf(R.drawable.ic_boy_sravni), Integer.valueOf(R.drawable.ic_man_sravni), Integer.valueOf(R.drawable.ic_nerd_sravni), Integer.valueOf(R.drawable.ic_black_man_sravni)});
    @NotNull
    public final BehaviorSubject<Integer> b;
    public int c;
    public final String d;
    public final String e;
    public final SharedPreferences f;

    public DashBoardStorage(@NotNull Context context, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        int i = 0;
        BehaviorSubject<Integer> create = BehaviorSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "BehaviorSubject.create<Int>()");
        this.b = create;
        this.d = "SravniDashboardSP";
        this.e = "iconNumField";
        SharedPreferences sharedPreferences = context.getSharedPreferences("SravniDashboardSP", 0);
        this.f = sharedPreferences;
        try {
            i = sharedPreferences.getInt("iconNumField", 0);
        } catch (Throwable th) {
            iErrorLogger.logError(MessagePriority.WARN, iThrowableWrapper.wrap(th));
            this.f.edit().putInt(this.e, 0).apply();
        }
        this.c = i;
        BehaviorSubject<Integer> iconSourceChannel = getIconSourceChannel();
        List<Integer> list = this.a;
        iconSourceChannel.onNext(list.get(this.c % list.size()));
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardStorage
    @NotNull
    public List<HelloMessageInfoRepo> getListHelloMessages() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new HelloMessageInfoRepo[]{new HelloMessageInfoRepo(5, 12, R.string.good_morning), new HelloMessageInfoRepo(12, 18, R.string.good_day), new HelloMessageInfoRepo(18, 24, R.string.good_evening), new HelloMessageInfoRepo(0, 5, R.string.good_night)});
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardStorage
    public void nextIcon() {
        this.c++;
        BehaviorSubject<Integer> iconSourceChannel = getIconSourceChannel();
        List<Integer> list = this.a;
        iconSourceChannel.onNext(list.get(this.c % list.size()));
        this.f.edit().putInt(this.e, this.c).apply();
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardStorage
    @NotNull
    public BehaviorSubject<Integer> getIconSourceChannel() {
        return this.b;
    }
}
