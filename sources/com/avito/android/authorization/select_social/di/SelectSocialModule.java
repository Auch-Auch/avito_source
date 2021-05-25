package com.avito.android.authorization.select_social.di;

import a2.b.a.a.a;
import com.avito.android.authorization.select_social.SelectSocialInteractor;
import com.avito.android.authorization.select_social.SelectSocialInteractorImpl;
import com.avito.android.authorization.select_social.SelectSocialPresenter;
import com.avito.android.authorization.select_social.SelectSocialPresenterImpl;
import com.avito.android.authorization.select_social.SelectSocialResourceProvider;
import com.avito.android.authorization.select_social.SelectSocialResourceProviderImpl;
import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.authorization.select_social.adapter.SocialItemBlueprint;
import com.avito.android.authorization.select_social.adapter.SocialItemBlueprintImpl;
import com.avito.android.authorization.select_social.adapter.SocialItemPresenter;
import com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl;
import com.avito.android.authorization.select_social.adapter.TextItemBlueprint;
import com.avito.android.authorization.select_social.adapter.TextItemBlueprintImpl;
import com.avito.android.authorization.select_social.adapter.TextItemPresenter;
import com.avito.android.authorization.select_social.adapter.TextItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/authorization/select_social/di/SelectSocialModule;", "", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField;", "provideFieldClickStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$authorization_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprint;", "socialItemBlueprint", "Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprint;", "textItemBlueprint", "provideItemBinder$authorization_release", "(Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprint;Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ErrorHelperModule.class, Declarations.class})
public final class SelectSocialModule {
    @NotNull
    public static final SelectSocialModule INSTANCE = new SelectSocialModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/authorization/select_social/di/SelectSocialModule$Declarations;", "", "Lcom/avito/android/authorization/select_social/SelectSocialPresenterImpl;", "presenter", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "bindSelectSocialPresenter", "(Lcom/avito/android/authorization/select_social/SelectSocialPresenterImpl;)Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "Lcom/avito/android/authorization/select_social/SelectSocialInteractorImpl;", "interactor", "Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "bindSelectSocialInteractor", "(Lcom/avito/android/authorization/select_social/SelectSocialInteractorImpl;)Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "bindSelectSocialResourceProvider", "(Lcom/avito/android/authorization/select_social/SelectSocialResourceProviderImpl;)Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprintImpl;", "blueprint", "Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprint;", "bindTextItemBlueprint", "(Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprintImpl;)Lcom/avito/android/authorization/select_social/adapter/TextItemBlueprint;", "Lcom/avito/android/authorization/select_social/adapter/TextItemPresenterImpl;", "Lcom/avito/android/authorization/select_social/adapter/TextItemPresenter;", "bindTextItemPresenter", "(Lcom/avito/android/authorization/select_social/adapter/TextItemPresenterImpl;)Lcom/avito/android/authorization/select_social/adapter/TextItemPresenter;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprintImpl;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprint;", "bindSocialItemBlueprint", "(Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprintImpl;)Lcom/avito/android/authorization/select_social/adapter/SocialItemBlueprint;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenterImpl;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenter;", "bindSocialItemPresenter", "(Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenterImpl;)Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenter;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        SelectSocialInteractor bindSelectSocialInteractor(@NotNull SelectSocialInteractorImpl selectSocialInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        SelectSocialPresenter bindSelectSocialPresenter(@NotNull SelectSocialPresenterImpl selectSocialPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        SelectSocialResourceProvider bindSelectSocialResourceProvider(@NotNull SelectSocialResourceProviderImpl selectSocialResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        SocialItemBlueprint bindSocialItemBlueprint(@NotNull SocialItemBlueprintImpl socialItemBlueprintImpl);

        @PerActivity
        @Binds
        @NotNull
        SocialItemPresenter bindSocialItemPresenter(@NotNull SocialItemPresenterImpl socialItemPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        TextItemBlueprint bindTextItemBlueprint(@NotNull TextItemBlueprintImpl textItemBlueprintImpl);

        @PerActivity
        @Binds
        @NotNull
        TextItemPresenter bindTextItemPresenter(@NotNull TextItemPresenterImpl textItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter$authorization_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<SelectSocialField> provideFieldClickStream() {
        PublishRelay<SelectSocialField> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<SelectSocialField>()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder$authorization_release(@NotNull SocialItemBlueprint socialItemBlueprint, @NotNull TextItemBlueprint textItemBlueprint) {
        Intrinsics.checkNotNullParameter(socialItemBlueprint, "socialItemBlueprint");
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        return new ItemBinder.Builder().registerItem(socialItemBlueprint).registerItem(textItemBlueprint).build();
    }
}
