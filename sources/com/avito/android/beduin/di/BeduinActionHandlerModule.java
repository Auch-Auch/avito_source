package com.avito.android.beduin.di;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.beduin.common.actionhandler.BeduinOpenDeeplinkActionHandler;
import com.avito.android.beduin.common.actionhandler.BeduinOpenLinkActionHandler;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/beduin/di/BeduinActionHandlerModule;", "", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "provideOpenLinkActionHandler", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/deep_linking/DeepLinkFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "provideOpenDeeplinkActionHandler", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BeduinActionHandlerModule {
    @NotNull
    public static final BeduinActionHandlerModule INSTANCE = new BeduinActionHandlerModule();

    @Provides
    @IntoSet
    @NotNull
    public final BeduinActionHandler provideOpenDeeplinkActionHandler(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return new BeduinOpenDeeplinkActionHandler(deepLinkIntentFactory, requireActivity);
    }

    @Provides
    @IntoSet
    @NotNull
    public final BeduinActionHandler provideOpenLinkActionHandler(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return new BeduinOpenLinkActionHandler(deepLinkIntentFactory, deepLinkFactory, requireActivity);
    }
}
