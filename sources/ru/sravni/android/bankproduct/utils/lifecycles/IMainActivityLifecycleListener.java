package ru.sravni.android.bankproduct.utils.lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/utils/lifecycles/IMainActivityLifecycleListener;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "onCreate", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onStart", "onResume", "onPause", "onStop", "onRestart", "onDestroy", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IMainActivityLifecycleListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onCreate(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onDestroy(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onPause(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onRestart(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onResume(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onStart(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }

        public static void onStop(IMainActivityLifecycleListener iMainActivityLifecycleListener, @NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        }
    }

    void onCreate(@NotNull AppCompatActivity appCompatActivity);

    void onDestroy(@NotNull AppCompatActivity appCompatActivity);

    void onPause(@NotNull AppCompatActivity appCompatActivity);

    void onRestart(@NotNull AppCompatActivity appCompatActivity);

    void onResume(@NotNull AppCompatActivity appCompatActivity);

    void onStart(@NotNull AppCompatActivity appCompatActivity);

    void onStop(@NotNull AppCompatActivity appCompatActivity);
}
