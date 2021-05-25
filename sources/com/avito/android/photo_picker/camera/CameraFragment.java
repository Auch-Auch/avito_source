package com.avito.android.photo_picker.camera;

import a2.a.a.x1.n.b;
import a2.g.r.g;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.camera.di.CameraComponent;
import com.avito.android.photo_picker.camera.di.CameraDependencies;
import com.avito.android.photo_picker.camera.di.DaggerCameraComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0005\u00103R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010;\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b:\u00103R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraFragment;", "Landroidx/fragment/app/Fragment;", "", AuthSource.SEND_ABUSE, "()V", AuthSource.BOOKING_ORDER, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onActivityCreated", "onDestroyView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "changeFlashButton", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "infoTextView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "galleryButton", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "allowAccessButton", "Lcom/avito/android/photo_picker/camera/CameraViewport;", "i", "Lcom/avito/android/photo_picker/camera/CameraViewport;", "cameraViewport", "Lcom/avito/android/photo_picker/camera/CameraViewModelFactory;", "viewModelFactory", "Lcom/avito/android/photo_picker/camera/CameraViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/photo_picker/camera/CameraViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/photo_picker/camera/CameraViewModelFactory;)V", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "cancelButton", "f", "Landroid/view/View;", "noPermissionView", g.a, "captureButton", "c", "changeCameraButton", "Lcom/avito/android/photo_picker/camera/CameraViewModel;", "j", "Lcom/avito/android/photo_picker/camera/CameraViewModel;", "viewModel", "<init>", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraFragment extends Fragment {
    public SimpleDraweeView a;
    public ImageButton b;
    public ImageButton c;
    public ImageView d;
    public Button e;
    public View f;
    public ImageButton g;
    public TextView h;
    public CameraViewport i;
    public CameraViewModel j;
    @Inject
    public CameraViewModelFactory viewModelFactory;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).captureClicked();
            } else if (i == 1) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).galleryClicked();
            } else if (i == 2) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).cancelClicked();
            } else if (i == 3) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).cameraModeClicked();
            } else if (i == 4) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).flashModeClicked();
            } else if (i == 5) {
                CameraFragment.access$getViewModel$p((CameraFragment) this.b).allowAccessClicked();
            } else {
                throw null;
            }
        }
    }

    public static final void access$disablePhotoControls(CameraFragment cameraFragment) {
        ImageButton imageButton = cameraFragment.g;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
        }
        Views.disable(imageButton);
        ImageButton imageButton2 = cameraFragment.c;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeCameraButton");
        }
        Views.disable(imageButton2);
        ImageView imageView = cameraFragment.d;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeFlashButton");
        }
        Views.disable(imageView);
    }

    public static final /* synthetic */ CameraViewport access$getCameraViewport$p(CameraFragment cameraFragment) {
        CameraViewport cameraViewport = cameraFragment.i;
        if (cameraViewport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
        }
        return cameraViewport;
    }

    public static final /* synthetic */ ImageView access$getChangeFlashButton$p(CameraFragment cameraFragment) {
        ImageView imageView = cameraFragment.d;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeFlashButton");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView access$getInfoTextView$p(CameraFragment cameraFragment) {
        TextView textView = cameraFragment.h;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoTextView");
        }
        return textView;
    }

    public static final /* synthetic */ CameraViewModel access$getViewModel$p(CameraFragment cameraFragment) {
        CameraViewModel cameraViewModel = cameraFragment.j;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cameraViewModel;
    }

    public static final void access$handlePhotoCaptured(CameraFragment cameraFragment, boolean z) {
        CameraViewport cameraViewport = cameraFragment.i;
        if (cameraViewport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
        }
        cameraViewport.startPhotoCaptureAnimation();
        cameraFragment.a();
        if (z) {
            CameraViewModel cameraViewModel = cameraFragment.j;
            if (cameraViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            cameraViewModel.closeCamera();
            cameraFragment.b();
        }
    }

    public static final void access$hideNoPermission(CameraFragment cameraFragment) {
        View view = cameraFragment.f;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noPermissionView");
        }
        view.setVisibility(8);
    }

    public static final void access$showGalleryButtonSrc(CameraFragment cameraFragment, Bitmap bitmap) {
        SimpleDraweeView simpleDraweeView = cameraFragment.a;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        simpleDraweeView.setClickable(true);
        SimpleDraweeView simpleDraweeView2 = cameraFragment.a;
        if (simpleDraweeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2).drawable(new BitmapDrawable(cameraFragment.getResources(), bitmap)).load();
    }

    public static final void access$showGalleryButtonStub(CameraFragment cameraFragment) {
        SimpleDraweeView simpleDraweeView = cameraFragment.a;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        simpleDraweeView.setClickable(true);
        SimpleDraweeView simpleDraweeView2 = cameraFragment.a;
        if (simpleDraweeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2);
        Drawable drawable = cameraFragment.requireContext().getDrawable(R.drawable.img_gallery_placeholder_48);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "requireContext().getDraw…gallery_placeholder_48)!!");
        requestBuilder.drawable(drawable).load();
    }

    public static final void access$showNoPermission(CameraFragment cameraFragment, int i2) {
        View view = cameraFragment.f;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noPermissionView");
        }
        view.setVisibility(0);
        Button button = cameraFragment.e;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowAccessButton");
        }
        button.setText(cameraFragment.getString(i2));
    }

    public final void a() {
        ImageButton imageButton = this.g;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
        }
        Views.enable(imageButton);
        ImageButton imageButton2 = this.c;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeCameraButton");
        }
        Views.enable(imageButton2);
        ImageView imageView = this.d;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeFlashButton");
        }
        Views.enable(imageView);
    }

    public final void b() {
        CameraViewport cameraViewport = this.i;
        if (cameraViewport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
        }
        if (cameraViewport.isTextureAvailable()) {
            CameraViewport cameraViewport2 = this.i;
            if (cameraViewport2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
            }
            SurfaceTexture surfaceTexture = cameraViewport2.getSurfaceTexture();
            if (surfaceTexture != null) {
                CameraViewport cameraViewport3 = this.i;
                if (cameraViewport3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
                }
                Dimension dimensions = cameraViewport3.getDimensions();
                int component1 = dimensions.component1();
                int component2 = dimensions.component2();
                CameraViewModel cameraViewModel = this.j;
                if (cameraViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                cameraViewModel.openCamera(surfaceTexture, component1, component2);
                return;
            }
            return;
        }
        CameraViewport cameraViewport4 = this.i;
        if (cameraViewport4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
        }
        CameraViewModel cameraViewModel2 = this.j;
        if (cameraViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cameraViewport4.setSurfaceTextureListener(cameraViewModel2.getSurfaceTextureListener());
    }

    @NotNull
    public final CameraViewModelFactory getViewModelFactory() {
        CameraViewModelFactory cameraViewModelFactory = this.viewModelFactory;
        if (cameraViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return cameraViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        CameraViewModel cameraViewModel = this.j;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ViewModel viewModel = ViewModelProviders.of(requireActivity()).get(PhotoPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(re…kerViewModel::class.java)");
        cameraViewModel.init((PhotoPickerViewModel) viewModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Point point = new Point();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        WindowManager windowManager = requireActivity.getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager, "requireActivity().windowManager");
        windowManager.getDefaultDisplay().getSize(point);
        CameraComponent.Builder dependencies = DaggerCameraComponent.builder().dependencies((CameraDependencies) FragmentsKt.activityComponent(this));
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        ContentResolver contentResolver = requireActivity2.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "requireActivity().contentResolver");
        CameraComponent.Builder withDisplaySize = dependencies.withContentResolver(contentResolver).withDisplaySize(point);
        FragmentActivity requireActivity3 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
        WindowManager windowManager2 = requireActivity3.getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager2, "requireActivity().windowManager");
        Display defaultDisplay = windowManager2.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "requireActivity().windowManager.defaultDisplay");
        CameraComponent.Builder withDisplay = withDisplaySize.withDisplay(defaultDisplay);
        FragmentActivity requireActivity4 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity()");
        withDisplay.withContext(requireActivity4).build().inject(this);
        CameraViewModelFactory cameraViewModelFactory = this.viewModelFactory;
        if (cameraViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, cameraViewModelFactory).get(CameraViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.j = (CameraViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_camera, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layout.fragment_camera, null)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        CameraViewModel cameraViewModel = this.j;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cameraViewModel.screenState().removeObservers(getViewLifecycleOwner());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        CameraViewModel cameraViewModel = this.j;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cameraViewModel.closeCamera();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.take_shot_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.take_shot_button)");
        ImageButton imageButton = (ImageButton) findViewById;
        this.g = imageButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
        }
        imageButton.setOnClickListener(new a(0, this));
        View findViewById2 = view.findViewById(R.id.gallery_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.gallery_button)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
        this.a = simpleDraweeView;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
        }
        simpleDraweeView.setOnClickListener(new a(1, this));
        View findViewById3 = view.findViewById(R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.cancel_button)");
        ImageButton imageButton2 = (ImageButton) findViewById3;
        this.b = imageButton2;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        }
        imageButton2.setOnClickListener(new a(2, this));
        View findViewById4 = view.findViewById(R.id.camera_toggle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.camera_toggle)");
        ImageButton imageButton3 = (ImageButton) findViewById4;
        this.c = imageButton3;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeCameraButton");
        }
        imageButton3.setOnClickListener(new a(3, this));
        View findViewById5 = view.findViewById(R.id.flash_toggle);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.flash_toggle)");
        ImageView imageView = (ImageView) findViewById5;
        this.d = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeFlashButton");
        }
        imageView.setOnClickListener(new a(4, this));
        View findViewById6 = view.findViewById(R.id.allow_access_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.allow_access_btn)");
        Button button = (Button) findViewById6;
        this.e = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowAccessButton");
        }
        button.setOnClickListener(new a(5, this));
        View findViewById7 = view.findViewById(R.id.no_permission);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.no_permission)");
        this.f = findViewById7;
        this.i = new CameraViewportImpl(view);
        CameraViewModel cameraViewModel = this.j;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        CameraViewport cameraViewport = this.i;
        if (cameraViewport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraViewport");
        }
        cameraViewModel.subscribeToFocusChanges(cameraViewport.getFocusObservable());
        View findViewById8 = view.findViewById(R.id.info);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.info)");
        this.h = (TextView) findViewById8;
        CameraViewModel cameraViewModel2 = this.j;
        if (cameraViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cameraViewModel2.checkCameraPermission();
        CameraViewModel cameraViewModel3 = this.j;
        if (cameraViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cameraViewModel3.screenState().observe(getViewLifecycleOwner(), new b(this));
        ((PhotoPickerViewModel) ViewModelProviders.of(requireActivity()).get(PhotoPickerViewModel.class)).screenState().observe(getViewLifecycleOwner(), new a2.a.a.x1.n.a(this));
    }

    public final void setViewModelFactory(@NotNull CameraViewModelFactory cameraViewModelFactory) {
        Intrinsics.checkNotNullParameter(cameraViewModelFactory, "<set-?>");
        this.viewModelFactory = cameraViewModelFactory;
    }
}
