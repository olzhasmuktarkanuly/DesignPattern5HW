package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {
    private List<GuildMember> allMembers = new ArrayList<>();
    private Map<String, List<GuildMember>> topics = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        allMembers.add(member);
    }

    @Override
    public void subscribe(String topic, GuildMember member) {
        topics.putIfAbsent(topic, new ArrayList<>());
        topics.get(topic).add(member);
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        List<GuildMember> subscribers = topics.getOrDefault(topic, new ArrayList<>());
        for (GuildMember member : subscribers) {
            if (member != from) {
                member.receive(topic, from, payload);
            }
        }
    }
}