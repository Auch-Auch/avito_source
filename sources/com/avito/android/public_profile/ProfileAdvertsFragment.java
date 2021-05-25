package com.avito.android.public_profile;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.public_profile.ProfileAdvertsPresenter;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.FragmentsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B\u0007¢\u0006\u0004\b\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJY\u0010)\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010k\u001a\u00020j8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010y\u001a\u00020x8\u0006@\u0006X.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006\u0001"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "getAbTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "setAbTestsConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)V", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "tracker", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "getTracker", "()Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "setTracker", "(Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "interactor", "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "getInteractor", "()Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "setInteractor", "(Lcom/avito/android/public_profile/ProfileAdvertsInteractor;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "presenter", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "getPresenter", "()Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "setPresenter", "(Lcom/avito/android/public_profile/ProfileAdvertsPresenter;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "<init>", "Factory", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsFragment extends TabBaseFragment implements ProfileAdvertsPresenter.Router {
    @Inject
    public AbTestsConfigProvider abTestsConfigProvider;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ProfileAdvertsInteractor interactor;
    @Inject
    public ProfileAdvertsPresenter presenter;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public PublicProfileAdvertsTracker tracker;
    @Inject
    public DestroyableViewHolderBuilder viewHolderBuilder;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsFragment$Factory;", "", "", "userKey", "shortcut", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", InternalConstsKt.PLACEHOLDER, "contextId", "Lcom/avito/android/public_profile/ProfileAdvertsFragment;", "create", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/screens/Screen;ZLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/public_profile/ProfileAdvertsFragment;", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Screen d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ String f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, String str3, Screen screen, boolean z, String str4) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = screen;
                this.e = z;
                this.f = str4;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("user_key", this.a);
                bundle2.putString("shortcut", this.b);
                bundle2.putString(InternalConstsKt.PLACEHOLDER, this.c);
                bundle2.putParcelable(InternalConstsKt.SCREEN, this.d);
                bundle2.putBoolean("sub_component", this.e);
                bundle2.putString("context_id", this.f);
                return Unit.INSTANCE;
            }
        }

        public static /* synthetic */ ProfileAdvertsFragment create$default(Factory factory, String str, String str2, Screen screen, boolean z, String str3, String str4, int i, Object obj) {
            return factory.create(str, str2, screen, (i & 8) != 0 ? false : z, str3, str4);
        }

        @NotNull
        public final ProfileAdvertsFragment create(@NotNull String str, @NotNull String str2, @NotNull Screen screen, boolean z, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(str, "userKey");
            Intrinsics.checkNotNullParameter(str2, "shortcut");
            Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
            return (ProfileAdvertsFragment) FragmentsKt.arguments(new ProfileAdvertsFragment(), 6, new a(str, str2, str3, screen, z, str4));
        }
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final AbTestsConfigProvider getAbTestsConfigProvider() {
        AbTestsConfigProvider abTestsConfigProvider2 = this.abTestsConfigProvider;
        if (abTestsConfigProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abTestsConfigProvider");
        }
        return abTestsConfigProvider2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ProfileAdvertsInteractor getInteractor() {
        ProfileAdvertsInteractor profileAdvertsInteractor = this.interactor;
        if (profileAdvertsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return profileAdvertsInteractor;
    }

    @NotNull
    public final ProfileAdvertsPresenter getPresenter() {
        ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
        if (profileAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return profileAdvertsPresenter;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        return spanSizeLookup2;
    }

    @NotNull
    public final PublicProfileAdvertsTracker getTracker() {
        PublicProfileAdvertsTracker publicProfileAdvertsTracker = this.tracker;
        if (publicProfileAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return publicProfileAdvertsTracker;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PublicProfileAdvertsTracker publicProfileAdvertsTracker = this.tracker;
        if (publicProfileAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileAdvertsTracker.startInit();
        return layoutInflater.inflate(R.layout.profile_adverts, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
        if (profileAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileAdvertsPresenter.detachView();
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getPublicProfileWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
            if (profileAdvertsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Bundles.putKundle(bundle2, "presenter_state", profileAdvertsPresenter.onSaveState());
            saveInRetainStorage(bundle2);
            return;
        }
        ProfileAdvertsPresenter profileAdvertsPresenter2 = this.presenter;
        if (profileAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", new CompressedParcelable(profileAdvertsPresenter2.onSaveState()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
        if (profileAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileAdvertsPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
        if (profileAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileAdvertsPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        ProfileAdvertsViewImpl profileAdvertsViewImpl = new ProfileAdvertsViewImpl(view, adapterPresenter2, destroyableViewHolderBuilder, spannedGridPositionProvider, spanSizeLookup2);
        ProfileAdvertsPresenter profileAdvertsPresenter = this.presenter;
        if (profileAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileAdvertsPresenter.attachView(profileAdvertsViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.attachView(profileAdvertsViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(profileAdvertsViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter3.attachErrorMessageView(profileAdvertsViewImpl);
        PublicProfileAdvertsTracker publicProfileAdvertsTracker = this.tracker;
        if (publicProfileAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileAdvertsTracker.trackInit();
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter.Router
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2560, null));
    }

    public final void setAbTestsConfigProvider(@NotNull AbTestsConfigProvider abTestsConfigProvider2) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider2, "<set-?>");
        this.abTestsConfigProvider = abTestsConfigProvider2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull ProfileAdvertsInteractor profileAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(profileAdvertsInteractor, "<set-?>");
        this.interactor = profileAdvertsInteractor;
    }

    public final void setPresenter(@NotNull ProfileAdvertsPresenter profileAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(profileAdvertsPresenter, "<set-?>");
        this.presenter = profileAdvertsPresenter;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setTracker(@NotNull PublicProfileAdvertsTracker publicProfileAdvertsTracker) {
        Intrinsics.checkNotNullParameter(publicProfileAdvertsTracker, "<set-?>");
        this.tracker = publicProfileAdvertsTracker;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    @Override // com.avito.android.ui.fragments.BaseFragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setUpFragmentComponent(@org.jetbrains.annotations.Nullable android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.public_profile.ProfileAdvertsFragment.setUpFragmentComponent(android.os.Bundle):boolean");
    }

    public final void setViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }
}
