package com.avito.android.remote.error;

import android.app.Application;
import android.content.res.Resources;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/error/ErrorConverterModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "provideErrorConverter", "(Landroid/app/Application;)Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ErrorConverterModule {
    @NotNull
    public static final ErrorConverterModule INSTANCE = new ErrorConverterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final TypedErrorThrowableConverter provideErrorConverter(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return new TypedErrorThrowableConverterImpl(resources, null, 2, null);
    }
}
