package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.annotations.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/reflect/Method;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseParametersConverter$fields$2 extends Lambda implements Function1<Method, Boolean> {
    public static final BaseParametersConverter$fields$2 INSTANCE = new BaseParametersConverter$fields$2();

    public BaseParametersConverter$fields$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke(method));
    }

    public final boolean invoke(Method method) {
        return method.isAnnotationPresent(Field.class);
    }
}
