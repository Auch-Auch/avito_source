package com.avito.android.abuse.details.adapter;

import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/abuse/details/adapter/CommentItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/CommentItemPresenter;", "Lcom/avito/android/abuse/details/adapter/CommentItemView;", "view", "Lcom/avito/android/abuse/details/adapter/AbuseField$Comment;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/abuse/details/adapter/CommentItemView;Lcom/avito/android/abuse/details/adapter/AbuseField$Comment;I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "valueConsumer", "<init>", "(Lcom/jakewharton/rxrelay3/PublishRelay;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class CommentItemPresenterImpl implements CommentItemPresenter {
    public final PublishRelay<AbuseField> a;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ CommentItemPresenterImpl a;
        public final /* synthetic */ AbuseField.Comment b;

        public a(CommentItemPresenterImpl commentItemPresenterImpl, AbuseField.Comment comment) {
            this.a = commentItemPresenterImpl;
            this.b = comment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            if ((r4.length() > 0) != false) goto L_0x0013;
         */
        @Override // io.reactivex.rxjava3.functions.Consumer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r4 = (java.lang.String) r4
                r0 = 0
                r1 = 1
                if (r4 == 0) goto L_0x0012
                int r2 = r4.length()
                if (r2 <= 0) goto L_0x000e
                r2 = 1
                goto L_0x000f
            L_0x000e:
                r2 = 0
            L_0x000f:
                if (r2 == 0) goto L_0x0012
                goto L_0x0013
            L_0x0012:
                r4 = r0
            L_0x0013:
                com.avito.android.abuse.details.adapter.AbuseField$Comment r0 = r3.b
                java.lang.String r0 = r0.getMessage()
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
                r0 = r0 ^ r1
                if (r0 == 0) goto L_0x0030
                com.avito.android.abuse.details.adapter.AbuseField$Comment r0 = r3.b
                r0.setMessage(r4)
                com.avito.android.abuse.details.adapter.CommentItemPresenterImpl r4 = r3.a
                com.jakewharton.rxrelay3.PublishRelay r4 = com.avito.android.abuse.details.adapter.CommentItemPresenterImpl.access$getValueConsumer$p(r4)
                com.avito.android.abuse.details.adapter.AbuseField$Comment r0 = r3.b
                r4.accept(r0)
            L_0x0030:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.abuse.details.adapter.CommentItemPresenterImpl.a.accept(java.lang.Object):void");
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CommentItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CommentItemView commentItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = commentItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CommentItemPresenterImpl(@Named("changed") @NotNull PublishRelay<AbuseField> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "valueConsumer");
        this.a = publishRelay;
    }

    public void bindView(@NotNull CommentItemView commentItemView, @NotNull AbuseField.Comment comment, int i) {
        Intrinsics.checkNotNullParameter(commentItemView, "view");
        Intrinsics.checkNotNullParameter(comment, "item");
        String message = comment.getMessage();
        if (message == null) {
            message = "";
        }
        commentItemView.setText(message);
        commentItemView.setHint(comment.getHint());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        commentItemView.setUnbindListener(new b(commentItemView, compositeDisposable));
        Disposable subscribe = commentItemView.textChangeCallbacks().subscribe(new a(this, comment));
        Intrinsics.checkNotNullExpressionValue(subscribe, "textChangeCallbacks().su…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
