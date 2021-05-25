package com.avito.android.publish.sts_scanner;

import a2.a.a.e2.f0.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.photo_picker.legacy.CameraPresenterState;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.EmptyDescriptionProvider;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule;
import com.avito.android.photo_picker.legacy.di.SimpleDescriptionProviderFactory;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.sts_scanner.di.DaggerStsScannerComponent;
import com.avito.android.publish.sts_scanner.di.StsScannerModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bt\u0010\u0014J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u0017\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010\u0014J)\u0010%\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J-\u0010,\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\fH\u0016¢\u0006\u0004\b2\u0010\u0014J\r\u00103\u001a\u00020\f¢\u0006\u0004\b3\u0010\u0014R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006u"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsScannerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onCreate", "(Landroid/os/Bundle;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onActivityCreated", "onStart", "()V", "onResume", "onPause", "onStop", "onDestroy", "outState", "onSaveInstanceState", "", "isMultiple", "openGallery", "(Z)Z", "openAppSettings", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onDetach", "showStsRecognitionErrorDialog", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "cameraPresenter", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "getCameraPresenter", "()Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "setCameraPresenter", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "rotationInteractor", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "getRotationInteractor", "()Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "setRotationInteractor", "(Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;)V", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "galleryResultsExtractor", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "getGalleryResultsExtractor", "()Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "setGalleryResultsExtractor", "(Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/PublishViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "presenter", "Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "getPresenter", "()Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "setPresenter", "(Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;)V", "Landroid/os/Handler;", AuthSource.SEND_ABUSE, "Landroid/os/Handler;", "handler", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StsScannerFragment extends Fragment implements CameraItemPresenter.Router {
    public final Handler a = new Handler();
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public PublishViewModel b;
    @Inject
    public CameraItemPresenter cameraPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public GalleryResultsExtractor galleryResultsExtractor;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public StsScannerPresenter presenter;
    @Inject
    public StoppableRotationInteractor rotationInteractor;

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
    public final CameraItemPresenter getCameraPresenter() {
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        return cameraItemPresenter;
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
    public final GalleryResultsExtractor getGalleryResultsExtractor() {
        GalleryResultsExtractor galleryResultsExtractor2 = this.galleryResultsExtractor;
        if (galleryResultsExtractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryResultsExtractor");
        }
        return galleryResultsExtractor2;
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
    public final StsScannerPresenter getPresenter() {
        StsScannerPresenter stsScannerPresenter = this.presenter;
        if (stsScannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return stsScannerPresenter;
    }

    @NotNull
    public final StoppableRotationInteractor getRotationInteractor() {
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        return stoppableRotationInteractor;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.publish.sts_scanner.StsScannerRouter");
        StsScannerRouter stsScannerRouter = (StsScannerRouter) activity;
        StsScannerPresenter stsScannerPresenter = this.presenter;
        if (stsScannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        stsScannerPresenter.attachRouter(stsScannerRouter);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.b = (PublishViewModel) viewModel;
        StsScannerPresenter stsScannerPresenter2 = this.presenter;
        if (stsScannerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PublishViewModel publishViewModel = this.b;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        stsScannerPresenter2.setPublishViewModel(publishViewModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            GalleryResultsExtractor galleryResultsExtractor2 = this.galleryResultsExtractor;
            if (galleryResultsExtractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryResultsExtractor");
            }
            List<Uri> extract = galleryResultsExtractor2.extract(intent);
            if (!extract.isEmpty()) {
                this.a.post(new a(this, extract));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setRequestedOrientation(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        CameraType.BackCamera backCamera = CameraType.BackCamera.INSTANCE;
        CameraPresenterState cameraPresenterState = bundle != null ? (CameraPresenterState) bundle.getParcelable("camera_presenter_state") : null;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        WindowManager windowManager = requireActivity.getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager, "requireActivity().windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "requireActivity().windowManager.defaultDisplay");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        CameraItemPresenterModule cameraItemPresenterModule = new CameraItemPresenterModule(defaultDisplay, resources, StsScannerFragmentKt.access$getPHOTO_SIZE$p(), backCamera, false, new SimpleDescriptionProviderFactory(new EmptyDescriptionProvider()), cameraPresenterState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            DaggerStsScannerComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).stsScannerModule(new StsScannerModule(this, arguments.getInt(PublishActivityKt.KEY_STEP_INDEX))).cameraPresenterModule(cameraItemPresenterModule).build().inject(this);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.sts_scanner, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StsScannerPresenter stsScannerPresenter = this.presenter;
        if (stsScannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        stsScannerPresenter.detachRouter();
        StsScannerPresenter stsScannerPresenter2 = this.presenter;
        if (stsScannerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        stsScannerPresenter2.detachView();
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.detachViewWithSurface();
        this.a.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setRequestedOrientation(-1);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        stoppableRotationInteractor.stop();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.onPermissionResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        stoppableRotationInteractor.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        bundle.putParcelable("camera_presenter_state", cameraItemPresenter.getState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.attachRouter(this);
        CameraItemPresenter cameraItemPresenter2 = this.cameraPresenter;
        if (cameraItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter2.initialize();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.detachRouter();
        CameraItemPresenter cameraItemPresenter2 = this.cameraPresenter;
        if (cameraItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter2.uninitialize();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        View findViewById = view.findViewById(R.id.camera_item_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.camera_item_view)");
        CameraItemPresenter cameraItemPresenter2 = this.cameraPresenter;
        if (cameraItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.bindView(new CameraItemViewImpl(findViewById, cameraItemPresenter2));
        StsScannerPresenter stsScannerPresenter = this.presenter;
        if (stsScannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById2 = view.findViewById(R.id.search_by_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.search_by_image)");
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        stsScannerPresenter.attachView(new StsScannerViewImpl(findViewById2, analytics2));
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Router
    public void openAppSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Router
    public boolean openGallery(boolean z) {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        FragmentsKt.startActivityForResultSafely(this, implicitIntentFactory2.pickExternalSingleImageIntent(), 1);
        return true;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCameraPresenter(@NotNull CameraItemPresenter cameraItemPresenter) {
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "<set-?>");
        this.cameraPresenter = cameraItemPresenter;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setGalleryResultsExtractor(@NotNull GalleryResultsExtractor galleryResultsExtractor2) {
        Intrinsics.checkNotNullParameter(galleryResultsExtractor2, "<set-?>");
        this.galleryResultsExtractor = galleryResultsExtractor2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull StsScannerPresenter stsScannerPresenter) {
        Intrinsics.checkNotNullParameter(stsScannerPresenter, "<set-?>");
        this.presenter = stsScannerPresenter;
    }

    public final void setRotationInteractor(@NotNull StoppableRotationInteractor stoppableRotationInteractor) {
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "<set-?>");
        this.rotationInteractor = stoppableRotationInteractor;
    }

    public final void showStsRecognitionErrorDialog() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        StsScannerPresenter stsScannerPresenter = this.presenter;
        if (stsScannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        StsRecognitionErrorDialogKt.showStsRecognitionErrorDialogFragment(childFragmentManager, stsScannerPresenter);
    }
}
