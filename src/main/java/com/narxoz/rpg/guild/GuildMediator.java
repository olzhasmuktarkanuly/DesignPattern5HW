package com.narxoz.rpg.guild;

public interface GuildMediator {
    void register(GuildMember member);
    void subscribe(String topic, GuildMember member);
    void dispatch(String topic, GuildMember from, String payload);
}