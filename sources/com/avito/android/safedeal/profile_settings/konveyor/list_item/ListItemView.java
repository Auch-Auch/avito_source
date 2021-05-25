package com.avito.android.safedeal.profile_settings.konveyor.list_item;

import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006JD\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00042\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onDeepLinkClickListener", "setLink", "(Ljava/lang/CharSequence;Lcom/avito/android/deep_linking/links/DeepLink;Lkotlin/jvm/functions/Function1;)V", "", UriUtil.LOCAL_RESOURCE_SCHEME, "setImageDrawable", "(Ljava/lang/Integer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ListItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ListItemView listItemView) {
            ItemView.DefaultImpls.onUnbind(listItemView);
        }
    }

    void setImageDrawable(@DrawableRes @Nullable Integer num);

    void setLink(@Nullable CharSequence charSequence, @NotNull DeepLink deepLink, @NotNull Function1<? super DeepLink, Unit> function1);

    void setSubtitle(@Nullable CharSequence charSequence);

    void setTitle(@Nullable CharSequence charSequence);
}
