package com.narxoz.rpg.guild;

public class Healer extends GuildMember {
    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
        mediator.subscribe("medical", this);
        mediator.subscribe("orders", this);
        mediator.subscribe("supplies", this);
    }

    public void requestMedicalHelp(String payload) {
        System.out.println("[" + name + " (Healer)] requests: " + payload);
        mediator.dispatch("medical", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[" + name + " (Healer)] received on '" + topic + "' from " + from.getName() + ": " + payload);
    }
}