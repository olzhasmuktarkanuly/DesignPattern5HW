package com.narxoz.rpg.artifact;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Artifact> items = new ArrayList<>();

    public void addArtifact(Artifact artifact) {
        items.add(artifact);
    }

    public void accept(ArtifactVisitor visitor) {
        for (Artifact artifact : items) {
            artifact.accept(visitor);
        }
    }
}