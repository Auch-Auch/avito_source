package com.avito.android.messenger.service;

import android.content.Context;
import androidx.work.Worker;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/di/ComponentDependencies;", "T", "Landroidx/work/Worker;", "findComponentDependencies", "(Landroidx/work/Worker;)Lcom/avito/android/di/ComponentDependencies;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class WorkerKt {
    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(Worker worker) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(worker, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        Context applicationContext = worker.getApplicationContext();
        if (worker instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) worker;
        } else if (applicationContext instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) applicationContext;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + worker);
        }
        return (T) ComponentDependenciesKt.getDependencies(ComponentDependencies.class, hasComponentDependencies);
    }
}
