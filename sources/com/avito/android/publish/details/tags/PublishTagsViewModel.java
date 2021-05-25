package com.avito.android.publish.details.tags;

import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "", "itemId", "query", "", "categoryId", "", "loadSuggests", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onCleared", "()V", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel$d;", "kotlin.jvm.PlatformType", "e", "Lcom/jakewharton/rxrelay2/PublishRelay;", "suggestRequestStream", "Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "f", "Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "tagsInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/publish/details/tags/PublishTagsInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public class PublishTagsViewModel extends TagsViewModel {
    public final CompositeDisposable d;
    public final PublishRelay<d> e;
    public final PublishTagsInteractor f;

    public static final class a<T, R> implements Function<d, SingleSource<? extends Pair<? extends String, ? extends List<? extends TagItem>>>> {
        public final /* synthetic */ PublishTagsViewModel a;

        public a(PublishTagsViewModel publishTagsViewModel) {
            this.a = publishTagsViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Pair<? extends String, ? extends List<? extends TagItem>>> apply(d dVar) {
            d dVar2 = dVar;
            Intrinsics.checkNotNullParameter(dVar2, "request");
            return this.a.f.loadSuggests(dVar2.b, dVar2.c).map(new a2.a.a.e2.r.n0.a(dVar2));
        }
    }

    public static final class b<T> implements Consumer<Pair<? extends String, ? extends List<? extends TagItem>>> {
        public final /* synthetic */ PublishTagsViewModel a;

        public b(PublishTagsViewModel publishTagsViewModel) {
            this.a = publishTagsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends String, ? extends List<? extends TagItem>> pair) {
            Pair<? extends String, ? extends List<? extends TagItem>> pair2 = pair;
            this.a.applyTagsList((String) pair2.component1(), (List) pair2.component2());
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("PublishTagsViewModel", "Error on loading suggests", th);
        }
    }

    public static final class d {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final Integer c;

        public d(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "query");
            this.a = str;
            this.b = str2;
            this.c = num;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c);
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.c;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Request(itemId=");
            L.append(this.a);
            L.append(", query=");
            L.append(this.b);
            L.append(", categoryId=");
            return a2.b.a.a.a.p(L, this.c, ")");
        }
    }

    public PublishTagsViewModel(@NotNull PublishTagsInteractor publishTagsInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(publishTagsInteractor, "tagsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.f = publishTagsInteractor;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        PublishRelay<d> create = PublishRelay.create();
        this.e = create;
        Disposable subscribe = create.distinctUntilChanged().switchMapSingle(new a(this)).observeOn(schedulersFactory.mainThread()).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "suggestRequestStream.dis…ests\", e) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void loadSuggests(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "query");
        this.e.accept(new d(str, str2, num));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.dispose();
        super.onCleared();
    }
}
