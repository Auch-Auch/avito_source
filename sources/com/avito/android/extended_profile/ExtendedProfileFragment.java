package com.avito.android.extended_profile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.Features;
import com.avito.android.PhotoGalleryIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.extended_profile.ExtendedProfileView;
import com.avito.android.extended_profile.ExtendedProfileViewSingleLiveEvent;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.di.DaggerExtendedProfileComponent;
import com.avito.android.extended_profile.di.ExtendedProfileComponent;
import com.avito.android.extended_profile.di.ExtendedProfileDependencies;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.public_profile.ui.OnBackPressedListener;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Á\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Á\u0001B\b¢\u0006\u0005\bÀ\u0001\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J%\u0010\u001c\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0014J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J)\u00104\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0014J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0014J#\u00107\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b7\u0010;J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b<\u0010%J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bA\u0010@J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bB\u0010%R\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020=0b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR(\u0010v\u001a\b\u0012\u0004\u0012\u00020u0t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R2\u0010}\u001a\b\u0012\u0004\u0012\u00020&0|8\u0006@\u0006X.¢\u0006\u001c\n\u0004\b}\u0010~\u0012\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R-\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010t8\u0006@\u0006X.¢\u0006\u0015\n\u0005\b\u0001\u0010w\u001a\u0005\b\u0001\u0010y\"\u0005\b\u0001\u0010{R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001a\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0006X\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R*\u0010®\u0001\u001a\u00030§\u00018\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010­\u0001R*\u0010°\u0001\u001a\u00030¯\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010\u0010\u001a\u00030¶\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R*\u0010º\u0001\u001a\u00030¹\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/extended_profile/ExtendedProfileView$Router;", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openFullScreenGallery", "(Ljava/util/List;I)V", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;", "event", "openAdvertDetails", "(Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "title", "text", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "leaveScreen", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "call", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "openNotificationsSettings", "openAuthScreen", "source", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "(Ljava/lang/String;Landroid/os/Parcelable;)V", "openFavoriteSellers", "Lcom/avito/android/public_profile/ui/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnBackPressedListener", "(Lcom/avito/android/public_profile/ui/OnBackPressedListener;)V", "removeOnBackPressedListener", "followDeepLinkFromSubscriptions", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "viewModel", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "getViewModel", "()Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "setViewModel", "(Lcom/avito/android/extended_profile/ExtendedProfileViewModel;)V", "Ldagger/Lazy;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup;", "spanLookup", "Ldagger/Lazy;", "getSpanLookup", "()Ldagger/Lazy;", "setSpanLookup", "(Ldagger/Lazy;)V", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "getSubscriptionsPresenter", "()Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "setSubscriptionsPresenter", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;)V", "columnCount", "I", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "", "l", "Ljava/util/List;", "backPressedListener", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "galleryClicks", "Lio/reactivex/rxjava3/core/Observable;", "getGalleryClicks", "()Lio/reactivex/rxjava3/core/Observable;", "setGalleryClicks", "(Lio/reactivex/rxjava3/core/Observable;)V", "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Lcom/avito/android/util/Formatter;", "getPhoneFormatter", "()Lcom/avito/android/util/Formatter;", "setPhoneFormatter", "(Lcom/avito/android/util/Formatter;)V", "getPhoneFormatter$annotations", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "clicks", "getClicks", "setClicks", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "isTablet", "Z", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "j", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulersFactory3", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/extended_profile/ExtendedProfileView;", "k", "Lcom/avito/android/extended_profile/ExtendedProfileView;", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "Companion", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileFragment extends TabBaseFragment implements ExtendedProfileView.Router, SubscriptionsPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Observable<ExtendedProfileItemAction> clicks;
    @Inject
    @JvmField
    public int columnCount;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Features features;
    @Inject
    public Observable<TnsGalleryItemClickAction> galleryClicks;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    @JvmField
    public boolean isTablet;
    @Inject
    public ItemBinder itemBinder;
    @NotNull
    public NavigationState j = new NavigationState(false);
    public ExtendedProfileView k;
    public final List<OnBackPressedListener> l = new ArrayList();
    @Inject
    public Formatter<String> phoneFormatter;
    @Inject
    public SchedulersFactory3 schedulersFactory3;
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;
    @Inject
    public Lazy<ExtendedProfileSpanLookup> spanLookup;
    @Inject
    public SubscriptionsPresenter subscriptionsPresenter;
    @Inject
    public ExtendedProfileViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileFragment$Companion;", "", "Lcom/avito/android/extended_profile/ExtendedProfileArguments;", "arguments", "Lcom/avito/android/extended_profile/ExtendedProfileFragment;", "newInstance", "(Lcom/avito/android/extended_profile/ExtendedProfileArguments;)Lcom/avito/android/extended_profile/ExtendedProfileFragment;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ ExtendedProfileArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ExtendedProfileArguments extendedProfileArguments) {
                super(1);
                this.a = extendedProfileArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final ExtendedProfileFragment newInstance(@NotNull ExtendedProfileArguments extendedProfileArguments) {
            Intrinsics.checkNotNullParameter(extendedProfileArguments, "arguments");
            return (ExtendedProfileFragment) FragmentsKt.arguments$default(new ExtendedProfileFragment(), 0, new a(extendedProfileArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            Logs.error(exc2);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            Logs.error(exc2);
            return Unit.INSTANCE;
        }
    }

    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    public static /* synthetic */ void getPhoneFormatter$annotations() {
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void addOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.l.contains(onBackPressedListener)) {
            this.l.add(onBackPressedListener);
        }
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void call(@NotNull PhoneLink.Call call) {
        Intrinsics.checkNotNullParameter(call, "phoneLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        try {
            startActivity(deepLinkIntentFactory2.getIntent(call));
        } catch (ActivityNotFoundException unused) {
            CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
            if (compositeSnackbarPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
            }
            String string = getString(R.string.cant_do_call);
            Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.cant_do_call)");
            CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(compositeSnackbarPresenter, string, 0, null, 0, null, 0, null, null, 254, null);
        }
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            IntentsKt.replaceTargetTabIfRequired(intent, currentTab());
            startActivity(intent);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void followDeepLinkFromSubscriptions(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink);
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
    public final Observable<ExtendedProfileItemAction> getClicks() {
        Observable<ExtendedProfileItemAction> observable = this.clicks;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clicks");
        }
        return observable;
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final Observable<TnsGalleryItemClickAction> getGalleryClicks() {
        Observable<TnsGalleryItemClickAction> observable = this.galleryClicks;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryClicks");
        }
        return observable;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.j;
    }

    @NotNull
    public final Formatter<String> getPhoneFormatter() {
        Formatter<String> formatter = this.phoneFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneFormatter");
        }
        return formatter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulersFactory3() {
        SchedulersFactory3 schedulersFactory32 = this.schedulersFactory3;
        if (schedulersFactory32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory3");
        }
        return schedulersFactory32;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    @NotNull
    public final Lazy<ExtendedProfileSpanLookup> getSpanLookup() {
        Lazy<ExtendedProfileSpanLookup> lazy = this.spanLookup;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanLookup");
        }
        return lazy;
    }

    @NotNull
    public final SubscriptionsPresenter getSubscriptionsPresenter() {
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        return subscriptionsPresenter2;
    }

    @NotNull
    public final ExtendedProfileViewModel getViewModel() {
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return extendedProfileViewModel;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void leaveScreen() {
        if (!(getActivity() instanceof ExtendedProfileActivity)) {
            finish();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (z) {
            SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
            if (subscriptionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
            }
            subscriptionsPresenter2.onAuthCompleted();
            Parcelable successAuthResultData = AuthIntentFactoryKt.getSuccessAuthResultData(intent);
            if (!(successAuthResultData instanceof DeepLink)) {
                successAuthResultData = null;
            }
            DeepLink deepLink = (DeepLink) successAuthResultData;
            if (deepLink != null) {
                ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
                if (extendedProfileViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                extendedProfileViewModel.handleDeepLink(deepLink);
            }
        } else {
            SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
            if (subscriptionsPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
            }
            subscriptionsPresenter3.onAuthCanceled();
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        ExtendedProfileArguments extendedProfileArguments;
        ScreenTransfer screenTransfer;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (extendedProfileArguments = (ExtendedProfileArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("Arguments must be specified");
        }
        Timer B1 = a2.b.a.a.a.B1();
        ExtendedProfileComponent.Factory factory = DaggerExtendedProfileComponent.factory();
        String userKey = extendedProfileArguments.getUserKey();
        ExtendedPublicUserProfile profile = extendedProfileArguments.getProfile();
        String contextId = extendedProfileArguments.getContextId();
        TreeClickStreamParent treeParent = extendedProfileArguments.getTreeParent();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(userKey, profile, contextId, treeParent, activity, this, resources, (ExtendedProfileDependencies) ComponentDependenciesKt.getDependencies(ExtendedProfileDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        extendedProfileViewModel.trackDiInject(B1.elapsed());
        ExtendedProfileViewModel extendedProfileViewModel2 = this.viewModel;
        if (extendedProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Observable<ExtendedProfileItemAction> observable = this.clicks;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clicks");
        }
        Observable<TnsGalleryItemClickAction> observable2 = this.galleryClicks;
        if (observable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryClicks");
        }
        extendedProfileViewModel2.observeClicks(observable, observable2);
        if (bundle == null && (screenTransfer = extendedProfileArguments.getScreenTransfer()) != null) {
            ExtendedProfileViewModel extendedProfileViewModel3 = this.viewModel;
            if (extendedProfileViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            extendedProfileViewModel3.recover(screenTransfer);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        extendedProfileViewModel.startInit();
        return layoutInflater.inflate(R.layout.extended_profile_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
        ExtendedProfileView extendedProfileView = this.k;
        if (extendedProfileView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        extendedProfileView.clear();
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        extendedProfileViewModel.stopTracking();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.attachRouter(this);
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        extendedProfileViewModel.refreshState();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.detachRouter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ExtendedProfileViewModel extendedProfileViewModel = this.viewModel;
        if (extendedProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        Formatter<String> formatter = this.phoneFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneFormatter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        boolean z = this.isTablet;
        int i = this.columnCount;
        Lazy<ExtendedProfileSpanLookup> lazy = this.spanLookup;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanLookup");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SchedulersFactory3 schedulersFactory32 = this.schedulersFactory3;
        if (schedulersFactory32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory3");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        this.k = new ExtendedProfileViewImpl(view, extendedProfileViewModel, this, viewLifecycleOwner, compositeSnackbarPresenter, formatter, dialogRouter2, z, i, lazy, adapterPresenter2, schedulersFactory32, itemBinder2, features2);
        CompositeSnackbarPresenter compositeSnackbarPresenter2 = this.snackbarPresenter;
        if (compositeSnackbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        ExtendedProfileView extendedProfileView = this.k;
        if (extendedProfileView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        compositeSnackbarPresenter2.setDefaultElement(extendedProfileView);
        ExtendedProfileViewModel extendedProfileViewModel2 = this.viewModel;
        if (extendedProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        extendedProfileViewModel2.trackInit();
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void openAdvertDetails(@NotNull ExtendedProfileViewSingleLiveEvent.AdvertDetailsOpenEvent advertDetailsOpenEvent) {
        Intrinsics.checkNotNullParameter(advertDetailsOpenEvent, "event");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.advertDetailsIntent(advertDetailsOpenEvent.getItemId(), advertDetailsOpenEvent.getContext(), advertDetailsOpenEvent.getTitle(), advertDetailsOpenEvent.getPrice(), advertDetailsOpenEvent.getOldPrice(), advertDetailsOpenEvent.getImage(), false, null, SystemClock.elapsedRealtime(), advertDetailsOpenEvent.getGalleryPosition(), currentTab(), ScreenSource.EXTENDED_PROFILE.INSTANCE));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentsKt.startActivityForResultSafely(this, com.avito.android.util.IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.SUBSCRIBE_SELLER, null, 5, null)), 1, a.a);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openFavoriteSellers(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void openFullScreenGallery(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(com.avito.android.util.IntentsKt.withClearTopFlags(PhotoGalleryIntentFactory.DefaultImpls.legacyPhotoGalleryIntent$default(activityIntentFactory, null, list, i, null, null, null, null, null, null, null, null, null, 4088, null)));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openNotificationsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void openShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(Intent.createChooser(implicitIntentFactory2.shareItemIntent(str2, str), getString(R.string.extended_profile_share)));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void removeOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.l.remove(onBackPressedListener);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setClicks(@NotNull Observable<ExtendedProfileItemAction> observable) {
        Intrinsics.checkNotNullParameter(observable, "<set-?>");
        this.clicks = observable;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGalleryClicks(@NotNull Observable<TnsGalleryItemClickAction> observable) {
        Intrinsics.checkNotNullParameter(observable, "<set-?>");
        this.galleryClicks = observable;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.j = navigationState;
    }

    public final void setPhoneFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneFormatter = formatter;
    }

    public final void setSchedulersFactory3(@NotNull SchedulersFactory3 schedulersFactory32) {
        Intrinsics.checkNotNullParameter(schedulersFactory32, "<set-?>");
        this.schedulersFactory3 = schedulersFactory32;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    public final void setSpanLookup(@NotNull Lazy<ExtendedProfileSpanLookup> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.spanLookup = lazy;
    }

    public final void setSubscriptionsPresenter(@NotNull SubscriptionsPresenter subscriptionsPresenter2) {
        Intrinsics.checkNotNullParameter(subscriptionsPresenter2, "<set-?>");
        this.subscriptionsPresenter = subscriptionsPresenter2;
    }

    public final void setViewModel(@NotNull ExtendedProfileViewModel extendedProfileViewModel) {
        Intrinsics.checkNotNullParameter(extendedProfileViewModel, "<set-?>");
        this.viewModel = extendedProfileViewModel;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView.Router
    public void openAuthScreen(@Nullable String str, @Nullable Parcelable parcelable) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentsKt.startActivityForResultSafely(this, com.avito.android.util.IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, str, parcelable, 1, null)), 1, b.a);
    }
}
