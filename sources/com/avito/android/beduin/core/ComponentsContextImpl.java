package com.avito.android.beduin.core;

import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.form.ComponentsFormTransform;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/beduin/core/ComponentsContextImpl;", "Lcom/avito/android/beduin/core/ComponentsContext;", "", "", "", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "transforms", "", "apply", "(Ljava/util/Map;)V", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "formTransform", "(Lcom/avito/android/beduin/core/form/ComponentsFormTransform;)V", "Lcom/avito/android/beduin/core/form/ComponentsForm;", AuthSource.SEND_ABUSE, "Lcom/avito/android/beduin/core/form/ComponentsForm;", "componentsForm", "<init>", "(Lcom/avito/android/beduin/core/form/ComponentsForm;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class ComponentsContextImpl implements ComponentsContext {
    public final ComponentsForm a;

    @Inject
    public ComponentsContextImpl(@NotNull ComponentsForm componentsForm) {
        Intrinsics.checkNotNullParameter(componentsForm, "componentsForm");
        this.a = componentsForm;
    }

    @Override // com.avito.android.beduin.core.ComponentsContext
    public void apply(@NotNull Map<String, ? extends List<? extends BeduinModelTransform>> map) {
        Intrinsics.checkNotNullParameter(map, "transforms");
        this.a.apply(new ComponentsFormTransform.Apply(map));
    }

    @Override // com.avito.android.beduin.core.ComponentsContext
    public void apply(@NotNull ComponentsFormTransform componentsFormTransform) {
        Intrinsics.checkNotNullParameter(componentsFormTransform, "formTransform");
        this.a.apply(componentsFormTransform);
    }
}
