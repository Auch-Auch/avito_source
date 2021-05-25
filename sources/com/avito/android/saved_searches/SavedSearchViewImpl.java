package com.avito.android.saved_searches;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bM\u0010NJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0010\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u0012\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J=\u0010\u0013\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004 \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J=\u0010\u0014\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J=\u0010\u0015\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 RD\u0010$\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#RD\u0010&\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)RD\u0010,\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004 \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010#RD\u0010.\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010#R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;RD\u0010>\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010#R\u0018\u0010@\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010;R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010)R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u00101¨\u0006O"}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchViewImpl;", "Lcom/avito/android/saved_searches/SavedSearchView;", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "", "selectedId", "", "pushEnabled", "", "show", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/Integer;Z)V", "closeDialog", "()V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "applyAction", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "deleteAction", "frequencyChangedAction", "closeAction", "openSettingsAction", "showSubscriptionMessage", "showUnsubscriptionMessage", "showSubscriptionEditedMessage", "", "message", "showMessage", "(Ljava/lang/String;)V", "showErrorMessage", "Lcom/avito/android/lib/design/chips/Chipable;", "i", "Lcom/avito/android/lib/design/chips/Chipable;", "selectedChipable", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "applyActionRelay", "k", "deleteActionRelay", "Lcom/avito/android/lib/design/button/Button;", "f", "Lcom/avito/android/lib/design/button/Button;", "applyButton", "l", "frequencyChangedRelay", AuthSource.OPEN_CHANNEL_LIST, "closeRelay", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "searchDescription", g.a, "applyButtonWithoutPush", "Lcom/avito/android/saved_searches/SavedSearchResourceProviderImpl;", "o", "Lcom/avito/android/saved_searches/SavedSearchResourceProviderImpl;", "resourceProvider", "Landroid/view/View;", "p", "Landroid/view/View;", "rootView", "n", "openSettingsRelay", AuthSource.BOOKING_ORDER, "containerView", "Lcom/avito/android/lib/design/chips/Chips;", "d", "Lcom/avito/android/lib/design/chips/Chips;", "pushFrequencyChips", "h", "openSettingsBtn", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "e", "pushDisabledHint", "<init>", "(Landroid/view/View;)V", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public final class SavedSearchViewImpl implements SavedSearchView {
    public BottomSheetDialog a;
    public View b;
    public TextView c;
    public Chips d;
    public TextView e;
    public Button f;
    public Button g;
    public Button h;
    public Chipable i;
    public final PublishRelay<Unit> j = PublishRelay.create();
    public final PublishRelay<Unit> k = PublishRelay.create();
    public final PublishRelay<Integer> l = PublishRelay.create();
    public final PublishRelay<Unit> m = PublishRelay.create();
    public final PublishRelay<Unit> n = PublishRelay.create();
    public final SavedSearchResourceProviderImpl o;
    public final View p;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ boolean d;

        public a(int i, Object obj, Object obj2, boolean z) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = z;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((SavedSearchViewImpl) this.b).j.accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((SavedSearchViewImpl) this.b).j.accept(Unit.INSTANCE);
            } else if (i == 2) {
                ((SavedSearchViewImpl) this.b).n.accept(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj, Object obj2, boolean z) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                PublishRelay publishRelay = ((SavedSearchViewImpl) this.b).k;
                Unit unit = Unit.INSTANCE;
                publishRelay.accept(unit);
                return unit;
            } else if (i == 1) {
                PublishRelay publishRelay2 = ((SavedSearchViewImpl) this.b).m;
                Unit unit2 = Unit.INSTANCE;
                publishRelay2.accept(unit2);
                ((SavedSearchViewImpl) this.b).closeDialog();
                return unit2;
            } else {
                throw null;
            }
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ SavedSearchViewImpl a;

        public c(SavedSearchViewImpl savedSearchViewImpl, SearchPushSubscription searchPushSubscription, boolean z) {
            this.a = savedSearchViewImpl;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.m.accept(Unit.INSTANCE);
            SavedSearchViewImpl.access$invalidateView(this.a);
        }
    }

    public SavedSearchViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.p = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.o = new SavedSearchResourceProviderImpl(context);
    }

    public static final void access$invalidateView(SavedSearchViewImpl savedSearchViewImpl) {
        savedSearchViewImpl.b = null;
        savedSearchViewImpl.c = null;
        savedSearchViewImpl.d = null;
        savedSearchViewImpl.f = null;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void closeDialog() {
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:100:0x00c1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.avito.android.lib.design.chips.Chips] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // com.avito.android.saved_searches.SavedSearchView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show(@org.jetbrains.annotations.NotNull com.avito.android.deep_linking.links.SearchPushSubscription r9, @org.jetbrains.annotations.Nullable java.lang.Integer r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 512
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.saved_searches.SavedSearchViewImpl.show(com.avito.android.deep_linking.links.SearchPushSubscription, java.lang.Integer, boolean):void");
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showErrorMessage() {
        View view = this.p;
        String errorMessage = this.o.errorMessage();
        Context context = this.p.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        Views.showSnackBar$default(view, errorMessage, 0, (String) null, 0, (Function0) null, (Function0) null, Contexts.getColorByAttr(context, R.attr.red), 62, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.p, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionEditedMessage() {
        Views.showSnackBar$default(this.p, this.o.subscriptionEditedMessage(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionMessage() {
        Views.showSnackBar$default(this.p, this.o.subscriptionMessage(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showUnsubscriptionMessage() {
        Views.showSnackBar$default(this.p, this.o.unsubscriptionMessage(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public PublishRelay<Unit> applyAction() {
        return this.j;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public PublishRelay<Unit> closeAction() {
        return this.m;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public PublishRelay<Unit> deleteAction() {
        return this.k;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public PublishRelay<Integer> frequencyChangedAction() {
        return this.l;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public PublishRelay<Unit> openSettingsAction() {
        return this.n;
    }
}
