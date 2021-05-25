package com.avito.android.app_rater.fragment;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.avito.android.app_rater.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.ScaleInOutTouchListener;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R:\u0010\r\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R:\u0010\u001c\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016¨\u0006!"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterWithEmojiDialogViewImpl;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogView;", "Landroid/view/View;", g.a, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogNegativeClicksRelay", "Lio/reactivex/Observable;", "f", "Lio/reactivex/Observable;", "getNegativeButtonClicks", "()Lio/reactivex/Observable;", "negativeButtonClicks", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "positiveButton", "e", "getPositiveButtonClicks", "positiveButtonClicks", "c", "dialogPositiveClicksRelay", AuthSource.BOOKING_ORDER, "negativeButton", "<init>", "(Landroid/view/View;)V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class AppRaterWithEmojiDialogViewImpl implements AppRaterDialogView {
    public final ImageView a;
    public final ImageView b;
    public final PublishRelay<Integer> c;
    public final PublishRelay<Integer> d;
    @NotNull
    public final Observable<Integer> e;
    @NotNull
    public final Observable<Integer> f;
    @NotNull
    public final View g;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AppRaterWithEmojiDialogViewImpl) this.b).c.accept(5);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AppRaterWithEmojiDialogViewImpl) this.b).d.accept(2);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public AppRaterWithEmojiDialogViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = getView().findViewById(R.id.happy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.happy)");
        ImageView imageView = (ImageView) findViewById;
        this.a = imageView;
        View findViewById2 = getView().findViewById(R.id.sad);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.sad)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.b = imageView2;
        PublishRelay<Integer> create = PublishRelay.create();
        this.c = create;
        PublishRelay<Integer> create2 = PublishRelay.create();
        this.d = create2;
        Intrinsics.checkNotNullExpressionValue(create, "dialogPositiveClicksRelay");
        this.e = create;
        Intrinsics.checkNotNullExpressionValue(create2, "dialogNegativeClicksRelay");
        this.f = create2;
        Resources resources = imageView.getResources();
        int i = R.dimen.click_padding;
        imageView.setOnTouchListener(new ScaleInOutTouchListener(0, resources.getDimensionPixelSize(i), new a(0, this), 1, null));
        imageView2.setOnTouchListener(new ScaleInOutTouchListener(0, imageView.getResources().getDimensionPixelSize(i), new a(1, this), 1, null));
    }

    @Override // com.avito.android.app_rater.fragment.AppRaterDialogView
    @NotNull
    public Observable<Integer> getNegativeButtonClicks() {
        return this.f;
    }

    @Override // com.avito.android.app_rater.fragment.AppRaterDialogView
    @NotNull
    public Observable<Integer> getPositiveButtonClicks() {
        return this.e;
    }

    @Override // com.avito.android.app_rater.fragment.AppRaterDialogView
    @NotNull
    public View getView() {
        return this.g;
    }
}
