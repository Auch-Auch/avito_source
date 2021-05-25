package com.avito.android.rating.publish.review_input;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.rating.R;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u0019\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\fJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\nR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000f\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0014\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006:"}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputViewImpl;", "Lcom/avito/android/rating/publish/review_input/ReviewInputView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "()V", "showSendButton", "", "title", "setTitle", "(Ljava/lang/String;)V", "showDescription", "hideDescription", "description", "setDescription", InternalConstsKt.PLACEHOLDER, "setPlaceholder", AbuseSendingResult.COMMENT, "setComment", "commentChanges", "message", "setCommentError", "hideCommentError", PlatformActions.HIDE_KEYBOARD, "showKeyboard", "isLoading", "showLoadingState", "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", "sendButton", "Lru/avito/component/info_label/InfoLabel;", "c", "Lru/avito/component/info_label/InfoLabel;", "commentLabel", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.SEND_ABUSE, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "f", "Landroid/widget/EditText;", AuthSource.BOOKING_ORDER, "Landroid/widget/EditText;", "commentInput", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewInputViewImpl implements ReviewInputView {
    public final AppBarImpl a;
    public final EditText b;
    public final InfoLabel c;
    public final Button d;
    public final TextView e;
    public final TextView f;

    public static final class a implements Runnable {
        public final /* synthetic */ ReviewInputViewImpl a;

        public a(ReviewInputViewImpl reviewInputViewImpl) {
            this.a = reviewInputViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.showKeyboard$default(this.a.b, 0, 1, null);
        }
    }

    public ReviewInputViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle("");
        Unit unit = Unit.INSTANCE;
        this.a = appBarImpl;
        View findViewById = view.findViewById(R.id.comment);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.EditText");
        this.b = (EditText) findViewById;
        View findViewById2 = view.findViewById(R.id.comment_label);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = new InfoLabel(findViewById2);
        View findViewById3 = view.findViewById(R.id.send_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        this.d = button;
        View findViewById4 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById5;
        button.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    @NotNull
    public Observable<Unit> buttonClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    @NotNull
    public Observable<String> commentChanges() {
        Observable<String> create = Observable.create(new ReviewInputViewImpl$commentChanges$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…(watcher)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void hideCommentError() {
        this.c.hide();
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void hideDescription() {
        Views.hide(this.f);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.b, false, 1, null);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return this.a.navigationCallbacks();
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setButtonEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setComment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AbuseSendingResult.COMMENT);
        this.b.setText(str);
        this.b.setSelection(str.length());
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setCommentError(@Nullable String str) {
        this.c.setValues(str != null ? str : "", InfoLevel.ERROR);
        this.c.setVisible(str != null);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextViews.bindText$default(this.f, str, false, 2, null);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setPlaceholder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, InternalConstsKt.PLACEHOLDER);
        this.b.setHint(str);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.e, str, false, 2, null);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void showContinueButton() {
        this.d.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void showDescription() {
        Views.show(this.f);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void showKeyboard() {
        this.b.post(new a(this));
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void showLoadingState(boolean z) {
        this.d.setLoading(z);
        this.d.setClickable(!z);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputView
    public void showSendButton() {
        this.d.setText(R.string.send_button_title);
    }
}
