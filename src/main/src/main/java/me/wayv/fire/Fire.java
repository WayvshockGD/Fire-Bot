package me.wayv.fire;

import me.wayv.fire.config.Config;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Fire extends ListenerAdapter
{

    public static void main(String[] args) throws LoginException
    {

        JDABuilder bot = JDABuilder.createDefault(Config.token);

        bot.setAutoReconnect(true);

        bot.setActivity(Activity.watching(Config.Status));

        bot.setStatus(OnlineStatus.ONLINE);

        bot.addEventListeners(new Fire());

        bot.build();

    }

    public void onReady(ReadyEvent event)
    {
        System.out.println("Ready");
    }
}
