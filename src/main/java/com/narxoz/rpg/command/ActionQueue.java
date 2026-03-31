package com.narxoz.rpg.command;

import java.util.ArrayList;
import java.util.List;

public class ActionQueue {
    private List<ActionCommand> queue = new ArrayList<>();

    public void enqueue(ActionCommand cmd) {
        queue.add(cmd);
    }

    public void undoLast() {
        if (!queue.isEmpty()) {
            ActionCommand removed = queue.remove(queue.size() - 1);
            System.out.println("Undoing from queue: " + removed.getDescription());
        }
    }

    public void executeAll() {
        for (ActionCommand cmd : queue) {
            cmd.execute();
        }
        queue.clear();
    }

    public List<String> getCommandDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (ActionCommand cmd : queue) {
            descriptions.add(cmd.getDescription());
        }
        return descriptions;
    }
}