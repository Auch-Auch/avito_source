package com.avito.android.code_confirmation.di;

import android.app.Activity;
import android.content.IntentFilter;
import com.avito.android.code_confirmation.CodeConfirmationPresenter;
import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeReceiver;
import com.avito.android.code_confirmation.CodeReceiverImpl;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.code_confirmation.timer.RxTimerImpl;
import com.avito.android.code_confirmation.timer.TimerFormatter;
import com.avito.android.di.PerActivity;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/code_confirmation/di/CodeConfirmationPresentationModule;", "", "Landroid/content/IntentFilter;", "provideCodeReceiverIntentFilter$code_confirmation_release", "()Landroid/content/IntentFilter;", "provideCodeReceiverIntentFilter", "Landroid/app/Activity;", "activity", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "provideSmsRetrieverClient$code_confirmation_release", "(Landroid/app/Activity;)Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "provideSmsRetrieverClient", "<init>", "()V", "Declarations", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CodeConfirmationPresentationModule {
    @NotNull
    public static final CodeConfirmationPresentationModule INSTANCE = new CodeConfirmationPresentationModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\b\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/code_confirmation/di/CodeConfirmationPresentationModule$Declarations;", "", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl;", "presenter", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "bindCodeConfirmationPresenter", "(Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl;)Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/code_confirmation/timer/RxTimerImpl;", "timer", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "bindRxTimer", "(Lcom/avito/android/code_confirmation/timer/RxTimerImpl;)Lcom/avito/android/code_confirmation/timer/RxTimer;", "Lcom/avito/android/code_confirmation/CodeReceiverImpl;", "receiver", "Lcom/avito/android/code_confirmation/CodeReceiver;", "bindCodeReceiver", "(Lcom/avito/android/code_confirmation/CodeReceiverImpl;)Lcom/avito/android/code_confirmation/CodeReceiver;", "Lcom/avito/android/code_confirmation/timer/TimerFormatter;", "Lcom/avito/android/util/Formatter;", "", "bindTimerFormatter", "(Lcom/avito/android/code_confirmation/timer/TimerFormatter;)Lcom/avito/android/util/Formatter;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        CodeConfirmationPresenter bindCodeConfirmationPresenter(@NotNull CodeConfirmationPresenterImpl codeConfirmationPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        CodeReceiver bindCodeReceiver(@NotNull CodeReceiverImpl codeReceiverImpl);

        @PerActivity
        @Binds
        @NotNull
        ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @PerActivity
        @Binds
        @NotNull
        RxTimer bindRxTimer(@NotNull RxTimerImpl rxTimerImpl);

        @Binds
        @NotNull
        @PerActivity
        Formatter<Long> bindTimerFormatter(@NotNull TimerFormatter timerFormatter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final IntentFilter provideCodeReceiverIntentFilter$code_confirmation_release() {
        return new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SmsRetrieverClient provideSmsRetrieverClient$code_confirmation_release(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SmsRetrieverClient client = SmsRetriever.getClient(activity);
        Intrinsics.checkNotNullExpressionValue(client, "SmsRetriever.getClient(activity)");
        return client;
    }
}
