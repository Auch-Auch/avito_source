package com.avito.android.extended_profile.adapter.info;

import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenter;", "Lcom/avito/android/extended_profile/adapter/info/InfoItemView;", "view", "Lcom/avito/android/extended_profile/adapter/info/InfoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/info/InfoItemView;Lcom/avito/android/extended_profile/adapter/info/InfoItem;I)V", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItemPresenterImpl implements InfoItemPresenter {

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ InfoItem a;
        public final /* synthetic */ InfoItemView b;

        public a(InfoItem infoItem, InfoItemView infoItemView) {
            this.a = infoItem;
            this.b = infoItemView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.setCollapsed(false);
            this.b.showText(this.a.getText(), this.a.isCollapsed());
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InfoItemView a;
        public final /* synthetic */ Disposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InfoItemView infoItemView, Disposable disposable) {
            super(0);
            this.a = infoItemView;
            this.b = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.dispose();
            return Unit.INSTANCE;
        }
    }

    public void bindView(@NotNull InfoItemView infoItemView, @NotNull InfoItem infoItem, int i) {
        Intrinsics.checkNotNullParameter(infoItemView, "view");
        Intrinsics.checkNotNullParameter(infoItem, "item");
        infoItemView.showText(infoItem.getText(), infoItem.isCollapsed());
        if (infoItem.isCollapsed()) {
            infoItemView.setUnbindListener(new b(infoItemView, infoItemView.getExpandClicks().subscribe(new a(infoItem, infoItemView))));
        }
    }
}
