package me.wayv.fire;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Bot extends ListenerAdapter {


    public static void main(String[] args) throws LoginException {
        try (InputStream input = Bot.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Cannot find config.properties!");
                return;
            }

            prop.load(input);


            JDABuilder builder = JDABuilder.createDefault(prop.getProperty("token"));
            builder.addEventListeners(new Bot());
            builder.setActivity(Activity.playing("help"));
            builder.setStatus(OnlineStatus.ONLINE);
            builder.setAutoReconnect(true);

            /*builder*/
            builder.build();


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void onReady(ReadyEvent event) {
        System.out.println("Logged in as " + event.getJDA().getSelfUser().getAsTag() + " on " + event.getJDA().getShardInfo().getShardTotal() + "shards ");
    }
}
