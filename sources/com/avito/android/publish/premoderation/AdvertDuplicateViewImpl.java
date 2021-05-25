package com.avito.android.publish.premoderation;

import a2.b.a.a.a;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.image_loader.Picture;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Toolbars;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001bR\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u001b¨\u00069"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicateViewImpl;", "Lcom/avito/android/publish/premoderation/AdvertDuplicateView;", "", "title", "", "showTitle", "(Ljava/lang/String;)V", "description", "showDescription", "hint", "showHint", "setActionTitle", "setSkipActionTitle", "Lcom/avito/android/image_loader/Picture;", "picture", "showAdvertImage", "(Lcom/avito/android/image_loader/Picture;)V", "showAdvertTitle", "price", "showAdvertPrice", "Lio/reactivex/Observable;", "actionClicks", "()Lio/reactivex/Observable;", "skipActionClicks", "upClicks", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "hintView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "advertImage", "c", "descriptionView", "Landroid/widget/Button;", "h", "Landroid/widget/Button;", "advertAction", "Lru/avito/component/button/ButtonImpl;", "i", "Lru/avito/component/button/ButtonImpl;", "skipAction", "f", "advertTitle", g.a, "advertPrice", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", AuthSource.BOOKING_ORDER, "titleView", "Landroid/view/ViewGroup;", "root", "<init>", "(Landroid/view/ViewGroup;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDuplicateViewImpl implements AdvertDuplicateView {
    public final Toolbar a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final TextView f;
    public final TextView g;
    public final Button h;
    public final ButtonImpl i;

    public AdvertDuplicateViewImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.image);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.e = (SimpleDraweeView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.advert_title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.advert_price);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.action_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.Button");
        this.h = (Button) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.continue_button);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.i = new ButtonImpl(findViewById9);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    @NotNull
    public Observable<Unit> actionClicks() {
        return RxView.clicks(this.h);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void setActionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.h.setText(str);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void setSkipActionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.i.setText(str);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showAdvertImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a.L0(this.e, picture);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showAdvertPrice(@Nullable String str) {
        TextViews.bindText$default(this.g, str, false, 2, null);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showAdvertTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.f, str, false, 2, null);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showHint(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    @NotNull
    public Observable<Unit> skipActionClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.i));
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateView
    @NotNull
    public Observable<Unit> upClicks() {
        return InteropKt.toV2(Toolbars.upClicks(this.a));
    }
}
