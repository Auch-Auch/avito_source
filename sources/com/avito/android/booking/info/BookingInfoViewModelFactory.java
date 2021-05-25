package com.avito.android.booking.info;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.di.qualifier.FromBlock;
import com.avito.android.booking.di.qualifier.ItemId;
import com.avito.android.booking.remote.converter.BookingInfoActionConverter;
import com.avito.android.booking.remote.converter.BookingInfoItemConverter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BU\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010!\u001a\u00020\u001c¢\u0006\u0004\b*\u0010+J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", "Lcom/avito/android/booking/info/BookingInfoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/booking/info/BookingInfoInteractor;", "interactor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "e", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "c", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "bookingInfoItemConverter", "", "h", "Ljava/lang/String;", "itemId", "i", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "d", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "bookingInfoActionConverter", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "f", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/booking/info/BookingInfoInteractor;Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoViewModelFactory implements ViewModelProvider.Factory {
    public final DeepLinkIntentFactory a;
    public final BookingInfoInteractor b;
    public final BookingInfoItemConverter c;
    public final BookingInfoActionConverter d;
    public final AdapterPresenter e;
    public final TypedErrorThrowableConverter f;
    public final SchedulersFactory3 g;
    public final String h;
    public final String i;

    @Inject
    public BookingInfoViewModelFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull BookingInfoInteractor bookingInfoInteractor, @NotNull BookingInfoItemConverter bookingInfoItemConverter, @NotNull BookingInfoActionConverter bookingInfoActionConverter, @NotNull AdapterPresenter adapterPresenter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @ItemId @NotNull String str, @FromBlock @NotNull String str2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(bookingInfoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(bookingInfoItemConverter, "bookingInfoItemConverter");
        Intrinsics.checkNotNullParameter(bookingInfoActionConverter, "bookingInfoActionConverter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers3");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.a = deepLinkIntentFactory;
        this.b = bookingInfoInteractor;
        this.c = bookingInfoItemConverter;
        this.d = bookingInfoActionConverter;
        this.e = adapterPresenter;
        this.f = typedErrorThrowableConverter;
        this.g = schedulersFactory3;
        this.h = str;
        this.i = str2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(BookingInfoViewModelImpl.class)) {
            return cls.cast(new BookingInfoViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
