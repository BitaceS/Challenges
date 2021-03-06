package world.bentobox.challenges.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

import world.bentobox.challenges.ChallengesAddon;


/**
 * This is Simple World Save event listener. On each world save, this method
 * asks challenge manager to save its data.
 */
public class SaveListener implements Listener
{
    public SaveListener(ChallengesAddon addon) {
        this.addon = addon;
    }


    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onWorldSave(WorldSaveEvent e)
    {
        if (!this.addon.getChallengesManager().getAllChallenges(e.getWorld()).isEmpty())
        {
            this.addon.getChallengesManager().save();
        }
    }


    // ---------------------------------------------------------------------
    // Section: Variables
    // ---------------------------------------------------------------------


    private ChallengesAddon addon;
}
