package com.avito.android.remote.di;

import com.avito.android.remote.model.CountResult;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/di/UserAdvertsJsonModule;", "", "", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "()Ljava/util/Set;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertsJsonModule {
    @NotNull
    public static final UserAdvertsJsonModule INSTANCE = new UserAdvertsJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), CountResult.class, r.mapOf(TuplesKt.to("ok", CountResult.Ok.class), TuplesKt.to("unauthenticated", CountResult.Unauthenticated.class)));
    }
}
