package com.narxoz.rpg.quest;

public class Quest {
    private String name;
    private String description;
    private QuestPriority priority;
    private int reward;

    public Quest(String name, String description, QuestPriority priority, int reward) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.reward = reward;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public QuestPriority getPriority() { return priority; }
    public int getReward() { return reward; }

    @Override
    public String toString() {
        return "[" + priority + "] " + name + " (" + reward + "G) - " + description;
    }
}