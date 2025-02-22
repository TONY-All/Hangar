package io.papermc.hangar.db.modelold;


import io.papermc.hangar.db.customtypes.JSONB;
import io.papermc.hangar.model.Visible;
import io.papermc.hangar.model.Visitable;
import io.papermc.hangar.model.common.projects.Category;
import io.papermc.hangar.model.common.projects.Visibility;
import org.jdbi.v3.core.annotation.Unmappable;
import org.jdbi.v3.core.enums.EnumByOrdinal;

import java.time.OffsetDateTime;
import java.util.Collection;

public class ProjectsTable implements Visitable, Visible {

    private long id;
    private OffsetDateTime createdAt;
    private String name;
    private String slug;
    private String ownerName;
    private Long recommendedVersionId;
    private long ownerId;
    private long topicId;
    private long postId;
    private Category category;
    private String description;
    private Visibility visibility;
    private JSONB notes;
    private Collection<String> keywords;
    private String homepage;
    private String issues;
    private String source;
    private String support;
    private String licenseName;
    private String licenseUrl;
    private boolean forumSync;

    public ProjectsTable() { }

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


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public Long getRecommendedVersionId() {
        return recommendedVersionId;
    }

    public void setRecommendedVersionId(Long recommendedVersionId) {
        this.recommendedVersionId = recommendedVersionId;
    }


    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }


    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }


    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }


    @EnumByOrdinal
    public Category getCategory() {
        return category;
    }

    @EnumByOrdinal
    public void setCategory(Category category) {
        this.category = category;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @EnumByOrdinal
    public Visibility getVisibility() {
        return visibility;
    }

    @EnumByOrdinal
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }


    public JSONB getNotes() {
        return notes;
    }

    public void setNotes(JSONB notes) {
        this.notes = notes;
    }


    public Collection<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Collection<String> keywords) {
        this.keywords = keywords;
    }


    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }


    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }


    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }


    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }


    public boolean getForumSync() {
        return forumSync;
    }

    public void setForumSync(boolean forumSync) {
        this.forumSync = forumSync;
    }

    @Unmappable
    @Override
    public String getUrl() {
        return "/" + getOwnerName() + "/" + getSlug();
    }
}
