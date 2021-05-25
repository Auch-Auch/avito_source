package com.sumsub.sns.camera.video.presentation;

import androidx.lifecycle.Observer;
import com.sumsub.sns.camera.video.R;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieViewModel;
import com.sumsub.sns.core.presentation.base.Event;
import kotlin.Metadata;
import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lcom/sumsub/sns/core/presentation/base/Event;", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Lcom/sumsub/sns/core/presentation/base/Event;)V", "com/sumsub/sns/core/common/ExtensionsKt$observeEvent$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1<T> implements Observer<Event<? extends T>> {
    public final /* synthetic */ SNSVideoSelfieActivity a;

    /* compiled from: java-style lambda group */
    public static final class a implements AnimationListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // pl.droidsonroids.gif.AnimationListener
        public final void onAnimationCompleted(int i) {
            int i2 = this.a;
            if (i2 == 0) {
                ((SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1) this.b).a.getViewModel().onCountdownFinished();
            } else if (i2 == 1) {
                ((SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1) this.b).a.getViewModel().onRecordingFinished();
            } else if (i2 == 2) {
                ((SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1) this.b).a.getViewModel().onFileCreated();
            } else {
                throw null;
            }
        }
    }

    public SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1(SNSVideoSelfieActivity sNSVideoSelfieActivity) {
        this.a = sNSVideoSelfieActivity;
    }

    public final void onChanged(Event<? extends T> event) {
        Object contentIfNotHandled;
        GifDrawable gifDrawable;
        if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
            int ordinal = ((SNSVideoSelfieViewModel.State) contentIfNotHandled).ordinal();
            if (ordinal == 1) {
                gifDrawable = new GifDrawable(this.a.getResources(), R.drawable.sns_gif_countdown);
                gifDrawable.addAnimationListener(new a(0, this));
            } else if (ordinal == 2) {
                gifDrawable = new GifDrawable(this.a.getResources(), R.drawable.sns_gif_recording);
                gifDrawable.addAnimationListener(new a(1, this));
            } else if (ordinal != 3) {
                gifDrawable = null;
            } else {
                gifDrawable = new GifDrawable(this.a.getResources(), R.drawable.sns_gif_done);
                gifDrawable.addAnimationListener(new a(2, this));
            }
            if (gifDrawable != null) {
                gifDrawable.setLoopCount(1);
                gifDrawable.seekToFrame(gifDrawable.getCurrentFrameIndex());
            }
            this.a.getGifView().setImageDrawable(gifDrawable);
        }
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((Event) ((Event) obj));
    }
}
