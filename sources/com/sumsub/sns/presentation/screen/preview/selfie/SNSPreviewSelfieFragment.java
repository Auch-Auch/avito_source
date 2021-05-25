package com.sumsub.sns.presentation.screen.preview.selfie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.sumsub.sns.R;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSLivenessResult;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment;
import com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b<\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u00104\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieFragment;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewFragment;", "Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "()V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "tvSubtitle", "getTvSubtitle", "setTvSubtitle", "Landroid/widget/Button;", "btnTakeAnotherVideo", "Landroid/widget/Button;", "getBtnTakeAnotherVideo", "()Landroid/widget/Button;", "setBtnTakeAnotherVideo", "(Landroid/widget/Button;)V", "btnReadableVideo", "getBtnReadableVideo", "setBtnReadableVideo", "Landroidx/constraintlayout/widget/Group;", "gContent", "Landroidx/constraintlayout/widget/Group;", "getGContent", "()Landroidx/constraintlayout/widget/Group;", "setGContent", "(Landroidx/constraintlayout/widget/Group;)V", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel;", "viewModel", "Lcom/google/android/exoplayer2/ui/PlayerView;", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "getPlayerView", "()Lcom/google/android/exoplayer2/ui/PlayerView;", "setPlayerView", "(Lcom/google/android/exoplayer2/ui/PlayerView;)V", "<init>", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewSelfieFragment extends SNSBaseDocumentPreviewFragment<SNSPreviewSelfieViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "PreviewSelfieFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSPreviewSelfieViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$$special$$inlined$viewModels$2
        public final /* synthetic */ Function0 a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.a.invoke()).getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }, new b(this));
    @BindView(2076)
    public Button btnReadableVideo;
    @BindView(2081)
    public Button btnTakeAnotherVideo;
    @BindView(2206)
    public Group gContent;
    @BindView(2343)
    public PlayerView playerView;
    @BindView(2481)
    public TextView tvSubtitle;
    @BindView(2483)
    public TextView tvTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieFragment$Companion;", "", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/data/model/Document;", "document", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/common/SNSSession;Lcom/sumsub/sns/core/data/model/Document;)Landroidx/fragment/app/Fragment;", "", "REQUEST_ID_LIVENESS", "I", "REQUEST_ID_VIDEO_SELFIE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull SNSSession sNSSession, @NotNull Document document) {
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            Intrinsics.checkNotNullParameter(document, "document");
            SNSPreviewSelfieFragment sNSPreviewSelfieFragment = new SNSPreviewSelfieFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            bundle.putParcelable(SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, document);
            Unit unit = Unit.INSTANCE;
            sNSPreviewSelfieFragment.setArguments(bundle);
            return sNSPreviewSelfieFragment;
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
                ((SNSPreviewSelfieFragment) this.b).getViewModel().onDataIsReadableClicked(0);
            } else if (i == 1) {
                ((SNSPreviewSelfieFragment) this.b).getViewModel().onTakeAnotherDataClicked();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSPreviewSelfieFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSPreviewSelfieFragment sNSPreviewSelfieFragment) {
            super(0);
            this.a = sNSPreviewSelfieFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSPreviewSelfieFragment sNSPreviewSelfieFragment = this.a;
            return new SNSPreviewSelfieViewModelFactory(sNSPreviewSelfieFragment, sNSPreviewSelfieFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @NotNull
    public final Button getBtnReadableVideo() {
        Button button = this.btnReadableVideo;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnReadableVideo");
        }
        return button;
    }

    @NotNull
    public final Button getBtnTakeAnotherVideo() {
        Button button = this.btnTakeAnotherVideo;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeAnotherVideo");
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

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_preview_selfie;
    }

    @NotNull
    public final PlayerView getPlayerView() {
        PlayerView playerView2 = this.playerView;
        if (playerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        }
        return playerView2;
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

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSPreviewSelfieViewModel getViewModel() {
        return (SNSPreviewSelfieViewModel) this.b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        SNSLivenessReason sNSLivenessReason = null;
        File file = null;
        if (i == 1) {
            SNSLivenessResult.FaceDetection faceDetection = intent != null ? (SNSLivenessResult.FaceDetection) intent.getParcelableExtra("EXTRA_RESULT") : null;
            SNSPreviewSelfieViewModel viewModel = getViewModel();
            if (faceDetection != null) {
                sNSLivenessReason = faceDetection.getReason();
            }
            viewModel.onHandleLiveness(sNSLivenessReason);
        } else if (i == 2) {
            String stringExtra = intent != null ? intent.getStringExtra(SNSVideoSelfieActivity.EXTRA_FILE) : null;
            String stringExtra2 = intent != null ? intent.getStringExtra(SNSVideoSelfieActivity.EXTRA_PHRASE) : null;
            SNSPreviewSelfieViewModel viewModel2 = getViewModel();
            if (!(stringExtra == null || stringExtra.length() == 0)) {
                z = false;
            }
            if (!z) {
                file = new File(stringExtra);
            }
            viewModel2.onHandleVideoSelfie(file, stringExtra2);
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PlayerView playerView2 = this.playerView;
        if (playerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        }
        Player player = playerView2.getPlayer();
        if (player != null) {
            player.release();
        }
        super.onDestroyView();
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView.setText(getTextResource(R.string.sns_preview_video_title));
        TextView textView2 = this.tvSubtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        textView2.setText(getTextResource(R.string.sns_preview_video_subtitle));
        Button button = this.btnReadableVideo;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnReadableVideo");
        }
        button.setText(getTextResource(R.string.sns_preview_video_action_accept));
        Button button2 = this.btnTakeAnotherVideo;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeAnotherVideo");
        }
        button2.setText(getTextResource(R.string.sns_preview_video_action_retake));
        Button button3 = this.btnReadableVideo;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnReadableVideo");
        }
        button3.setOnClickListener(new a(0, this));
        Button button4 = this.btnTakeAnotherVideo;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeAnotherVideo");
        }
        button4.setOnClickListener(new a(1, this));
        LiveData<Boolean> showContent = getViewModel().getShowContent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showContent.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSPreviewSelfieFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getGContent().setVisibility(t.booleanValue() ? 0 : 8);
                }
            }
        });
        LiveData<Boolean> showProgress = getViewModel().getShowProgress();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showProgress.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSPreviewSelfieFragment a;

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
        LiveData<Event<SNSPreviewSelfieViewModel.VideoParams>> showVideoSelfiePicker = getViewModel().getShowVideoSelfiePicker();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        showVideoSelfiePicker.observe(viewLifecycleOwner3, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSPreviewSelfieFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSPreviewSelfieFragment sNSPreviewSelfieFragment = this.a;
                    SNSVideoSelfieActivity.Companion companion = SNSVideoSelfieActivity.Companion;
                    Context requireContext = sNSPreviewSelfieFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    sNSPreviewSelfieFragment.startActivityForResult(companion.newIntent(requireContext, this.a.getSession(), ((SNSPreviewSelfieViewModel.VideoParams) contentIfNotHandled).getDocument()), 2);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<File> videoSelfie = getViewModel().getVideoSelfie();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        videoSelfie.observe(viewLifecycleOwner4, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment$onViewCreated$$inlined$observe$3
            public final /* synthetic */ SNSPreviewSelfieFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(this.a.getContext(), "ExoPlayer-local")).createMediaSource(Uri.parse(t.getAbsolutePath()));
                    SimpleExoPlayer build = new SimpleExoPlayer.Builder(this.a.requireContext()).build();
                    Intrinsics.checkNotNullExpressionValue(build, "SimpleExoPlayer.Builder(requireContext()).build()");
                    this.a.getPlayerView().setPlayer(build);
                    build.prepare(createMediaSource);
                }
            }
        });
    }

    public final void setBtnReadableVideo(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnReadableVideo = button;
    }

    public final void setBtnTakeAnotherVideo(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnTakeAnotherVideo = button;
    }

    public final void setGContent(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, "<set-?>");
        this.gContent = group;
    }

    public final void setPlayerView(@NotNull PlayerView playerView2) {
        Intrinsics.checkNotNullParameter(playerView2, "<set-?>");
        this.playerView = playerView2;
    }

    public final void setTvSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubtitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }
}
