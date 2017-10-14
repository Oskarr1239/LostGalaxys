package com.jatti.achievements.missions

import com.jatti.user.User

//TODO missions diary
interface Mission {

    val id: Int
    val name: String
    fun onGet(user: User)
    fun onComplete(user: User)

}