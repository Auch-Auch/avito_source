package com.avito.android.lib.design.snackbar.util;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarModule;", "", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "provideCompositeSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CompositeSnackbarModule {
    @NotNull
    public static final CompositeSnackbarModule INSTANCE = new CompositeSnackbarModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final CompositeSnackbarPresenter provideCompositeSnackbarPresenter() {
        return new CompositeSnackbarPresenterImpl();
    }
}
