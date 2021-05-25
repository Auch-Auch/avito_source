package com.avito.android.beduin.core.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR0\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fj\u0004\u0018\u0001`\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsForm;", "", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "formTransform", "", "apply", "(Lcom/avito/android/beduin/core/form/ComponentsFormTransform;)V", "", "", "getParameters", "()Ljava/util/Map;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "isValid", "()Z", "Lkotlin/Function1;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "Lcom/avito/android/beduin/core/form/FormUpdateHandler;", "getOnFormUpdate", "()Lkotlin/jvm/functions/Function1;", "setOnFormUpdate", "(Lkotlin/jvm/functions/Function1;)V", "onFormUpdate", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface ComponentsForm {
    void apply(@NotNull ComponentsFormTransform componentsFormTransform);

    @Nullable
    Function1<ComponentsFormUpdate, Unit> getOnFormUpdate();

    @NotNull
    Map<String, Object> getParameters();

    boolean isValid();

    void setOnFormUpdate(@Nullable Function1<? super ComponentsFormUpdate, Unit> function1);
}
