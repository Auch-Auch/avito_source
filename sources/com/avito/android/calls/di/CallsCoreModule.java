package com.avito.android.calls.di;

import com.avito.android.calls.CallClientConnection;
import com.avito.android.calls.CallClientPushTokenRegistration;
import com.avito.android.calls.CallClientSession;
import com.avito.android.calls.voximplant.rx.VoxCallClientConnection;
import com.avito.android.calls.voximplant.rx.VoxCallClientPushTokenRegistration;
import com.avito.android.calls.voximplant.rx.VoxCallClientSession;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/calls/di/CallsCoreModule;", "", "<init>", "()V", "Declarations", "calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public class CallsCoreModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/calls/di/CallsCoreModule$Declarations;", "", "Lcom/avito/android/calls/voximplant/rx/VoxCallClientConnection;", "impl", "Lcom/avito/android/calls/CallClientConnection;", "bindCallClientConnection", "(Lcom/avito/android/calls/voximplant/rx/VoxCallClientConnection;)Lcom/avito/android/calls/CallClientConnection;", "Lcom/avito/android/calls/voximplant/rx/VoxCallClientSession;", "Lcom/avito/android/calls/CallClientSession;", "bindCallClientSession", "(Lcom/avito/android/calls/voximplant/rx/VoxCallClientSession;)Lcom/avito/android/calls/CallClientSession;", "Lcom/avito/android/calls/voximplant/rx/VoxCallClientPushTokenRegistration;", "Lcom/avito/android/calls/CallClientPushTokenRegistration;", "bindCallClientPushTokenRegistration", "(Lcom/avito/android/calls/voximplant/rx/VoxCallClientPushTokenRegistration;)Lcom/avito/android/calls/CallClientPushTokenRegistration;", "calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        CallClientConnection bindCallClientConnection(@NotNull VoxCallClientConnection voxCallClientConnection);

        @Singleton
        @Binds
        @NotNull
        CallClientPushTokenRegistration bindCallClientPushTokenRegistration(@NotNull VoxCallClientPushTokenRegistration voxCallClientPushTokenRegistration);

        @Singleton
        @Binds
        @NotNull
        CallClientSession bindCallClientSession(@NotNull VoxCallClientSession voxCallClientSession);
    }
}
