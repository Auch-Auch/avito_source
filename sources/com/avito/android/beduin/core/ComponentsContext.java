package com.avito.android.beduin.core;

import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.form.ComponentsFormTransform;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/beduin/core/ComponentsContext;", "", "", "", "", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "transforms", "", "apply", "(Ljava/util/Map;)V", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "formTransform", "(Lcom/avito/android/beduin/core/form/ComponentsFormTransform;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface ComponentsContext {
    void apply(@NotNull ComponentsFormTransform componentsFormTransform);

    void apply(@NotNull Map<String, ? extends List<? extends BeduinModelTransform>> map);
}
