package com.avito.android.short_term_rent.hotels.dialogs.location;

import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\u000f\u0012\u0006\u0010N\u001a\u00020\u0016¢\u0006\u0004\bO\u0010PJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102RD\u00108\u001a0\u0012\f\u0012\n 4*\u0004\u0018\u00010\u001b0\u001b 4*\u0017\u0012\f\u0012\n 4*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u0013¢\u0006\u0002\b50\u0013¢\u0006\u0002\b58\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R.\u0010?\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=8V@VX\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010.R\u0016\u0010G\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010'R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JRD\u0010M\u001a0\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u0004 4*\u0017\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0013¢\u0006\u0002\b50\u0013¢\u0006\u0002\b58\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u00107¨\u0006R"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationFilterViewImpl;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationView;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemClickListener;", "", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItem;", "items", "", "setItemsView", "(Ljava/util/List;)V", "Lkotlin/Function0;", "resetAction", "setResetAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "setCloseAction", "", VKApiConst.POSITION, "onItemClicked", "(I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "selectAction", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Landroid/view/View;", "c", "Landroid/view/View;", "closeButton", "Lio/reactivex/rxjava3/core/Observable;", "", "k", "Lio/reactivex/rxjava3/core/Observable;", "getSearchTextChanges", "()Lio/reactivex/rxjava3/core/Observable;", "searchTextChanges", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "resetButton", "Lcom/avito/android/lib/design/input/Input;", "e", "Lcom/avito/android/lib/design/input/Input;", "searchFilterInput", "h", "Ljava/util/List;", "visibleItems", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "searchTextRelay", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "closeIcon", "Landroid/os/Parcelable;", "value", "state", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", g.a, AuthSource.SEND_ABUSE, "title", "Lcom/avito/konveyor/ItemBinder;", "l", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "j", "clickRelay", "rootView", "<init>", "(Landroid/view/View;)V", "State", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationFilterViewImpl implements HotelsLocationView, HotelsLocationDialogItemClickListener {
    public final TextView a;
    public final TextView b;
    public final View c;
    public final RecyclerView d;
    public final Input e;
    public final Drawable f;
    public List<HotelsLocationDialogItem> g;
    public List<HotelsLocationDialogItem> h;
    public final PublishRelay<String> i;
    public final PublishRelay<HotelsLocationDialogItem> j = PublishRelay.create();
    @NotNull
    public final Observable<String> k;
    public final ItemBinder l;
    public final SimpleAdapterPresenter m;

    @Parcelize
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        @Nullable
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new State(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(@Nullable String str) {
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public HotelsLocationFilterViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.hotels_filter_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…tels_filter_dialog_title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = view.findViewById(R.id.hotels_filter_reset_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.hotels_filter_close_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.filter_options_recycler_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.d = recyclerView;
        View findViewById5 = view.findViewById(R.id.search_edit_text);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById5;
        this.e = input;
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_close_24_black);
        this.f = drawable;
        List<HotelsLocationDialogItem> emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.g = emptyList;
        this.h = emptyList;
        PublishRelay<String> create = PublishRelay.create();
        this.i = create;
        Intrinsics.checkNotNullExpressionValue(create, "searchTextRelay");
        this.k = create;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        ItemBinder build = new ItemBinder.Builder().registerItem(new HotelsLocationDialogSelectItemBlueprint(new HotelsLocationDialogItemPresenter(this))).build();
        this.l = build;
        this.m = new SimpleAdapterPresenter(build, build);
        textView.setText(view.getResources().getString(R.string.hotels_location_dialog_title));
        findViewById3.setBackground(drawable);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        input.addTextChangedListener(new SimpleTextWatcher() { // from class: com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationFilterViewImpl$setupSearchInput$1
            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                HotelsLocationFilterViewImpl.this.i.accept(charSequence.toString());
            }
        });
        input.setHint(resources.getString(R.string.hotels_location_filter_hint));
    }

    @NotNull
    public final Observable<String> getSearchTextChanges() {
        return this.k;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    @Nullable
    public Parcelable getState() {
        return new State(this.e.getDeformattedText());
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItemClickListener
    public void onItemClicked(int i2) {
        if ((!this.h.isEmpty()) && i2 >= 0 && i2 < this.h.size()) {
            this.j.accept(this.h.get(i2));
        }
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationView
    @NotNull
    public PublishRelay<HotelsLocationDialogItem> selectAction() {
        PublishRelay<HotelsLocationDialogItem> publishRelay = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "clickRelay");
        return publishRelay;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setCloseAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        this.c.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationView
    public void setItemsView(@NotNull List<HotelsLocationDialogItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.g = list;
        this.h = list;
        this.m.onDataSourceChanged(new ListDataSource(list));
        if (this.d.getAdapter() == null) {
            this.d.setAdapter(new SimpleRecyclerAdapter(this.m, this.l));
            return;
        }
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setResetAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "resetAction");
        this.b.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof State) {
            Input.setText$default(this.e, ((State) parcelable).a, false, 2, null);
        }
    }
}
