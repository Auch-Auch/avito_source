package com.avito.android.messenger.conversation.adapter.text;

import a2.b.a.a.a;
import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.messenger.conversation.adapter.HighlightableKt;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.text.TextMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.ui_components.R;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Uris;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0017\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u0018J+\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n \"*\u0004\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010#R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010/R\u001e\u0010:\u001a\n \"*\u0004\u0018\u000107078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "onUnbind", "()V", "", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "textList", "Lkotlin/Function1;", "", "onOpenInBrowser", "setMessage", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLinkLongClickListener", "(Lkotlin/jvm/functions/Function1;)V", "showCopiedMessage", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "chunk", AuthSource.SEND_ABUSE, "(Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", "e", "Lkotlin/jvm/functions/Function1;", "linkLongClickListener", "", "Landroid/widget/TextView;", g.a, "Ljava/util/List;", "textViews", "", AuthSource.BOOKING_ORDER, "F", "defaultTextSize", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "messageBody", "c", "emojiTextSize", "Landroid/view/LayoutInflater;", "f", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/animation/ValueAnimator;", "h", "Landroid/animation/ValueAnimator;", "animation", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class TextMessageViewDelegate implements TextMessageView, MessageViewClicks {
    public final Context a;
    public final float b;
    public final float c;
    public final LinearLayout d;
    public Function1<? super String, Unit> e;
    public final LayoutInflater f;
    public final List<TextView> g = new ArrayList();
    public ValueAnimator h;
    public final View i;
    public final /* synthetic */ MessageViewClicksDelegate j;

    public TextMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.j = new MessageViewClicksDelegate(view);
        this.i = view;
        this.a = view.getContext();
        float dimensionPixelSize = (float) view.getResources().getDimensionPixelSize(R.dimen.big_text_size);
        this.b = dimensionPixelSize;
        this.c = dimensionPixelSize * 4.0f;
        View findViewById = view.findViewById(com.avito.android.messenger.R.id.message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message)");
        this.d = (LinearLayout) findViewById;
        this.f = LayoutInflater.from(view.getContext());
    }

    public final void a(TextMessageView.TextChunk textChunk, Function1<? super String, Unit> function1) {
        TextView textView;
        String t;
        if (textChunk instanceof TextMessageView.TextChunk.Link) {
            CharSequence text = textChunk.getText();
            View inflate = this.f.inflate(com.avito.android.messenger.R.layout.messenger_text_bubble_body_link_text_view, (ViewGroup) this.d, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            textView = (TextView) inflate;
            String obj = text.toString();
            String[] url_schemes = Uris.getURL_SCHEMES();
            int length = url_schemes.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    t = a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], obj);
                    break;
                }
                String str = url_schemes[i2];
                if (!m.startsWith(obj, str, true)) {
                    i2++;
                } else if (!m.startsWith(obj, str, false)) {
                    StringBuilder L = a.L(str);
                    String substring = obj.substring(str.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    L.append(substring);
                    t = L.toString();
                } else {
                    t = obj;
                }
            }
            textView.setOnClickListener(new View.OnClickListener(t) { // from class: com.avito.android.messenger.conversation.adapter.text.TextMessageViewDelegate$createLinkTextView$1
                public final /* synthetic */ String b;

                {
                    this.b = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1.this.invoke(this.b);
                }
            });
            textView.setText(new Regex(".(?!$)").replace(obj, "$0​"));
            textView.setOnLongClickListener(new View.OnLongClickListener(t) { // from class: com.avito.android.messenger.conversation.adapter.text.TextMessageViewDelegate$createLinkTextView$2
                public final /* synthetic */ String b;

                {
                    this.b = r2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    if (TextMessageViewDelegate.this.e == null) {
                        return false;
                    }
                    Function1 function12 = TextMessageViewDelegate.this.e;
                    if (function12 != null) {
                        Unit unit = (Unit) function12.invoke(this.b);
                    }
                    return true;
                }
            });
        } else if (textChunk instanceof TextMessageView.TextChunk.Text) {
            CharSequence text2 = textChunk.getText();
            View inflate2 = this.f.inflate(com.avito.android.messenger.R.layout.messenger_text_bubble_body_plain_text_view, (ViewGroup) this.d, false);
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.widget.TextView");
            textView = (TextView) inflate2;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(text2);
            textView.setOnClickListener(TextMessageViewDelegate$createPlainTextView$1.INSTANCE);
            textView.setOnLongClickListener(TextMessageViewDelegate$createPlainTextView$2.INSTANCE);
        } else if (textChunk instanceof TextMessageView.TextChunk.Emoji) {
            CharSequence text3 = textChunk.getText();
            View inflate3 = this.f.inflate(com.avito.android.messenger.R.layout.messenger_text_bubble_body_plain_text_view, (ViewGroup) this.d, false);
            Objects.requireNonNull(inflate3, "null cannot be cast to non-null type android.widget.TextView");
            textView = (TextView) inflate3;
            textView.setTextSize(0, this.c);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(text3);
            textView.setOnClickListener(TextMessageViewDelegate$createPlainTextView$1.INSTANCE);
            textView.setOnLongClickListener(TextMessageViewDelegate$createPlainTextView$2.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setId(View.generateViewId());
        this.d.addView(textView, -2, -2);
        this.g.add(textView);
    }

    @Override // com.avito.android.messenger.conversation.adapter.Highlightable
    public void highlight(boolean z) {
        ValueAnimator valueAnimator;
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.mutate();
            ValueAnimator valueAnimator2 = this.h;
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
            this.h = valueAnimator;
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.h = null;
        TextMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.setClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView
    public void setLinkLongClickListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e = function1;
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.setLongClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView
    public void setMessage(@NotNull List<? extends TextMessageView.TextChunk> list, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "textList");
        Intrinsics.checkNotNullParameter(function1, "onOpenInBrowser");
        List<TextView> list2 = this.g;
        LinearLayout linearLayout = this.d;
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            linearLayout.removeView(it.next());
        }
        this.g.clear();
        if (list.size() == 1) {
            a((TextMessageView.TextChunk) list.get(0), function1);
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            a(it2.next(), function1);
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView
    public void showCopiedMessage() {
        Context context = this.i.getContext();
        if (context != null) {
            ToastsKt.showToast$default(context, com.avito.android.messenger.R.string.text_is_copied, 0, 2, (Object) null);
        }
    }
}
