package com.avito.android.authorization.login_protection.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter;
import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.avito.android.authorization.login_protection.adapter.another.di.AnotherPhoneItemModule;
import com.avito.android.authorization.login_protection.adapter.not_found.di.PhoneNotFoundItemModule;
import com.avito.android.authorization.login_protection.adapter.phone.di.PhoneItemModule;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatterImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListModule;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "providePhoneActionRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AdapterModule.class, PhoneItemModule.class, AnotherPhoneItemModule.class, PhoneNotFoundItemModule.class})
public final class LoginProtectionPhoneListModule {
    @NotNull
    public static final LoginProtectionPhoneListModule INSTANCE = new LoginProtectionPhoneListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListModule$Declarations;", "", "Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl;", "impl", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "bindAntihackPresenter", "(Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl;)Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindPhoneActionConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/core/Observable;", "bindPhoneActionObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatterImpl;", "Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "bindPhoneFormatter", "(Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatterImpl;)Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractorImpl;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "bindTfaInteractor", "(Lcom/avito/android/code_confirmation/tfa/TfaInteractorImpl;)Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "bindCodeConfirmationResourceProvider", "(Lcom/avito/android/code_confirmation/CodeConfirmationResourceProviderImpl;)Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        LoginProtectionPhoneListPresenter bindAntihackPresenter(@NotNull LoginProtectionListPresenterImpl loginProtectionListPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CodeConfirmationResourceProvider bindCodeConfirmationResourceProvider(@NotNull CodeConfirmationResourceProviderImpl codeConfirmationResourceProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<PhoneListAction> bindPhoneActionConsumer(@NotNull PublishRelay<PhoneListAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<PhoneListAction> bindPhoneActionObservable(@NotNull PublishRelay<PhoneListAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        LoginProtectionPhoneFormatter bindPhoneFormatter(@NotNull LoginProtectionPhoneFormatterImpl loginProtectionPhoneFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        TfaInteractor bindTfaInteractor(@NotNull TfaInteractorImpl tfaInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RecyclerView.Adapter<?> provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<PhoneListAction> providePhoneActionRelay() {
        PublishRelay<PhoneListAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
