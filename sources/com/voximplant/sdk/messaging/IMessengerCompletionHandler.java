package com.voximplant.sdk.messaging;
public interface IMessengerCompletionHandler<T> {
    void onError(IErrorEvent iErrorEvent);

    void onSuccess(T t);
}
