package com.avito.android.publish.add_advert;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/add_advert/AddAdvertModule;", "", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "provideAddAdvertInteractor", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AddAdvertModule {
    @NotNull
    public static final AddAdvertModule INSTANCE = new AddAdvertModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AddAdvertInteractor provideAddAdvertInteractor(@NotNull PublishApi publishApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "typedErrorThrowableConverter");
        return new AddAdvertInteractorImpl(publishApi, schedulersFactory3, typedErrorThrowableConverter);
    }
}
