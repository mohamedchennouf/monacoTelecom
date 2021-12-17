package com.monaco.telecom.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A class defining a monaco service
 */
@Schema(title = "MonacoService", description = "Monaco service description")
public class MonacoServiceModel {

    /**
     * the service id
     */
    @Schema(hidden = true)
    private Integer id;

    /**
     * the service tag
     */
    @Schema(title = "tag", example="tag1", required = true)
    private String tag;

    /**
     * the service action
     */
    @Schema(title = "action", example="ACTIVE", required = true)
    private String action;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString(){
        return "{tag:" + tag + " action:" + action +"}";
    }
}
