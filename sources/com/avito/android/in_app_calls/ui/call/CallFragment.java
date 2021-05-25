package com.avito.android.in_app_calls.ui.call;

import a2.a.a.f1.h.d.b;
import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceKt;
import com.avito.android.in_app_calls.ui.AudioDeviceChooser;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import com.avito.android.in_app_calls.ui.call.CallFragmentComponent;
import com.avito.android.in_app_calls.ui.call.debugView.CallDebugInfoView;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001m\u0018\u0000 y2\u00020\u0001:\u0002yzB\u0007¢\u0006\u0004\bx\u0010\u0013J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001d\u0010l\u001a\u00020g8B@\u0002X\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010r\u001a\u00020q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006{"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "setTimeSource", "(Lcom/avito/android/server_time/TimeSource;)V", "Lcom/avito/android/in_app_calls/ui/call/CallView;", "c", "Lcom/avito/android/in_app_calls/ui/call/CallView;", "callView", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "pendingFinish", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "newDesignTestGroup", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "getNewDesignTestGroup", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "setNewDesignTestGroup", "(Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "intentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/in_app_calls/ui/call/debugView/CallDebugInfoView;", "d", "Lcom/avito/android/in_app_calls/ui/call/debugView/CallDebugInfoView;", "callDebugInfoView", "Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "audioDeviceChooser", "Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "getAudioDeviceChooser", "()Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "setAudioDeviceChooser", "(Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;)V", "Lcom/avito/android/calls/audio/CallAudioManager;", "audioManager", "Lcom/avito/android/calls/audio/CallAudioManager;", "getAudioManager", "()Lcom/avito/android/calls/audio/CallAudioManager;", "setAudioManager", "(Lcom/avito/android/calls/audio/CallAudioManager;)V", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "callPresenter", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "getCallPresenter", "()Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "setCallPresenter", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/permissions/PermissionHelper;", g.a, "Lkotlin/Lazy;", "getPermissionHelper", "()Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "com/avito/android/in_app_calls/ui/call/CallFragment$serviceConnection$1", "h", "Lcom/avito/android/in_app_calls/ui/call/CallFragment$serviceConnection$1;", "serviceConnection", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "router", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "getRouter", "()Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "setRouter", "(Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;)V", "<init>", "Companion", "Params", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_REQUEST = "request";
    @Inject
    public Analytics analytics;
    @Inject
    public AudioDeviceChooser audioDeviceChooser;
    @Inject
    public CallAudioManager audioManager;
    public CallView c;
    @Inject
    public CallPresenter callPresenter;
    public CallDebugInfoView d;
    public final CompositeDisposable e = new CompositeDisposable();
    public Disposable f;
    @Inject
    public Features features;
    public final Lazy g = c.lazy(new a(this));
    public final CallFragment$serviceConnection$1 h = new CallFragment$serviceConnection$1(this);
    @Inject
    public ImplicitIntentFactory intentFactory;
    @Inject
    public ExposedAbTestGroup<CallsNewDesignTestGroup> newDesignTestGroup;
    @Inject
    public InAppCallsRouter router;
    @Inject
    public TimeSource timeSource;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragment$Companion;", "", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "Lcom/avito/android/in_app_calls/ui/call/CallFragment;", "newInstance", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)Lcom/avito/android/in_app_calls/ui/call/CallFragment;", "", "KEY_REQUEST", "Ljava/lang/String;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CallFragment newInstance(@Nullable CallActivityRequest callActivityRequest) {
            CallFragment callFragment = new CallFragment();
            callFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("request", callActivityRequest)));
            return callFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragment$Params;", "", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "component1", "()Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "copy", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)Lcom/avito/android/in_app_calls/ui/call/CallFragment$Params;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "getRequest", "<init>", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @Nullable
        public final CallActivityRequest a;

        public Params(@Nullable CallActivityRequest callActivityRequest) {
            this.a = callActivityRequest;
        }

        public static /* synthetic */ Params copy$default(Params params, CallActivityRequest callActivityRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                callActivityRequest = params.a;
            }
            return params.copy(callActivityRequest);
        }

        @Nullable
        public final CallActivityRequest component1() {
            return this.a;
        }

        @NotNull
        public final Params copy(@Nullable CallActivityRequest callActivityRequest) {
            return new Params(callActivityRequest);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Params) && Intrinsics.areEqual(this.a, ((Params) obj).a);
            }
            return true;
        }

        @Nullable
        public final CallActivityRequest getRequest() {
            return this.a;
        }

        public int hashCode() {
            CallActivityRequest callActivityRequest = this.a;
            if (callActivityRequest != null) {
                return callActivityRequest.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(request=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a extends Lambda implements Function0<FragmentPermissionHelper> {
        public final /* synthetic */ CallFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CallFragment callFragment) {
            super(0);
            this.a = callFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FragmentPermissionHelper invoke() {
            return new FragmentPermissionHelper(this.a);
        }
    }

    public static final void access$finish(CallFragment callFragment) {
        FragmentActivity activity = callFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final /* synthetic */ CallDebugInfoView access$getCallDebugInfoView$p(CallFragment callFragment) {
        CallDebugInfoView callDebugInfoView = callFragment.d;
        if (callDebugInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callDebugInfoView");
        }
        return callDebugInfoView;
    }

    public static final /* synthetic */ CallView access$getCallView$p(CallFragment callFragment) {
        CallView callView = callFragment.c;
        if (callView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        return callView;
    }

    public static final PermissionHelper access$getPermissionHelper$p(CallFragment callFragment) {
        return (PermissionHelper) callFragment.g.getValue();
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
    public final AudioDeviceChooser getAudioDeviceChooser() {
        AudioDeviceChooser audioDeviceChooser2 = this.audioDeviceChooser;
        if (audioDeviceChooser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioDeviceChooser");
        }
        return audioDeviceChooser2;
    }

    @NotNull
    public final CallAudioManager getAudioManager() {
        CallAudioManager callAudioManager = this.audioManager;
        if (callAudioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        }
        return callAudioManager;
    }

    @NotNull
    public final CallPresenter getCallPresenter() {
        CallPresenter callPresenter2 = this.callPresenter;
        if (callPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        return callPresenter2;
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
    public final ImplicitIntentFactory getIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final ExposedAbTestGroup<CallsNewDesignTestGroup> getNewDesignTestGroup() {
        ExposedAbTestGroup<CallsNewDesignTestGroup> exposedAbTestGroup = this.newDesignTestGroup;
        if (exposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newDesignTestGroup");
        }
        return exposedAbTestGroup;
    }

    @NotNull
    public final InAppCallsRouter getRouter() {
        InAppCallsRouter inAppCallsRouter = this.router;
        if (inAppCallsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return inAppCallsRouter;
    }

    @NotNull
    public final TimeSource getTimeSource() {
        TimeSource timeSource2 = this.timeSource;
        if (timeSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSource");
        }
        return timeSource2;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_call, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059  */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r5, @org.jetbrains.annotations.NotNull java.lang.String[] r6, @org.jetbrains.annotations.NotNull int[] r7) {
        /*
            r4 = this;
            java.lang.String r0 = "permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "grantResults"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            if (r5 != r0) goto L_0x0062
            int r5 = r7.length
            r1 = 0
            if (r5 != 0) goto L_0x0013
            r5 = 1
            goto L_0x0014
        L_0x0013:
            r5 = 0
        L_0x0014:
            r5 = r5 ^ r0
            if (r5 == 0) goto L_0x002e
            int r5 = r7.length
            r2 = 0
        L_0x0019:
            if (r2 >= r5) goto L_0x0029
            r3 = r7[r2]
            if (r3 != 0) goto L_0x0021
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            if (r3 != 0) goto L_0x0026
            r5 = 0
            goto L_0x002a
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0029:
            r5 = 1
        L_0x002a:
            if (r5 == 0) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 == 0) goto L_0x0034
            com.avito.android.permissions.PermissionState r5 = com.avito.android.permissions.PermissionState.GRANTED
            goto L_0x0055
        L_0x0034:
            int r5 = r6.length
            r7 = 0
        L_0x0036:
            if (r7 >= r5) goto L_0x004d
            r2 = r6[r7]
            kotlin.Lazy r3 = r4.g
            java.lang.Object r3 = r3.getValue()
            com.avito.android.permissions.PermissionHelper r3 = (com.avito.android.permissions.PermissionHelper) r3
            boolean r2 = r3.shouldShowRequestPermissionRationale(r2)
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            int r7 = r7 + 1
            goto L_0x0036
        L_0x004d:
            r0 = 0
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            com.avito.android.permissions.PermissionState r5 = com.avito.android.permissions.PermissionState.FOREVER_DENIED
            goto L_0x0055
        L_0x0053:
            com.avito.android.permissions.PermissionState r5 = com.avito.android.permissions.PermissionState.DENIED
        L_0x0055:
            com.avito.android.in_app_calls.ui.call.CallPresenter r6 = r4.callPresenter
            if (r6 != 0) goto L_0x005e
            java.lang.String r7 = "callPresenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x005e:
            r6.onPermissionGranted(r5)
            goto L_0x0065
        L_0x0062:
            super.onRequestPermissionsResult(r5, r6, r7)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.ui.call.CallFragment.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CallView callView = this.c;
        if (callView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        callView.onStart();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.bindService(new Intent(requireContext(), CallManagerService.class), this.h, 9);
        }
        CallView callView2 = this.c;
        if (callView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Observable<Unit> answerClicks = callView2.getAnswerClicks();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe = answerClicks.throttleFirst(300, timeUnit).subscribe(new l2(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "callView.answerClicks\n  … callPresenter.answer() }");
        DisposableKt.addTo(subscribe, this.e);
        CallView callView3 = this.c;
        if (callView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe2 = callView3.getDeclineClicks().throttleFirst(300, timeUnit).subscribe(new l2(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "callView.declineClicks\n …callPresenter.decline() }");
        DisposableKt.addTo(subscribe2, this.e);
        CallView callView4 = this.c;
        if (callView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe3 = callView4.getHangupClicks().throttleFirst(300, timeUnit).subscribe(new l2(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "callView.hangupClicks\n  … callPresenter.hangup() }");
        DisposableKt.addTo(subscribe3, this.e);
        CallView callView5 = this.c;
        if (callView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe4 = callView5.getCloseClicks().throttleFirst(300, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new l2(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "callView.closeClicks\n   …  .subscribe { finish() }");
        DisposableKt.addTo(subscribe4, this.e);
        CallView callView6 = this.c;
        if (callView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe5 = callView6.getSpeakerClicks().throttleFirst(300, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new l2(4, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "callView.speakerClicks\n …ser.selectAudioDevice() }");
        DisposableKt.addTo(subscribe5, this.e);
        CallView callView7 = this.c;
        if (callView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe6 = callView7.getMicClicks().throttleFirst(300, timeUnit).subscribe(new l2(5, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "callView.micClicks\n     …llPresenter.toggleMic() }");
        DisposableKt.addTo(subscribe6, this.e);
        CallView callView8 = this.c;
        if (callView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        Disposable subscribe7 = callView8.getRatingButtonClicks().throttleFirst(300, timeUnit).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "callView.ratingButtonCli…lPresenter.rateCall(it) }");
        DisposableKt.addTo(subscribe7, this.e);
        CallPresenter callPresenter2 = this.callPresenter;
        if (callPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter2.getFinishWithDelayStream().observe(getViewLifecycleOwner(), new CallFragment$bindCallView$$inlined$observeNotNull$1(this));
        CallPresenter callPresenter3 = this.callPresenter;
        if (callPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter3.getPermissionRequestStream().observe(getViewLifecycleOwner(), new CallFragment$bindCallView$$inlined$observeNotNull$2(this));
        CallPresenter callPresenter4 = this.callPresenter;
        if (callPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter4.getStartServiceStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.in_app_calls.ui.call.CallFragment$bindCallView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    Context requireContext = CallFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    Intent createCallManagerServiceIntent = CallManagerServiceKt.createCallManagerServiceIntent(requireContext, t);
                    if (Build.VERSION.SDK_INT >= 26) {
                        FragmentActivity activity2 = CallFragment.this.getActivity();
                        if (activity2 != null) {
                            activity2.startForegroundService(createCallManagerServiceIntent);
                            return;
                        }
                        return;
                    }
                    FragmentActivity activity3 = CallFragment.this.getActivity();
                    if (activity3 != null) {
                        activity3.startService(createCallManagerServiceIntent);
                    }
                }
            }
        });
        CallPresenter callPresenter5 = this.callPresenter;
        if (callPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter5.getToastStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.in_app_calls.ui.call.CallFragment$bindCallView$$inlined$observeNotNull$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Context context = CallFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t2, 1);
                    }
                }
            }
        });
        CallPresenter callPresenter6 = this.callPresenter;
        if (callPresenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter6.getOpenDeclineReasonStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.in_app_calls.ui.call.CallFragment$bindCallView$$inlined$observeNotNull$5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    CallFragment.this.getRouter().openDeclineReasonScreen((String) t2.getFirst(), ((Number) t2.getSecond()).intValue());
                }
            }
        });
        CallPresenter callPresenter7 = this.callPresenter;
        if (callPresenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter7.getOpenCancelReasonStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.in_app_calls.ui.call.CallFragment$bindCallView$$inlined$observeNotNull$6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    CallFragment.this.getRouter().openCancelReasonScreen(t);
                }
            }
        });
        CallPresenter callPresenter8 = this.callPresenter;
        if (callPresenter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        Disposable subscribe8 = callPresenter8.getStateObservable().distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new a2.a.a.f1.h.d.a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe8, "callPresenter.stateObser…          }\n            }");
        DisposableKt.addTo(subscribe8, this.e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        CallView callView = this.c;
        if (callView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callView");
        }
        callView.onStop();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unbindService(this.h);
        }
        this.e.clear();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.fragment_call);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(R.id.fragment_call)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Window window = requireActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        TimeSource timeSource2 = this.timeSource;
        if (timeSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSource");
        }
        CallAudioManager callAudioManager = this.audioManager;
        if (callAudioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        }
        ExposedAbTestGroup<CallsNewDesignTestGroup> exposedAbTestGroup = this.newDesignTestGroup;
        if (exposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newDesignTestGroup");
        }
        this.c = new CallViewImpl(window, findViewById, timeSource2, callAudioManager, exposedAbTestGroup);
        View findViewById2 = findViewById.findViewById(R.id.call_debug_info_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.call_debug_info_view)");
        CallDebugInfoView callDebugInfoView = (CallDebugInfoView) findViewById2;
        this.d = callDebugInfoView;
        if (callDebugInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callDebugInfoView");
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        callDebugInfoView.setVisibility(features2.getCallsDebugMode().invoke().booleanValue() ? 0 : 8);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAudioDeviceChooser(@NotNull AudioDeviceChooser audioDeviceChooser2) {
        Intrinsics.checkNotNullParameter(audioDeviceChooser2, "<set-?>");
        this.audioDeviceChooser = audioDeviceChooser2;
    }

    public final void setAudioManager(@NotNull CallAudioManager callAudioManager) {
        Intrinsics.checkNotNullParameter(callAudioManager, "<set-?>");
        this.audioManager = callAudioManager;
    }

    public final void setCallPresenter(@NotNull CallPresenter callPresenter2) {
        Intrinsics.checkNotNullParameter(callPresenter2, "<set-?>");
        this.callPresenter = callPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.intentFactory = implicitIntentFactory;
    }

    public final void setNewDesignTestGroup(@NotNull ExposedAbTestGroup<CallsNewDesignTestGroup> exposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "<set-?>");
        this.newDesignTestGroup = exposedAbTestGroup;
    }

    public final void setRouter(@NotNull InAppCallsRouter inAppCallsRouter) {
        Intrinsics.checkNotNullParameter(inAppCallsRouter, "<set-?>");
        this.router = inAppCallsRouter;
    }

    public final void setTimeSource(@NotNull TimeSource timeSource2) {
        Intrinsics.checkNotNullParameter(timeSource2, "<set-?>");
        this.timeSource = timeSource2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        CallActivityRequest callActivityRequest = arguments != null ? (CallActivityRequest) arguments.getParcelable("request") : null;
        CallFragmentComponent.Builder fragment = DaggerCallFragmentComponent.builder().dependencies((CallFragmentComponentDependencies) ComponentDependenciesKt.getDependencies(CallFragmentComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).fragment(this);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        CallFragmentComponent.Builder activity = fragment.activity(requireActivity);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        activity.resources(resources).build().inject(this);
        if (callActivityRequest == null) {
            return true;
        }
        CallPresenter callPresenter2 = this.callPresenter;
        if (callPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPresenter");
        }
        callPresenter2.handleStartRequest(callActivityRequest);
        return true;
    }
}
