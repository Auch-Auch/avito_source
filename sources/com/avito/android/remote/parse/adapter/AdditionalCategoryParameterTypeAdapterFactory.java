package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.category_parameters.AdditionalBooleanParameter;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import com.avito.android.remote.model.category_parameters.AdditionalCharParameter;
import com.avito.android.remote.model.category_parameters.UnknownAdditionalParameter;
import com.avito.android.util.preferences.db_preferences.Types;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdditionalCategoryParameterTypeAdapterFactory;", "", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "create", "()Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalCategoryParameterTypeAdapterFactory {
    @NotNull
    public final RuntimeTypeAdapterFactory<AdditionalCategoryParameter> create() {
        RuntimeTypeAdapterFactory<AdditionalCategoryParameter> registerFallbackSubtype = RuntimeTypeAdapterFactory.of(AdditionalCategoryParameter.class).registerSubtype(AdditionalBooleanParameter.class, Types.BOOLEAN).registerSubtype(AdditionalCharParameter.class, "char").registerFallbackSubtype(UnknownAdditionalParameter.class);
        Intrinsics.checkNotNullExpressionValue(registerFallbackSubtype, "RuntimeTypeAdapterFactor…nalParameter::class.java)");
        return registerFallbackSubtype;
    }
}
