package com.avito.android.advert_core.short_term_rent;

import a2.a.a.g.m.a;
import a2.a.a.g.m.b;
import a2.a.a.g.m.c;
import a2.a.a.g.m.d;
import a2.a.a.g.m.e;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.Features;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlock;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockView;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.component.switch_list_element.SwitchListElement;
import com.avito.android.component.switch_list_element.SwitchListElementImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010\u000f\u001a\u000202\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u00108\u001a\u000205¢\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\tJ\"\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0013\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001d\u0010\u0017J&\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0001¢\u0006\u0004\b$\u0010\u0017J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001eH\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0004H\u0001¢\u0006\u0004\b(\u0010\u0006J \u0010,\u001a\u00020\u00042\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0001¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u000f\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewImpl;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView;", "Lcom/avito/android/component/switch_list_element/SwitchListElement;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrParametersView;", "", "hideToggle", "()V", "", "isChecked", "()Z", "isSaveEnabled", "withAnimation", "setChecked", "(ZZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled", "setEnabled", "(Z)V", "", "resId", "setIcon", "(I)V", "enabled", "setSaveEnabled", "", MessengerShareContentUtility.SUBTITLE, "Landroid/text/method/MovementMethod;", "movementMethod", "setSubtitle", "(Ljava/lang/CharSequence;Landroid/text/method/MovementMethod;)V", "setSwitchEnabled", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "showToggle", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "bindParameters", "(Ljava/util/List;)V", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$Listener;", "d", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$Listener;", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "viewModel", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$CalendarButtonClickListener;", "e", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$CalendarButtonClickListener;", "buttonClickListener", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$Listener;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$CalendarButtonClickListener;Lcom/avito/android/Features;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlockViewImpl implements AdvertStrBlockView, SwitchListElement, AdvertStrParametersView {
    public final View a;
    public final AdvertStrBlockViewModel b;
    public final LifecycleOwner c;
    public final AdvertStrBlockView.Listener d;
    public final AdvertStrBlockView.CalendarButtonClickListener e;
    public final Features f;
    public final /* synthetic */ SwitchListElementImpl g;
    public final /* synthetic */ AdvertStrParametersViewImpl h;

    public AdvertStrBlockViewImpl(@NotNull View view, @NotNull AdvertStrBlockViewModel advertStrBlockViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull AdvertStrBlockView.Listener listener, @NotNull AdvertStrBlockView.CalendarButtonClickListener calendarButtonClickListener, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertStrBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(calendarButtonClickListener, "buttonClickListener");
        Intrinsics.checkNotNullParameter(features, "features");
        this.g = new SwitchListElementImpl(view);
        this.h = new AdvertStrParametersViewImpl(view);
        this.a = view;
        this.b = advertStrBlockViewModel;
        this.c = lifecycleOwner;
        this.d = listener;
        this.e = calendarButtonClickListener;
        this.f = features;
        setSaveEnabled(false);
        advertStrBlockViewModel.getDataChanges().observe(lifecycleOwner, new b(this));
        advertStrBlockViewModel.getSwitchChanges().observe(lifecycleOwner, new p0(0, this));
        advertStrBlockViewModel.getSwitchEnableChanges().observe(lifecycleOwner, new p0(1, this));
        advertStrBlockViewModel.getSwitchErrorChanges().observe(lifecycleOwner, new c(this));
    }

    public static final void access$bindStrBlock(AdvertStrBlockViewImpl advertStrBlockViewImpl, AdvertStrBlock advertStrBlock) {
        ViewStub viewStub;
        Objects.requireNonNull(advertStrBlockViewImpl);
        AdvertStrBlock.Switcher onlineBookingField = advertStrBlock.getOnlineBookingField();
        List<AdvertStrBlock.Parameter> parameters = advertStrBlock.getParameters();
        Action manageCalendarButtonAction = advertStrBlock.getManageCalendarButtonAction();
        if (!advertStrBlockViewImpl.f.getStrSellerAdvertBlock().invoke().booleanValue()) {
            return;
        }
        if (onlineBookingField != null || parameters != null || manageCalendarButtonAction != null) {
            if (onlineBookingField != null) {
                advertStrBlockViewImpl.setIcon(R.drawable.ic_calendar_rds_blue_24);
                advertStrBlockViewImpl.setTitle(onlineBookingField.getTitle());
                advertStrBlockViewImpl.setSubtitle(onlineBookingField.getDisclaimer(), LinkMovementMethod.getInstance());
                boolean isEnabled = onlineBookingField.isEnabled();
                advertStrBlockViewImpl.setCheckedChangeListener(d.a);
                SwitchListElement.DefaultImpls.setChecked$default(advertStrBlockViewImpl, isEnabled, false, 2, null);
                advertStrBlockViewImpl.setCheckedChangeListener(new e(advertStrBlockViewImpl));
            }
            advertStrBlockViewImpl.bindParameters(parameters);
            if (!(!advertStrBlockViewImpl.f.getStrSellerCalendar().invoke().booleanValue() || manageCalendarButtonAction == null || (viewStub = (ViewStub) advertStrBlockViewImpl.a.findViewById(com.avito.android.advert_core.R.id.manage_calendar_button_stub)) == null)) {
                View inflate = viewStub.inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setId(com.avito.android.advert_core.R.id.action_primary);
                textView.setText(manageCalendarButtonAction.getTitle());
                textView.setOnClickListener(new a(manageCalendarButtonAction, advertStrBlockViewImpl));
            }
            Views.show(advertStrBlockViewImpl.a);
        }
    }

    public static final void access$setToggleValue(AdvertStrBlockViewImpl advertStrBlockViewImpl, boolean z) {
        Objects.requireNonNull(advertStrBlockViewImpl);
        advertStrBlockViewImpl.setCheckedChangeListener(d.a);
        SwitchListElement.DefaultImpls.setChecked$default(advertStrBlockViewImpl, z, false, 2, null);
        advertStrBlockViewImpl.setCheckedChangeListener(new e(advertStrBlockViewImpl));
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrParametersView
    public void bindParameters(@Nullable List<AdvertStrBlock.Parameter> list) {
        this.h.bindParameters(list);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void hideToggle() {
        this.g.hideToggle();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isChecked() {
        return this.g.isChecked();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isSaveEnabled() {
        return this.g.isSaveEnabled();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setChecked(boolean z, boolean z2) {
        this.g.setChecked(z, z2);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.g.setCheckedChangeListener(function1);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g.setClickListener(function0);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setIcon(@DrawableRes int i) {
        this.g.setIcon(i);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSaveEnabled(boolean z) {
        this.g.setSaveEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSubtitle(@Nullable CharSequence charSequence, @Nullable MovementMethod movementMethod) {
        this.g.setSubtitle(charSequence, movementMethod);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSwitchEnabled(boolean z) {
        this.g.setSwitchEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.g.setTitle(charSequence);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void showToggle() {
        this.g.showToggle();
    }
}
