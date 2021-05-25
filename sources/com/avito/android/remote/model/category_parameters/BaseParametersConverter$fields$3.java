package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.annotations.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00050\u00050\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "", "", "invoke", "(Ljava/lang/reflect/Method;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseParametersConverter$fields$3 extends Lambda implements Function1<Method, Pair<? extends String, ? extends Object>> {
    public final /* synthetic */ Object $this_fields;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseParametersConverter$fields$3(Object obj) {
        super(1);
        this.$this_fields = obj;
    }

    @NotNull
    public final Pair<String, Object> invoke(Method method) {
        return TuplesKt.to(((Field) method.getAnnotation(Field.class)).name(), method.invoke(this.$this_fields, new Object[0]));
    }
}
