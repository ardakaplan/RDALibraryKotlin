package com.ardakaplan.rdalibrary.data

/**
 * Created by Arda Kaplan at 11.04.2022 - 21:36
 *
 * ardakaplan101@gmail.com
 */
interface RDAMapper<I, O> {
    fun map(input: I): O
}