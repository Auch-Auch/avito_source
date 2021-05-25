package com.avito.android.di;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ContentProvider;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0005H\b¢\u0006\u0004\b\u0003\u0010\u0006\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0007H\b¢\u0006\u0004\b\u0003\u0010\b\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\tH\b¢\u0006\u0004\b\u0003\u0010\n\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u000bH\b¢\u0006\u0004\b\u0003\u0010\f\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\rH\b¢\u0006\u0004\b\u0003\u0010\u000e\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u000fH\b¢\u0006\u0004\b\u0003\u0010\u0010\u001a'\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u00110\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0017\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\t¢\u0006\u0004\b\u001c\u0010\u001e\u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001f\u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\r¢\u0006\u0004\b\u001c\u0010 \u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\u000f¢\u0006\u0004\b\u001c\u0010!\u001a.\u0010\u001c\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019j\u0002`\u001b*\u00020\u0005¢\u0006\u0004\b\u001c\u0010\"\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\u0007¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\t¢\u0006\u0004\b#\u0010%\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\u000b¢\u0006\u0004\b#\u0010&\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\r¢\u0006\u0004\b#\u0010'\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\u000f¢\u0006\u0004\b#\u0010(\u001a\u0011\u0010#\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b#\u0010)\u001a*\u0010#\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020**\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u0005H\b¢\u0006\u0004\b#\u0010,\u001a\u0018\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020*H\b¢\u0006\u0004\b/\u00100*<\u00101\"\u001b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u00192\u001b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0011\u0012\t\u0012\u00070\u0000¢\u0006\u0002\b\u001a0\u0019¨\u00062"}, d2 = {"Lcom/avito/android/di/ComponentDependencies;", "T", "Lcom/avito/android/di/HasComponentDependencies;", "findComponentDependencies", "(Lcom/avito/android/di/HasComponentDependencies;)Lcom/avito/android/di/ComponentDependencies;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/avito/android/di/ComponentDependencies;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/di/ComponentDependencies;", "Landroid/app/Activity;", "(Landroid/app/Activity;)Lcom/avito/android/di/ComponentDependencies;", "Landroid/view/View;", "(Landroid/view/View;)Lcom/avito/android/di/ComponentDependencies;", "Landroid/app/Service;", "(Landroid/app/Service;)Lcom/avito/android/di/ComponentDependencies;", "Landroid/content/ContentProvider;", "(Landroid/content/ContentProvider;)Lcom/avito/android/di/ComponentDependencies;", "Ljava/lang/Class;", "clazz", "", "allComponentDependencies", "(Ljava/lang/Class;)Ljava/util/Set;", "dependenciesHolder", "getDependencies", "(Ljava/lang/Class;Lcom/avito/android/di/HasComponentDependencies;)Lcom/avito/android/di/ComponentDependencies;", "", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/avito/android/di/ComponentDependenciesProvider;", "findComponentDependenciesProvider", "(Landroidx/fragment/app/Fragment;)Ljava/util/Map;", "(Landroid/app/Activity;)Ljava/util/Map;", "(Landroid/view/View;)Ljava/util/Map;", "(Landroid/app/Service;)Ljava/util/Map;", "(Landroid/content/ContentProvider;)Ljava/util/Map;", "(Landroid/content/Context;)Ljava/util/Map;", "findComponentDependenciesHolder", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/di/HasComponentDependencies;", "(Landroid/app/Activity;)Lcom/avito/android/di/HasComponentDependencies;", "(Landroid/view/View;)Lcom/avito/android/di/HasComponentDependencies;", "(Landroid/app/Service;)Lcom/avito/android/di/HasComponentDependencies;", "(Landroid/content/ContentProvider;)Lcom/avito/android/di/HasComponentDependencies;", "(Landroid/content/Context;)Lcom/avito/android/di/HasComponentDependencies;", "", "context", "(Ljava/lang/Object;Landroid/content/Context;)Lcom/avito/android/di/HasComponentDependencies;", "target", "", "throwNoSuitableProvider", "(Ljava/lang/Object;)Ljava/lang/Void;", "ComponentDependenciesProvider", "dagger-scopes_release"}, k = 2, mv = {1, 4, 2})
public final class ComponentDependenciesKt {

