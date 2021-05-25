package com.avito.android.beduin.core.form;

import com.avito.android.beduin.core.form.ComponentsFormTransform;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001¢\u0006\u0004\b\u0007\u0010\b*\"\u0010\u000b\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t2\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¨\u0006\f"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsForm;", "", "", "", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "modelsTransforms", "", "apply", "(Lcom/avito/android/beduin/core/form/ComponentsForm;Ljava/util/Map;)V", "Lkotlin/Function1;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "FormUpdateHandler", "beduin_release"}, k = 2, mv = {1, 4, 2})
public final class ComponentsFormKt {
    public static final void apply(@NotNull ComponentsForm componentsForm, @NotNull Map<String, ? extends List<? extends BeduinModelTransform>> map) {
        Intrinsics.checkNotNullParameter(componentsForm, "$this$apply");
        Intrinsics.checkNotNullParameter(map, "modelsTransforms");
        componentsForm.apply(new ComponentsFormTransform.Apply(map));
    }
}
