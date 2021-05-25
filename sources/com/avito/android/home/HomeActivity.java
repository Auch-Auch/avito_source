package com.avito.android.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.CalledFrom;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestPrefsKt;
import com.avito.android.ab_tests.AbTests;
import com.avito.android.ab_tests.DraftsOnStartPublishSheet;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.InAppUpdateAcceptEvent;
import com.avito.android.analytics.event.InAppUpdateCancelEvent;
import com.avito.android.analytics.event.InAppUpdateShowEvent;
import com.avito.android.analytics.sideload.SideloadDelegate;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.BottomNavigationController;
import com.avito.android.bottom_navigation.NavigationProvider;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSet;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.UpNavigationHandler;
import com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener;
import com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerHomeActivityComponent;
import com.avito.android.di.component.HomeActivityDependencies;
import com.avito.android.home.analytics.FakeAbConfigCheckEvent;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.R;
import com.avito.android.ui.UserProfileStatusDataProvider;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.ResultFragmentData;
import com.avito.android.ui.fragments.ResultReportData;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Intents;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.android.util.preferences.Preferences;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 »\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002»\u0001B\b¢\u0006\u0005\bº\u0001\u0010\u0012J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0012J)\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0007H\u0014¢\u0006\u0004\b \u0010\u0012J\u0019\u0010!\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0012J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\u0012J\u001f\u00105\u001a\u00020\u00072\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0015H\u0014¢\u0006\u0004\b7\u00108J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>R\u001e\u0010B\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010?8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR1\u0010|\u001a\b\u0012\u0004\u0012\u00020{0z8\u0006@\u0006X.¢\u0006\u001b\n\u0004\b|\u0010}\u0012\u0005\b\u0001\u0010\u0012\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u001f\n\u0006\b\u0001\u0010\u0001\u0012\u0005\b\u0001\u0010\u0012\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001RB\u0010\u0001\u001a+\u0012\r\u0012\u000b \u0001*\u0004\u0018\u00010,0, \u0001*\u0014\u0012\r\u0012\u000b \u0001*\u0004\u0018\u00010,0,\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010£\u0001\u001a\u00030 \u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R1\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¤\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/avito/android/home/HomeActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/bottom_navigation/UpNavigationHandler;", "Lcom/avito/android/bottom_navigation/ui/OnAddButtonStateChangeListener;", "Lcom/avito/android/bottom_navigation/NavigationProvider;", "Landroid/content/Intent;", "intent", "", AuthSource.SEND_ABUSE, "(Landroid/content/Intent;)V", "", "setUpCustomToolbar", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setContentView", "()V", "onStart", "popupSnackbarForCompleteUpdate", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStop", "onResume", "onPause", "outState", "onSaveInstanceState", "onDestroy", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "onNewIntent", "onBackPressed", "finishFragment", "", "fragmentId", "Lcom/avito/android/ui/fragments/ResultReportData;", "resultReportData", "reportFragmentResult", "(Ljava/lang/String;Lcom/avito/android/ui/fragments/ResultReportData;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;", "resultDispatcher", "registerSelf", "(Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;)V", "handleUpNavigation", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/bottom_navigation/AddButtonState;", "state", "onAddButtonStateChange", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/bottom_navigation/AddButtonState;)V", "getContentLayoutId", "()I", "Lcom/avito/android/bottom_navigation/NavigationTab;", "currentTab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "registerStartForResult", "(Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "Lio/reactivex/rxjava3/core/Observable;", "getTabObservable", "()Lio/reactivex/rxjava3/core/Observable;", "tabObservable", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/util/KeyboardSubscription;", "l", "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lcom/avito/android/ui/UserProfileStatusDataProvider;", "userProfileStatusDataProvider", "Lcom/avito/android/ui/UserProfileStatusDataProvider;", "getUserProfileStatusDataProvider", "()Lcom/avito/android/ui/UserProfileStatusDataProvider;", "setUserProfileStatusDataProvider", "(Lcom/avito/android/ui/UserProfileStatusDataProvider;)V", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", VKApiConst.Q, "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "navigationTabSet", "", "r", "Ljava/lang/Object;", "installStateUpdatedListener", "Lcom/avito/android/bottom_navigation/BottomNavigationController;", "k", "Lcom/avito/android/bottom_navigation/BottomNavigationController;", "bottomNavigationController", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "tabBadgeDisposable", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "draftsOnStartPublishSheet", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "getDraftsOnStartPublishSheet", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "setDraftsOnStartPublishSheet", "(Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "getDraftsOnStartPublishSheet$annotations", "Lio/reactivex/rxjava3/disposables/Disposable;", "n", "Lio/reactivex/rxjava3/disposables/Disposable;", "counterDisposable", "Lcom/avito/android/util/preferences/Preferences;", "abPreferences", "Lcom/avito/android/util/preferences/Preferences;", "getAbPreferences", "()Lcom/avito/android/util/preferences/Preferences;", "setAbPreferences", "(Lcom/avito/android/util/preferences/Preferences;)V", "getAbPreferences$annotations", "", "kotlin.jvm.PlatformType", "", "p", "Ljava/util/Set;", "dispatchers", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "tabFragmentFactory", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "getTabFragmentFactory", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "setTabFragmentFactory", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;)V", "Lcom/avito/android/analytics/sideload/SideloadDelegate;", "o", "Lcom/avito/android/analytics/sideload/SideloadDelegate;", "sideloadDelegate", "", "s", "J", "inAppUpdateLastTimeStamp", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsTabTestGroup", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getUserAdvertsTabTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "setUserAdvertsTabTestGroup", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "inAppUpdateTestGroup", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "getInAppUpdateTestGroup", "()Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "setInAppUpdateTestGroup", "(Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Factory", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeActivity extends BaseActivity implements UpNavigationHandler, OnAddButtonStateChangeListener, NavigationProvider {
    @NotNull
    public static final Factory Factory = new Factory(null);
    @Inject
    public Preferences abPreferences;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public BuildInfo buildInfo;
    @Inject
    public ManuallyExposedAbTestGroup<SimpleTestGroup> draftsOnStartPublishSheet;
    @Inject
    public Features features;
    @Inject
    public InAppUpdateTestGroup inAppUpdateTestGroup;
    public BottomNavigationController k;
    public KeyboardSubscription l;
    public final CompositeDisposable m = new CompositeDisposable();
    public Disposable n;
    public SideloadDelegate o;
    public final Set<ResultDispatcher> p = Collections.newSetFromMap(new WeakHashMap());
    public NavigationTabSet q;
    public Object r;
    public long s;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public TabFragmentFactory tabFragmentFactory;
    @Inject
    public SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsTabTestGroup;
    @Inject
    public UserProfileStatusDataProvider userProfileStatusDataProvider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/home/HomeActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Landroid/content/Intent;", "", "EXTRA_TAB", "Ljava/lang/String;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public Factory() {
        }

        public static final Intent access$create(Factory factory, Context context, int i) {
            Objects.requireNonNull(factory);
            Intent putExtra = new Intent().setClassName(context, "com.avito.android.Launcher").setFlags(603979776).putExtra("tab_ordinal", i);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().setClassName(co…ra(EXTRA_TAB, tabOrdinal)");
            return putExtra;
        }

        @NotNull
        public final Intent create(@NotNull Context context, @NotNull TabFragmentFactory.Data data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent flags = new Intent().setClassName(context, "com.avito.android.Launcher").setFlags(603979776);
            Intrinsics.checkNotNullExpressionValue(flags, "Intent().setClassName(co…FLAG_ACTIVITY_SINGLE_TOP)");
            return IntentsKt.putTabFragmentData(flags, data);
        }

        public Factory(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserAdvertsTabTestGroup.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a<ResultT> implements OnSuccessListener<AppUpdateInfo> {
        public final /* synthetic */ HomeActivity a;
        public final /* synthetic */ AppUpdateManager b;

        public a(HomeActivity homeActivity, AppUpdateManager appUpdateManager) {
            this.a = homeActivity;
            this.b = appUpdateManager;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.play.core.tasks.OnSuccessListener
        public void onSuccess(AppUpdateInfo appUpdateInfo) {
            AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
            if (appUpdateInfo2.updateAvailability() == 3) {
                HomeActivity.access$callUpdateFlow(this.a, this.b, appUpdateInfo2, 1);
            }
        }
    }

    public static final class b<ResultT> implements OnSuccessListener<AppUpdateInfo> {
        public final /* synthetic */ HomeActivity a;
        public final /* synthetic */ AppUpdateManager b;

        public b(HomeActivity homeActivity, AppUpdateManager appUpdateManager) {
            this.a = homeActivity;
            this.b = appUpdateManager;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.play.core.tasks.OnSuccessListener
        public void onSuccess(AppUpdateInfo appUpdateInfo) {
            AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
            if (appUpdateInfo2.updateAvailability() == 2) {
                if (appUpdateInfo2.isUpdateTypeAllowed(0)) {
                    this.a.getAnalytics().track(new InAppUpdateShowEvent());
                    HomeActivity.access$callUpdateFlow(this.a, this.b, appUpdateInfo2, 0);
                    HomeActivity.access$saveLastUpdateTime(this.a);
                } else if (appUpdateInfo2.isUpdateTypeAllowed(1)) {
                    this.a.getAnalytics().track(new InAppUpdateShowEvent());
                    HomeActivity.access$callUpdateFlow(this.a, this.b, appUpdateInfo2, 1);
                    HomeActivity.access$saveLastUpdateTime(this.a);
                }
            } else if (appUpdateInfo2.installStatus() == 11) {
                this.a.popupSnackbarForCompleteUpdate();
            }
        }
    }

    public static final class c implements OnFailureListener {
        public static final c a = new c();

        @Override // com.google.android.play.core.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            Logs.error("InAppUpdate: failure", exc);
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HomeActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(HomeActivity homeActivity) {
            super(0);
            this.a = homeActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AppUpdateManager create = AppUpdateManagerFactory.create(this.a.getApplicationContext());
            if (create != null) {
                create.completeUpdate();
            }
            return Unit.INSTANCE;
        }
    }

    public static final void access$callUpdateFlow(HomeActivity homeActivity, AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, int i) {
        Objects.requireNonNull(homeActivity);
        try {
            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, homeActivity, 0);
        } catch (Exception e) {
            Logs.error("InAppUpdate: callUpdateFlow error", e);
        }
    }

    public static final /* synthetic */ NavigationTabSet access$getNavigationTabSet$p(HomeActivity homeActivity) {
        NavigationTabSet navigationTabSet = homeActivity.q;
        if (navigationTabSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationTabSet");
        }
        return navigationTabSet;
    }

    public static final void access$openAuthScreen(HomeActivity homeActivity, Intent intent, NavigationTabSetItem navigationTabSetItem) {
        String str;
        Objects.requireNonNull(homeActivity);
        if (Intrinsics.areEqual(navigationTabSetItem, NavigationTab.ADD.INSTANCE)) {
            str = AuthSource.CREATE_ADVERT;
        } else if (Intrinsics.areEqual(navigationTabSetItem, NavigationTab.MESSAGE.INSTANCE)) {
            str = AuthSource.OPEN_CHANNEL_LIST;
        } else {
            str = Intrinsics.areEqual(navigationTabSetItem, NavigationTab.PROFILE.INSTANCE) ? AuthSource.OPEN_USER_ADVERTS : AuthSource.TEST_1;
        }
        ActivityIntentFactory activityIntentFactory2 = homeActivity.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        homeActivity.startActivity(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, intent, str, null, 4, null));
    }

    public static final void access$saveLastUpdateTime(HomeActivity homeActivity) {
        Objects.requireNonNull(homeActivity);
        homeActivity.s = System.currentTimeMillis();
        Preferences preferences = homeActivity.abPreferences;
        if (preferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abPreferences");
        }
        preferences.putLong("in_app_update_last_timestamp", homeActivity.s);
    }

    @AbTests
    public static /* synthetic */ void getAbPreferences$annotations() {
    }

    @DraftsOnStartPublishSheet
    public static /* synthetic */ void getDraftsOnStartPublishSheet$annotations() {
    }

    public final void a(Intent intent) {
        BottomNavigationController bottomNavigationController;
        TabFragmentFactory.Data tabFragmentData = IntentsKt.getTabFragmentData(intent);
        int intExtra = intent.getIntExtra("tab_ordinal", -1);
        CalledFrom calledFrom = Intents.getCalledFrom(intent);
        if (((calledFrom instanceof CalledFrom.AppLinking) && Intrinsics.areEqual(((CalledFrom.AppLinking) calledFrom).getPath(), AdvertPublicationLink.PATH)) || ((calledFrom instanceof CalledFrom.Push) && Intrinsics.areEqual(((CalledFrom.Push) calledFrom).getPath(), AdvertPublicationLink.PATH))) {
            BottomNavigationController bottomNavigationController2 = this.k;
            if (bottomNavigationController2 != null) {
                bottomNavigationController2.selectTab(NavigationTab.ADD.INSTANCE);
            }
        } else if (tabFragmentData != null) {
            BottomNavigationController bottomNavigationController3 = this.k;
            if (bottomNavigationController3 != null) {
                bottomNavigationController3.openScreen(tabFragmentData);
            }
        } else if (intExtra > -1) {
            NavigationTabSet navigationTabSet = this.q;
            if (navigationTabSet == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationTabSet");
            }
            NavigationTabSetItem navigationTabSetItem = (NavigationTabSetItem) CollectionsKt___CollectionsKt.elementAt(navigationTabSet, intExtra);
            BottomNavigationController bottomNavigationController4 = this.k;
            if (bottomNavigationController4 != null) {
                bottomNavigationController4.selectTab(navigationTabSetItem);
            }
        } else {
            BottomNavigationController bottomNavigationController5 = this.k;
            if ((bottomNavigationController5 != null ? bottomNavigationController5.currentTab() : null) == null && (bottomNavigationController = this.k) != null) {
                bottomNavigationController.selectTab(NavigationTab.SEARCH.INSTANCE);
            }
        }
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    @Nullable
    public NavigationTab currentTab() {
        BottomNavigationController bottomNavigationController = this.k;
        NavigationTab navigationTab = null;
        NavigationTabSetItem currentTab = bottomNavigationController != null ? bottomNavigationController.currentTab() : null;
        if (currentTab instanceof NavigationTab) {
            navigationTab = currentTab;
        }
        return navigationTab;
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    public void finishFragment() {
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bottomNavigationController.finish();
        } else {
            super.onBackPressed();
        }
    }

    @NotNull
    public final Preferences getAbPreferences() {
        Preferences preferences = this.abPreferences;
        if (preferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abPreferences");
        }
        return preferences;
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        ManuallyExposedAbTestGroup<SimpleTestGroup> manuallyExposedAbTestGroup = this.draftsOnStartPublishSheet;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftsOnStartPublishSheet");
        }
        if (manuallyExposedAbTestGroup.getTestGroup().isTest()) {
            return R.layout.home_screen_with_bottom_navigation_and_separate_tab_add;
        }
        return R.layout.home_screen_with_bottom_navigation;
    }

    @NotNull
    public final ManuallyExposedAbTestGroup<SimpleTestGroup> getDraftsOnStartPublishSheet() {
        ManuallyExposedAbTestGroup<SimpleTestGroup> manuallyExposedAbTestGroup = this.draftsOnStartPublishSheet;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftsOnStartPublishSheet");
        }
        return manuallyExposedAbTestGroup;
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
    public final InAppUpdateTestGroup getInAppUpdateTestGroup() {
        InAppUpdateTestGroup inAppUpdateTestGroup2 = this.inAppUpdateTestGroup;
        if (inAppUpdateTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inAppUpdateTestGroup");
        }
        return inAppUpdateTestGroup2;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final TabFragmentFactory getTabFragmentFactory() {
        TabFragmentFactory tabFragmentFactory2 = this.tabFragmentFactory;
        if (tabFragmentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabFragmentFactory");
        }
        return tabFragmentFactory2;
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    @Nullable
    public Observable<NavigationTabSetItem> getTabObservable() {
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            return bottomNavigationController.getTabClickObservable();
        }
        return null;
    }

    @NotNull
    public final SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> getUserAdvertsTabTestGroup() {
        SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> singleManuallyExposedAbTestGroup = this.userAdvertsTabTestGroup;
        if (singleManuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsTabTestGroup");
        }
        return singleManuallyExposedAbTestGroup;
    }

    @NotNull
    public final UserProfileStatusDataProvider getUserProfileStatusDataProvider() {
        UserProfileStatusDataProvider userProfileStatusDataProvider2 = this.userProfileStatusDataProvider;
        if (userProfileStatusDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileStatusDataProvider");
        }
        return userProfileStatusDataProvider2;
    }

    @Override // com.avito.android.bottom_navigation.UpNavigationHandler
    public void handleUpNavigation() {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            return;
        }
        if (i2 == -1) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new InAppUpdateAcceptEvent());
        } else if (i2 == 0) {
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics3.track(new InAppUpdateCancelEvent());
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener
    public void onAddButtonStateChange(@NotNull NavigationTabSetItem navigationTabSetItem, @NotNull AddButtonState addButtonState) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        Intrinsics.checkNotNullParameter(addButtonState, "state");
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bottomNavigationController.setAddButtonStateByTab(navigationTabSetItem, addButtonState);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LastClick.Updater.update();
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bottomNavigationController.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r27) {
        /*
        // Method dump skipped, instructions count: 819
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.home.HomeActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.m.clear();
        KeyboardSubscription keyboardSubscription = this.l;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        this.l = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        a(intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Disposable disposable = this.n;
        if (disposable != null) {
            disposable.dispose();
        }
        this.n = null;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        AppUpdateManager create;
        Task<AppUpdateInfo> appUpdateInfo;
        super.onResume();
        UserProfileStatusDataProvider userProfileStatusDataProvider2 = this.userProfileStatusDataProvider;
        if (userProfileStatusDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileStatusDataProvider");
        }
        userProfileStatusDataProvider2.updateUnreadMessagesAndExpiredAdverts();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Observable<Long> interval = Observable.interval(0, 1, timeUnit, schedulersFactory3.computation());
        SchedulersFactory3 schedulersFactory32 = this.schedulers;
        if (schedulersFactory32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        this.n = interval.observeOn(schedulersFactory32.mainThread()).subscribe(new a2.a.a.a1.a(this), a2.a.a.a1.b.a);
        InAppUpdateTestGroup inAppUpdateTestGroup2 = this.inAppUpdateTestGroup;
        if (inAppUpdateTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inAppUpdateTestGroup");
        }
        if (inAppUpdateTestGroup2.isTest() && (create = AppUpdateManagerFactory.create(getApplicationContext())) != null && (appUpdateInfo = create.getAppUpdateInfo()) != null) {
            appUpdateInfo.addOnSuccessListener(new a(this, create));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bundle.putIntegerArrayList("tab_stack", new ArrayList(bottomNavigationController.saveTabStackOrdinals()));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (T t : bottomNavigationController.saveAddButtonStateOrdinals().entrySet()) {
                arrayList.add(t.getKey());
                arrayList2.add(t.getValue());
            }
            bundle.putIntegerArrayList("add_button_state_key", arrayList);
            bundle.putIntegerArrayList("add_button_state_value", arrayList2);
            bundle.putParcelable("navigation_fragment_result", bottomNavigationController.saveFragmentResult());
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (System.currentTimeMillis() - this.s > TimeUnit.HOURS.toMillis(24)) {
            InAppUpdateTestGroup inAppUpdateTestGroup2 = this.inAppUpdateTestGroup;
            if (inAppUpdateTestGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inAppUpdateTestGroup");
            }
            if (inAppUpdateTestGroup2.isTest()) {
                AppUpdateManager create = AppUpdateManagerFactory.create(getApplicationContext());
                Task<AppUpdateInfo> appUpdateInfo = create != null ? create.getAppUpdateInfo() : null;
                if (appUpdateInfo != null) {
                    appUpdateInfo.addOnSuccessListener(new b(this, create));
                }
                if (appUpdateInfo != null) {
                    appUpdateInfo.addOnFailureListener(c.a);
                }
            }
        }
        AppUpdateManager create2 = AppUpdateManagerFactory.create(getApplicationContext());
        if (create2 != null) {
            Object obj = this.r;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.android.play.core.install.InstallStateUpdatedListener");
            create2.registerListener((InstallStateUpdatedListener) obj);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AppUpdateManager create = AppUpdateManagerFactory.create(getApplicationContext());
        if (create != null) {
            Object obj = this.r;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.android.play.core.install.InstallStateUpdatedListener");
            create.unregisterListener((InstallStateUpdatedListener) obj);
        }
        super.onStop();
    }

    public final void popupSnackbarForCompleteUpdate() {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        String string = getString(R.string.in_app_update_title);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.in_app_update_title)");
        Views.showSnackBar$default(decorView, string, -2, getString(R.string.in_app_update_action), 0, new d(this), (Function0) null, 0, 104, (Object) null);
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    public void registerSelf(@NotNull ResultDispatcher resultDispatcher) {
        Intrinsics.checkNotNullParameter(resultDispatcher, "resultDispatcher");
        this.p.add(resultDispatcher);
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    public void registerStartForResult(@NotNull ResultFragmentData resultFragmentData) {
        Intrinsics.checkNotNullParameter(resultFragmentData, "data");
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bottomNavigationController.registerStartForResult(resultFragmentData);
        }
    }

    @Override // com.avito.android.bottom_navigation.NavigationProvider
    public void reportFragmentResult(@NotNull String str, @NotNull ResultReportData resultReportData) {
        Intrinsics.checkNotNullParameter(str, "fragmentId");
        Intrinsics.checkNotNullParameter(resultReportData, "resultReportData");
        BottomNavigationController bottomNavigationController = this.k;
        if (bottomNavigationController != null) {
            bottomNavigationController.reportResult(str, resultReportData);
        }
    }

    public final void setAbPreferences(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "<set-?>");
        this.abPreferences = preferences;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public void setContentView() {
        try {
            super.setContentView();
        } catch (Exception e) {
            SideloadDelegate sideloadDelegate = this.o;
            if (sideloadDelegate != null) {
                SideloadDelegate.catchException$default(sideloadDelegate, this, "setContentView", null, e, 4, null);
            }
            throw e;
        }
    }

    public final void setDraftsOnStartPublishSheet(@NotNull ManuallyExposedAbTestGroup<SimpleTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "<set-?>");
        this.draftsOnStartPublishSheet = manuallyExposedAbTestGroup;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setInAppUpdateTestGroup(@NotNull InAppUpdateTestGroup inAppUpdateTestGroup2) {
        Intrinsics.checkNotNullParameter(inAppUpdateTestGroup2, "<set-?>");
        this.inAppUpdateTestGroup = inAppUpdateTestGroup2;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setTabFragmentFactory(@NotNull TabFragmentFactory tabFragmentFactory2) {
        Intrinsics.checkNotNullParameter(tabFragmentFactory2, "<set-?>");
        this.tabFragmentFactory = tabFragmentFactory2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerHomeActivityComponent.builder().dependencies((HomeActivityDependencies) ComponentDependenciesKt.getDependencies(HomeActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        Preferences preferences = this.abPreferences;
        if (preferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abPreferences");
        }
        long j = preferences.getLong(AbTestPrefsKt.LAST_CONFIG_UPDATE_TIMESTAMP_IN_MILLIS, -1);
        Preferences preferences2 = this.abPreferences;
        if (preferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abPreferences");
        }
        this.s = preferences2.getLong("in_app_update_last_timestamp", 0);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new FakeAbConfigCheckEvent(j));
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }

    public final void setUserAdvertsTabTestGroup(@NotNull SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "<set-?>");
        this.userAdvertsTabTestGroup = singleManuallyExposedAbTestGroup;
    }

    public final void setUserProfileStatusDataProvider(@NotNull UserProfileStatusDataProvider userProfileStatusDataProvider2) {
        Intrinsics.checkNotNullParameter(userProfileStatusDataProvider2, "<set-?>");
        this.userProfileStatusDataProvider = userProfileStatusDataProvider2;
    }
}
