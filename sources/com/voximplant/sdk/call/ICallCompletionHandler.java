package com.voximplant.sdk.call;
public interface ICallCompletionHandler {
    void onComplete();

    void onFailure(CallException callException);
}
