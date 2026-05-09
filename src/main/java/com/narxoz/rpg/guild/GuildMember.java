package com.narxoz.rpg.guild;

public abstract class GuildMember {
    protected String name;
    protected GuildMediator mediator;

    public GuildMember(String name, GuildMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.register(this);
    }

    public String getName() {
        return name;
    }

    public abstract void receive(String topic, GuildMember from, String payload);
}