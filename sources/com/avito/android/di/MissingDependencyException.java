package com.avito.android.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/di/MissingDependencyException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/avito/android/di/HasComponentDependencies;", "source", "Ljava/lang/Class;", "Lcom/avito/android/di/ComponentDependencies;", "dependency", "<init>", "(Lcom/avito/android/di/HasComponentDependencies;Ljava/lang/Class;)V", "dagger-scopes_release"}, k = 1, mv = {1, 4, 2})
public final class MissingDependencyException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissingDependencyException(@NotNull HasComponentDependencies hasComponentDependencies, @NotNull Class<? extends ComponentDependencies> cls) {
        super("Can't find " + cls.getCanonicalName() + " dependency. Probable reasons: \n- " + hasComponentDependencies.getClass().getCanonicalName() + " doesn't implement " + cls.getCanonicalName() + "\n- " + cls.getCanonicalName() + " is not provided in dependencies. See HasComponentDependencies interface. For Avito app - ComponentDependenciesModule.");
        Intrinsics.checkNotNullParameter(hasComponentDependencies, "source");
        Intrinsics.checkNotNullParameter(cls, "dependency");
    }
}
