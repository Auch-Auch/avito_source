package com.avito.android.blueprints.input;

import a2.g.r.g;
import android.text.Selection;
import android.text.Spannable;
import com.avito.android.blueprints.input.MultiStateInputItemView;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemState;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemViewExtensionsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.item_temporary.R;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.MultiStateInputChangePayload;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b=\u0010>J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ%\u0010\u0013\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R:\u0010\u001d\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cRj\u0010!\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a \u001b*\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001e0\u001e \u001b**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a \u001b*\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001e0\u001e\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R:\u0010.\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010'0' \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010'0'\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001cR.\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u001e0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010)\u001a\u0004\b;\u0010+¨\u0006?"}, d2 = {"Lcom/avito/android/blueprints/input/MultiStateInputItemPresenterImpl;", "Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "view", "Lcom/avito/android/items/InputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/input/MultiStateInputItemView;Lcom/avito/android/items/InputItem;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/input/MultiStateInputItemView;Lcom/avito/android/items/InputItem;ILjava/util/List;)V", "Lcom/avito/android/items/ItemWithState$State;", "state", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/input/MultiStateInputItemView;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "j", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/items/BasicInputItem;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "valueChangesStream", "Lkotlin/Pair;", "", AuthSource.BOOKING_ORDER, "focusChangesStream", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "i", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lio/reactivex/Observable;", "Lcom/avito/android/items/ItemWithAdditionalButton;", "f", "Lio/reactivex/Observable;", "getRightIconClickObservable", "()Lio/reactivex/Observable;", "rightIconClickObservable", "c", "rightIconClickStream", "e", "getFocusChangesObservable", "focusChangesObservable", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", g.a, "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", "editorState", "Lcom/avito/android/util/text/AttributedTextFormatter;", "h", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "d", "getValueChangesObservable", "valueChangesObservable", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/html_formatter/HtmlRenderOptions;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateInputItemPresenterImpl implements MultiStateInputItemPresenter {
    public final PublishRelay<BasicInputItem> a;
    public final PublishRelay<Pair<Boolean, BasicInputItem>> b;
    public final PublishRelay<ItemWithAdditionalButton> c;
    @NotNull
    public final Observable<BasicInputItem> d;
    @NotNull
    public final Observable<Pair<Boolean, BasicInputItem>> e;
    @NotNull
    public final Observable<ItemWithAdditionalButton> f;
    public final HtmlEditorItemState g = new HtmlEditorItemState();
    public final AttributedTextFormatter h;
    public final HtmlRenderOptions i;
    public final HtmlEditorViewModel j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemWithAdditionalButton.AdditionalButtonType.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MultiStateInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem) {
            super(1);
            this.a = multiStateInputItemPresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            MultiStateInputItemPresenterImpl.access$onFocusChanged(this.a, this.b, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<CharSequence, String, Unit> {
        public final /* synthetic */ MultiStateInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem) {
            super(2);
            this.a = multiStateInputItemPresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CharSequence charSequence, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "value");
            MultiStateInputItemPresenterImpl.access$onValueChanged(this.a, this.b, str2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MultiStateInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem) {
            super(1);
            this.a = multiStateInputItemPresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            MultiStateInputItemPresenterImpl.access$onFocusChanged(this.a, this.b, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<CharSequence, String, Unit> {
        public final /* synthetic */ MultiStateInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem) {
            super(2);
            this.a = multiStateInputItemPresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CharSequence charSequence, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "html");
            MultiStateInputItemPresenterImpl.access$onValueChanged(this.a, this.b, str2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MultiStateInputItemPresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull HtmlRenderOptions htmlRenderOptions, @Nullable HtmlEditorViewModel htmlEditorViewModel) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        this.h = attributedTextFormatter;
        this.i = htmlRenderOptions;
        this.j = htmlEditorViewModel;
        PublishRelay<BasicInputItem> create = PublishRelay.create();
        this.a = create;
        PublishRelay<Pair<Boolean, BasicInputItem>> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<ItemWithAdditionalButton> create3 = PublishRelay.create();
        this.c = create3;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesStream");
        this.d = create;
        Intrinsics.checkNotNullExpressionValue(create2, "focusChangesStream");
        this.e = create2;
        Intrinsics.checkNotNullExpressionValue(create3, "rightIconClickStream");
        this.f = create3;
    }

    public static final void access$onFocusChanged(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem, boolean z) {
        multiStateInputItemPresenterImpl.g.getEditorState().clear();
        multiStateInputItemPresenterImpl.b.accept(TuplesKt.to(Boolean.valueOf(z), inputItem));
    }

    public static final void access$onValueChanged(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem, String str) {
        Objects.requireNonNull(multiStateInputItemPresenterImpl);
        inputItem.setValue(str);
        multiStateInputItemPresenterImpl.a.accept(inputItem);
    }

    public final void a(MultiStateInputItemView multiStateInputItemView, ItemWithState.State state, AttributedText attributedText) {
        if (state instanceof ItemWithState.State.Error) {
            multiStateInputItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateInputItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message == null) {
                message = attributedText != null ? this.h.format(attributedText) : null;
            }
            multiStateInputItemView.setNormalState(message);
        }
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemPresenter
    @NotNull
    public Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable() {
        return this.e;
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemPresenter
    @NotNull
    public Observable<ItemWithAdditionalButton> getRightIconClickObservable() {
        return this.f;
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemPresenter
    @NotNull
    public Observable<BasicInputItem> getValueChangesObservable() {
        return this.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(MultiStateInputItemView multiStateInputItemView, InputItem inputItem, int i2, List list) {
        bindView(multiStateInputItemView, inputItem, i2, (List<? extends Object>) list);
    }

    public void bindView(@NotNull MultiStateInputItemView multiStateInputItemView, @NotNull InputItem inputItem, int i2) {
        String postfix;
        String prefix;
        Intrinsics.checkNotNullParameter(multiStateInputItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        ItemWithAdditionalButton.AdditionalButtonType additionalButtonType = null;
        multiStateInputItemView.setOnValueChangeListener(null);
        multiStateInputItemView.removeTextWatcher();
        multiStateInputItemView.setTitle(inputItem.getHideTitle() ? "" : inputItem.getTitle());
        multiStateInputItemView.setPlaceholder(inputItem.getPlaceholder());
        multiStateInputItemView.setPrefix(inputItem.getPrefix());
        multiStateInputItemView.setPostfix(inputItem.getPostfix());
        DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
        if (!(displayingOptions == null || (prefix = displayingOptions.getPrefix()) == null)) {
            multiStateInputItemView.setPrefix(prefix);
        }
        DisplayingOptions displayingOptions2 = inputItem.getDisplayingOptions();
        if (!(displayingOptions2 == null || (postfix = displayingOptions2.getPostfix()) == null)) {
            multiStateInputItemView.setPostfix(postfix);
        }
        multiStateInputItemView.setValue(null);
        multiStateInputItemView.setInputType(inputItem.getInputType());
        if (inputItem.getLines() > 1) {
            MultiStateInputItemView.DefaultImpls.setMultiLine$default(multiStateInputItemView, inputItem.getLines(), 0, 2, null);
            multiStateInputItemView.setSelectionToEndOnFocus(false);
        } else {
            multiStateInputItemView.setSingleLine();
            multiStateInputItemView.setSelectionToEndOnFocus(true);
        }
        multiStateInputItemView.setMaxLength(Intrinsics.areEqual(inputItem.getInputType(), FormatterType.Companion.getDECIMAL()) ? 12 : Integer.MAX_VALUE);
        MutableHtmlNode htmlRootNode = inputItem.getHtmlRootNode();
        if (htmlRootNode != null) {
            multiStateInputItemView.setValue(htmlRootNode.render(this.i));
        } else {
            multiStateInputItemView.setValue(inputItem.getValue());
        }
        CharSequence text = multiStateInputItemView.getText();
        if (!(text instanceof Spannable)) {
            text = null;
        }
        HtmlRenderOptions htmlRenderOptions = this.i;
        HtmlEditorItemState htmlEditorItemState = this.g;
        HtmlEditorViewModel htmlEditorViewModel = this.j;
        PublishRelay<BasicInputItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "valueChangesStream");
        HtmlEditorItemViewExtensionsKt.setupListeners(multiStateInputItemView, (Spannable) text, htmlRootNode, inputItem, htmlRenderOptions, htmlEditorItemState, htmlEditorViewModel, publishRelay, new a(this, inputItem), new b(this, inputItem));
        a(multiStateInputItemView, inputItem.getState(), inputItem.getMotivation());
        ItemWithAdditionalButton.AdditionalButton additionalButton = inputItem.getAdditionalButton();
        if (additionalButton != null) {
            additionalButtonType = additionalButton.getType();
        }
        if (additionalButtonType != null && additionalButtonType.ordinal() == 0) {
            multiStateInputItemView.setRightIconClickListener(new a2.a.a.t.a.a(this, inputItem));
            multiStateInputItemView.setRightIcon(R.drawable.ic_question_sign, com.avito.android.lib.design.R.attr.gray28);
        }
    }

    public void bindView(@NotNull MultiStateInputItemView multiStateInputItemView, @NotNull InputItem inputItem, int i2, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(multiStateInputItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        Spannable spannable = null;
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof MultiStateInputChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(multiStateInputItemView, inputItem, i2);
            return;
        }
        if (!(t3.getState() == null && t3.getMotivation() == null)) {
            ItemWithState.State state = t3.getState();
            if (state == null) {
                state = inputItem.getState();
            }
            AttributedText motivation = t3.getMotivation();
            if (motivation == null) {
                motivation = inputItem.getMotivation();
            }
            a(multiStateInputItemView, state, motivation);
        }
        HtmlEditorItemViewExtensionsKt.removeListeners(multiStateInputItemView);
        MutableHtmlNode htmlRootNode = inputItem.getHtmlRootNode();
        CharSequence text = multiStateInputItemView.getText();
        int selectionStart = Selection.getSelectionStart(text);
        int selectionEnd = Selection.getSelectionEnd(text);
        if (htmlRootNode == null) {
            String value = t3.getValue();
            if (value != null) {
                multiStateInputItemView.setValueIfDistinct(value);
            }
        } else {
            MutableHtmlNode htmlNode = t3.getHtmlNode();
            if (htmlNode != null) {
                multiStateInputItemView.setValue(htmlNode.render(this.i));
            }
        }
        CharSequence text2 = multiStateInputItemView.getText();
        if (text2 instanceof Spannable) {
            spannable = text2;
        }
        Spannable spannable2 = spannable;
        if (spannable2 != null) {
            Selection.setSelection(spannable2, e.coerceIn(selectionStart, 0, spannable2.length()), e.coerceIn(selectionEnd, 0, spannable2.length()));
        }
        HtmlRenderOptions htmlRenderOptions = this.i;
        HtmlEditorItemState htmlEditorItemState = this.g;
        HtmlEditorViewModel htmlEditorViewModel = this.j;
        PublishRelay<BasicInputItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "valueChangesStream");
        HtmlEditorItemViewExtensionsKt.setupListeners(multiStateInputItemView, spannable2, htmlRootNode, inputItem, htmlRenderOptions, htmlEditorItemState, htmlEditorViewModel, publishRelay, new c(this, inputItem), new d(this, inputItem));
    }
}
