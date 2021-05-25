package com.avito.android.authorization.select_profile.social_login;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.login.di.LoginModule;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter;
import com.avito.android.authorization.select_profile.social_login.di.DaggerSocialRegistrationSuggestsComponent;
import com.avito.android.authorization.select_profile.social_login.di.SocialRegistrationSuggestsComponent;
import com.avito.android.authorization.select_profile.social_login.di.SocialRegistrationSuggestsDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.social.SocialActivity;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b:\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0011R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "", "login", "suggestKey", "openLogin", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "social", "openSelectSocial", "(Ljava/util/List;Ljava/lang/String;)V", "leaveScreen", "onProfileCreated", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;", "presenter", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;", "getPresenter", "()Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;", "setPresenter", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsFragment extends BaseFragment implements SocialRegistrationSuggestsPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SocialRegistrationSuggestsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment$Companion;", "", "", "title", "suggestKey", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "socialType", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SocialRegistrationSuggestsFragment newInstance(@NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "suggestKey");
            Intrinsics.checkNotNullParameter(list, "profiles");
            Intrinsics.checkNotNullParameter(str3, "socialType");
            SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment = new SocialRegistrationSuggestsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putString(LoginModule.SUGGEST_KEY, str2);
            Bundles.putParcelableList(bundle, "profiles", list);
            bundle.putString(SocialActivity.SOCIAL_TYPE_PARAM, str3);
            Unit unit = Unit.INSTANCE;
            socialRegistrationSuggestsFragment.setArguments(bundle);
            return socialRegistrationSuggestsFragment;
        }

        public Companion(j jVar) {
        }
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SocialRegistrationSuggestsPresenter getPresenter() {
        SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter = this.presenter;
        if (socialRegistrationSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return socialRegistrationSuggestsPresenter;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter.Router
    public void leaveScreen() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.social_registration_suggests, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SocialRegistrationSuggestsViewImpl socialRegistrationSuggestsViewImpl = new SocialRegistrationSuggestsViewImpl(viewGroup2, adapterPresenter2, itemBinder2);
        SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter = this.presenter;
        if (socialRegistrationSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialRegistrationSuggestsPresenter.attachView(socialRegistrationSuggestsViewImpl);
        SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter2 = this.presenter;
        if (socialRegistrationSuggestsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialRegistrationSuggestsPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter = this.presenter;
        if (socialRegistrationSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialRegistrationSuggestsPresenter.detachView();
        SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter2 = this.presenter;
        if (socialRegistrationSuggestsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialRegistrationSuggestsPresenter2.detachRouter();
        super.onDestroyView();
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter.Router
    public void onProfileCreated() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "it");
        requireActivity.startActivity(IntentsKt.withClearTopFlags(com.avito.android.authorization.IntentsKt.withResult(AuthParamsKt.getTargetIntent(requireActivity), -1)));
        requireActivity.finish();
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter.Router
    public void openLogin(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "suggestKey");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        startActivity(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, AuthParamsKt.getTargetIntent(requireActivity), str, null, true, str2, false, 32, null));
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter.Router
    public void openSelectSocial(@NotNull List<ProfileSocial> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "social");
        Intrinsics.checkNotNullParameter(str, "suggestKey");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        startActivity(activityIntentFactory.selectSocialIntent(AuthParamsKt.getTargetIntent(requireActivity), list, str));
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter) {
        Intrinsics.checkNotNullParameter(socialRegistrationSuggestsPresenter, "<set-?>");
        this.presenter = socialRegistrationSuggestsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string;
        String string2;
        ArrayList parcelableArrayList;
        String string3;
        SocialRegistrationSuggestsComponent.Factory factory = DaggerSocialRegistrationSuggestsComponent.factory();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("title")) == null) {
            throw new IllegalStateException("Title must not be null");
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…\"Title must not be null\")");
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString(LoginModule.SUGGEST_KEY)) == null) {
            throw new IllegalStateException("Suggest key  must not be null");
        }
        Intrinsics.checkNotNullExpressionValue(string2, "arguments?.getString(KEY…t key  must not be null\")");
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (parcelableArrayList = arguments3.getParcelableArrayList("profiles")) == null) {
            throw new IllegalStateException("Profiles must not be null");
        }
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string3 = arguments4.getString(SocialActivity.SOCIAL_TYPE_PARAM)) == null) {
            throw new IllegalStateException("Social type must not be null");
        }
        Intrinsics.checkNotNullExpressionValue(string3, "arguments?.getString(KEY…l type must not be null\")");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(string, string2, string3, parcelableArrayList, resources, (SocialRegistrationSuggestsDependencies) ComponentDependenciesKt.getDependencies(SocialRegistrationSuggestsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }
}
