package com.avito.android.messenger.conversation.adapter.location;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.HighlightableKt;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.location.LocationMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.ui.widget.WrapWidthTextView;
import com.avito.android.util.ToastsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u001e\u0010\u0015\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0001¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "onUnbind", "()V", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setMapImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "showCopiedText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "Lcom/avito/android/ui/widget/WrapWidthTextView;", "c", "Lcom/avito/android/ui/widget/WrapWidthTextView;", "textView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "mapImage", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "animation", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocationMessageViewDelegate implements LocationMessageView, MessageViewClicks {
    public final Context a;
    public final SimpleDraweeView b;
    public final WrapWidthTextView c;
    public ValueAnimator d;
    public final /* synthetic */ LocationMessageViewClicksDelegate e;

    public LocationMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = new LocationMessageViewClicksDelegate(view);
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.messenger_location_bubble_map_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…ocation_bubble_map_image)");
        this.b = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.messenger_location_bubble_text_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…ocation_bubble_text_text)");
        this.c = (WrapWidthTextView) findViewById2;
    }

    @Override // com.avito.android.messenger.conversation.adapter.Highlightable
    public void highlight(boolean z) {
        ValueAnimator valueAnimator;
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.mutate();
            ValueAnimator valueAnimator2 = this.d;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            if (z) {
                Context context = this.a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                valueAnimator = HighlightableKt.animateColor(background, context, com.avito.android.lib.design.R.attr.oldBackground, com.avito.android.lib.design.R.attr.gray12);
            } else {
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                valueAnimator = HighlightableKt.animateColor(background, context2, com.avito.android.lib.design.R.attr.blue50, com.avito.android.lib.design.R.attr.blue200);
            }
            this.d = valueAnimator;
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.d = null;
        LocationMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setLongClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
    public void setMapImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a.L0(this.b, picture);
    }

    @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.c.setText(charSequence);
    }

    @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
    public void showCopiedText() {
        Context context = this.a;
        if (context != null) {
            ToastsKt.showToast$default(context, R.string.text_is_copied, 0, 2, (Object) null);
        }
    }
}
