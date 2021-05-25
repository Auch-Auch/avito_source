package com.avito.android.location_picker.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.location_picker.R;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.util.Views;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/location_picker/view/SuggestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/location_picker/view/SuggestionViewHolder;", "", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, "", "updateList", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "", "getItemId", "(I)J", "getItemCount", "()I", "holder", "onBindViewHolder", "(Lcom/avito/android/location_picker/view/SuggestionViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/location_picker/view/SuggestionViewHolder;", "Landroid/view/LayoutInflater;", "c", "Landroid/view/LayoutInflater;", "layoutInflater", "e", "Ljava/util/List;", "suggestionsList", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "d", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "subjectClicks", "Lio/reactivex/rxjava3/core/Observable;", "f", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionViewHolder> {
    public LayoutInflater c;
    public final PublishSubject<AddressSuggestion> d;
    public List<AddressSuggestion> e = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    public final Observable<AddressSuggestion> f;

    public static final class a<T, R> implements Function<Integer, AddressSuggestion> {
        public final /* synthetic */ SuggestionsAdapter a;

        public a(SuggestionsAdapter suggestionsAdapter) {
            this.a = suggestionsAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressSuggestion apply(Integer num) {
            Integer num2 = num;
            List list = this.a.e;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return (AddressSuggestion) list.get(num2.intValue());
        }
    }

    public SuggestionsAdapter() {
        PublishSubject<AddressSuggestion> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.d = create;
        this.f = create;
        setHasStableIds(true);
    }

    @NotNull
    public final Observable<AddressSuggestion> getClicks() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return (long) this.e.get(i).getTitle().hashCode();
    }

    public final void updateList(@NotNull List<AddressSuggestion> list) {
        Intrinsics.checkNotNullParameter(list, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS);
        this.e = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull SuggestionViewHolder suggestionViewHolder, int i) {
        Intrinsics.checkNotNullParameter(suggestionViewHolder, "holder");
        AddressSuggestion addressSuggestion = this.e.get(i);
        if (!(addressSuggestion.getTitle().length() == 0)) {
            if (!(addressSuggestion.getSubtitle().length() == 0)) {
                suggestionViewHolder.getTextView().setText(addressSuggestion.getTitle());
                suggestionViewHolder.getSubtextView().setText(addressSuggestion.getSubtitle());
                Views.setVisible(suggestionViewHolder.getSubtextView(), true);
                return;
            }
        }
        suggestionViewHolder.getTextView().setText(addressSuggestion.getTitle());
        Views.setVisible(suggestionViewHolder.getSubtextView(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public SuggestionViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater layoutInflater = this.c;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
            this.c = layoutInflater;
        }
        View inflate = layoutInflater.inflate(R.layout.location_picker_suggestion_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SuggestionViewHolder suggestionViewHolder = new SuggestionViewHolder(inflate);
        suggestionViewHolder.getClicks().map(new a(this)).subscribe(this.d);
        return suggestionViewHolder;
    }
}
