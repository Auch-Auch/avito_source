package com.avito.android.authorization.login_suggests.adapter.error_snippet;

import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItemPresenterImpl;", "Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItemPresenter;", "Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItemView;", "view", "Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItemView;Lcom/avito/android/authorization/login_suggests/adapter/error_snippet/ErrorSnippetItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "refreshConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorSnippetItemPresenterImpl implements ErrorSnippetItemPresenter {
    public final Consumer<LoginSuggestsItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ErrorSnippetItemPresenterImpl a;
        public final /* synthetic */ ErrorSnippetItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ErrorSnippetItemPresenterImpl errorSnippetItemPresenterImpl, ErrorSnippetItem errorSnippetItem) {
            super(0);
            this.a = errorSnippetItemPresenterImpl;
            this.b = errorSnippetItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public ErrorSnippetItemPresenterImpl(@NotNull Consumer<LoginSuggestsItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "refreshConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ErrorSnippetItemView errorSnippetItemView, @NotNull ErrorSnippetItem errorSnippetItem, int i) {
        Intrinsics.checkNotNullParameter(errorSnippetItemView, "view");
        Intrinsics.checkNotNullParameter(errorSnippetItem, "item");
        errorSnippetItemView.setMessage(errorSnippetItem.getMessage());
        errorSnippetItemView.setRefreshListener(new a(this, errorSnippetItem));
    }
}
