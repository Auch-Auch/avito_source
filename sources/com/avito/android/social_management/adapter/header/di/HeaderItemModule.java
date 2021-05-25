package com.avito.android.social_management.adapter.header.di;

import com.avito.android.di.PerActivity;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.header.HeaderItemBlueprint;
import com.avito.android.social_management.adapter.header.HeaderItemPresenter;
import com.avito.android.social_management.adapter.header.HeaderItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/social_management/adapter/header/di/HeaderItemModule;", "", "Lcom/avito/android/social_management/adapter/header/HeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$social_network_editor_release", "(Lcom/avito/android/social_management/adapter/header/HeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/social_management/adapter/SocialItem;", "clicksRelay", "providePresenter$social_network_editor_release", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lcom/avito/android/social_management/adapter/header/HeaderItemPresenter;", "providePresenter", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class HeaderItemModule {
    @NotNull
    public static final HeaderItemModule INSTANCE = new HeaderItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$social_network_editor_release(@NotNull HeaderItemPresenter headerItemPresenter) {
        Intrinsics.checkNotNullParameter(headerItemPresenter, "presenter");
        return new HeaderItemBlueprint(headerItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final HeaderItemPresenter providePresenter$social_network_editor_release(@NotNull PublishRelay<SocialItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksRelay");
        return new HeaderItemPresenterImpl(publishRelay);
    }
}
