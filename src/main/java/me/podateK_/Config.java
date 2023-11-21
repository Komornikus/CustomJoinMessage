package me.podateK_;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;

public class Config extends OkaeriConfig {
    @Comment("Made with love by podateK_")
    @Comment("")
    @Comment("")
    @Comment("")

    @Comment("Your custom join Message, default on, u can change it using /customjoinmessage joinmessage off ")
    @Comment("Or turn it back on using /customjoinmessage joinmessage on")
    @Comment("To get player name use {PLAYER}")
    public String joinMessage = "&aWitaj na serwerze \n Ta wiadomosc mozna zmienic w config.yml";

    @Comment("")
    @Comment("")
    @Comment("")

    @Comment("Your custom leave message, default on, u can turn it off using /customjoinmessage leavemessage off ")
    @Comment("Or turn it back on using /customjoinmessage leavemessage on")
    @Comment("To get player name use {PLAYER}")
    public String leaveMessage = "&aGracz {PLAYER} wlasnie wyszedl z serwera \n Ta wiadomosc mozna zmienic w config.yml";
}
