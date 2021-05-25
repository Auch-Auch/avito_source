package com.avito.android.bottom_navigation;

import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"com/avito/android/bottom_navigation/DataTabFragmentFactory$Companion$create$1", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "create", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getDataType", "()Ljava/lang/Class;", "dataType", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DataTabFragmentFactory$Companion$create$1 implements DataTabFragmentFactory {
    @NotNull
    public final Class<?> a = TabFragmentFactory.Data.class;
    public final /* synthetic */ Function1 b;

    public DataTabFragmentFactory$Companion$create$1(Function1 function1) {
        this.b = function1;
        Intrinsics.reifiedOperationMarker(4, "DATA");
    }

    @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
    @NotNull
    public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Function1 function1 = this.b;
        Intrinsics.reifiedOperationMarker(1, "DATA");
        return (TabBaseFragment) function1.invoke(data);
    }

    @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
    @NotNull
    public Class<?> getDataType() {
        return this.a;
    }
}
