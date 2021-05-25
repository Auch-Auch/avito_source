package com.avito.android.abuse.details.adapter;

import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRD\u0010\"\u001a0\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u000b0\u000b \u001e*\u0017\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u001d¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0002\b\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/abuse/details/adapter/CommentItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/abuse/details/adapter/CommentItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lio/reactivex/rxjava3/core/Observable;", "", "textChangeCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/widget/EditText;", "s", "Landroid/widget/EditText;", "input", "", "value", "getHint", "()Ljava/lang/CharSequence;", "setHint", "(Ljava/lang/CharSequence;)V", "hint", "Landroid/text/TextWatcher;", "u", "Landroid/text/TextWatcher;", "watcher", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "t", "Lcom/jakewharton/rxrelay3/PublishRelay;", "textChangeCallbacksRelay", "getText", "setText", "text", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class CommentItemViewImpl extends BaseViewHolder implements CommentItemView {
    public final EditText s;
    public final PublishRelay<String> t = PublishRelay.create();
    public TextWatcher u;
    public Function0<Unit> v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (EditText) view;
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    @Nullable
    public CharSequence getHint() {
        return this.s.getHint();
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    @Nullable
    public CharSequence getText() {
        return this.s.getText();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    public void setHint(@Nullable CharSequence charSequence) {
        this.s.setHint(charSequence);
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    public void setText(@Nullable CharSequence charSequence) {
        this.s.setText(charSequence);
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.v = function0;
    }

    @Override // com.avito.android.abuse.details.adapter.CommentItemView
    @NotNull
    public Observable<String> textChangeCallbacks() {
        EditText editText = this.s;
        CommentItemViewImpl$textChangeCallbacks$1 commentItemViewImpl$textChangeCallbacks$1 = new SimpleTextWatcher(this) { // from class: com.avito.android.abuse.details.adapter.CommentItemViewImpl$textChangeCallbacks$1
            public final /* synthetic */ CommentItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                this.a.t.accept(charSequence.toString());
            }
        };
        editText.removeTextChangedListener(this.u);
        this.u = commentItemViewImpl$textChangeCallbacks$1;
        editText.addTextChangedListener(commentItemViewImpl$textChangeCallbacks$1);
        PublishRelay<String> publishRelay = this.t;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "textChangeCallbacksRelay");
        return publishRelay;
    }
}
