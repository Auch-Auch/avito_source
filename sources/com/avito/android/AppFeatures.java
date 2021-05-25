package com.avito.android;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.toggle.Feature;
import com.avito.android.toggle.FeatureKt;
import com.avito.android.toggle.ImmutableFeature;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.UrlParams;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJU\u0010\u0014\u001a\f\u0012\u0004\u0012\u00028\u00000\u0013R\u00020\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u001a\u001a\u00020\u00042-\u0010\u0019\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00020\u0016H\u0004¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R(\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00020!8V@\u0016X\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\u00020\u000f*\u00020\u001c8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R.\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00020)8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/AppFeatures;", "", "Lcom/avito/android/toggle/Feature;", "feature", "", "registerFeature", "(Lcom/avito/android/toggle/Feature;)V", "", "key", "get", "(Ljava/lang/String;)Lcom/avito/android/toggle/Feature;", "T", "description", "defaultValue", "apiToggleId", "", "isRemote", "Lcom/avito/android/AvitoUnit;", UrlParams.OWNER, "Lcom/avito/android/AppFeatures$FeatureDelegate;", "createFeature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZLcom/avito/android/AvitoUnit;)Lcom/avito/android/AppFeatures$FeatureDelegate;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "decorator", "decorate", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "", "getFeatures", "()Ljava/util/List;", "getFeatures$annotations", "()V", "features", "isDev", "(Lcom/avito/android/util/BuildInfo;)Z", "", "featuresMap", "Ljava/util/Map;", "getFeaturesMap", "()Ljava/util/Map;", "<init>", "(Lcom/avito/android/util/BuildInfo;)V", "FeatureDelegate", "features_release"}, k = 1, mv = {1, 4, 2})
public abstract class AppFeatures {
    @NotNull
    private final BuildInfo buildInfo;
    @NotNull
    private final Map<String, Feature<Object>> featuresMap = new LinkedHashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/AppFeatures$FeatureDelegate;", "T", "", "Lcom/avito/android/AppFeatures;", "features", "Lkotlin/reflect/KProperty;", "property", "Lcom/avito/android/toggle/Feature;", "getValue", "(Lcom/avito/android/AppFeatures;Lkotlin/reflect/KProperty;)Lcom/avito/android/toggle/Feature;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "(Lcom/avito/android/AppFeatures;Ljava/lang/String;)V", "features_release"}, k = 1, mv = {1, 4, 2})
    public final class FeatureDelegate<T> {
        @NotNull
        public final String a;
        public final /* synthetic */ AppFeatures b;

        public FeatureDelegate(@NotNull AppFeatures appFeatures, String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.b = appFeatures;
            this.a = str;
        }

        @NotNull
        public final String getKey() {
            return this.a;
        }

        @NotNull
        public final Feature<T> getValue(@NotNull AppFeatures appFeatures, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(appFeatures, "features");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            Feature<Object> feature = this.b.getFeaturesMap().get(this.a);
            Objects.requireNonNull(feature, "null cannot be cast to non-null type com.avito.android.toggle.Feature<T>");
            return (Feature<T>) feature;
        }
    }

    public AppFeatures(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.buildInfo = buildInfo2;
    }

    public static /* synthetic */ FeatureDelegate createFeature$default(AppFeatures appFeatures, String str, String str2, Object obj, String str3, boolean z, AvitoUnit avitoUnit, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return appFeatures.createFeature(str, str2, obj, str3, (i & 16) != 0 ? true : z, avitoUnit);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFeature");
    }

    public static /* synthetic */ void getFeatures$annotations() {
    }

    private final void registerFeature(Feature<? extends Object> feature) {
        if (!(this.featuresMap.put(feature.getKey(), feature) == null)) {
            StringBuilder L = a.L("Duplicate toggles: ");
            L.append(feature.getKey());
            throw new IllegalStateException(L.toString().toString());
        }
    }

    @NotNull
    public final <T> FeatureDelegate<T> createFeature(@NotNull String str, @NotNull String str2, T t, @Nullable String str3, boolean z, @NotNull AvitoUnit avitoUnit) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(avitoUnit, UrlParams.OWNER);
        ImmutableFeature immutableFeature = new ImmutableFeature(str, t, str2, str3, z);
        boolean z2 = true;
        if (!immutableFeature.isRemote() || !(!FeatureKt.canBeRemote(immutableFeature))) {
            z2 = false;
        }
        if (!z2) {
            registerFeature(immutableFeature);
            return new FeatureDelegate<>(this, str2);
        }
        StringBuilder L = a.L("Toggle ");
        L.append(immutableFeature.getKey());
        L.append(" must be non-remote. ");
        L.append("Only boolean toggles are supported.");
        throw new IllegalStateException(L.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, com.avito.android.toggle.Feature<java.lang.Object>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void decorate(@NotNull Function1<? super Feature<? extends Object>, ? extends Feature<? extends Object>> function1) {
        Intrinsics.checkNotNullParameter(function1, "decorator");
        for (Map.Entry<String, Feature<Object>> entry : this.featuresMap.entrySet()) {
            this.featuresMap.put(entry.getKey(), function1.invoke(entry.getValue()));
        }
    }

    @Nullable
    public Feature<Object> get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.featuresMap.get(str);
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        return this.buildInfo;
    }

    @NotNull
    public List<Feature<Object>> getFeatures() {
        List<Feature<Object>> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.toList(this.featuresMap.values()));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable…turesMap.values.toList())");
        return unmodifiableList;
    }

    @NotNull
    public final Map<String, Feature<Object>> getFeaturesMap() {
        return this.featuresMap;
    }

    public final boolean isDev(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "$this$isDev");
        return buildInfo2.isDebug() && !buildInfo2.isStaging();
    }
}
