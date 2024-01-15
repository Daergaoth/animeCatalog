package org.daergaoth.enums;

public enum Fields {
    ALTERNATIVE_TITLES("alternative_titles"),
    START_DATE("start_date"),
    END_DATE("end_date"),
    SYNOPSIS("synopsis"),
    MEAN("mean"),
    RANK("rank"),
    POPULARITY("popularity"),
    NUM_LIST_USERS("num_list_users"),
    NUM_SCORING_USERS("num_scoring_users"),
    NSFW("nsfw"),
    GENRES("genres"),
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at"),
    MEDIA_TYPE("media_type"),
    STATUS("status"),
    MY_LIST_STATUS("my_list_status"),
    NUM_EPISODES("num_episodes"),
    START_SEASON("start_season"),
    BROADCAST("broadcast"),
    SOURCE("source"),
    AVERAGE_EPISODE_DURATION("average_episode_duration"),
    RATING("rating"),
    STUDIOS("studios");



    private final String label;

    private Fields(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
