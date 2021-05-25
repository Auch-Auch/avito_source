package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.remote.adapter.MyAdvertDetailsDeserializer;
import com.avito.android.remote.adapter.MyAdvertStatsDeserializer;
import com.avito.android.remote.adapter.UserAdvertDeserializer;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.adverts.RestoreAdvertResult;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/UserAdvertJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "()Ljava/util/Set;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertJsonModule {
    @NotNull
    public static final UserAdvertJsonModule INSTANCE = new UserAdvertJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), RestoreAdvertResult.class, r.mapOf(TuplesKt.to("ok", RestoreAdvertResult.Ok.class), TuplesKt.to("forbidden", RestoreAdvertResult.Forbidden.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(MyAdvertDetails.Stats.class, new MyAdvertStatsDeserializer(features)));
        linkedHashSet.add(new TypeAdapterEntry(MyAdvertDetails.class, new MyAdvertDetailsDeserializer(features)));
        linkedHashSet.add(new TypeAdapterEntry(UserAdvert.class, new UserAdvertDeserializer(features)));
        return linkedHashSet;
    }
}
