package com.avito.android.photo_picker.photo_panel;

import a2.g.r.g;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.photo_panel.PhotoPanelViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/photo_picker/photo_panel/PhotoPanelFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onActivityCreated", "onDestroyView", "()V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "noPhotoSelectedMessage", "d", "photoCounterTextView", "Landroid/widget/FrameLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "photoCountContainer", AuthSource.SEND_ABUSE, "photosContainer", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel;", "h", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel;", "viewModel", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "mainButton", "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "topPhotoView", g.a, "bottomPhotoView", "<init>", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPanelFragment extends Fragment {
    public FrameLayout a;
    public FrameLayout b;
    public TextView c;
    public TextView d;
    public Button e;
    public SimpleDraweeView f;
    public SimpleDraweeView g;
    public PhotoPanelViewModel h;

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
                PhotoPanelFragment.access$getViewModel$p((PhotoPanelFragment) this.b).mainButtonClicked();
                PhotoPanelFragment.access$getMainButton$p((PhotoPanelFragment) this.b).setLoading(true);
                PhotoPanelFragment.access$getMainButton$p((PhotoPanelFragment) this.b).setClickable(false);
            } else if (i == 1) {
                PhotoPanelFragment.access$getViewModel$p((PhotoPanelFragment) this.b).photosClicked();
            } else {
                throw null;
            }
        }
    }

    public static final /* synthetic */ Button access$getMainButton$p(PhotoPanelFragment photoPanelFragment) {
        Button button = photoPanelFragment.e;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainButton");
        }
        return button;
    }

    public static final /* synthetic */ PhotoPanelViewModel access$getViewModel$p(PhotoPanelFragment photoPanelFragment) {
        PhotoPanelViewModel photoPanelViewModel = photoPanelFragment.h;
        if (photoPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return photoPanelViewModel;
    }

    public static final void access$updateViews(PhotoPanelFragment photoPanelFragment, PhotoPanelViewModel.ViewState.SelectedPhotosUpdate selectedPhotosUpdate) {
        Objects.requireNonNull(photoPanelFragment);
        int i = 8;
        if (selectedPhotosUpdate.getCount() == 0) {
            FrameLayout frameLayout = photoPanelFragment.b;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoCountContainer");
            }
            frameLayout.setVisibility(8);
            TextView textView = photoPanelFragment.c;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noPhotoSelectedMessage");
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = photoPanelFragment.d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoCounterTextView");
            }
            String string = photoPanelFragment.getResources().getString(R.string.photo_panel_count);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.photo_panel_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(selectedPhotosUpdate.getCount())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
            Uri lastPhoto = selectedPhotosUpdate.getLastPhoto();
            if (lastPhoto != null) {
                SimpleDraweeView simpleDraweeView = photoPanelFragment.f;
                if (simpleDraweeView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topPhotoView");
                }
                simpleDraweeView.setImageURI(lastPhoto, photoPanelFragment.getContext());
            }
            Uri preLastPhoto = selectedPhotosUpdate.getPreLastPhoto();
            if (preLastPhoto != null) {
                SimpleDraweeView simpleDraweeView2 = photoPanelFragment.g;
                if (simpleDraweeView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomPhotoView");
                }
                simpleDraweeView2.setImageURI(preLastPhoto, photoPanelFragment.getContext());
            }
            TextView textView3 = photoPanelFragment.c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noPhotoSelectedMessage");
            }
            textView3.setVisibility(8);
            FrameLayout frameLayout2 = photoPanelFragment.b;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoCountContainer");
            }
            frameLayout2.setVisibility(0);
        }
        SimpleDraweeView simpleDraweeView3 = photoPanelFragment.g;
        if (simpleDraweeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPhotoView");
        }
        if (selectedPhotosUpdate.getPreLastPhoto() != null) {
            i = 0;
        }
        simpleDraweeView3.setVisibility(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        PhotoPanelViewModel photoPanelViewModel = this.h;
        if (photoPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ViewModel viewModel = ViewModelProviders.of(requireActivity()).get(PhotoPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(re…kerViewModel::class.java)");
        photoPanelViewModel.init((PhotoPickerViewModel) viewModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ViewModel viewModel = ViewModelProviders.of(this).get(PhotoPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…nelViewModel::class.java)");
        this.h = (PhotoPanelViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_photo_panel, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        PhotoPanelViewModel photoPanelViewModel = this.h;
        if (photoPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPanelViewModel.screenState().removeObservers(getViewLifecycleOwner());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.photo_counter);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.photo_counter)");
        this.d = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.main_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.main_button)");
        Button button = (Button) findViewById2;
        this.e = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainButton");
        }
        button.setOnClickListener(new a(0, this));
        View findViewById3 = view.findViewById(R.id.no_photo_selected);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.no_photo_selected)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.photo_count_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.photo_count_container)");
        this.b = (FrameLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.photos_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.photos_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById5;
        this.a = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosContainer");
        }
        frameLayout.setOnClickListener(new a(1, this));
        View findViewById6 = view.findViewById(R.id.top_photo);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.top_photo)");
        this.f = (SimpleDraweeView) findViewById6;
        View findViewById7 = view.findViewById(R.id.bottom_photo);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.bottom_photo)");
        this.g = (SimpleDraweeView) findViewById7;
        PhotoPanelViewModel photoPanelViewModel = this.h;
        if (photoPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPanelViewModel.screenState().observe(getViewLifecycleOwner(), new a2.a.a.x1.r.a(this));
    }
}
