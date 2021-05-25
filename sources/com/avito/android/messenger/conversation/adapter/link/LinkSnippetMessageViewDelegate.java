package com.avito.android.messenger.conversation.adapter.link;

import a2.g.r.g;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.BottomSheetsKt$showLinkBottomSheetMenuDialog$1;
import com.avito.android.messenger.conversation.adapter.HighlightableKt;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView;
import com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageViewDelegate;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010F\u001a\u00020B\u0012\u0006\u0010G\u001a\u00020B¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u001e\u0010\u001e\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010 \u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0001¢\u0006\u0004\b \u0010\u001fR\u001e\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00100R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00100R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "onUnbind", "()V", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "", "title", MessengerShareContentUtility.SUBTITLE, "setText", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "domain", "setDomain", "(Ljava/lang/String;)V", "url", "Lkotlin/Function0;", "onOpenInBrowserClick", "onCopyClick", "showLinkMenuLegacy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "showCopiedMessage", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/app/Dialog;", "h", "Landroid/app/Dialog;", "menuDialog", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTextView", "", "i", "I", "menuDialogPeekHeight", "e", "subtitleTextView", "Landroid/animation/ValueAnimator;", "j", "Landroid/animation/ValueAnimator;", "animation", "f", "domainTextView", "Landroid/graphics/drawable/Drawable;", g.a, "Landroid/graphics/drawable/Drawable;", "imagePlaceHolder", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "messageBody", "view", "parentView", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSnippetMessageViewDelegate implements LinkSnippetMessageView, MessageViewClicks {
    public final Context a;
    public final View b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final Drawable g;
    public Dialog h;
    public int i = -1;
    public ValueAnimator j;
    public final /* synthetic */ MessageViewClicksDelegate k;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(1);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(View view) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(view, "it");
                ((Function0) this.c).invoke();
                Dialog dialog = ((LinkSnippetMessageViewDelegate) this.b).h;
                if (dialog != null) {
                    dialog.dismiss();
                }
                ((LinkSnippetMessageViewDelegate) this.b).h = null;
                return Unit.INSTANCE;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(view, "it");
                ((Function0) this.c).invoke();
                Dialog dialog2 = ((LinkSnippetMessageViewDelegate) this.b).h;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                ((LinkSnippetMessageViewDelegate) this.b).h = null;
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public LinkSnippetMessageViewDelegate(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(view2, "parentView");
        this.k = new MessageViewClicksDelegate(view);
        Context context = view.getContext();
        this.a = context;
        View findViewById = view.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message)");
        this.b = findViewById;
        View findViewById2 = view.findViewById(R.id.message_link_snippet_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.message_link_snippet_image)");
        this.c = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.message_link_snippet_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.message_link_snippet_title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.message_link_snippet_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.m…ge_link_snippet_subtitle)");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.message_link_snippet_domain);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.m…sage_link_snippet_domain)");
        this.f = (TextView) findViewById5;
        this.g = context.getDrawable(R.drawable.ic_messenger_link_snippet_image_placeholder);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(view2, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.y.b.a
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return Integer.valueOf(((LinkSnippetMessageViewDelegate) this.receiver).i);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((LinkSnippetMessageViewDelegate) this.receiver).i = ((Number) obj).intValue();
            }
        }) { // from class: com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageViewDelegate$$special$$inlined$initializeLinkBottomSheetPeekHeight$1
            public final /* synthetic */ View a;
            public final /* synthetic */ KMutableProperty0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "rootView.viewTreeObserver");
                ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                Context context2 = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
                this.b.set(Integer.valueOf((Contexts.getDisplayHeight(context2) * 2) / 3));
            }
        });
    }

    @Override // com.avito.android.messenger.conversation.adapter.Highlightable
    public void highlight(boolean z) {
        Drawable drawable;
        ValueAnimator valueAnimator;
        Drawable background = this.b.getBackground();
        if (!(background instanceof LayerDrawable)) {
            background = null;
        }
        LayerDrawable layerDrawable = (LayerDrawable) background;
        if (layerDrawable == null || (drawable = layerDrawable.findDrawableByLayerId(R.id.background)) == null) {
            drawable = this.b.getBackground();
        }
        if (drawable != null) {
            drawable.mutate();
            ValueAnimator valueAnimator2 = this.j;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            if (z) {
                Context context = this.a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                valueAnimator = HighlightableKt.animateColor(drawable, context, com.avito.android.lib.design.R.attr.oldBackground, com.avito.android.lib.design.R.attr.gray12);
            } else {
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                valueAnimator = HighlightableKt.animateColor(drawable, context2, com.avito.android.lib.design.R.attr.blue50, com.avito.android.lib.design.R.attr.blue200);
            }
            this.j = valueAnimator;
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.j = null;
        LinkSnippetMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k.setClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
    public void setDomain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "domain");
        this.f.setText(str);
    }

    @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
    public void setImage(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.c, picture, this.g, null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k.setLongClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
    public void setText(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        if (str2 == null || m.isBlank(str2)) {
            this.d.setSingleLine(false);
            this.d.setMaxLines(2);
            Views.hide(this.e);
        } else {
            this.d.setSingleLine(true);
            this.d.setMaxLines(1);
            this.e.setText(str2);
            Views.show(this.e);
        }
        this.d.setText(str);
    }

    @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
    public void showCopiedMessage() {
        Context context = this.a;
        if (context != null) {
            ToastsKt.showToast$default(context, R.string.text_is_copied, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
    public void showLinkMenuLegacy(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        BottomSheetMenuDialog bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(function0, "onOpenInBrowserClick");
        Intrinsics.checkNotNullParameter(function02, "onCopyClick");
        Context context = this.a;
        if (context != null) {
            bottomSheetMenuDialog = new BottomSheetMenuDialog(context, new BottomSheetsKt$showLinkBottomSheetMenuDialog$1(context, str, new a(0, this, function0), new a(1, this, function02), this.i));
        } else {
            bottomSheetMenuDialog = null;
        }
        this.h = bottomSheetMenuDialog;
    }
}
