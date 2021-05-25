package com.avito.android.blueprints.publish.html_editor;

import a2.g.r.g;
import android.text.Selection;
import android.text.Spannable;
import com.avito.android.html_editor.HtmlInteractor;
import com.avito.android.html_editor.InputOperationFactoryImpl;
import com.avito.android.html_editor.RenderedHistorySnapshot;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithHtmlSupport;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B]\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0017\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/FormatHistoryNavigationObserver;", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/html_editor/RenderedHistorySnapshot;", "snapshot", "", "accept", "(Lcom/avito/android/html_editor/RenderedHistorySnapshot;)V", "Lcom/avito/android/items/BasicInputItem;", "e", "Lio/reactivex/functions/Consumer;", "valueChangesStream", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "f", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "Lkotlin/Function0;", g.a, "Lkotlin/jvm/functions/Function0;", "onBeforeHtmlChangedListener", "Lcom/avito/android/html_editor/HtmlInteractor;", "c", "Lcom/avito/android/html_editor/HtmlInteractor;", "htmlInteractor", "Lkotlin/Function2;", "", "", "d", "Lkotlin/jvm/functions/Function2;", "htmlChangeListener", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "view", "Lcom/avito/android/items/ItemWithHtmlSupport;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/items/ItemWithHtmlSupport;", "item", "<init>", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;Lcom/avito/android/items/ItemWithHtmlSupport;Lcom/avito/android/html_editor/HtmlInteractor;Lkotlin/jvm/functions/Function2;Lio/reactivex/functions/Consumer;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;Lkotlin/jvm/functions/Function0;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class FormatHistoryNavigationObserver implements Consumer<RenderedHistorySnapshot> {
    public final HtmlEditorItemView a;
    public final ItemWithHtmlSupport b;
    public final HtmlInteractor c;
    public final Function2<CharSequence, String, Unit> d;
    public final Consumer<BasicInputItem> e;
    public final HtmlEditorViewModel f;
    public final Function0<Unit> g;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.CharSequence, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FormatHistoryNavigationObserver(@NotNull HtmlEditorItemView htmlEditorItemView, @NotNull ItemWithHtmlSupport itemWithHtmlSupport, @NotNull HtmlInteractor htmlInteractor, @NotNull Function2<? super CharSequence, ? super String, Unit> function2, @NotNull Consumer<BasicInputItem> consumer, @NotNull HtmlEditorViewModel htmlEditorViewModel, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(htmlEditorItemView, "view");
        Intrinsics.checkNotNullParameter(itemWithHtmlSupport, "item");
        Intrinsics.checkNotNullParameter(htmlInteractor, "htmlInteractor");
        Intrinsics.checkNotNullParameter(function2, "htmlChangeListener");
        Intrinsics.checkNotNullParameter(consumer, "valueChangesStream");
        Intrinsics.checkNotNullParameter(htmlEditorViewModel, "htmlEditorViewModel");
        Intrinsics.checkNotNullParameter(function0, "onBeforeHtmlChangedListener");
        this.a = htmlEditorItemView;
        this.b = itemWithHtmlSupport;
        this.c = htmlInteractor;
        this.d = function2;
        this.e = consumer;
        this.f = htmlEditorViewModel;
        this.g = function0;
    }

    public void accept(@NotNull RenderedHistorySnapshot renderedHistorySnapshot) {
        Intrinsics.checkNotNullParameter(renderedHistorySnapshot, "snapshot");
        this.a.removeTextWatcher();
        Spannable spannable = null;
        this.a.setOnSelectionChangedListener(null);
        this.b.setValue(renderedHistorySnapshot.getValue());
        this.b.setHtmlRootNode(renderedHistorySnapshot.getRootNode());
        this.a.setValue(renderedHistorySnapshot.getRenderedValue());
        HtmlEditorSelectionListener htmlEditorSelectionListener = new HtmlEditorSelectionListener(renderedHistorySnapshot.getSelectionStart(), renderedHistorySnapshot.getSelectionEnd(), this.c, this.f);
        this.a.setOnSelectionChangedListener(new Function3<CharSequence, Integer, Integer, Unit>(htmlEditorSelectionListener) { // from class: com.avito.android.blueprints.publish.html_editor.FormatHistoryNavigationObserver.a
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
        HtmlEditorItemView htmlEditorItemView = this.a;
        htmlEditorItemView.setTextWatcher(new HtmlEditorTextWatcher(htmlEditorItemView, renderedHistorySnapshot.getRootNode(), new InputOperationFactoryImpl(), this.c, this.d, this.g, htmlEditorSelectionListener));
        CharSequence text = this.a.getText();
        if (text instanceof Spannable) {
            spannable = text;
        }
        Spannable spannable2 = spannable;
        if (spannable2 != null) {
            Selection.setSelection(spannable2, e.coerceIn(renderedHistorySnapshot.getSelectionStart(), 0, spannable2.length()), e.coerceIn(renderedHistorySnapshot.getSelectionEnd(), 0, spannable2.length()));
            this.e.accept(this.b);
        }
    }
}
