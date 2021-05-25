package com.avito.android.advert_details.remote;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.model.ConsultationRequestResult;
import com.avito.android.remote.parse.adapter.SafeDealListComponentTypeAdapterFactory;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.google.gson.TypeAdapterFactory;
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
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_details/remote/AdvertDetailsJsonModule;", "", "", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "()Ljava/util/Set;", "Lcom/google/gson/TypeAdapterFactory;", "provideCommonTypeAdapterFactories", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdvertDetailsJsonModule {
    @NotNull
    public static final AdvertDetailsJsonModule INSTANCE = new AdvertDetailsJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterFactory> provideCommonTypeAdapterFactories() {
        return x.setOf(new SafeDealListComponentTypeAdapterFactory().create());
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), ConsultationRequestResult.class, r.mapOf(TuplesKt.to("ok", ConsultationRequestResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, ConsultationRequestResult.Failure.class), TuplesKt.to("need-phone-verification", ConsultationRequestResult.PhoneNeedVerification.class)));
    }
}
