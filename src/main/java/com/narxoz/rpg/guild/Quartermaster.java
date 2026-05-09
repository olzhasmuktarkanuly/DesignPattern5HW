package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {
    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
        mediator.subscribe("supplies", this);
        mediator.subscribe("orders", this);
    }

    public void requestSupplies(String payload) {
        System.out.println("[" + name + " (Quartermaster)] announces: " + payload);
        mediator.dispatch("supplies", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[" + name + " (Quartermaster)] received on '" + topic + "' from " + from.getName() + ": " + payload);
    }
}