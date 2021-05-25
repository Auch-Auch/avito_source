package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.calls_shared.InAppCallsConfig;
import com.avito.android.in_app_calls.logging.AppLogStreamer;
import com.avito.android.in_app_calls.logging.CallLogWriter;
import com.avito.android.in_app_calls.logging.CallLogWriterImpl;
import com.avito.android.in_app_calls.logging.FullLogFormatter;
import com.avito.android.in_app_calls.logging.LogFormatter;
import com.avito.android.in_app_calls.logging.LogStreamer;
import com.avito.android.in_app_calls.service.callStartTasks.CallLoggingTask;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTasksContainer;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallStartupTasksModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallLoggingTask;", "loggingTasks", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "provideCallStartupTasks", "(Lcom/avito/android/Features;Lcom/avito/android/in_app_calls/service/callStartTasks/CallLoggingTask;)Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "Lcom/avito/android/in_app_calls/logging/LogStreamer;", "provideLogsStreamer", "()Lcom/avito/android/in_app_calls/logging/LogStreamer;", "<init>", "()V", "Declarations", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public class CallStartupTasksModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallStartupTasksModule$Declarations;", "", "Lcom/avito/android/in_app_calls/logging/CallLogWriterImpl;", "impl", "Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "bindCallLogWriter", "(Lcom/avito/android/in_app_calls/logging/CallLogWriterImpl;)Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "Lcom/avito/android/in_app_calls/logging/FullLogFormatter;", "Lcom/avito/android/in_app_calls/logging/LogFormatter;", "bindFullLogFormatter", "(Lcom/avito/android/in_app_calls/logging/FullLogFormatter;)Lcom/avito/android/in_app_calls/logging/LogFormatter;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        CallLogWriter bindCallLogWriter(@NotNull CallLogWriterImpl callLogWriterImpl);

        @Binds
        @NotNull
        LogFormatter bindFullLogFormatter(@NotNull FullLogFormatter fullLogFormatter);
    }

    @Provides
    @NotNull
    public final CallStartTask provideCallStartupTasks(@NotNull Features features, @NotNull CallLoggingTask callLoggingTask) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(callLoggingTask, "loggingTasks");
        CallStartTasksContainer callStartTasksContainer = new CallStartTasksContainer();
        if (features.getCallsSendLogs().invoke().booleanValue()) {
            callStartTasksContainer.register(callLoggingTask);
        }
        return callStartTasksContainer;
    }

    @Provides
    @NotNull
    public final LogStreamer provideLogsStreamer() {
        return new AppLogStreamer(InAppCallsConfig.INSTANCE.getLOG_TAG_WHITE_LIST());
    }
}
