package com.avito.android.component.contact_bar;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.TextViews;
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
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010;\u001a\u00020,\u0012\u0006\u0010I\u001a\u00020\u0015¢\u0006\u0004\bL\u0010MJ1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u001dJ\u001f\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010\u0018J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00108\u001a\n 5*\u0004\u0018\u000104048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u00102¨\u0006N"}, d2 = {"Lcom/avito/android/component/contact_bar/AdvertDetailsContactBar;", "Lcom/avito/android/component/contact_bar/ContactBar;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onClickListener", "setActions", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "status", "setUserStatus", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "isOnline", "setOnline", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "statusContainerClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showStatusContainer", "()V", "hideStatusContainer", "show", "hide", "visible", "immediately", "animateShowHide", "(ZZ)V", "isEnabled", "setEnabled", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "", "Landroid/view/View;", "f", "Ljava/util/List;", MessengerShareContentUtility.BUTTONS, "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "h", "Landroid/view/View;", "view", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "buttonsContainer", g.a, "Ljava/lang/CharSequence;", "onlineStatus", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "statusContainer", "i", "Z", "isInPhotoGallery", "d", "hidePhoneTextView", "<init>", "(Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsContactBar implements ContactBar {
    public final Context a;
    public final ViewGroup b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final List<View> f = new ArrayList();
    public CharSequence g = "";
    public final View h;
    public final boolean i;

    public static final class a implements Runnable {
        public final /* synthetic */ AdvertDetailsContactBar a;

        public a(AdvertDetailsContactBar advertDetailsContactBar) {
            this.a = advertDetailsContactBar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h.setVisibility(0);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AdvertDetailsContactBar a;
        public final /* synthetic */ boolean b;

        public b(AdvertDetailsContactBar advertDetailsContactBar, boolean z) {
            this.a = advertDetailsContactBar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h.setVisibility(this.b ? 8 : 0);
        }
    }

    public AdvertDetailsContactBar(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = view;
        this.i = z;
        this.a = view.getContext();
        this.b = (ViewGroup) view.findViewById(R.id.contact_bar_status_container);
        this.c = (TextView) view.findViewById(R.id.contact_bar_text);
        this.d = (TextView) view.findViewById(R.id.contact_bar_hide_phone_text);
        this.e = (LinearLayout) view.findViewById(R.id.contact_bar_buttons_container);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void animateShowHide(boolean z, boolean z2) {
        Iterator<T> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().setClickable(!z);
        }
        ViewCompat.animate(this.h).alpha(z ? 0.0f : 1.0f).setDuration(z2 ? 0 : 200).withStartAction(new a(this)).withEndAction(new b(this, z)).start();
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsTop() {
        View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.f);
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsVisibilityPercents() {
        Rect rect = new Rect();
        View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.f);
        if (view == null || view.getHeight() <= 0) {
            return 0;
        }
        view.getGlobalVisibleRect(rect);
        return (int) ((((rect.top < 0 || rect.bottom < 0) ? 0.0f : (float) rect.height()) / ((float) view.getHeight())) * ((float) 100));
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hide() {
        Views.conceal(this.h);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hideStatusContainer() {
        Views.hide(this.c);
        Views.hide(this.b);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setActions(@NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        boolean z;
        TextView textView;
        Button button;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onClickListener");
        LinearLayout linearLayout2 = this.e;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        this.f.clear();
        Iterator<T> it = list.iterator();
        int i2 = 0;
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getType() == ContactBar.ActionType.BUY || next.getType() == ContactBar.ActionType.CART) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.marketplace_action, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
                Button button2 = (Button) inflate;
                button2.setText(next.getText());
                button2.setOnClickListener(new k3(0, function1, next));
                this.f.add(button2);
                button = button2;
            } else {
                View inflate2 = LayoutInflater.from(this.a).inflate(this.i ? R.layout.photo_gallery_contact_bar_button : R.layout.advert_details_contact_bar_button, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate2, "buttonView");
                View findViewById = inflate2.findViewById(R.id.button_container);
                if (findViewById == null) {
                    findViewById = inflate2;
                }
                if (next.getType() == ContactBar.ActionType.PHONE && (!this.i)) {
                    Intrinsics.checkNotNullExpressionValue(findViewById, "container");
                    Views.setBackgroundCompat(findViewById, R.drawable.bg_btn_flat_rds_green);
                }
                findViewById.setOnClickListener(new k3(1, function1, next));
                List<View> list2 = this.f;
                Intrinsics.checkNotNullExpressionValue(findViewById, "container");
                list2.add(findViewById);
                View findViewById2 = findViewById.findViewById(R.id.button_text);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView2 = (TextView) findViewById2;
                textView2.setText(next.getText());
                Context context = this.a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                int colorCompat = Contexts.getColorCompat(context, next.getIconTintColor());
                Integer iconDrawableId = next.getIconDrawableId();
                button = inflate2;
                if (iconDrawableId != null) {
                    Drawable drawable = this.a.getDrawable(iconDrawableId.intValue());
                    textView2.setCompoundDrawablesWithIntrinsicBounds(drawable != null ? DrawablesKt.wrapForTinting(drawable, colorCompat) : null, (Drawable) null, (Drawable) null, (Drawable) null);
                    button = inflate2;
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            LinearLayout linearLayout3 = this.e;
            if (linearLayout3 != null) {
                linearLayout3.addView(button, layoutParams);
            }
            if ((!this.i) && i2 >= 0 && i2 < list.size() - 1 && (linearLayout = this.e) != null) {
                Space space = new Space(this.a);
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                linearLayout.addView(space, new LinearLayout.LayoutParams(context2.getResources().getDimensionPixelSize(R.dimen.contact_button_inner_padding), -2, 0.0f));
            }
            i2++;
        }
        if (!(list.size() == 1 && ((ContactBar.Action) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)).getType() == ContactBar.ActionType.MESSENGER)) {
            z = false;
        }
        if (z && (textView = this.d) != null) {
            TextViews.bindText$default(textView, this.a.getText(R.string.contact_bar_hide_phone_text), false, 2, null);
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType) {
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setEnabled(boolean z) {
        Iterator<T> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setOnline(boolean z) {
        this.g = z ? "●" : "";
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setUserStatus(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        boolean z = true;
        if (this.g.length() == 0) {
            if (charSequence2 == null || charSequence2.length() == 0) {
                hideStatusContainer();
                return;
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.g.length() > 0) {
            spannableStringBuilder.append(this.g);
            spannableStringBuilder.append((CharSequence) " ");
            Context context = this.h.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.green)), 0, 1, 33);
        }
        spannableStringBuilder.append(charSequence);
        if (charSequence2 != null && !m.isBlank(charSequence2)) {
            z = false;
        }
        if (!z) {
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append(charSequence2);
        }
        showStatusContainer();
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void show() {
        Views.show(this.h);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void showStatusContainer() {
        Views.show(this.b);
        Views.show(this.c);
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
        Iterator<T> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().setClickable(!z);
        }
        this.h.setAlpha(z ? 0.0f : 1.0f);
        this.h.setVisibility(z ? 8 : 0);
    }
}
