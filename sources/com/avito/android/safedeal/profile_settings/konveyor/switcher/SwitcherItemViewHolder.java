package com.avito.android.safedeal.profile_settings.konveyor.switcher;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView;
import com.avito.android.util.DeepLinkSpan;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007JD\u0010\u000f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001b\u0010\u0019\u001a\u00020\u00052\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemViewHolder;", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onDeepLinkClickListener", "setLink", "(Ljava/lang/CharSequence;Lcom/avito/android/deep_linking/links/DeepLink;Lkotlin/jvm/functions/Function1;)V", "", "checked", "setChecked", "(Z)V", "loading", "setLoading", "", UriUtil.LOCAL_RESOURCE_SCHEME, "setImageDrawable", "(Ljava/lang/Integer;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "s", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcher", "<init>", "(Lcom/avito/android/lib/design/list_item/SwitcherListItem;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItemViewHolder extends BaseViewHolder implements SwitcherItemView {
    public final SwitcherListItem s;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitcherItemViewHolder(@NotNull SwitcherListItem switcherListItem) {
        super(switcherListItem);
        Intrinsics.checkNotNullParameter(switcherListItem, "switcher");
        this.s = switcherListItem;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SwitcherItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setImageDrawable(@DrawableRes @Nullable Integer num) {
        if (num != null) {
            num.intValue();
            this.s.setImageResource(num.intValue());
        }
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setLink(@Nullable CharSequence charSequence, @NotNull DeepLink deepLink, @NotNull Function1<? super DeepLink, Unit> function1) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(function1, "onDeepLinkClickListener");
        if (charSequence != null) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new DeepLinkSpan(deepLink, new OnDeepLinkClickListener(deepLink, function1, charSequence) { // from class: com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemViewHolder$setLink$$inlined$apply$lambda$1
                public final /* synthetic */ Function1 a;

                {
                    this.a = r2;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
                    this.a.invoke(deepLink2);
                }
            }, false, 4, null), 0, charSequence.length(), 33);
            this.s.setLink(spannableString);
            SwitcherListItem switcherListItem = this.s;
            MovementMethod instance = LinkMovementMethod.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
            switcherListItem.setLinkMovementMethod(instance);
        }
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setLoading(boolean z) {
        this.s.setLoading(z);
        this.s.setClickable(!z);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setSubtitle(@Nullable CharSequence charSequence) {
        this.s.setSubtitle(charSequence);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.s.setTitle(charSequence);
    }
}
