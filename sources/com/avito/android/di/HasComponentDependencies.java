package com.avito.android.di;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R3\u0010\t\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0002j\u0002`\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/di/HasComponentDependencies;", "", "", "Ljava/lang/Class;", "Lcom/avito/android/di/ComponentDependencies;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/avito/android/di/ComponentDependenciesProvider;", "getDependencies", "()Ljava/util/Map;", "dependencies", "dagger-scopes_release"}, k = 1, mv = {1, 4, 2})
public interface HasComponentDependencies {
    @NotNull
    Map<Class<? extends ComponentDependencies>, ComponentDependencies> getDependencies();
}
