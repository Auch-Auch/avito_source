package com.avito.android.publish.details.di;

import com.avito.android.di.PerFragment;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandlerImpl;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.item_legacy.details.SelectParameterClickListenerImpl;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.BasicParameterClickListenerImpl;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.publish.view.ItemDetailsParameterClickListenerImpl;
import com.avito.android.publish.view.LocationParameterClickListener;
import com.avito.android.publish.view.LocationParameterClickListenerImpl;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsViewModule;", "", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandlerImpl;", "handler", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "provideResultHandler", "(Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandlerImpl;)Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListenerImpl;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "provideParamsClickListener", "(Lcom/avito/android/publish/view/ItemDetailsParameterClickListenerImpl;)Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "Lcom/avito/android/publish/view/BasicParameterClickListenerImpl;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "provideBasicParamsClickListener", "(Lcom/avito/android/publish/view/BasicParameterClickListenerImpl;)Lcom/avito/android/publish/view/BasicParameterClickListener;", "Lcom/avito/android/publish/view/LocationParameterClickListenerImpl;", "Lcom/avito/android/publish/view/LocationParameterClickListener;", "locationParameterClickListener", "(Lcom/avito/android/publish/view/LocationParameterClickListenerImpl;)Lcom/avito/android/publish/view/LocationParameterClickListener;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListenerImpl;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "provideSelectParameterClickListener", "(Lcom/avito/android/item_legacy/details/SelectParameterClickListenerImpl;)Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class})
public interface PublishDetailsViewModule {
    @PerFragment
    @Binds
    @NotNull
    LocationParameterClickListener locationParameterClickListener(@NotNull LocationParameterClickListenerImpl locationParameterClickListenerImpl);

    @PerFragment
    @Binds
    @NotNull
    BasicParameterClickListener provideBasicParamsClickListener(@NotNull BasicParameterClickListenerImpl basicParameterClickListenerImpl);

    @PerFragment
    @Binds
    @NotNull
    ItemDetailsParameterClickListener provideParamsClickListener(@NotNull ItemDetailsParameterClickListenerImpl itemDetailsParameterClickListenerImpl);

    @PerFragment
    @Binds
    @NotNull
    ItemDetailsSelectResultHandler provideResultHandler(@NotNull ItemDetailsSelectResultHandlerImpl itemDetailsSelectResultHandlerImpl);

    @PerFragment
    @Binds
    @NotNull
    SelectParameterClickListener provideSelectParameterClickListener(@NotNull SelectParameterClickListenerImpl selectParameterClickListenerImpl);
}
