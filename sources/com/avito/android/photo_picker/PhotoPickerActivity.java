package com.avito.android.photo_picker;

import a2.a.a.x1.b;
import a2.a.a.x1.c;
import a2.a.a.x1.d;
import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CheckResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.app.di.HasActivityComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.camera.CameraFragmentKt;
import com.avito.android.photo_picker.edit.EditPhotoFragment;
import com.avito.android.photo_picker.gallery.GalleryPickerFragmentKt;
import com.avito.android.photo_picker.legacy.CameraPresenterState;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.EmptyDescriptionProvider;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.PhotoDragAndDrop;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractorState;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenter;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterState;
import com.avito.android.photo_picker.legacy.PhotoPickerView;
import com.avito.android.photo_picker.legacy.PhotoPickerViewImpl;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule;
import com.avito.android.photo_picker.legacy.di.DaggerPhotoPickerComponent;
import com.avito.android.photo_picker.legacy.di.PhotoPickerComponent;
import com.avito.android.photo_picker.legacy.di.PhotoPickerDependencies;
import com.avito.android.photo_picker.legacy.di.PhotoPickerModule;
import com.avito.android.photo_picker.legacy.di.SimpleDescriptionProviderFactory;
import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import com.avito.android.photo_picker.photo_panel.PhotoPanelFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\b¢\u0006\u0005\b\u0001\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\bJ)\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0014¢\u0006\u0004\b#\u0010\u0013J\u0019\u0010$\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\bJ\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\bJ\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\bJ\u0017\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b*\u0010\fJ-\u00100\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\r2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\"\u0010|\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b|\u0010w\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R)\u0010\u0001\u001a\u000208\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "Lcom/avito/android/app/di/HasActivityComponent;", "Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "", AuthSource.SEND_ABUSE, "()V", "", "isMultiple", AuthSource.BOOKING_ORDER, "(Z)Z", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPostResume", "onResume", "onPause", "onStart", "onStop", "onDestroy", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "getActivityComponent", "()Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "outState", "onSaveInstanceState", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "onBackPressed", "onSubmit", "onCancel", "openAppSettings", "openGallery", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/os/Handler;", "n", "Landroid/os/Handler;", "handler", "k", "Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "photoPickerComponent", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "galleryResultsExtractor", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "getGalleryResultsExtractor", "()Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "setGalleryResultsExtractor", "(Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;)V", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "cameraPresenter", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "getCameraPresenter", "()Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "setCameraPresenter", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;)V", "o", "Z", "shouldShowGalleryFragmentOnResume", "Lcom/avito/android/util/ImplicitIntentFactory;", "intentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "photoDragAndDrop", "Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "getPhotoDragAndDrop", "()Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "setPhotoDragAndDrop", "(Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;)V", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "presenter", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "getPresenter", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "setPresenter", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$photo_picker_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$photo_picker_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "l", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "viewModel", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelFragment;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelFragment;", "panelFragment", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "displayAnalyzer", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "getDisplayAnalyzer", "()Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "setDisplayAnalyzer", "(Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "cameraAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getCameraAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setCameraAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "thumbnailsAdapter", "getThumbnailsAdapter", "setThumbnailsAdapter", "Lcom/avito/android/photo_picker/PhotoPickerViewModelFactory;", "viewModelFactory", "Lcom/avito/android/photo_picker/PhotoPickerViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/photo_picker/PhotoPickerViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/photo_picker/PhotoPickerViewModelFactory;)V", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "rotationInteractor", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "getRotationInteractor", "()Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "setRotationInteractor", "(Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;)V", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "interactor", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "getInteractor", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "setInteractor", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;)V", "<init>", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerActivity extends BaseActivity implements PhotoPickerPresenter.Router, CameraItemPresenter.Router, HasActivityComponent<PhotoPickerComponent> {
    @Inject
    public Analytics analytics;
    @PhotoPickerModule.DetailsAdapter
    @Inject
    public SimpleRecyclerAdapter cameraAdapter;
    @Inject
    public CameraItemPresenter cameraPresenter;
    @Inject
    public DisplayAnalyzer displayAnalyzer;
    @Inject
    public GalleryResultsExtractor galleryResultsExtractor;
    @Inject
    public ImplicitIntentFactory intentFactory;
    @Inject
    public PhotoPickerInteractor interactor;
    public PhotoPickerComponent k;
    public PhotoPickerViewModel l;
    public final PhotoPanelFragment m = new PhotoPanelFragment();
    public final Handler n = new Handler();
    public boolean o;
    @Inject
    public PhotoDragAndDrop photoDragAndDrop;
    @Inject
    public PhotoPickerPresenter presenter;
    @Inject
    public StoppableRotationInteractor rotationInteractor;
    @Inject
    @PhotoPickerModule.ThumbnailsAdapter
    public SimpleRecyclerAdapter thumbnailsAdapter;
    @Inject
    public PhotoPickerViewModelFactory viewModelFactory;

    public static final void access$hideChosenPhotoFragment(PhotoPickerActivity photoPickerActivity) {
        photoPickerActivity.getSupportFragmentManager().beginTransaction().remove(photoPickerActivity.m).commit();
    }

    public static final void access$hideFullScreenLoading(PhotoPickerActivity photoPickerActivity) {
        PhotoPickerPresenter photoPickerPresenter = photoPickerActivity.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter.hideFullScreenLoading();
    }

    public static final void access$openEdit(PhotoPickerActivity photoPickerActivity, List list) {
        Objects.requireNonNull(photoPickerActivity);
        if (!list.isEmpty()) {
            photoPickerActivity.a();
            photoPickerActivity.n.post(new d(photoPickerActivity, list));
        }
    }

    public static final void access$setResultAndFinish(PhotoPickerActivity photoPickerActivity) {
        photoPickerActivity.setResult(0);
        CameraItemPresenter cameraItemPresenter = photoPickerActivity.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.onScreenLeaved();
        photoPickerActivity.finish();
    }

    public static final void access$showCameraFragment(PhotoPickerActivity photoPickerActivity) {
        Objects.requireNonNull(photoPickerActivity);
        photoPickerActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, CameraFragmentKt.createCameraFragment()).commit();
    }

    public static final void access$showChosenPhotoFragment(PhotoPickerActivity photoPickerActivity) {
        photoPickerActivity.getSupportFragmentManager().beginTransaction().replace(R.id.panel_fragment_container, photoPickerActivity.m).commit();
    }

    public static final void access$showFullScreenLoading(PhotoPickerActivity photoPickerActivity) {
        PhotoPickerPresenter photoPickerPresenter = photoPickerActivity.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter.showFullScreenLoading();
    }

    public static final void access$showMaxPhotoError(PhotoPickerActivity photoPickerActivity, int i) {
        View findViewById = photoPickerActivity.findViewById(R.id.snackbar_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.snackbar_root)");
        String string = photoPickerActivity.getString(R.string.max_photo);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.max_photo)");
        Views.showSnackBar$default(findViewById, a.H(new Object[]{Integer.valueOf(i)}, 1, string, "java.lang.String.format(format, *args)"), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    public static final void access$showPhotoEditFragment(PhotoPickerActivity photoPickerActivity, String str) {
        Objects.requireNonNull(photoPickerActivity);
        photoPickerActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, EditPhotoFragment.Companion.newInstance(str)).commit();
    }

    public static final void access$showSystemGallery(PhotoPickerActivity photoPickerActivity, boolean z) {
        photoPickerActivity.a();
        photoPickerActivity.b(z);
    }

    public static final void access$startInAppGallery(PhotoPickerActivity photoPickerActivity) {
        CameraItemPresenter cameraItemPresenter = photoPickerActivity.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.uninitialize();
        photoPickerActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, GalleryPickerFragmentKt.createGalleryPickerFragment()).commit();
    }

    public final void a() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    public final boolean b(boolean z) {
        Intent intent;
        if (z) {
            ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
            if (implicitIntentFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            intent = implicitIntentFactory.pickExternalMultipleImageIntent();
        } else {
            ImplicitIntentFactory implicitIntentFactory2 = this.intentFactory;
            if (implicitIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            intent = implicitIntentFactory2.pickExternalSingleImageIntent();
        }
        try {
            startActivityForResult(IntentsKt.makeSafeForExternalApps(intent), 1);
            return true;
        } catch (Exception e) {
            getAnalytics$photo_picker_release().track(new NonFatalError("error", e, null, 4, null));
            return false;
        }
    }

    @NotNull
    public final Analytics getAnalytics$photo_picker_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getCameraAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.cameraAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final CameraItemPresenter getCameraPresenter() {
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        return cameraItemPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.photo_picker;
    }

    @NotNull
    public final DisplayAnalyzer getDisplayAnalyzer() {
        DisplayAnalyzer displayAnalyzer2 = this.displayAnalyzer;
        if (displayAnalyzer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayAnalyzer");
        }
        return displayAnalyzer2;
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
    public final ImplicitIntentFactory getIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final PhotoPickerInteractor getInteractor() {
        PhotoPickerInteractor photoPickerInteractor = this.interactor;
        if (photoPickerInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return photoPickerInteractor;
    }

    @NotNull
    public final PhotoDragAndDrop getPhotoDragAndDrop() {
        PhotoDragAndDrop photoDragAndDrop2 = this.photoDragAndDrop;
        if (photoDragAndDrop2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoDragAndDrop");
        }
        return photoDragAndDrop2;
    }

    @NotNull
    public final PhotoPickerPresenter getPresenter() {
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return photoPickerPresenter;
    }

    @NotNull
    public final StoppableRotationInteractor getRotationInteractor() {
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        return stoppableRotationInteractor;
    }

    @NotNull
    public final SimpleRecyclerAdapter getThumbnailsAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.thumbnailsAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailsAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final PhotoPickerViewModelFactory getViewModelFactory() {
        PhotoPickerViewModelFactory photoPickerViewModelFactory = this.viewModelFactory;
        if (photoPickerViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return photoPickerViewModelFactory;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            PhotoPickerViewModel photoPickerViewModel = this.l;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (photoPickerViewModel.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
                this.o = true;
            }
        } else if (i == 1 && intent != null) {
            GalleryResultsExtractor galleryResultsExtractor2 = this.galleryResultsExtractor;
            if (galleryResultsExtractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryResultsExtractor");
            }
            List<Uri> extract = galleryResultsExtractor2.extract(intent);
            PhotoPickerViewModel photoPickerViewModel2 = this.l;
            if (photoPickerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (photoPickerViewModel2.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
                this.o = true;
                for (T t : extract) {
                    PhotoPickerViewModel photoPickerViewModel3 = this.l;
                    if (photoPickerViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    PhotoPickerViewModel.selectPhotoByUri$default(photoPickerViewModel3, t, PhotoSource.GALLERY, null, null, 12, null);
                }
            }
            if (!extract.isEmpty()) {
                this.n.post(new a2.a.a.x1.a(this, extract));
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PhotoPickerViewModel photoPickerViewModel = this.l;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PhotoPickerViewModel.handleBack$default(photoPickerViewModel, false, 1, null);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter.Router
    public void onCancel() {
        onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig;
        super.onCreate(bundle);
        PhotoPickerViewModelFactory photoPickerViewModelFactory = this.viewModelFactory;
        if (photoPickerViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, photoPickerViewModelFactory).get(PhotoPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…kerViewModel::class.java)");
        PhotoPickerViewModel photoPickerViewModel = (PhotoPickerViewModel) viewModel;
        this.l = photoPickerViewModel;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPickerViewModel.routingActions().observe(this, new b(this));
        PhotoPickerViewModel photoPickerViewModel2 = this.l;
        if (photoPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPickerViewModel2.screenState().observe(this, new c(this));
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PhotoPickerViewModel photoPickerViewModel3 = this.l;
        if (photoPickerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPickerPresenter.setViewModel(photoPickerViewModel3);
        PhotoPickerViewModel photoPickerViewModel4 = this.l;
        if (photoPickerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (photoPickerViewModel4.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_APPBAR;
        } else {
            photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_FOOTER;
        }
        View findViewById = findViewById(R.id.photo_picker_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.photo_picker_root_view)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        PhotoPickerPresenter photoPickerPresenter2 = this.presenter;
        if (photoPickerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        PhotoDragAndDrop photoDragAndDrop2 = this.photoDragAndDrop;
        if (photoDragAndDrop2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoDragAndDrop");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.cameraAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraAdapter");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter2 = this.thumbnailsAdapter;
        if (simpleRecyclerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailsAdapter");
        }
        PhotoPickerViewImpl photoPickerViewImpl = new PhotoPickerViewImpl(viewGroup, photoPickerPresenter2, analytics2, photoPickerLayoutConfig, photoDragAndDrop2, simpleRecyclerAdapter, simpleRecyclerAdapter2, null, 128, null);
        PhotoPickerPresenter photoPickerPresenter3 = this.presenter;
        if (photoPickerPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter3.attachView(photoPickerViewImpl);
        String stringExtra = getIntent().getStringExtra("selected_photo_id");
        if (stringExtra != null) {
            PhotoPickerPresenter photoPickerPresenter4 = this.presenter;
            if (photoPickerPresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            photoPickerPresenter4.setSelectedPhotoId(stringExtra);
        }
        PhotoPickerViewModel photoPickerViewModel5 = this.l;
        if (photoPickerViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (photoPickerViewModel5.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
            PhotoPickerViewModel photoPickerViewModel6 = this.l;
            if (photoPickerViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            photoPickerViewModel6.startModeAdd();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter.detachView();
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.detachViewWithSurface();
        this.n.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        stoppableRotationInteractor.stop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (this.o) {
            PhotoPickerViewModel photoPickerViewModel = this.l;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            photoPickerViewModel.startModeAdd();
            this.o = false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.onPermissionResult(i, strArr, iArr);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        StoppableRotationInteractor stoppableRotationInteractor = this.rotationInteractor;
        if (stoppableRotationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationInteractor");
        }
        stoppableRotationInteractor.start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", photoPickerPresenter.getState());
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        bundle.putParcelable("camera_presenter_state", cameraItemPresenter.getState());
        PhotoPickerInteractor photoPickerInteractor = this.interactor;
        if (photoPickerInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("interactor_state", photoPickerInteractor.getState());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter.attachRouter(this);
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.attachRouter(this);
        PhotoPickerViewModel photoPickerViewModel = this.l;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (photoPickerViewModel.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            CameraItemPresenter cameraItemPresenter2 = this.cameraPresenter;
            if (cameraItemPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
            }
            cameraItemPresenter2.initialize();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PhotoPickerPresenter photoPickerPresenter = this.presenter;
        if (photoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        photoPickerPresenter.detachRouter();
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

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter.Router
    public void onSubmit() {
        Parcelable parcelable;
        PhotoPickerViewModel photoPickerViewModel = this.l;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Intent intent = null;
        Transformation transformation = null;
        if (photoPickerViewModel.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
            PhotoPickerViewModel photoPickerViewModel2 = this.l;
            if (photoPickerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            parcelable = (Parcelable) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) photoPickerViewModel2.getSelectedPhotos$photo_picker_release());
        } else {
            PhotoPickerPresenter photoPickerPresenter = this.presenter;
            if (photoPickerPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            UriPhotoItem firstPhoto = photoPickerPresenter.getFirstPhoto();
            parcelable = firstPhoto != null ? firstPhoto.getImageUri() : null;
        }
        if (parcelable != null) {
            Intent putExtra = new Intent().putExtra(PhotoPickerActivityKt.EXTRA_PHOTO_URI, parcelable).putExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID, getIntent().getStringExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID));
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n               …gExtra(KEY_OPERATION_ID))");
            PhotoPickerPresenter photoPickerPresenter2 = this.presenter;
            if (photoPickerPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            UriPhotoItem firstPhoto2 = photoPickerPresenter2.getFirstPhoto();
            if (firstPhoto2 != null) {
                transformation = firstPhoto2.getTransformation();
            }
            if (transformation != null) {
                putExtra.putExtra(PhotoPickerActivityKt.EXTRA_PHOTO_TRANSFORMATION, transformation);
            }
            intent = putExtra;
        }
        setResult(-1, intent);
        CameraItemPresenter cameraItemPresenter = this.cameraPresenter;
        if (cameraItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPresenter");
        }
        cameraItemPresenter.onScreenLeaved();
        finish();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Router
    public void openAppSettings() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(implicitIntentFactory.createAppSettingsIntent());
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Router
    @CheckResult
    public boolean openGallery(boolean z) {
        return b(z);
    }

    public final void setAnalytics$photo_picker_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCameraAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.cameraAdapter = simpleRecyclerAdapter;
    }

    public final void setCameraPresenter(@NotNull CameraItemPresenter cameraItemPresenter) {
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "<set-?>");
        this.cameraPresenter = cameraItemPresenter;
    }

    public final void setDisplayAnalyzer(@NotNull DisplayAnalyzer displayAnalyzer2) {
        Intrinsics.checkNotNullParameter(displayAnalyzer2, "<set-?>");
        this.displayAnalyzer = displayAnalyzer2;
    }

    public final void setGalleryResultsExtractor(@NotNull GalleryResultsExtractor galleryResultsExtractor2) {
        Intrinsics.checkNotNullParameter(galleryResultsExtractor2, "<set-?>");
        this.galleryResultsExtractor = galleryResultsExtractor2;
    }

    public final void setIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.intentFactory = implicitIntentFactory;
    }

    public final void setInteractor(@NotNull PhotoPickerInteractor photoPickerInteractor) {
        Intrinsics.checkNotNullParameter(photoPickerInteractor, "<set-?>");
        this.interactor = photoPickerInteractor;
    }

    public final void setPhotoDragAndDrop(@NotNull PhotoDragAndDrop photoDragAndDrop2) {
        Intrinsics.checkNotNullParameter(photoDragAndDrop2, "<set-?>");
        this.photoDragAndDrop = photoDragAndDrop2;
    }

    public final void setPresenter(@NotNull PhotoPickerPresenter photoPickerPresenter) {
        Intrinsics.checkNotNullParameter(photoPickerPresenter, "<set-?>");
        this.presenter = photoPickerPresenter;
    }

    public final void setRotationInteractor(@NotNull StoppableRotationInteractor stoppableRotationInteractor) {
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "<set-?>");
        this.rotationInteractor = stoppableRotationInteractor;
    }

    public final void setThumbnailsAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.thumbnailsAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig;
        String stringExtra = getIntent().getStringExtra("type_id");
        String stringExtra2 = getIntent().getStringExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID);
        int intExtra = getIntent().getIntExtra("min_photo_count", 0);
        int intExtra2 = getIntent().getIntExtra("max_photo_count", 0);
        if (stringExtra2 == null || stringExtra2.length() == 0) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new NonFatalError("operationId must be non empty", null, null, 6, null));
        }
        if (intExtra2 < 0 || intExtra2 < intExtra) {
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics3.track(new NonFatalError("maxPhotoCount must be greater than zero() and minPhotoCount", null, null, 6, null));
        }
        boolean booleanExtra = getIntent().getBooleanExtra("simplified_ui", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("with_crop", false);
        CameraType cameraType = (CameraType) getIntent().getParcelableExtra("start_camera");
        if (cameraType == null) {
            cameraType = CameraType.BackCamera.INSTANCE;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("photo_picker_mode");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.PublishIntentFactory.PhotoPickerMode");
        PublishIntentFactory.PhotoPickerMode photoPickerMode = (PublishIntentFactory.PhotoPickerMode) serializableExtra;
        if (photoPickerMode == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_APPBAR;
        } else {
            photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_FOOTER;
        }
        PhotoPickerPresenterState photoPickerPresenterState = bundle != null ? (PhotoPickerPresenterState) bundle.getParcelable("presenter_state") : null;
        PhotoPickerInteractorState photoPickerInteractorState = bundle != null ? (PhotoPickerInteractorState) bundle.getParcelable("interactor_state") : null;
        CameraPresenterState cameraPresenterState = bundle != null ? (CameraPresenterState) bundle.getParcelable("camera_presenter_state") : null;
        boolean z = intExtra2 > 1;
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "operationId");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "typeId");
        PhotoPickerModule photoPickerModule = new PhotoPickerModule(this, stringExtra2, stringExtra, photoPickerPresenterState, photoPickerInteractorState, intExtra, intExtra2, booleanExtra, booleanExtra2, photoPickerLayoutConfig);
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager, "windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "windowManager.defaultDisplay");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        PhotoPickerComponent.Builder withMaxPhotoCount = DaggerPhotoPickerComponent.builder().dependencies((PhotoPickerDependencies) ComponentDependenciesKt.getDependencies(PhotoPickerDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).photoPickerModule(photoPickerModule).cameraItemPresenterModule(new CameraItemPresenterModule(defaultDisplay, resources, PhotoPickerActivityKt.access$getPHOTO_SIZE$p(), cameraType, z, new SimpleDescriptionProviderFactory(new EmptyDescriptionProvider()), cameraPresenterState)).withMode(photoPickerMode).withMaxPhotoCount(intExtra2);
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        PhotoPickerComponent build = withMaxPhotoCount.withGson(create).build();
        this.k = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerComponent");
        }
        build.inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull PhotoPickerViewModelFactory photoPickerViewModelFactory) {
        Intrinsics.checkNotNullParameter(photoPickerViewModelFactory, "<set-?>");
        this.viewModelFactory = photoPickerViewModelFactory;
    }

    @Override // com.avito.android.app.di.HasActivityComponent
    @NotNull
    public PhotoPickerComponent getActivityComponent() {
        PhotoPickerComponent photoPickerComponent = this.k;
        if (photoPickerComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerComponent");
        }
        return photoPickerComponent;
    }
}
