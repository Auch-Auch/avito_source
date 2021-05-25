package com.avito.android.rating.publish.select_advert.adapter.error_snippet;

import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItemPresenterImpl;", "Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItemPresenter;", "Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItemView;", "view", "Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItemView;Lcom/avito/android/rating/publish/select_advert/adapter/error_snippet/ErrorSnippetItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorSnippetItemPresenterImpl implements ErrorSnippetItemPresenter {
    public final Consumer<SelectAdvertAction> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ErrorSnippetItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ErrorSnippetItemPresenterImpl errorSnippetItemPresenterImpl, ErrorSnippetItem errorSnippetItem) {
            super(0);
            this.a = errorSnippetItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(new SelectAdvertAction.RefreshClick());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ErrorSnippetItemPresenterImpl(@NotNull Consumer<SelectAdvertAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ErrorSnippetItemView errorSnippetItemView, @NotNull ErrorSnippetItem errorSnippetItem, int i) {
        Intrinsics.checkNotNullParameter(errorSnippetItemView, "view");
        Intrinsics.checkNotNullParameter(errorSnippetItem, "item");
        errorSnippetItemView.setMessage(errorSnippetItem.getMessage());
        errorSnippetItemView.setRefreshListener(new a(this, errorSnippetItem));
    }
}
