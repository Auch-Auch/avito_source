package com.avito.android.social_management.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.Features;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SignInManager;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.di.SocialModule;
import com.avito.android.social_management.SocialManagementInteractor;
import com.avito.android.social_management.SocialManagementInteractorImpl;
import com.avito.android.social_management.SocialManagementPresenter;
import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.SocialManagementResourceProvider;
import com.avito.android.social_management.SocialManagementResourceProviderImpl;
import com.avito.android.social_management.adapter.SocialContentsComparator;
import com.avito.android.social_management.adapter.SocialEqualityComparator;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b2\u00103J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0001¢\u0006\u0004\b\b\u0010\u0005JM\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u001f\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b)\u0010*J-\u00100\u001a\u00020$2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010%\u001a\u00020.2\u0006\u0010/\u001a\u00020!H\u0007¢\u0006\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/social_management/di/SocialManagementModule;", "", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/social_management/adapter/SocialItem;", "provideClicksStream$social_network_editor_release", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "provideClicksStream", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "provideNotificationsActionsStream$social_network_editor_release", "provideNotificationsActionsStream", "Lcom/avito/android/social/FacebookSocialManager;", "facebookSocialManager", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "odnoklassnikiSocialManager", "Lcom/avito/android/social/VkontakteSocialManager;", "vkontakteSocialManager", "Lcom/avito/android/social/GoogleSocialManager;", "googleSocialManager", "Lcom/avito/android/social/AppleSignInManager;", "appleSignInManager", "Lcom/avito/android/social/EsiaSignInManager;", "esiaSignInManager", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/social/SignInManager;", "provideSocialManagers$social_network_editor_release", "(Lcom/avito/android/social/FacebookSocialManager;Lcom/avito/android/social/OdnoklassnikiSocialManager;Lcom/avito/android/social/VkontakteSocialManager;Lcom/avito/android/social/GoogleSocialManager;Lcom/avito/android/social/AppleSignInManager;Lcom/avito/android/social/EsiaSignInManager;Lcom/avito/android/Features;)Ljava/util/List;", "provideSocialManagers", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "equalityComparator", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "(Lcom/avito/android/recycler/data_aware/ContentsComparator;Lcom/avito/android/recycler/data_aware/EqualityComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "diffCalculator", "provideDataAwareAdapter", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "<init>", "()V", "Declarations", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, SocialModule.class, Declarations.class, AttributedTextFormatterModule.class})
public final class SocialManagementModule {
    @NotNull
    public static final SocialManagementModule INSTANCE = new SocialManagementModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/social_management/di/SocialManagementModule$Declarations;", "", "Lcom/avito/android/social_management/SocialManagementPresenterImpl;", "presenter", "Lcom/avito/android/social_management/SocialManagementPresenter;", "bindSocialManagementPresenter", "(Lcom/avito/android/social_management/SocialManagementPresenterImpl;)Lcom/avito/android/social_management/SocialManagementPresenter;", "Lcom/avito/android/social_management/SocialManagementInteractorImpl;", "interactor", "Lcom/avito/android/social_management/SocialManagementInteractor;", "bindSocialManagementInteractor", "(Lcom/avito/android/social_management/SocialManagementInteractorImpl;)Lcom/avito/android/social_management/SocialManagementInteractor;", "Lcom/avito/android/social_management/SocialManagementResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/social_management/SocialManagementResourceProvider;", "bindSocialManagementResourceProvider", "(Lcom/avito/android/social_management/SocialManagementResourceProviderImpl;)Lcom/avito/android/social_management/SocialManagementResourceProvider;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/social_management/adapter/SocialContentsComparator;", "impl", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "bindContentsComparator", "(Lcom/avito/android/social_management/adapter/SocialContentsComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/social_management/adapter/SocialEqualityComparator;", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "bindEqualityComparator", "(Lcom/avito/android/social_management/adapter/SocialEqualityComparator;)Lcom/avito/android/recycler/data_aware/EqualityComparator;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        ContentsComparator bindContentsComparator(@NotNull SocialContentsComparator socialContentsComparator);

        @PerActivity
        @Binds
        @NotNull
        EqualityComparator bindEqualityComparator(@NotNull SocialEqualityComparator socialEqualityComparator);

        @PerActivity
        @Binds
        @NotNull
        SocialManagementInteractor bindSocialManagementInteractor(@NotNull SocialManagementInteractorImpl socialManagementInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        SocialManagementPresenter bindSocialManagementPresenter(@NotNull SocialManagementPresenterImpl socialManagementPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        SocialManagementResourceProvider bindSocialManagementResourceProvider(@NotNull SocialManagementResourceProviderImpl socialManagementResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<SocialItem> provideClicksStream$social_network_editor_release() {
        PublishRelay<SocialItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<SocialItem>()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final DataAwareAdapterPresenter provideDataAwareAdapter(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final DiffCalculator provideDiffCalculator(@NotNull ContentsComparator contentsComparator, @NotNull EqualityComparator equalityComparator) {
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
        return new SimpleDiffCalculator(contentsComparator, equalityComparator, true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<SocialNotificationAction> provideNotificationsActionsStream$social_network_editor_release() {
        PublishRelay<SocialNotificationAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<SocialNotificationAction>()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleRecyclerAdapter(dataAwareAdapterPresenter, itemBinder);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003a: APUT  
      (r0v8 com.avito.android.social.SignInManager[])
      (0 ??[int, short, byte, char])
      (r8v1 com.avito.android.social.EsiaSignInManager)
     */
    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final List<SignInManager> provideSocialManagers$social_network_editor_release(@NotNull FacebookSocialManager facebookSocialManager, @NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull VkontakteSocialManager vkontakteSocialManager, @NotNull GoogleSocialManager googleSocialManager, @NotNull AppleSignInManager appleSignInManager, @NotNull EsiaSignInManager esiaSignInManager, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(facebookSocialManager, "facebookSocialManager");
        Intrinsics.checkNotNullParameter(odnoklassnikiSocialManager, "odnoklassnikiSocialManager");
        Intrinsics.checkNotNullParameter(vkontakteSocialManager, "vkontakteSocialManager");
        Intrinsics.checkNotNullParameter(googleSocialManager, "googleSocialManager");
        Intrinsics.checkNotNullParameter(appleSignInManager, "appleSignInManager");
        Intrinsics.checkNotNullParameter(esiaSignInManager, "esiaSignInManager");
        Intrinsics.checkNotNullParameter(features, "features");
        SignInManager[] signInManagerArr = new SignInManager[6];
        if (!features.getEsiaInProfile().invoke().booleanValue()) {
            esiaSignInManager = null;
        }
        signInManagerArr[0] = esiaSignInManager;
        signInManagerArr[1] = vkontakteSocialManager;
        signInManagerArr[2] = odnoklassnikiSocialManager;
        if (!features.getSignInWithApple().invoke().booleanValue()) {
            appleSignInManager = null;
        }
        signInManagerArr[3] = appleSignInManager;
        signInManagerArr[4] = facebookSocialManager;
        if (!googleSocialManager.isAvailable()) {
            googleSocialManager = null;
        }
        signInManagerArr[5] = googleSocialManager;
        return new ArrayList(CollectionsKt__CollectionsKt.listOfNotNull((Object[]) signInManagerArr));
    }
}
