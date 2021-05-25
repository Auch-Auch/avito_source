package ru.sravni.android.bankproduct.utils.lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/utils/lifecycles/ActivityLifecycleListenerContainer;", "Lru/sravni/android/bankproduct/utils/lifecycles/IActivityLifecycleListenerContainer;", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "onCreate", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onStart", "onResume", "onPause", "onStop", "onRestart", "onDestroy", "", "Lru/sravni/android/bankproduct/utils/lifecycles/IMainActivityLifecycleListener;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "listenerList", "<init>", "(Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ActivityLifecycleListenerContainer implements IActivityLifecycleListenerContainer {
    public final List<IMainActivityLifecycleListener> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener> */
    /* JADX WARN: Multi-variable type inference failed */
    public ActivityLifecycleListenerContainer(@NotNull List<? extends IMainActivityLifecycleListener> list) {
        Intrinsics.checkParameterIsNotNull(list, "listenerList");
        this.a = list;
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onCreate(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onCreate(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onDestroy(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDestroy(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onPause(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPause(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onRestart(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRestart(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onResume(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onResume(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onStart(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onStart(appCompatActivity);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener
    public void onStop(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onStop(appCompatActivity);
        }
    }
}
