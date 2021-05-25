package com.avito.android.component.banner_card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.component.banner_card.BannerCard;
import com.avito.android.image_loader.Picture;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006:"}, d2 = {"Lcom/avito/android/component/banner_card/BannerCardImpl;", "Lcom/avito/android/component/banner_card/BannerCard;", "", "message", "", "setMessage", "(Ljava/lang/CharSequence;)V", "", "drawableRes", "setImage", "(I)V", "Lcom/avito/android/image_loader/Picture;", "picture", "(Lcom/avito/android/image_loader/Picture;)V", "", "Lcom/avito/android/component/banner_card/BannerCard$Action;", "actions", "setActions", "(Ljava/util/List;)V", "clearActionListeners", "()V", "", "visible", "setCloseButtonVisible", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/text/Text;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text/Text;", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "closeButton", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "f", "Landroid/view/LayoutInflater;", "inflater", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "actionsContainer", "", "Landroid/widget/TextView;", "e", "Ljava/util/List;", "actionViews", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BannerCardImpl implements BannerCard {
    public final SimpleDraweeView a;
    public final Text b;
    public final ImageView c;
    public final ViewGroup d;
    public final List<TextView> e = new ArrayList();
    public final LayoutInflater f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BannerCard.Action a;

        public a(BannerCard.Action action) {
            this.a = action;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getListener().invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public BannerCardImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.banner_image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.a = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.banner_message);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.banner_message)");
        this.b = new TextImpl(findViewById2);
        View findViewById3 = view.findViewById(R.id.close_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.c = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.actions_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.actions_container)");
        this.d = (ViewGroup) findViewById4;
        this.f = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void clearActionListeners() {
        for (TextView textView : this.e) {
            textView.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setActions(@NotNull List<BannerCard.Action> list) {
        int i;
        int lastIndex;
        int size;
        ArrayList i0 = a2.b.a.a.a.i0(list, "actions");
        Iterator<T> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            CharSequence title = next.getTitle();
            if (title != null) {
                if (title.length() > 0) {
                    i = 1;
                }
            }
            if (i != 0) {
                i0.add(next);
            }
        }
        if (this.e.size() < i0.size()) {
            int size2 = i0.size();
            for (int size3 = this.e.size(); size3 < size2; size3++) {
                View inflate = this.f.inflate(com.avito.android.deprecated_design.R.layout.button_flat_primary, this.d, false);
                List<TextView> list2 = this.e;
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                list2.add(textView);
                this.d.addView(inflate);
                textView.setGravity(3);
            }
        }
        if (i0.size() < this.e.size() && (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.e)) >= (size = i0.size())) {
            while (true) {
                this.d.removeView(this.e.remove(lastIndex));
                if (lastIndex == size) {
                    break;
                }
                lastIndex--;
            }
        }
        int size4 = i0.size();
        while (i < size4) {
            TextView textView2 = this.e.get(i);
            BannerCard.Action action = (BannerCard.Action) i0.get(i);
            textView2.setText(action.getTitle());
            if (action.getListener() == null) {
                textView2.setOnClickListener(null);
            } else {
                textView2.setOnClickListener(new a(action));
            }
            i++;
        }
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setCloseButtonVisible(boolean z) {
        Views.setVisible(this.c, z);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setCloseClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.c.setOnClickListener(null);
        } else {
            this.c.setOnClickListener(new b(function0));
        }
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setImage(int i) {
        if (i != 0) {
            Views.show(this.a);
            this.a.setImageResource(i);
            return;
        }
        Views.hide(this.a);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.b.setText(charSequence);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setImage(@Nullable Picture picture) {
        if (picture != null) {
            Views.show(this.a);
            a2.b.a.a.a.L0(this.a, picture);
            return;
        }
        Views.hide(this.a);
    }
}
