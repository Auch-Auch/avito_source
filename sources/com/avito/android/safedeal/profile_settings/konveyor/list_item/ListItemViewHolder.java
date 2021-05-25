package com.avito.android.safedeal.profile_settings.konveyor.list_item;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemView;
import com.avito.android.util.DeepLinkSpan;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007JD\u0010\u000f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00052\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemViewHolder;", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onDeepLinkClickListener", "setLink", "(Ljava/lang/CharSequence;Lcom/avito/android/deep_linking/links/DeepLink;Lkotlin/jvm/functions/Function1;)V", "", UriUtil.LOCAL_RESOURCE_SCHEME, "setImageDrawable", "(Ljava/lang/Integer;)V", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "<init>", "(Lcom/avito/android/lib/design/list_item/ListItem;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ListItemViewHolder extends BaseViewHolder implements ListItemView {
    public final ListItem s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemViewHolder(@NotNull ListItem listItem) {
        super(listItem);
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        this.s = listItem;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ListItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemView
    public void setImageDrawable(@DrawableRes @Nullable Integer num) {
        if (num != null) {
            num.intValue();
            ListItem.setImageResource$default(this.s, num.intValue(), 0, 2, null);
        }
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemView
    public void setLink(@Nullable CharSequence charSequence, @NotNull DeepLink deepLink, @NotNull Function1<? super DeepLink, Unit> function1) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(function1, "onDeepLinkClickListener");
        if (charSequence != null) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new DeepLinkSpan(deepLink, new OnDeepLinkClickListener(deepLink, function1, charSequence) { // from class: com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemViewHolder$setLink$$inlined$apply$lambda$1
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
            ListItem listItem = this.s;
            MovementMethod instance = LinkMovementMethod.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
            listItem.setLinkMovementMethod(instance);
        }
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemView
    public void setSubtitle(@Nullable CharSequence charSequence) {
        this.s.setSubtitle(charSequence);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.s.setTitle(charSequence);
    }
}
