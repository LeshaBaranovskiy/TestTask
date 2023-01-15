package com.example.empattesttask.domain.usecase.subscriber

class UseCaseSubscriberImpl<T>(
    override val next: (T) -> Unit,
    override val error: (Throwable) -> Unit = {},
    override val cancel: () -> Unit = {}
) : UseCaseSubscriber<T> {

    override fun onStart() {}

    override fun onError(throwable: Throwable) = error.invoke(throwable)

    override fun onComplete() {}
}
