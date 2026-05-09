package com.narxoz.rpg.guild;

public class Captain extends GuildMember {
    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
        mediator.subscribe("orders", this);
        mediator.subscribe("intel", this);
    }

    public void issueOrder(String payload) {
        System.out.println("[" + name + " (Captain)] issues order: " + payload);
        mediator.dispatch("orders", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[" + name + " (Captain)] received on '" + topic + "' from " + from.getName() + ": " + payload);
    }
}