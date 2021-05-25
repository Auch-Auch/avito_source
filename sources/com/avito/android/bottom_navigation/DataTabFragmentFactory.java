package com.avito.android.bottom_navigation;

import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "create", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "Ljava/lang/Class;", "getDataType", "()Ljava/lang/Class;", "dataType", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DataTabFragmentFactory {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\b\u001a\u00020\u0007\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"Lcom/avito/android/bottom_navigation/DataTabFragmentFactory$Companion;", "", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "DATA", "Lkotlin/Function1;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "action", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "create", "(Lkotlin/jvm/functions/Function1;)Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        public final /* synthetic */ <DATA extends TabFragmentFactory.Data> DataTabFragmentFactory create(Function1<? super DATA, ? extends TabBaseFragment> function1) {
            Intrinsics.checkNotNullParameter(function1, "action");
            Intrinsics.needClassReification();
            return new DataTabFragmentFactory$Companion$create$1(function1);
        }
    }

    @NotNull
    TabBaseFragment create(@NotNull TabFragmentFactory.Data data);

    @NotNull
    Class<?> getDataType();
}
