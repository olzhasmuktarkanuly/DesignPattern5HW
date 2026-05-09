package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);
        mediator.subscribe("lore", this);
        mediator.subscribe("intel", this);
    }

    public void shareLore(String payload) {
        System.out.println("[" + name + " (Loremaster)] shares lore: " + payload);
        mediator.dispatch("lore", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[" + name + " (Loremaster)] received on '" + topic + "' from " + from.getName() + ": " + payload);
    }
}