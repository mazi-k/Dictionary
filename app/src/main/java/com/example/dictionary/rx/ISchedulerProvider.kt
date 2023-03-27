package com.example.dictionary.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}