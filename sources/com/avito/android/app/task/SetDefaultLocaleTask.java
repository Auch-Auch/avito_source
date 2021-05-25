package com.avito.android.app.task;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/app/task/SetDefaultLocaleTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SetDefaultLocaleTask implements ApplicationBlockingStartupTask {
    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        Locale locale = new Locale("ru");
        if (!Intrinsics.areEqual(locale, Locale.getDefault())) {
            Locale.setDefault(locale);
        }
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (locale2 == null || (!Intrinsics.areEqual(locale, locale2))) {
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, null);
        }
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
