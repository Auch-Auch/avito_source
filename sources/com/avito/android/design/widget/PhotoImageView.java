package com.avito.android.design.widget;

import a2.g.r.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001a=B'\b\u0017\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\"\u0010'\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0015R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0015R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u0010008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0015¨\u0006>"}, d2 = {"Lcom/avito/android/design/widget/PhotoImageView;", "Landroid/widget/FrameLayout;", "", "drawableId", "", "setOverlay", "(I)V", "showProgressBar", "()V", "showRemoveOverlay", "showContent", "showErrorOverlay", "", "showRetry", "showErrorActionsOverlay", "(Z)V", "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "(Landroid/view/View;)V", "i", "Landroid/view/View;", "progressBar", g.a, "errorActionsContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "f", "errorIcon", "Lcom/avito/android/design/widget/PhotoImageView$Listener;", "Lcom/avito/android/design/widget/PhotoImageView$Listener;", "getListener", "()Lcom/avito/android/design/widget/PhotoImageView$Listener;", "setListener", "(Lcom/avito/android/design/widget/PhotoImageView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "overlayView", "d", "bigDeleteIcon", "h", "retryIcon", "", "j", "Ljava/util/List;", "topViews", "e", "smallDeleteIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Listener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoImageView extends FrameLayout {
    @NotNull
    public Listener a;
    @NotNull
    public final SimpleDraweeView b;
    public final ImageView c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final View h;
    public final View i;
    public final List<View> j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/design/widget/PhotoImageView$Listener;", "", "", "onRemoveClicked", "()V", "onRetryClicked", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onRemoveClicked();

        void onRetryClicked();
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((PhotoImageView) this.b).getListener().onRetryClicked();
            } else if (i == 1) {
                ((PhotoImageView) this.b).getListener().onRemoveClicked();
            } else if (i == 2) {
                ((PhotoImageView) this.b).getListener().onRemoveClicked();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Listener {
        @Override // com.avito.android.design.widget.PhotoImageView.Listener
        public void onRemoveClicked() {
        }

        @Override // com.avito.android.design.widget.PhotoImageView.Listener
        public void onRetryClicked() {
        }
    }

    @JvmOverloads
    public PhotoImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PhotoImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new b();
        LayoutInflater.from(context).inflate(R.layout.photo_image_view, this);
        View findViewById = findViewById(R.id.image_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById;
        View findViewById2 = findViewById(R.id.overlay_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.i = findViewById3;
        View findViewById4 = findViewById(R.id.big_delete_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = findViewById(R.id.error_icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = findViewById(R.id.error_actions_container);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.g = findViewById6;
        View findViewById7 = findViewById(R.id.retry_icon);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById7;
        View findViewById8 = findViewById(R.id.small_delete_icon);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById8;
        this.j = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{findViewById3, findViewById6, findViewById5, findViewById4});
        findViewById7.setOnClickListener(new a(0, this));
        findViewById4.setOnClickListener(new a(1, this));
        findViewById8.setOnClickListener(new a(2, this));
    }

    private final void setOverlay(@DrawableRes int i2) {
        this.c.setImageResource(i2);
        Views.show(this.c);
    }

    public final void a(View view) {
        List<View> list = this.j;
        ArrayList<View> arrayList = new ArrayList();
        for (T t : list) {
            if (!Intrinsics.areEqual(t, view)) {
                arrayList.add(t);
            }
        }
        for (View view2 : arrayList) {
            Views.conceal(view2);
        }
        Views.show(view);
    }

    @NotNull
    public final SimpleDraweeView getImageView() {
        return this.b;
    }

    @NotNull
    public final Listener getListener() {
        return this.a;
    }

    public final void setListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "<set-?>");
        this.a = listener;
    }

    public final void showContent() {
        setOverlay(R.drawable.bg_btn_flat_rounded);
        Iterator<T> it = this.j.iterator();
        while (it.hasNext()) {
            Views.conceal(it.next());
        }
    }

    public final void showErrorActionsOverlay(boolean z) {
        setOverlay(R.drawable.photo_image_view_not_ready_overlay);
        this.h.setVisibility(z ? 0 : 8);
        a(this.g);
    }

    public final void showErrorOverlay() {
        setOverlay(R.drawable.photo_image_view_not_ready_overlay);
        a(this.f);
    }

    public final void showProgressBar() {
        setOverlay(R.drawable.photo_image_view_not_ready_overlay);
        a(this.i);
    }

    public final void showRemoveOverlay() {
        setOverlay(R.drawable.photo_image_view_delete_overlay);
        a(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoImageView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
