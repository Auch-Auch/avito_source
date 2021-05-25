package com.avito.android.publish;

import a2.a.a.e2.k;
import a2.a.a.e2.l;
import a2.a.a.e2.m;
import a2.g.r.g;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.publish.PublishSession;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.RoutingAction;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractor;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryModel;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotWithParameters;
import com.avito.android.util.Collections;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.q;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u0011\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002Ï\u0001B&\u0012\u0006\u0010d\u001a\u00020a\u0012\t\b\u0002\u0010º\u0001\u001a\u00020\u001b\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\f*\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\u0004\b\u0017\u0010\u0015J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013¢\u0006\u0004\b\u0019\u0010\u0015J\u001d\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020!2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020\u0005¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0016¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0016¢\u0006\u0004\b4\u00103J\u0019\u00105\u001a\u00020\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0016¢\u0006\u0004\b7\u00103J!\u0010<\u001a\u00020\u001b2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:08¢\u0006\u0004\b<\u0010=J\u0017\u0010'\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b'\u0010@J\r\u0010A\u001a\u00020>¢\u0006\u0004\bA\u0010BJ\u0019\u0010E\u001a\u00020\u00162\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\u00162\u0006\u0010G\u001a\u000209¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00162\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0015\u0010O\u001a\u00020\u00162\u0006\u0010N\u001a\u00020J¢\u0006\u0004\bO\u0010MJ\u000f\u0010P\u001a\u00020\u0016H\u0014¢\u0006\u0004\bP\u00103J#\u0010T\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010R0R0Q2\u0006\u0010.\u001a\u00020\u0005¢\u0006\u0004\bT\u0010UR\u0016\u0010\u001a\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00160X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001f\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0X8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010Z\u001a\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010ZR#\u0010l\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030g0f8\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kRJ\u0010p\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 S*\b\u0012\u0002\b\u0003\u0018\u00010g0g S*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 S*\b\u0012\u0002\b\u0003\u0018\u00010g0g\u0018\u00010m0m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR*\u0010&\u001a\u00020%2\u0006\u0010q\u001a\u00020%8\u0006@BX\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0013\u0010x\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\bx\u0010 R%\u0010\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R-\u0010\"\u001a\u0004\u0018\u00010!2\t\u0010\u0001\u001a\u0004\u0018\u00010!8\u0006@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0005\b\u0001\u0010IR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010 R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010\u0001R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0X8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010ZR\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00038B@\u0002X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R(\u0010\u001c\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u001b8\u0006@BX\u000e¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010 R\u0015\u0010\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010 R(\u0010.\u001a\u00020\u00052\u0006\u0010q\u001a\u00020\u00058F@BX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u0004\u0018\u0001098F@\u0006¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u0001R)\u0010¥\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u001b8F@BX\u000e¢\u0006\u000f\n\u0006\b£\u0001\u0010\u0001\u001a\u0005\b¤\u0001\u0010 R\u0015\u0010§\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010 R\"\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010¨\u00018B@\u0002X\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R1\u0010°\u0001\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u001e\n\u0006\b¬\u0001\u0010\u0001\u0012\u0005\b¯\u0001\u00103\u001a\u0006\b­\u0001\u0010\u0001\"\u0005\b®\u0001\u0010IR#\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050m8\u0006@\u0006¢\u0006\u000f\n\u0005\b±\u0001\u0010o\u001a\u0006\b²\u0001\u0010³\u0001R(\u0010¶\u0001\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\bµ\u0001\u0010\u0001\u001a\u0005\b¶\u0001\u0010 \"\u0006\b·\u0001\u0010¸\u0001R\u0019\u0010º\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010\u0001R\u0018\u0010»\u0001\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010\u0001R5\u0010Â\u0001\u001a\u0004\u0018\u00010\u00182\b\u0010q\u001a\u0004\u0018\u00010\u00188\u0006@FX\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0001R*\u0010Ç\u0001\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\bÄ\u0001\u0010\u0001\u001a\u0006\bÅ\u0001\u0010\u0001\"\u0005\bÆ\u0001\u0010IR\u001f\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020/0È\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\r\u0010É\u0001R\u0018\u0010Ì\u0001\u001a\u0004\u0018\u0001098F@\u0006¢\u0006\b\u001a\u0006\bË\u0001\u0010\u0001¨\u0006Ð\u0001"}, d2 = {"Lcom/avito/android/publish/PublishViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish/NavigationProvider;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", AnalyticFieldsName.step, "", "d", "(Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;)I", "Lcom/avito/android/publish/PublishViewModel$a;", "behavior", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "Lcom/avito/android/publish/RoutingAction;", g.a, "(Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;Lcom/avito/android/publish/PublishViewModel$a;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Lcom/avito/android/publish/RoutingAction;", "Lcom/avito/android/publish/PublishState$StepState$CategorySelector;", "Lcom/avito/android/remote/model/Navigation;", "f", "(Lcom/avito/android/publish/PublishState$StepState$CategorySelector;Lcom/avito/android/publish/PublishViewModel$a;)Lcom/avito/android/remote/model/Navigation;", "Landroidx/lifecycle/LiveData;", "routingActions", "()Landroidx/lifecycle/LiveData;", "", "stateInitialization", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "contactDataLoaded", "navigation", "", "shouldRestoreDraft", "init", "(Lcom/avito/android/remote/model/Navigation;Z)V", "isEditing", "()Z", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "setCategoryParametersAndInitSteps", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "Lcom/avito/android/publish/PublishState;", "state", "restoreState", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/publish/PublishState;)V", "setCurrentStepIndex", "(Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;)V", FirebaseAnalytics.Param.INDEX, "getStep", "(Ljava/lang/Integer;)Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "stepIndex", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParamsForStep", "(I)Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "startDynamicPublishingFlow", "()V", "resumePublishingFlow", "goToNextStep", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "goToPreviousStep", "", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "errors", "handleServerValidationErrors", "(Ljava/util/Map;)Z", "Lcom/avito/android/util/Kundle;", "savedState", "(Lcom/avito/android/util/Kundle;)V", "saveState", "()Lcom/avito/android/util/Kundle;", "", "error", "onUnexpectedErrorOccurred", "(Ljava/lang/Throwable;)V", "message", "handleErrorOrFail", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/CategoryModel;", "category", "updateStateWithCategory", "(Lcom/avito/android/remote/model/CategoryModel;)V", "newCategory", "resetStateWithChangedCategory", "onCleared", "Lio/reactivex/Maybe;", "Lru/avito/component/toolbar/OnboardingData;", "kotlin.jvm.PlatformType", "shouldShowDraftOnboardingForStep", "(I)Lio/reactivex/Maybe;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "h", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "stateInitialized", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "u", "getDialogs", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "dialogs", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "y", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "draftOnboardingInteractor", "j", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "w", "Lio/reactivex/Observable;", "getParametersValueChanges", "()Lio/reactivex/Observable;", "parametersValueChanges", "Lcom/jakewharton/rxrelay2/PublishRelay;", "k", "Lcom/jakewharton/rxrelay2/PublishRelay;", "parametersValueChangesRelay", "value", "l", "Lcom/avito/android/publish/PublishState;", "getState", "()Lcom/avito/android/publish/PublishState;", "setState", "(Lcom/avito/android/publish/PublishState;)V", "isPrevalidationRequired", "Lcom/avito/android/remote/model/ItemBrief;", "p", "Lcom/avito/android/remote/model/ItemBrief;", "getItem", "()Lcom/avito/android/remote/model/ItemBrief;", "setItem", "(Lcom/avito/android/remote/model/ItemBrief;)V", "item", "<set-?>", "r", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "o", "Ljava/lang/String;", "getDraftId", "()Ljava/lang/String;", "setDraftId", "draftId", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "isRemoteDraft", "parameterObserverDisposables", "i", "()Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "currentPublishStep", "Lcom/avito/android/publish/analytics/PublishEventTracker;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/publish/analytics/PublishEventTracker;", "tracker", "n", "Z", "getShouldRestoreDraft", "isItemPublished", "getStepIndex", "()I", "setStepIndex", "(I)V", "getStepId", "stepId", "x", "getScrollToNotificationOnValidationError", "scrollToNotificationOnValidationError", "getShouldSaveDraft", "shouldSaveDraft", "", "e", "()Ljava/util/List;", "steps", VKApiConst.Q, "getPostAction", "setPostAction", "getPostAction$annotations", "postAction", VKApiConst.VERSION, "getStepIndexChanges", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "stepIndexChanges", "t", "isCategoryChanged", "setCategoryChanged", "(Z)V", "z", "isDebug", "canHandleIndexUpdate", "s", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "getContactsData", "()Lcom/avito/android/publish/slots/contact_info/ContactsData;", "setContactsData", "(Lcom/avito/android/publish/slots/contact_info/ContactsData;)V", "contactsData", "isPrevalidationDone", AuthSource.OPEN_CHANNEL_LIST, "getAdvertId", "setAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "", "[Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "paramsByStepsIndex", "getAnalyticsScreenId", "analyticsScreenId", "<init>", "(Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;ZLcom/avito/android/publish/analytics/PublishEventTracker;)V", AuthSource.SEND_ABUSE, "publish_release"}, k = 1, mv = {1, 4, 2})
public class PublishViewModel extends ViewModel implements NavigationProvider {
    public final PublishEventTracker A;
    public final CompositeDisposable c;
    public final CompositeDisposable d;
    public boolean e;
    public boolean f;
    public ParametersTree[] g;
    public final SingleLiveEvent<Unit> h;
    public final SingleLiveEvent<RoutingAction> i;
    public final SingleLiveEvent<ContactsData> j;
    public final PublishRelay<EditableParameter<?>> k;
    @NotNull
    public PublishState l;
    @Nullable
    public String m;
    public boolean n;
    @Nullable
    public String o;
    @Nullable
    public ItemBrief p;
    @Nullable
    public String q;
    @Nullable
    public CategoryParameters r;
    @Nullable
    public ContactsData s;
    public boolean t;
    @NotNull
    public final SingleLiveEvent<DeepLinksDialogInfo> u;
    @NotNull
    public final PublishRelay<Integer> v;
    @NotNull
    public final Observable<EditableParameter<?>> w;
    public boolean x;
    public final DraftOnboardingInteractor y;
    public final boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PublishSession.StepType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            PublishSession.StepType stepType = PublishSession.StepType.PARAMS;
            iArr[0] = 1;
            PublishSession.StepType stepType2 = PublishSession.StepType.SELECT;
            iArr[1] = 2;
            PublishSession.StepType stepType3 = PublishSession.StepType.WIZARD;
            iArr[2] = 3;
            PublishSession.StepType stepType4 = PublishSession.StepType.SUGGEST_CATEGORY;
            iArr[6] = 4;
            PublishSession.StepType stepType5 = PublishSession.StepType.VIN;
            iArr[3] = 5;
            PublishSession.StepType stepType6 = PublishSession.StepType.PREMODERATION;
            iArr[4] = 6;
            PublishSession.StepType stepType7 = PublishSession.StepType.CONTACTS;
            iArr[5] = 7;
            PublishSession.StepType stepType8 = PublishSession.StepType.REQUEST_PRETEND;
            iArr[7] = 8;
            PublishSession.StepType stepType9 = PublishSession.StepType.REQUEST_STEPS;
            iArr[8] = 9;
            PublishSession.StepType stepType10 = PublishSession.StepType.REQUEST_PUBLISH;
            iArr[9] = 10;
            PublishSession.StepType stepType11 = PublishSession.StepType.REQUEST_EDIT;
            iArr[10] = 11;
        }
    }

    public enum a {
        FORWARD,
        BACKSTACK
    }

    public static final class b<V> implements Callable<MaybeSource<? extends Unit>> {
        public final /* synthetic */ PublishViewModel a;
        public final /* synthetic */ int b;

        public b(PublishViewModel publishViewModel, int i) {
            this.a = publishViewModel;
            this.b = i;
        }

        @Override // java.util.concurrent.Callable
        public MaybeSource<? extends Unit> call() {
            return PublishViewModelKt.access$toMaybe(!this.a.isEditing() && this.b == this.a.getState().getStepIndex());
        }
    }

    public static final class c<T, R> implements Function<Unit, MaybeSource<? extends OnboardingData>> {
        public final /* synthetic */ PublishViewModel a;

        public c(PublishViewModel publishViewModel) {
            this.a = publishViewModel;
        }

        @Override // io.reactivex.functions.Function
        public MaybeSource<? extends OnboardingData> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.y.shouldShowDraftOnboarding();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishViewModel(DraftOnboardingInteractor draftOnboardingInteractor, boolean z2, PublishEventTracker publishEventTracker, int i2, j jVar) {
        this(draftOnboardingInteractor, (i2 & 2) != 0 ? false : z2, publishEventTracker);
    }

    public static final String access$getParameterId(PublishViewModel publishViewModel, EditableParameter editableParameter) {
        ParameterSlot findParameterHolder;
        String id;
        CategoryParameters categoryParameters = publishViewModel.r;
        return (categoryParameters == null || (findParameterHolder = categoryParameters.findParameterHolder(editableParameter.getId())) == null || (id = findParameterHolder.getId()) == null) ? editableParameter.getId() : id;
    }

    public static final void access$setState$p(PublishViewModel publishViewModel, PublishState publishState) {
        publishViewModel.l = publishState;
        publishViewModel.h.postValue(Unit.INSTANCE);
    }

    public static /* synthetic */ void getPostAction$annotations() {
    }

    public static /* synthetic */ void goToNextStep$default(PublishViewModel publishViewModel, ScreenTransfer screenTransfer, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                screenTransfer = null;
            }
            publishViewModel.goToNextStep(screenTransfer);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextStep");
    }

    public static /* synthetic */ void onUnexpectedErrorOccurred$default(PublishViewModel publishViewModel, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                th = null;
            }
            publishViewModel.onUnexpectedErrorOccurred(th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUnexpectedErrorOccurred");
    }

    public final CategoryPublishStep c() {
        return getStep(Integer.valueOf(getStepIndex()));
    }

    @NotNull
    public final LiveData<ContactsData> contactDataLoaded() {
        return this.j;
    }

    public final int d(CategoryPublishStep categoryPublishStep) {
        if (categoryPublishStep != null) {
            List<CategoryPublishStep> e2 = e();
            Integer valueOf = e2 != null ? Integer.valueOf(e2.indexOf(categoryPublishStep)) : null;
            if (valueOf != null) {
                return valueOf.intValue();
            }
        }
        return -1;
    }

    public final List<CategoryPublishStep> e() {
        CategoryParameters categoryParameters = this.r;
        if (categoryParameters != null) {
            return categoryParameters.getSteps();
        }
        return null;
    }

    public final Navigation f(PublishState.StepState.CategorySelector categorySelector, a aVar) {
        Navigation navigation;
        if (aVar == a.BACKSTACK) {
            navigation = this.l.getRootNavigation();
        } else {
            navigation = getNavigation();
        }
        Navigation previousNavigation = categorySelector.getPreviousNavigation();
        if (previousNavigation != null) {
            navigation = previousNavigation;
        }
        categorySelector.setPreviousNavigation(navigation);
        return navigation;
    }

    public final RoutingAction g(CategoryPublishStep categoryPublishStep, a aVar, ScreenTransfer screenTransfer) {
        PublishState.StepState stepState;
        PublishState.StepState stepState2;
        List<Navigation> list = null;
        switch (PublishViewModelKt.a(categoryPublishStep).ordinal()) {
            case 0:
                return new RoutingAction.ToDetailsParams(screenTransfer);
            case 1:
                return RoutingAction.ToSelect.INSTANCE;
            case 2:
                Objects.requireNonNull(categoryPublishStep, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.CategoryPublishStep.Wizard");
                CategoryPublishStep.Wizard wizard = (CategoryPublishStep.Wizard) categoryPublishStep;
                PublishState publishState = this.l;
                int d2 = d(categoryPublishStep);
                Parcelable parcelable = (PublishState.StepState) publishState.getStepStates().get(Integer.valueOf(d2));
                if (!(parcelable instanceof PublishState.StepState.Wizard)) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                        stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                        stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                        stepState = new PublishState.StepState.Vin(null, 1, null);
                    } else {
                        StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                        L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class));
                        L.append('\'');
                        throw new IllegalArgumentException(L.toString());
                    }
                    publishState.getStepStates().put(Integer.valueOf(d2), stepState);
                    parcelable = (PublishState.StepState.Wizard) stepState;
                }
                Navigation f2 = f((PublishState.StepState.CategorySelector) parcelable, aVar);
                CategoryPublishStep.Wizard.Config config = wizard.getConfig();
                if (config != null) {
                    list = config.getLeaves();
                }
                return new RoutingAction.ToWizard(f2, list);
            case 3:
                return RoutingAction.ToInputVin.INSTANCE;
            case 4:
                return RoutingAction.Premoderation.INSTANCE;
            case 5:
                return new RoutingAction.ToDetailsParams(screenTransfer);
            case 6:
                Objects.requireNonNull(categoryPublishStep, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.CategoryPublishStep.SuggestCategory");
                CategoryPublishStep.SuggestCategory suggestCategory = (CategoryPublishStep.SuggestCategory) categoryPublishStep;
                PublishState publishState2 = this.l;
                int d3 = d(categoryPublishStep);
                Parcelable parcelable2 = (PublishState.StepState) publishState2.getStepStates().get(Integer.valueOf(d3));
                if (!(parcelable2 instanceof PublishState.StepState.CategoriesSuggestions)) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                        stepState2 = new PublishState.StepState.Wizard(null, null, null, 7, null);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                        stepState2 = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                        stepState2 = new PublishState.StepState.Vin(null, 1, null);
                    } else {
                        StringBuilder L2 = a2.b.a.a.a.L("Unknown StepState type '");
                        L2.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class));
                        L2.append('\'');
                        throw new IllegalArgumentException(L2.toString());
                    }
                    publishState2.getStepStates().put(Integer.valueOf(d3), stepState2);
                    parcelable2 = (PublishState.StepState.CategoriesSuggestions) stepState2;
                }
                f((PublishState.StepState.CategorySelector) parcelable2, aVar);
                return RoutingAction.ToCategoriesSuggestions.INSTANCE;
            case 7:
                return RoutingAction.Pretend.INSTANCE;
            case 8:
                return new RoutingAction.InfomodelRequest(false);
            case 9:
                return RoutingAction.Publish.INSTANCE;
            case 10:
                return RoutingAction.Edit.INSTANCE;
            default:
                StringBuilder L3 = a2.b.a.a.a.L("Unknown combination of type '");
                L3.append(categoryPublishStep.getType());
                L3.append("' and subtype '");
                L3.append(categoryPublishStep.getSubtype());
                L3.append('\'');
                throw new IllegalArgumentException(L3.toString());
        }
    }

    @Nullable
    public final String getAdvertId() {
        return this.m;
    }

    @Nullable
    public final String getAnalyticsScreenId() {
        CategoryPublishStep c2 = c();
        if (c2 != null) {
            return c2.toString();
        }
        return null;
    }

    @Nullable
    public final CategoryParameters getCategoryParameters() {
        return this.r;
    }

    @Nullable
    public final ContactsData getContactsData() {
        return this.s;
    }

    @NotNull
    public final SingleLiveEvent<DeepLinksDialogInfo> getDialogs() {
        return this.u;
    }

    @Nullable
    public final String getDraftId() {
        return this.o;
    }

    @Nullable
    public final ItemBrief getItem() {
        return this.p;
    }

    @Override // com.avito.android.publish.NavigationProvider
    @NotNull
    public Navigation getNavigation() {
        return this.l.getNavigation();
    }

    @NotNull
    public final Observable<EditableParameter<?>> getParametersValueChanges() {
        return this.w;
    }

    @NotNull
    public final ParametersTree getParamsForStep(int i2) {
        ParametersTree[] parametersTreeArr = this.g;
        return (i2 < 0 || i2 > ArraysKt___ArraysKt.getLastIndex(parametersTreeArr)) ? new SimpleParametersTree(CollectionsKt__CollectionsKt.emptyList(), null, 2, null) : parametersTreeArr[i2];
    }

    @Nullable
    public final String getPostAction() {
        return this.q;
    }

    public final boolean getScrollToNotificationOnValidationError() {
        boolean z2 = this.x;
        this.x = false;
        return z2;
    }

    public final boolean getShouldRestoreDraft() {
        return this.n;
    }

    public final boolean getShouldSaveDraft() {
        CategoryParameters categoryParameters = this.r;
        if (categoryParameters != null) {
            return categoryParameters.getShouldSaveDraft();
        }
        return false;
    }

    @NotNull
    public final PublishState getState() {
        return this.l;
    }

    @Nullable
    public final CategoryPublishStep getStep(@Nullable Integer num) {
        if (e() == null || num == null || num.intValue() == -1) {
            return null;
        }
        List<CategoryPublishStep> e2 = e();
        Intrinsics.checkNotNull(e2);
        return e2.get(num.intValue());
    }

    @Nullable
    public final String getStepId() {
        CategoryPublishStep step = getStep(Integer.valueOf(getStepIndex()));
        if (step != null) {
            return step.getId();
        }
        return null;
    }

    public final int getStepIndex() {
        return this.l.getStepIndex();
    }

    @NotNull
    public final PublishRelay<Integer> getStepIndexChanges() {
        return this.v;
    }

    public final void goToNextStep(@Nullable ScreenTransfer screenTransfer) {
        CategoryPublishStep categoryPublishStep;
        int stepIndex = getStepIndex();
        List<CategoryPublishStep> e2 = e();
        if (e2 == null || stepIndex != CollectionsKt__CollectionsKt.getLastIndex(e2)) {
            List<CategoryPublishStep> e3 = e();
            if (e3 == null || (categoryPublishStep = (CategoryPublishStep) Collections.getNextItem(e3, c(), false)) == null) {
                List<CategoryPublishStep> e4 = e();
                categoryPublishStep = e4 != null ? (CategoryPublishStep) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) e4) : null;
            }
            if (categoryPublishStep == null) {
                handleErrorOrFail("Cannot go to the next step");
                return;
            }
            try {
                RoutingAction g2 = g(categoryPublishStep, a.FORWARD, screenTransfer);
                setCurrentStepIndex(categoryPublishStep);
                this.i.setValue(g2);
            } catch (IllegalArgumentException e5) {
                onUnexpectedErrorOccurred(e5);
            }
        } else {
            onUnexpectedErrorOccurred(new Exception("Trying to go next step from the last one"));
        }
    }

    public final void goToPreviousStep() {
        Navigation previousNavigation;
        List<CategoryPublishStep> e2 = e();
        if (e2 == null) {
            handleErrorOrFail("Steps list is null. Cannot go to previous step");
            return;
        }
        CategoryPublishStep c2 = c();
        do {
            c2 = (CategoryPublishStep) Collections.getPreviousItem(e2, c2, false);
            if (c2 == null) {
                break;
            }
            PublishState.StepState stepState = this.l.getStepStates().get(Integer.valueOf(d(c2)));
            if ((stepState instanceof PublishState.StepState.CategorySelector) && (previousNavigation = ((PublishState.StepState.CategorySelector) stepState).getPreviousNavigation()) != null) {
                this.l.setNavigation(previousNavigation);
            }
        } while (c2.getSkipOnBackwards());
        if (c2 != null) {
            setCurrentStepIndex(c2);
            this.i.setValue(new RoutingAction.BackToStep(getStepIndex(), PublishViewModelKt.access$sendToAnalytics(getStep(Integer.valueOf(getStepIndex())))));
            return;
        }
        this.i.setValue(RoutingAction.CancelPublish.INSTANCE);
    }

    public final void handleErrorOrFail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (!this.z) {
            onUnexpectedErrorOccurred(new RuntimeException(str));
            return;
        }
        throw new RuntimeException(str);
    }

    public final boolean handleServerValidationErrors(@NotNull Map<String, ? extends PretendErrorValue> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        List<CategoryPublishStep> e2 = e();
        if (e2 == null) {
            return false;
        }
        Integer valueOf = Integer.valueOf(getStepIndex());
        Integer num = null;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        Iterator it = e.downTo(valueOf != null ? valueOf.intValue() : e2.size() - 1, 0).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (this.g[nextInt].applyPretendResult(map)) {
                num = Integer.valueOf(nextInt);
            }
        }
        if (num != null) {
            setCurrentStepIndex(getStep(Integer.valueOf(num.intValue())));
            this.x = true;
            this.i.setValue(new RoutingAction.BackToStep(getStepIndex(), PublishViewModelKt.access$sendToAnalytics(getStep(Integer.valueOf(getStepIndex())))));
        }
        if (num != null) {
            return true;
        }
        return false;
    }

    public final void init(@NotNull Navigation navigation, boolean z2) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        this.l.setNavigation(navigation);
        this.l.setRootNavigation(navigation);
        this.n = z2;
    }

    public final boolean isCategoryChanged() {
        return this.t;
    }

    public final boolean isEditing() {
        return this.p != null;
    }

    public final boolean isItemPublished() {
        return (this.p == null && this.m == null) ? false : true;
    }

    public final boolean isPrevalidationRequired() {
        String str = this.q;
        boolean z2 = str != null && Intrinsics.areEqual(str, "activate") && !this.e;
        this.e = true;
        return z2;
    }

    public final boolean isRemoteDraft() {
        CategoryParameters categoryParameters = this.r;
        return (categoryParameters != null ? categoryParameters.getDraft() : null) != null;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
        this.d.clear();
        super.onCleared();
    }

    public final void onUnexpectedErrorOccurred(@Nullable Throwable th) {
        if (th != null) {
            Logs.error("onUnexpectedErrorOccurred", th);
        }
        this.i.postValue(RoutingAction.UnexpectedError.INSTANCE);
    }

    public final void resetStateWithChangedCategory(@NotNull CategoryModel categoryModel) {
        Intrinsics.checkNotNullParameter(categoryModel, "newCategory");
        this.t = true;
        this.n = true;
        this.l.resetStepStatesWithNewCategory(categoryModel);
        Navigation rootNavigation = categoryModel.getRootNavigation();
        if (rootNavigation != null) {
            this.l.setRootNavigation(rootNavigation);
        }
        this.l.setNavigation(categoryModel.getNavigation());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void restoreState(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.category_parameters.CategoryParameters r18, @org.jetbrains.annotations.NotNull com.avito.android.publish.PublishState r19) {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.PublishViewModel.restoreState(com.avito.android.remote.model.category_parameters.CategoryParameters, com.avito.android.publish.PublishState):void");
    }

    public final void resumePublishingFlow() {
        this.i.setValue(new RoutingAction.InfomodelRequest(false));
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.i;
    }

    @NotNull
    public final Kundle saveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("key_state", this.l);
        kundle.putString("key_item_id", this.m);
        kundle.putBoolean("key_should_restore_draft", Boolean.valueOf(this.n));
        kundle.putParcelable("key_category_parameters", this.r);
        kundle.putParcelable("key_contacts_data", this.s);
        kundle.putParcelable("key_item_data", this.p);
        kundle.putString("key_post_action", this.q);
        return kundle;
    }

    public final void setAdvertId(@Nullable String str) {
        this.m = str;
    }

    public final void setCategoryChanged(boolean z2) {
        this.t = z2;
    }

    public final void setCategoryParametersAndInitSteps(@NotNull CategoryParameters categoryParameters) {
        ArrayList<SlotWithParameters> arrayList;
        LinkedHashMap linkedHashMap;
        String targetStepId;
        ParametersTree[] parametersTreeArr;
        List<ParameterSlot> parameters;
        List<ParameterSlot> parameters2;
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        this.r = categoryParameters;
        this.l.setNavigation(categoryParameters.getNavigation());
        this.d.clear();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = categoryParameters.getValueChanges().subscribe(this.k);
        Intrinsics.checkNotNullExpressionValue(subscribe, "categoryParameters\n     …ametersValueChangesRelay)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = categoryParameters.getValueChanges().subscribe(new m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "categoryParameters\n     …add(getParameterId(it)) }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CategoryParameters categoryParameters2 = this.r;
        CategoryPublishStep categoryPublishStep = null;
        if (categoryParameters2 == null || (parameters2 = categoryParameters2.getParameters()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (T t2 : parameters2) {
                if (t2 instanceof SlotWithParameters) {
                    arrayList.add(t2);
                }
            }
        }
        if (arrayList != null) {
            for (SlotWithParameters slotWithParameters : arrayList) {
                slotWithParameters.initParameters();
            }
        }
        CategoryParameters categoryParameters3 = this.r;
        if (categoryParameters3 == null || (parameters = categoryParameters3.getParameters()) == null) {
            linkedHashMap = null;
        } else {
            linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(parameters, 10)), 16));
            for (T t3 : parameters) {
                linkedHashMap.put(t3.getId(), t3);
            }
        }
        if (linkedHashMap == null) {
            this.g = new ParametersTree[0];
            handleErrorOrFail("Cannot init steps with null parameters");
        } else {
            List<CategoryPublishStep> e2 = e();
            if (e2 != null) {
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(e2, 10));
                Iterator<T> it = e2.iterator();
                while (it.hasNext()) {
                    List<String> fields = it.next().getFields();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<T> it2 = fields.iterator();
                    while (it2.hasNext()) {
                        ParameterSlot parameterSlot = (ParameterSlot) linkedHashMap.get(it2.next());
                        if (parameterSlot != null) {
                            arrayList3.add(parameterSlot);
                        }
                    }
                    arrayList2.add(new SimpleParametersTree(arrayList3, null, 2, null));
                }
                Object[] array = arrayList2.toArray(new ParametersTree[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                parametersTreeArr = (ParametersTree[]) array;
            } else {
                parametersTreeArr = new ParametersTree[0];
            }
            this.g = parametersTreeArr;
        }
        if (this.t && (targetStepId = categoryParameters.getTargetStepId()) != null) {
            List<CategoryPublishStep> e3 = e();
            if (e3 != null) {
                Iterator<T> it3 = e3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    if (Intrinsics.areEqual(next.getId(), targetStepId)) {
                        categoryPublishStep = next;
                        break;
                    }
                }
                categoryPublishStep = categoryPublishStep;
            }
            setCurrentStepIndex(categoryPublishStep);
        }
    }

    public final void setContactsData(@Nullable ContactsData contactsData) {
        this.s = contactsData;
        if (contactsData != null) {
            this.j.setValue(contactsData);
        }
    }

    public final void setCurrentStepIndex(@Nullable CategoryPublishStep categoryPublishStep) {
        CategoryParameters categoryParameters;
        List<CategoryPublishStep> steps;
        String str;
        int d2 = d(categoryPublishStep);
        boolean z2 = false;
        if (this.l.getStepIndex() != d2) {
            this.l.setStepIndex(d2);
            if (!(d2 == -1 || (categoryParameters = this.r) == null || (steps = categoryParameters.getSteps()) == null || (str = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) steps.get(d2).getFields())) == null)) {
                this.l.setActiveFieldId(str);
                z2 = this.f;
            }
        }
        if (z2) {
            this.v.accept(Integer.valueOf(d2));
        }
    }

    public final void setDraftId(@Nullable String str) {
        this.o = str;
    }

    public final void setItem(@Nullable ItemBrief itemBrief) {
        this.p = itemBrief;
    }

    public final void setPostAction(@Nullable String str) {
        this.q = str;
    }

    @NotNull
    public final Maybe<OnboardingData> shouldShowDraftOnboardingForStep(int i2) {
        Maybe<OnboardingData> flatMap = Maybe.defer(new b(this, i2)).flatMap(new c(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Maybe.defer {\n        (!…ldShowDraftOnboarding() }");
        return flatMap;
    }

    public final void startDynamicPublishingFlow() {
        this.i.setValue(new RoutingAction.InfomodelRequest(true));
    }

    @NotNull
    public final LiveData<Unit> stateInitialization() {
        return this.h;
    }

    public void updateStateWithCategory(@NotNull CategoryModel categoryModel) {
        Intrinsics.checkNotNullParameter(categoryModel, "category");
        this.l.setSelectedCategoryForStep(getStepIndex(), categoryModel);
        this.l.setNavigation(categoryModel.getNavigation());
        this.A.trackSelectCategory(getNavigation().getCategoryId());
        if (isEditing()) {
            setCurrentStepIndex(null);
            startDynamicPublishingFlow();
            return;
        }
        goToNextStep$default(this, null, 1, null);
    }

    public PublishViewModel(@NotNull DraftOnboardingInteractor draftOnboardingInteractor, boolean z2, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(draftOnboardingInteractor, "draftOnboardingInteractor");
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        this.y = draftOnboardingInteractor;
        this.z = z2;
        this.A = publishEventTracker;
        this.c = new CompositeDisposable();
        this.d = new CompositeDisposable();
        this.f = true;
        this.g = new ParametersTree[0];
        this.h = new SingleLiveEvent<>();
        this.i = new SingleLiveEvent<>();
        this.j = new SingleLiveEvent<>();
        PublishRelay<EditableParameter<?>> create = PublishRelay.create();
        this.k = create;
        this.l = new PublishState(null, null, 0, null, null, null, 63, null);
        this.u = new SingleLiveEvent<>();
        PublishRelay<Integer> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.v = create2;
        Observable<EditableParameter<?>> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "parametersValueChangesRelay.hide()");
        this.w = hide;
    }

    public final void restoreState(@Nullable Kundle kundle) {
        if (kundle != null) {
            PublishState publishState = (PublishState) kundle.getParcelable("key_state");
            if (publishState == null) {
                publishState = new PublishState(null, null, 0, null, null, null, 63, null);
            }
            this.l = publishState;
            this.h.postValue(Unit.INSTANCE);
            this.m = kundle.getString("key_item_id");
            this.n = kundle.getBoolean("key_should_restore_draft", this.n);
            CategoryParameters categoryParameters = (CategoryParameters) kundle.getParcelable("key_category_parameters");
            if (categoryParameters != null) {
                setCategoryParametersAndInitSteps(categoryParameters);
            }
            setContactsData((ContactsData) kundle.getParcelable("key_contacts_data"));
            this.p = (ItemBrief) kundle.getParcelable("key_item_data");
            this.q = kundle.getString("key_post_action");
            return;
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.w.map(new k(this)).subscribe(new l(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "parametersValueChanges\n …tiveFieldId\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
