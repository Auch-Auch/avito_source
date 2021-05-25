package ru.sravni.android.bankproduct.utils.lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lru/sravni/android/bankproduct/utils/lifecycles/IActivityLifecycleListenerContainer;", "Lru/sravni/android/bankproduct/utils/lifecycles/IMainActivityLifecycleListener;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IActivityLifecycleListenerContainer extends IMainActivityLifecycleListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onCreate(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onCreate(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onDestroy(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onDestroy(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onPause(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onPause(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onRestart(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onRestart(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onResume(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onResume(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onStart(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onStart(iActivityLifecycleListenerContainer, appCompatActivity);
        }

        public static void onStop(IActivityLifecycleListenerContainer iActivityLifecycleListenerContainer, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            IMainActivityLifecycleListener.DefaultImpls.onStop(iActivityLifecycleListenerContainer, appCompatActivity);
        }
    }
}
