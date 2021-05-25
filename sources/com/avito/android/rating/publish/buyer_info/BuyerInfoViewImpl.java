package com.avito.android.rating.publish.buyer_info;

import android.view.View;
import android.widget.EditText;
import com.avito.android.lib.design.button.Button;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/BuyerInfoViewImpl;", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "text", "setText", "(Ljava/lang/String;)V", "textChanges", PlatformActions.HIDE_KEYBOARD, "()V", "showKeyboard", "buttonClicks", "showContinueButton", "showSendButton", "", "isLoading", "showLoadingState", "(Z)V", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "sendButton", "Landroid/widget/EditText;", AuthSource.BOOKING_ORDER, "Landroid/widget/EditText;", "textInput", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.SEND_ABUSE, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class BuyerInfoViewImpl implements BuyerInfoView {
    public final AppBarImpl a;
    public final EditText b;
    public final Button c;

    public static final class a implements Runnable {
        public final /* synthetic */ BuyerInfoViewImpl a;

        public a(BuyerInfoViewImpl buyerInfoViewImpl) {
            this.a = buyerInfoViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.showKeyboard$default(this.a.b, 0, 1, null);
        }
    }

    public BuyerInfoViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle("");
        Unit unit = Unit.INSTANCE;
        this.a = appBarImpl;
        View findViewById = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.EditText");
        this.b = (EditText) findViewById;
        View findViewById2 = view.findViewById(R.id.send_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById2;
        this.c = button;
        button.setText(R.string.send_button_title);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    @NotNull
    public Observable<Unit> buttonClicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.b, false, 1, null);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return this.a.navigationCallbacks();
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.b.setText(str);
        this.b.setSelection(str.length());
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void showContinueButton() {
        this.c.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void showKeyboard() {
        this.b.post(new a(this));
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void showLoadingState(boolean z) {
        this.c.setLoading(z);
        this.c.setClickable(!z);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    public void showSendButton() {
        this.c.setText(R.string.send_button_title);
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoView
    @NotNull
    public Observable<String> textChanges() {
        Observable<String> create = Observable.create(new BuyerInfoViewImpl$textChanges$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…(watcher)\n        }\n    }");
        return create;
    }
}
