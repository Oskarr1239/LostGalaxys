package com.jatti.achievements.missions

import com.jatti.user.User

//TODO missions diary
/**
 * interface for missions
 * id - mission's id
 * name - mission's name
 * lore - mission's description
 * onGet(User) - what happens when user gets mission
 * onComplete(User) - what happens when user ends mission
 * @author Jatti
 * @version 1.1
 *
 */
interface Mission {

    val id: Int
    val name: String
    val lore: List<String>
    fun onGet(user: User)
    fun onComplete(user: User)

}