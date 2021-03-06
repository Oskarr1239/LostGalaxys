package com.jatti.achievements.missions

import com.jatti.achievements.Achievement
import com.jatti.achievements.AchievementDifficulty
import com.jatti.user.User
import org.bukkit.ChatColor
import java.util.*

/**
 * Mission to test if missions are working
 * @author Jatti
 * @version 1.1
 */
class TestMission : Mission {


    override val name: String = "Pierwsza"
    override val id: Int = 1
    override val lore: List<String> = Arrays.asList("BABA", "SIALA")

    override fun onComplete(user: User) {

        user.sendMessage("" + ChatColor.GOLD + "Brawo skonczyles testowa misje!")
        user.addLevels(1)
        val ach: Achievement = Achievement.builder(1).withName("Testowe Osiagniecie!").withDesc(Arrays.asList("Fajne osiagniecie", "Ale ono fajne")).withDifficulty(AchievementDifficulty.HARD).build()
        user.addAchievement(ach)
    }

    override fun onGet(user: User) {

        user.sendMessage("" + ChatColor.GOLD + "Dostales nowa misje!")

    }
}