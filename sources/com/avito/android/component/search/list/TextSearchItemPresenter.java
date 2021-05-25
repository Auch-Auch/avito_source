package com.avito.android.component.search.list;

import com.avito.android.component.search.SuggestItemListener;
import com.avito.android.component.search.TextSearchItem;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.IconSize;
import com.avito.android.remote.model.search.suggest.IconSource;
import com.avito.android.remote.model.search.suggest.LocalIcon;
import com.avito.android.remote.model.search.suggest.Padding;
import com.avito.android.remote.model.search.suggest.ServerIcon;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.TextSuggestItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/search/list/TextSearchItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/component/search/list/TextSuggestItemView;", "Lcom/avito/android/component/search/TextSearchItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/search/list/TextSuggestItemView;Lcom/avito/android/component/search/TextSearchItem;I)V", "Lcom/avito/android/component/search/SuggestItemListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/component/search/SuggestItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/component/search/SuggestItemListener;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextSearchItemPresenter implements ItemPresenter<TextSuggestItemView, TextSearchItem> {
    public final SuggestItemListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TextSearchItemPresenter a;
        public final /* synthetic */ TextSuggestItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TextSearchItemPresenter textSearchItemPresenter, TextSuggestItem textSuggestItem) {
            super(0);
            this.a = textSearchItemPresenter;
            this.b = textSuggestItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            List<SuggestAction> actions = this.b.getActions();
            if (actions != null) {
                this.a.a.onItemClicked(actions);
            }
            return Unit.INSTANCE;
        }
    }

    public TextSearchItemPresenter(@NotNull SuggestItemListener suggestItemListener) {
        Intrinsics.checkNotNullParameter(suggestItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = suggestItemListener;
    }

    public void bindView(@NotNull TextSuggestItemView textSuggestItemView, @NotNull TextSearchItem textSearchItem, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(textSuggestItemView, "view");
        Intrinsics.checkNotNullParameter(textSearchItem, "item");
        TextSuggestItem suggestItem = textSearchItem.getSuggestItem();
        textSuggestItemView.setClickListener(new a(this, suggestItem));
        textSuggestItemView.setTitle(suggestItem.getTitle());
        textSuggestItemView.setDescription(suggestItem.getDescription());
        textSuggestItemView.setMinimalHeight(suggestItem.getMinHeight());
        Padding padding = suggestItem.getPadding();
        Integer num2 = null;
        textSuggestItemView.setPadding(padding != null ? Integer.valueOf(padding.getTop()) : null, padding != null ? Integer.valueOf(padding.getBottom()) : null);
        IconSource icon = suggestItem.getIcon();
        if (icon instanceof LocalIcon) {
            Integer num3 = (Integer) TextSearchItemPresenterKt.access$getLocalIconMapping$p().get(((LocalIcon) icon).getType());
            if (num3 != null) {
                textSuggestItemView.setIcon(num3.intValue());
            } else {
                textSuggestItemView.clearIcon();
            }
        } else if (icon instanceof ServerIcon) {
            ServerIcon serverIcon = (ServerIcon) icon;
            SimplePicture simplePicture = new SimplePicture(serverIcon.getUri());
            IconSize size = serverIcon.getSize();
            if (size != null) {
                num2 = Integer.valueOf(size.getWidth());
                num = Integer.valueOf(size.getHeight());
            } else {
                num = null;
            }
            textSuggestItemView.setIcon(simplePicture, num2, num);
        } else {
            textSuggestItemView.clearIcon();
        }
    }
}
