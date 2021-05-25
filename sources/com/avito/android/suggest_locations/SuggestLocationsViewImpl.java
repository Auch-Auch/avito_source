package com.avito.android.suggest_locations;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import com.avito.android.suggest_locations.adapter.SuggestLocationsAdapter;
import com.avito.android.util.AvitoSnackbar;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u00109\u001a\u000207¢\u0006\u0004\b:\u0010;J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006<"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsViewImpl;", "Lcom/avito/android/suggest_locations/SuggestLocationsView;", "", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "locations", "", "updateLocations", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "addresses", "updateAddresses", "", "textQuery", "updateTextQuery", "(Ljava/lang/String;)V", "clearLocations", "()V", "Lio/reactivex/rxjava3/core/Observable;", "myLocationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "addressClicks", "searchQueryChanged", "backPressed", "donePressed", "errorSnackbarClicks", "showError", "showNetworkError", "showEmptySuggestsError", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationsAdapter;", "e", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationsAdapter;", "suggestsAdapter", "Lkotlin/Lazy;", "Lcom/google/android/material/snackbar/Snackbar;", "d", "Lkotlin/Lazy;", "errorSnackbar", "Landroidx/recyclerview/widget/LinearLayoutManager;", "f", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "suggestsRecycler", "Lcom/avito/android/suggest_locations/SuggestLocationsToolbar;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/suggest_locations/SuggestLocationsToolbar;", "suggestsSearch", "Lcom/jakewharton/rxrelay3/PublishRelay;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "errorRelay", "Landroid/view/View;", "rootView", "", "suggestAddress", "autoOpenKeyboard", "<init>", "(Landroid/view/View;ZZ)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsViewImpl implements SuggestLocationsView {
    public final RecyclerView a;
    public final SuggestLocationsToolbar b;
    public final PublishRelay<Unit> c;
    public final Lazy<Snackbar> d;
    public final SuggestLocationsAdapter e;
    public final LinearLayoutManager f;

    public static final class a extends Lambda implements Function0<Snackbar> {
        public final /* synthetic */ View a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(0);
            this.a = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Snackbar invoke() {
            AvitoSnackbar avitoSnackbar = AvitoSnackbar.INSTANCE;
            View findViewById = this.a.findViewById(R.id.location_suggests_root);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            return AvitoSnackbar.make$default(avitoSnackbar, findViewById, "", -2, null, 0, null, null, 0, 0, 0, 1016, null);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SuggestLocationsViewImpl a;

        public b(SuggestLocationsViewImpl suggestLocationsViewImpl) {
            this.a = suggestLocationsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.c.accept(Unit.INSTANCE);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SuggestLocationsViewImpl a;

        public c(SuggestLocationsViewImpl suggestLocationsViewImpl) {
            this.a = suggestLocationsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.c.accept(Unit.INSTANCE);
        }
    }

    public SuggestLocationsViewImpl(@NotNull View view, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.location_suggests_recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.suggests_search);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.suggest_locations.SuggestLocationsToolbarImpl");
        SuggestLocationsToolbarImpl suggestLocationsToolbarImpl = (SuggestLocationsToolbarImpl) findViewById2;
        this.b = suggestLocationsToolbarImpl;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        this.d = t6.c.lazy(new a(view));
        SuggestLocationsAdapter suggestLocationsAdapter = new SuggestLocationsAdapter(z);
        this.e = suggestLocationsAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        this.f = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(suggestLocationsAdapter);
        if (!z) {
            String string = view.getContext().getString(R.string.sl_search_bar_hint);
            Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri…tring.sl_search_bar_hint)");
            suggestLocationsToolbarImpl.setHint(string);
        } else {
            String string2 = view.getContext().getString(R.string.sl_address_hint);
            Intrinsics.checkNotNullExpressionValue(string2, "rootView.context.getStri…R.string.sl_address_hint)");
            suggestLocationsToolbarImpl.setHint(string2);
        }
        if (z2 || z) {
            suggestLocationsToolbarImpl.showKeyboard();
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<AddressSuggestion> addressClicks() {
        return this.e.getAddressClicks();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<Unit> backPressed() {
        return this.b.backPressed();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void clearLocations() {
        this.e.clearList();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<String> donePressed() {
        return this.b.donePressed();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<Unit> errorSnackbarClicks() {
        return this.c;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<SuggestLocationItem> myLocationClicks() {
        return this.e.getClicks();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    @NotNull
    public Observable<String> searchQueryChanged() {
        return this.b.queryEmits();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void showEmptySuggestsError() {
        Snackbar value = this.d.getValue();
        value.setText(R.string.sl_error_no_suggests);
        if (!value.isShown()) {
            value.show();
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void showError() {
        Snackbar value = this.d.getValue();
        value.setText(R.string.sl_error_text);
        value.setAction(R.string.sl_error_action, new b(this));
        if (!value.isShown()) {
            value.show();
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void showNetworkError() {
        Snackbar value = this.d.getValue();
        value.setText(R.string.sl_network_error_text);
        value.setAction(R.string.sl_error_action, new c(this));
        if (!value.isShown()) {
            value.show();
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void updateAddresses(@NotNull List<AddressSuggestion> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        if (this.d.isInitialized() && this.d.getValue().isShown()) {
            this.d.getValue().dismiss();
        }
        this.e.updateAddressesList(list);
        this.f.scrollToPosition(0);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void updateLocations(@NotNull List<SuggestLocationItem> list) {
        Intrinsics.checkNotNullParameter(list, "locations");
        if (this.d.isInitialized() && this.d.getValue().isShown()) {
            this.d.getValue().dismiss();
        }
        this.e.updateLocationsList(list);
        this.f.scrollToPosition(0);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsView
    public void updateTextQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "textQuery");
        this.b.updateText(str);
    }
}
