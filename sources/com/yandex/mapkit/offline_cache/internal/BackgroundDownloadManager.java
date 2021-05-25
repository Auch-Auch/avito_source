package com.yandex.mapkit.offline_cache.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.JobConfig;
import com.evernote.android.job.patched.internal.JobCreator;
import com.evernote.android.job.patched.internal.JobManager;
import com.evernote.android.job.patched.internal.JobRequest;
import com.yandex.mapkit.offline_cache.DownloadNotificationsListener;
import com.yandex.mapkit.offline_cache.OfflineCacheManager;
import com.yandex.runtime.Runtime;
public class BackgroundDownloadManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static BackgroundDownloadManager instance;
    private int activeDownloads = 0;
    private boolean allowCellular = false;
    private DownloadNotificationsListener listener;

    private BackgroundDownloadManager(final Runnable runnable, Context context, DownloadNotificationsListener downloadNotificationsListener) {
        this.listener = downloadNotificationsListener;
        JobConfig.setForceAllowApi14(true);
        JobManager.create(context).addJobCreator(new JobCreator() { // from class: com.yandex.mapkit.offline_cache.internal.BackgroundDownloadManager.1
            @Override // com.evernote.android.job.patched.internal.JobCreator
            public Job create(String str) {
                if (str == BackgroundDownloadJob.TAG) {
                    return new BackgroundDownloadJob(runnable);
                }
                return null;
            }
        });
    }

    private void activateNotifications(@NonNull OfflineCacheManager offlineCacheManager) {
        DownloadNotificationsListener downloadNotificationsListener = this.listener;
        if (downloadNotificationsListener != null) {
            downloadNotificationsListener.startNotifications(offlineCacheManager);
        }
    }

    private void decrementActiveDownloads() {
        int i = this.activeDownloads - 1;
        this.activeDownloads = i;
        if (i == 0) {
            disableBackgroundDownloading();
        }
    }

    private void disableBackgroundDownloading() {
        JobManager.instance().cancelAllForTag(BackgroundDownloadJob.TAG);
    }

    private void enableBackgroundDownloading() {
        new JobRequest.Builder(BackgroundDownloadJob.TAG).setExecutionWindow(1, 3074457345618258602L).setUpdateCurrent(true).setRequiredNetworkType(this.allowCellular ? JobRequest.NetworkType.CONNECTED : JobRequest.NetworkType.UNMETERED).setRequirementsEnforced(true).build().schedule();
    }

    public static BackgroundDownloadManager getInstance() {
        if (instance == null) {
            instance = new BackgroundDownloadManager(null, Runtime.getApplicationContext(), null);
        }
        return instance;
    }

    private void incrementActiveDownloads() {
        int i = this.activeDownloads + 1;
        this.activeDownloads = i;
        if (i == 1) {
            enableBackgroundDownloading();
        }
    }

    public static void initialize(@Nullable Runnable runnable, @NonNull Context context, @Nullable DownloadNotificationsListener downloadNotificationsListener) {
        if (instance == null) {
            instance = new BackgroundDownloadManager(runnable, context, downloadNotificationsListener);
        }
    }

    private void updateBackgroundDownloading(boolean z) {
        this.allowCellular = z;
        if (!JobManager.instance().getAllJobRequestsForTag(BackgroundDownloadJob.TAG).isEmpty() || !JobManager.instance().getAllJobsForTag(BackgroundDownloadJob.TAG).isEmpty()) {
            enableBackgroundDownloading();
        }
    }

    public void resetListener(DownloadNotificationsListener downloadNotificationsListener) {
        this.listener = downloadNotificationsListener;
    }
}
