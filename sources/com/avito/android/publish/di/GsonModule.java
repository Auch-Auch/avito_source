package com.avito.android.publish.di;

import com.avito.android.publish.WizardParameterForDraftTypeAdapter;
import com.avito.android.remote.model.WizardParameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/di/GsonModule;", "", "Lcom/google/gson/TypeAdapterFactory;", "provideTypeAdapterFactory", "()Lcom/google/gson/TypeAdapterFactory;", "typeAdapterFactory", "Lcom/google/gson/Gson;", "provideGson", "(Lcom/google/gson/TypeAdapterFactory;)Lcom/google/gson/Gson;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class GsonModule {
    @Provides
    @NotNull
    public final Gson provideGson(@NotNull TypeAdapterFactory typeAdapterFactory) {
        Intrinsics.checkNotNullParameter(typeAdapterFactory, "typeAdapterFactory");
        Gson create = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).registerTypeAdapter(WizardParameter.class, new WizardParameterForDraftTypeAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n        .r…pter())\n        .create()");
        return create;
    }

    @Provides
    @NotNull
    public final TypeAdapterFactory provideTypeAdapterFactory() {
        return GsonModuleKt.createStepStateTypeAdapterFactory();
    }
}
