package com.avito.android.remote.model.category_parameters;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class SelectParameter$Sectioned$findValueWithId$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new SelectParameter$Sectioned$findValueWithId$1();

    public SelectParameter$Sectioned$findValueWithId$1() {
        super(SelectParameter.Sectioned.Section.class, ResidentialComplexModuleKt.VALUES, "getValues()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return ((SelectParameter.Sectioned.Section) obj).getValues();
    }
}
