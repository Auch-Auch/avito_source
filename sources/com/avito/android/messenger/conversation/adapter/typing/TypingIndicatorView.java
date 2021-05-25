package com.avito.android.messenger.conversation.adapter.typing;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatarDelegate;
import com.avito.android.util.Contexts;
import com.avito.android.util.GlobalAnimationsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "", "startAnimations", "()V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface TypingIndicatorView extends ItemView, MessageViewAvatar {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TypingIndicatorView typingIndicatorView) {
            ItemView.DefaultImpls.onUnbind(typingIndicatorView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "startAnimations", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/animation/AnimatorSet;", "u", "Landroid/animation/AnimatorSet;", "animations", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "t", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "animationInterpolator", "", "kotlin.jvm.PlatformType", "s", "[Landroid/view/View;", "dots", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements TypingIndicatorView, MessageViewAvatar {
        public final View[] s;
        public final AccelerateDecelerateInterpolator t = new AccelerateDecelerateInterpolator();
        public AnimatorSet u;
        public final View v;
        public final /* synthetic */ MessageViewAvatarDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.w = new MessageViewAvatarDelegate(view);
            this.v = view;
            View[] viewArr = {view.findViewById(R.id.dot1), view.findViewById(R.id.dot2), view.findViewById(R.id.dot3)};
            this.s = viewArr;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            Paint paint = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            paint.setColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue600));
            Paint paint2 = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "paint");
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint3, "paint");
            paint3.setAntiAlias(true);
            for (View view2 : viewArr) {
                Intrinsics.checkNotNullExpressionValue(view2, "dot");
                view2.setBackground(shapeDrawable);
            }
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            AnimatorSet animatorSet = this.u;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.u = null;
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatar(@Nullable Picture picture) {
            this.w.setAvatar(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.w.setAvatarClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorView
        public void startAnimations() {
            AnimatorSet animatorSet = this.u;
            int i = 1;
            if (animatorSet == null || !animatorSet.isRunning()) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                View[] viewArr = this.s;
                int length = viewArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    View view = viewArr[i2];
                    int i4 = i3 + 1;
                    long length2 = (long) ((((float) (((long) i3) * 1200)) / ((float) this.s.length)) / ((float) 2));
                    Animator[] animatorArr = new Animator[i];
                    Intrinsics.checkNotNullExpressionValue(view, "dot");
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", Arrays.copyOf(new float[]{0.4f, 1.0f, 0.4f, 0.4f, 0.4f, 0.4f, 0.4f}, 7));
                    ofFloat.setDuration(1200L);
                    ofFloat.setStartDelay(length2);
                    GlobalAnimationsKt.setSafeRepeatCount(ofFloat, -1);
                    ofFloat.setRepeatMode(i);
                    ofFloat.setInterpolator(this.t);
                    Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(t…polator\n                }");
                    animatorArr[0] = ofFloat;
                    animatorSet2.playTogether(animatorArr);
                    Animator[] animatorArr2 = new Animator[i];
                    Resources resources = view.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "dot.resources");
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", Arrays.copyOf(new float[]{0.0f, (-resources.getDisplayMetrics().density) * ((float) 4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 7));
                    ofFloat2.setDuration(1200L);
                    ofFloat2.setStartDelay(length2);
                    GlobalAnimationsKt.setSafeRepeatCount(ofFloat2, -1);
                    ofFloat2.setRepeatMode(1);
                    ofFloat2.setInterpolator(this.t);
                    Intrinsics.checkNotNullExpressionValue(ofFloat2, "ObjectAnimator.ofFloat(t…polator\n                }");
                    animatorArr2[0] = ofFloat2;
                    animatorSet2.playTogether(animatorArr2);
                    i2++;
                    i3 = i4;
                    i = 1;
                }
                animatorSet2.start();
                Unit unit = Unit.INSTANCE;
                this.u = animatorSet2;
            }
        }
    }

    void startAnimations();
}
