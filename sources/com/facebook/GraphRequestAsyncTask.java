package com.facebook;

import a2.b.a.a.a;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    public static final String d = GraphRequestAsyncTask.class.getCanonicalName();
    public final HttpURLConnection a;
    public final GraphRequestBatch b;
    public Exception c;

    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch(graphRequestArr));
    }

    public final Exception getException() {
        return this.c;
    }

    public final GraphRequestBatch getRequests() {
        return this.b;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        if (FacebookSdk.isDebugEnabled()) {
            Utility.logd(d, String.format("execute async task: %s", this));
        }
        if (this.b.a == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.b.a = handler;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder Q = a.Q("{RequestAsyncTask: ", " connection: ");
        Q.append(this.a);
        Q.append(", requests: ");
        Q.append(this.b);
        Q.append("}");
        return Q.toString();
    }

    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
    }

    public List<GraphResponse> doInBackground(Void... voidArr) {
        try {
            HttpURLConnection httpURLConnection = this.a;
            if (httpURLConnection == null) {
                return this.b.executeAndWait();
            }
            return GraphRequest.executeConnectionAndWait(httpURLConnection, this.b);
        } catch (Exception e) {
            this.c = e;
            return null;
        }
    }

    public void onPostExecute(List<GraphResponse> list) {
        super.onPostExecute((GraphRequestAsyncTask) list);
        Exception exc = this.c;
        if (exc != null) {
            Utility.logd(d, String.format("onPostExecute: exception encountered during request: %s", exc.getMessage()));
        }
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch(graphRequestArr));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.b = graphRequestBatch;
        this.a = httpURLConnection;
    }
}
