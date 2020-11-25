package com.lessons.productlist

import org.koin.dsl.module

val repositoryModule = module {
    single { PostRepository(get()) }
}