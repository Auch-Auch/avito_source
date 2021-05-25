package com.avito.android.search.filter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.PublishIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.filter.FilterCommons;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.filter.FiltersPresenter;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenter;
import com.avito.android.search.filter.di.DaggerFiltersComponent;
import com.avito.android.search.filter.di.FiltersComponent;
import com.avito.android.search.filter.di.FiltersDependencies;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactory;
import com.avito.android.search.filter.tracker.FiltersTracker;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectActivityKt;
import com.avito.android.select.SelectResult;
import com.avito.android.select.bottom_sheet.SelectBottomSheetActivityKt;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.suggest_locations.OpenEventFromBlock;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Æ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002Æ\u0001B\b¢\u0006\u0005\bÅ\u0001\u0010\u0018J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJG\u0010)\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0'0&H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00142\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00142\u0006\u0010,\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00142\u0006\u0010,\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b3\u0010\u001eJ#\u00105\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010!2\b\u0010%\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b5\u00106J!\u0010;\u001a\u00020\u00142\u0006\u00108\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b;\u0010<J#\u0010@\u001a\u00020\u00142\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b@\u0010AJ)\u0010F\u001a\u00020\u00142\u0006\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0014H\u0016¢\u0006\u0004\bH\u0010\u0018J\u0017\u0010K\u001a\u00020\u00142\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0014H\u0016¢\u0006\u0004\bM\u0010\u0018J\u000f\u0010N\u001a\u00020\u0014H\u0016¢\u0006\u0004\bN\u0010\u0018J\u0017\u0010P\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0014H\u0016¢\u0006\u0004\bT\u0010\u0018J\u000f\u0010U\u001a\u00020\u0014H\u0016¢\u0006\u0004\bU\u0010\u0018J\u0019\u0010W\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0014H\u0016¢\u0006\u0004\bY\u0010\u0018R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR#\u0010{\u001a\u00020z8\u0006@\u0006X.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R*\u0010¢\u0001\u001a\u00030¡\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b­\u0001\u0010®\u0001R*\u0010°\u0001\u001a\u00030¯\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R*\u0010½\u0001\u001a\u00030¶\u00018\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006Ç\u0001"}, d2 = {"Lcom/avito/android/search/filter/FiltersFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/search/filter/FiltersPresenter$Router;", "Lcom/avito/android/ui/ActivityInteractor;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "onPause", "Lcom/avito/android/select/Arguments;", "arguments", "showSelectScreen", "(Lcom/avito/android/select/Arguments;)V", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "metroWithLines", "", "requestId", "", "locationId", "categoryId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValues", "showSelectMetroScreen", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/List;)V", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "showSelectDialog", "(Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "showMultiselectDialog", "(Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "showGroupSelectDialog", "showSelectBottomSheet", "selectedLocationId", "showRegionSelectScreen", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/SearchParams;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/SearchRadius;", "searchRadius", "showSearchRadiusPickerScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SearchRadius;)V", "Ljava/util/Date;", "startDate", "endDate", "showSelectDatesCalendar", "(Ljava/util/Date;Ljava/util/Date;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "closeScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "closeScreenWithDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onBackPressed", "()Z", "findLocation", "onClickLocationSnackbar", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/search/filter/FiltersInteractor;", "interactor", "Lcom/avito/android/search/filter/FiltersInteractor;", "getInteractor", "()Lcom/avito/android/search/filter/FiltersInteractor;", "setInteractor", "(Lcom/avito/android/search/filter/FiltersInteractor;)V", "Lcom/avito/android/search/filter/MultiselectDialogFactory;", "multiselectDialogFactory", "Lcom/avito/android/search/filter/MultiselectDialogFactory;", "getMultiselectDialogFactory", "()Lcom/avito/android/search/filter/MultiselectDialogFactory;", "setMultiselectDialogFactory", "(Lcom/avito/android/search/filter/MultiselectDialogFactory;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/search/filter/FiltersView;", "j", "Lcom/avito/android/search/filter/FiltersView;", "filtersView", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "groupSelectDialogFactory", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "getGroupSelectDialogFactory", "()Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "setGroupSelectDialogFactory", "(Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;)V", "Lcom/avito/android/search/filter/SelectDialogFactory;", "selectDialogFactory", "Lcom/avito/android/search/filter/SelectDialogFactory;", "getSelectDialogFactory", "()Lcom/avito/android/search/filter/SelectDialogFactory;", "setSelectDialogFactory", "(Lcom/avito/android/search/filter/SelectDialogFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "bubblesSelectItemPresenter", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "getBubblesSelectItemPresenter", "()Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "setBubblesSelectItemPresenter", "(Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;)V", "Lcom/avito/android/search/filter/tracker/FiltersTracker;", "tracker", "Lcom/avito/android/search/filter/tracker/FiltersTracker;", "getTracker", "()Lcom/avito/android/search/filter/tracker/FiltersTracker;", "setTracker", "(Lcom/avito/android/search/filter/tracker/FiltersTracker;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "l", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/search/filter/FiltersPresenter;", "presenter", "Lcom/avito/android/search/filter/FiltersPresenter;", "getPresenter", "()Lcom/avito/android/search/filter/FiltersPresenter;", "setPresenter", "(Lcom/avito/android/search/filter/FiltersPresenter;)V", "<init>", "Companion", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersFragment extends TabBaseFragment implements FiltersPresenter.Router, ActivityInteractor, OnBackPressedListener, LocationPermissionDialogPresenter.Router, LocationPermissionDialogPresenter.Subscriber {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    @Inject
    public BubblesSelectItemPresenter bubblesSelectItemPresenter;
    @Inject
    public Features features;
    @Inject
    public GroupSelectDialogFactory groupSelectDialogFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public FiltersInteractor interactor;
    public FiltersView j;
    public final Handler k = new Handler();
    @NotNull
    public NavigationState l = new NavigationState(false);
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public MultiselectDialogFactory multiselectDialogFactory;
    @Inject
    public FiltersPresenter presenter;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public SelectDialogFactory selectDialogFactory;
    @Inject
    public FiltersTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/search/filter/FiltersFragment$Companion;", "", "Lcom/avito/android/search/filter/FiltersArguments;", "arguments", "Lcom/avito/android/search/filter/FiltersFragment;", "newInstance", "(Lcom/avito/android/search/filter/FiltersArguments;)Lcom/avito/android/search/filter/FiltersFragment;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ FiltersArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(FiltersArguments filtersArguments) {
                super(1);
                this.a = filtersArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("filters_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final FiltersFragment newInstance(@NotNull FiltersArguments filtersArguments) {
            Intrinsics.checkNotNullParameter(filtersArguments, "arguments");
            return (FiltersFragment) FragmentsKt.arguments$default(new FiltersFragment(), 0, new a(filtersArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 0) {
                ((FiltersFragment) this.c).getPresenter().onSelected(((SelectResult) this.b).getRequestId(), ((SelectResult) this.b).getSelectedItems(), ((SelectResult) this.b).getSectionTitle());
            } else if (i == 1) {
                ((FiltersFragment) this.b).getPresenter().onLocationChanged((Location) this.c);
            } else if (i == 2) {
                ((FiltersFragment) this.b).getPresenter().onSearchRadiusChanged((SearchRadius) this.c);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FiltersFragment a;
        public final /* synthetic */ Date b;
        public final /* synthetic */ Date c;

        public b(FiltersFragment filtersFragment, Date date, Date date2) {
            this.a = filtersFragment;
            this.b = date;
            this.c = date2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getPresenter().onDatesSelected(this.b, this.c);
        }
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void closeScreen() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getFiltersWithoutActivity().invoke().booleanValue() || (getActivity() instanceof FiltersActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(0);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        TabBaseFragment.setResult$default(this, 0, null, 2, null);
        finish();
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void closeScreenWithDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getFiltersWithoutActivity().invoke().booleanValue() || (getActivity() instanceof FiltersActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, new FilterCommons().createResultIntent(deepLink));
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        setResult(-1, new FilterCommons().createResultIntent(deepLink));
        finish();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        filtersInteractor.findCoordinates(requireActivity);
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
    public final BubblesSelectItemPresenter getBubblesSelectItemPresenter() {
        BubblesSelectItemPresenter bubblesSelectItemPresenter2 = this.bubblesSelectItemPresenter;
        if (bubblesSelectItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubblesSelectItemPresenter");
        }
        return bubblesSelectItemPresenter2;
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
    public final GroupSelectDialogFactory getGroupSelectDialogFactory() {
        GroupSelectDialogFactory groupSelectDialogFactory2 = this.groupSelectDialogFactory;
        if (groupSelectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupSelectDialogFactory");
        }
        return groupSelectDialogFactory2;
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
    public final FiltersInteractor getInteractor() {
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return filtersInteractor;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionDialogPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final MultiselectDialogFactory getMultiselectDialogFactory() {
        MultiselectDialogFactory multiselectDialogFactory2 = this.multiselectDialogFactory;
        if (multiselectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiselectDialogFactory");
        }
        return multiselectDialogFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.l;
    }

    @NotNull
    public final FiltersPresenter getPresenter() {
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return filtersPresenter;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final SelectDialogFactory getSelectDialogFactory() {
        SelectDialogFactory selectDialogFactory2 = this.selectDialogFactory;
        if (selectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectDialogFactory");
        }
        return selectDialogFactory2;
    }

    @NotNull
    public final FiltersTracker getTracker() {
        FiltersTracker filtersTracker = this.tracker;
        if (filtersTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return filtersTracker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Object obj = null;
            if (i == 1) {
                if (intent != null) {
                    obj = (Location) intent.getParcelableExtra("location");
                }
                this.k.post(new a(1, this, obj));
            } else if (i == 2) {
                if (intent != null) {
                    obj = (SelectResult) intent.getParcelableExtra(SelectActivityKt.EXTRA_SELECT_RESULT);
                }
                if (obj != null) {
                    this.k.post(new a(0, obj, this));
                }
            } else if (i == 4) {
                if (intent != null) {
                    obj = (SearchRadius) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_RADIUS_RESULT);
                }
                this.k.post(new a(2, this, obj));
            } else if (i == 5 && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE);
                if (serializableExtra != null) {
                    Date date = (Date) serializableExtra;
                    Serializable serializableExtra2 = intent.getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE);
                    if (serializableExtra2 != null) {
                        this.k.post(new b(this, date, (Date) serializableExtra2));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        filtersPresenter.onBackPressed();
        return false;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onClickLocationSnackbar() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FiltersTracker filtersTracker = this.tracker;
        if (filtersTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        filtersTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.filters, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ilters, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FiltersView filtersView = this.j;
        if (filtersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filtersView");
        }
        filtersView.dispose();
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        filtersPresenter.detachView();
        this.k.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onLocationNotFound(@Nullable String str) {
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        filtersInteractor.onLocationNotFound(str);
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onNotPermissionGranted() {
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        FiltersView filtersView = this.j;
        if (filtersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filtersView");
        }
        filtersInteractor.subscribeOnNotPermissionGranted(filtersView.getRootView());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        filtersInteractor.sendScreenExitAfterCoordinatesResolve();
        FiltersInteractor filtersInteractor2 = this.interactor;
        if (filtersInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        filtersInteractor2.unregisterLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        filtersInteractor.registerLocationReceiver(requireContext);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", filtersPresenter.onSaveState());
        FiltersInteractor filtersInteractor = this.interactor;
        if (filtersInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Bundles.putKundle(bundle, "interactor_state", filtersInteractor.onSaveState());
        BubblesSelectItemPresenter bubblesSelectItemPresenter2 = this.bubblesSelectItemPresenter;
        if (bubblesSelectItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubblesSelectItemPresenter");
        }
        Bundles.putKundle(bundle, "bubbles_select_presenter_state", bubblesSelectItemPresenter2.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.attachRouter(this);
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.setSubscriber(this);
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        filtersPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.detachRouter();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.detachSubscriber();
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        filtersPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.j = new FiltersViewImpl(view, simpleRecyclerAdapter, analytics2);
        FiltersPresenter filtersPresenter = this.presenter;
        if (filtersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FiltersView filtersView = this.j;
        if (filtersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filtersView");
        }
        filtersPresenter.attachView(filtersView);
        FiltersTracker filtersTracker = this.tracker;
        if (filtersTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        filtersTracker.trackInit();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBubblesSelectItemPresenter(@NotNull BubblesSelectItemPresenter bubblesSelectItemPresenter2) {
        Intrinsics.checkNotNullParameter(bubblesSelectItemPresenter2, "<set-?>");
        this.bubblesSelectItemPresenter = bubblesSelectItemPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGroupSelectDialogFactory(@NotNull GroupSelectDialogFactory groupSelectDialogFactory2) {
        Intrinsics.checkNotNullParameter(groupSelectDialogFactory2, "<set-?>");
        this.groupSelectDialogFactory = groupSelectDialogFactory2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull FiltersInteractor filtersInteractor) {
        Intrinsics.checkNotNullParameter(filtersInteractor, "<set-?>");
        this.interactor = filtersInteractor;
    }

    public final void setLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
        this.locationPermissionDialogPresenter = locationPermissionDialogPresenter2;
    }

    public final void setMultiselectDialogFactory(@NotNull MultiselectDialogFactory multiselectDialogFactory2) {
        Intrinsics.checkNotNullParameter(multiselectDialogFactory2, "<set-?>");
        this.multiselectDialogFactory = multiselectDialogFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.l = navigationState;
    }

    public final void setPresenter(@NotNull FiltersPresenter filtersPresenter) {
        Intrinsics.checkNotNullParameter(filtersPresenter, "<set-?>");
        this.presenter = filtersPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setSelectDialogFactory(@NotNull SelectDialogFactory selectDialogFactory2) {
        Intrinsics.checkNotNullParameter(selectDialogFactory2, "<set-?>");
        this.selectDialogFactory = selectDialogFactory2;
    }

    public final void setTracker(@NotNull FiltersTracker filtersTracker) {
        Intrinsics.checkNotNullParameter(filtersTracker, "<set-?>");
        this.tracker = filtersTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        FiltersArguments filtersArguments;
        Bundle arguments = getArguments();
        if (arguments == null || (filtersArguments = (FiltersArguments) arguments.getParcelable("filters_arguments")) == null) {
            throw new IllegalArgumentException("FilterArguments must be specified");
        }
        SearchParams searchParams = filtersArguments.getSearchParams();
        FilterAnalyticsData analyticsData = filtersArguments.getAnalyticsData();
        Area searchArea = filtersArguments.getSearchArea();
        String mapSerpState = filtersArguments.getMapSerpState();
        boolean isOnlySortShown = filtersArguments.isOnlySortShown();
        boolean showSimpleMap = filtersArguments.getShowSimpleMap();
        Kundle kundle = null;
        Kundle kundle2 = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        Kundle kundle3 = bundle != null ? Bundles.getKundle(bundle, "interactor_state") : null;
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "bubbles_select_presenter_state");
        }
        boolean z = bundle == null;
        Timer B1 = a2.b.a.a.a.B1();
        FiltersComponent.Builder withIsFirstStart = DaggerFiltersComponent.builder().dependentOn((FiltersDependencies) ComponentDependenciesKt.getDependencies(FiltersDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withPresenterState(kundle2).withIsOnlySortShown(isOnlySortShown).withIsFirstStart(z);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        FiltersComponent.Builder withResources = withIsFirstStart.withResources(resources);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        withResources.withActivity(requireActivity).withFragment(this).withActivityInteractor(this).withSearchParams(searchParams).withFilterAnalyticsData(analyticsData).withSearchArea(searchArea).withShowSimpleMap(showSimpleMap).withMapSerpState(mapSerpState).withInteractorState(kundle3).withBubblePresenterState(kundle).build().inject(this);
        FiltersTracker filtersTracker = this.tracker;
        if (filtersTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        filtersTracker.trackDiInject(B1.elapsed());
        return true;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showGroupSelectDialog(@NotNull ParameterElement.Multiselect multiselect) {
        Intrinsics.checkNotNullParameter(multiselect, "item");
        GroupSelectDialogFactory groupSelectDialogFactory2 = this.groupSelectDialogFactory;
        if (groupSelectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupSelectDialogFactory");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        groupSelectDialogFactory2.showDialog(requireContext, multiselect);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showMultiselectDialog(@NotNull ParameterElement.Multiselect multiselect) {
        Intrinsics.checkNotNullParameter(multiselect, "item");
        MultiselectDialogFactory multiselectDialogFactory2 = this.multiselectDialogFactory;
        if (multiselectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiselectDialogFactory");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        multiselectDialogFactory2.showDialog(requireContext, multiselect);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showRegionSelectScreen(@Nullable String str, @Nullable String str2) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent suggestLocationsIntent$default = SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(activityIntentFactory, str, str2, Integer.valueOf(OpenEventFromBlock.FILTERS.getValue()), null, null, currentTab(), false, null, null, false, false, 1856, null);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getLocationSelectWithoutActivity().invoke().booleanValue() || currentTab() == null) {
            startActivityForResult(suggestLocationsIntent$default, 1);
        } else {
            startForResult(suggestLocationsIntent$default, 1);
        }
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSearchRadiusPickerScreen(@NotNull SearchParams searchParams, @Nullable SearchRadius searchRadius) {
        Intrinsics.checkNotNullParameter(searchParams, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(activityIntentFactory, null, null, searchRadius, null, null, searchParams, null, null, 219, null), 4);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSelectBottomSheet(@NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        startActivityForResult(SelectBottomSheetActivityKt.createBottomSheetSelectIntent(requireContext, arguments), 2);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSelectDatesCalendar(@Nullable Date date, @Nullable Date date2) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.calendarSelectDatesIntent(date, date2), 5);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSelectDialog(@NotNull ParameterElement.Select select) {
        Intrinsics.checkNotNullParameter(select, "item");
        SelectDialogFactory selectDialogFactory2 = this.selectDialogFactory;
        if (selectDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectDialogFactory");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        selectDialogFactory2.showDialog(requireContext, select);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSelectMetroScreen(@Nullable MetroResponseBody metroResponseBody, @NotNull String str, int i, @Nullable Integer num, @NotNull List<? extends ParcelableEntity<String>> list) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedValues");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent selectMetroIntent = activityIntentFactory.selectMetroIntent(metroResponseBody, str, i, num, list, currentTab());
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getSelectMetroWithoutActivity().invoke().booleanValue() && currentTab() != null) {
            Features features3 = this.features;
            if (features3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features3.getFiltersWithoutActivity().invoke().booleanValue() && !(getActivity() instanceof FiltersActivity)) {
                startForResult(selectMetroIntent, 2);
                return;
            }
        }
        startActivityForResult(selectMetroIntent, 2);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter.Router
    public void showSelectScreen(@NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        startActivityForResult(SelectActivityKt.createSelectActivityIntent(requireContext, arguments), 2);
    }
}
