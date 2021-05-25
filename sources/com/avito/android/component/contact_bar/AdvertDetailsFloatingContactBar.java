package com.avito.android.component.contact_bar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\b?\u0010@J1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u001dJ\u001f\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010\u0018J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00109\u001a\b\u0012\u0004\u0012\u000202068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010>\u001a\n ;*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/component/contact_bar/AdvertDetailsFloatingContactBar;", "Lcom/avito/android/component/contact_bar/ContactBar;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onClickListener", "setActions", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "status", "setUserStatus", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "isOnline", "setOnline", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "statusContainerClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showStatusContainer", "()V", "hideStatusContainer", "show", "hide", "visible", "immediately", "animateShowHide", "(ZZ)V", "isEnabled", "setEnabled", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "Landroid/widget/LinearLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/LinearLayout;", "buttonsContainer", "d", "Ljava/lang/Boolean;", "isShown", "Landroid/view/View;", "e", "Landroid/view/View;", "view", "", "c", "Ljava/util/List;", MessengerShareContentUtility.BUTTONS, "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFloatingContactBar implements ContactBar {
    public final Context a;
    public final LinearLayout b;
    public final List<View> c = new ArrayList();
    public Boolean d;
    public final View e;

    public AdvertDetailsFloatingContactBar(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        this.a = view.getContext();
        this.b = (LinearLayout) view.findViewById(R.id.contact_bar_buttons_container);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void animateShowHide(boolean z, boolean z2) {
        float f;
        if (!Intrinsics.areEqual(this.d, Boolean.valueOf(z)) && this.e.getHeight() != 0 && !(!Views.isVisible(this.e))) {
            this.d = Boolean.valueOf(z);
            if (z) {
                f = 0.0f;
            } else {
                f = (float) this.e.getHeight();
            }
            ViewPropertyAnimatorCompat duration = ViewCompat.animate(this.e).translationY(f).setDuration(z2 ? 0 : 100);
            Intrinsics.checkNotNullExpressionValue(duration, "it");
            duration.setInterpolator(new LinearInterpolator());
            duration.start();
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsTop() {
        View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.c);
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsVisibilityPercents() {
        return 0;
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hide() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hideStatusContainer() {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setActions(@NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        Button button;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onClickListener");
        LinearLayout linearLayout2 = this.b;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        this.c.clear();
        int i = 0;
        for (T t : list) {
            if (t.getType() == ContactBar.ActionType.BUY || t.getType() == ContactBar.ActionType.CART) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.marketplace_action, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
                Button button2 = (Button) inflate;
                button2.setText(t.getText());
                button2.setOnClickListener(new e(0, function1, t));
                this.c.add(button2);
                button = button2;
            } else {
                View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.advert_details_contact_bar_button, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate2, "buttonView");
                View findViewById = inflate2.findViewById(R.id.button_container);
                if (findViewById == null) {
                    findViewById = inflate2;
                }
                if (t.getType() == ContactBar.ActionType.PHONE) {
                    Intrinsics.checkNotNullExpressionValue(findViewById, "container");
                    Views.setBackgroundCompat(findViewById, R.drawable.bg_btn_flat_rds_green);
                }
                findViewById.setOnClickListener(new e(1, function1, t));
                List<View> list2 = this.c;
                Intrinsics.checkNotNullExpressionValue(findViewById, "container");
                list2.add(findViewById);
                View findViewById2 = findViewById.findViewById(R.id.button_text);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) findViewById2;
                textView.setText(t.getText());
                Context context = this.a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                int colorCompat = Contexts.getColorCompat(context, t.getIconTintColor());
                Integer iconDrawableId = t.getIconDrawableId();
                button = inflate2;
                if (iconDrawableId != null) {
                    Drawable drawable = this.a.getDrawable(iconDrawableId.intValue());
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable != null ? DrawablesKt.wrapForTinting(drawable, colorCompat) : null, (Drawable) null, (Drawable) null, (Drawable) null);
                    button = inflate2;
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            LinearLayout linearLayout3 = this.b;
            if (linearLayout3 != null) {
                linearLayout3.addView(button, layoutParams);
            }
            if (i >= 0 && i < list.size() - 1 && (linearLayout = this.b) != null) {
                Space space = new Space(this.a);
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                linearLayout.addView(space, new LinearLayout.LayoutParams(context2.getResources().getDimensionPixelSize(R.dimen.contact_button_inner_padding), -2, 0.0f));
            }
            i++;
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType) {
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setEnabled(boolean z) {
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setOnline(boolean z) {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setUserStatus(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void show() {
        Views.show(this.e);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void showStatusContainer() {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    @NotNull
    public Observable<Unit> statusContainerClicks() {
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty<Unit>()");
        return empty;
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hide(boolean z) {
        if (z) {
            hide();
        } else {
            show();
        }
    }
}
