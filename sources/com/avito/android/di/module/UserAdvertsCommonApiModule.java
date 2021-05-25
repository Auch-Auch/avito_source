package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.model.CharityDialogResponse;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/UserAdvertsCommonApiModule;", "", "", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapter", "()Ljava/util/Set;", "Lcom/avito/android/remote/RetrofitFactory;", "retrofit", "Lcom/avito/android/remote/UserAdvertsCommonApi;", "provideUserAdvertApi", "(Lcom/avito/android/remote/RetrofitFactory;)Lcom/avito/android/remote/UserAdvertsCommonApi;", "<init>", "()V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertsCommonApiModule {
    @NotNull
    public static final UserAdvertsCommonApiModule INSTANCE = new UserAdvertsCommonApiModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapter() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), CharityDialogResponse.class, r.mapOf(TuplesKt.to("ok", CharityDialogResponse.Ok.class), TuplesKt.to("not-required", CharityDialogResponse.NotRequired.class)));
    }

    @Provides
    @Reusable
    @NotNull
    public final UserAdvertsCommonApi provideUserAdvertApi(@NotNull RetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofit");
        return (UserAdvertsCommonApi) retrofitFactory.create(UserAdvertsCommonApi.class);
    }
}
