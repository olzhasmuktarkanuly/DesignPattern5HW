package com.narxoz.rpg.guild;

public class Scout extends GuildMember {
    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
        mediator.subscribe("intel", this);
        mediator.subscribe("orders", this);
    }

    public void reportIntel(String payload) {
        System.out.println("[" + name + " (Scout)] reports: " + payload);
        mediator.dispatch("intel", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[" + name + " (Scout)] received on '" + topic + "' from " + from.getName() + ": " + payload);
    }
}