package io.papermc.hangar.db.modelold;


import io.papermc.hangar.model.common.Color;
import org.jdbi.v3.core.enums.EnumByOrdinal;

import java.time.OffsetDateTime;

public class ProjectChannelsTable {

    private long id;
    private OffsetDateTime createdAt;
    private String name;
    private Color color;
    private long projectId;
    private boolean nonReviewed;

    public ProjectChannelsTable() {
        //
    }

    public ProjectChannelsTable(String name, Color color, long projectId, boolean nonReviewed) {
        this.name = name;
        this.color = color;
        this.projectId = projectId;
        this.nonReviewed = nonReviewed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @EnumByOrdinal
    public Color getColor() {
        return color;
    }

    @EnumByOrdinal
    public void setColor(Color color) {
        this.color = color;
    }


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    public boolean isNonReviewed() {
        return nonReviewed;
    }

    public void setNonReviewed(boolean isNonReviewed) {
        this.nonReviewed = isNonReviewed;
    }

}
