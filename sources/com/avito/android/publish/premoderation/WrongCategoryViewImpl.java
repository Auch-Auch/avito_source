package com.avito.android.publish.premoderation;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.publish.R;
import com.avito.android.publish.premoderation.SelectListWidget;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.publish.view.publish_button.PublishButtonImpl;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u000201¢\u0006\u0004\b7\u00108J3\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ'\u0010\u0010\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR:\u0010 \u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\n0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/publish/premoderation/WrongCategoryViewImpl;", "Lcom/avito/android/publish/premoderation/WrongCategoryView;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", "continueButtonClicks", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "Lio/reactivex/Observable;", "backClicks", "()Lio/reactivex/Observable;", "", "categoryWizardIdSelection", "", "Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", "suggestedItems", "initialCheckedItem", "fillCategoryList", "(Ljava/util/List;Lcom/avito/android/publish/premoderation/SelectListWidget$Data;)V", "", "isEnable", "continueButtonAvailability", "(Z)V", "Lcom/avito/android/publish/premoderation/SelectListWidget;", "c", "Lcom/avito/android/publish/premoderation/SelectListWidget;", "categoryList", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", MessengerShareContentUtility.SUBTITLE, "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "publishButtonClicksStream", "Lkotlin/Function2;", g.a, "Lkotlin/jvm/functions/Function2;", "categoryListListener", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "e", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "publishButton", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "d", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "lastSelectedCategory", "Landroid/view/View;", "h", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WrongCategoryViewImpl implements WrongCategoryView {
    public final Toolbar a;
    public final TextView b;
    public final SelectListWidget c;
    public final BehaviorRelay<String> d;
    public final PublishButton e;
    public final PublishRelay<Unit> f = PublishRelay.create();
    public final Function2<SelectListWidget.Data, Boolean, Unit> g = new b(this);
    @NotNull
    public final View h;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WrongCategoryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WrongCategoryViewImpl wrongCategoryViewImpl) {
            super(0);
            this.a = wrongCategoryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.f;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final class b extends Lambda implements Function2<SelectListWidget.Data, Boolean, Unit> {
        public final /* synthetic */ WrongCategoryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(WrongCategoryViewImpl wrongCategoryViewImpl) {
            super(2);
            this.a = wrongCategoryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(SelectListWidget.Data data, Boolean bool) {
            SelectListWidget.Data data2 = data;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(data2, "item");
            if (booleanValue) {
                this.a.d.accept(data2.getItemId());
            }
            return Unit.INSTANCE;
        }
    }

    public WrongCategoryViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = view;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.categories);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.publish.premoderation.SelectListWidget");
        this.c = (SelectListWidget) findViewById3;
        BehaviorRelay<String> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.d = create;
        PublishButtonImpl publishButtonImpl = new PublishButtonImpl(view);
        this.e = publishButtonImpl;
        publishButtonImpl.setText(view.getContext().getText(R.string.wrong_category_continue).toString());
        publishButtonImpl.setClickListener(new a(this));
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryView
    @NotNull
    public Observable<Unit> backClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryView
    @NotNull
    public Observable<String> categoryWizardIdSelection() {
        return this.d;
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryView
    public void continueButtonAvailability(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryView
    public void fillCategoryList(@NotNull List<SelectListWidget.Data> list, @Nullable SelectListWidget.Data data) {
        Intrinsics.checkNotNullParameter(list, "suggestedItems");
        this.c.setValues(list, data, this.g);
        this.b.setText(this.h.getResources().getString(list.size() == 2 ? R.string.wrong_category_caption : R.string.wrong_category_caption_plural));
    }

    @NotNull
    public final View getView() {
        return this.h;
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryView
    public PublishRelay<Unit> continueButtonClicks() {
        return this.f;
    }
}
