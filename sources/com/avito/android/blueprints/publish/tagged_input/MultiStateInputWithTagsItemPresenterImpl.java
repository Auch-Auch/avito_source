package com.avito.android.blueprints.publish.tagged_input;

import android.text.Selection;
import android.text.Spannable;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemState;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemViewExtensionsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.util.MultiStateInputChangePayload;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\b\u00100\u001a\u0004\u0018\u00010-\u0012\b\u0010=\u001a\u0004\u0018\u00010:\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010,\u001a\u00020)\u0012\b\u00109\u001a\u0004\u0018\u000106¢\u0006\u0004\bE\u0010FJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ%\u0010\u0013\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R:\u0010\u0019\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR.\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00160\u001f0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R:\u0010(\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010&0& \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010&0&\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/Rj\u00102\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0016 \u0017*\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001f0\u001f \u0017**\u0012$\u0012\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0016 \u0017*\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001f0\u001f\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0018R\"\u00105\u001a\b\u0012\u0004\u0012\u00020&0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010\"\u001a\u0004\b?\u0010$R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemPresenterImpl;", "Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemPresenter;", "Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;ILjava/util/List;)V", "Lcom/avito/android/items/ItemWithState$State;", "state", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/items/BasicInputItem;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "valueChangesStream", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", a2.g.r.g.a, "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", "editorState", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "e", "Lio/reactivex/Observable;", "getFocusChangesObservable", "()Lio/reactivex/Observable;", "focusChangesObservable", "Lcom/avito/android/blueprints/publish/tagged_input/SuggestRequest;", "c", "suggestSourceStream", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "k", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "h", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", AuthSource.BOOKING_ORDER, "focusChangesStream", "f", "getSuggestsRequestObservable", "suggestsRequestObservable", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "l", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "d", "getValueChangesObservable", "valueChangesObservable", "Lcom/avito/android/util/text/AttributedTextFormatter;", "j", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/html_formatter/HtmlRenderOptions;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateInputWithTagsItemPresenterImpl implements MultiStateInputWithTagsItemPresenter {
    public final PublishRelay<BasicInputItem> a;
    public final PublishRelay<Pair<Boolean, BasicInputItem>> b;
    public final PublishRelay<SuggestRequest> c;
    @NotNull
    public final Observable<BasicInputItem> d;
    @NotNull
    public final Observable<Pair<Boolean, BasicInputItem>> e;
    @NotNull
    public final Observable<SuggestRequest> f;
    public final HtmlEditorItemState g = new HtmlEditorItemState();
    public final TagsViewModel h;
    public final LifecycleOwner i;
    public final AttributedTextFormatter j;
    public final HtmlRenderOptions k;
    public final HtmlEditorViewModel l;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                MultiStateInputWithTagsItemPresenterImpl.access$bindToTagsViewModel((MultiStateInputWithTagsItemPresenterImpl) this.b, (MultiStateInputWithTagsItemView) this.e, ((ParameterElement.TaggedInput) this.c).getStringId(), ((ParameterElement.TaggedInput) this.c).getDynamicTags());
                return Unit.INSTANCE;
            } else if (i == 1) {
                MultiStateInputWithTagsItemPresenterImpl.access$unbindFromTagsViewModel((MultiStateInputWithTagsItemPresenterImpl) this.b, (MultiStateInputWithTagsItemView) this.e, ((ParameterElement.TaggedInput) this.c).getStringId());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                MultiStateInputWithTagsItemPresenterImpl.access$bindToTagsViewModel((MultiStateInputWithTagsItemPresenterImpl) this.c, (MultiStateInputWithTagsItemView) this.b, ((ParameterElement.TaggedInput) this.d).getStringId(), ((ParameterElement.TaggedInput) this.d).getDynamicTags());
                return Unit.INSTANCE;
            } else if (i == 1) {
                MultiStateInputWithTagsItemPresenterImpl.access$unbindFromTagsViewModel((MultiStateInputWithTagsItemPresenterImpl) this.c, (MultiStateInputWithTagsItemView) this.b, ((ParameterElement.TaggedInput) this.d).getStringId());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemView a;
        public final /* synthetic */ MultiStateInputWithTagsItemPresenterImpl b;
        public final /* synthetic */ ParameterElement.TaggedInput c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput) {
            super(1);
            this.a = multiStateInputWithTagsItemView;
            this.b = multiStateInputWithTagsItemPresenterImpl;
            this.c = taggedInput;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            MultiStateInputWithTagsItemPresenterImpl.access$onFocusChange(this.b, this.c, this.a, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<CharSequence, String, Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.TaggedInput b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput) {
            super(2);
            this.a = multiStateInputWithTagsItemPresenterImpl;
            this.b = taggedInput;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CharSequence charSequence, String str) {
            CharSequence charSequence2 = charSequence;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl = this.a;
            ParameterElement.TaggedInput taggedInput = this.b;
            String obj = charSequence2 != null ? charSequence2.toString() : null;
            if (obj == null) {
                obj = "";
            }
            MultiStateInputWithTagsItemPresenterImpl.access$onValueChange(multiStateInputWithTagsItemPresenterImpl, taggedInput, str2, obj);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemView a;
        public final /* synthetic */ MultiStateInputWithTagsItemPresenterImpl b;
        public final /* synthetic */ ParameterElement.TaggedInput c;
        public final /* synthetic */ MultiStateInputWithTagsItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput, MultiStateInputChangePayload multiStateInputChangePayload, MultiStateInputWithTagsItemView multiStateInputWithTagsItemView2) {
            super(1);
            this.a = multiStateInputWithTagsItemView;
            this.b = multiStateInputWithTagsItemPresenterImpl;
            this.c = taggedInput;
            this.d = multiStateInputWithTagsItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            MultiStateInputWithTagsItemPresenterImpl.access$onFocusChange(this.b, this.c, this.a, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function2<CharSequence, String, Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.TaggedInput b;
        public final /* synthetic */ MultiStateInputWithTagsItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput, MultiStateInputChangePayload multiStateInputChangePayload, MultiStateInputWithTagsItemView multiStateInputWithTagsItemView) {
            super(2);
            this.a = multiStateInputWithTagsItemPresenterImpl;
            this.b = taggedInput;
            this.c = multiStateInputWithTagsItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CharSequence charSequence, String str) {
            CharSequence charSequence2 = charSequence;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl = this.a;
            ParameterElement.TaggedInput taggedInput = this.b;
            String obj = charSequence2 != null ? charSequence2.toString() : null;
            if (obj == null) {
                obj = "";
            }
            MultiStateInputWithTagsItemPresenterImpl.access$onValueChange(multiStateInputWithTagsItemPresenterImpl, taggedInput, str2, obj);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView) {
            super(0);
            this.a = multiStateInputWithTagsItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.detachTextInserter();
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MultiStateInputWithTagsItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView) {
            super(0);
            this.a = multiStateInputWithTagsItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.detachTextInserter();
            return Unit.INSTANCE;
        }
    }

    public MultiStateInputWithTagsItemPresenterImpl(@Nullable TagsViewModel tagsViewModel, @Nullable LifecycleOwner lifecycleOwner, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull HtmlRenderOptions htmlRenderOptions, @Nullable HtmlEditorViewModel htmlEditorViewModel) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        this.h = tagsViewModel;
        this.i = lifecycleOwner;
        this.j = attributedTextFormatter;
        this.k = htmlRenderOptions;
        this.l = htmlEditorViewModel;
        PublishRelay<BasicInputItem> create = PublishRelay.create();
        this.a = create;
        PublishRelay<Pair<Boolean, BasicInputItem>> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<SuggestRequest> create3 = PublishRelay.create();
        this.c = create3;
        Observable<BasicInputItem> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "valueChangesStream.hide()");
        this.d = hide;
        Observable<Pair<Boolean, BasicInputItem>> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "focusChangesStream.hide()");
        this.e = hide2;
        Observable<SuggestRequest> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "suggestSourceStream.hide()");
        this.f = hide3;
    }

    public static final void access$bindToTagsViewModel(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, String str, boolean z) {
        LifecycleOwner lifecycleOwner;
        TagsViewModel tagsViewModel = multiStateInputWithTagsItemPresenterImpl.h;
        if (tagsViewModel != null && (lifecycleOwner = multiStateInputWithTagsItemPresenterImpl.i) != null) {
            multiStateInputWithTagsItemView.bindTagsListTo(str, tagsViewModel, lifecycleOwner, z);
            multiStateInputWithTagsItemView.bindTo(str, multiStateInputWithTagsItemPresenterImpl.h, multiStateInputWithTagsItemPresenterImpl.i);
        }
    }

    public static final void access$onFocusChange(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput, MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, boolean z) {
        multiStateInputWithTagsItemPresenterImpl.b.accept(TuplesKt.to(Boolean.valueOf(z), taggedInput));
        if (z) {
            multiStateInputWithTagsItemView.showKeyboard();
            multiStateInputWithTagsItemPresenterImpl.g.getEditorState().clear();
        }
    }

    public static final void access$onValueChange(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, ParameterElement.TaggedInput taggedInput, String str, String str2) {
        Objects.requireNonNull(multiStateInputWithTagsItemPresenterImpl);
        taggedInput.setValue(str);
        if (taggedInput.getDynamicTags()) {
            multiStateInputWithTagsItemPresenterImpl.c.accept(new SuggestRequest(taggedInput.getStringId(), str2));
        }
        multiStateInputWithTagsItemPresenterImpl.a.accept(taggedInput);
    }

    public static final void access$unbindFromTagsViewModel(MultiStateInputWithTagsItemPresenterImpl multiStateInputWithTagsItemPresenterImpl, MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, String str) {
        LifecycleOwner lifecycleOwner = multiStateInputWithTagsItemPresenterImpl.i;
        if (lifecycleOwner != null) {
            multiStateInputWithTagsItemView.unbindTagsList(str, lifecycleOwner);
            multiStateInputWithTagsItemView.unbind(str, multiStateInputWithTagsItemPresenterImpl.i);
        }
    }

    public final void a(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, ItemWithState.State state, AttributedText attributedText) {
        if (state instanceof ItemWithState.State.Error) {
            multiStateInputWithTagsItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateInputWithTagsItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message == null) {
                message = attributedText != null ? this.j.format(attributedText) : null;
            }
            multiStateInputWithTagsItemView.setNormalState(message);
        }
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter
    @NotNull
    public Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable() {
        return this.e;
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter
    @NotNull
    public Observable<SuggestRequest> getSuggestsRequestObservable() {
        return this.f;
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter
    @NotNull
    public Observable<BasicInputItem> getValueChangesObservable() {
        return this.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, ParameterElement.TaggedInput taggedInput, int i2, List list) {
        bindView(multiStateInputWithTagsItemView, taggedInput, i2, (List<? extends Object>) list);
    }

    public void bindView(@NotNull MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, @NotNull ParameterElement.TaggedInput taggedInput, int i2) {
        Intrinsics.checkNotNullParameter(multiStateInputWithTagsItemView, "view");
        Intrinsics.checkNotNullParameter(taggedInput, "item");
        Spannable spannable = null;
        multiStateInputWithTagsItemView.setOnValueChangeListener(null);
        multiStateInputWithTagsItemView.setFocusChangeListener(null);
        multiStateInputWithTagsItemView.removeTextWatcher();
        multiStateInputWithTagsItemView.attachTextInserter(multiStateInputWithTagsItemView);
        String str = "";
        multiStateInputWithTagsItemView.setTitle(taggedInput.getHideTitle() ? str : taggedInput.getTitle());
        multiStateInputWithTagsItemView.setPlaceholder(taggedInput.getPlaceholder());
        multiStateInputWithTagsItemView.setInputType(taggedInput.getInputType());
        if (taggedInput.getLines() == 1) {
            multiStateInputWithTagsItemView.setSingleLine();
            multiStateInputWithTagsItemView.setTagListStyle(false);
        } else {
            multiStateInputWithTagsItemView.setMultiLine(taggedInput.getLines());
            multiStateInputWithTagsItemView.setTagListStyle(true);
        }
        MutableHtmlNode htmlRootNode = taggedInput.getHtmlRootNode();
        if (htmlRootNode != null) {
            multiStateInputWithTagsItemView.setValue(htmlRootNode.render(this.k));
        } else {
            multiStateInputWithTagsItemView.setValue(taggedInput.getValue());
        }
        if (taggedInput.getDynamicTags()) {
            PublishRelay<SuggestRequest> publishRelay = this.c;
            String stringId = taggedInput.getStringId();
            String value = taggedInput.getValue();
            if (value != null) {
                str = value;
            }
            publishRelay.accept(new SuggestRequest(stringId, str));
        }
        CharSequence text = multiStateInputWithTagsItemView.getText();
        if (text instanceof Spannable) {
            spannable = text;
        }
        HtmlRenderOptions htmlRenderOptions = this.k;
        HtmlEditorItemState htmlEditorItemState = this.g;
        HtmlEditorViewModel htmlEditorViewModel = this.l;
        PublishRelay<BasicInputItem> publishRelay2 = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay2, "valueChangesStream");
        HtmlEditorItemViewExtensionsKt.setupListeners(multiStateInputWithTagsItemView, spannable, htmlRootNode, taggedInput, htmlRenderOptions, htmlEditorItemState, htmlEditorViewModel, publishRelay2, new c(multiStateInputWithTagsItemView, this, taggedInput), new d(this, taggedInput));
        a(multiStateInputWithTagsItemView, taggedInput.getState(), taggedInput.getMotivation());
        multiStateInputWithTagsItemView.setAttachListener(new b(0, multiStateInputWithTagsItemView, this, taggedInput));
        multiStateInputWithTagsItemView.setDetachListener(new b(1, multiStateInputWithTagsItemView, this, taggedInput));
        multiStateInputWithTagsItemView.setOnUnbindListener(new g(multiStateInputWithTagsItemView));
    }

    public void bindView(@NotNull MultiStateInputWithTagsItemView multiStateInputWithTagsItemView, @NotNull ParameterElement.TaggedInput taggedInput, int i2, @NotNull List<? extends Object> list) {
        MutableHtmlNode htmlNode;
        Intrinsics.checkNotNullParameter(multiStateInputWithTagsItemView, "view");
        Intrinsics.checkNotNullParameter(taggedInput, "item");
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
            bindView(multiStateInputWithTagsItemView, taggedInput, i2);
            return;
        }
        multiStateInputWithTagsItemView.setOnValueChangeListener(null);
        multiStateInputWithTagsItemView.setFocusChangeListener(null);
        MutableHtmlNode htmlRootNode = taggedInput.getHtmlRootNode();
        ItemWithState.State state = t3.getState();
        if (state != null) {
            a(multiStateInputWithTagsItemView, state, taggedInput.getMotivation());
        }
        HtmlEditorItemViewExtensionsKt.removeListeners(multiStateInputWithTagsItemView);
        if (!(htmlRootNode == null || (htmlNode = t3.getHtmlNode()) == null)) {
            CharSequence text = multiStateInputWithTagsItemView.getText();
            int selectionStart = Selection.getSelectionStart(text);
            int selectionEnd = Selection.getSelectionEnd(text);
            multiStateInputWithTagsItemView.setValue(htmlNode.render(this.k));
            CharSequence text2 = multiStateInputWithTagsItemView.getText();
            if (!(text2 instanceof Spannable)) {
                text2 = null;
            }
            Spannable spannable2 = (Spannable) text2;
            if (spannable2 != null) {
                Selection.setSelection(spannable2, t6.v.e.coerceIn(selectionStart, 0, spannable2.length()), t6.v.e.coerceIn(selectionEnd, 0, spannable2.length()));
            }
        }
        multiStateInputWithTagsItemView.attachTextInserter(multiStateInputWithTagsItemView);
        CharSequence text3 = multiStateInputWithTagsItemView.getText();
        if (text3 instanceof Spannable) {
            spannable = text3;
        }
        HtmlRenderOptions htmlRenderOptions = this.k;
        HtmlEditorItemState htmlEditorItemState = this.g;
        HtmlEditorViewModel htmlEditorViewModel = this.l;
        PublishRelay<BasicInputItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "valueChangesStream");
        HtmlEditorItemViewExtensionsKt.setupListeners(multiStateInputWithTagsItemView, spannable, htmlRootNode, taggedInput, htmlRenderOptions, htmlEditorItemState, htmlEditorViewModel, publishRelay, new e(multiStateInputWithTagsItemView, this, taggedInput, t3, multiStateInputWithTagsItemView), new f(this, taggedInput, t3, multiStateInputWithTagsItemView));
        multiStateInputWithTagsItemView.setAttachListener(new a(0, this, taggedInput, t3, multiStateInputWithTagsItemView));
        multiStateInputWithTagsItemView.setDetachListener(new a(1, this, taggedInput, t3, multiStateInputWithTagsItemView));
        multiStateInputWithTagsItemView.setOnUnbindListener(new h(multiStateInputWithTagsItemView));
    }
}
