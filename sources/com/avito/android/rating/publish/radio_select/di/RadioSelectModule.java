package com.avito.android.rating.publish.radio_select.di;

import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.publish.radio_select.RadioSelectPresenter;
import com.avito.android.rating.publish.radio_select.RadioSelectPresenterImpl;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/publish/radio_select/di/RadioSelectModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItem;", "provideRadioSelectPublishRelay$rating_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideRadioSelectPublishRelay", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AdapterModule.class})
public final class RadioSelectModule {
    @NotNull
    public static final RadioSelectModule INSTANCE = new RadioSelectModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/publish/radio_select/di/RadioSelectModule$Declarations;", "", "Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter;", "bindRadioSelectPresenter", "(Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenterImpl;)Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItem;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        Consumer<RadioSelectItem> bindConsumer(@NotNull PublishRelay<RadioSelectItem> publishRelay);

        @Binds
        @NotNull
        Observable<RadioSelectItem> bindObservable(@NotNull PublishRelay<RadioSelectItem> publishRelay);

        @Binds
        @NotNull
        RadioSelectPresenter bindRadioSelectPresenter(@NotNull RadioSelectPresenterImpl radioSelectPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<RadioSelectItem> provideRadioSelectPublishRelay$rating_release() {
        PublishRelay<RadioSelectItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
