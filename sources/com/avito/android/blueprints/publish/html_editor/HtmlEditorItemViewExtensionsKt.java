package com.avito.android.blueprints.publish.html_editor;

import a2.a.a.t.b.a.c;
import a2.a.a.t.b.a.d;
import a2.a.a.t.b.a.e;
import android.text.Selection;
import android.text.Spannable;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorSelectionListener;
import com.avito.android.html_editor.HistorySnapshot;
import com.avito.android.html_editor.HtmlInteractorImpl;
import com.avito.android.html_editor.InputOperationFactoryImpl;
import com.avito.android.html_editor.OperationTreeDisassemblerImpl;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithHtmlSupport;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a£\u0001\u0010\u001d\u001a\u00020\u0001*\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001328\u0010\u001c\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010'\u001a\u00020\u0001*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!28\u0010\u001c\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0002¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "", "removeListeners", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;)V", "Landroid/text/Spannable;", "value", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "htmlRootNode", "Lcom/avito/android/items/ItemWithHtmlSupport;", "item", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", "state", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/items/BasicInputItem;", "valueChangesStream", "Lkotlin/Function1;", "", "focusChangeListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "formattedValue", "", "valueChangeListener", "setupListeners", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;Landroid/text/Spannable;Lcom/avito/android/html_formatter/MutableHtmlNode;Lcom/avito/android/items/ItemWithHtmlSupport;Lcom/avito/android/html_formatter/HtmlRenderOptions;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;Lio/reactivex/functions/Consumer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/html_editor/HtmlInteractorImpl;", "htmlInteractor", "formatted", "html", "Lkotlin/Function0;", "onBeforeHtmlChangedListener", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;Lio/reactivex/disposables/CompositeDisposable;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;Lcom/avito/android/items/ItemWithHtmlSupport;Lcom/avito/android/html_editor/HtmlInteractorImpl;Lkotlin/jvm/functions/Function2;Lio/reactivex/functions/Consumer;Lkotlin/jvm/functions/Function0;)V", "item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class HtmlEditorItemViewExtensionsKt {

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ HtmlEditorItemView a;
        public final /* synthetic */ ItemWithHtmlSupport b;
        public final /* synthetic */ HtmlEditorViewModel c;

        public a(HtmlEditorItemView htmlEditorItemView, ItemWithHtmlSupport itemWithHtmlSupport, HtmlEditorViewModel htmlEditorViewModel) {
            this.a = htmlEditorItemView;
            this.b = itemWithHtmlSupport;
            this.c = htmlEditorViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            CharSequence text = this.a.getText();
            String value = this.b.getValue();
            if (value != null) {
                this.c.onNewSnapshot(new HistorySnapshot(value, Selection.getSelectionStart(text), Selection.getSelectionEnd(text)), false);
            }
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function2 function2) {
            super(1);
            this.a = function2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            this.a.invoke(str2, str2);
            return Unit.INSTANCE;
        }
    }

    public static final void a(HtmlEditorItemView htmlEditorItemView, CompositeDisposable compositeDisposable, HtmlEditorViewModel htmlEditorViewModel, ItemWithHtmlSupport itemWithHtmlSupport, HtmlInteractorImpl htmlInteractorImpl, Function2<? super CharSequence, ? super String, Unit> function2, Consumer<BasicInputItem> consumer, Function0<Unit> function0) {
        compositeDisposable.clear();
        Disposable subscribe = htmlEditorViewModel.itemFormatChangesObservable(itemWithHtmlSupport.getStringId()).subscribe(new FormatObserver(htmlEditorItemView, itemWithHtmlSupport, htmlInteractorImpl, function2, consumer, htmlEditorViewModel, function0));
        Intrinsics.checkNotNullExpressionValue(subscribe, "htmlEditorViewModel.item…dListener\n        )\n    )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = htmlEditorViewModel.itemSnapshotsFromStorageObservable(itemWithHtmlSupport.getStringId()).subscribe(new FormatHistoryNavigationObserver(htmlEditorItemView, itemWithHtmlSupport, htmlInteractorImpl, function2, consumer, htmlEditorViewModel, function0));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "htmlEditorViewModel.item…dListener\n        )\n    )");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = htmlEditorViewModel.itemCreateSnapshotEventsObservable(itemWithHtmlSupport.getStringId()).subscribe(new a(htmlEditorItemView, itemWithHtmlSupport, htmlEditorViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "htmlEditorViewModel.item…        )\n        }\n    }");
        DisposableKt.plusAssign(compositeDisposable, subscribe3);
    }

    public static final void access$unBindViewModel(HtmlEditorItemState htmlEditorItemState, ItemWithHtmlSupport itemWithHtmlSupport) {
        htmlEditorItemState.getItemSubscriptionsDisposable(itemWithHtmlSupport.getStringId()).clear();
    }

    public static final void removeListeners(@NotNull HtmlEditorItemView htmlEditorItemView) {
        Intrinsics.checkNotNullParameter(htmlEditorItemView, "$this$removeListeners");
        htmlEditorItemView.setOnValueChangeListener(null);
        htmlEditorItemView.removeTextWatcher();
        htmlEditorItemView.setOnSelectionChangedListener(null);
        htmlEditorItemView.setOnViewTouchedListener(null);
    }

    public static final void setupListeners(@NotNull HtmlEditorItemView htmlEditorItemView, @Nullable Spannable spannable, @Nullable MutableHtmlNode mutableHtmlNode, @NotNull ItemWithHtmlSupport itemWithHtmlSupport, @NotNull HtmlRenderOptions htmlRenderOptions, @NotNull HtmlEditorItemState htmlEditorItemState, @Nullable HtmlEditorViewModel htmlEditorViewModel, @NotNull Consumer<BasicInputItem> consumer, @NotNull Function1<? super Boolean, Unit> function1, @NotNull Function2<? super CharSequence, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(htmlEditorItemView, "$this$setupListeners");
        Intrinsics.checkNotNullParameter(itemWithHtmlSupport, "item");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        Intrinsics.checkNotNullParameter(htmlEditorItemState, "state");
        Intrinsics.checkNotNullParameter(consumer, "valueChangesStream");
        Intrinsics.checkNotNullParameter(function1, "focusChangeListener");
        Intrinsics.checkNotNullParameter(function2, "valueChangeListener");
        htmlEditorItemState.getItemSubscriptionsDisposable(itemWithHtmlSupport.getStringId()).clear();
        if (mutableHtmlNode == null || htmlEditorViewModel == null) {
            htmlEditorItemView.setOnSelectionChangedListener(null);
            htmlEditorItemView.setFocusChangeListener(function1);
            htmlEditorItemView.setOnValueChangeListener(new b(function2));
            return;
        }
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        CompositeDisposable itemSubscriptionsDisposable = htmlEditorItemState.getItemSubscriptionsDisposable(itemWithHtmlSupport.getStringId());
        htmlEditorItemView.setOnViewTouchedListener(new a2.a.a.t.b.a.a(htmlEditorItemView, htmlEditorItemState, itemWithHtmlSupport, htmlEditorViewModel));
        x5 x5Var = new x5(1, htmlEditorViewModel, htmlEditorItemState);
        HtmlInteractorImpl htmlInteractorImpl = new HtmlInteractorImpl(new OperationTreeDisassemblerImpl(), htmlRenderOptions, htmlEditorItemState.getEditorState(), new e(htmlEditorViewModel));
        HtmlEditorSelectionListener htmlEditorSelectionListener = new HtmlEditorSelectionListener(min, max, htmlInteractorImpl, htmlEditorViewModel);
        htmlEditorItemView.setOnSelectionChangedListener(new Function3<CharSequence, Integer, Integer, Unit>(htmlEditorSelectionListener) { // from class: a2.a.a.t.b.a.b
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
        htmlEditorItemView.setTextWatcher(new HtmlEditorTextWatcher(htmlEditorItemView, mutableHtmlNode, new InputOperationFactoryImpl(), htmlInteractorImpl, function2, x5Var, htmlEditorSelectionListener));
        a(htmlEditorItemView, itemSubscriptionsDisposable, htmlEditorViewModel, itemWithHtmlSupport, htmlInteractorImpl, function2, consumer, x5Var);
        htmlEditorItemView.setAttachListener(new c(htmlEditorItemView, itemSubscriptionsDisposable, htmlEditorViewModel, itemWithHtmlSupport, htmlInteractorImpl, function2, consumer, x5Var));
        htmlEditorItemView.setDetachListener(new x5(0, htmlEditorItemState, itemWithHtmlSupport));
        htmlEditorItemView.setFocusChangeListener(new d(function1, htmlEditorViewModel, itemWithHtmlSupport));
    }
}
