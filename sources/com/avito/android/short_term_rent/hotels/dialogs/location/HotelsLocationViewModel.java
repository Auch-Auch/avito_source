package com.avito.android.short_term_rent.hotels.dialogs.location;

import a2.a.a.v2.b.i.c.f;
import a2.a.a.v2.b.i.c.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationFilterViewImpl;", "viewImpl", "", "init", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationFilterViewImpl;)V", "c", "()V", "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "d", "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "repository", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItem;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSuggestListChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "suggestListChanges", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "f", "Ljava/util/List;", "defaultLocations", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;Lcom/avito/android/util/SchedulersFactory3;Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationViewModel extends ViewModel {
    @NotNull
    public final SingleLiveEvent<List<HotelsLocationDialogItem>> c = new SingleLiveEvent<>();
    public final HotelsRepository d;
    public final SchedulersFactory3 e;
    public final List<HotelsLocation> f;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ HotelsLocationViewModel a;

        public a(HotelsLocationViewModel hotelsLocationViewModel) {
            this.a = hotelsLocationViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            HotelsLocationViewModel hotelsLocationViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "searchText");
            HotelsLocationViewModel.access$requestSuggest(hotelsLocationViewModel, str2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public HotelsLocationViewModel(@NotNull HotelsRepository hotelsRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull List<HotelsLocation> list) {
        Intrinsics.checkNotNullParameter(hotelsRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(list, "defaultLocations");
        this.d = hotelsRepository;
        this.e = schedulersFactory3;
        this.f = list;
    }

    public static final void access$requestSuggest(HotelsLocationViewModel hotelsLocationViewModel, String str) {
        Objects.requireNonNull(hotelsLocationViewModel);
        if (str.length() == 0) {
            hotelsLocationViewModel.c();
        } else {
            hotelsLocationViewModel.d.getHotelsLocationsSuggest(str).subscribeOn(hotelsLocationViewModel.e.io()).observeOn(hotelsLocationViewModel.e.mainThread()).subscribe(new f(hotelsLocationViewModel), new g(hotelsLocationViewModel));
        }
    }

    public final void c() {
        this.c.setValue(HotelsLocationViewModelKt.access$toDialogItems(this.f));
    }

    @NotNull
    public final SingleLiveEvent<List<HotelsLocationDialogItem>> getSuggestListChanges() {
        return this.c;
    }

    public final void init(@NotNull HotelsLocationFilterViewImpl hotelsLocationFilterViewImpl) {
        Intrinsics.checkNotNullParameter(hotelsLocationFilterViewImpl, "viewImpl");
        hotelsLocationFilterViewImpl.getSearchTextChanges().observeOn(this.e.mainThread()).subscribe(new a(this), b.a);
        c();
    }
}
