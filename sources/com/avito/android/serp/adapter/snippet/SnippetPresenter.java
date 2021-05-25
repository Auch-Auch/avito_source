package com.avito.android.serp.adapter.snippet;

import com.avito.android.component.banner_card.BannerCard;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/serp/adapter/snippet/SnippetView;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "Impl", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetPresenter extends ItemPresenter<SnippetView, SnippetItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B]\b\u0007\u0012\u001a\b\u0001\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u000b\u0012\u001a\b\u0001\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u000b\u0012\u001a\b\u0001\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR(\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetPresenter$Impl;", "Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "Lcom/avito/android/serp/adapter/snippet/SnippetView;", "view", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/snippet/SnippetView;Lcom/avito/android/serp/adapter/snippet/SnippetItem;I)V", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "", "c", "Lcom/jakewharton/rxrelay3/Relay;", "visibleConsumer", AuthSource.SEND_ABUSE, "actionButtonClickConsumer", AuthSource.BOOKING_ORDER, "closeButtonClickConsumer", "<init>", "(Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SnippetPresenter {
        public final Relay<Pair<SnippetItem, Integer>> a;
        public final Relay<Pair<SnippetItem, Integer>> b;
        public final Relay<Pair<SnippetItem, Boolean>> c;

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Object c;
            public final /* synthetic */ Object d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i, int i2, Object obj, Object obj2) {
                super(0);
                this.a = i;
                this.b = i2;
                this.c = obj;
                this.d = obj2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    ((Impl) this.c).a.accept(TuplesKt.to((SnippetItem) this.d, Integer.valueOf(this.b)));
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    ((Impl) this.c).b.accept(TuplesKt.to((SnippetItem) this.d, Integer.valueOf(this.b)));
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            }
        }

        public static final class b extends Lambda implements Function1<Boolean, Unit> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ SnippetItem b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Impl impl, SnippetItem snippetItem) {
                super(1);
                this.a = impl;
                this.b = snippetItem;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Boolean bool) {
                this.a.c.accept(TuplesKt.to(this.b, Boolean.valueOf(bool.booleanValue())));
                return Unit.INSTANCE;
            }
        }

        @Inject
        public Impl(@SnippetClick @NotNull Relay<Pair<SnippetItem, Integer>> relay, @SnippetClose @NotNull Relay<Pair<SnippetItem, Integer>> relay2, @SnippetVisibility @NotNull Relay<Pair<SnippetItem, Boolean>> relay3) {
            Intrinsics.checkNotNullParameter(relay, "actionButtonClickConsumer");
            Intrinsics.checkNotNullParameter(relay2, "closeButtonClickConsumer");
            Intrinsics.checkNotNullParameter(relay3, "visibleConsumer");
            this.a = relay;
            this.b = relay2;
            this.c = relay3;
        }

        public void bindView(@NotNull SnippetView snippetView, @NotNull SnippetItem snippetItem, int i) {
            Intrinsics.checkNotNullParameter(snippetView, "view");
            Intrinsics.checkNotNullParameter(snippetItem, "item");
            snippetView.setImage(AvitoPictureKt.pictureOf$default(snippetItem.getImage(), false, 0.0f, 0.0f, null, 28, null));
            snippetView.setMessage(snippetItem.getText());
            snippetView.setActions(d.listOf(new BannerCard.Action(snippetItem.getAction().getTitle(), new a(0, i, this, snippetItem))));
            snippetView.setCloseButtonVisible(snippetItem.getClosable());
            snippetView.setCloseClickListener(new a(1, i, this, snippetItem));
            snippetView.setOnVisibleCallback(new b(this, snippetItem));
        }
    }
}
