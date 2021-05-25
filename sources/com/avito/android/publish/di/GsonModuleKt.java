package com.avito.android.publish.di;

import com.avito.android.publish.PublishSession;
import com.avito.android.publish.PublishState;
import com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory;
import com.google.gson.TypeAdapterFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/gson/TypeAdapterFactory;", "createStepStateTypeAdapterFactory", "()Lcom/google/gson/TypeAdapterFactory;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class GsonModuleKt {
    @NotNull
    public static final TypeAdapterFactory createStepStateTypeAdapterFactory() {
        RuntimeTypeAdapterFactory registerSubtype = RuntimeTypeAdapterFactory.of(PublishState.StepState.class).registerSubtype(PublishState.StepState.Wizard.class, PublishSession.StepType.WIZARD.toString()).registerSubtype(PublishState.StepState.CategoriesSuggestions.class, PublishSession.StepType.SUGGEST_CATEGORY.toString()).registerSubtype(PublishState.StepState.Vin.class, PublishSession.StepType.VIN.toString());
        Intrinsics.checkNotNullExpressionValue(registerSubtype, "RuntimeTypeAdapterFactor….StepType.VIN.toString())");
        return registerSubtype;
    }
}
