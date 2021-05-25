package com.avito.android.hints.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.hints.HintsDialogFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/hints/di/HintsComponent;", "", "Lcom/avito/android/hints/HintsDialogFragment;", "hintsDialogFragment", "", "inject", "(Lcom/avito/android/hints/HintsDialogFragment;)V", "Builder", "hints_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HintsDependencies.class}, modules = {HintsModule.class, ListModule.class})
@PerFragment
public interface HintsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/hints/di/HintsComponent$Builder;", "", "Lcom/avito/android/hints/di/HintsDependencies;", "dependencies", "(Lcom/avito/android/hints/di/HintsDependencies;)Lcom/avito/android/hints/di/HintsComponent$Builder;", "", "type", "hintType", "(Ljava/lang/String;)Lcom/avito/android/hints/di/HintsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/hints/di/HintsComponent$Builder;", "Lcom/avito/android/hints/di/HintsComponent;", "build", "()Lcom/avito/android/hints/di/HintsComponent;", "hints_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        HintsComponent build();

        @NotNull
        Builder dependencies(@NotNull HintsDependencies hintsDependencies);

        @BindsInstance
        @NotNull
        Builder hintType(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull HintsDialogFragment hintsDialogFragment);
}
