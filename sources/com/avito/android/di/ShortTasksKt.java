package com.avito.android.di;

import com.avito.android.BaseApp;
import com.avito.android.service.short_task.ShortTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/di/ComponentDependencies;", "T", "Lcom/avito/android/service/short_task/ShortTask;", "findComponentDependencies", "(Lcom/avito/android/service/short_task/ShortTask;)Lcom/avito/android/di/ComponentDependencies;", "application_release"}, k = 2, mv = {1, 4, 2})
public final class ShortTasksKt {
    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(ShortTask shortTask) {
        Intrinsics.checkNotNullParameter(shortTask, "$this$findComponentDependencies");
        BaseApp instance = BaseApp.Companion.getInstance();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) ComponentDependenciesKt.getDependencies(ComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(instance));
    }
}
