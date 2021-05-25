package com.avito.android.photo_picker.gallery;

import a2.g.r.g;
import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.gallery.data.Folder;
import com.avito.android.photo_picker.gallery.di.DaggerGalleryPickerComponent;
import com.avito.android.photo_picker.gallery.di.GalleryPickerComponent;
import com.avito.android.photo_picker.gallery.di.GalleryPickerDependencies;
import com.avito.android.photo_picker.gallery.folders_list.FolderListPopup;
import com.avito.android.photo_picker.gallery.folders_list.FolderSelectedListener;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.FragmentsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\by\u0010\rJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\rJ/\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\f\u0010(R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030L8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b[\u0010(R\u0016\u0010_\u001a\u00020]8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0006\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X.¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bi\u0010jR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\bs\u0010(R\u0016\u0010x\u001a\u00020u8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006z"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerFragment;", "Landroidx/fragment/app/Fragment;", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "photos", "", "c", "(Ljava/util/List;)V", "Landroid/graphics/SurfaceTexture;", "surface", AuthSource.BOOKING_ORDER, "(Landroid/graphics/SurfaceTexture;)V", AuthSource.SEND_ABUSE, "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onActivityCreated", "onStart", "onResume", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/View;", "emptyState", "Landroidx/recyclerview/widget/RecyclerView;", "k", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "rootView", "Landroid/hardware/Camera;", "n", "Landroid/hardware/Camera;", "camera", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModelFactory;", "viewModelFactory", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModelFactory;)V", "Landroid/widget/Button;", "j", "Landroid/widget/Button;", "allowAccessButton", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/konveyor/data_source/ListDataSource;", "l", "Lcom/avito/konveyor/data_source/ListDataSource;", "dataSource", "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "cancelButton", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "e", "photoView", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "noPermissionView", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel;", "viewModel", "Landroid/view/TextureView;", "f", "Landroid/view/TextureView;", "textureView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "selectedFolderText", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "photoGridPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getPhotoGridPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setPhotoGridPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", g.a, "selectedFolderView", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderListPopup;", "i", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderListPopup;", "foldersPopUp", "<init>", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPickerFragment extends Fragment {
    public View a;
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public Analytics analytics;
    public View b;
    public FrameLayout c;
    public ImageButton d;
    public View e;
    public TextureView f;
    @Inject
    public Features features;
    public View g;
    public TextView h;
    public FolderListPopup i;
    public Button j;
    public RecyclerView k;
    public ListDataSource<GalleryUriPhotoItem> l;
    public GalleryPickerViewModel m;
    public Camera n;
    @Inject
    public AdapterPresenter photoGridPresenter;
    @Inject
    public GalleryPickerViewModelFactory viewModelFactory;

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
                GalleryPickerFragment.access$getViewModel$p((GalleryPickerFragment) this.b).allowAccessClicked();
            } else if (i == 1) {
                GalleryPickerFragment.access$getViewModel$p((GalleryPickerFragment) this.b).cancelButtonClicked();
            } else if (i == 2) {
                GalleryPickerFragment.access$getViewModel$p((GalleryPickerFragment) this.b).takePhotoClicked();
            } else if (i == 3) {
                GalleryPickerFragment.access$getFoldersPopUp$p((GalleryPickerFragment) this.b).showAsDropDown(GalleryPickerFragment.access$getSelectedFolderView$p((GalleryPickerFragment) this.b));
            } else {
                throw null;
            }
        }
    }

    public static final /* synthetic */ FolderListPopup access$getFoldersPopUp$p(GalleryPickerFragment galleryPickerFragment) {
        FolderListPopup folderListPopup = galleryPickerFragment.i;
        if (folderListPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        return folderListPopup;
    }

    public static final /* synthetic */ View access$getSelectedFolderView$p(GalleryPickerFragment galleryPickerFragment) {
        View view = galleryPickerFragment.g;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFolderView");
        }
        return view;
    }

    public static final /* synthetic */ GalleryPickerViewModel access$getViewModel$p(GalleryPickerFragment galleryPickerFragment) {
        GalleryPickerViewModel galleryPickerViewModel = galleryPickerFragment.m;
        if (galleryPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return galleryPickerViewModel;
    }

    public static final void access$hideNoPermission(GalleryPickerFragment galleryPickerFragment) {
        FrameLayout frameLayout = galleryPickerFragment.c;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noPermissionView");
        }
        frameLayout.setVisibility(8);
    }

    public static final void access$hideNoPhotos(GalleryPickerFragment galleryPickerFragment) {
        RecyclerView recyclerView = galleryPickerFragment.k;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setVisibility(0);
        View view = galleryPickerFragment.b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyState");
        }
        view.setVisibility(8);
    }

    public static final void access$onInitialDataLoaded(GalleryPickerFragment galleryPickerFragment, List list, List list2) {
        FolderListPopup folderListPopup = galleryPickerFragment.i;
        if (folderListPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup.setFolders(list2);
        FolderListPopup folderListPopup2 = galleryPickerFragment.i;
        if (folderListPopup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup2.setFolderSelectedListener(new FolderSelectedListener() { // from class: com.avito.android.photo_picker.gallery.GalleryPickerFragment$onInitialDataLoaded$1
            @Override // com.avito.android.photo_picker.gallery.folders_list.FolderSelectedListener
            public void onFolderSelected(int i2, @NotNull Folder folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                GalleryPickerFragment.access$getViewModel$p(GalleryPickerFragment.this).folderSelected(i2, folder);
            }
        });
        TextView textView = galleryPickerFragment.h;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFolderText");
        }
        textView.setText(((Folder) list2.get(0)).getFolderName());
        galleryPickerFragment.c(list);
    }

    public static final void access$selectFolder(GalleryPickerFragment galleryPickerFragment, String str) {
        FolderListPopup folderListPopup = galleryPickerFragment.i;
        if (folderListPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup.dismiss();
        TextView textView = galleryPickerFragment.h;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFolderText");
        }
        textView.setText(str);
    }

    public static final void access$showNoPermission(GalleryPickerFragment galleryPickerFragment, int i2) {
        Button button = galleryPickerFragment.j;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowAccessButton");
        }
        button.setText(galleryPickerFragment.getString(i2));
        FrameLayout frameLayout = galleryPickerFragment.c;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noPermissionView");
        }
        frameLayout.setVisibility(0);
    }

    public static final void access$showNoPhotos(GalleryPickerFragment galleryPickerFragment) {
        RecyclerView recyclerView = galleryPickerFragment.k;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setVisibility(8);
        View view = galleryPickerFragment.b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyState");
        }
        view.setVisibility(0);
    }

    public static final boolean access$stopPreview(GalleryPickerFragment galleryPickerFragment) {
        Objects.requireNonNull(galleryPickerFragment);
        try {
            Camera camera = galleryPickerFragment.n;
            if (camera != null) {
                camera.stopPreview();
            }
            Camera camera2 = galleryPickerFragment.n;
            if (camera2 == null) {
                return true;
            }
            camera2.release();
            return true;
        } catch (Exception e2) {
            Analytics analytics2 = galleryPickerFragment.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new NonFatalError("Can't stop preview or release camera", e2, null, 4, null));
            return true;
        }
    }

    public final void a() {
        TextureView textureView = this.f;
        if (textureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        float width = (float) textureView.getWidth();
        TextureView textureView2 = this.f;
        if (textureView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        float height = (float) textureView2.getHeight();
        TextureView textureView3 = this.f;
        if (textureView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        float width2 = (float) textureView3.getWidth();
        float f2 = width2 / 0.75f;
        TextureView textureView4 = this.f;
        if (textureView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        Matrix matrix = new Matrix();
        matrix.setScale(width2 / width, f2 / height);
        matrix.postTranslate((width - width2) / 2.0f, (height - f2) / 2.0f);
        textureView4.setTransform(matrix);
    }

    public final void b(SurfaceTexture surfaceTexture) {
        GalleryPickerViewModel galleryPickerViewModel = this.m;
        if (galleryPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (galleryPickerViewModel.checkCameraPermission()) {
            try {
                this.n = Camera.open();
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                int i2 = 0;
                Camera.getCameraInfo(0, cameraInfo);
                int rotation = requireActivity().getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 0) {
                    if (rotation == 1) {
                        i2 = 90;
                    } else if (rotation == 2) {
                        i2 = 180;
                    } else if (rotation == 3) {
                        i2 = 270;
                    }
                }
                int i3 = ((cameraInfo.orientation - i2) + 360) % 360;
                Camera camera = this.n;
                if (camera != null) {
                    camera.setDisplayOrientation(i3);
                }
                Camera camera2 = this.n;
                if (camera2 != null) {
                    camera2.setPreviewTexture(surfaceTexture);
                }
                Camera camera3 = this.n;
                if (camera3 != null) {
                    camera3.startPreview();
                }
                a();
            } catch (Exception e2) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new NonFatalError("Can't open camera or start preview", e2, null, 4, null));
            }
        }
    }

    public final void c(List<GalleryUriPhotoItem> list) {
        this.l = new ListDataSource<>(list);
        AdapterPresenter adapterPresenter = this.photoGridPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoGridPresenter");
        }
        ListDataSource<GalleryUriPhotoItem> listDataSource = this.l;
        if (listDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
        }
        adapterPresenter.onDataSourceChanged(listDataSource);
        RecyclerView recyclerView = this.k;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final AdapterPresenter getPhotoGridPresenter() {
        AdapterPresenter adapterPresenter = this.photoGridPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoGridPresenter");
        }
        return adapterPresenter;
    }

    @NotNull
    public final GalleryPickerViewModelFactory getViewModelFactory() {
        GalleryPickerViewModelFactory galleryPickerViewModelFactory = this.viewModelFactory;
        if (galleryPickerViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return galleryPickerViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        GalleryPickerViewModel galleryPickerViewModel = this.m;
        if (galleryPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ViewModel viewModel = ViewModelProviders.of(requireActivity()).get(PhotoPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(re…kerViewModel::class.java)");
        galleryPickerViewModel.initScreen((PhotoPickerViewModel) viewModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        GalleryPickerComponent.Builder withFragment = DaggerGalleryPickerComponent.builder().dependencies((GalleryPickerDependencies) FragmentsKt.activityComponent(this)).withFragment(this);
        FragmentActivity activity = getActivity();
        ContentResolver contentResolver = activity != null ? activity.getContentResolver() : null;
        Intrinsics.checkNotNull(contentResolver);
        withFragment.contentResolver(contentResolver).build().inject(this);
        GalleryPickerViewModelFactory galleryPickerViewModelFactory = this.viewModelFactory;
        if (galleryPickerViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, galleryPickerViewModelFactory).get(GalleryPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.m = (GalleryPickerViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_gallery, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layout.fragment_gallery, null)");
        this.a = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i2 == 1000) {
            GalleryPickerViewModel galleryPickerViewModel = this.m;
            if (galleryPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            galleryPickerViewModel.loadData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextureView textureView = this.f;
        if (textureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        if (textureView.isAvailable()) {
            TextureView textureView2 = this.f;
            if (textureView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
            }
            b(textureView2.getSurfaceTexture());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GalleryPickerViewModel galleryPickerViewModel = this.m;
        if (galleryPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        galleryPickerViewModel.loadData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = this.a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById = view2.findViewById(R.id.empty_state);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_state)");
        this.b = findViewById;
        View view3 = this.a;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById2 = view3.findViewById(R.id.no_permission);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.no_permission)");
        this.c = (FrameLayout) findViewById2;
        View view4 = this.a;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById3 = view4.findViewById(R.id.allow_access_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.allow_access_btn)");
        Button button = (Button) findViewById3;
        this.j = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowAccessButton");
        }
        button.setOnClickListener(new a(0, this));
        View view5 = this.a;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById4 = view5.findViewById(R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.cancel_button)");
        ImageButton imageButton = (ImageButton) findViewById4;
        this.d = imageButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        }
        imageButton.setOnClickListener(new a(1, this));
        View view6 = this.a;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById5 = view6.findViewById(R.id.photo_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.photo_view)");
        this.e = findViewById5;
        if (findViewById5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        findViewById5.setOnClickListener(new a(2, this));
        View view7 = this.a;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById6 = view7.findViewById(R.id.texture);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.texture)");
        TextureView textureView = (TextureView) findViewById6;
        this.f = textureView;
        if (textureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        }
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.avito.android.photo_picker.gallery.GalleryPickerFragment$onViewCreated$4
            public final /* synthetic */ GalleryPickerFragment a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@Nullable SurfaceTexture surfaceTexture, int i2, int i3) {
                this.a.b(surfaceTexture);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
                return GalleryPickerFragment.access$stopPreview(this.a);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
            }
        });
        View view8 = this.a;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById7 = view8.findViewById(R.id.folders_selector);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.folders_selector)");
        this.g = findViewById7;
        if (findViewById7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFolderView");
        }
        findViewById7.setOnClickListener(new a(3, this));
        View view9 = this.a;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById8 = view9.findViewById(R.id.selected_folder);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.selected_folder)");
        this.h = (TextView) findViewById8;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FolderListPopup folderListPopup = new FolderListPopup(requireActivity);
        this.i = folderListPopup;
        folderListPopup.setHeight(-2);
        FolderListPopup folderListPopup2 = this.i;
        if (folderListPopup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup2.setWidth(-2);
        FolderListPopup folderListPopup3 = this.i;
        if (folderListPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup3.setOutsideTouchable(true);
        FolderListPopup folderListPopup4 = this.i;
        if (folderListPopup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPopUp");
        }
        folderListPopup4.setFocusable(true);
        View view10 = this.a;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById9 = view10.findViewById(R.id.photo_list);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.photo_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById9;
        this.k = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.gallery_column_number)));
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(simpleRecyclerAdapter);
        GalleryPickerViewModel galleryPickerViewModel = this.m;
        if (galleryPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        galleryPickerViewModel.checkStoragePermission();
        GalleryPickerViewModel galleryPickerViewModel2 = this.m;
        if (galleryPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        galleryPickerViewModel2.screenState().observe(getViewLifecycleOwner(), new a2.a.a.x1.p.a(this));
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setPhotoGridPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "<set-?>");
        this.photoGridPresenter = adapterPresenter;
    }

    public final void setViewModelFactory(@NotNull GalleryPickerViewModelFactory galleryPickerViewModelFactory) {
        Intrinsics.checkNotNullParameter(galleryPickerViewModelFactory, "<set-?>");
        this.viewModelFactory = galleryPickerViewModelFactory;
    }
}
