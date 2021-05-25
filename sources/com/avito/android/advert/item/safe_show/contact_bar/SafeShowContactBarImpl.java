package com.avito.android.advert.item.safe_show.contact_bar;

import a2.a.a.f.x.z.b.a;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208¢\u0006\u0004\b<\u0010=J1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u001dJ\u001f\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010\u0018J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00103\u001a\n 0*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/advert/item/safe_show/contact_bar/SafeShowContactBarImpl;", "Lcom/avito/android/component/contact_bar/ContactBar;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onClickListener", "setActions", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "status", "setUserStatus", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "isOnline", "setOnline", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "statusContainerClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showStatusContainer", "()V", "hideStatusContainer", "show", "hide", "visible", "immediately", "animateShowHide", "(ZZ)V", "isEnabled", "setEnabled", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "Landroid/widget/LinearLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/LinearLayout;", "buttonsContainer", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "", "d", "Ljava/lang/String;", "btnText", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowContactBarImpl implements ContactBar {
    public final Context a;
    public final LinearLayout b;
    public final View c;
    public final String d;

    public SafeShowContactBarImpl(@NotNull View view, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "btnText");
        this.c = view;
        this.d = str;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.contact_bar_buttons_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.b = (LinearLayout) findViewById;
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void animateShowHide(boolean z, boolean z2) {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsTop() {
        return 0;
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public int getButtonsVisibilityPercents() {
        return 0;
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hide() {
        Views.hide(this.c);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hide(boolean z) {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void hideStatusContainer() {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setActions(@NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        T t;
        T t2;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onClickListener");
        this.b.removeAllViews();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getType() == ContactBar.ActionType.PHONE) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        T t3 = t;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (t2.getType() == ContactBar.ActionType.MESSENGER) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t4 = t2;
        if (t3 == null) {
            t3 = t4;
        }
        if (t3 != null) {
            String str = this.d;
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Button button = new Button(context, null, com.avito.android.lib.design.R.attr.buttonPrimaryLarge);
            button.setOnClickListener(new a(function1, t3, str));
            button.setText(str);
            this.b.addView(button, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType) {
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void setEnabled(boolean z) {
        LinearLayout linearLayout = this.b;
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            childAt.setEnabled(z);
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
        Views.show(this.c);
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    public void showStatusContainer() {
    }

    @Override // com.avito.android.component.contact_bar.ContactBar
    @NotNull
    public Observable<Unit> statusContainerClicks() {
        Observable<Unit> never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never<Unit>()");
        return never;
    }
}
