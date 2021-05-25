package com.avito.android.favorite_sellers;

import a2.a.a.s0.a;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018J(\u0010\u0007\u001a\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/favorite_sellers/BottomSheetMenu;", "", "Lkotlin/Function1;", "Lcom/avito/android/favorite_sellers/BottomSheetMenu$MenuItem;", "", "Lkotlin/ExtensionFunctionType;", "block", "addItem", "(Lkotlin/jvm/functions/Function1;)Lcom/avito/android/favorite_sellers/BottomSheetMenu$MenuItem;", "()Lcom/avito/android/favorite_sellers/BottomSheetMenu$MenuItem;", "show", "()V", "dismiss", "", "enabled", "setItemsEnabled", "(Z)V", "isShown", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "getDismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "Companion", "MenuItem", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface BottomSheetMenu {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/favorite_sellers/BottomSheetMenu$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/favorite_sellers/BottomSheetMenu;", "createAsDialog", "(Landroid/content/Context;)Lcom/avito/android/favorite_sellers/BottomSheetMenu;", "<init>", "()V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final BottomSheetMenu createAsDialog(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new a(context);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/favorite_sellers/BottomSheetMenu$MenuItem;", "", "", "resId", "", "setIcon", "(I)V", "setTitle", "setColorRes", "color", "setColorRgb", "showProgress", "()V", "hideProgress", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "title", "Landroid/view/View;", "d", "Landroid/view/View;", "itemView", "", "value", "getEnabled", "()Z", "setEnabled", "(Z)V", "enabled", "Landroid/widget/ProgressBar;", AuthSource.BOOKING_ORDER, "Landroid/widget/ProgressBar;", "progress", "<init>", "(Landroid/view/View;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class MenuItem {
        public final ImageView a;
        public final ProgressBar b;
        public final TextView c;
        public final View d;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ Function0 a;

            public a(Function0 function0) {
                this.a = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.invoke();
            }
        }

        public MenuItem(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.d = view;
            View findViewById = view.findViewById(R.id.menu_item_icon);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.menu_item_progress);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
            this.b = (ProgressBar) findViewById2;
            View findViewById3 = view.findViewById(R.id.menu_item_title);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.c = (TextView) findViewById3;
        }

        public final boolean getEnabled() {
            return this.d.isEnabled();
        }

        public final void hideProgress() {
            Views.hide(this.b);
            Views.show(this.a);
        }

        public final void setColorRes(@ColorRes int i) {
            setColorRgb(ContextCompat.getColor(this.c.getContext(), i));
        }

        public final void setColorRgb(@ColorInt int i) {
            this.a.setColorFilter(i);
            this.c.setTextColor(i);
            this.b.getIndeterminateDrawable().setTint(i);
        }

        public final void setEnabled(boolean z) {
            this.d.setEnabled(z);
        }

        public final void setIcon(@DrawableRes int i) {
            this.a.setImageResource(i);
        }

        public final void setOnClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.d.setOnClickListener(new a(function0));
        }

        public final void setTitle(@StringRes int i) {
            this.c.setText(i);
        }

        public final void showProgress() {
            Views.show(this.b);
            Views.hide(this.a);
        }
    }

    @NotNull
    MenuItem addItem();

    @NotNull
    MenuItem addItem(@NotNull Function1<? super MenuItem, Unit> function1);

    void dismiss();

    @NotNull
    Observable<Unit> getDismissEvents();

    boolean isShown();

    void setItemsEnabled(boolean z);

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    void show();
}
