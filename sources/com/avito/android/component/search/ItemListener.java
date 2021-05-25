package com.avito.android.component.search;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
@Deprecated(message = "Use Lazy initialization instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/component/search/ItemListener;", "T", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "attachListener", "(Ljava/lang/Object;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ItemListener<T> {
    void attachListener(T t);
}
