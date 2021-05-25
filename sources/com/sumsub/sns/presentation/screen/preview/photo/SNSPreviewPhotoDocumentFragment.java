package com.sumsub.sns.presentation.screen.preview.photo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.transition.TransitionManager;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sumsub.camera.selfie.with.document.presentation.SNSSelfieWithDocumentPickerActivity;
import com.sumsub.sns.R;
import com.sumsub.sns.camera.photo.presentation.SNSPhotoDocumentPickerActivity;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.widget.SNSRotationImageView;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import com.transitionseverywhere.Crossfade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 M*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001MB\u0007¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u0010\"\u001a\u0004\b0\u0010$\"\u0004\b1\u0010&R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010\"\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R\"\u0010<\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u00104\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\"\u0010?\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel;", "VM", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewFragment;", "", AuthSource.SEND_ABUSE, "()V", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getTitle", "()Ljava/lang/CharSequence;", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/sumsub/sns/core/widget/SNSRotationImageView;", "ivPhoto", "Lcom/sumsub/sns/core/widget/SNSRotationImageView;", "getIvPhoto", "()Lcom/sumsub/sns/core/widget/SNSRotationImageView;", "setIvPhoto", "(Lcom/sumsub/sns/core/widget/SNSRotationImageView;)V", "Landroid/widget/TextView;", "tvIdDoc", "Landroid/widget/TextView;", "getTvIdDoc", "()Landroid/widget/TextView;", "setTvIdDoc", "(Landroid/widget/TextView;)V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/ViewGroup;", "bsbWarning", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBsbWarning", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBsbWarning", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "tvTitle", "getTvTitle", "setTvTitle", "Landroid/widget/Button;", "btnReadableDocument", "Landroid/widget/Button;", "getBtnReadableDocument", "()Landroid/widget/Button;", "setBtnReadableDocument", "(Landroid/widget/Button;)V", "tvSubtitle", "getTvSubtitle", "setTvSubtitle", "btnTakeAnotherPhoto", "getBtnTakeAnotherPhoto", "setBtnTakeAnotherPhoto", "vgWarning", "Landroid/view/ViewGroup;", "getVgWarning", "()Landroid/view/ViewGroup;", "setVgWarning", "(Landroid/view/ViewGroup;)V", "Landroidx/constraintlayout/widget/Group;", "gContent", "Landroidx/constraintlayout/widget/Group;", "getGContent", "()Landroidx/constraintlayout/widget/Group;", "setGContent", "(Landroidx/constraintlayout/widget/Group;)V", "<init>", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSPreviewPhotoDocumentFragment<VM extends SNSPreviewPhotoDocumentViewModel> extends SNSBaseDocumentPreviewFragment<VM> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_ID_PHOTO_DOCUMENT_PICKER = 1;
    @NotNull
    public static final String TAG = "PreviewPhotoDocumentFragment";
    public BottomSheetBehavior<ViewGroup> bsbWarning;
    @BindView(2075)
    public Button btnReadableDocument;
    @BindView(2080)
    public Button btnTakeAnotherPhoto;
    @BindView(2206)
    public Group gContent;
    @BindView(2240)
    public SNSRotationImageView ivPhoto;
    public TextView tvIdDoc;
    @BindView(2481)
    public TextView tvSubtitle;
    @BindView(2483)
    public TextView tvTitle;
    public ViewGroup vgWarning;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentFragment$Companion;", "", "", "REQUEST_ID_PHOTO_DOCUMENT_PICKER", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
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
                ((SNSPreviewPhotoDocumentFragment) this.b).getIvPhoto().rotateCW();
            } else if (i == 1) {
                ((SNSPreviewPhotoDocumentFragment) this.b).getIvPhoto().rotateCCW();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<CharSequence, CharSequence> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return charSequence2;
        }
    }

    public static final void access$showError(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment, CharSequence charSequence) {
        ViewGroup viewGroup = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            textView.setText(sNSPreviewPhotoDocumentFragment.getTextResource(R.string.sns_preview_idDocError_brief));
            textView.setVisibility(8);
        }
        ViewGroup viewGroup2 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        TextView textView2 = (TextView) viewGroup2.findViewById(16908299);
        if (textView2 != null) {
            textView2.setText(charSequence);
            textView2.setVisibility(0);
        }
        ViewGroup viewGroup3 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Button button = (Button) viewGroup3.findViewById(16908313);
        if (button != null) {
            button.setText(sNSPreviewPhotoDocumentFragment.getTextResource(R.string.sns_preview_idDocError_action_retake));
            button.setOnClickListener(new a2.q.a.d.a.d.b.a(sNSPreviewPhotoDocumentFragment));
        }
        ViewGroup viewGroup4 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Button button2 = (Button) viewGroup4.findViewById(16908314);
        if (button2 != null) {
            button2.setVisibility(8);
        }
        ViewGroup viewGroup5 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(viewGroup5, new Runnable(viewGroup5, sNSPreviewPhotoDocumentFragment) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$showError$$inlined$doOnPreDraw$1
            public final /* synthetic */ View a;
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextView textView3 = (TextView) this.b.getVgWarning().findViewById(16908299);
                int i = 0;
                int height = textView3 != null ? textView3.getHeight() : 0;
                TextView textView4 = (TextView) this.b.getVgWarning().findViewById(16908310);
                if (textView4 != null) {
                    i = textView4.getHeight();
                }
                this.b.getBsbWarning().setPeekHeight((this.b.getVgWarning().getHeight() - height) + i);
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior = sNSPreviewPhotoDocumentFragment.bsbWarning;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bsbWarning");
        }
        bottomSheetBehavior.setState(3);
    }

    public static final void access$showWarning(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment, CharSequence charSequence) {
        ViewGroup viewGroup = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            textView.setText(sNSPreviewPhotoDocumentFragment.getTextResource(R.string.sns_preview_idDocWarning_brief));
            textView.setVisibility(8);
        }
        ViewGroup viewGroup2 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        TextView textView2 = (TextView) viewGroup2.findViewById(16908299);
        if (textView2 != null) {
            textView2.setText(charSequence);
            textView2.setVisibility(0);
        }
        ViewGroup viewGroup3 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Button button = (Button) viewGroup3.findViewById(16908313);
        if (button != null) {
            button.setText(sNSPreviewPhotoDocumentFragment.getTextResource(R.string.sns_preview_idDocWarning_action_continue));
            button.setOnClickListener(new c1(0, sNSPreviewPhotoDocumentFragment));
        }
        ViewGroup viewGroup4 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Button button2 = (Button) viewGroup4.findViewById(16908314);
        if (button2 != null) {
            button2.setText(sNSPreviewPhotoDocumentFragment.getTextResource(R.string.sns_preview_idDocWarning_action_retake));
            button2.setOnClickListener(new c1(1, sNSPreviewPhotoDocumentFragment));
            button2.setVisibility(0);
        }
        ViewGroup viewGroup5 = sNSPreviewPhotoDocumentFragment.vgWarning;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(viewGroup5, new Runnable(viewGroup5, sNSPreviewPhotoDocumentFragment) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$showWarning$$inlined$doOnPreDraw$1
            public final /* synthetic */ View a;
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextView textView3 = (TextView) this.b.getVgWarning().findViewById(16908299);
                int i = 0;
                int height = textView3 != null ? textView3.getHeight() : 0;
                TextView textView4 = (TextView) this.b.getVgWarning().findViewById(16908310);
                if (textView4 != null) {
                    i = textView4.getHeight();
                }
                this.b.getBsbWarning().setPeekHeight((this.b.getVgWarning().getHeight() - height) + i);
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior = sNSPreviewPhotoDocumentFragment.bsbWarning;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bsbWarning");
        }
        bottomSheetBehavior.setState(3);
    }

    public final void a() {
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior = this.bsbWarning;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bsbWarning");
        }
        bottomSheetBehavior.setHideable(true);
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior2 = this.bsbWarning;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bsbWarning");
        }
        bottomSheetBehavior2.setState(5);
        TextView textView = this.tvIdDoc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdDoc");
        }
        textView.setVisibility(8);
    }

    @NotNull
    public final BottomSheetBehavior<ViewGroup> getBsbWarning() {
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior = this.bsbWarning;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bsbWarning");
        }
        return bottomSheetBehavior;
    }

    @NotNull
    public final Button getBtnReadableDocument() {
        Button button = this.btnReadableDocument;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnReadableDocument");
        }
        return button;
    }

    @NotNull
    public final Button getBtnTakeAnotherPhoto() {
        Button button = this.btnTakeAnotherPhoto;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeAnotherPhoto");
        }
        return button;
    }

    @NotNull
    public final Group getGContent() {
        Group group = this.gContent;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gContent");
        }
        return group;
    }

    @NotNull
    public final SNSRotationImageView getIvPhoto() {
        SNSRotationImageView sNSRotationImageView = this.ivPhoto;
        if (sNSRotationImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPhoto");
        }
        return sNSRotationImageView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_preview_photo_document;
    }

    @NotNull
    public CharSequence getTitle() {
        return getTextResource(R.string.sns_preview_photo_title);
    }

    @NotNull
    public final TextView getTvIdDoc() {
        TextView textView = this.tvIdDoc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdDoc");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvSubtitle() {
        TextView textView = this.tvSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return textView;
    }

    @NotNull
    public final ViewGroup getVgWarning() {
        ViewGroup viewGroup = this.vgWarning;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            ((SNSPreviewPhotoDocumentViewModel) getViewModel()).onDocumentPicked(intent != null ? (DocumentPickerResult) intent.getParcelableExtra(SNSConstants.Extra.DOCUMENT_RESULT) : null);
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<Boolean> showContent = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowContent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showContent.observe(viewLifecycleOwner, new SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1(this));
        LiveData<Boolean> showProgress = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowProgress();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showProgress.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    boolean booleanValue = t.booleanValue();
                    FragmentActivity activity = this.a.getActivity();
                    if (!(activity instanceof SNSAppListener)) {
                        activity = null;
                    }
                    SNSAppListener sNSAppListener = (SNSAppListener) activity;
                    if (sNSAppListener != null) {
                        sNSAppListener.onProgress(booleanValue);
                    }
                }
            }
        });
        LiveData<Event<Object>> showAnotherSideAlert = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowAnotherSideAlert();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        showAnotherSideAlert.observe(viewLifecycleOwner3, new SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$1(this));
        LiveData<Event<SNSPreviewPhotoDocumentViewModel.PickerRequest>> showDocumentPhotoPicker = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowDocumentPhotoPicker();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showDocumentPhotoPicker.observe(viewLifecycleOwner4, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$2
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSPreviewPhotoDocumentViewModel.PickerRequest pickerRequest = (SNSPreviewPhotoDocumentViewModel.PickerRequest) contentIfNotHandled;
                    SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment = this.a;
                    SNSPhotoDocumentPickerActivity.Companion companion = SNSPhotoDocumentPickerActivity.Companion;
                    Context requireContext = sNSPreviewPhotoDocumentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    sNSPreviewPhotoDocumentFragment.startActivityForResult(companion.newIntent(requireContext, this.a.getSession(), pickerRequest.getApplicant(), pickerRequest.getDocument().getType(), pickerRequest.getSide(), pickerRequest.getGallery(), pickerRequest.getIdentityType()), 1);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Event<SNSPreviewPhotoDocumentViewModel.PickerRequest>> showSelfieWithDocumentPicker = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowSelfieWithDocumentPicker();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        showSelfieWithDocumentPicker.observe(viewLifecycleOwner5, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$3
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSPreviewPhotoDocumentViewModel.PickerRequest pickerRequest = (SNSPreviewPhotoDocumentViewModel.PickerRequest) contentIfNotHandled;
                    SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment = this.a;
                    SNSSelfieWithDocumentPickerActivity.Companion companion = SNSSelfieWithDocumentPickerActivity.Companion;
                    Context requireContext = sNSPreviewPhotoDocumentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    sNSPreviewPhotoDocumentFragment.startActivityForResult(companion.newIntent(requireContext, this.a.getSession(), pickerRequest.getApplicant(), pickerRequest.getDocument().getType(), pickerRequest.getGallery()), 1);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Pair<Bitmap, Integer>> photo = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getPhoto();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        photo.observe(viewLifecycleOwner6, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$3
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    int intValue = ((Number) t2.component2()).intValue();
                    this.a.getIvPhoto().setImageBitmapWithRotation((Bitmap) t2.component1(), intValue);
                }
            }
        });
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_rotate_cw);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_rotate_ccw);
        imageButton.setOnClickListener(new a(0, this));
        imageButton2.setOnClickListener(new a(1, this));
        MutableLiveData<Boolean> allowRotate = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getAllowRotate();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "viewLifecycleOwner");
        allowRotate.observe(viewLifecycleOwner7, new Observer<T>(imageButton, imageButton2) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$4
            public final /* synthetic */ ImageButton a;
            public final /* synthetic */ ImageButton b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    ImageButton imageButton3 = this.a;
                    Intrinsics.checkNotNullExpressionValue(imageButton3, "btnRotateCW");
                    Intrinsics.checkNotNullExpressionValue(t2, "allow");
                    int i = 0;
                    imageButton3.setVisibility(t2.booleanValue() ? 0 : 4);
                    ImageButton imageButton4 = this.b;
                    Intrinsics.checkNotNullExpressionValue(imageButton4, "btnRotateCCW");
                    if (!t2.booleanValue()) {
                        i = 4;
                    }
                    imageButton4.setVisibility(i);
                }
            }
        });
        View findViewById = view.findViewById(R.id.tv_iddoc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_iddoc)");
        TextView textView = (TextView) findViewById;
        this.tvIdDoc = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdDoc");
        }
        textView.setVisibility(8);
        MutableLiveData<SNSPreviewPhotoDocumentViewModel.WarningResult> showWarning = ((SNSPreviewPhotoDocumentViewModel) getViewModel()).getShowWarning();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "viewLifecycleOwner");
        showWarning.observe(viewLifecycleOwner8, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$5
            public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    CharSequence component1 = t2.component1();
                    boolean component2 = t2.component2();
                    String component3 = t2.component3();
                    List<String> component4 = t2.component4();
                    String obj = component1.toString();
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(component4, 10));
                    Iterator<T> it = component4.iterator();
                    while (it.hasNext()) {
                        String r0 = IdentityType.m202constructorimpl(it.next());
                        Context requireContext = this.a.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        arrayList.add(IdentityType.m206getTitleimpl(r0, requireContext));
                    }
                    String replace$default = m.replace$default(obj, "{docTypes}", CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, SNSPreviewPhotoDocumentFragment.b.a, 30, null), false, 4, (Object) null);
                    if (component2) {
                        SNSPreviewPhotoDocumentFragment.access$showError(this.a, replace$default);
                    } else {
                        SNSPreviewPhotoDocumentFragment.access$showWarning(this.a, replace$default);
                    }
                    TextView tvIdDoc2 = this.a.getTvIdDoc();
                    tvIdDoc2.setVisibility(0);
                    String r02 = IdentityType.m202constructorimpl(component3);
                    Context requireContext2 = this.a.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                    tvIdDoc2.setText(IdentityType.m206getTitleimpl(r02, requireContext2));
                    this.a.getTvTitle().setVisibility(4);
                    this.a.getTvSubtitle().setVisibility(4);
                    this.a.getBtnReadableDocument().setVisibility(4);
                    this.a.getBtnTakeAnotherPhoto().setVisibility(4);
                }
            }
        });
        View findViewById2 = view.findViewById(R.id.vg_warning);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.vg_warning)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.vgWarning = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.tv_powered);
        if (textView2 != null) {
            textView2.setText(getTextResource(R.string.sns_general_poweredBy));
        }
        ViewGroup viewGroup2 = this.vgWarning;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgWarning");
        }
        BottomSheetBehavior<ViewGroup> from = BottomSheetBehavior.from(viewGroup2);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$prepareWarningDialog$$inlined$apply$lambda$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view2, float f) {
                Intrinsics.checkNotNullParameter(view2, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view2, int i) {
                Intrinsics.checkNotNullParameter(view2, "bottomSheet");
                if (i == 3) {
                    SNSPreviewPhotoDocumentFragment.this.getBsbWarning().setHideable(false);
                    TransitionManager.beginDelayedTransition(SNSPreviewPhotoDocumentFragment.this.getVgWarning(), new Crossfade());
                    TextView textView3 = (TextView) SNSPreviewPhotoDocumentFragment.this.getVgWarning().findViewById(16908310);
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    TextView textView4 = (TextView) SNSPreviewPhotoDocumentFragment.this.getVgWarning().findViewById(16908299);
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                } else if (i == 4) {
                    TransitionManager.beginDelayedTransition(SNSPreviewPhotoDocumentFragment.this.getVgWarning(), new Crossfade());
                    TextView textView5 = (TextView) SNSPreviewPhotoDocumentFragment.this.getVgWarning().findViewById(16908310);
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    TextView textView6 = (TextView) SNSPreviewPhotoDocumentFragment.this.getVgWarning().findViewById(16908299);
                    if (textView6 != null) {
                        textView6.setVisibility(8);
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from…\n            })\n        }");
        this.bsbWarning = from;
        a();
    }

    public final void setBsbWarning(@NotNull BottomSheetBehavior<ViewGroup> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<set-?>");
        this.bsbWarning = bottomSheetBehavior;
    }

    public final void setBtnReadableDocument(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnReadableDocument = button;
    }

    public final void setBtnTakeAnotherPhoto(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnTakeAnotherPhoto = button;
    }

    public final void setGContent(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, "<set-?>");
        this.gContent = group;
    }

    public final void setIvPhoto(@NotNull SNSRotationImageView sNSRotationImageView) {
        Intrinsics.checkNotNullParameter(sNSRotationImageView, "<set-?>");
        this.ivPhoto = sNSRotationImageView;
    }

    public final void setTvIdDoc(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvIdDoc = textView;
    }

    public final void setTvSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubtitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }

    public final void setVgWarning(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgWarning = viewGroup;
    }
}
