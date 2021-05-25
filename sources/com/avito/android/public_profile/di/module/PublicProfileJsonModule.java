package com.avito.android.public_profile.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.public_profile.remote.model.LegacyPublicProfileResult;
import com.avito.android.public_profile.remote.model.PublicProfileResult;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.public_profile.remote.parse.adapter.PublicProfileResultOkTypeAdapter;
import com.avito.android.public_profile.remote.parse.adapter.PublicUserProfileTypeAdapter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/avito/android/public_profile/di/module/PublicProfileJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublicProfileJsonModule {
    @NotNull
    public static final PublicProfileJsonModule INSTANCE = new PublicProfileJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        Set<CustomTypeAdapterEntry> registerCustomType = GsonSetsKt.registerCustomType(new LinkedHashSet(), LegacyPublicProfileResult.class, r.mapOf(TuplesKt.to("ok", LegacyPublicProfileResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, LegacyPublicProfileResult.FailedWithMessage.class), TuplesKt.to("user-banned", LegacyPublicProfileResult.UserBanned.class), TuplesKt.to("user-removed", LegacyPublicProfileResult.UserRemoved.class)));
        if (features.getExtendedProfile().invoke().booleanValue()) {
            GsonSetsKt.registerCustomType(registerCustomType, PublicProfileResult.class, r.mapOf(TuplesKt.to("ok", PublicProfileResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, PublicProfileResult.FailedWithMessage.class), TuplesKt.to("user-banned", PublicProfileResult.UserBanned.class), TuplesKt.to("user-removed", PublicProfileResult.UserRemoved.class)));
        }
        return registerCustomType;
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(LegacyPublicProfileResult.Ok.class, new PublicProfileResultOkTypeAdapter()));
        if (features.getExtendedProfile().invoke().booleanValue()) {
            linkedHashSet.add(new TypeAdapterEntry(PublicUserProfile.class, new PublicUserProfileTypeAdapter()));
        }
        return linkedHashSet;
    }
}
