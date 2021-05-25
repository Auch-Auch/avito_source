package com.avito.android.rating.publish.select_rating;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding4.appcompat.RxToolbar;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/rating/publish/select_rating/SelectRatingViewImpl;", "Lcom/avito/android/rating/publish/select_rating/SelectRatingView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "continueClicks", "", "scoreChanges", "score", "setScore", "(I)V", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "()V", "showSendButton", "isLoading", "showLoadingState", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "continueButton", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/lib/design/rating/RatingBar;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectRatingViewImpl implements SelectRatingView {
    public final Toolbar a;
    public final RatingBar b;
    public final Button c;

    public SelectRatingViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.rating.R.id.rating);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.b = (RatingBar) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.rating.R.id.continue_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        this.c = button;
        button.setText(com.avito.android.rating.R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    @NotNull
    public Observable<Unit> continueClicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    @NotNull
    public Observable<Integer> scoreChanges() {
        Observable<Integer> create = Observable.create(new ObservableOnSubscribe<Integer>(this) { // from class: com.avito.android.rating.publish.select_rating.SelectRatingViewImpl$scoreChanges$1
            public final /* synthetic */ SelectRatingViewImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<Integer> observableEmitter) {
                this.a.b.setListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.avito.android.rating.publish.select_rating.SelectRatingViewImpl$scoreChanges$1.1
                    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.avito.android.lib.design.rating.RatingBar.OnRatingBarChangeListener
                    public void onRatingChanged(int i, boolean z) {
                        if (z) {
                            observableEmitter.onNext(Integer.valueOf(i));
                        }
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    public void setButtonEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    public void setScore(int i) {
        this.b.setRating((float) i);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    public void showContinueButton() {
        this.c.setText(com.avito.android.rating.R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    public void showLoadingState(boolean z) {
        this.c.setLoading(z);
        this.c.setClickable(!z);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingView
    public void showSendButton() {
        this.c.setText(com.avito.android.rating.R.string.send_button_title);
    }
}
