package com.avito.android.util.di;

import android.app.Application;
import android.content.ClipboardManager;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.ClipDataFactoryImpl;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/di/ClipboardModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/ClipboardManager;", "provideClipboardManager$android_release", "(Landroid/app/Application;)Landroid/content/ClipboardManager;", "provideClipboardManager", "<init>", "()V", "Declarations", "android_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ClipboardModule {
    @NotNull
    public static final ClipboardModule INSTANCE = new ClipboardModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/di/ClipboardModule$Declarations;", "", "Lcom/avito/android/util/ClipDataFactoryImpl;", "factory", "Lcom/avito/android/util/ClipDataFactory;", "bindClipDataFactory", "(Lcom/avito/android/util/ClipDataFactoryImpl;)Lcom/avito/android/util/ClipDataFactory;", "android_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        ClipDataFactory bindClipDataFactory(@NotNull ClipDataFactoryImpl clipDataFactoryImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ClipboardManager provideClipboardManager$android_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Object systemService = application.getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }
}
