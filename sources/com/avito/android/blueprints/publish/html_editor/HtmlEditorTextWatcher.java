package com.avito.android.blueprints.publish.html_editor;

import a2.g.r.g;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import com.avito.android.html_editor.HtmlInteractor;
import com.avito.android.html_editor.InputOperationFactory;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.span.HtmlSpan;
import com.avito.android.html_formatter.span.NodeSpan;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u00128\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b00\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b8\u00109J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012RH\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\b008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorTextWatcher;", "Landroid/text/TextWatcher;", "", "text", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "d", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "rendered", "", "html", g.a, "Lkotlin/jvm/functions/Function2;", "htmlChangeListener", "Landroid/text/Spannable;", AuthSource.SEND_ABUSE, "Landroid/text/Spannable;", "textBeforeChanges", AuthSource.BOOKING_ORDER, "I", "cursorPosition", "Lcom/avito/android/html_editor/InputOperationFactory;", "e", "Lcom/avito/android/html_editor/InputOperationFactory;", "inputOperationFactory", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "c", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "view", "Lcom/avito/android/html_editor/HtmlInteractor;", "f", "Lcom/avito/android/html_editor/HtmlInteractor;", "htmlInteractor", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "onBeforeHtmlChanged", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorSelectionListener;", "i", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorSelectionListener;", "selectionListener", "<init>", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;Lcom/avito/android/html_formatter/MutableHtmlNode;Lcom/avito/android/html_editor/InputOperationFactory;Lcom/avito/android/html_editor/HtmlInteractor;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorSelectionListener;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorTextWatcher implements TextWatcher {
    public Spannable a;
    public int b;
    public final HtmlEditorItemView c;
    public final MutableHtmlNode d;
    public final InputOperationFactory e;
    public final HtmlInteractor f;
    public final Function2<CharSequence, String, Unit> g;
    public final Function0<Unit> h;
    public final HtmlEditorSelectionListener i;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.CharSequence, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public HtmlEditorTextWatcher(@NotNull HtmlEditorItemView htmlEditorItemView, @NotNull MutableHtmlNode mutableHtmlNode, @NotNull InputOperationFactory inputOperationFactory, @NotNull HtmlInteractor htmlInteractor, @Nullable Function2<? super CharSequence, ? super String, Unit> function2, @NotNull Function0<Unit> function0, @NotNull HtmlEditorSelectionListener htmlEditorSelectionListener) {
        Intrinsics.checkNotNullParameter(htmlEditorItemView, "view");
        Intrinsics.checkNotNullParameter(mutableHtmlNode, "rootNode");
        Intrinsics.checkNotNullParameter(inputOperationFactory, "inputOperationFactory");
        Intrinsics.checkNotNullParameter(htmlInteractor, "htmlInteractor");
        Intrinsics.checkNotNullParameter(function0, "onBeforeHtmlChanged");
        Intrinsics.checkNotNullParameter(htmlEditorSelectionListener, "selectionListener");
        this.c = htmlEditorItemView;
        this.d = mutableHtmlNode;
        this.e = inputOperationFactory;
        this.f = htmlInteractor;
        this.g = function2;
        this.h = function0;
        this.i = htmlEditorSelectionListener;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "text");
        if (!Intrinsics.areEqual(String.valueOf(this.a), editable.toString())) {
            this.h.invoke();
            HtmlInteractor htmlInteractor = this.f;
            MutableHtmlNode mutableHtmlNode = this.d;
            Spanned spanned = this.a;
            if (spanned == null) {
                spanned = new SpannableString("");
            }
            HtmlInteractor.OperationResult applyOperationsList = htmlInteractor.applyOperationsList(mutableHtmlNode, spanned, this.e.getOperationsList(editable));
            String component1 = applyOperationsList.component1();
            HtmlCharSequence component2 = applyOperationsList.component2();
            int component3 = applyOperationsList.component3();
            this.a = component2;
            if (Intrinsics.areEqual(editable.toString(), component2.toString())) {
                Object[] spans = editable.getSpans(0, editable.length(), Object.class);
                Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.length, Any::class.java)");
                for (Object obj : spans) {
                    if ((obj instanceof NodeSpan) || (obj instanceof HtmlSpan) || (obj instanceof StyleSpan)) {
                        editable.removeSpan(obj);
                    }
                }
                Object[] spans2 = component2.getSpans(0, component2.length(), Object.class);
                Intrinsics.checkNotNullExpressionValue(spans2, "formattedText.getSpans(0….length, Any::class.java)");
                for (Object obj2 : spans2) {
                    if ((obj2 instanceof NodeSpan) || (obj2 instanceof HtmlSpan) || (obj2 instanceof StyleSpan)) {
                        editable.setSpan(obj2, component2.getSpanStart(obj2), component2.getSpanEnd(obj2), component2.getSpanFlags(obj2));
                    }
                }
            } else {
                this.c.setOnSelectionChangedListener(null);
                this.c.removeTextWatcher();
                this.c.setValue(component2);
                this.c.setTextWatcher(this);
                this.c.setOnSelectionChangedListener(new Function3<CharSequence, Integer, Integer, Unit>(this.i) { // from class: com.avito.android.blueprints.publish.html_editor.HtmlEditorTextWatcher.a
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function3
                    public Unit invoke(CharSequence charSequence, Integer num, Integer num2) {
                        int intValue = num.intValue();
                        int intValue2 = num2.intValue();
                        ((HtmlEditorSelectionListener) this.receiver).onSelectionChanged(charSequence, intValue, intValue2);
                        return Unit.INSTANCE;
                    }
                });
                CharSequence text = this.c.getText();
                Objects.requireNonNull(text, "null cannot be cast to non-null type android.text.Spannable");
                Selection.setSelection((Spannable) text, e.coerceIn(this.b + component3, 0, text.length()));
            }
            Function2<CharSequence, String, Unit> function2 = this.g;
            if (function2 != null) {
                function2.invoke(component2, component1);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.e.beforeTextChanged((Spannable) charSequence, i2, i3, i4);
        if (this.a == null) {
            this.a = new SpannableString(charSequence);
        }
        Spannable spannable = this.a;
        if (spannable != null) {
            Selection.setSelection(spannable, e.coerceIn(Selection.getSelectionStart(charSequence), 0, spannable.length()));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (Intrinsics.areEqual(String.valueOf(this.a), charSequence.toString())) {
            InputOperationFactory inputOperationFactory = this.e;
            if (!(charSequence instanceof Spannable)) {
                charSequence = null;
            }
            inputOperationFactory.clearCachedOperations((Spannable) charSequence);
            return;
        }
        this.b = i2 + i4;
        this.e.onTextChanged((Spannable) charSequence, i2, i3, i4);
    }
}
