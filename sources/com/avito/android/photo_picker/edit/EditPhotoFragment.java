package com.avito.android.photo_picker.edit;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.krop.KropView;
import com.avito.android.krop.util.Transformation;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.edit.di.DaggerEditPhotoComponent;
import com.avito.android.photo_picker.edit.di.EditPhotoDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.Contexts;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Views;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b2\u0010\u001bR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010E\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u00106R\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bL\u0010\u001b¨\u0006P"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "onResume", "onPause", "e", "Landroid/view/View;", "progressView", "Lcom/avito/android/krop/KropView;", "d", "Lcom/avito/android/krop/KropView;", "photoView", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "photoPickerViewModel", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "viewModel", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "getViewModel", "()Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "setViewModel", "(Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;)V", "Lcom/avito/android/lib/design/button/Button;", "f", "Lcom/avito/android/lib/design/button/Button;", "cancelBtn", g.a, "saveBtn", "h", "rotateBtn", "", "j", "I", "backgroundColor", "Landroid/animation/ValueAnimator;", "l", "Landroid/animation/ValueAnimator;", "fadeCancelAnimation", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "i", "Lcom/facebook/datasource/DataSource;", "imageSource", "", AuthSource.OPEN_CHANNEL_LIST, "Z", "fadeBackgroundActive", "k", "backgroundColorFaded", "c", "controlsBg", "<init>", "Companion", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class EditPhotoFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public PhotoPickerViewModel a;
    public Toolbar b;
    public View c;
    public KropView d;
    public View e;
    public Button f;
    public Button g;
    public View h;
    public DataSource<CloseableReference<CloseableImage>> i;
    public final int j = R.attr.white;
    public final int k = R.attr.whiteAlpha80;
    public ValueAnimator l;
    public boolean m;
    @Inject
    public EditPhotoViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoFragment$Companion;", "", "", "photoId", "Lcom/avito/android/photo_picker/edit/EditPhotoFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/edit/EditPhotoFragment;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.a = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("photo_id", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final EditPhotoFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "photoId");
            return (EditPhotoFragment) FragmentsKt.arguments$default(new EditPhotoFragment(), 0, new a(str), 1, null);
        }

        public Companion(j jVar) {
        }
    }

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
                ((EditPhotoFragment) this.b).getViewModel().cancelEditProcess();
            } else if (i == 1) {
                ((EditPhotoFragment) this.b).getViewModel().rotate90();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ EditPhotoFragment a;

        public b(EditPhotoFragment editPhotoFragment) {
            this.a = editPhotoFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) a2.b.a.a.a.g2(valueAnimator, "updatedAnimation", "null cannot be cast to non-null type kotlin.Int")).intValue();
            this.a.m = false;
            EditPhotoFragment.access$setOverlayColor(this.a, intValue);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ EditPhotoFragment a;

        public static final class a extends Lambda implements Function0<Bitmap> {
            public final /* synthetic */ c a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar) {
                super(0);
                this.a = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Bitmap invoke() {
                return EditPhotoFragment.access$getPhotoView$p(this.a.a).getCroppedBitmap();
            }
        }

        public c(EditPhotoFragment editPhotoFragment) {
            this.a = editPhotoFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditPhotoFragment.access$lockButtons(this.a);
            this.a.getViewModel().saveChanges(EditPhotoFragment.access$getPhotoView$p(this.a).getTransformation(), new a(this));
        }
    }

    public static final void access$closeScreen(EditPhotoFragment editPhotoFragment) {
        PhotoPickerViewModel photoPickerViewModel = editPhotoFragment.a;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        PhotoPickerViewModel.handleBack$default(photoPickerViewModel, false, 1, null);
    }

    public static final /* synthetic */ ValueAnimator access$getFadeCancelAnimation$p(EditPhotoFragment editPhotoFragment) {
        ValueAnimator valueAnimator = editPhotoFragment.l;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeCancelAnimation");
        }
        return valueAnimator;
    }

    public static final /* synthetic */ PhotoPickerViewModel access$getPhotoPickerViewModel$p(EditPhotoFragment editPhotoFragment) {
        PhotoPickerViewModel photoPickerViewModel = editPhotoFragment.a;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel;
    }

    public static final /* synthetic */ KropView access$getPhotoView$p(EditPhotoFragment editPhotoFragment) {
        KropView kropView = editPhotoFragment.d;
        if (kropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        return kropView;
    }

    public static final /* synthetic */ View access$getProgressView$p(EditPhotoFragment editPhotoFragment) {
        View view = editPhotoFragment.e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        return view;
    }

    public static final /* synthetic */ View access$getRotateBtn$p(EditPhotoFragment editPhotoFragment) {
        View view = editPhotoFragment.h;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateBtn");
        }
        return view;
    }

    public static final void access$lockButtons(EditPhotoFragment editPhotoFragment) {
        Button button = editPhotoFragment.f;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        button.setEnabled(false);
        Button button2 = editPhotoFragment.g;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
        }
        button2.setLoading(true);
    }

    public static final void access$rotateImage(EditPhotoFragment editPhotoFragment, float f2) {
        Objects.requireNonNull(editPhotoFragment);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new a2.a.a.x1.o.b(editPhotoFragment, floatRef, f2));
        ofFloat.addListener(new AnimationUtils.SimpleAnimatorListener(floatRef, f2) { // from class: com.avito.android.photo_picker.edit.EditPhotoFragment$rotateImage$$inlined$apply$lambda$2
            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                EditPhotoFragment.access$getRotateBtn$p(EditPhotoFragment.this).setEnabled(true);
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                EditPhotoFragment.access$getRotateBtn$p(EditPhotoFragment.this).setEnabled(false);
            }
        });
        ofFloat.start();
    }

    public static final void access$setImage(EditPhotoFragment editPhotoFragment, Uri uri, Transformation transformation) {
        View view = editPhotoFragment.e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.setVisible(view, true);
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), editPhotoFragment.getContext());
        editPhotoFragment.i = fetchDecodedImage;
        if (fetchDecodedImage != null) {
            fetchDecodedImage.subscribe(new BaseBitmapDataSubscriber(transformation) { // from class: com.avito.android.photo_picker.edit.EditPhotoFragment$setImage$1
                public final /* synthetic */ Transformation b;

                {
                    this.b = r2;
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (bitmap != null) {
                        Views.setVisible(EditPhotoFragment.access$getProgressView$p(EditPhotoFragment.this), false);
                        EditPhotoFragment editPhotoFragment2 = EditPhotoFragment.this;
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(bitmap)");
                        EditPhotoFragment.access$setImageBitmap(editPhotoFragment2, createBitmap, this.b);
                    }
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static final void access$setImageBitmap(EditPhotoFragment editPhotoFragment, Bitmap bitmap, Transformation transformation) {
        Objects.requireNonNull(editPhotoFragment);
        if (bitmap.getHeight() > bitmap.getWidth()) {
            KropView kropView = editPhotoFragment.d;
            if (kropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoView");
            }
            Context context = kropView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "photoView.context");
            float displayWidth = (((float) Contexts.getDisplayWidth(context)) * 0.25f) / ((float) 2);
            KropView kropView2 = editPhotoFragment.d;
            if (kropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoView");
            }
            kropView2.applyOffset((int) displayWidth);
            KropView kropView3 = editPhotoFragment.d;
            if (kropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoView");
            }
            kropView3.applyAspectRatio(3, 4);
        }
        if (transformation != null) {
            KropView kropView4 = editPhotoFragment.d;
            if (kropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoView");
            }
            kropView4.setTransformation(transformation);
        }
        KropView kropView5 = editPhotoFragment.d;
        if (kropView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        kropView5.setBitmap(bitmap);
        KropView kropView6 = editPhotoFragment.d;
        if (kropView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        kropView6.setTransformationListener(new KropView.TransformationListener() { // from class: com.avito.android.photo_picker.edit.EditPhotoFragment$setBackgroundAnimation$1
            @Override // com.avito.android.krop.KropView.TransformationListener
            public void onUpdate(@NotNull Transformation transformation2) {
                Intrinsics.checkNotNullParameter(transformation2, "transformation");
                EditPhotoFragment.access$getFadeCancelAnimation$p(EditPhotoFragment.this).cancel();
                if (!(EditPhotoFragment.this.m)) {
                    EditPhotoFragment editPhotoFragment2 = EditPhotoFragment.this;
                    Context requireContext = editPhotoFragment2.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    EditPhotoFragment.access$setOverlayColor(editPhotoFragment2, Contexts.getColorByAttr(requireContext, EditPhotoFragment.this.k));
                    EditPhotoFragment.this.m = true;
                }
                EditPhotoFragment editPhotoFragment3 = EditPhotoFragment.this;
                EditPhotoFragment.access$start(editPhotoFragment3, EditPhotoFragment.access$getFadeCancelAnimation$p(editPhotoFragment3), 1500);
            }
        });
    }

    public static final void access$setOverlayColor(EditPhotoFragment editPhotoFragment, int i2) {
        KropView kropView = editPhotoFragment.d;
        if (kropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        kropView.applyOverlayColor(i2);
        Toolbar toolbar = editPhotoFragment.b;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.setBackgroundColor(i2);
        View view = editPhotoFragment.c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsBg");
        }
        view.setBackgroundColor(i2);
    }

    public static final void access$start(EditPhotoFragment editPhotoFragment, ValueAnimator valueAnimator, long j2) {
        Objects.requireNonNull(editPhotoFragment);
        valueAnimator.setStartDelay(j2);
        valueAnimator.start();
    }

    @NotNull
    public final EditPhotoViewModel getViewModel() {
        EditPhotoViewModel editPhotoViewModel = this.viewModel;
        if (editPhotoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return editPhotoViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(requireActivity()).get(PhotoPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(re…kerViewModel::class.java)");
        this.a = (PhotoPickerViewModel) viewModel2;
        String string = requireArguments().getString("photo_id");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(ARG_PHOTO_ID)!!");
        EditPhotoViewModel editPhotoViewModel = this.viewModel;
        if (editPhotoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PhotoPickerViewModel photoPickerViewModel = this.a;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        editPhotoViewModel.init(photoPickerViewModel.getSelectedPhoto(string));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        int colorByAttr = Contexts.getColorByAttr(requireContext, this.k);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        ValueAnimator ofArgb = ValueAnimator.ofArgb(colorByAttr, Contexts.getColorByAttr(requireContext2, this.j));
        ofArgb.setDuration(200L);
        ofArgb.addUpdateListener(new b(this));
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(ofArgb, "ValueAnimator.ofArgb(sta…)\n            }\n        }");
        this.l = ofArgb;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerEditPhotoComponent.builder().dependencies((EditPhotoDependencies) FragmentsKt.activityComponent(this)).withFragment(this).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.avito.android.photo_picker.R.layout.fragment_edit_photo, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ragment_edit_photo, null)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EditPhotoViewModel editPhotoViewModel = this.viewModel;
        if (editPhotoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editPhotoViewModel.screenState().removeObservers(getViewLifecycleOwner());
        DataSource<CloseableReference<CloseableImage>> dataSource = this.i;
        if (dataSource != null) {
            dataSource.close();
        }
        this.i = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeCancelAnimation");
        }
        valueAnimator.cancel();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeCancelAnimation");
        }
        valueAnimator.setStartDelay(0);
        valueAnimator.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(com.avito.android.photo_picker.R.id.progress_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_overlay)");
        this.e = findViewById;
        View findViewById2 = view.findViewById(com.avito.android.photo_picker.R.id.edit_photo_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.edit_photo_view)");
        this.d = (KropView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.photo_picker.R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.cancel_button)");
        this.f = (Button) findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.photo_picker.R.id.save_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.save_button)");
        this.g = (Button) findViewById4;
        View findViewById5 = view.findViewById(com.avito.android.photo_picker.R.id.rotate_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.rotate_button)");
        this.h = findViewById5;
        View findViewById6 = view.findViewById(com.avito.android.photo_picker.R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.toolbar)");
        this.b = (Toolbar) findViewById6;
        View findViewById7 = view.findViewById(com.avito.android.photo_picker.R.id.controls_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.controls_background)");
        this.c = findViewById7;
        KropView kropView = this.d;
        if (kropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        }
        kropView.setMaxScale(3.0f);
        Button button = this.f;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        button.setOnClickListener(new a(0, this));
        Button button2 = this.g;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
        }
        button2.setOnClickListener(new c(this));
        View view2 = this.h;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateBtn");
        }
        view2.setOnClickListener(new a(1, this));
        EditPhotoViewModel editPhotoViewModel = this.viewModel;
        if (editPhotoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editPhotoViewModel.screenState().observe(getViewLifecycleOwner(), new a2.a.a.x1.o.a(this));
    }

    public final void setViewModel(@NotNull EditPhotoViewModel editPhotoViewModel) {
        Intrinsics.checkNotNullParameter(editPhotoViewModel, "<set-?>");
        this.viewModel = editPhotoViewModel;
    }
}
