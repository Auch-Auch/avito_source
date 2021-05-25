package com.avito.android.messenger.conversation.adapter.platform;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.model.VKApiCommunityFull;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\u0017J'\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/LinkArrowKeyMovementMethod;", "Landroid/text/method/ArrowKeyMovementMethod;", "Landroid/widget/TextView;", "widget", "Landroid/text/Spannable;", "text", "", "initialize", "(Landroid/widget/TextView;Landroid/text/Spannable;)V", "view", "", "dir", "onTakeFocus", "(Landroid/widget/TextView;Landroid/text/Spannable;I)V", "buffer", "keyCode", "movementMetaState", "Landroid/view/KeyEvent;", "event", "", "handleMovementKey", "(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z", "up", "(Landroid/widget/TextView;Landroid/text/Spannable;)Z", "down", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "Landroid/view/MotionEvent;", "onTouchEvent", "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "what", AuthSource.SEND_ABUSE, "(ILandroid/widget/TextView;Landroid/text/Spannable;)Z", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LinkArrowKeyMovementMethod extends ArrowKeyMovementMethod {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final NoCopySpan.Concrete a = new NoCopySpan.Concrete();
    @NotNull
    public static final Lazy b = c.lazy(LazyThreadSafetyMode.NONE, (Function0) a.a);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/LinkArrowKeyMovementMethod$Companion;", "", "Lcom/avito/android/messenger/conversation/adapter/platform/LinkArrowKeyMovementMethod;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/avito/android/messenger/conversation/adapter/platform/LinkArrowKeyMovementMethod;", "instance", "", "CLICK", "I", "DOWN", "Landroid/text/NoCopySpan$Concrete;", "FROM_BELOW", "Landroid/text/NoCopySpan$Concrete;", "UP", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LinkArrowKeyMovementMethod getInstance() {
            Lazy lazy = LinkArrowKeyMovementMethod.b;
            Companion companion = LinkArrowKeyMovementMethod.Companion;
            return (LinkArrowKeyMovementMethod) lazy.getValue();
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<LinkArrowKeyMovementMethod> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LinkArrowKeyMovementMethod invoke() {
            return new LinkArrowKeyMovementMethod();
        }
    }

    public final boolean a(int i, TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int totalPaddingBottom = textView.getTotalPaddingBottom() + textView.getTotalPaddingTop();
        int scrollY = textView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int lineForVertical2 = layout.getLineForVertical((textView.getHeight() + scrollY) - totalPaddingBottom);
        int lineStart = layout.getLineStart(lineForVertical);
        int lineEnd = layout.getLineEnd(lineForVertical2);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(lineStart, lineEnd, ClickableSpan.class);
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        if (min < 0 && spannable.getSpanStart(a) >= 0) {
            min = spannable.length();
            max = min;
        }
        if (min > lineEnd) {
            max = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
        }
        int i2 = -1;
        if (max < lineStart) {
            max = -1;
            min = -1;
        }
        if (i != 1) {
            if (i == 2) {
                Intrinsics.checkNotNullExpressionValue(clickableSpanArr, "candidates");
                int length = clickableSpanArr.length;
                int i3 = -1;
                for (int i4 = 0; i4 < length; i4++) {
                    int spanEnd = spannable.getSpanEnd(clickableSpanArr[i4]);
                    if ((spanEnd < max || min == max) && spanEnd > i3) {
                        i2 = spannable.getSpanStart(clickableSpanArr[i4]);
                        i3 = spanEnd;
                    }
                }
                if (i2 >= 0) {
                    Selection.setSelection(spannable, i3, i2);
                    return true;
                }
            } else if (i == 3) {
                Intrinsics.checkNotNullExpressionValue(clickableSpanArr, "candidates");
                int length2 = clickableSpanArr.length;
                int i5 = Integer.MAX_VALUE;
                int i6 = Integer.MAX_VALUE;
                for (int i7 = 0; i7 < length2; i7++) {
                    int spanStart = spannable.getSpanStart(clickableSpanArr[i7]);
                    if ((spanStart > min || min == max) && spanStart < i6) {
                        i5 = spannable.getSpanEnd(clickableSpanArr[i7]);
                        i6 = spanStart;
                    }
                }
                if (i5 < Integer.MAX_VALUE) {
                    Selection.setSelection(spannable, i6, i5);
                    return true;
                }
            }
        } else if (min == max) {
            return false;
        } else {
            ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(min, max, ClickableSpan.class);
            if (clickableSpanArr2.length != 1) {
                return false;
            }
            clickableSpanArr2[0].onClick(textView);
        }
        return false;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    public boolean down(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        if (a(3, textView, spannable)) {
            return true;
        }
        return super.down(textView, spannable);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    public boolean handleMovementKey(@NotNull TextView textView, @NotNull Spannable spannable, int i, int i2, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if ((i == 23 || i == 66) && KeyEvent.metaStateHasNoModifiers(i2) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && a(1, textView, spannable)) {
            return true;
        }
        return super.handleMovementKey(textView, spannable, i, i2, keyEvent);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "text");
        super.initialize(textView, spannable);
        spannable.removeSpan(a);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    public boolean left(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        if (a(2, textView, spannable)) {
            return true;
        }
        return super.left(textView, spannable);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(@NotNull TextView textView, @NotNull Spannable spannable, int i) {
        Intrinsics.checkNotNullParameter(textView, "view");
        Intrinsics.checkNotNullParameter(spannable, "text");
        super.onTakeFocus(textView, spannable, i);
        if ((i & 1) != 0) {
            spannable.setSpan(a, 0, 0, 34);
        } else {
            spannable.removeSpan(a);
        }
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(@NotNull TextView textView, @NotNull Spannable spannable, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX() + x;
            int scrollY = textView.getScrollY() + y;
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(objArr, VKApiCommunityFull.LINKS);
            if (!(objArr.length == 0)) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    public boolean right(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        if (a(3, textView, spannable)) {
            return true;
        }
        return super.right(textView, spannable);
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    public boolean up(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        Intrinsics.checkNotNullParameter(spannable, "buffer");
        if (a(2, textView, spannable)) {
            return true;
        }
        return super.up(textView, spannable);
    }
}