    public static final class a extends Lambda implements Function2<Class<?>, Set<Class<?>>, Unit> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final void a(@NotNull Class<?> cls, @NotNull Set<Class<?>> set) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(set, "result");
            if (cls.isInterface() && ComponentDependencies.class.isAssignableFrom(cls)) {
                set.add(cls);
            }
            Class<?>[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
            ArrayList<Class<?>> arrayList = new ArrayList();
            for (Class<?> cls2 : interfaces) {
                if (!Intrinsics.areEqual(cls2, ComponentDependencies.class)) {
                    arrayList.add(cls2);
                }
            }
            for (Class<?> cls3 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(cls3, "it");
                a(cls3, set);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Class<?> cls, Set<Class<?>> set) {
            a(cls, set);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Set<Class<? extends ComponentDependencies>> allComponentDependencies(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        a aVar = a.a;
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
        Set<Class<? extends ComponentDependencies>> mutableSet = ArraysKt___ArraysKt.toMutableSet(interfaces);
        for (Class<?> cls2 : CollectionsKt___CollectionsKt.toList(mutableSet)) {
            a aVar2 = a.a;
            Intrinsics.checkNotNullExpressionValue(cls2, "it");
            aVar2.a(cls2, mutableSet);
        }
        Objects.requireNonNull(mutableSet, "null cannot be cast to non-null type kotlin.collections.Set<java.lang.Class<com.avito.android.di.ComponentDependencies>>");
        return mutableSet;
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(HasComponentDependencies hasComponentDependencies) {
        Intrinsics.checkNotNullParameter(hasComponentDependencies, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, hasComponentDependencies);
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull Fragment fragment) {
        HasComponentDependencies findComponentDependenciesHolder;
        Intrinsics.checkNotNullParameter(fragment, "$this$findComponentDependenciesHolder");
        Fragment parentFragment = fragment.getParentFragment();
        while (true) {
            if (parentFragment != null ? parentFragment instanceof HasComponentDependencies : true) {
                break;
            }
            parentFragment = parentFragment != null ? parentFragment.getParentFragment() : null;
        }
        if (parentFragment != null) {
            return (HasComponentDependencies) parentFragment;
        }
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && (findComponentDependenciesHolder = findComponentDependenciesHolder((Activity) activity)) != null) {
            return findComponentDependenciesHolder;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + fragment);
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$findComponentDependenciesProvider");
        return findComponentDependenciesHolder(fragment).getDependencies();
    }

    @NotNull
    public static final <T extends ComponentDependencies> T getDependencies(@NotNull Class<T> cls, @NotNull HasComponentDependencies hasComponentDependencies) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(hasComponentDependencies, "dependenciesHolder");
        ComponentDependencies componentDependencies = hasComponentDependencies.getDependencies().get(cls);
        if (!(componentDependencies instanceof ComponentDependencies)) {
            componentDependencies = null;
        }
        T t = (T) componentDependencies;
        if (t != null) {
            return t;
        }
        throw new MissingDependencyException(hasComponentDependencies, cls);
    }

    @NotNull
    public static final Void throwNoSuitableProvider(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "target");
        throw new IllegalStateException(a2.b.a.a.a.b3("Can not find suitable dagger provider of HasComponentDependencies for ", obj));
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(context));
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull Activity activity) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(activity, "$this$findComponentDependenciesProvider");
        Application application = activity.getApplication();
        if (activity instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) activity;
        } else if (application instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) application;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + activity);
        }
        return hasComponentDependencies.getDependencies();
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(fragment));
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(activity));
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(view));
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(Service service) {
        Intrinsics.checkNotNullParameter(service, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(service));
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull View view) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(view, "$this$findComponentDependenciesProvider");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        Context applicationContext = context.getApplicationContext();
        if (view instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) view;
        } else if (applicationContext instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) applicationContext;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + view);
        }
        return hasComponentDependencies.getDependencies();
    }

    public static final /* synthetic */ <T extends ComponentDependencies> T findComponentDependencies(ContentProvider contentProvider) {
        Intrinsics.checkNotNullParameter(contentProvider, "$this$findComponentDependencies");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getDependencies(ComponentDependencies.class, findComponentDependenciesHolder(contentProvider));
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$findComponentDependenciesHolder");
        Application application = activity.getApplication();
        if (activity instanceof HasComponentDependencies) {
            return (HasComponentDependencies) activity;
        }
        if (application instanceof HasComponentDependencies) {
            return (HasComponentDependencies) application;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + activity);
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull Service service) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(service, "$this$findComponentDependenciesProvider");
        Application application = service.getApplication();
        if (service instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) service;
        } else if (application instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) application;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + service);
        }
        return hasComponentDependencies.getDependencies();
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$findComponentDependenciesHolder");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        Context applicationContext = context.getApplicationContext();
        if (view instanceof HasComponentDependencies) {
            return (HasComponentDependencies) view;
        }
        if (applicationContext instanceof HasComponentDependencies) {
            return (HasComponentDependencies) applicationContext;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + view);
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull ContentProvider contentProvider) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(contentProvider, "$this$findComponentDependenciesProvider");
        Context context = contentProvider.getContext();
        if (contentProvider instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) contentProvider;
        } else if (context instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) context;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + contentProvider);
        }
        return hasComponentDependencies.getDependencies();
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "$this$findComponentDependenciesHolder");
        Application application = service.getApplication();
        if (service instanceof HasComponentDependencies) {
            return (HasComponentDependencies) service;
        }
        if (application instanceof HasComponentDependencies) {
            return (HasComponentDependencies) application;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + service);
    }

    @NotNull
    public static final Map<Class<? extends ComponentDependencies>, ComponentDependencies> findComponentDependenciesProvider(@NotNull Context context) {
        HasComponentDependencies hasComponentDependencies;
        Intrinsics.checkNotNullParameter(context, "$this$findComponentDependenciesProvider");
        Context applicationContext = context.getApplicationContext();
        if (context instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) context;
        } else if (applicationContext instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) applicationContext;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + context);
        }
        return hasComponentDependencies.getDependencies();
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull ContentProvider contentProvider) {
        Intrinsics.checkNotNullParameter(contentProvider, "$this$findComponentDependenciesHolder");
        Context context = contentProvider.getContext();
        if (contentProvider instanceof HasComponentDependencies) {
            return (HasComponentDependencies) contentProvider;
        }
        if (context instanceof HasComponentDependencies) {
            return (HasComponentDependencies) context;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + contentProvider);
    }

    @NotNull
    public static final HasComponentDependencies findComponentDependenciesHolder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$findComponentDependenciesHolder");
        Context applicationContext = context.getApplicationContext();
        if (context instanceof HasComponentDependencies) {
            return (HasComponentDependencies) context;
        }
        if (applicationContext instanceof HasComponentDependencies) {
            return (HasComponentDependencies) applicationContext;
        }
        throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + context);
    }

    public static final /* synthetic */ <T> HasComponentDependencies findComponentDependenciesHolder(T t, Context context) {
        Intrinsics.checkNotNullParameter(t, "$this$findComponentDependenciesHolder");
        if (t instanceof HasComponentDependencies) {
            return t;
        }
        if (context instanceof HasComponentDependencies) {
            return (HasComponentDependencies) context;
        }
        throw new IllegalStateException(a2.b.a.a.a.b3("Can not find suitable dagger provider of HasComponentDependencies for ", t));
    }
}
