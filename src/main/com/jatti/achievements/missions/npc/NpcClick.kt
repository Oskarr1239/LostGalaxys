package com.jatti.achievements.missions.npc

import com.jatti.achievements.missions.Mission
import com.jatti.achievements.missions.TestMission
import com.jatti.user.User
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent

/**
 * Listener when player clicks NPC
 * @author Jatti
 * @version 1.1
 */
class NpcClick : Listener {

    companion object {
        /**
         * List of all missions that you can get from NPC
         * @return ArrayList<Mission>
         */
        @JvmStatic
        fun getMissions(): ArrayList<Mission> {
            val missions: ArrayList<Mission> = ArrayList()
            missions.add(TestMission())
            return missions
        }
    }

    @EventHandler
    fun onClick(evt: PlayerInteractAtEntityEvent) {

        if (evt.rightClicked.type == EntityType.VILLAGER) {

            for (n in NpcUtils.getNpcs()) {

                if (n.entityId == evt.rightClicked.entityId) {

                    val u: User = User.get(evt.player.name)

                    for (mission in getMissions()) {

                        if (n.id == mission.id) {

                            if (u.missions!!.contains(mission.id)) {

                                mission.onComplete(u)

                            } else {

                                mission.onGet(u)

                            }

                        }

                    }

                }

            }

        }
    }
}