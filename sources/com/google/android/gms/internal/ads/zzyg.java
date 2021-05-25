package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
public interface zzyg extends IInterface {
    float getAspectRatio() throws RemoteException;

    float getCurrentTime() throws RemoteException;

    float getDuration() throws RemoteException;

    int getPlaybackState() throws RemoteException;

    boolean isClickToExpandEnabled() throws RemoteException;

    boolean isCustomControlsEnabled() throws RemoteException;

    boolean isMuted() throws RemoteException;

    void mute(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void stop() throws RemoteException;

    void zza(zzyl zzyl) throws RemoteException;

    zzyl zzqj() throws RemoteException;
}
