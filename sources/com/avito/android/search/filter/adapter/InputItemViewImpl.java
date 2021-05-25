package com.avito.android.search.filter.adapter;

import android.view.View;
import com.avito.android.common.InputFormatter;
import com.avito.android.design.widget.FullWidthInputView;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ%\u0010\u000e\u001a\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0013J#\u0010\u001d\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/search/filter/adapter/InputItemViewImpl;", "Lcom/avito/android/search/filter/adapter/InputItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", PlatformActions.HIDE_KEYBOARD, "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "maxLines", "setMaxLines", "(I)V", "minLines", "setMinLines", "prefix", "setPrefix", "postfix", "setPostfix", "inputType", "setInputType", "", "setOnFocusChangeListener", "onUnbind", "Lcom/avito/android/common/InputFormatter;", "formatter", "setFormatter", "(Lcom/avito/android/common/InputFormatter;)V", "Lcom/avito/android/design/widget/FullWidthInputView;", "s", "Lcom/avito/android/design/widget/FullWidthInputView;", "inputView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemViewImpl extends BaseViewHolder implements InputItemView {
    public final FullWidthInputView s;

    public static final class a extends Lambda implements Function2<FullWidthInputView, Boolean, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(FullWidthInputView fullWidthInputView, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(fullWidthInputView, "<anonymous parameter 0>");
            this.a.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<FullWidthInputView, String, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(FullWidthInputView fullWidthInputView, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(fullWidthInputView, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a.invoke(str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (FullWidthInputView) view;
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void hideKeyboard() {
        Keyboards.hideKeyboard(this.s, false);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Keyboards.hideKeyboard$default(this.s, false, 1, null);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setFormatter(@Nullable InputFormatter inputFormatter) {
        this.s.setFormatter(inputFormatter);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setInputType(int i) {
        this.s.setInputType(i);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setMaxLines(int i) {
        this.s.setMaxLines(i);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setMinLines(int i) {
        this.s.setMinLines(i);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setFocusChangeListener(new a(function1));
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setChangeListener(new b(function1));
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setPostfix(@Nullable String str) {
        this.s.setPostfix(str);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setPrefix(@Nullable String str) {
        this.s.setPrefix(str);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setError((CharSequence) null);
        this.s.setTitle(str);
    }

    @Override // com.avito.android.search.filter.adapter.InputItemView
    public void setValue(@Nullable String str) {
        this.s.setValue(str);
    }
}
