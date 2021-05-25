package a2.a.a.a;

import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import com.avito.android.component.MessageInput;
import com.avito.android.ui_components.R;
import com.avito.android.util.Keyboards;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
public final class a extends SimpleTextWatcher implements MessageInput {
    public final View a;
    public final ImageView b;
    public final ImageView c;
    public final ViewAnimator d;
    public final EditText e;
    public final TypedValue f;
    public final TypedValue g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Unit> i;
    @NotNull
    public final Observable<String> j;
    @NotNull
    public final Observable<CharSequence> k;
    @NotNull
    public final Relay<Unit> l;
    public final View m;

    /* compiled from: java-style lambda group */
    /* renamed from: a2.a.a.a.a$a  reason: collision with other inner class name */
    public static final class View$OnTouchListenerC0000a implements View.OnTouchListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public View$OnTouchListenerC0000a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
                if (motionEvent.getActionMasked() == 0) {
                    ((a) this.b).l.accept(Unit.INSTANCE);
                }
                return false;
            } else if (i == 1) {
                Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
                if (motionEvent.getActionMasked() == 0) {
                    ((a) this.b).l.accept(Unit.INSTANCE);
                }
                return false;
            } else if (i == 2) {
                Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
                if (motionEvent.getActionMasked() == 0) {
                    ((a) this.b).l.accept(Unit.INSTANCE);
                }
                return false;
            } else if (i == 3) {
                Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
                if (motionEvent.getActionMasked() == 0) {
                    ((a) this.b).l.accept(Unit.INSTANCE);
                }
                return false;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Unit, String> {
        public final /* synthetic */ a a;

        public b(a aVar) {
            this.a = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Unit unit) {
            EditText editText = this.a.e;
            Intrinsics.checkNotNullExpressionValue(editText, "messageText");
            return editText.getText().toString();
        }
    }

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.m = view;
        View findViewById = view.findViewById(R.id.attachment_button);
        this.a = findViewById;
        ImageView imageView = (ImageView) view.findViewById(R.id.submit_button);
        this.b = imageView;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.photo_button);
        this.c = imageView2;
        this.d = (ViewAnimator) view.findViewById(R.id.submit_button_animator);
        EditText editText = (EditText) view.findViewById(R.id.message);
        this.e = editText;
        TypedValue typedValue = new TypedValue();
        this.f = typedValue;
        TypedValue typedValue2 = new TypedValue();
        this.g = typedValue2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "photoButton");
        this.h = RxView.clicks(imageView2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "attachmentButton");
        this.i = RxView.clicks(findViewById);
        Intrinsics.checkNotNullExpressionValue(imageView, "submitButton");
        Observable<R> map = RxView.clicks(imageView).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "submitButton.clicks().ma…ageText.text.toString() }");
        this.j = map;
        Intrinsics.checkNotNullExpressionValue(editText, "messageText");
        this.k = RxTextView.textChanges(editText);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.l = create;
        view.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        view.getResources().getValue(R.dimen.inactive_alpha, typedValue2, true);
        editText.addTextChangedListener(this);
        editText.setOnTouchListener(new View$OnTouchListenerC0000a(0, this));
        findViewById.setOnTouchListener(new View$OnTouchListenerC0000a(1, this));
        imageView.setOnTouchListener(new View$OnTouchListenerC0000a(2, this));
        imageView2.setOnTouchListener(new View$OnTouchListenerC0000a(3, this));
    }

    @Override // com.avito.android.component.MessageInput
    public void clearText() {
        EditText editText = this.e;
        Intrinsics.checkNotNullExpressionValue(editText, "messageText");
        editText.setText((CharSequence) null);
    }

    @Override // com.avito.android.component.MessageInput
    @NotNull
    public Observable<Unit> getAttachmentButtonClicks() {
        return this.i;
    }

    @Override // com.avito.android.component.MessageInput
    @NotNull
    public Observable<Unit> getPhotoButtonClicks() {
        return this.h;
    }

    @Override // com.avito.android.component.MessageInput
    @NotNull
    public Observable<String> getSubmitButtonClicks() {
        return this.j;
    }

    @Override // com.avito.android.component.MessageInput
    @NotNull
    public Observable<CharSequence> getTextChanges() {
        return this.k;
    }

    @Override // com.avito.android.component.MessageInput
    public Observable getTouches() {
        return this.l;
    }

    @Override // com.avito.android.component.MessageInput
    public void hide() {
        EditText editText = this.e;
        Intrinsics.checkNotNullExpressionValue(editText, "messageText");
        Keyboards.hideKeyboard$default(editText, false, 1, null);
        Views.hide(this.m);
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (!m.isBlank(charSequence)) {
            ViewAnimator viewAnimator = this.d;
            Intrinsics.checkNotNullExpressionValue(viewAnimator, "submitButtonAnimator");
            if (1 != viewAnimator.getDisplayedChild()) {
                ViewAnimator viewAnimator2 = this.d;
                Intrinsics.checkNotNullExpressionValue(viewAnimator2, "submitButtonAnimator");
                viewAnimator2.setDisplayedChild(1);
                return;
            }
            return;
        }
        ViewAnimator viewAnimator3 = this.d;
        Intrinsics.checkNotNullExpressionValue(viewAnimator3, "submitButtonAnimator");
        if (viewAnimator3.getDisplayedChild() != 0) {
            ViewAnimator viewAnimator4 = this.d;
            Intrinsics.checkNotNullExpressionValue(viewAnimator4, "submitButtonAnimator");
            viewAnimator4.setDisplayedChild(0);
        }
    }

    @Override // com.avito.android.component.MessageInput
    public void setAttachmentButtonState(@NotNull MessageInput.AttachButtonState attachButtonState) {
        Intrinsics.checkNotNullParameter(attachButtonState, "state");
        int ordinal = attachButtonState.ordinal();
        if (ordinal == 0) {
            Views.show(this.a);
            View view = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "attachmentButton");
            view.setAlpha(this.f.getFloat());
            View view2 = this.a;
            Intrinsics.checkNotNullExpressionValue(view2, "attachmentButton");
            view2.setClickable(true);
        } else if (ordinal == 1) {
            Views.show(this.a);
            View view3 = this.a;
            Intrinsics.checkNotNullExpressionValue(view3, "attachmentButton");
            view3.setAlpha(this.g.getFloat());
            View view4 = this.a;
            Intrinsics.checkNotNullExpressionValue(view4, "attachmentButton");
            view4.setClickable(false);
        } else if (ordinal == 2) {
            Views.hide(this.a);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.component.MessageInput
    public void setPhotoEnabled(boolean z) {
        if (z) {
            ImageView imageView = this.c;
            Intrinsics.checkNotNullExpressionValue(imageView, "photoButton");
            imageView.setAlpha(this.f.getFloat());
            ImageView imageView2 = this.c;
            Intrinsics.checkNotNullExpressionValue(imageView2, "photoButton");
            imageView2.setTag(MessageInput.SendPhotoButtonState.SEND_PHOTO_ALLOW);
            return;
        }
        ImageView imageView3 = this.c;
        Intrinsics.checkNotNullExpressionValue(imageView3, "photoButton");
        imageView3.setAlpha(this.g.getFloat());
        ImageView imageView4 = this.c;
        Intrinsics.checkNotNullExpressionValue(imageView4, "photoButton");
        imageView4.setTag(MessageInput.SendPhotoButtonState.SEND_PHOTO_DISALLOW);
    }

    @Override // com.avito.android.component.MessageInput
    public void setText(@NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.e.setText(charSequence);
        this.e.setSelection(charSequence.length());
        if (z) {
            EditText editText = this.e;
            Intrinsics.checkNotNullExpressionValue(editText, "messageText");
            Keyboards.showKeyboard(editText, 2);
        }
    }

    @Override // com.avito.android.component.MessageInput
    public void show() {
        Views.show(this.m);
    }
}
