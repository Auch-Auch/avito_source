package com.avito.android.remote;

import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.model.FailurePhoneResponse;
import com.avito.android.remote.model.PhoneResponse;
import com.avito.android.remote.model.SuccessPhoneResponse;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/PhoneResponseJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "<init>", "()V", "async-phone_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhoneResponseJsonModule {
    @NotNull
    public static final PhoneResponseJsonModule INSTANCE = new PhoneResponseJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ok", SuccessPhoneResponse.class);
        if (features.getAdvertPhoneContactUnderAuth().invoke().booleanValue()) {
            linkedHashMap.put(PublicConstantsKt.FAILURE, FailurePhoneResponse.class);
        }
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), PhoneResponse.class, linkedHashMap);
    }
}
